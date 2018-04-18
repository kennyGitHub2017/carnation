package com.sinco.carnation.check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.user.bo.CheckResultHistoryBO;
import com.sinco.carnation.user.dao.CheckResultHistoryDao;
import com.sinco.dal.common.MyPage;

@Service
public class CheckResultHistoryService {

	@Autowired
	private CheckResultHistoryDao checkResultHistoryDao;

	public MyPage<CheckResultHistoryBO> findPageByUserId(Long userId, MyPage<CheckResultHistoryBO> page) {
		List<CheckResultHistoryBO> list = checkResultHistoryDao.findPageByUserId(userId, page);
		page.setContent(list);
		return page;
	}
}
