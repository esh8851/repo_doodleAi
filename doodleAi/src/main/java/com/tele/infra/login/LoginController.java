package com.tele.infra.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/v1/infra/login/loginUsrSignIn")
	public String loginUsrSignIn() {
		return "usr/v1/infra/login/loginUsrSignIn";
	}
	
	@RequestMapping(value="/v1/infra/login/loginUsrSignUp")
	public String loginUsrSignUp() {
		return "usr/v1/infra/login/loginUsrSignUp";
	}
	
	

}
