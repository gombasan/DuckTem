package com.ducktem.web.service;


import com.ducktem.web.entity.ProductImg;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService {

    /* 상품아이디로 파일 등록하기 */
    void upload(MultipartFile file, Long productId);



}
