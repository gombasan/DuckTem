package com.ducktem.web.service;


import com.ducktem.web.entity.Category;
import com.ducktem.web.entity.SubCategory;


import java.util.List;


public interface CategoryService {

    List<Category> getList();

    List<SubCategory> getSubList();

	


}
