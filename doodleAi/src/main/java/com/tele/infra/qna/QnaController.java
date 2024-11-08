package com.tele.infra.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tele.infra.act.ActService;
@Controller
public class QnaController {
	
	@Autowired
	ActService actService;
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrList")
	public String qnaUsrView() {
		return "/usr/v1/infra/qna/qnaUsrList";
	}

}
