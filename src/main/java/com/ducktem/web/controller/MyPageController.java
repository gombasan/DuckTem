package com.ducktem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ducktem.web.entity.DucktemUserDetails;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.ProductPreviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {

	
    @Autowired
    private ProductPreviewService productPreviewService;
	
//	
//    /* 판매중 상품 보여주기 */
//    @GetMapping("myProductList")
//	@ResponseBody
//    public List<ProductPreview> getMyProduct(HttpSession session) {
//    	String userId = (String)session.getAttribute("userId");
//
//        return productPreviewService.myList(userId);
//    }
    
    /* 판매중 상품 보여주기 */
    @GetMapping("myProductList")
    @ResponseBody
    public List<ProductPreview> getMyProduct(@AuthenticationPrincipal DucktemUserDetails user) {
    	String userId = user.getUsername();
    	
    	return productPreviewService.myList(userId);
    }

}
