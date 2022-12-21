package com.ducktem.web.service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao memberDao;



    /* 회원 등록 서비스 아이디가 중복이라면 false, 아니면 true 반환 */
    @Override
    public void reg(MemberForm memberForm) {
            Member member = bindMember(memberForm);
            memberDao.save(member);
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
    public boolean validMember(String userId) {
        Member byId = memberDao.findById(userId);

        if(byId != null) {
            return false;
        }else {
            return true;
        }

    }


    /* MemberForm 에서 Member로 값 이동 */
    private Member bindMember(MemberForm memberForm) {
        Member member = new Member();
        member.setUserId(memberForm.getUserId());
        member.setName(memberForm.getName());
        member.setNickName(memberForm.getNickName());
        member.setPhoneNumber(memberForm.getPhoneNumber());
        member.setPwd(memberForm.getPwd());
        member.setEmail(memberForm.geteMail());

        return member;
    }

    //    회원 아이디 받아서 Member의 status를 1(탈퇴회원)로 변경
    @Override
    public void deactMember(String userId) {
        memberDao.updateStatus(userId);

    }
}
