package com.ducktem.web.controller;


import com.ducktem.web.entity.DucktemUserDetails;
import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
import com.ducktem.web.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            if(!memberForm.getPwd().equals(memberForm.getPwdCheck())){
                bindingResult.rejectValue("pwd","passwordInCorrect","비밀번호가 다릅니다. 다시 확인해주세요.");
                return "/sign-up";
            }
            else {
                memberService.reg(memberForm);
                return "/sign-up-ending";
            }
        }
        else {
            return "/sign-up";
        }
    }



    // =================================================================== 회원 조회==========================================================
    @GetMapping("/member/list")
    public String list(Model model) {
        List<Member> member = memberService.getList();
        model.addAttribute("members", member);
        return "member/list";
    }

    // =====================================마이페이지==========================================================


    @GetMapping("/mypage")
    public String myPage(@AuthenticationPrincipal DucktemUserDetails user, Model model) {
    	
        String userId = user.getUsername();
        
        System.out.println("마이페이지");
//        if (userId == null)//로그인 안한경우 로그인 페이지로 연결
//        	return "redirect:/login?returnURL=/mypage";
        			
//        Member member = memberService.getMember(userId);
//        model.addAttribute(member);

        return "member/my-page/index";
    }

    // =====================================탈퇴==========================================================

    @GetMapping("/test-deactivate")
    public String deactPage() {

        return "test-deactivate";
    }

    @PostMapping("/test-deactivate")
    public String deactPage(@RequestParam("pwd") String pwd, HttpSession session) {

        String userId = (String)session.getAttribute("userId");
        Member user = memberService.getMember(userId);

        if(user.getPwd().equals(pwd)) {
            memberService.deactMember(userId);
            session.invalidate();
            return "redirect:/";
        }
        else {
            return "test-deactive";
        }
    }

}
