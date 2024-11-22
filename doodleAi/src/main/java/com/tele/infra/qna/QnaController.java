package com.tele.infra.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrList")
	public String qnaUsrView(Model model) {
		List<QnaDto> qnas = qnaService.selectList();
		model.addAttribute("list", qnas);
		return "usr/v1/infra/qna/qnaUsrList";
	}

	@RequestMapping(value="/v1/infra/qna/qnaUsrForm")
	public String qnaUsrFrom(QnaDto qnaDto) {
		return "usr/v1/infra/qna/qnaUsrForm";
	}
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrInst")
	public String qnaUsrInst(QnaDto qnaDto) {
		qnaService.insert(qnaDto);
		return "redirect:/usr/v1/infra/qna/qnaUsrList";
	}
	
}
