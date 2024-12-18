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
//		qnaVo.setParamsPaging(qnaService.selectOneCount(qnaVo));
////		if (qnaVo.getTotalRows() > 0) {
//			model.addAttribute("list", qnaService.selectList(qnaVo));
////		}
		qnaVo.setParamsPaging(qnaService.selectOneCount(qnaVo));
		List<QnaDto> qnas = qnaService.selectList(qnaVo);
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
		return "redirect:/v1/infra/qna/qnaUsrList";
	}
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrMfom")
	public String qnaUsrMfom(QnaDto qnaDto,Model model) {
		model.addAttribute("item",qnaService.selectOne(qnaDto));
		return "usr/v1/infra/qna/qnaUsrMfom";
	}
	
	@RequestMapping(value="/v1/infra/qna/qnaUsrPdt")
	public String qnaUsrPdt(QnaDto qnaDto) {
		qnaService.update(qnaDto);
		return "redirect:/v1/infra/qna/qnaUsrList";
	}
	
}
