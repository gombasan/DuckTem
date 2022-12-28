package com.ducktem.web.dao;

import com.ducktem.web.entity.SuperCategory;
import com.ducktem.web.entity.Category;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

    List<SuperCategory> findAll();
    List<Category> findSubCategoryAll(int superCategoryId);
    
}
