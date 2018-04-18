package com.sinco.carnation.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.ResBO;
import com.sinco.carnation.sys.dao.ResDao;
import com.sinco.carnation.sys.model.Res;

@Service
@Transactional
public class ResService {
	@Autowired
	private ResDao resDAO;

	public List<ResBO> findByValue(String value) {
		return resDAO.findByValue(value);
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		try {
			this.resDAO.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean save(Res res) {
		// TODO Auto-generated method stub
		try {
			this.resDAO.save(res);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Res res) {
		// TODO Auto-generated method stub
		try {
			this.resDAO.update(res);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Res getObjById(Long id) {
		// TODO Auto-generated method stub
		return this.resDAO.get(id);
	}

//	public List<Res> query(String query, Map params, int begin, int max) {
//		// TODO Auto-generated method stub
//		return this.resDAO.query(query, params, begin, max);
//	}
//
//	public IPageList list(IQueryObject properties) {
//		// TODO Auto-generated method stub
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(Res.class, query,construct, params,
//				this.resDAO);
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

}
