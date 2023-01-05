package com.ducktem.web.controller;


import com.ducktem.web.entity.DucktemUserDetails;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductPreviewService;
import com.ducktem.web.service.ProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductPreviewService productPreviewService;
    @Autowired
    private MemberService memberService;



    /* 메인 페이지*/
    @GetMapping("/")

    public String index(Model model, @AuthenticationPrincipal DucktemUserDetails user, HttpServletRequest request) {
    	
    	String userId = null;
    	
    	if(user != null) {
    		userId = user.getUsername();
    	}
    	List<ProductPreview> preview = productPreviewService.preview(userId);
    	model.addAttribute("preview", preview);

        return "index";
    }


}
