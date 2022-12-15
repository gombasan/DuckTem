package com.ducktem.web.dao;

import com.ducktem.web.entity.Member;
import com.ducktem.web.form.MemberForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* DB 구축 전 기능확인을 위한 Dao 구현객체 */
public class MemberDaoImpl{
//
//    private static Map<String, Member> memberRepository = new HashMap<>();
//
//
//    @Override
//    public void save(Member member) {
//
//        memberRepository.put(member.getUserId(), member);
//    }
//
//    @Override
//    public MemberForm findById(String memberId) {
//
//       return memberRepository.get(memberId);
//    }
//
//    @Override
//    public List<MemberForm> findAll() {
//
//        return new ArrayList<>(memberRepository.values());
//    }
//
//    @Override
//    public MemberForm findByName(String memberName) {
//        ArrayList<MemberForm> memberForms = new ArrayList<>(memberRepository.values());
//        MemberForm memberForm = null;
//        for (MemberForm m : memberForms) {
//            if(m.getName().equals(memberName)) {
//                memberForm = memberRepository.get(m.getUserId());
//            }
//
//        }
//
//        return memberForm;
//    }
}
