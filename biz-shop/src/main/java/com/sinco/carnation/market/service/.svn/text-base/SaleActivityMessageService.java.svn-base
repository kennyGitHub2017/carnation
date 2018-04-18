package com.sinco.carnation.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.dao.ActivitySaleMessageDao;
import com.sinco.carnation.market.vo.ActivitySaleMessageVO;

@Service
@Transactional
public class SaleActivityMessageService {
	@Autowired
	private ActivitySaleMessageDao activitySaleMessageDao;

	public ActivitySaleMessageBO getSaleMessageByActId(Long actId) {
		return activitySaleMessageDao.getSaleMessageByActId(actId);
	}
	
	public ActivitySaleMessageBO getSaleMessageById(Long id) {
		if(id == null){
			return null;
		}
		return activitySaleMessageDao.findOne(id);
	}

	public void save(ActivitySaleMessageVO saleMessage) {
		activitySaleMessageDao.save(saleMessage);
	}

}
