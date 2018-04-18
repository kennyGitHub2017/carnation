package com.sinco.carnation.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.SysLogBO;
import com.sinco.carnation.sys.dao.SysLogDao;
import com.sinco.carnation.sys.model.SysLog;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class SysLogServiceImpl {

	@Autowired
	private SysLogDao sysLogDao;

	public MyPage<SysLogBO> list(MyPage<SysLogBO> page) {
		sysLogDao.findByPage(page);
		return page;
	}

	public boolean save(SysLog sysLog) {
		/**
		 * init other field here
		 */
		try {
			this.sysLogDao.save(sysLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public SysLog getObjById(Long id) {
		SysLog sysLog = this.sysLogDao.get(id);
		if (sysLog != null) {
			return sysLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.sysLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void batchDelete(List<Long> sysLogIds) {

		sysLogDao.deleteByIds(sysLogIds);

	}

	public void deleteAll() {
		sysLogDao.deleteAll();
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(SysLog.class,construct, query,
//				params, this.sysLogDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
//						.getCurrentPage(), pageObj.getPageSize() == null ? 0
//						: pageObj.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(SysLog sysLog) {
		try {
			this.sysLogDao.update(sysLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<SysLog> query(String query, Map params, int begin, int max) {
//		return this.sysLogDao.query(query, params, begin, max);
//
//	}

	public SysLog querySysLogByUid(Long uid) {
		return this.sysLogDao.selectOneByUid(uid);
	}

}
