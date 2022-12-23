package com.ducktem.web.service;

import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;

import jakarta.servlet.http.Cookie;

import java.util.List;

public interface MemberService {

    /* 멤버 등록 서비스 */
    void reg(MemberForm memberForm);

    /* 회원 id로 조회 서비스 */
    Member getMember(String memberId);

    /* 전체 회원 리스트 조회 서비스*/
    List<Member> getList();

    /* 중복 확인 서비스 */
    boolean validMember(String userId);

    /*회원 탈퇴 서비스*/
    void deactMember(String userId);

    /*자동로그인 서비스*/
	void addAutoLogin(String userId, String sessionId);

	String findLoginInfo(String loginInfo);


}
