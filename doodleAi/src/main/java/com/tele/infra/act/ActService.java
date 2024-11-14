package com.tele.infra.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;

@Service
public class ActService {
	
	@Autowired
	ActDao actDao;
		
	@Autowired
    private RestTemplate restTemplate;  // RestTemplate을 주입받아 사용

    // OpenAI API 호출을 위한 상수
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "openai.api.key";  // 여기에 OpenAI API 키를 입력하세요.

    /**
     * OpenAI API 호출 메소드
     * @param prompt 사용자가 입력한 텍스트
     * @return OpenAI GPT-3.5 모델의 응답
     */
    public String getChatResponseFromOpenAI(String prompt) {
        // OpenAI API 요청 본문 설정
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("model", "gpt-3.5-turbo");
        requestBody.add("messages", new Object[]{
            new Object[]{"role", "system", "content", "You are a helpful assistant."},
            new Object[]{"role", "user", "content", prompt}
        });

        // 헤더 설정: Authorization 헤더에 Bearer API 키 포함
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);

        // HTTP 요청 엔티티 생성
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // API 호출: HTTP POST 요청
        ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

        // API 응답 반환
        return response.getBody();
    }
	
}
