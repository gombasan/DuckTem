package com.ducktem.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.entity.Category;
import com.ducktem.web.service.CategoryService;

@RestController
@RequestMapping("/api")
public class ListApi {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("lists")
	public List<Category> categoryList(@RequestParam("c") int superCategoryId){
		
		
		List<Category> categoryList = categoryService.getSubList(superCategoryId);
		
		return categoryList;
	}

};
