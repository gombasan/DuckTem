package com.ducktem.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ducktem.web.entity.DucktemUserDetails;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.MyPageReview;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.Review;
import com.ducktem.web.service.BuyService;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductPreviewService;
import com.ducktem.web.service.ProductService;
import com.ducktem.web.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
    @Autowired
    private MemberService memberService;
	
	@Autowired
    private BuyService buyService;
	
    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private ProductService productService;
	
//	review 등록하기
    @PostMapping("regReview")
    public void regReview(@AuthenticationPrincipal DucktemUserDetails user, Long productId) {
    	String userId = null;
    	
    	if(user != null) {
    		userId = user.getUsername();
    	}
    	if(buyService.confirmBuy(userId,productId))
    		reviewService.save(userId,productId);  
    }
	
//	myreviewList-내가 받은 리뷰???
    @GetMapping("getMyReviewList")
	@ResponseBody
    public List<MyPageReview> getMyReviewProduct(@AuthenticationPrincipal DucktemUserDetails user) {
    	String userId = null;
    	
    	if(user != null) {
    		userId = user.getUsername();
    	}
    	
    	List<Product> mySellingProduct = productService.getByMemberId(userId);
    	List<String> tempCustomers = buyService.get(mySellingProduct);
    	List<Member> customerInfo = memberService.getMemberList(tempCustomers);
    	
        return reviewService.getmyList(customerInfo,mySellingProduct);
    }
	
	
	
	
}
