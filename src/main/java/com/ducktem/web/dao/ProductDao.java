package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductDao {

    /* 상품 등록하기 */
    Long save(Product product);

    /* 전체 상품 리스트 찾기 */
    List<Product> findAll();

    /* 상품 찾기 */
    Product findById(Long productId);
    /* 상품 찾기 */
    List<Product> findByMemberId(String regMemberId);

    void updateHit(Long productId);


    void update(Product product);


}
