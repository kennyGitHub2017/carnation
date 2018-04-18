package com.sinco.carnation.express.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.constants.EcCommonConstants;
import com.sinco.carnation.shop.dao.EcCommonDao;
import com.sinco.carnation.shop.dao.ExpressCompanyDao;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.vo.EcCommonVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional
public class ExpressCompanyCommonService {
	@Autowired
	private EcCommonDao expressCompanyCommonDao;
	@Autowired
	private ExpressCompanyDao expressCompanyDao;

	public boolean save(EcCommon expressCompanyCommon) {
		/**
		 * init other field here
		 */
		try {
			this.expressCompanyCommonDao.save(expressCompanyCommon);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public EcCommon getObjById(Long id) {
		EcCommon expressCompanyCommon = this.expressCompanyCommonDao.get(id);
		if (expressCompanyCommon != null) {
			return expressCompanyCommon;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.expressCompanyCommonDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> expressCompanyCommonIds) {
		// TODO Auto-generated method stub
		for (Serializable id : expressCompanyCommonIds) {
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
//		GenericPageList pList = new GenericPageList(EcCommon.class,
//				construct, query, params, this.expressCompanyCommonDao);
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

	public boolean update(EcCommon expressCompanyCommon) {
		try {
			this.expressCompanyCommonDao.update(expressCompanyCommon);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<EcCommon> query(String query, Map params,
//			int begin, int max) {
//		return this.expressCompanyCommonDao.query(query, params, begin, max);
//
//	}

	public List<EcCommonBO> selectAllByEccType(Integer eccType) {
		return this.expressCompanyCommonDao.selectAllByCondition(eccType, null, null, null);
	}

	public List<EcCommonBO> selectAllByCondition(Integer eccType, Integer eccDefault) {
		return this.expressCompanyCommonDao.selectAllByCondition(eccType, eccDefault, null, null);
	}

	public List<EcCommonBO> selectAllByCondition(Integer eccType, Integer eccDefault, Long eccStoreId) {
		return this.expressCompanyCommonDao.selectAllByCondition(eccType, eccDefault, eccStoreId, null);
	}

	public List<EcCommonBO> selectAllByCondition(Integer eccType, Long eccStoreId) {
		return this.expressCompanyCommonDao.selectAllByCondition(eccType, null, eccStoreId, null);
	}

	public List<EcCommonBO> selectAllByCondition(Integer eccType, Long eccStoreId, Long eccEcId) {
		return this.expressCompanyCommonDao.selectAllByCondition(eccType, null, eccStoreId, eccEcId);
	}

	/**
	 * 保存常用物流
	 * 
	 * @param ecIds
	 * @return
	 */
	@Transactional(readOnly = false)
	public Boolean ecCommonSave(String[] ecIds) {
		if (ecIds != null && ecIds.length > 0) {
			List<Long> idList = new ArrayList<Long>(ecIds.length);
			for (String ecId : ecIds) {
				idList.add(CommUtil.null2Long(ecId));
			}
			// 删除自营类型的常用物流，由于自营的只有自己一家，所以不传快递公司的ID
			this.expressCompanyCommonDao.delete(null, EcCommonConstants.ECC_TYPE_SELF);
			for (Long eccId : idList) {
				ExpressCompanyBO ec = this.expressCompanyDao.get(eccId);
				if (ec != null) {
					EcCommon ecc = new EcCommon();
					ecc.setAddTime(new Date());
					ecc.setEccCode(ec.getCompanyMark());
					ecc.setEccEcId(ec.getId());
					ecc.setEccName(ec.getCompanyName());
					ecc.setEccTemplate(ec.getCompanyTemplate());
					ecc.setEccTemplateHeigh(ec.getCompanyTemplateHeigh());
					ecc.setEccTemplateWidth(ec.getCompanyTemplateWidth());
					ecc.setEccTemplateOffset(ec.getCompanyTemplateOffset());
					ecc.setEccType(EcCommonConstants.ECC_TYPE_SELF);
					ecc.setDeleteStatus(EcCommonConstants.ECC_DELETE_STATUS_FALSE);
					ecc.setEccEcType(ec.getCompanyType());
					this.expressCompanyCommonDao.save(ecc);
				}
			}
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@SuppressWarnings("unused")
	public void findListByVo(MyPage<EcCommonBO> page, EcCommonVO vo) {
		List<EcCommonBO> result = this.expressCompanyCommonDao.findListByVo(page, vo);
	}
}
