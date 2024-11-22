package com.tele.infra.qna;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface QnaDao {
	
	List<QnaDto> selectList();
	
	public int insert(QnaDto qnaDto);
	
}
