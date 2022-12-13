package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Member member = memberDao.findByName(memberName);

        /* product 멤버 아이디 사용.*/
        product.setRegMemberId(member.getUserId());

        productDao.save(product);
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

    @Override
    public Long getProductId() {
        return productDao.findId();
    }


}
