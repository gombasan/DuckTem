package com.ducktem.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DucktemSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf()
				.disable()
			.authorizeHttpRequests()
				.requestMatchers("/member/**").hasAnyRole("MEMBER")
				.requestMatchers("/mypage").hasAnyRole("MEMBER")
				.requestMatchers("/product").hasAnyRole("MEMBER")//상품 등록 페이지
				.requestMatchers("/mylist").hasAnyRole("MEMBER")//내 상품 보기 
				.anyRequest().permitAll()		
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.and()
			.exceptionHandling(exp->exp.accessDeniedPage("/denied"))
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
//		//회원가입 시 적용
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String test = encoder.encode("testtest");
//		System.out.println(test);
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService jdbcUserDetailsService() {
		
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		
		// where절에서는 테이블의 실제 컬럼명을 적어야 한다.
		manager.setUsersByUsernameQuery("select userId username, pwd password, 1 enabled from Member where userId = ?");
		manager.setAuthoritiesByUsernameQuery("select userId username, 'ROLE_MEMBER' authority from Member where userId = ?");
		
		return manager;
	}
	
}
