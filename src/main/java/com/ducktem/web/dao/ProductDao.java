package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductDao {


    //상품 등록하기
    void save(Product product);

    // 전체 상품 리스트 가져오기
    List<Product> findAll();

    // 유저 상품 리스트 가져오기
    List<Product> findMemberProductList(String memberName);

    // 상품 디테일 페이지
    Product find();

    Long findId();
}
