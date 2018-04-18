package com.sinco.carnation.tips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.dao.TipsDao;
import com.sinco.carnation.sns.model.Tips;

@Service
@Transactional
public class TipsServiceImpl {

	@Autowired
	private TipsDao tipsDao;

	@Transactional(readOnly = false)
	public boolean save(Tips tips) {
		/**
		 * init other field here
		 */
		try {
			this.tipsDao.save(tips);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
