package com.ducktem.web.service;


import com.ducktem.web.entity.SuperCategory;
import com.ducktem.web.entity.Category;


import java.util.List;



public interface CategoryService {

	//상품 목록에서 카테고리 대분류를 얻을 때 사용
    List<SuperCategory> getList();
    
    //상품목록에서 카테고리 소분류를 얻을 때 사용
    List<Category> getSubList(int superCategoryId);
    
    //상품 디테일 에서 카테고리 이름을 얻을 때 사용
	Category getCategoryName(Long productId);
	


}
