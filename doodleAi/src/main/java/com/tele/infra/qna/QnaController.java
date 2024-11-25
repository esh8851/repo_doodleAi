package com.tele.infra.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrList")
	public String qnaUsrList(Model model,@ModelAttribute("vo") QnaVo qnaVo) {
		List<QnaDto> qnas = qnaService.selectList(qnaVo);
		model.addAttribute("list", qnas);
		qnaVo.setParamsPaging(qnaService.selectOneCount(qnaVo));
		return "usr/v1/infra/qna/qnaUsrList";
	}

	@RequestMapping(value="/v1/infra/qna/qnaUsrForm")
	public String qnaUsrFrom(QnaDto qnaDto) {
		return "usr/v1/infra/qna/qnaUsrForm";
	}
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrInst")
	public String qnaUsrInst(QnaDto qnaDto) {
		qnaService.insert(qnaDto);
		return "redirect:/v1/infra/qna/qnaUsrList";
	}
	
}
