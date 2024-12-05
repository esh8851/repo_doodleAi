package com.tele.infra.dreams;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DreamsDao {

	public List<DreamsDto> selectList(DreamsDto dto);
	
	public DreamsDto selectOne(DreamsDto dto);
	
	public int insert(DreamsDto dto);
	
}
