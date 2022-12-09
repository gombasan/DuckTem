package com.ducktem.web.service;

import com.ducktem.web.entity.Member;

import java.util.List;

public interface MemberService {

    
    void reg(Member member);
    Member getMember(String memberId);
    List<Member> getList();

}
