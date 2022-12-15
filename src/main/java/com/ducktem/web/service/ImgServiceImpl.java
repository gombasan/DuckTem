package com.ducktem.web.service;

import com.ducktem.web.dao.ImgDao;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class ImgServiceImpl implements ImgService{

    @Autowired
    private ImgDao imgDao;


    /* 상품 이미지 등록 서비스*/
    @Override
    public void upload(MultipartFile file,Long productId) {
        ProductImg productImg = new ProductImg();
        productImg.setProductId(productId);
        /* 상품 이미지 파일 이름에 UUID 삽입 후 저장 */
        productImg.setName(fileSave(file));


        imgDao.save(productImg);
    }


    /*  */
    @Override
    public List<ProductImg> getList(Long productId) {

        return imgDao.findByProductId(productId);
    }


    /* 파일을 받아 UUID 삽입과 파일 저장을 위한 함수 */
    static String fileSave(MultipartFile file) {

        String productImgPath = System.getProperty("user.dir") + "/src/main/resources/static/productimgs";
        UUID uuid = UUID.randomUUID();
        String productImgName = uuid + "_" + file.getOriginalFilename();
        File productImgFile = new File(productImgPath, productImgName);
        try{
            file.transferTo(productImgFile);
        }catch (Exception e){

        }
        return "/productimgs/" + productImgName;
    }
}
