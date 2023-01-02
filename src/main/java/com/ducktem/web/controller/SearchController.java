package com.ducktem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ducktem.web.service.ProductService;

@RequestMapping("")
@Controller
public class SearchController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/search")
	public String searchResult() {
		
		String result = "";
		
		return "list-search"+result;
//		return "list-search?result="+result;
	}

}
