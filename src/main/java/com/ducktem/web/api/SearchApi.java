package com.ducktem.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.service.ProductService;

@RestController
public class SearchApi {

	@Autowired
	private ProductService productService;
	
	
}
