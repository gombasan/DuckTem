package com.ducktem.web.dao;

import com.ducktem.web.entity.Product;

import java.util.List;

public interface ProductDao {

    //상품 등록하기
    void upload(String memberId ,Product product);

    // 전체 상품 리스트 가져오기
    List<Product> findAll();

    // 유저 상품 리스트 가져오기
    List<Product> findMemberProductList(String memberName);

    // 상품 디테일 페이지
    Product find();

}
