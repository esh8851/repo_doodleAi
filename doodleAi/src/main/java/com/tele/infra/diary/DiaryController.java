package com.tele.infra.diary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiaryController {
	
	@Autowired
	DiaryService diaryService;
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrList")
	public String diaryUsrView() {
		return "usr/v1/infra/diary/diaryUsrList";
	}
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrForm")
	public String diaryUsrForm() {
		return "usr/v1/infra/diary/diaryUsrForm";
	}
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrInst")
	public String diaryUsrInst(DiaryDto diaryDto) {
		diaryService.insert(diaryDto);
		return "redirect:/v1/infra/diary/diaryUsrList";
	}
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrMForm")
	public String diaryUsrMForm(Model model, DiaryDto diaryDto) {
		model.addAttribute("item", diaryService.selectOne(diaryDto));
		return "usr/v1/infra/diary/diaryUsrMForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/v1/infra/diary/diaryUsrProc")
	public Map<String, Object> concertUsrInst(Model model, DiaryDto diaryDto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<DiaryDto> diaryList = diaryService.selectList(diaryDto);
		returnMap.put("list", diaryList);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrUpdt")
	public String diaryUsrUpdt(DiaryDto diaryDto) {
		diaryService.update(diaryDto);
		return "redirect:/v1/infra/diary/diaryUsrList";
	}

}
