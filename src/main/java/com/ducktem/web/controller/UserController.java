package com.ducktem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ducktem.web.entity.Member;
import com.ducktem.web.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userId") String id,
                        @RequestParam("pwd") String pwd,
                        @RequestParam(defaultValue = "false" ,name = "autologin") boolean autoLogin,
                        HttpSession session,
                        HttpServletRequest request,
                        HttpServletResponse response
    ) {
        Member user = memberService.getMember(id);
        
        //탈퇴 회원 확인
        if(user.getStatus() == 1) {
            //아이디/비번 유효하지 않습니다 -> 메시지 띄울건지? (띄운다면) html 수정해야.
            System.out.println("없는 계정입니다.");

            return "/login";
        }
        	
        //일반로그인
        if(user != null && user.getPwd().equals(pwd)) {
            session.setAttribute("nickName",user.getNickName());
            session.setAttribute("userId",user.getUserId());
            String sessionId = session.getId();
            System.out.println(sessionId);

            //자동로그인 체크되었을 때 세션 저장
            if(autoLogin == true) {
                Cookie cookie = new Cookie("loginInfo",sessionId);
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
                memberService.addAutoLogin(id, sessionId);
               
            }
            return "redirect:/";
        }
        else {
            System.out.println("없는 계정입니다.");
            return "/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.invalidate();
        
        //자동로그인 해지 - 쿠키 삭제
        Cookie cookie = new Cookie("loginInfo", null); 
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        
        return "redirect:/";
    }

}
