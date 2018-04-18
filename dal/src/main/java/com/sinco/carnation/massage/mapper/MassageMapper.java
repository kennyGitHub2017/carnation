package com.sinco.carnation.massage.mapper;

import com.sinco.carnation.massage.model.Massage;

public interface MassageMapper {

	int insertSelective(Massage massage);

	Massage selectByPrimaryKey(Long id);

	Massage selectByUserId(Long userId);
	
	void updateByPrimaryKey(Massage massage);
}