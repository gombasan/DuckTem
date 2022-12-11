package com.ducktem.web.dao;

import com.ducktem.web.entity.Member;

import java.util.List;

public interface MemberDao {
    void save(Member member);

    Member findById(String meberId);

    List<Member> findAll();

    Member findByName(String memberName);

}
