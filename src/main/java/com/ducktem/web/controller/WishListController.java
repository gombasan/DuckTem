package com.ducktem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.WishList;
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
//	나의 찜 목록 불러오기
    @GetMapping("wish")
	@ResponseBody
	public List<WishList> findWishList(HttpSession session) {
		
    	String userId = (String)session.getAttribute("userId");
    	List<WishList> wishList = null;
		if(userId != null)
			wishList = wishListService.findWish(userId); 
		
		
		return wishList;
	}
	
//	찜 저장
    @PostMapping("{id}/wish")
	@ResponseBody
	public String checkWishList(HttpSession session,
								@PathVariable("id") Long productId) {
		String userId = (String)session.getAttribute("userId");
        
		if(userId == null) {
            System.out.println("로그인 후 사용해주세요.");
            return "/login";
		}
		else {
			wishListService.checkWish(userId, productId);
	        return "ok";
		}
	}
    
    
    
//	찜 취소
    @DeleteMapping("{id}/wish/delete")
	@ResponseBody
	public String deleteWishList(HttpSession session,
								  @PathVariable("id") Long productId) {
		String userId = (String)session.getAttribute("userId");

		if(userId == null)
			return "NoUserId";		
//			wish 목록에 있는지 확인
		if(wishListService.confirmWish(userId, productId) == false)	
			return "NoWishList";
			
//			찜 목록 확인	
		else {			
			System.out.println(userId);
			System.out.println(productId);
	        wishListService.deleteWish(userId, productId);
	        return "deleteDone";
		}
	}
    

//	멤버	아이디로 불러오기
	
	
	
	
//	프로덕트 아이디로 불러오기
    @GetMapping("{id}/nums")
	@ResponseBody
	public int productWishNums(Model model, @PathVariable("id") Long productId) {
		System.out.print(productId);
    	return wishListService.getWIshNums(productId);
	}
	
	
}
