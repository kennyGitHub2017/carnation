package com.sinco.carnation.express.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.dao.ExpressCompanyDao;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class ExpressCompanyService {
	@Autowired
	private ExpressCompanyDao expressCompanyDao;

	public boolean save(ExpressCompany expressCompany) {
		/**
		 * init other field here
		 */
		try {
			this.expressCompanyDao.save(expressCompany);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ExpressCompany getObjById(Long id) {
		ExpressCompany expressCompany = this.expressCompanyDao.get(id);
		if (expressCompany != null) {
			return expressCompany;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.expressCompanyDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> expressCompanyIds) {
		// TODO Auto-generated method stub
		for (Serializable id : expressCompanyIds) {
			delete((Long) id);
		}
		return true;
	}

	// public IPageList list(IQueryObject properties) {
	// if (properties == null) {
	// return null;
	// }
	// String query = properties.getQuery();
	// String construct = properties.getConstruct();
	// Map params = properties.getParameters();
	// GenericPageList pList = new GenericPageList(ExpressCompany.class,
	// construct, query, params, this.expressCompanyDao);
	// if (properties != null) {
	// PageObject pageObj = properties.getPageObj();
	// if (pageObj != null)
	// pList.doList(
	// pageObj.getCurrentPage() == null ? 0 : pageObj
	// .getCurrentPage(),
	// pageObj.getPageSize() == null ? 0 : pageObj
	// .getPageSize());
	// } else
	// pList.doList(0, -1);
	// return pList;
	// }

	/**
	 * 快递公司列表
	 * 
	 * @param page
	 */
	public void queryExpressCompany(MyPage<ExpressCompanyBO> page) {
		page.setContent(expressCompanyDao.queryExpressCompanyPage(page));
	}

	/**
	 * 根据id查询快递公司
	 * 
	 * @param id
	 * @return
	 */
	public ExpressCompanyBO queryExpressCompanyById(Long id) {
		return expressCompanyDao.findOne(id);
	}

	/**
	 * 保存快递公司信息
	 * 
	 * @param company
	 */
	@Transactional(readOnly = false)
	public void saveExpressCompany(ExpressCompany company) {
		if (null != company.getId()) {
			expressCompanyDao.update(company);
		} else {
			company.setAddTime(new Date());
			expressCompanyDao.save(company);
		}
	}

	/**
	 * 快递公司删除
	 * 
	 * @param mulitId
	 */
	@Transactional(readOnly = false)
	public void deleteExpressCompanyById(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			Long[] longIds = new Long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				longIds[i] = CommUtil.null2Long(ids[i]);
			}
			expressCompanyDao.deleteExpressCompanyById(longIds);
		}
	}

	@Transactional(readOnly = false)
	public void update(ExpressCompany expressCompany) {
		expressCompanyDao.update(expressCompany);
	}

	public List<ExpressCompanyBO> findListByStatus(Integer companyStatus) {
		return expressCompanyDao.findListByStatus(companyStatus);
	}
}
