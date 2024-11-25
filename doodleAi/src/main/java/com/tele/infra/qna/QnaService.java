package com.tele.infra.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaDao qnaDao;
	
	List<QnaDto> selectList(QnaVo qnaVo){
		return qnaDao.selectList(qnaVo);
	}
	
	public int insert(QnaDto qnaDto) {
		return qnaDao.insert(qnaDto);
	}
	
	public int selectOneCount(QnaVo qnaVo) {
		return qnaDao.selectOneCount(qnaVo);
	}
	
}
