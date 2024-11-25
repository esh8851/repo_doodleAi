package com.tele.infra.comm;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CommDao {
	
	List<CommDto> selectList();
	
	
}
