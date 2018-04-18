package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.dao.StoreSlideDao;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.store.vo.StoreSlideVO;

@Service
@Transactional
public class StoreSlideService {

	@Autowired
	private StoreSlideDao storeSlideDao;

	public boolean save(StoreSlide storeSlide) {
		/**
		 * init other field here
		 */
		try {
			this.storeSlideDao.save(storeSlide);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StoreSlide getObjById(Long id) {
		StoreSlide storeSlide = this.storeSlideDao.get(id);
		if (storeSlide != null) {
			return storeSlide;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storeSlideDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storeSlideIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storeSlideIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StoreSlide storeSlide) {
		try {
			this.storeSlideDao.update(storeSlide);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<StoreSlide> findListByVo(StoreSlideVO vo) {
		return storeSlideDao.findListByVo(vo);
	}
}
