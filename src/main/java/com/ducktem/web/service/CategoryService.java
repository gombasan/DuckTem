package com.ducktem.web.service;


import com.ducktem.web.entity.SuperCategory;
import com.ducktem.web.entity.Category;


import java.util.List;


public interface CategoryService {

    List<SuperCategory> getList();
    List<Category> getSubList(int superCategoryId);

	


}
