package com.sinco.carnation.healthcircle.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.healthcircle.bo.BlacklistBO;
import com.sinco.carnation.healthcircle.dao.BlacklistDao;
import com.sinco.carnation.healthcircle.model.BlacklistPO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class BlacklistService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BlacklistDao blacklistDao;

	/**
	 * 分页获取黑名单列表
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<BlacklistBO> findByPage(MyPage<BlacklistPO> page) {
		List<BlacklistBO> blacklists = blacklistDao.findAllBlacklist(page);
		for (BlacklistBO item : blacklists) {
			// 如果不是CN账号，cnAccount字段为空
			if (null == item.getCnAccount() || !item.getCnAccount().startsWith(UserContant.ACCOUNT_TYPE_CN)) {
				item.setCnAccount("");
			}
		}
		return blacklists;
	}

	/**
	 * 添加黑名单
	 * 
	 * @param uid
	 * @return
	 */
	public void save(Long userId) {
		// 判断该用户是不是已是黑名单
		BlacklistBO query = blacklistDao.getBlacklistByUid(userId);
		// 如果不是黑名单则添加进黑名单中
		if (null != query) {// 存在则修改deleteStatus 为 0
			BlacklistPO item = new BlacklistPO();
			item.setDeleteStatus(CommUtil.null2Long(0));
			item.setId(query.getId());
			item.setUserId(query.getUserId());
			item.setCreateTime(query.getCreateTime());
			blacklistDao.update(item);
		} else if (null == query && 0 < userId) { // 如果不存在则添加
			BlacklistPO item = new BlacklistPO();
			item.setUserId(userId);
			blacklistDao.save(item);
		}
	}

	/**
	 * 解除黑名单(修改deleteStatus 为 1则为删除)
	 * 
	 * @param uid
	 * @return
	 */
	public void deleteBlacklist(Long id) {
		// 判断该用户是不是已是黑名单
		BlacklistPO item = new BlacklistPO();
		item.setId(id);
		item.setDeleteStatus(CommUtil.null2Long(1));
		// 删除黑名单
		blacklistDao.update(item);

	}

	/**
	 * 根据用户ID获取黑名单信息
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public BlacklistBO getBlacklistByUid(Long uid) {
		return blacklistDao.getBlacklistByUid(uid);
	}

}
