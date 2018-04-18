package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.bo.StoreAdjustInfoBO;
import com.sinco.carnation.store.dao.StoreAdjustInfoDao;
import com.sinco.carnation.store.model.StoreAdjustInfo;
import com.sinco.carnation.store.vo.StoreAdjustInfoVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class StoreAdjustInfoService {

	@Autowired
	private StoreAdjustInfoDao storeAdjustInfoDao;

	public boolean save(StoreAdjustInfo storeAdjustInfo) {
		/**
		 * init other field here
		 */
		try {
			this.storeAdjustInfoDao.save(storeAdjustInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StoreAdjustInfo getObjById(Long id) {
		StoreAdjustInfo storeAdjustInfo = this.storeAdjustInfoDao.get(id);
		if (storeAdjustInfo != null) {
			return storeAdjustInfo;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storeAdjustInfoDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storeAdjustInfoIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storeAdjustInfoIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StoreAdjustInfo storeAdjustInfo) {
		try {
			this.storeAdjustInfoDao.update(storeAdjustInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void findPageByVO(MyPage<StoreAdjustInfoBO> page, StoreAdjustInfoVO vo) {
		// 暂时没有查询条件，先这样写
		List<StoreAdjustInfoBO> content = this.storeAdjustInfoDao.findAll();
		page.setContent(content);
	}

	public List<StoreAdjustInfo> findListByVo(StoreAdjustInfoVO vo) {
		return storeAdjustInfoDao.findListByVo(vo);
	}

	public void deletes(List<StoreAdjustInfo> infos) {
		for (StoreAdjustInfo info : infos) {
			this.delete(info.getId());
		}
	}
}
