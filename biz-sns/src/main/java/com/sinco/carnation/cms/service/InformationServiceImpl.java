package com.sinco.carnation.cms.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sns.bo.InformationBO;
import com.sinco.carnation.sns.contants.InformationContant;
import com.sinco.carnation.sns.dao.InformationDao;
import com.sinco.carnation.sns.model.Information;
import com.sinco.carnation.sns.vo.InformationVO;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class InformationServiceImpl {

	@Autowired
	private InformationDao informationDao;

	@Autowired
	private InformationClassServiceImpl informationClassService;

	public boolean save(Information information) {
		/**
		 * init other field here
		 */
		try {
			this.informationDao.save(information);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Information getObjById(Long id) {
		Information information = this.informationDao.get(id);
		if (information != null) {
			return information;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.informationDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> informationIds) {
		// TODO Auto-generated method stub
		for (Serializable id : informationIds) {
			delete((Long) id);
		}
		return true;
	}

	@Transactional
	public void batchDelete(String[] ids, Long userId) {
		if (null != ids && ids.length > 0) {
			for (String idStr : ids) {
				Information information = new Information();
				information.setId(CommUtil.null2Long(idStr));
				information.setDeleteStatus(InformationContant.IS_DELETED);
				informationDao.update(information);
			}
		}
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(Information.class,construct, query,
//				params, this.informationDao);
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

	public boolean update(Information information) {
		try {
			this.informationDao.update(information);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<InformationBO> selectByClassId(Long classId) {
		return informationDao.selectByClassId(classId);
	}

	public List<InformationBO> selectPageByClassId(Long classId, MyPage<InformationBO> page) {
		return informationDao.selectPageByClassId(classId, page);
	}

//	public List<Information> query(String query, Map params, int begin, int max){
//		return this.informationDao.query(query, params, begin, max);
//		
//	}

	public MyPage<InformationBO> queryList(InformationVO vo, MyPage<InformationBO> page) {
		if (vo.getClassid() != null) {
			List<Long> classIds = informationClassService.getChildsByClassId(vo.getClassid());
			if (null != classIds && classIds.size() > 0) {
				vo.setClassIds(classIds);
			}
		}

		if (null != vo.getStatus()) {
			vo.setVerifyStatus(new ArrayList<Integer>());
			vo.getVerifyStatus().add(vo.getStatus());
		}
		List<InformationBO> list = informationDao.selectByList(vo, page);
		page.setContent(list);
		return page;
	}

	public void addInformation(InformationVO vo, Long userId) {
		Information information = new Information();
		BeanUtils.copyProperties(vo, information);
		information.setAddTime(new Date());
		information.setAuthorId(userId);
		information.setDeleteStatus(InformationContant.NOT_DELETED);
		information.setType(InformationContant.TYPE_2);
		information.setStatus(InformationContant.STATUS_10);
		information.setClicktimes(0);
		information.setSequence(0);
		informationDao.add(information);
	}

	public void updateInformation(InformationVO vo, Long userId) {
		Information information = new Information();
		BeanUtils.copyProperties(vo, information);
		informationDao.update(information);
	}

	public InformationBO findById(Long id) {
		return informationDao.selectById(id);
	}

	public void verifyInformation(InformationVO vo) {
		Information information = new Information();
		information.setId(vo.getId());
		information.setStatus(vo.getStatus());
		if (StringUtils.isNotBlank(vo.getFailreason())) {
			information.setFailreason(vo.getFailreason());
		}
		informationDao.update(information);
	}
}
