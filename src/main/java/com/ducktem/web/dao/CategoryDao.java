package com.ducktem.web.dao;

import com.ducktem.web.entity.SuperCategory;
import com.ducktem.web.entity.Category;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryDao {
	
	//상품 목록에서 카테고리 대분류를 얻을 때 사용
    List<SuperCategory> findAll();
    
    //상품목록에서 카테고리 소분류를 얻을 때 사용
    List<Category> findSubCategoryAll(int superCategoryId);
    
    //상품 디테일 에서 카테고리 이름을 얻을 때 사용
    Category findCategoryName(Long productId);
	
    
}
