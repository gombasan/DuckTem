package com.ducktem.web.service;

import com.ducktem.web.dao.ImgDao;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductImg;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class ImgServiceImpl implements ImgService{

    @Autowired
    private ImgDao imgDao;




    /* 상품 이미지 등록 서비스*/
    @Override
    public void upload(MultipartFile[] files,Long productId,HttpServletRequest request) {
        MultipartFile thumbNail = files[3];

        for(int i=0; i<files.length; i++) {
            ProductImg productImg = new ProductImg();
            if(files[i].equals(thumbNail)) {
                productImg.setThumbnail((byte) 1);
            }
            String productName = fileSave(files[i], request);
            if(productName != null){
                productImg.setName(productName);
                imgDao.save(productImg);
            }
        }

        for(MultipartFile file : files) {
            ProductImg productImg = new ProductImg();
            String test = fileSave(file,request);
            System.out.println(test);
            productImg.setProductId(productId);
            /* 상품 이미지 파일 이름에 UUID 삽입 후 저장 */
            String productName = fileSave(file, request);
            if(productName != null) {
                productImg.setName(productName);
                imgDao.save(productImg);
            }
        }
    }


    /*  */
    @Override
    public List<ProductImg> getList(Long productId) {
        return imgDao.findByProductId(productId);
    }


    /* 파일을 받아 UUID 삽입과 파일 저장을 위한 함수 */
    static String fileSave(MultipartFile file,HttpServletRequest request) {
        String productImgPath = request.getServletContext().getRealPath("/productimgs")+File.separator;


        UUID uuid = UUID.randomUUID();

        if(file.getOriginalFilename().equals("")) {
            return null;
        }

        String productImgName = uuid + "_" + file.getOriginalFilename();
        File productImgFile = new File(productImgPath, productImgName);
        try {
            file.transferTo(productImgFile);
        } catch (Exception e) {

        }
        return "/productimgs/" + productImgName;
    }
}
