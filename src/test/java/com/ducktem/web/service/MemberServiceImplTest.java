package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.MemberDaoImpl;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {


    private MemberDao memberDao = new MemberDaoImpl();


    @Test
    void reg() {
        Member member = new Member("hihi","hihi","1234","1234","xxxx", Role.USER);
        memberDao.save(member);
        System.out.println("member = " + member);

    }

    @Test
    void getMember() {
        Member member = new Member("hihi","hihi","1234","1234","xxxx", Role.USER);
        memberDao.save(member);

        Member member1 = memberDao.findById(member.getUserId());

        Assertions.assertThat(member1).isEqualTo(member);


    }

    @Test
    void getList() {
        Member member = new Member("hihi","hihi","1234","1234","xxxx", Role.USER);
        Member member1 = new Member("hih412412i","hihi412412","1234","1234","xxxx", Role.USER);
        Member member2 = new Member("hih312i","hih321i","1312234","1233214","xxxx", Role.USER);
        memberDao.save(member);
        memberDao.save(member1);
        memberDao.save(member2);



        List<Member> memberList = memberDao.findByAll();
        
        for(Member members: memberList) {
            System.out.println("members = " + members);
        }


    }
}