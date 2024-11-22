package com.tele.infra.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tele.infra.member.MemberDto;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public LoginDto selectOneLogin(LoginDto loginDto) {
		return loginDao.selectOneLogin(loginDto);
	}
	
	public int insert(LoginDto loginDto) {
		return loginDao.insert(loginDto);
	}
	
	public int update(LoginDto loginDto) {
		return loginDao.update(loginDto);
	}
	
	public int uelete(LoginDto loginDto) {
		return loginDao.uelete(loginDto);
	}
	
	public int delete(LoginDto loginDto) {
		return loginDao.delete(loginDto);
	}

}
