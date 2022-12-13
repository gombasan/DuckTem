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



    /* 회원 등록 서비스 아이디가 중복이라면 false, 아니면 true 반환 */
    @Override
    public boolean reg(Member member) {

        /* 멤버 중복 확인 후 중복이 아니라면 true */
        boolean result = validMember(member);

        if(result) {
            memberDao.save(member);
            return true;
        } else{
            return false;
        }

    }

    /* 회원 아이디로 조회한 후 멤버 객체를 반환한다. */
    @Override
    public Member getMember(String memberId) {
        Member member = memberDao.findById(memberId);
        return member;
    }

    /* 전체 회원을 조회하며 멤버타입 리스트를 반환한다.*/
    @Override
    public List<Member> getList() {
        return memberDao.findAll();
    }

    /* 회원 중복을 확인하기 위한 함수. (예외 처리로 변경예정) */
    private boolean validMember(Member member) {
        String userId = member.getUserId();
        Member byId = memberDao.findById(userId);

        if(byId != null) {
            return false;
        }else {
            return true;
        }

    }

}
