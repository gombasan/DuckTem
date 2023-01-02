package com.ducktem.web.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class HomeControllerTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;

    /* 메인 페이지*/
  
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request, HttpSession session) {
        List<ProductPreview> preview = productService.preview();
        model.addAttribute("preview", preview);
        
        /*자동 로그인*/
        Cookie[] cookies = request.getCookies();
        String loginInfo = "";
        
        for (Cookie c : cookies) {
        	String cName = c.getName();
        	if(cName.equals("loginInfo")) {
        		loginInfo = c.getValue();
//        		System.out.println("loginInfo : "+loginInfo);
        	}
        }
        
        if (!loginInfo.equals("")) {
        	Member member = memberService.findByLoginInfo(loginInfo);
        	session.setAttribute("nickName",member.getNickName());
        	session.setAttribute("userId",member.getUserId());
        	System.out.println("if문 들어옴");
        	return "redirect:/";
        }

        return "index";
    }
    
    


}
