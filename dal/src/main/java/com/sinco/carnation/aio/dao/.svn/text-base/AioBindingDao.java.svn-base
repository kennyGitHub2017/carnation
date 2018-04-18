package com.sinco.carnation.aio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.aio.mapper.AioBindingMapper;
import com.sinco.carnation.aio.model.AioBinding;

@Repository
public class AioBindingDao {

	@Autowired
	private AioBindingMapper mapper;

	/**
	 * 根据用户ID获取绑定信息
	 * 
	 * @param uid
	 * @return
	 */
	public AioBinding getAioBindingByUid(Long uid) {
		return mapper.queryByUid(uid);
	}
	
	/**
	 * 保存绑定信息
	 * 
	 * @param aioBinding
	 */
	public void saveAioBinding(AioBinding aioBinding) {
		mapper.insertSelective(aioBinding);
	}
	
	/**
	 * 更新绑定信息
	 * 
	 * @param order
	 */
	public void updateAioBinding(AioBinding aioBinding) {
		mapper.updateByPrimaryKeySelective(aioBinding);
	}
}
