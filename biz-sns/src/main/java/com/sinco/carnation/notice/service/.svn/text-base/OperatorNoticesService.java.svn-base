package com.sinco.carnation.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.dao.OperatorNoticesDao;
import com.sinco.carnation.sns.model.OperatorNotices;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class OperatorNoticesService {

	@Autowired
	private OperatorNoticesDao operateNoticesDao;

	public MyPage<OperatorNoticesBO> findPageByVO(OperatorNoticesVO vo, MyPage<OperatorNoticesBO> page) {
		operateNoticesDao.findList(vo, page);
		return page;
	}

	public OperatorNoticesBO getBoById(Long id) {
		return operateNoticesDao.get(id);
	}

	public OperatorNoticesBO getBoDataById(Long id) {
		return operateNoticesDao.getBo(id);
	}

	public boolean save(OperatorNotices operatorNotices) {
		/**
		 * init other field here
		 */
		try {
			this.operateNoticesDao.save(operatorNotices);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Long id) {
		try {
			this.operateNoticesDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(OperatorNotices operatorNotices) {
		try {
			this.operateNoticesDao.update(operatorNotices);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean audit(OperatorNotices operatorNotices, int status) {
		try {
			operatorNotices.setNtStatus(status);
			this.operateNoticesDao.update(operatorNotices);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void queryNoticesList(Long opertorId, MyPage<OperatorNoticesBO> page) {
		page.setContent(operateNoticesDao.queryNoticesList(opertorId, page));
	}
}
