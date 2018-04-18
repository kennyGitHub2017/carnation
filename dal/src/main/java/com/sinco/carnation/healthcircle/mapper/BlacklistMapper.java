package com.sinco.carnation.healthcircle.mapper;

import java.util.List;

import com.sinco.carnation.healthcircle.bo.BlacklistBO;
import com.sinco.carnation.healthcircle.model.BlacklistPO;
import com.sinco.dal.common.MyPage;

public interface BlacklistMapper {

	/**
	 * 添加黑名单
	 * 
	 * @param blacklist
	 * @return
	 */
	int add(BlacklistPO blacklist);

	/**
	 * 修改黑名单
	 * 
	 * @param record
	 * @param example
	 * @return
	 */
	int update(BlacklistPO blacklist);

	/**
	 * 分页获取所有黑名单列表
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	List<BlacklistBO> findAllBlacklist(MyPage<BlacklistPO> page);

	/**
	 * 通过用户ID获取黑名单
	 * 
	 * @param uid
	 * @return
	 */
	BlacklistBO getBlacklistByUid(Long uid);

}