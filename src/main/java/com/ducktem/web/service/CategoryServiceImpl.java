package com.ducktem.web.service;

import com.ducktem.web.dao.CategoryDao;
import com.ducktem.web.entity.SuperCategory;
import com.ducktem.web.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
    private CategoryDao categoryDao;

    @Override
    public List<SuperCategory> getList() {

    	return categoryDao.findAll();
    }

	@Override
	public List<Category> getSubList(int superCategoryId) {
	
		return categoryDao.findSubCategoryAll(superCategoryId);
	}

	

    
    
}
