package com.ducktem.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.Member;

@Mapper
public interface MemberDao {

	/* 회원 저장 */
	// void를 반환하기 보다 Memeber를 반환하는 것도 좋을 것 같아요 -> 편리하게 사용가능함(특히, 테스트)
	void save(Member member);

	/* ID로 회원 찾기 */
	Member findById(String memberId);

	/* 전체 회원 찾기 */
	List<Member> findAll();

	/* 이름으로 회원찾기 */
	Member findByName(String memberName);

	/* 회원 상태 비활성화 */
	void updateStatus(String userId);

}
