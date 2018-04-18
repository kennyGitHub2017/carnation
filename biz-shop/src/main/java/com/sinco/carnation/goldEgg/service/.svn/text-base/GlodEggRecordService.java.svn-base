package com.sinco.carnation.goldEgg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.dao.GlodEggRecordDao;
import com.sinco.carnation.goldEgg.vo.GlodEggRecordVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GlodEggRecordService {

	@Autowired
	private GlodEggRecordDao glodEggRecordDao;

	public void findPageByVO(MyPage<GlodEggRecordBO> page, GlodEggRecordVO vo) {
		this.glodEggRecordDao.findPageByVO(page, vo);
	}
}
