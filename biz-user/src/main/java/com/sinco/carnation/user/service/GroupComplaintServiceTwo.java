package com.sinco.carnation.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.dao.GroupComplaintDao;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = false)
public class GroupComplaintServiceTwo {

	@SuppressWarnings("unused")
	private Logger loger = LoggerFactory.getLogger(GroupComplaintServiceTwo.class);

	@Autowired
	private GroupComplaintDao groupComplaintDao;

	/**
	 * 我的运营商投诉列表
	 * 
	 * @param uid
	 * @param page
	 */
	public void groupComplaintList(int status, String name, java.lang.Long id, MyPage<GroupComplaintBO> page) {
		List<GroupComplaintBO> list = groupComplaintDao.groupComplaintList(status, name, id, page);
		page.setContent(list);

	}

}
