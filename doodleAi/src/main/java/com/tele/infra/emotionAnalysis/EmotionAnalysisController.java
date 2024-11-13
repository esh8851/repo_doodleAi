package com.tele.infra.emotionAnalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmotionAnalysisController {
	
	@Autowired
	EmotionAnalysisService emotionAnalysisService;
	
	@RequestMapping(value="/v1/infra/emotionAnalysis/emotionAnalysisUsrList")
	public String emotionAnalysisUsrList() {
		return "/usr/v1/infra/emotionAnalysis/emotionAnalysisUsrList";
	}
	
	@RequestMapping(value="/v1/infra/emotionAnalysis/emotionAnalysisUsrForm")
	public String emotionAnalysisUsrForm() {
		return "/usr/v1/infra/emotionAnalysis/emotionAnalysisUsrForm";
	}

}
