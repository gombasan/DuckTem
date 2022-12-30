package com.ducktem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ducktem.web.entity.Review;
import com.ducktem.web.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {

	
    @Autowired
    private ReviewService reviewService;
	
//	review 등록하기
    @PostMapping("regReview")
    public void regReview(HttpSession session) {
    	String userId = (String)session.getAttribute("userId");

    	reviewService.save(userId);  
    }
	
//	myreviewList-내가 작성한 리뷰?? 내가 받은 리뷰???
    @GetMapping("getMyReviewList")
	@ResponseBody
    public List<Review> getMyReviewProduct(HttpSession session) {
    	String userId = (String)session.getAttribute("userId");

        return reviewService.getmyList(userId);
    }
	
	
	
	
}
