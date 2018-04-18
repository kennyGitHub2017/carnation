package com.sinco.carnation.integral.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.IntegralGoodsCartDao;
import com.sinco.carnation.shop.model.IntegralGoodsCart;

@Service
@Transactional
public class IntegralGoodsCartService {

	@Autowired
	private IntegralGoodsCartDao integralGoodsCartDao;

	public boolean save(IntegralGoodsCart integralGoodsCart) {
		/**
		 * init other field here
		 */
		try {
			this.integralGoodsCartDao.save(integralGoodsCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectByTop20() {
		return integralGoodsCartDao.selectByTop20();
	}

	public IntegralGoodsCart getObjById(Long id) {
		IntegralGoodsCart integralGoodsCart = this.integralGoodsCartDao.get(id);
		if (integralGoodsCart != null) {
			return integralGoodsCart;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.integralGoodsCartDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> integralGoodsCartIds) {
		// TODO Auto-generated method stub
		for (Serializable id : integralGoodsCartIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(IntegralGoodsCart integralGoodsCart) {
		try {
			this.integralGoodsCartDao.update(integralGoodsCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
