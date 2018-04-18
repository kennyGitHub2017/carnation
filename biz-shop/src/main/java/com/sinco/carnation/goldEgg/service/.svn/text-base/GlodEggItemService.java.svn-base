package com.sinco.carnation.goldEgg.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.dao.GlodEggItemDao;
import com.sinco.carnation.goldEgg.model.GlodEggItem;

@Service
@Transactional
public class GlodEggItemService {

	@Autowired
	private GlodEggItemDao glodEggItemDao;

	public GlodEggItem save(GlodEggItem record) {
		return this.glodEggItemDao.save(record);
	}

	/**
	 * 保存活动拆金蛋奖品项
	 * 
	 * @param actGlodEggID
	 *            活动ID
	 * @param num
	 *            产生奖品项的数量
	 * @return
	 */
	public int save(Long actGlodEggID, Integer num) {
		if (num == null || num == 0) {
			num = 3;
		}
		GlodEggItem glodEggItem01 = null;
		for (int i = 0; i < num; i++) {
			glodEggItem01 = new GlodEggItem();
			glodEggItem01.setGlodEggId(actGlodEggID);
			glodEggItem01.setCreateTime(new Date());
			glodEggItem01.setCreateBy(0L);
			this.save(glodEggItem01);
		}
		return 0;
	}

	public List<GlodEggItemBO> findByGlodEggID(Long actGlodEggID) {
		return this.glodEggItemDao.findByGlodEggID(actGlodEggID);
	}

	public void update(GlodEggItem record) {
		this.glodEggItemDao.update(record);
	}
}
