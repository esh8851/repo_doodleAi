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
	
	public DiaryDto selectOne(DiaryDto diaryDto) {
		return diaryDao.selectOne(diaryDto);
	}
	
	public int insert(DiaryDto diaryDto) {
		return diaryDao.insert(diaryDto);
	}
	
	public int update(DiaryDto diaryDto) {
		return diaryDao.update(diaryDto);
	}

}
