package com.tele.infra.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QnaController {
	
	@Autowired
	QnaService qnaService;
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrList")
	public String qnaUsrView() {
		return "/usr/v1/infra/qna/qnaUsrList";
	}

	@RequestMapping(value="/v1/infra/qna/qnaUsrForm")
	public String qnaUsrFrom() {
		return "/usr/v1/infra/qna/qnaUsrForm";
	}
	
}
