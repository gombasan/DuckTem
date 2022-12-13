package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductDao {

	List<ProductPreview> getPreviewAll();



    /* 상품 등록하기 */
    void save(Product product);

    /* 전체 상품 리스트 찾기 */
    List<Product> findAll();

    /* 회원이름으로 상품 리스트 찾기(userId로 변경 예정) */
    List<Product> findMemberProductList(String memberName);

    /* 상품 찾기 (미구현) */
    Product find();

    /* 상품 테이블 id 찾기 */
    Long findId();
}
