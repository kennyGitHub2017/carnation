package com.sinco.carnation.ship.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.dao.ShipAddressDao;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.shop.vo.ShipAddressVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class ShipAddressService {

	@Autowired
	private ShipAddressDao shipAddressDao;

	@Transactional(readOnly = false)
	public boolean save(ShipAddress shipAddress) {
		if (shipAddress == null) {
			return false;
		}
		if (null == shipAddress.getSaAreaId() || null == shipAddress.getSaName()
				|| null == shipAddress.getSaAddr() || null == shipAddress.getSaUserId()){
			return false;
		}
		try {
			this.shipAddressDao.save(shipAddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ShipAddressBO getObjById(Long id) {
		ShipAddressBO shipAddress = shipAddressDao.get(id);
		if (shipAddress != null) {
			return shipAddress;
		}
		return null;
	}

	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		try {
			this.shipAddressDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> shipAddressIds) {
		// TODO Auto-generated method stub
		for (Serializable id : shipAddressIds) {
			delete((Long) id);
		}
		return true;
	}

	@Transactional(readOnly = false)
	public boolean update(ShipAddress shipAddress) {
		if (shipAddress == null) {
			return false;
		}
		if (null == shipAddress.getSaAreaId() || null == shipAddress.getSaName()
				|| null == shipAddress.getSaAddr() || null == shipAddress.getSaUserId()){
			return false;
		}
		try {
			this.shipAddressDao.update(shipAddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void queryShipAddress(Integer saType, MyPage<ShipAddressBO> page) {
		page.setContent(shipAddressDao.queryShipAddress(saType, page));
	}

	public ShipAddressBO queryShipAddressById(Long id) {
		return shipAddressDao.queryShipAddressById(id);
	}

	@Transactional(readOnly = false)
	public void shipAddress(ShipAddressBO vo) {
		if (vo.getId() != null) {
			shipAddressDao.update(vo);
		} else {
			vo.setAddTime(new Date());
			shipAddressDao.save(vo);
		}
	}

	public List<ShipAddress> findAllBySaType(Integer saType) {
		return this.shipAddressDao.findAllBySaType(saType);
	}

	public void findPageByVo(MyPage<ShipAddressBO> page, ShipAddressVO vo) {
		this.shipAddressDao.findPageByVo(page, vo);
	}

	public List<ShipAddressBO> findAllByCondition(Boolean saDefault, Long saUserId) {
		return shipAddressDao.findAllByCondition(null, saUserId, saDefault);
	}

	public List<ShipAddressBO> findAllByCondition(Integer saType, Long saUserId) {
		return shipAddressDao.findAllByCondition(saType, saUserId, null);
	}
}
