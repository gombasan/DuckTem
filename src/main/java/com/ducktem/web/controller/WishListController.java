package com.ducktem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.entity.Product;
import com.ducktem.web.service.ImgService;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductService;
import com.ducktem.web.service.WishListService;

import jakarta.servlet.http.HttpSession;


@Controller
public class WishListController {

    @Autowired
	private WishListService wishListService;
	
    @Autowired
    private ImgService imgService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private MemberService memberService;
//	찜 불러오기
    @GetMapping("{id}/wish")
	public String findWishList(HttpSession session,
								@PathVariable("id") Long productId) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
            System.out.println("로그인 후 사용해주세요.");
	        return "redirect:/login?returnURL=/product/"+productId+"/wish";
		}
		else {		
			wishListService.findWish(userId, productId);
	        return "redirect:/";
		}
	}
	
//	찜 저장
    @PostMapping("product/{id}/wish")
	@ResponseBody
	public String checkWishList(HttpSession session,
								@PathVariable("id") Long productId) {
		String userId = (String)session.getAttribute("userId");
        
		if(userId == null) {
            System.out.println("로그인 후 사용해주세요.");
            return "reject";
		}
		else {
            System.out.println(productId);
			wishListService.checkWish(userId, productId);
	        return "ok";
		}
	}
    
    
    
//	찜 취소
    @PutMapping("{id}/wish")
	@ResponseBody
	public Boolean deleteWishList(HttpSession session,
								Long productId) {
		String userId = (String)session.getAttribute("userId");

		if(userId == null)
			return false;
		else {		
	        wishListService.deleteWish(userId, productId);
	        return true;
		}
	}
    
    
    
    
    
    
    
    
//	멤버	아이디로 불러오기
	
	
	
	
//	프로덕트 아이디로 불러오기
	
	
	
}
