package com.sinco.carnation.sys.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.mapper.IncrementMapper;
import com.sinco.carnation.sys.model.Increment;

@Repository
public class IncrementDao {

	@Autowired
	private IncrementMapper mapper;

	public Increment insert(Increment record) {
		mapper.insert(record);
		return record;
	}
}
