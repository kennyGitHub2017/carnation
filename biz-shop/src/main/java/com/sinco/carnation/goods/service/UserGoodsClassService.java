package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.dao.UserGoodsClassDao;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.vo.UserGoodsClassVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class UserGoodsClassService {
	@Autowired
	private UserGoodsClassDao userGoodsClassDao;

	public List<UserGoodsClass> findByParentId(Long parentId) {
		return userGoodsClassDao.findByParentId(parentId);
	}

	public List<UserGoodsClassBO> findParentByUserId(Long userId) {
		List<UserGoodsClassBO> result = new ArrayList<>();
		List<UserGoodsClass> list = userGoodsClassDao.findParentByUserId(userId);
		if (list.size() > 0) {
			for (UserGoodsClass userGoodsClass : list) {
				UserGoodsClassBO bo = new UserGoodsClassBO();
				BeanUtils.copyProperties(userGoodsClass, bo);
				List<UserGoodsClass> listChilds = userGoodsClassDao.findByParentId(bo.getId());
				bo.setChilds(listChilds);
				result.add(bo);
			}
		}

		return result;
	}

	public boolean save(UserGoodsClass userGoodsClass) {
		/**
		 * init other field here
		 */
		try {
			this.userGoodsClassDao.save(userGoodsClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public UserGoodsClass getObjById(Long id) {
		UserGoodsClass userGoodsClass = this.userGoodsClassDao.get(id);
		if (userGoodsClass != null) {
			return userGoodsClass;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.userGoodsClassDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean removeByParentId(Long parentId) {
		try {
			this.userGoodsClassDao.removeByParentId(parentId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> userGoodsClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : userGoodsClassIds) {
			delete((Long) id);
		}
		return true;
	}

	public void selectParentPageByVO(UserGoodsClassVO vo, MyPage<UserGoodsClassBO> page) {
		List<UserGoodsClassBO> list = userGoodsClassDao.selectParentPageByVO(vo, page);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<UserGoodsClass> listChilds = userGoodsClassDao.findByParentId(list.get(i).getId());
				list.get(i).setChilds(listChilds);
			}
		}
	}

	public boolean update(UserGoodsClass userGoodsClass) {
		try {
			this.userGoodsClassDao.update(userGoodsClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//	public List<UserGoodsClass> query(String query, Map params, int begin, int max){
//		return this.userGoodsClassDao.query(query, params, begin, max);
//		
//	}
}
