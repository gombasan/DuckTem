package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Autowired
    private MemberDao memberDao;


    @Override
    public void upload(String memberName, MultipartFile file, Product product) throws Exception {

        String productImgPath = System.getProperty("user.dir") + "/src/main/resources/static/productimgs";

        UUID uuid = UUID.randomUUID();

        String productImgName = uuid + "_" + file.getOriginalFilename();

        File productImgFile = new File(productImgPath, productImgName);

        file.transferTo(productImgFile);
        product.setImg("productimgs/" + productImgName);


        Member member = memberDao.findByName(memberName);


        LocalDate now = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        product.setRegDate(now);

        productDao.upload(member.getName() ,product);
    }

    @Override
    public Product get() {

        return null;
    }

    @Override
    public List<Product> myList(String memberName) {
        Member member = memberDao.findByName(memberName);
        return productDao.findMemberProductList(member.getName());
    }

    @Override
    public List<Product> list() {
        return productDao.findAll();
    }
}