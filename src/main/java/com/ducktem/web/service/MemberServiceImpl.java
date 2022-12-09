package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao memberDao;


    @Override
    public void reg(Member member) {
        memberDao.save(member);
    }

    @Override
    public Member getMember(String memberId) {
        return memberDao.findById(memberId);
    }

    @Override
    public List<Member> getList() {
        return memberDao.findByAll();
    }
}
