package com.sinco.carnation.aio.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.aio.dao.AioBindingDao;
import com.sinco.carnation.aio.model.AioBinding;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class AioBindingService {
	@Autowired
	private AioBindingDao aioBindingDao;

	public AioBinding getAioBindingByUid(Long uid) {
		// 根据uid获取绑定信息
		AioBinding result = aioBindingDao.getAioBindingByUid(uid);
		return result;
	}

	public int saveAioBinding(AioBinding aioBinding) {
		// 校验参数
		if (null == aioBinding || !CommUtil.isNotNull(aioBinding.getUid())
				|| !CommUtil.isNotNull(aioBinding.getIdCard())) {
			return 101;
		}
		Long uid = aioBinding.getUid();
		// 根据uid获取绑定信息
		AioBinding result = aioBindingDao.getAioBindingByUid(uid);
		// 绑定次数
		int updateNum = 0;
		if (null == result) {
			// uid无绑定信息则添加
			aioBindingDao.saveAioBinding(aioBinding);
		} else if (result.getUpdateNum() >= 3) {
			return 102;
		} else {
			// 已存在绑定信息则更新
			updateNum = result.getUpdateNum() + 1;
			result.setIdCard(aioBinding.getIdCard());
			result.setLastUpdateTime(CommUtil.formatLongDate(new Date()));
			result.setUpdateNum(updateNum);
			aioBindingDao.updateAioBinding(result);
			
		}
		return updateNum;
	}
}
