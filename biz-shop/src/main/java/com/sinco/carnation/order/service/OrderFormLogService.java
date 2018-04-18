package com.sinco.carnation.order.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.OrderLogBO;
import com.sinco.carnation.shop.dao.OrderLogDao;
import com.sinco.carnation.shop.model.OrderLog;

@Service
@Transactional
public class OrderFormLogService {
	@Autowired
	private OrderLogDao OrderLogDao;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean save(OrderLog OrderLog) {
		/**
		 * init other field here
		 */
		try {
			this.OrderLogDao.save(OrderLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public OrderLog getObjById(Long id) {
		OrderLog OrderLog = this.OrderLogDao.get(id);
		if (OrderLog != null) {
			return OrderLog;
		}
		return null;
	}

	/**
	 * 根据userId获取OrderLog
	 * 
	 * @param userId
	 * @return
	 */
	public List<OrderLog> queryByUserId(Long userId) {
		return OrderLogDao.queryByUserId(userId);
	}

	/**
	 * 根据oderId获取OrderLog
	 * 
	 * @param userId
	 * @return
	 */
	public List<OrderLogBO> queryByOrderId(Long orderId) {
		return OrderLogDao.queryByOrderId(orderId);
	}

	public boolean delete(Long id) {
		try {
			this.OrderLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> OrderLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : OrderLogIds) {
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
//		GenericPageList pList = new GenericPageList(OrderLog.class,construct, query,
//				params, this.OrderLogDao);
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

	public boolean update(OrderLog OrderLog) {
		try {
			this.OrderLogDao.update(OrderLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//	public List<OrderLog> query(String query, Map params, int begin, int max){
//		return this.OrderLogDao.query(query, params, begin, max);
//		
//	}
}
