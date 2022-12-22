package com.ducktem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.ducktem.web.entity.Product;
import com.ducktem.web.service.ImgService;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.WishListService;

import jakarta.servlet.http.HttpSession;

public class WishListController {

    @Autowired
	private WishListService wishListService;
	
    @Autowired
    private ImgService imgService;

    @Autowired
    private MemberService memberService;

	
//	찜 저장
	@GetMapping("/")
	public String checkWishList(HttpSession session, Product product) {
        String userId = (String)session.getAttribute("userId");
		
        wishListService.checkWish(userId, productId);
        
        return "";
        
	}
    
    
    
//	멤버	아이디로 불러오기
	
	
	
	
//	프로덕트 아이디로 불러오기
	
	
	
}
