package com.ducktem.web.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.entity.Category;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.CategoryService;
import com.ducktem.web.service.ProductPreviewService;
import com.ducktem.web.service.ProductService;

@RestController
@RequestMapping("/api")
public class ListApi {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
    private ProductPreviewService productPreviewService;


	

	
	
	
	
	
	
	@GetMapping("lists")
	public Map<String, Object> ListByCategory(@RequestParam(name="super") Integer superCategoryId, @RequestParam(defaultValue="-1", name="cate") Integer categoryId) {

		Map<String, Object> listByCategoryDto = new HashMap<>();

		
		List<Category> categoryList = categoryService.getSubList(superCategoryId);
		List<ProductPreview> preview = productPreviewService.previewByCategory(superCategoryId, categoryId);
		
		listByCategoryDto.put("categoryList", categoryList);
		listByCategoryDto.put("productPreviewByCategory", preview);
		

		return listByCategoryDto;
	}

};
