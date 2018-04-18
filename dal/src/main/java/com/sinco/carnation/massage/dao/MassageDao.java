package com.sinco.carnation.massage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.massage.mapper.MassageMapper;
import com.sinco.carnation.massage.model.Massage;

@Repository
public class MassageDao {

	@Autowired
	private MassageMapper mapper;

	/**
	 * 保存按摩数据
	 * 
	 * @param massage
	 */
	public void save(Massage massage) {
		mapper.insertSelective(massage);
	}

	/**
	 * 根据主键ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Massage getById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据用户ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Massage getByUserId(Long userId) {
		return mapper.selectByUserId(userId);
	}
	
	/**
	 * 根据ID更新按摩信息
	 * 
	 * @param id
	 * @return
	 */
	public void update(Massage massage) {
		 mapper.updateByPrimaryKey(massage);
	}
	
}
