package com.ducktem.web.service;

import com.ducktem.web.entity.Member;

import java.util.List;

public interface MemberService {

    /* 멤버 등록 서비스 */
    boolean reg(Member member);

    /* 회원 id로 조회 서비스 */
    Member getMember(String memberId);

    /* 전체 회원 리스트 조회 서비스*/
    List<Member> getList();

}
