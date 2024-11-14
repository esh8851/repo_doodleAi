package com.tele.infra.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActController {
    
    @Autowired
    ActService actService;
    
    @RequestMapping(value="/v1/infra/act/actUsrList")
    public String actUsrView() {
        return "/usr/v1/infra/act/actUsrList";
    }

    // OpenAI API 결과를 포함한 actUsrForm 페이지로 이동
    @RequestMapping(value = "/v1/infra/act/actUsrForm", method = RequestMethod.GET)
    public String actUsrForm() {
        return "/usr/v1/infra/act/actUsrForm";
    }

    // POST 요청을 통해 사용자가 입력한 텍스트를 받아 OpenAI API에 전달하고 결과 반환
    @RequestMapping(value = "/v1/infra/act/actUsrForm", method = RequestMethod.POST)
    public String actUsrFormSubmit(@RequestParam(value = "userInput", required = false) String userInput, Model model) {
        if (userInput == null || userInput.trim().isEmpty()) {
            // 사용자 입력이 없으면 기본 메시지나 예외 처리
            model.addAttribute("errorMessage", "입력값이 없습니다. 다시 시도해 주세요.");
            return "/usr/v1/infra/act/actUsrForm"; // 결과를 포함한 같은 폼 페이지로 돌아가기
        }

        // 사용자가 입력한 텍스트를 OpenAI API에 전달하여 응답을 받음
        String aiResponse = actService.getChatResponseFromOpenAI(userInput);

        // 모델에 응답을 전달하여 뷰로 전달
        model.addAttribute("userInput", userInput);
        model.addAttribute("aiResponse", aiResponse);

        return "/usr/v1/infra/act/actUsrForm"; // 결과를 포함한 같은 폼 페이지로 돌아가기
    }
}
