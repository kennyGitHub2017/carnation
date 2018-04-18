package com.sinco.carnation.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.dao.RedPackageGetRecordDao;
import com.sinco.carnation.market.vo.RedPackageGetRecordVO;
import com.sinco.dal.common.MyPage;

/**
 * 红包领取相关Service
 * 
 */
@Service
public class RedPackageGetService {

	@Autowired
	RedPackageGetRecordDao redPackageGetRecordDao;

	public List<RedPackageGetRecordBO> findAllByPage(RedPackageGetRecordVO vo,
			MyPage<RedPackageGetRecordBO> page) {
		return this.redPackageGetRecordDao.findAllByPage(vo, page);
	}

	public RedPackageGetRecordBO findRedPackageGetRecordById(Long id) {
		return this.redPackageGetRecordDao.findOne(id);
	}

}
