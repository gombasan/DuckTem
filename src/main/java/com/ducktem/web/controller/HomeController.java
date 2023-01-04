package com.ducktem.web.controller;


import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.service.MemberService;
import com.ducktem.web.service.ProductPreviewService;
import com.ducktem.web.service.ProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String index(Model model, HttpSession session, HttpServletRequest request) {
    	String userId = (String)session.getAttribute("userId");
        List<ProductPreview> preview = productPreviewService.preview(userId);
        model.addAttribute("preview", preview);
        
//        /*자동 로그인*/
//        Cookie[] cookies = request.getCookies();
//        String loginInfo = "";
//        
//        for (Cookie c : cookies) {
//        	String cName = c.getName();
//        	if(cName.equals("loginInfo")) {
//        		loginInfo = c.getValue();
//        		break;
//        	}
//        }
//        
//        if (!loginInfo.equals("")) {
//        	Member member = memberService.findByLoginInfo(loginInfo);
//        	session.setAttribute("nickName",member.getNickName());
//        	session.setAttribute("userId",member.getUserId());
//        }


        return "index";
    }

    /*자동 로그인*/


    

}
