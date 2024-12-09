package com.tele.infra.qna;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface QnaDao {
	
	List<QnaDto> selectList(QnaVo qnaVo);
	
	public int insert(QnaDto qnaDto);
	
	public int selectOneCount(QnaVo qnaVo);
	
	public int update(QnaDto qnaDto);
	
	public QnaDto selectOne(QnaDto qnaDto);
	
}
