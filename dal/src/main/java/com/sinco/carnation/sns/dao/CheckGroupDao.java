package com.sinco.carnation.sns.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.mapper.CheckGroupMapper;
import com.sinco.carnation.sns.model.CheckGroup;
import com.sinco.carnation.sns.model.CheckGroupExample;
import com.sinco.carnation.sns.vo.CheckGroupVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckGroupDao {

	@Autowired
	private CheckGroupMapper mapper;

	public List<CheckGroupBO> findList(CheckGroupVO vo, MyPage<CheckGroupBO> page) {
		return mapper.selectByList(vo, page);
	}

	public void addCheckGroup(CheckGroup checkGroup) {
		mapper.insertSelective(checkGroup);
	}

	public void updateById(CheckGroup checkGroup) {
		mapper.updateByPrimaryKeySelective(checkGroup);
	}

	public void delete(Long groupId, Long userId) {
		CheckGroup checkGroup = new CheckGroup();
		checkGroup.setId(groupId);
		checkGroup.setIsDeleted(true);
		checkGroup.setUpdateBy(userId);
		checkGroup.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(checkGroup);
	}

	public CheckGroupBO selectById(Long id) {
		return mapper.selectById(id);
	}

	public int insertSelective(CheckGroup record) {
		return mapper.insertSelective(record);
	}

	public CheckGroup selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<CheckGroup> findBySequence(Long id) {
		CheckGroupExample example = new CheckGroupExample();
		example.createCriteria().andCheckGroupSequenceEqualTo(id);
		return mapper.selectByExample(example);
	}

}
