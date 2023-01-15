package com.ducktem.web.service;

import static org.mockito.Mockito.*;

import java.util.List;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

	@Mock
	private MemberDao memberDao;

    @InjectMocks
    private MemberServiceImpl memberService;

   @Test
   void reg() {
       Member member = new Member();
       MemberForm memberForm = new MemberForm(
           "1","닉네임","이름","password","010-1234-5678","email@email.com"
       );
       memberService.reg(memberForm);
   }

   @Test
   void getMember() {
       Member member = new Member();
       memberDao.save(member);
       when(memberDao.findById(any())).thenReturn(member);

       Member member1 = memberDao.findById(member.getUserId());

       Assertions.assertThat(member1).isEqualTo(member);
   }

   @Test
   void getList() {
       Member member = new Member();
       Member member1 = new Member();
       Member member2 = new Member();
       memberDao.save(member);
       memberDao.save(member1);
       memberDao.save(member2);
       when(memberDao.findAll()).thenReturn(List.of(member,member1,member2));

       List<Member> memberList = memberDao.findAll();

       for(Member members: memberList) {
           System.out.println("members = " + members);
       }
   }
}