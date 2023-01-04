package com.ducktem.web.service;


import com.ducktem.web.entity.ProductImg;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImgService {

    /* 상품아이디로 파일 등록하기 */ 
    void upload(MultipartFile thumbNail,MultipartFile[] file, Long productId, HttpServletRequest request);

    List<ProductImg> getList(Long productId);

}
