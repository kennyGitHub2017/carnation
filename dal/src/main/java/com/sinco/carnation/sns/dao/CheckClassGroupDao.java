package com.sinco.carnation.sns.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.mapper.CheckClassGroupMapper;
import com.sinco.carnation.sns.model.CheckClassGroup;

@Repository
public class CheckClassGroupDao {

	@Autowired
	private CheckClassGroupMapper mapper;

	public int insertSelective(CheckClassGroup record) {
		return mapper.insertSelective(record);
	}

	public int updateClassByGroupId(Long newClassId, Long oldClassId, Long groupId) {
		return mapper.updateClassByGroupId(newClassId, oldClassId, groupId);
	}
}
