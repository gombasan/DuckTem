package com.ducktem.web.service;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    /* 상품 등록 서비스 */
    void upload(String memberName, MultipartFile file, Product product) throws Exception;

    /* 하나의 상품 조회 서비스*/
    Product get();

    /* 내 상품 리스트 조회 서비스 (프리뷰로 변경 예정)*/
    List<Product> myList(String memberName);

    /* 전체 상품 리스트 조회 서비스 */
    List<Product> list();

    /* 상품 아이디 조회 서비스 */
    Long getProductId();

    /* 상품 리스트 조회 서비스 */
	List<ProductPreview> preview();

}
