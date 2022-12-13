package com.ducktem.web.service;

import com.ducktem.web.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    // 상품 등록
    void upload(String memberName, MultipartFile file, Product product) throws Exception;

    //상품 디테일 출력
    Product get();

    //내 상품 리스트 출력
    List<Product> myList(String memberName);

    List<Product> list();

    Long getProductId();

}
