package com.tele.infra.emotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmotionController {
	
	@Autowired
	EmotionService emotionService;
	
	@RequestMapping(value="/v1/infra/emotion/emotionUsrList")
	public String emotionUsrList() {
		return "usr/v1/infra/emotion/emotionUsrList";
	}
	
	@RequestMapping(value="/v1/infra/emotion/emotionUsrForm")
	public String emotionUsrForm() {
		return "usr/v1/infra/emotion/emotionUsrForm";
	}

}
