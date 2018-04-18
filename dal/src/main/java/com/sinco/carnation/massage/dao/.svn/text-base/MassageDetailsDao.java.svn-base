package com.sinco.carnation.massage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.massage.mapper.MassageDetailsMapper;
import com.sinco.carnation.massage.model.MassageDetails;

@Repository
public class MassageDetailsDao {

	@Autowired
	private MassageDetailsMapper mapper;

	/**
	 * 保存按摩详细数据
	 * 
	 * @param massage
	 */
	public void save(MassageDetails massageDetails) {
		mapper.insertSelective(massageDetails);
	}

	/**
	 * 根据主键ID查询
	 * 
	 * @param id
	 * @return
	 */
	public MassageDetails getById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据用户ID查询当天数据
	 * 
	 * @param id
	 * @return
	 */
	public MassageDetails getByUserId(Long userId) {
		return mapper.selectByUserId(userId);
	}

	/**
	 * 根据ID更新按摩详细信息
	 * 
	 * @param id
	 * @return
	 */
	public void update(MassageDetails massageDetails) {
		mapper.updateByPrimaryKey(massageDetails);
	}
}
