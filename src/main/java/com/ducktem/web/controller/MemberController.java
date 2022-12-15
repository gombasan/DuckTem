package com.ducktem.web.controller;


import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
import com.ducktem.web.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    // ===================================================================회원 등록 ==========================================================
    @GetMapping("/sign-up")
    public String signUpForm(MemberForm memberForm) {

        return "sign-up";
    }


    @PostMapping("/sign-up")
    public String signUp(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (memberService.reg(memberForm)) {
                return "/sign-up-ending";
            }
            System.out.println("memberForm.toString() = " + memberForm.toString());
        }

        return "/sign-up";

    }



    // =================================================================== 회원 조회==========================================================
    @GetMapping("/member/list")
    public String list(Model model) {
        List<Member> member = memberService.getList();
        model.addAttribute("members", member);
        return "member/list";
    }






    // ===================================================================로그인/로그아웃==========================================================
    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("userId") String id, @RequestParam("pwd") String pwd, HttpSession session) {
        Member user = memberService.getMember(id);
        if(user != null && user.getPwd().equals(pwd)) {
            session.setAttribute("id",user.getNickName());
            return "redirect:/";
        }
        else {
            System.out.println("없는 계정입니다.");
            return "/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

}
