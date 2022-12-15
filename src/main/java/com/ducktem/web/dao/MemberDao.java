package com.ducktem.web.dao;

import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
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

}
