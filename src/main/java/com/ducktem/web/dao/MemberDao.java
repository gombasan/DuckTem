package com.ducktem.web.dao;

import com.ducktem.web.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberDao {
    void save(Member member);

    Member findById(String memberId);

    List<Member> findAll();

    Member findByName(String memberName);

}
