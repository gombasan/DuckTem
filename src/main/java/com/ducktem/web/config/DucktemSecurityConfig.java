package com.ducktem.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DucktemSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		http
			.csrf()
				.disable()
			.authorizeHttpRequests()
//				.requestMatchers("/member/**").hasAnyRole("MEMBER")
//				.requestMatchers("/mypage").hasAnyRole("MEMBER")
//				.requestMatchers("/product").hasAnyRole("MEMBER")//상품 등록 페이지
//				.requestMatchers("/mylist").hasAnyRole("MEMBER")//내 상품 보기 
				.anyRequest().permitAll()		;
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.defaultSuccessUrl("/index")
//				.and()
//			.logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/index");
//		
		return http.build();
	}
}
