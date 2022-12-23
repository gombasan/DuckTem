package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductDao {

	List<ProductPreview> getPreviewAll();

    /* 상품 등록하기 */
    Long save(Product product);

    /* 전체 상품 리스트 찾기 */
    List<Product> findAll();

    /* 회원이름으로 상품 리스트 찾기(userId로 변경 예정) */
    List<ProductPreview> findMemberProductList(String memberId);

    /* 상품 찾기 */
    Product findById(Long productId);

    /* 상품 테이블 id 찾기 */
    Long findId();

    void plusHit(Long productId);

    List<ProductPreview> getPreviewList(int size, int offset);
}
