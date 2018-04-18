package com.sinco.carnation.user.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.beans.BeanUtils;

import com.google.common.collect.Sets;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class SellerService {

	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserService userService;

	/**
	 * 服务权限
	 */
	public static Set<String> groupRoles = Sets.newHashSet("ROLE_GROUP_SELLER", "ROLE_GROUP_CODE_SELLER",
			"ROLE_GROUP_ORDER_SELLER", "ROLE_GROUP_LOCAL_ORDER_SELLER", "ROLE_GROUP_ADJUST_SELLER",
			"ROLE_SELLER_STAT_GROUP", "ROLE_GROUP_LOCAL_ORDER_SELLER", "ROLE_SELLER_GROUP_RETURN",
			"ROLE_SELLER_GROUP_EVALUATE", "ROLE_GROUP_ADJUST_SELLER");

	/**
	 * 商城权限
	 */
	public static Set<String> shopRoles = Sets.newHashSet("ROLE_GOODS_SELLER", "ROLE_CONSULT_SELLER",
			"ROLE_ADJUST_SELLER", "ROLE_GOODS_CLASS_SELLER", "ROLE_COMPLAINT_SELLER",
			"ROLE_GOODS_FORMAT_SELLER", "ROLE_STORE_NAV", "ROLE_GOODS_STORAGE_SELLER",
			"ROLE_GOODS_OUT_SELLER", "ROLE_GOODS_LIST_SELLER", "ROLE_GROUP_ORDER_SELLER",
			"ROLE_TRANSPORT_SELLER", "ROLE_SELLER_RETURN", "ROLE_SHIP_ADDRESS_SELLER", "ROLE_ORDER_SELLER",
			"ROLE_ORDER_SHIP_SELLER", "ROLE_SELLER_STAT_STORE", "ROLE_EVALUATE_SELLER", "ROLE_SPEC_SELLER",
			"ROLE_SELLER_APPLY", "ROLE_COUPON_SELLER", "ROLE_SELLER_ECC");

	public int findSellerMemberById(Long sellerId) {
		return sellerDao.findSellerMemberById(sellerId);
	}

	public int findSellerOwnMemberById(Long sellerId) {
		return sellerDao.findSellerOwnMemberById(sellerId);
	}

	public int findSellerOwnSellerById(Long sellerId) {
		return sellerDao.findSellerOwnSellerById(sellerId);
	}

	public int findSellerAllOrderCount(Long sellerId) {
		return sellerDao.findSellerAllOrderCount(sellerId);
	}

	public int findSellerWeekOrderCount(Long sellerId) {
		return sellerDao.findSellerWeekOrderCount(sellerId);
	}

	public BigDecimal findSellerRebateOrderCount(Long sellerId) {
		return sellerDao.findSellerRebateOrderCount(sellerId);
	}

	public BigDecimal findSellerWeekRebateOrderCount(Long sellerId) {
		return sellerDao.findSellerWeekRebateOrderCount(sellerId);
	}

	public BigDecimal findSellerMonthRebateOrderCount(Long sellerId) {
		return sellerDao.findSellerMonthRebateOrderCount(sellerId);
	}

	/**
	 * 
	 * @Title: selectOperatorSellerPageList
	 * @Description: TODO(查询运营商所属商户)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	public List<SellerBO> selectOperatorSellerPageList(MyPage<SellerBO> page, SellerVO vo) {
		return sellerDao.selectOperatorSellerPageList(page, vo);
	}

	/**
	 * 
	 * @Title: selectOperatorSellerPageList
	 * @Description: TODO(查询运营商所属商户 这里没有消费反润总额计算，比上个方法简单)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	public List<SellerBO> selectOperatorSellerSimplePageList(MyPage<SellerBO> page, SellerVO vo) {
		return sellerDao.selectOperatorSellerSimplePageList(page, vo);
	}

	/**
	 * 
	 * @Title: selectOperatorRegisterSellerPageList
	 * @Description: TODO(查询运营商注册商户)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	public List<SellerBO> selectOperatorRegisterSellerPageList(MyPage<SellerBO> page, SellerVO vo) {
		return sellerDao.selectOperatorRegisterSellerPageList(page, vo);
	}

	/**
	 * 初始化商户权限
	 * 
	 * @param mappings
	 */
	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public void initSellerRole() {
		// 商城权限
		List<RoleBO> roles = roleDao.findByType(UserContant.ROLE_TYPE_SELLER);

		// 给个人用户设置权限
		List<StoreBO> all = this.storeDao.findInitRoleList();
		for (StoreBO store : all) {
			List<Long> rids = getStoreRole(roles, store);
			userService.saveUserRole(store.getCreateUserId(), UserContant.ROLE_TYPE_SELLER,
					rids.toArray(new Long[rids.size()]));
		}
	}

	/**
	 * 得到商户对应的权限
	 * 
	 * @param roles
	 * @param store
	 * @return
	 */
	public List<Long> getStoreRole(List<RoleBO> roles, Store store) {
		List<Long> rids = new ArrayList<Long>();
		for (RoleBO role : roles) {
			if (groupRoles.contains(role.getRoleCode())) {
				if (store.getIsO2o() != null && store.getIsO2o()) {
					rids.add(role.getId());
				}
			} else if (shopRoles.contains(role.getRoleCode())) {
				if (store.getIsShop() != null && store.getIsShop()) {
					rids.add(role.getId());
				}
			} else {
				rids.add(role.getId());
			}
		}
		return rids;
	}

	/**
	 * 根据店铺查找商户
	 * 
	 * @param storeId
	 * @return
	 */
	public Seller findByStore(Long storeId) {
		return sellerDao.findByStore(storeId);
	}

	public SellerBO getByUsername(String username) {
		return sellerDao.findByUsername(username);
	}
	
	/****
	 * 查询seller与store关联表
	 * 
	 * @param uid 用户ID
	 * @param group 是否是O2O
	 * @param shop 是否是shop
	 * @return SellerBO
	 */
	public SellerBO findSessionById(Long uid,Boolean group, Boolean shop) {
		return sellerDao.findSessionById(uid,group,shop);
	}

	public SellerBO selectByStore(String storeId) {
		return sellerDao.selectByStore(storeId);
	}

	public SellerBO findByUid(Long uid) {
		return sellerDao.findOne(uid);
	}

	public Seller getByStoreId(Long storeId) {
		return sellerDao.getByStoreId(storeId);
	}

	@Transactional(readOnly = false)
	public int updateByCondition(Seller record) {
		return sellerDao.updateByCondition(record);
	}

	@Transactional(readOnly = false)
	public int updateByCondition(SellerVO vo) {
		try {
			Seller s = null;
			if (vo != null) {
				s = new Seller();
				BeanUtils.copyProperties(vo, s);
			}
			this.sellerDao.updateByCondition(s);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 通过卖家uid查询是否o2o
	 * 
	 * @param uid
	 * @return
	 */
	public boolean sellerIsO2oByUid(Long uid) {
		boolean result = false;

		if (uid != null) {
			Integer reint = sellerDao.sellerIsO2oByUid(uid);
			if (reint != null && reint == 1) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 通过卖家uid查询是否B2C
	 * 
	 * @param uid
	 * @return
	 */
	public boolean sellerIsB2CByUid(Long uid) {
		boolean result = false;
		if (uid != null) {
			Integer reint = sellerDao.sellerIsB2CByUid(uid);
			if (reint != null && reint == 1) {
				result = true;
			}
		}
		return result;
	}
	
	public List<SellerBO> findSellerByUIdList(Long uid) {
		return this.sellerDao.findSellerByUIdList(uid);
	}
}
