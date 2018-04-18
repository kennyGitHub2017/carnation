package com.sinco.carnation.pay.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.dao.PaymentDao;
import com.sinco.carnation.shop.model.Payment;

@Service
@Transactional
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;

	/**
	 * find by mark
	 * 
	 * @param mark
	 * @param install
	 * @return
	 */
	public PaymentBO findByMark(String mark, Boolean install) {
		return this.paymentDao.findByMark(mark, install);
	}

	public Payment findById(Long paymentId) {
		return this.paymentDao.findOne(paymentId);
	}

	/**
	 * find by mark
	 * 
	 * @param notMarks
	 * @param install
	 * @return
	 */
	public List<PaymentBO> findByMark(String[] notMarks, Boolean install) {
		return this.paymentDao.findByMark(notMarks, install);
	}

	public PaymentBO findByMark(String mark) {
		return this.paymentDao.findByMark(mark);
	}

	public boolean save(Payment payment) {
		/**
		 * init other field here
		 */
		try {
			this.paymentDao.save(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Payment getObjById(Long id) {
		return this.paymentDao.get(id);
	}

	public boolean delete(Long id) {
		try {
			this.paymentDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> paymentIds) {
		// TODO Auto-generated method stub
		for (Serializable id : paymentIds) {
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
//		GenericPageList pList = new GenericPageList(Payment.class, construct,query,
//				params, this.paymentDao);
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

	public boolean update(Payment payment) {
		try {
			this.paymentDao.update(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Payment> findInstalledAll() {
		return this.paymentDao.findInstalledAll();

	}
//
//	@Override
//	public Payment getObjByProperty(String construct, String propertyName,
//			String value) {
//		// TODO Auto-generated method stub
//		return this.paymentDao.getBy(construct, propertyName, value);
//	}
}
