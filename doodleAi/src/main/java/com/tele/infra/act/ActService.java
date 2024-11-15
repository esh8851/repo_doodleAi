package com.tele.infra.act;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ActService {

    @Autowired
    ActDao actDao;

    @Autowired
    private RestTemplate restTemplate;  // RestTemplate을 주입받아 사용

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    
    // application-external.properties에서 API 키를 읽어옵니다
    @Value("${openai.api.key}")
    private String API_KEY;

    private List<Map<String, Object>> conversationHistory = new ArrayList<>(); // 대화 이력 저장

    /**
     * OpenAI API 호출 메소드
     * @param prompt 사용자가 입력한 텍스트
     * @return OpenAI GPT-3.5 모델의 응답 (모델 응답만 반환)
     */
    public String getChatResponseFromOpenAI(String prompt) {
        try {
            // 사용자 메시지 추가
            conversationHistory.add(Map.of("role", "user", "content", prompt));

            // OpenAI API 요청 본문 설정 
            Map<String, Object> requestBody = new LinkedHashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", conversationHistory);

            // 헤더 설정: Authorization 헤더에 Bearer API 키 포함
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + API_KEY);

            // JSON으로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            // HTTP 요청 엔티티 생성
            HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

            // API 호출: HTTP POST 요청
            ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

            // 응답에서 모델의 응답만 추출
            String responseBody = response.getBody();
            if (responseBody != null) {
                Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);
                // "choices"에서 첫 번째 항목의 "message.content" 값을 가져옴
                Map<String, Object> choice = ((List<Map<String, Object>>) responseMap.get("choices")).get(0);
                Map<String, Object> message = (Map<String, Object>) choice.get("message");
                String modelResponse = (String) message.get("content");

                // 모델의 응답을 대화 이력에 추가
                conversationHistory.add(Map.of("role", "assistant", "content", modelResponse));

                return modelResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: 응답을 처리하는데 문제가 발생했습니다.";
    }
}
