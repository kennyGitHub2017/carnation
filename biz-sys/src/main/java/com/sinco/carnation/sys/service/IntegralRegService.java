package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.IntegralRegBO;
import com.sinco.carnation.sys.dao.IntegralRegDao;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class IntegralRegService {

	@Autowired
	private IntegralRegDao integralRegDao;

	public IntegralReg getObjByType(String type) {
		return this.integralRegDao.findByType(type);
	}

	public boolean save(IntegralReg integralReg) {
		try {
			this.integralRegDao.save(integralReg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public IntegralReg getObjById(Long id) {
		IntegralReg integralReg = this.integralRegDao.get(id);
		if (integralReg != null) {
			return integralReg;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.integralRegDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> integralRegIds) {
		for (Serializable id : integralRegIds) {
			delete((Long) id);
		}
		return true;
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(Template.class,construct, query,
//				params, this.templateDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(
//						pageObj.getCurrentPage() == null ? 0 : pageObj
//								.getCurrentPage(),
//						pageObj.getPageSize() == null ? 0 : pageObj
//								.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(IntegralReg integralReg) {
		try {
			this.integralRegDao.update(integralReg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<Template> query(String query, Map params, int begin, int max) {
//		return this.templateDao.query(query, params, begin, max);
//
//	}

//	@Override
//	public Template getObjByProperty(String construct, String propertyName,
//			Object value) {
//		// TODO Auto-generated method stub
//		return this.templateDao.getBy(construct, propertyName, value);
//	}

	public List<IntegralRegBO> selectListByVO(MyPage<IntegralRegBO> page, IntegralRegVO vo) {
		List<IntegralRegBO> list = this.integralRegDao.selectListByVO(page, vo);
		page.setContent(list);
		return list;
	}

	public boolean checkIntegral(IntegralRegVO vo) {
		List<IntegralRegBO> list = this.integralRegDao.checkIntegral(vo);
		return list != null && list.size() > 0 ? false : true;
	}
	
	public List<IntegralRegBO> findAll(){
		return this.integralRegDao.findAll();
	}
	
	public List<IntegralRegBO> selectAllType(){
		return this.integralRegDao.selectAllType();
	}
}
