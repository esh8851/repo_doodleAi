package com.tele.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tele.common.constants.Constants;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/v1/infra/member/profileUsrView")
	public String profileUsrView() {
		return "usr/v1/infra/member/profileUsrView";
	}
	
	@RequestMapping(value="/v1/infra/member/signinUsrForm")
	public String signinUsrForm() {
		return "usr/v1/infra/member/signinUsrForm";
	}
	
	@RequestMapping(value="/v1/infra/member/signupUsrForm")
	public String signupUsrForm(MemberDto memberDto) {
		return "usr/v1/infra/member/signupUsrForm";
	}
	
	@RequestMapping (value = "/usr/v1/infra/member/memberUsrInst")
	public String memberUsrInst(MemberDto memberDto){//함수 선언
//		memberDto.setMemPassword(encodeBcrypt(memberDto.getMemPassword(), 10));//비밀번호 암호화
		memberService.insert(memberDto); //함수 사용
//		mailService.sendMailSimple();
		return "redirect:/v1/infra/member/signinUsrForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/usr/v1/infra/member/signinUsrProc")
	public Map<String, Object> signinUsrProc(MemberDto memberDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rtMember = memberService.selectOneId(memberDto);
		if (rtMember != null) {
			MemberDto rtMember2 = memberService.selectOneLogin(memberDto);
			if (rtMember2 != null) {
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_USR); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessIdUsr", rtMember2.getIfmmId());
				httpSession.setAttribute("sessNameUsr", rtMember2.getIfmmName());
				httpSession.setAttribute("sessZipcodeUsr", rtMember2.getIfmmNickName());
				httpSession.setAttribute("sessEmailUsr", rtMember2.getIfmmEmail());
				httpSession.setAttribute("sessPhoneNumUsr", rtMember2.getIfmmPhone());
				httpSession.setAttribute("sessAddressUsr", rtMember2.getIfmmPhone());
				httpSession.setAttribute("sessDtAddressUsr", rtMember2.getIfmmBirth());
				httpSession.setAttribute("Member_memseq", rtMember2.getIfmmSeq());
				System.out.println("Member_memseq set in session:" + rtMember2.getIfmmSeq());
				returnMap.put("rt", "success");
			} else {
				returnMap.put("rt", "fail");
			}
		} else {
			returnMap.put("rt", "fail");
		}
		System.out.println("sessSeqUsr: " + httpSession.getAttribute("sessSeqUsr"));
		System.out.println("sessIdUsr: " + httpSession.getAttribute("sessIdUsr"));
		System.out.println("sessNameUsr: " + httpSession.getAttribute("sessNameUsr"));
		System.out.println("Member_memseq: " + httpSession.getAttribute("Member_memseq"));
		System.out.println("sessEmailUsr: " + httpSession.getAttribute("sessEmailUsr"));
		System.out.println("sessPhoneNumUsr: " + httpSession.getAttribute("sessPhoneNumUsr"));
		System.out.println("sessZipcodeUsr: " + httpSession.getAttribute("sessZipcodeUsr"));
		System.out.println("sessAddressUsr: " + httpSession.getAttribute("sessAddressUsr"));
		System.out.println("sessDtAddressUsr: " + httpSession.getAttribute("sessDtAddressUsr"));
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
}
