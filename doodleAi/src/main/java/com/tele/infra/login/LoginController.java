package com.tele.infra.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import jakarta.servlet.http.HttpSession;

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
	
	@ResponseBody
	@RequestMapping(value = "/v1/infra/login/signinUsrProc")
	public Map<String, Object> signinUsrProc(LoginDto loginDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		MemberDto rtMember = memberService.selectOneId(memberDto);

		LoginDto rtMember2 = loginService.selectOneLogin(loginDto);

			if (rtMember2 != null) {
				
//				if(matchesBcrypt(loginDto.getIfmmPassword(), rtMember2.getIfmmPassword(), 10)) {
				
//				if(dto.getAutoLogin() == true) {
//					UtilCookie.createCookie(
//							Constants.COOKIE_SEQ_NAME_XDM, 
//							rtMember2.getIfmmSeq(), 
//							Constants.COOKIE_DOMAIN_XDM, 
//							Constants.COOKIE_PATH_XDM, 
//							Constants.COOKIE_MAXAGE_XDM);
//				} else {
//					// by pass
//				}

				httpSession.setMaxInactiveInterval(60 * 30); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessIdUsr", rtMember2.getIfmmId());
				httpSession.setAttribute("sessNameUsr", rtMember2.getIfmmName());
				httpSession.setAttribute("sessNickNameUsr", rtMember2.getIfmmNickName());
//
//				rtMember2.setIfmmSocialLoginCd(103);
//				rtMember2.setIflgResultNy(1);
//				memberService.insertLogLogin(rtMember2);

				returnMap.put("rt", "success");
//				} else {
//					returnMap.put("rt", "fail");
//				}
			} else {
//				memberDto.setIfmmSocialLoginCd(103);
//				memberDto.setIfmmSeq(rtMember.getIfmmSeq());
//				memberDto.setIflgResultNy(0);
//				memberService.insertLogLogin(memberDto);
				returnMap.put("rt", "fail");
			}
//			memberDto.setIfmmSocialLoginCd(103);
//			memberDto.setIflgResultNy(0);
//			memberService.insertLogLogin(memberDto);

		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/v1/infra/login/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}

}
