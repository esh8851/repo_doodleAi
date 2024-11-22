package com.tele.infra.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaDao qnaDao;
	
	List<QnaDto> selectList(){
		return qnaDao.selectList();
	}
	
	public int insert(QnaDto qnaDto) {
		return qnaDao.insert(qnaDto);
	}
}
