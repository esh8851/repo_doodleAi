package com.tele.infra.member;

import org.springframework.stereotype.Repository;




@Repository
public interface MemberDao {

	public MemberDto selectOneLogin(MemberDto memberDto);
	
	public MemberDto selectOne(MemberDto memberDto);
	
	public int selectOneCount(MemberVo vo);
	
	public int insert(MemberDto memberDto);
	
	public int update(MemberDto memberDto);
	
	public int uelete(MemberDto memberDto);
	
	public int delete(MemberDto memberDto);
	
}
