package com.sinco.carnation.healthcircle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.healthcircle.bo.BlacklistBO;
import com.sinco.carnation.healthcircle.mapper.BlacklistMapper;
import com.sinco.carnation.healthcircle.model.BlacklistPO;
import com.sinco.dal.common.MyPage;

@Repository
public class BlacklistDao {

	@Autowired
	private BlacklistMapper mapper;

	public void save(BlacklistPO blacklist) {
		mapper.add(blacklist);
	}

	public void update(BlacklistPO blacklist) {
		mapper.update(blacklist);
	}

	public BlacklistBO getBlacklistByUid(java.lang.Long uid) {
		return mapper.getBlacklistByUid(uid);
	}

	public List<BlacklistBO> findAllBlacklist(MyPage<BlacklistPO> page) {
		return mapper.findAllBlacklist(page);
	}
}
