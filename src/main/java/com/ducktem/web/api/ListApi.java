package com.ducktem.web.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.entity.Category;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.CategoryService;
import com.ducktem.web.service.ProductService;

@RestController
@RequestMapping("/api")
public class ListApi {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

//	@GetMapping("lists")
//	public Map<String, Object> List(@RequestParam("c") Integer superCategoryId,
//			@RequestParam("sub") Integer subCategoryId) {
//
//		Map<String, Object> listDto = new HashMap<>();
//
//		List<Category> categoryList = categoryService.getSubList(superCategoryId);
//		listDto.put("categoryList", categoryList);
//
//		if (subCategoryId != null) {
//			List<Product> ProductList = productService.list(subCategoryId, superCategoryId);
//			listDto.put("ProductList", ProductList);
//		}
//		
//		
//		
//
//		return listDto;
//	}
	
	
	
	@GetMapping("lists")
	public List<Category> categoryList(@RequestParam("c") Integer superCategoryId) {

		List<Category> categoryList = categoryService.getSubList(superCategoryId);
		
		return categoryList;
	}

};
