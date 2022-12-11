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
    public List<Member> findAll() {

        return new ArrayList<>(memberRepository.values());
    }

    @Override
    public Member findByName(String memberName) {
        ArrayList<Member> members = new ArrayList<>(memberRepository.values());
        Member member = null;
        for (Member m : members) {
            if(m.getName().equals(memberName)) {
                member = memberRepository.get(m.getUserId());
            }

        }

        return member;
    }
}
