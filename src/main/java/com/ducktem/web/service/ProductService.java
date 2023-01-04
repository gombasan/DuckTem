package com.ducktem.web.service;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    /* 상품 등록 서비스 */
    void upload(String memberNickName, Product product);

    /* 하나의 상품 조회 서비스*/
    Product get(Long productId);

    /* 전체 상품 리스트 조회 서비스 */
    List<Product> list();


    void upHit(HttpServletResponse response,String hitCookie, Long productId);

    void update(Product product);

    void stateChange(Long productId, int salesStatusId);

	List<Product> getByMemberId(String memberId);
}
