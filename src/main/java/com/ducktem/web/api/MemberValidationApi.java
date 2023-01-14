package com.ducktem.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.web.service.MemberService;

@RestController
public class MemberValidationApi {

	@Autowired
	private MemberService memberService;

	@GetMapping("/api/user/{id}")
	public boolean signUpValidation(@PathVariable(name = "id") String userId) {
		return memberService.validMember(userId);
	}
}
