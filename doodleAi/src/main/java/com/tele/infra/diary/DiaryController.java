package com.tele.infra.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiaryController {
	
	@Autowired
	DiaryService diaryService;
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrList")
	public String diaryUsrView(Model model, DiaryDto diaryDto) {
		model.addAttribute("list", diaryService.selectList(diaryDto));
		return "/usr/v1/infra/diary/diaryUsrList";
	}
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrForm")
	public String diaryUsrForm() {
		return "/usr/v1/infra/diary/diaryUsrForm";
	}

}
