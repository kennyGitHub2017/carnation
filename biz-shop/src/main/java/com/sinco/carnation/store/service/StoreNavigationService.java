package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.bo.StoreNavigationBO;
import com.sinco.carnation.store.dao.StoreNavigationDao;
import com.sinco.carnation.store.model.StoreNavigation;
import com.sinco.carnation.store.vo.StoreNavigationVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class StoreNavigationService {
	@Autowired
	private StoreNavigationDao storeNavigationDao;

	public List<StoreNavigationBO> findAllByStoreId(Long storeId) {
		return storeNavigationDao.findAllByStoreId(storeId);
	}

	public boolean save(StoreNavigation storeNavigation) {
		/**
		 * init other field here
		 */
		try {
			this.storeNavigationDao.save(storeNavigation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StoreNavigation getObjById(Long id) {
		StoreNavigation storeNavigation = this.storeNavigationDao.get(id);
		if (storeNavigation != null) {
			return storeNavigation;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storeNavigationDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storeNavigationIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storeNavigationIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StoreNavigation storeNavigation) {
		try {
			this.storeNavigationDao.update(storeNavigation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void findListByVo(MyPage<StoreNavigationBO> page, StoreNavigationVO vo) {
		storeNavigationDao.findListByVo(page, vo);
	}
}
