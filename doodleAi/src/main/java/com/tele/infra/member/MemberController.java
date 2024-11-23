package com.tele.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/v1/infra/member/profileUsrView")
	public String profileUsrView() {
		return "usr/v1/infra/member/profileUsrView";
	}
	
}
