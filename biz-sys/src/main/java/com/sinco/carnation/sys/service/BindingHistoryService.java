package com.sinco.carnation.sys.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.dao.BindingHistoryDao;
import com.sinco.carnation.sys.model.BindingHistory;

@Service
@Transactional
public class BindingHistoryService {
	@Autowired
	private BindingHistoryDao bindingHistoryDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(BindingHistory record) {
		record.setAddtime(new Date());
		bindingHistoryDao.save(record);
	}
}
