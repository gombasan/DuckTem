package com.ducktem.web.dao;

import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;

import jakarta.servlet.http.Cookie;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberDao {

    /* 회원 저장 */
    void save(Member member);

    /* ID로 회원 찾기 */
    Member findById(String memberId);

    /* 전체 회원 찾기 */
    List<Member> findAll();

    /* 이름으로 회원찾기 */
    Member findByName(String memberName);
    Member findByNickName(String nickName);

    /* 회원 상태 비활성화 */
    void updateStatus(String userId);

    /* 자동로그인 세션 넣기 */
	void updateAutoLogin(String userId, String sessionId);

	/* 자동로그인 세션 찾기 */
	Member findbyLoginInfo(String loginInfo);



}
