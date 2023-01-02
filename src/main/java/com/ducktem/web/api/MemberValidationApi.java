package com.ducktem.web.api;


import com.ducktem.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberValidationApi {

    @Autowired
    private MemberService memberService;
    
    @GetMapping("/api/user/{id}")
    public boolean signUpValidation(@PathVariable(name = "id") String userId){
    	
    	return memberService.validMember(userId);
    }
    
    @GetMapping("/api/user/nickchk/{nickName}")
    public boolean nickNameValidation(@PathVariable(name = "nickName") String nickName){
    	
    	return memberService.validNickName(nickName);
    }

    
}
