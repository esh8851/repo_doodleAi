package com.tele.infra.dreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DreamsController {
	
	@Autowired
	private DreamsService dreamsService;
	
	@RequestMapping(value="/v1/infra/dreams/dreamsUsrView")
	public String dreamsUsrView(Model model, DreamsDto dto) {
		model.addAttribute("list", dreamsService.selectList(dto));
		
		return "usr/v1/infra/dreams/dreamsUsrView";
	}
	
	@RequestMapping(value="/v1/infra/dreams/dreamsUsrForm")
	public String dreamsUsrForm() {
		return "usr/v1/infra/dreams/dreams/dreamsUsrForm";
	}
	
	@RequestMapping(value="/v1/infra/dreams/dreamsUsrMfom")
	public String dreamsUsrMfom(Model model, DreamsDto dto) {
		
		model.addAttribute("item", dreamsService.selectOne(dto));
		
		return "usr/v1/infra/dreams/dreamsUsrMfom";
	}
	
	@RequestMapping(value="/v1/infra/dreams/dreamsUsrInst")
	public String dreamsUsrInst(@ModelAttribute("dto") DreamsDto dto) {
		dreamsService.insert(dto);
		return "redirect:/v1/infra/dreams/dreamsUsrView";
	}

	@RequestMapping(value = "/v1/infra/dreams/dreamsUsrForm", method = RequestMethod.GET)
    public String dreamsUsrForm(HttpSession session, Model model) {
        // 세션에서 대화 이력 가져오기 (없으면 새로 생성)
        List<Map<String, Object>> conversationHistory2 = (List<Map<String, Object>>) session.getAttribute("conversationHistory2");
        if (conversationHistory2 == null) {
            conversationHistory2 = new ArrayList<>();
            session.setAttribute("conversationHistory2", conversationHistory2);
        }

        // 대화 이력을 모델에 추가
        model.addAttribute("conversationHistory2", conversationHistory2);
        return "usr/v1/infra/dreams/dreamsUsrForm";
    }

    @RequestMapping(value = "/v1/infra/dreams/dreamsUsrForm", method = RequestMethod.POST)
    public String dreamsUsrFormSubmit(
            @RequestParam(value = "userInput", required = false) String userInput,
            HttpSession session,
            Model model) {

        // 세션에서 대화 이력 가져오기 (없으면 새로 생성)
        List<Map<String, Object>> conversationHistory2 = (List<Map<String, Object>>) session.getAttribute("conversationHistory2");
        if (conversationHistory2 == null) {
            conversationHistory2 = new ArrayList<>();
            session.setAttribute("conversationHistory2", conversationHistory2);
        }

        if (userInput == null || userInput.trim().isEmpty()) {
            model.addAttribute("errorMessage", "입력값이 없습니다. 다시 시도해 주세요.");
            model.addAttribute("conversationHistory2", conversationHistory2);
            return "usr/v1/infra/dreams/dreamsUsrForm";
        }

        // 사용자 입력을 대화 이력에 추가
        conversationHistory2.add(Map.of("role", "user", "content", userInput));

        // OpenAI API 호출
        String aiResponse = dreamsService.getChatResponseFromOpenAI(conversationHistory2);
        
        // 모델에 응답을 전달하여 뷰로 전달
        model.addAttribute("userInput", userInput + "분석해줘");
        model.addAttribute("aiResponse", aiResponse);

        // OpenAI 응답을 대화 이력에 추가
        conversationHistory2.add(Map.of("role", "assistant", "content", aiResponse));

        // 세션에 대화 이력을 업데이트
        session.setAttribute("conversationHistory2", conversationHistory2);

        // 모델에 대화 이력을 전달
        model.addAttribute("conversationHistory2", conversationHistory2);

        return "usr/v1/infra/dreams/dreamsUsrForm";
    }
	
}
