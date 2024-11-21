package com.tele.infra.diary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
	
	@Autowired
	DiaryDao diaryDao;
	
	public List<DiaryDto> selectList(DiaryDto diaryDto){
		return diaryDao.selectList(diaryDto);
	}
	
	public DiaryDto selectOne() {
		return diaryDao.selectOne();
	}

}
