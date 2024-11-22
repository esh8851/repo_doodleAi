package com.tele.infra.diary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// DiaryService에서 다이어리 리스트 가져오기
        List<DiaryDto> diaryList = diaryService.selectList(diaryDto);
     // 풀캘린더 형식으로 변환
        List<Map<String, Object>> calendarEvents = new ArrayList<>();
        for (DiaryDto diary : diaryList) {
            Map<String, Object> event = new HashMap<>();
            event.put("title", diary.getIfdrTitle());
            event.put("start", "2024-11-01T17:00:00");
            // 이벤트 리스트에 추가
            calendarEvents.add(event);
         // 모델에 "list" 대신 "calendarEvents" 추가
            model.addAttribute("calendarEvents", calendarEvents);
        }
		return "usr/v1/infra/diary/diaryUsrList";
	}
	
	@RequestMapping(value="/v1/infra/diary/diaryUsrForm")
	public String diaryUsrForm() {
		return "usr/v1/infra/diary/diaryUsrForm";
	}

}
