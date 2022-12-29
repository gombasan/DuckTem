package com.ducktem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.ProductService;
import com.ducktem.web.service.SearchService;

@RequestMapping("")
@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		
		List<ProductPreview> searchResult = searchService.getResult(keyword);
		model.addAttribute("searchResult",searchResult);
		System.out.println(searchResult);
		
		int resultCount = searchService.getResultCount(keyword);
		model.addAttribute("resultCount",resultCount);
		model.addAttribute("keyword",keyword);
		
				
		return "list-search";
	}
	
//	@PostMapping("/")
//	public String search(@RequestParam("keyword") String keyword) {
//		System.out.println(keyword);
//		
//		return "list-search";
//	}
//	
//	@PostMapping("/")
//	public String search(@RequestParam("keyword") String keyword) {
//		
//		List<ProductPreview> result = searchService.getResult(keyword);
//		System.out.println(keyword);
//		System.out.println(result);
//		
//		return "search?q="+keyword;
//	}
//
}
