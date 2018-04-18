package com.sinco.carnation.sns.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.CheckGroupResultBO;
import com.sinco.carnation.sns.mapper.CheckGroupResultMapper;
import com.sinco.carnation.sns.model.CheckGroupResult;

@Repository
public class CheckGroupResultDao {

	@Autowired
	private CheckGroupResultMapper mapper;

	public List<CheckGroupResultBO> findListByGroup(Long groupId) {
		return mapper.selectAllByGroupId(groupId);
	}

	public int insertSelective(CheckGroupResult record) {
		return mapper.insertSelective(record);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int updateById(CheckGroupResult record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public CheckGroupResultBO findById(Long id) {
		return mapper.selectById(id);
	}

	public Integer selectMaxEndScoreByGroup(Long groupId) {
		return mapper.selectMaxEndScoreByGroup(groupId);
	}

	public Integer findExistsRecordHistory(Long userId, Long groupId) {
		return mapper.findExistsRecordHistory(userId, groupId);
	}
}
