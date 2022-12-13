package com.ducktem.web.service;


import com.ducktem.web.entity.ProductImg;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
    void upload(MultipartFile file, Long productId);



}
