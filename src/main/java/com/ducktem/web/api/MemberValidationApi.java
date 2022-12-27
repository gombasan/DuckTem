//package com.ducktem.web.api;
//
//
//import com.ducktem.web.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MemberValidationApi {
//
//    @Autowired
//    private MemberService memberService;
//
//
//    @GetMapping("/api/user/{id}")
//    public boolean signUpValidation(@PathVariable(name = "id") String userId){
//
//        return memberService.validMember(userId);
//    }
//
//    @GetMapping("/api/user/{blank}")
//    public String blankAware(@PathVariable(name = "blank") String tagId){
//
//        switch(tagId){
//          case "name":
//              return "이름을 입력해주세요";
//          case "nickname":
//              return "닉네임을 입력해주세요";
//          case "uid":
//              return "아이디를 입력해주세요";
//          case "password1":
//            case "password2":
//                return "비밀번호를 입력해주세요";
//          case "email":
//              return "이메일을 입력해주세요";
//          case "phonenumber":
//              return "핸드폰 번호를 입력해주세요";
//        }
//
//         return "항목을 입력해주세요";
//    }
//
//
//}

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
    
    @GetMapping("/api/user/nick/{nickName}")
    public boolean nickNameValidation(@PathVariable(name = "nickName") String nickName){
    	
    	return memberService.validNickName(nickName);
    }

    
}
