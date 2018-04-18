package com.sinco.carnation.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.bo.CheckResultReplyBO;
import com.sinco.carnation.sns.dao.CheckResultReplyDao;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = false)
public class CheckReportService {

	@SuppressWarnings("unused")
	private Logger loger = LoggerFactory.getLogger(CheckReportService.class);

	@Autowired
	private CheckResultReplyDao checkReportDao;

	public void checkReportList(Long uid, MyPage<CheckResultReplyBO> page) {
		List<CheckResultReplyBO> list = checkReportDao.checkReportList(uid, page);
		page.setContent(list);

	}

}
