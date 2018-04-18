package com.sinco.carnation.shop.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.bo.ComplaintSubjectBO;
import com.sinco.carnation.shop.dao.ComplaintSubjectDao;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class ComplaintSubjectService {
	@Autowired
	private ComplaintSubjectDao complaintSubjectDao;

	@Transactional(readOnly = false)
	public void save(ComplaintSubject complaintSubject) {
		this.complaintSubjectDao.save(complaintSubject);
	}

	public ComplaintSubject getObjById(Long id) {
		ComplaintSubject complaintSubject = this.complaintSubjectDao.get(id);
		if (complaintSubject != null) {
			return complaintSubject;
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		complaintSubjectDao.remove(id);
	}

	@Transactional(readOnly = false)
	public void batchDelete(List<Serializable> complaintSubjectIds) {
		// TODO Auto-generated method stub
		for (Serializable id : complaintSubjectIds) {
			delete((Long) id);
		}
	}

	public List<ComplaintSubjectBO> allSeller() {
		return complaintSubjectDao.allSeller();
	}

	@Transactional(readOnly = false)
	public void update(ComplaintSubject complaintSubject) {
		complaintSubjectDao.update(complaintSubject);
	}

	public void queryComplaintPageList(String type, MyPage<ComplaintSubject> page) {
		page.setContent(complaintSubjectDao.queryComplaintPageList(type, page));
	}

	@Transactional(readOnly = false)
	public void deleteComplaint(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			Long[] longIds = new Long[ids.length];
			for (int i = 0; i < longIds.length; i++) {
				longIds[i] = CommUtil.null2Long(ids[i]);
			}
			complaintSubjectDao.deleteComplaint(longIds);
		}
	}

	@Transactional(readOnly = false)
	public void saveComplaint(ComplaintSubject subject) {
		subject.setAddTime(new Date());
		complaintSubjectDao.save(subject);
	}
}
