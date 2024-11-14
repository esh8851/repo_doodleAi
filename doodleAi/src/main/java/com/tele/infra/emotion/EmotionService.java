package com.tele.infra.emotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionService {
	
	@Autowired
	EmotionDao emotionDao;

}
