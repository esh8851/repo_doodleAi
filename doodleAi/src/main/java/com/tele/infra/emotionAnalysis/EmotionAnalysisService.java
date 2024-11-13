package com.tele.infra.emotionAnalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionAnalysisService {
	
	@Autowired
	EmotionAnalysisDao emotionAnalysisDao;

}
