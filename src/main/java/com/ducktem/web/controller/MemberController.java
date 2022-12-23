package com.ducktem.web.controller;


import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
import com.ducktem.web.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    public String myPage(HttpSession session, Model model) {

        String userId = (String)session.getAttribute("userId");
        Member member = memberService.getMember(userId);
        model.addAttribute(member);

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


    // =======================================(수정중)============================로그인/로그아웃==========================================================

    @GetMapping("/login")
    public String loginForm() {

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
    	//user를 이렇게 먼저 가져와도 되나? 상관없나?
        Member user = memberService.getMember(id);

        //스위치문 사용?
        //확인해야 할 경우
        // 1. 탈퇴여부, 2.자동로그인 설정했는지 확인->맞으면 로그인 시키기 3.로그인 했는데 자동로그인 체크해둔 경우 로그인 시키면서 세션 저장 
        //4.로그아웃 하면 자동로그인 취소되게. db에서 세션아이디 지우기. (한번 로그아웃 후 다시 자동로그인 체크해두면 새 세션 아이디 잘 들어가는지 확인)
        
        
        //1. 탈퇴 회원 확인
        if(user.getStatus() == 1) {
            //로그인 인풋창 아래에 '회원 정보가 존재하지 않습니다' 띄우는 방법?->js 
            System.out.println("없는 계정입니다.");

            return "/login";
        }
        
//        //2.자동로그인 확인 (컨트롤러 따로 빼거나 서비스 따로 뺄 것!!!!!!!)
//        Cookie[] cookies = request.getCookies();
//        String loginInfo = "";
//        
//        for (Cookie c : cookies) {
//        	String cName = c.getName();
//        	if(cName == "loginInfo") {
//        		loginInfo = c.getValue();
//        		break;
//        	}
//        }
//        
//        
//        //변수명 더 고민해보기. db에 있는 session 정보 vs. 현재 클라이언트 쿠키에 있는 세션 정보
//        //현재 문제. 내가 이 브라우저로 여러 아이디 접속했다 풀면 어떤 아이디로 오토로그인해야 하는지 구분 못함. 
//        String info = memberService.findLoginInfo(loginInfo);
//        if(loginInfo.equals(info)) {
//            session.setAttribute("nickName",user.getNickName());
//            session.setAttribute("userId",user.getUserId());
//        	return "redirect:/";
//        }
        	
        	
        //3. 일반로그인
        else if(user != null && user.getPwd().equals(pwd)) {
            session.setAttribute("nickName",user.getNickName());
            session.setAttribute("userId",user.getUserId());
//            세션에서 멤버식별용 아이디 얻어와야 마이페이지에서 멤버별 정보 가져올 수 있음
            String sessionId = session.getId();
            System.out.println(sessionId);

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
