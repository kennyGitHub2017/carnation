package com.sinco.carnation.user.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sys.dao.AreaDao;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.AddressDao;
import com.sinco.carnation.user.model.Address;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private AreaDao areaDao;

	public int countByUid(Long uid) {
		return this.addressDao.countByUid(uid);
	}

	/**
	 * 设备默认地址
	 * 
	 * @param id
	 * @param uid
	 * @return
	 */
	public boolean updateDefault(Long id, Long uid) {

		Address addr = new Address();
		addr.setDefaultVal(false);
		this.addressDao.updateByUid(addr, uid);

		addr.setDefaultVal(true);
		this.addressDao.update(addr, id, uid);

		return true;
	}

	/**
	 * 根据用户id查找商城列表
	 * 
	 * @param uid
	 * @return
	 */
	public List<AddressBO> findShopByUid(Long uid) {
		return addressDao.findShopByUid(uid);
	}

	public void save(Long id, String areaInfo, Long areaId, Long userId) throws ServiceException {
		Address address = addressDao.fetch(id);

		if (areaId != null) {
			Area area = areaDao.get(areaId);
			if (area == null || !area.getLevel().equals(2)) {
				throw new ServiceException("所传地区参数错误");
			}
		}
		if (null == id || null == address) {
			address = new Address();
			UserCustomerBO user = customerService.findSessionUser(userId);
			if (user != null) {
				address.setMobile(user.getMobile());
				address.setTelephone(user.getMobile());
				address.setUserId(userId);
				address.setTrueName(user.getName());
				address.setAddTime(new Date());
			} else {
				throw new ServiceException("获取个人信息失败");
			}
		}
		address.setAreaInfo(areaInfo);
		address.setAreaId(areaId);

		if (null != address.getAreaInfo()) {// 填了详细地址，这个地址设为默认地址，其他地址取消默认
			address.setDefaultVal(true);

			Address addr = new Address();
			addr.setDefaultVal(false);
			this.addressDao.updateByUid(addr, userId);
		}

		addressDao.save(address);
	}

	public boolean save(Address address) throws ServiceException {

		if (address.getAreaId() != null) {
			Area area = areaDao.get(address.getAreaId());
			if (area == null || !area.getLevel().equals(2)) {
				throw new ServiceException("所传地区参数错误");
			}
		}
		/**
		 * init other field here
		 */

		if (address.getId() == null) {
			address.setAddTime(new Date());
		}

		this.addressDao.save(address);
		return true;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Map> selectByTop100(int userId) {
		List<Map> list = addressDao.selectByTop100(userId);
		for (Map map : list)
			if (map.get("area_id") != null)
				map.put("areaFullName", areaService.fullName(Long.parseLong(map.get("area_id") + "")));

		return list;
	}

	public List<AddressBO> selectByUser(Long userId) {
		return addressDao.selectByUser(userId);
	}

	public AddressBO getObjById(Long id) {
		AddressBO address = this.addressDao.get(id);
		if (address != null && address.getAreaId() != null) {
			address.setArea(areaService.fetchAndAllParent(address.getAreaId()));
		}
		return address;
	}

	/**
	 * 获取用户默认收货地址/居住地址
	 * 
	 * @param userId
	 * @return
	 */
	public Address getDefaultByUserId(Long userId) {
		return addressDao.getDefaultByUserId(userId);
	}

	public boolean delete(Long id) {
		try {
			this.addressDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAndSetDefault(Long id, Long uid) {
		try {
			this.addressDao.remove(id);
			List<Address> list = this.queryByUserId(uid);
			if (list != null && list.size() > 0) {
				Address address = list.get(0);
				address.setDefaultVal(true);
				addressDao.update(address);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> addressIds) {
		// TODO Auto-generated method stub
		for (Serializable id : addressIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(Address address) {
		try {
			this.addressDao.update(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Address> queryByUserId(Long userId) {
		List<Address> addresses = addressDao.queryByUserId(userId);
		for (Address address : addresses) {
			address.setArea(areaService.fetchAndAllParent(address.getAreaId()));
		}
		return addresses;
	}

	@Transactional(readOnly = false)
	public void setDefaultAddress(Long id, Long userId) {
		Address address = addressDao.fetch(id);
		if (!address.getUserId().equals(userId))
			return;
		Address defaultAddress = addressDao.getDefaultByUserId(userId);
		if (defaultAddress != null) {
			defaultAddress.setDefaultVal(false);
			addressDao.update(defaultAddress);
		}
		address.setDefaultVal(true);
		addressDao.update(address);
	}

	public void save(Address address, Long userId) throws ServiceException {

		if (address.getAreaId() != null) {
			Area area = areaDao.get(address.getAreaId());
			if (area == null || !area.getLevel().equals(2)) {
				throw new ServiceException("所传地区参数错误");
			}
		}

		if (address.getId() == null || address.getId() == 0L) {
			boolean b = addressDao.getDefaultByUserId(userId) == null ? true : false;
			address.setDefaultVal(b);
		}
		addressDao.save(address);
	}

	@Transactional(readOnly = false)
	public void deleteAddress(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String cart_ids[] = ids.split(",");
			for (String id : cart_ids) {
				addressDao.delete(CommUtil.null2Long(id));
			}
		}
	}
}
