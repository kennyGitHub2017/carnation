package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.dao.NavigationDao;
import com.sinco.carnation.sys.model.Navigation;
import com.sinco.carnation.sys.tools.NavViewTools;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class NavigationService {
	@Autowired
	private NavigationDao navigationDao;

	@Autowired
	private NavViewTools navTools;

	public boolean save(Navigation navigation) {
		/**
		 * init other field here
		 */
		try {
			this.navigationDao.save(navigation);
			navTools.clearNavCache();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Navigation getObjById(Long id) {
		Navigation navigation = this.navigationDao.get(id);
		if (navigation != null) {
			return navigation;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.navigationDao.remove(id);
			navTools.clearNavCache();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> navigationIds) {
		// TODO Auto-generated method stub
		for (Serializable id : navigationIds) {
			delete((Long) id);
		}
		navTools.clearNavCache();
		return true;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectByTitle(String title, MyPage<Map> page) {
		return navigationDao.selectByTitle(title, page);
	}

	public boolean update(Navigation navigation) {
		try {
			this.navigationDao.update(navigation);
			navTools.clearNavCache();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
