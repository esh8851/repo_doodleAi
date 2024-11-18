package com.tele.infra.act;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ActService {

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    @Value("${openai.api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * OpenAI API 호출 메소드
     * @param conversationHistory 대화 이력
     * @return OpenAI GPT-3.5 모델의 응답
     */
    public String getChatResponseFromOpenAI(List<Map<String, Object>> conversationHistory) {
        try {
            // OpenAI API 요청 본문 설정
            Map<String, Object> requestBody = new LinkedHashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", conversationHistory);

            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + API_KEY);

            // JSON으로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            // HTTP 요청 엔티티 생성
            HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

            // API 호출
            ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

            // 응답에서 모델의 응답만 추출
            String responseBody = response.getBody();
            if (responseBody != null) {
                Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);
                Map<String, Object> choice = ((List<Map<String, Object>>) responseMap.get("choices")).get(0);
                Map<String, Object> message = (Map<String, Object>) choice.get("message");
                return (String) message.get("content");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: 응답을 처리하는데 문제가 발생했습니다.";
    }
}

