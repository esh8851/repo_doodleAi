package com.tele.infra.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/v1/infra/login/loginUsrSignin")
	public String loginUsrSignin() {
		return "/usr/v1/infra/login/loginUsrSignin";
	}

}
