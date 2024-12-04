package com.tele.infra.diary;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DiaryDao {
	
	public List<DiaryDto> selectList(DiaryDto diaryDto);
	
	public DiaryDto selectOne(DiaryDto diaryDto);
	
	public int insert(DiaryDto diaryDto);

}
