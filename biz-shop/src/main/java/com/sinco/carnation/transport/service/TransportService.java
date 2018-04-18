package com.sinco.carnation.transport.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.beans.BeanUtils;

import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.dao.TransportDao;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.shop.vo.TransportVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class TransportService {
	@Autowired
	private TransportDao transportDao;

	public boolean save(Transport transport) {
		/**
		 * init other field here
		 */
		try {
			this.transportDao.save(transport);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Transport getObjById(Long id) {
		Transport transport = this.transportDao.get(id);
		if (transport != null) {
			return transport;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.transportDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> transportIds) {
		// TODO Auto-generated method stub
		for (Serializable id : transportIds) {
			delete((Long) id);
		}
		return true;
	}

	public void list(MyPage<TransportBO> page, String transportType) {
		transportDao.findPageByType(page, transportType, null);
	}

	public void list(MyPage<TransportBO> page, Long storeId) {
		transportDao.findPageByType(page, null, storeId);
	}

	public boolean update(Transport transport) {
		try {
			this.transportDao.update(transport);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<Transport> query(String query, Map params, int begin, int max){
//		return this.transportDao.query(query, params, begin, max);
//		
//	}

	public void findPageByVo(MyPage<TransportBO> page, TransportVO vo) {
		List<TransportBO> content = this.transportDao.findListByVo(vo);
		page.setContent(content);
	}

	public void update(TransportVO vo) {
		Transport target = new Transport();
		BeanUtils.copyProperties(vo, target);
		this.transportDao.update(target);
	}

	public void save(TransportVO vo) {
		Transport target = new Transport();
		BeanUtils.copyProperties(vo, target);
		this.transportDao.save(target);
	}
}
