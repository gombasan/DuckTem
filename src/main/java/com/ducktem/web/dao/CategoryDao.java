package com.ducktem.web.dao;

import com.ducktem.web.entity.Category;
import com.ducktem.web.entity.SubCategory;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

    List<Category> findAll();

    List<SubCategory> findSubCategoryAll();
    
   
    


}
