package com.ducktem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	// 사용하지 않으면 빼도 좋을 것 같아요!
	// @Autowired
	// private MemberService memberService;

	/* 메인 페이지*/
	@GetMapping("/")
	public String index(Model model, HttpSession session) { // session도 필요 한가요?
		List<ProductPreview> preview = productService.preview();
		model.addAttribute("preview", preview);
		return "index";
	}
}
