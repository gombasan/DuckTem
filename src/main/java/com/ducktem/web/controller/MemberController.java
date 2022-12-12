package com.ducktem.web.controller;


import com.ducktem.web.entity.Member;
import com.ducktem.web.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;


    @GetMapping("/member/new")
    public String regMemberForm() {

        return "/member/member-form";
    }

    @PostMapping("/member/new")
    public String regMember(Member member) {
        memberService.reg(member);
        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String list(Model model) {
        List<Member> members = memberService.getList();
        model.addAttribute("members",members);
        return "member/list";
    }

    @GetMapping("/login")
    public String loginForm() {

        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userId") String id, @RequestParam("pwd") String pwd, HttpSession session) {
        Member user = memberService.getMember(id);
        if(user.getPwd().equals(pwd)) {

            session.setAttribute("id",user.getName());

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
