package com.ducktem.web.dao;

import com.ducktem.web.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDaoImpl implements MemberDao{

    private static Map<String,Member> memberRepository = new HashMap<>();


    @Override
    public void save(Member member) {
        memberRepository.put(member.getUserId(),member);
    }

    @Override
    public Member findById(String memberId) {

       return memberRepository.get(memberId);
    }

    @Override
    public List<Member> findByAll() {
        return new ArrayList<>(memberRepository.values());
    }
}
