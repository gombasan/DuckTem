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
    private ProductPreviewService productPreviewServiceService;
    @Autowired
    private MemberService memberService;



    /* 메인 페이지*/
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<ProductPreview> preview = productPreviewServiceService.preview();
        model.addAttribute("preview", preview);

        return "index";
    }

    

}
