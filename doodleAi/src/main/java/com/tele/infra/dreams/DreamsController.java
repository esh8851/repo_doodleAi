package com.tele.infra.dreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class DreamsController {
	
	@Autowired
	private DreamsService dreamsService;
	
	@RequestMapping(value="/v1/infra/dreams/dreamsUsrView")
	public String dreamsUsrView() {
		return "/usr/v1/infra/dreams/dreamsUsrView";
	}

	@RequestMapping(value = "/v1/infra/dreams/dreamsUsrView", method = RequestMethod.GET)
    public String actUsrForm(HttpSession session, Model model) {
        // 세션에서 대화 이력 가져오기 (없으면 새로 생성)
        List<Map<String, Object>> conversationHistory = (List<Map<String, Object>>) session.getAttribute("conversationHistory");
        if (conversationHistory == null) {
            conversationHistory = new ArrayList<>();
            session.setAttribute("conversationHistory", conversationHistory);
        }

        // 대화 이력을 모델에 추가
        model.addAttribute("conversationHistory", conversationHistory);
        return "/usr/v1/infra/dreams/dreamsUsrView";
    }

    @RequestMapping(value = "/v1/infra/dreams/dreamsUsrView", method = RequestMethod.POST)
    public String actUsrFormSubmit(
            @RequestParam(value = "userInput", required = false) String userInput,
            HttpSession session,
            Model model) {

        // 세션에서 대화 이력 가져오기 (없으면 새로 생성)
        List<Map<String, Object>> conversationHistory = (List<Map<String, Object>>) session.getAttribute("conversationHistory");
        if (conversationHistory == null) {
            conversationHistory = new ArrayList<>();
            session.setAttribute("conversationHistory", conversationHistory);
        }

        if (userInput == null || userInput.trim().isEmpty()) {
            model.addAttribute("errorMessage", "입력값이 없습니다. 다시 시도해 주세요.");
            model.addAttribute("conversationHistory", conversationHistory);
            return "/usr/v1/infra/act/actUsrForm";
        }

        // 사용자 입력을 대화 이력에 추가
        conversationHistory.add(Map.of("role", "user", "content", userInput));

        // OpenAI API 호출
        String aiResponse = dreamsService.getChatResponseFromOpenAI(conversationHistory);

        // OpenAI 응답을 대화 이력에 추가
        conversationHistory.add(Map.of("role", "assistant", "content", aiResponse));

        // 세션에 대화 이력을 업데이트
        session.setAttribute("conversationHistory", conversationHistory);

        // 모델에 대화 이력을 전달
        model.addAttribute("conversationHistory", conversationHistory);

        return "/usr/v1/infra/dreams/dreamsUsrView";
    }
	
}
