package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.PartnerBO;
import com.sinco.carnation.sys.dao.PartnerDao;
import com.sinco.carnation.sys.model.Partner;

@Service
@Transactional
public class PartnerService {
	@Autowired
	private PartnerDao partnerDao;

	public List<PartnerBO> findImg(Boolean isNull) {
		return partnerDao.findImg(isNull);
	}

	public boolean save(Partner partner) {
		/**
		 * init other field here
		 */
		try {
			this.partnerDao.save(partner);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Partner getObjById(Long id) {
		Partner partner = this.partnerDao.get(id);
		if (partner != null) {
			return partner;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.partnerDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> partnerIds) {
		// TODO Auto-generated method stub
		for (Serializable id : partnerIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(Partner partner) {
		try {
			this.partnerDao.update(partner);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
