package com.ducktem.web.service;

import com.ducktem.web.dao.ImgDao;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class ImgServiceImpl implements ImgService{

    @Autowired
    private ImgDao imgDao;

    @Override
    public void upload(MultipartFile file,Long productId) {
        ProductImg productImg = new ProductImg();
        productImg.setProductId(productId);
        productImg.setName(fileSave(file));


        imgDao.save(productImg);
    }
    static String fileSave(MultipartFile file) {

        String productImgPath = System.getProperty("user.dir") + "/src/main/resources/static/productimgs";
        UUID uuid = UUID.randomUUID();
        String productImgName = uuid + "_" + file.getOriginalFilename();
        File productImgFile = new File(productImgPath, productImgName);
        try{
            file.transferTo(productImgFile);
        }catch (Exception e){

        }
        return productImgName;
    }
}
