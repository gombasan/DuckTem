package com.ducktem.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.entity.DucktemUserDetails;
import com.ducktem.web.entity.Member;

public class DucktemUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberDao memberdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberdao.findById(username);
		
		DucktemUserDetails user = new DucktemUserDetails();
		user.setId(member.getId());
		user.setNickName(member.getNickName());
		user.setPassword(member.getPwd());
		user.setUsername(member.getUserId());
		user.setEmail(member.getEmail());
		
		return user;
	}

}
