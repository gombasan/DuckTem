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

    /* 내 상품 리스트 조회 서비스 (프리뷰로 변경 예정)*/
    List<ProductPreview> myList(String memberId);

    /* 전체 상품 리스트 조회 서비스 */
    List<Product> list();

    /* 상품 아이디 조회 서비스 */
    Long getProductId();

    /* 상품 리스트 조회 서비스 */
	List<ProductPreview> preview();

    List<ProductPreview> preview(int page);

    void upHit(HttpServletResponse response,String hitCookie, Long productId);
}
