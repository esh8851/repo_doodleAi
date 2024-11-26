package com.tele.infra.comm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommService {
	
	@Autowired
	CommDao commDao;
	
	List<CommDto> selectList(){
		return commDao.selectList();
	}
	
	public CommDto selectOne(CommDto commDto) {
		return commDao.selectOne(commDto);
	}
	
}
