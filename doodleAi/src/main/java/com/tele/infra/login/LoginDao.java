package com.tele.infra.login;

import org.springframework.stereotype.Repository;


@Repository
public interface LoginDao {

	public LoginDto selectOneLogin(LoginDto loginDto);
	
	public int insert(LoginDto loginDto);
	
	public int update(LoginDto loginDto);
	
	public int uelete(LoginDto loginDto);
	
	public int delete(LoginDto loginDto);
	
}
