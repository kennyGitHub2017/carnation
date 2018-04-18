package com.sinco.carnation.shop.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.ComplaintGoodsBO;
import com.sinco.carnation.shop.dao.ComplaintGoodsDao;
import com.sinco.carnation.shop.model.ComplaintGoods;
import com.sinco.carnation.shop.vo.ComplaintGoodsVO;

@Service
@Transactional
public class ComplaintGoodsService {

	@Autowired
	private ComplaintGoodsDao complaintGoodsDao;

	public boolean save(ComplaintGoods complaintGoods) {
		/**
		 * init other field here
		 */
		try {
			this.complaintGoodsDao.save(complaintGoods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ComplaintGoods getObjById(Long id) {
		ComplaintGoods complaintGoods = this.complaintGoodsDao.get(id);
		if (complaintGoods != null) {
			return complaintGoods;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.complaintGoodsDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> complaintGoodsIds) {
		// TODO Auto-generated method stub
		for (Serializable id : complaintGoodsIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(ComplaintGoods complaintGoods) {
		try {
			this.complaintGoodsDao.update(complaintGoods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ComplaintGoodsBO> findListByVo(ComplaintGoodsVO vo) {
		return complaintGoodsDao.findListByVo(vo);
	}

}
