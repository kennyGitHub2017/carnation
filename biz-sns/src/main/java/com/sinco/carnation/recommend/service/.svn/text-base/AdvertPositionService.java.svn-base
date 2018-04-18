package com.sinco.carnation.recommend.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.dao.AdvertPositionDao;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sns.vo.AdvertPositionVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class AdvertPositionService {

	@Autowired
	private AdvertPositionDao advertPositionDao;

	/**
	 * find by ap_type
	 * 
	 * @param type
	 * @param status
	 * @return
	 */
	public List<AdvertPosition> findByTypeAndlLocation(String type, String location, Integer width,
			Integer height, Integer status) {
		return advertPositionDao.findByTypeAndlLocation(type, location, width, height, status);
	}

	/**
	 * find by ap_type
	 * 
	 * @param type
	 * @param status
	 * @return
	 */
	public List<AdvertPosition> findByType(String type, Integer status) {
		return advertPositionDao.findByType(type, status);
	}

	public boolean save(AdvertPosition advertPosition) {
		/**
		 * init other field here
		 */
		try {
			this.advertPositionDao.save(advertPosition);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据标识查找
	 * 
	 * @param code
	 * @return
	 */
	public AdvertPosition findByCode(String code) {
		return this.advertPositionDao.findByCode(code);
	}

	public AdvertPosition getObjById(Long id) {
		return this.advertPositionDao.get(id);
	}

	public boolean delete(Long id) {
		try {
			AdvertPosition advertPosition = this.advertPositionDao.get(id);
			if (advertPosition.getApSysType() != AdvertContant.IS_AP_SYS_TYPE) {
				this.advertPositionDao.remove(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> advertPositionIds) {
		// TODO Auto-generated method stub
		for (Serializable id : advertPositionIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(AdvertPosition advertPosition) {
		try {
			this.advertPositionDao.update(advertPosition);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<AdvertPosition> findList() {
		return advertPositionDao.findAll();
	}

	public List<AdvertPosition> findByRelease(int releaseType) {
		return advertPositionDao.findByRelease(releaseType);
	}

	/* grey added begin */
	@Transactional(readOnly = true)
	public MyPage<AdvertPosition> findPageByVO(AdvertPositionVO vo, MyPage<AdvertPosition> page) {
		List<AdvertPosition> list = advertPositionDao.findList(vo, page);
		page.setContent(list);
		return page;
	}

	public List<AdvertPosition> findAll() {
		return advertPositionDao.findList();
	}

	public List<AdvertPosition> findByApCode(String apCode) {
		return advertPositionDao.findByApCode(apCode);
	}

	/* grey added end */

	public boolean updateStatuaById(int status, int id) {
		try {
			this.advertPositionDao.updateStatusById(status, id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
