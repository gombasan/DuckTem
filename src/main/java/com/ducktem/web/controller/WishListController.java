//package com.ducktem.web.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.ducktem.web.entity.Product;
//import com.ducktem.web.service.ImgService;
//import com.ducktem.web.service.MemberService;
//import com.ducktem.web.service.ProductService;
//import com.ducktem.web.service.WishListService;
//
//import jakarta.servlet.http.HttpSession;
//
//public class WishListController {
//
//    @Autowired
//	private WishListService wishListService;
//	
//    @Autowired
//    private ImgService imgService;
//
//    @Autowired
//    private ProductService productService;
//    
//    @Autowired
//    private MemberService memberService;
//
//	
////	찜 저장
//	@GetMapping("/wish")
//	public void checkWishList(HttpSession session,
//								@PathVariable("id") Long productId) {
//		String userId = (String)session.getAttribute("userId");
//
//        wishListService.checkWish(userId, productId);
//        
//	}
//    
//    
//    
////	멤버	아이디로 불러오기
//	
//	
//	
//	
////	프로덕트 아이디로 불러오기
//	
//	
//	
//}
