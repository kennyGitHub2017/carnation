package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;
import cn.eeepay.EeePayConstants;
import cn.eeepay.EeePayGetSDKKeyResult;
import cn.eeepay.EeePayRegisterResult;
import cn.eeepay.EeePayRegisterVO;
import cn.eeepay.EeePayUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.dao.GroupGoodsDao;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.dao.StoreApplyInfoDao;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreApplyInfo;
import com.sinco.carnation.store.tools.DistanceUtils;
import com.sinco.carnation.store.vo.GroupStoreListVO;
import com.sinco.carnation.store.vo.StoreApplyInfoVO;
import com.sinco.carnation.store.vo.StoreApplyVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.contants.OrclUserContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.dao.AlbumDao;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class StoreService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${eeepay.url}")
	private String eeepayURL;

	@Autowired
	private StoreDao storeDao;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private UserService userService;
	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private Mapper mapper;
	@Autowired
	private UserAccountDao accountDao;
	@Autowired
	private StoreApplyInfoDao storeApplyInfoDao;
	@Autowired
	private UserOwnService userOwnService;
	@Autowired
	private GroupGoodsDao groupGoodsDao;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryServiceImpl;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private OperatorDao operatorDao;
	@Autowired
	private OrclUserBaseService orclUserBaseService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private UserAccountService userAccountService;

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	private static String store_cached_key = "store_cached";

	private final Integer expireTime = 300;

	public List<StoreBO> selectAllotStoreList(MyPage<StoreBO> page, StoreVO vo) {
		return storeDao.selectAllotStoreList(page, vo);
	}

	public List<StoreBO> selectOperatorCheckList(MyPage<StoreBO> page, String operatorCode,
			String operatorName, String storeName, String operatorUserName) {
		return storeDao
				.selectOperatorCheckList(page, operatorCode, operatorName, storeName, operatorUserName);
	}

	public StoreBO selectOwnStoreByOperatorId(String operatorAreaId, Long storeId, String operatorLevel) {
		return storeDao.selectOwnStoreByOperatorId(operatorAreaId, storeId, operatorLevel);
	}

	public List<StoreBO> selectCheckListByOperatorId(MyPage<StoreBO> page, Long operatorId, String storeName,
			String operatorLevel) {
		return storeDao.selectCheckListByOperatorId(page, operatorId, storeName, operatorLevel);
	}

	/**
	 * 查找用于重跑搜索引擎的店铺
	 * 
	 * @return
	 */
	public List<Long> findInitLuceneList() {
		return storeDao.findInitLuceneList();
	}

	/**
	 * 查找店铺申请信息
	 * 
	 * @param storeId
	 * @return
	 */
	public StoreApplyInfoBO findStoreApplyInfoById(Long storeId) {
		return storeApplyInfoDao.findOne(storeId);
	}

	/**
	 * 得到店铺状态
	 * 
	 * @param id
	 * @return
	 */
	public StoreBO getStoreStatus(Long id) {
		return storeDao.getStoreStatus(id);
	}

	/**
	 * 得到店铺申请信息
	 * 
	 * @param id
	 * @return
	 */
	public StoreApplyInfoBO getStoreApplyInfoBO(Long id) {
		return storeApplyInfoDao.get(id);
	}

	/**
	 * 查找服务店铺
	 * 
	 * @param vo
	 * @return
	 */
	public List<StoreBO> findGroupStoreList(GroupStoreListVO vo) {
		return storeDao.findGroupStoreList(vo);
	}

	public List<StoreBO> findStoreByKeywords(String keywords) {
		return storeDao.findStoreByKeywords(keywords);
	}

	@Transactional(readOnly = false)
	public boolean save(Store store) {
		/**
		 * init other field here
		 */
		try {
			this.storeDao.save(store);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StoreBO getObjById(Long id) {
		return this.storeDao.get(id);
	}

	public StoreBO getStoreBOById(Long id) {
		StoreBO store = this.storeDao.get(id);
		return store;
	}

	public boolean delete(Long id) {
		try {
			this.storeDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storeIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storeIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(Store store) {
		this.storeDao.update(store);
		refreshGroupCase(store.getId());// 刷新缓存-cc
		return true;
	}

	public boolean update(StoreApplyInfoVO vo) {
		StoreApplyInfo info = null;
		if (vo != null) {
			info = new StoreApplyInfo();
			BeanUtils.copyProperties(vo, info);
		}
		this.storeApplyInfoDao.update(info);
		return true;
	}

	public List<StoreBO> findPageByVo(MyPage<StoreBO> page, StoreVO vo) {
		List<StoreBO> list = this.storeDao.findListByVO(page, vo);
		try {
			if (list != null && list.size() > 0) {
				for (StoreBO sbo : list) {
					Area area = areaService.getObjById(sbo.getAreaId());
					if (area != null) {
						sbo.setAreaName(area.getAreaName());
						if (area.getParentId() != null) {
							Area parentArea = areaService.getObjById(area.getParentId());
							sbo.setParentAreaName(parentArea.getAreaName());
						}
					}
				}
			}
			page.setContent(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public StoreBO fetchStoreByCreateUserId(Long userId) {
		return storeDao.fetchStoreByCreateUserId(userId);
	}

	@Transactional(readOnly = false)
	public boolean create(StoreVO storeVo) {
		Store store = null;
		if (storeVo != null) {
			store = new Store();
			BeanUtils.copyProperties(storeVo, store);
		}
		// 添加创建用户 update by james
		store.setCreateUserId(storeVo.getUid());

		return save(storeVo.getLoginName(), store);
	}

	/**
	 * 申请店铺修改，storeId 为空新增，不为空修改
	 * 
	 * @param vo
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unused")
	@Transactional(readOnly = false)
	public boolean applyStore(StoreApplyVO vo, Long uid, Long storeId) throws ServiceException {

	/*	if (storeId == null) {
			if (storeDao.countByCreateUserId(uid) > 0) {
				throw new ServiceException("用户已经有店铺");
			}
		}*/

		// 处理其它附件不超过5个
		if (StringUtils.isNotBlank(vo.getOtherPhotoPath())) {
			String[] otherImg = vo.getOtherPhotoPath().split(";");
			if (otherImg.length > 5) {
				vo.setOtherPhotoPath(StringUtils.join(Arrays.copyOf(otherImg, 5), ";"));
			}
		}

		Store store = mapper.map(vo, Store.class);
		store.setId(storeId);
		store.setGroupDetailInfo(StringUtils.join(vo.getGroupDetailInfo(), ","));
		store.setCreateUserId(uid);
		store.setStoreInfo(vo.getLicenseCDesc());// 设置店铺简介
		store.setStoreCoverPath(vo.getBusinessPlacePhotoPath()); // 店铺封面
		StoreApplyInfo applyInfo = mapper.map(vo, StoreApplyInfo.class);

		UserAccount account = accountDao.findByUid(uid, UserContant.ACCOUNT_TYPE_2);
		Integer ownType = 1;
		// 删除商户关系
		userOwnService.deleteOwns(uid,ownType);
		// 建立与运营商的关系
		String operatorCode = userOwnService.updateUserOwns(store.getCreateUserId(),
				applyInfo.getOperateNumber(), store.getAreaId(),ownType);

		/*if (StringUtils.isNotBlank(operatorCode)) {
			// 初始化为运营商审批
			store.setStoreStatus(StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT);
		} else {*/
		// 初始化为平台审批------------现在只用通过平台审批
		store.setStoreStatus(StoreConstants.STORE_STATUS_SYS_AUDIT);
//		}

		if (storeId == null) {
			store.setAddTime(new Date());
			store.setIsO2o(true); // 服务商户
			store.setIsShop(false);
			save(account.getLoginName(), store);
		} else {
			update(store);
		}

		// 与传入的storeId区分开来
		Long applyStoreId = store.getId();
		applyInfo.setStoreId(applyStoreId);

		if (storeId == null) {
			storeApplyInfoDao.create(applyInfo);
		} else {
			storeApplyInfoDao.update(applyInfo);
		}

		return true;
	}

	/**
	 * 用于重新申请pos机
	 * 
	 * @param vo
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public void applyStoreForPos(StoreApplyVO vo, Long uid, Long storeId) throws ServiceException {

		// 处理其它附件不超过5个
		if (StringUtils.isNotBlank(vo.getOtherPhotoPath())) {
			String[] otherImg = vo.getOtherPhotoPath().split(";");
			if (otherImg.length > 5) {
				vo.setOtherPhotoPath(StringUtils.join(Arrays.copyOf(otherImg, 5), ";"));
			}
		}

		Store store = mapper.map(vo, Store.class);
		store.setId(storeId);
		store.setGroupDetailInfo(StringUtils.join(vo.getGroupDetailInfo(), ","));
		store.setCreateUserId(uid);
		store.setStoreInfo(vo.getLicenseCDesc());// 设置店铺简介

		StoreApplyInfo applyInfo = mapper.map(vo, StoreApplyInfo.class);

		String operatorCode = vo.getOperateNumber();
		if (StringUtils.isNotBlank(operatorCode)) {
			// 初始化为运营商审批
			store.setStoreStatus(StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT);
		} else {
			// 初始化为平台审批
			store.setStoreStatus(StoreConstants.STORE_STATUS_SYS_AUDIT);
		}
		// 更新商户信息
		update(store);

		applyInfo.setStoreId(storeId);
		// 更新申请信息
		storeApplyInfoDao.update(applyInfo);

	}

	/**
	 * 店铺修改，storeId 为空新增，不为空修改
	 * 
	 * @param vo
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public boolean applyStoreEdit(StoreApplyInfo apply, Store store) throws ServiceException {
		if (apply != null && StringUtils.isNotBlank(apply.getBusinessPlacePhotoPath())) {
			store.setStoreCoverPath(apply.getBusinessPlacePhotoPath());
		}
		update(store);
		storeApplyInfoDao.update(apply);

		return true;
	}

	/**
	 * 申请店铺,用于第一次申请
	 * 
	 * @param vo
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public boolean applyStore(StoreApplyVO vo, Long uid) throws ServiceException {
		return applyStore(vo, uid, null);
	}

	@Transactional(readOnly = false)
	public boolean save(String sellerUserName, Store store) {
		if (store.getId() == null) {
			// 新增环境相册
			Album album = new Album();
			album.setAddTime(new Date());
			album.setAlbumName("环境相册");
			album.setAlbumSequence(-9999);
			album.setAlbumDefault(false);
			album.setStoreInfoDefault(true);
			album.setUserId(store.getCreateUserId());
			this.albumDao.save(album);

			// 添加卖家权限
			List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_SELLER);
			List<Long> rids = sellerService.getStoreRole(roles, store);
			this.userService.saveUserRole(store.getCreateUserId(), UserContant.ROLE_TYPE_SELLER,
					rids.toArray(new Long[rids.size()]));
		}
		// 保存商铺
		this.storeDao.save(store);
		// 保存卖家
		Seller seller = new Seller();
		seller.setUid(store.getCreateUserId());
		seller.setUserName(sellerUserName);
		seller.setReport(0);
		seller.setStatus(1);
		seller.setStoreId(store.getId());
		sellerDao.create(seller);
		return true;
	}

	@Transactional(readOnly = false)
	public void updateCheck(Store store, String checkResult, String checkDescribe, String implementNumber,
			Integer posType, String lineNumber) {
		Store s = new Store();
		s.setId(store.getId());
		switch (checkResult) {
			case "1":
				s.setStoreStatus(StoreConstants.STORE_STATUS_SYS_AUDIT);
				if (store != null && store.getIsEepay() && StringUtils.isNotEmpty(implementNumber)
						&& posType != null && StringUtils.isNotEmpty(lineNumber)) {
					s.setImplementNumber(implementNumber);
					s.setPosType(posType);
					s.setLineNumber(lineNumber);
					if (EeePayConstants.POS_TYPE_4.equals(String.valueOf(posType))) {
						s.setAddType(Integer.parseInt(EeePayConstants.APP_TYPE_6));
					}
					if (EeePayConstants.POS_TYPE_5.equals(String.valueOf(posType))) {
						s.setAddType(Integer.parseInt(EeePayConstants.APP_TYPE_24));
					}
				}
				break;
			case "0":
				s.setStoreStatus(StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT_FAIL);
				StoreApplyInfoVO storeApplyInfo = new StoreApplyInfoVO();
				storeApplyInfo.setStoreId(store.getId());
				storeApplyInfo.setFailReseaon(checkDescribe);
				update(storeApplyInfo);
				break;
		}
		update(s);
	}

	@Transactional(readOnly = false)
	public boolean update(StoreVO storeVo) {
		try {
			Store store = null;
			if (storeVo != null) {
				store = new Store();
				BeanUtils.copyProperties(storeVo, store);
			}
			this.storeDao.update(store);
			refreshGroupCase(store.getId());// 刷新缓存-cc
			// 供应商审核短信提醒
			sendMsgToAudit(storeVo.getId() + "", storeVo.getStoreStatus(), StoreConstants.AUDIT_TYPE_STORE);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<StoreBO> findStoreIsExist(String storeName, Long id) {
		return storeDao.findStore(storeName, id);
	}

	@Transactional(readOnly = false)
	public void storeSetSave(Store store, StoreVO vo, String mobile, MultipartFile logoFile,
			MultipartFile bannerFile, MultipartFile coverFile, Long uid) {
		// 图片上传开始logo
		if (logoFile != null && logoFile.getSize() != 0) {
			try {
				String fileUrl = FileUploadTools.fileUpload(logoFile, UploadConstants.EDITOR);
				store.setStoreLogoPath(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// banner
		if (bannerFile != null && bannerFile.getSize() != 0) {
			try {
				String fileUrl = FileUploadTools.fileUpload(bannerFile, UploadConstants.EDITOR);
				store.setStoreBannerPath(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 封面图
		if (coverFile != null && coverFile.getSize() != 0) {
			try {
				String fileUrl = FileUploadTools.fileUpload(coverFile, UploadConstants.EDITOR);
				store.setStoreCoverPath(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		store.setAreaId(vo.getAreaId());// 保存最底层的地址
		store.setStoreName(vo.getStoreName());
		store.setLicenseCName(vo.getLicenseCName());
		store.setStoreTelephone(vo.getStoreTelephone());
		store.setStoreQq(vo.getStoreQq());
		store.setStoreWw(vo.getStoreWw());
		store.setStoreSeoKeywords(vo.getStoreSeoKeywords());
		store.setStoreSeoDescription(vo.getStoreSeoDescription());
		store.setStoreAddress(vo.getStoreAddress());
		store.setStoreInfo(vo.getStoreInfo());
		store.setStoreLat(vo.getStoreLat());
		store.setStoreLon(vo.getStoreLon());
		StoreApplyInfo apply = this.storeApplyInfoDao.get(store.getId());
		if (apply != null) {
			// 同步封面
			if (StringUtils.isNotBlank(store.getStoreCoverPath())) {
				apply.setBusinessPlacePhotoPath(store.getStoreCoverPath());
			}
			apply.setLicenseBusinessScope(vo.getLicenseBusinessScope());
			storeApplyInfoDao.update(apply);
		}
		this.update(store);
		if (mobile != null && !mobile.equals("")) {
			/*Seller seller = sellerDao.findByUid(uid);*/
			Seller seller = sellerDao.getByStoreId(store.getId());
			seller.setMobile(mobile);
			seller.setId(seller.getId());
			sellerDao.update(seller);
		}
		refreshGroupCase(vo.getId());// 刷新缓存-cc
	}

	public void queryFavaStorePageList(Long uid, String type, MyPage<StoreBO> page) {
		page.setContent(storeDao.queryFavaStorePageList(uid, type, page));
	}

	/**
	 * 商户首页信息
	 * 
	 * @param uid
	 * @return
	 */
	public StoreBO queryStoreInfo(Long uid,Boolean group,Boolean shop) {
		return storeDao.queryStoreInfo(uid,group,shop);
	}

	/**
	 * 查询商户审核进度
	 * 
	 * @param uid
	 * @return
	 */
	public StoreBO queryStoreStatus(Long uid,Boolean group, Boolean shop) {
		return storeDao.queryStoreStatus(uid,group,shop);
	}

	public StoreBO queryStoreById(Long storeId) {
		return storeDao.queryStoreById(storeId);
	}

	/**
	 * 商户审核
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public String saveMerchantAudit(StoreVO vo, StoreApplyInfoVO svo) throws Exception {
		String returnStr = StringUtils.EMPTY;
		SysConfigBO config = configService.getSysConfig();

		// update by james
		if (vo.getId() != null) {
			if (vo.getStoreStatus() == StoreConstants.STORE_STATUS_SYS_AUDIT) {// 审核通过
				StoreBO bo = storeDao.findObjById(vo.getId());
				// 判断隶属运营商的级别：银卡会员不可注册商户
				Integer ownType = 1;
				UserOwnsBO userOwnsBO = userOwnService.findOne(vo.getId(),ownType);
				if (userOwnsBO != null) {
					OperatorBO operatorBO = operatorDao.findOne(userOwnsBO.getOwnOperatorId());
					if (operatorBO != null) {
						// 运营商为金卡，银卡级别的运营商不能推荐供应商
						if (UserContants.OPERATOR_LEVEL_SILVER.equals(operatorBO.getLevel())) {
							return "隶属运营商级别为银卡，不能注册商户";
						}
						if (operatorBO.getCn_username() != null
								&& operatorBO.getCn_username().startsWith(UserContant.ACCOUNT_TYPE_CN)) {
							CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operatorBO
									.getCn_username());
							if (cn == null || null == cn.getUserType() || "" == cn.getUserType()) {
								return "结算系统未查询到该推荐运营商，请稍后再试，或联系管理员";
							}
							if (cn != null && OrclUserContants.OPERATOR_LEVEL_SILVER.equals(cn.getUserType())) {
								return "隶属运营商级别为银卡，不能注册商户";
							}
						}
					}
				}

				UserAccount account = accountDao.findByUid(bo.getCreateUserId(), UserContant.ACCOUNT_TYPE_2);
				String mobile = account.getLoginName();
				if (vo.getIsEepay()) {// 安装POS机,到第三方支付注册
					StoreApplyInfoBO infoBO = storeApplyInfoDao.queryStoreApplyInfo(vo.getId());
					// 先查询第三方是否已经注册
					EeePayGetSDKKeyResult getSDKKeyResult = EeePayUtils.getEeePaySDKKey(eeepayURL,
							config.getEeepayAgentNo(), mobile, vo.getImplementNumber());
					if (getSDKKeyResult.isSucceed()) {
						vo.setEepayKey(getSDKKeyResult.getSdkKey());
						vo.setEepayMid(getSDKKeyResult.getMerchantNo());
					} else {
						// 如果查询不存在或者查询失败，调用注册接口，返回成功,更新状态为正常营业，否则审核失败
						EeePayRegisterVO eeePayRegisterVO = getEeePayRegisterVO(vo, bo, mobile, infoBO);
						EeePayRegisterResult result = EeePayUtils.registerEeePay(eeepayURL, eeePayRegisterVO);

						if (result == null) {
							return "调用第三方支付公司注册接口失败";
						}
						if (!result.isSucceed()) {// 调用返回失败
							return "调用第三方支付公司注册接口失败:" + result.getError();
						}
						vo.setEepayKey(result.getSdkKey());
						vo.setEepayMid(result.getMerchantNo());
					}
				}

				vo.setStoreStatus(StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS);// 正常营业
				// 更新商户状态
				this.storeDao.update(vo);
				returnStr = "审核成功";
//				msgTools.sendSms(SMSConstants.SMS_MERCHANT_AUDIT_SUCCESS, mobile);
			} else {
				svo.setStoreId(vo.getId());
				// 保存审核不通过原因
				this.storeApplyInfoDao.update(svo);
				// 更新商户状态
				this.storeDao.update(vo);
			}

			// 商户审核短信提醒
			sendMsgToAudit(vo.getId() + "", vo.getStoreStatus(), StoreConstants.AUDIT_TYPE_MERCHANTS);
			refreshGroupCase(vo.getId());// 刷新缓存-cc
		}

		return returnStr;
	}

	public EeePayRegisterVO getEeePayRegisterVO(StoreVO vo, StoreBO bo, String moblie, StoreApplyInfoBO infoBO) {
		EeePayRegisterVO eeePayRegisterVO = new EeePayRegisterVO();
		SysConfigBO config = configService.getSysConfig();
		if (vo != null && bo != null) {
			// 开户行所在省市
			Long bankAreaId = bo.getBankAreaId();
			Area areaCity = this.areaService.getObjById(bankAreaId);
			String city = StringUtils.EMPTY;
			String province = StringUtils.EMPTY;
			if (null != areaCity) {
				city = areaCity.getAreaName();
				Area areaProvince = this.areaService.getObjById(areaCity.getParentId());
				if (areaProvince != null) {
					province = areaProvince.getAreaName();
				}
			}
			// 经营地所在省市
			Long areaId = bo.getAreaId();
			Area areaRegion = this.areaService.getObjById(areaId);
			String city1 = StringUtils.EMPTY;
			String province1 = StringUtils.EMPTY;
			if (areaRegion != null) {
				Area cityArea = this.areaService.getObjById(areaRegion.getParentId());
				if (cityArea != null) {
					city1 = cityArea.getAreaName();
					Area areaProvince = this.areaService.getObjById(cityArea.getParentId());
					if (areaProvince != null) {
						province1 = areaProvince.getAreaName();
					}
				}
			}
			eeePayRegisterVO.setAddType("1");
			eeePayRegisterVO.setName(bo.getStoreName());
			eeePayRegisterVO.setMobile(moblie);
			eeePayRegisterVO.setPassword(RandomStringUtils.randomNumeric(8));
			eeePayRegisterVO.setSn(vo.getImplementNumber());
			eeePayRegisterVO.setPosType(String.valueOf(vo.getPosType()));

			// 根据机具类型，设置客户端类型
			switch (String.valueOf(vo.getPosType())) {
				case EeePayConstants.POS_TYPE_4:
					eeePayRegisterVO.setAppType(EeePayConstants.APP_TYPE_6);
					break;
				case EeePayConstants.POS_TYPE_5:
					eeePayRegisterVO.setAppType(EeePayConstants.APP_TYPE_24);
					break;
			}

			eeePayRegisterVO.setIdCardNo(bo.getStoreOwerCard());
			eeePayRegisterVO.setBankName(bo.getBankName());
			eeePayRegisterVO.setAccountName(bo.getBankAccountName());
			eeePayRegisterVO.setAccountNo(bo.getBankCAccount());
			eeePayRegisterVO.setAccountProvince(province);
			eeePayRegisterVO.setAccountCity(city);
			eeePayRegisterVO.setCnapsNo(vo.getLineNumber());
			eeePayRegisterVO.setQuerstion("云尚");
			eeePayRegisterVO.setAnswer("云尚");
			eeePayRegisterVO.setProvince(province1);
			eeePayRegisterVO.setCity(city1);
			eeePayRegisterVO.setAddress(bo.getStoreAddress());
			// 反润比例
			Double ratioValue = new Double(
					(bo.getCommissionRebate().doubleValue() + config.getEeepayFee().doubleValue() + config
							.getCommissionRebateRate().doubleValue()) * 100);
			eeePayRegisterVO.setRatioValue(ratioValue.floatValue());
		}
		List<String> files = new ArrayList<String>();
		if (infoBO != null) {
			if (StringUtils.isNotEmpty(infoBO.getBankCardBackPath())) {
				files.add(infoBO.getBankCardBackPath());
			}
			if (StringUtils.isNotEmpty(infoBO.getBankCardFrontPath())) {
				files.add(infoBO.getBankCardFrontPath());
			}
			if (StringUtils.isNotEmpty(infoBO.getLicenseImagePath())) {
				files.add(infoBO.getLicenseImagePath());
			}
			if (StringUtils.isNotEmpty(infoBO.getLicenseLegalIdCard())) {
				files.add(infoBO.getLicenseLegalIdCard());
			}
			if (StringUtils.isNotEmpty(infoBO.getLicenseLegalIdCardBackPath())) {
				files.add(infoBO.getLicenseLegalIdCardBackPath());
			}
			if (StringUtils.isNotEmpty(infoBO.getLicenseLegalIdCardFrontPath())) {
				files.add(infoBO.getLicenseLegalIdCardFrontPath());
			}
			if (StringUtils.isNotEmpty(infoBO.getLicenseLegalIdcardImagePath())) {
				files.add(infoBO.getLicenseLegalIdcardImagePath());
			}
			if (StringUtils.isNotEmpty(infoBO.getLicenseLegalIdCardReachPath())) {
				files.add(infoBO.getLicenseLegalIdCardReachPath());
			}
			if (StringUtils.isNotEmpty(infoBO.getOrganizationImagePath())) {
				files.add(infoBO.getOrganizationImagePath());
			}
			if (StringUtils.isNotEmpty(infoBO.getTaxGeneralCardPath())) {
				files.add(infoBO.getTaxGeneralCardPath());
			}
			if (StringUtils.isNotEmpty(infoBO.getTaxRegCardPath())) {
				files.add(infoBO.getTaxRegCardPath());
			}
		}
		eeePayRegisterVO.setFiles(files);

		return eeePayRegisterVO;
	}

	/**
	 * 商户违规下架
	 */
	@Transactional(readOnly = false)
	public void merchantViolationClose(StoreVO vo) {
		if (vo.getId() != null) {
			vo.setStoreStatus(20);
			// 更新商户状态
			this.storeDao.update(vo);
			// 所有服务下架
			List<GroupGoodsBO> ggs = this.groupGoodsDao.findAllByStoreId(vo.getId());
			if (null != ggs && ggs.size() > 0) {
				GroupGoods gg = null;
				for (int i = 0; i < ggs.size(); i++) {
					gg = (GroupGoods) ggs.get(i);
					gg.setGgStatus(-2);
					this.groupGoodsDao.update(gg);
				}
			}
			refreshGroupCase(vo.getId());// 刷新缓存-cc
		}
	}

	public void queryStoreFavorites(Long uid, Integer type, double storeLat, double storeLon,
			MyPage<StoreBO> page) {
		List<StoreBO> list = storeDao.queryStoreFavorites(uid, type, page);
		if (list != null)
			for (StoreBO store : list) {
				if (StringUtils.isBlank(store.getStoreCoverPath())) {
					AlbumBO albumBO = albumService.getStoreAlbum(store.getCreateUserId());
					if (albumBO != null) {
						Accessory accessory = accessoryServiceImpl.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
						if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
							store.setStoreInfoPath(accessory.getPath());
						}
					}
				} else {
					store.setStoreInfoPath(store.getStoreCoverPath());
				}

				if (storeLat == 0.0 && storeLon == 0.0) {
					store.setDistance(0.0);
				} else {
					// 获取距离
					Double distance = DistanceUtils.GetDistance(CommUtil.null2Double(store.getStoreLon()),
							CommUtil.null2Double(store.getStoreLat()), storeLon, storeLat);
					store.setDistance(distance);
				}

				// 设置服务评分
				store.setEvaluationAverage(store.getStoreEvaluationAverage());
			}
		page.setContent(list);
	}

	public StoreApplyInfoBO queryStoreApplyInfo(Long uid,boolean group, boolean shop) {
		StoreBO store = storeDao.queryStoreInfo(uid,group,shop);
		if (store != null) {
			return storeApplyInfoDao.queryStoreApplyInfo(store.getId());
		}
		return null;
	}

	public void queryRecommStore(Long areaId, Double storeLat, Double storeLon, Boolean store_recommend,
			MyPage<StoreBO> page) {
		List<StoreBO> list = null;
		if (areaId == null) {
			list = storeDao.queryRecommStore(storeLat, storeLon, store_recommend, page);
		} else {
			Set<Long> areaIds = null;
			List<Area> areas = areaService.queryAreaByParentId(areaId);
			if (areas != null && areas.size() > 0) {
				areaIds = new HashSet<Long>();
				for (Area area : areas) {
					areaIds.add(area.getId());
				}
			}
			list = storeDao.queryRecommStoreByArea(areaIds, store_recommend, page);
		}
		if (storeLat == null || storeLon == null) {
			for (StoreBO storeBO : list) {
				// 设置服务评分
				storeBO.setEvaluationAverage(storeBO.getStoreEvaluationAverage());
				// 设置地区

				DicBase area = dicContent.getDic(Area.class, CommUtil.null2String(storeBO.getAreaId()));
				storeBO.setArea(area.getName());
				// 设置距离
				storeBO.setDistance(null);
				// 设置图片
				if (StringUtils.isNotBlank(storeBO.getStoreCoverPath())) {
					storeBO.setStoreInfoPath(storeBO.getStoreCoverPath());
				} else {
					AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
					if (albumBO != null) {
						Accessory accessory = accessoryServiceImpl.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
						if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
							storeBO.setStoreInfoPath(accessory.getPath());
						}
					}
				}
				// 折扣*10，方便APP显示
				if (storeBO.getGroupDiscount() != null) {
					storeBO.setGroupDiscount(storeBO.getGroupDiscount().multiply(new BigDecimal(10)));
				}
			}
		} else {
			for (StoreBO storeBO : list) {
				// 设置服务评分
				storeBO.setEvaluationAverage(storeBO.getStoreEvaluationAverage());
				// 设置地区
				Area area = areaService.getCacheById(storeBO.getAreaId());
				// DicBase area = dicContent.getDic(Area.class,
				// CommUtil.null2String(area.getCode()));
				storeBO.setArea(area.getName());
				// 设置距离
				if (storeBO.getStoreLon() != null && storeBO.getStoreLat() != null) {
					Double distance = DistanceUtils.GetDistance(CommUtil.null2Double(storeBO.getStoreLon()),
							CommUtil.null2Double(storeBO.getStoreLat()), storeLon, storeLat);
					storeBO.setDistance(distance);
				} else {
					storeBO.setDistance(null);
				}
				// 设置图片
				if (StringUtils.isNotBlank(storeBO.getStoreCoverPath())) {
					storeBO.setStoreInfoPath(storeBO.getStoreCoverPath());
				} else {
					AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
					if (albumBO != null) {
						Accessory accessory = accessoryServiceImpl.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
						if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
							storeBO.setStoreInfoPath(accessory.getPath());
						}
					}
				}
				// 折扣*10，方便APP显示
				if (storeBO.getGroupDiscount() != null) {
					storeBO.setGroupDiscount(storeBO.getGroupDiscount().multiply(new BigDecimal(10)));
				}
			}
		}
		page.setContent(list);
	}

	public void queryStoreGoods(Long areaId, Double storeLat, Double storeLon, Boolean store_recommend,
			MyPage<StoreBO> page) {
		List<StoreBO> list = null;
		if (areaId == null) {
			list = storeDao.queryStoreGoods(storeLat, storeLon, store_recommend, page);
		} else {
			Set<Long> areaIds = null;
			List<Area> areas = areaService.queryAreaByParentId(areaId);
			if (areas != null && areas.size() > 0) {
				areaIds = new HashSet<Long>();
				for (Area area : areas) {
					areaIds.add(area.getId());
				}
			}
			list = storeDao.queryStoreGoodsByArea(areaIds, store_recommend, page);
		}

		if (storeLat == null || storeLon == null) {
			for (StoreBO storeBO : list) {
				// 设置服务评分
				storeBO.setEvaluationAverage(storeBO.getStoreEvaluationAverage());
				// 设置地区

				DicBase area = dicContent.getDic(Area.class, CommUtil.null2String(storeBO.getAreaId()));
				storeBO.setArea(area.getName());
				// 设置距离
				storeBO.setDistance(null);
				// 设置图片
				AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
				if (albumBO != null) {
					Accessory accessory = accessoryServiceImpl.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
					if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
						storeBO.setStoreInfoPath(accessory.getPath());
					}
				}
				// 折扣*10，方便APP显示
				if (storeBO.getGroupDiscount() != null) {
					storeBO.setGroupDiscount(storeBO.getGroupDiscount().multiply(new BigDecimal(10)));
				}
			}
		} else {
			for (StoreBO storeBO : list) {
				// 设置服务评分
				storeBO.setEvaluationAverage(storeBO.getStoreEvaluationAverage());
				// 设置地区
				Area area = areaService.getCacheById(storeBO.getAreaId());
				// DicBase area = dicContent.getDic(Area.class,
				// CommUtil.null2String(area.getCode()));
				storeBO.setArea(area.getName());
				// 设置距离
				if (storeBO.getStoreLon() != null && storeBO.getStoreLat() != null) {
					Double distance = DistanceUtils.GetDistance(CommUtil.null2Double(storeBO.getStoreLon()),
							CommUtil.null2Double(storeBO.getStoreLat()), storeLon, storeLat);
					storeBO.setDistance(distance);
				} else {
					storeBO.setDistance(null);
				}
				// 设置图片
				AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
				if (albumBO != null) {
					Accessory accessory = accessoryServiceImpl.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
					if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
						storeBO.setStoreInfoPath(accessory.getPath());
					}
				}
				// 折扣*10，方便APP显示
				if (storeBO.getGroupDiscount() != null) {
					storeBO.setGroupDiscount(storeBO.getGroupDiscount().multiply(new BigDecimal(10)));
				}
			}
		}
		page.setContent(list);
	}

	public void queryBusinessPageList(StoreVO vo, MyPage<StoreBO> page) {
		page.setContent(storeDao.queryBusinessPageList(vo, page));
	}

	public StoreBO queryStoreByCreateUserId(Long uid) {
		return storeDao.queryStoreByCreateUserId(uid);
	}

	/**
	 * 刷新条缓存
	 * 
	 * @return cc
	 */
	@Transactional(readOnly = true)
	public StoreBO refreshGroupCase(Long id) {
		StringBuilder key = new StringBuilder(store_cached_key);
		key.append(":").append(id);
		StoreBO store = getObjById(id);
		cacheUtils.set(key.toString(), store, expireTime);
		// localCache.invalidateAll();
		return store;
	}

	/**
	 * 对内使用//查询是否存在该店铺id所对应的缓存，不存在则重新load缓存
	 * 
	 * @return cc
	 */
	private StoreBO toGetGroupCase(Long id) {
		StringBuilder key = new StringBuilder(store_cached_key);
		key.append(":").append(id);
		StoreBO store = cacheUtils.get(key.toString(), new TypeReference<StoreBO>() {});
		if (store == null) {
			store = getObjById(id);
			cacheUtils.set(key.toString(), store, expireTime);
		}
		return store;
	}

	public StoreBO getObjById_(Long id) {
		return toGetGroupCase(id);
	}

	/***
	 * 供应商入驻
	 * 
	 * @param vo
	 *            入驻信息
	 * @param uid
	 *            uid
	 * @param storeId
	 *            店铺Id
	 * 
	 */
	public StoreApplyInfo supplierSaveService(String loginName, StoreApplyVO vo, Long uid, Long storeId)
			throws ServiceException {
		// 处理其它附件不超过5个
		if (StringUtils.isNotBlank(vo.getOtherPhotoPath())) {
			String[] otherImg = vo.getOtherPhotoPath().split(";");
			if (otherImg.length > 5) {
				vo.setOtherPhotoPath(StringUtils.join(Arrays.copyOf(otherImg, 5), ";"));
			}
		}

		StoreApplyInfo applyInfo = mapper.map(vo, StoreApplyInfo.class);

		// //////////////////////////////////////////////////////////////////////////////////////////////start
		if (CommUtil.isNotNull(vo.getOperateNumber())) {
			OperatorBO operatorBO = this.operatorService.getOperatorBOByOperatorCode(vo.getOperateNumber());// 推荐人
			if (operatorBO != null) {

				if (UserContants.OPERATOR_LEVEL_GOLD.equals(operatorBO.getLevel())
						|| UserContants.OPERATOR_LEVEL_SILVER.equals(operatorBO.getLevel())) {
					System.out.println("运营商金卡 银卡 不能推荐供应商");
					throw new ServiceException("运营商金卡 银卡 不能推荐供应商！");
				}

				if (operatorBO.getCn_username() != null
						&& operatorBO.getCn_username().startsWith(UserContant.ACCOUNT_TYPE_CN)) {

					CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operatorBO.getCn_username());

					if (null == cn || null == cn.getUserType() || "" == cn.getUserType()) {
						System.out.println("结算平台未查询到该运营商，请稍后再试");
						throw new ServiceException("结算平台未查询到该运营商，请稍后再试！");
					}

					if (cn != null && OrclUserContants.OPERATOR_LEVEL_GOLD.equals(cn.getUserType())
							|| OrclUserContants.OPERATOR_LEVEL_SILVER.equals(cn.getUserType())) {
						System.out.println("金卡，银卡级别不能推荐供应商!");
						throw new ServiceException("金卡，银卡级别不能推荐供应商!");
					}
				}

				// 删除运营商关系
				/*			userOwnService.deleteOwns(uid);
							this.userOwnService.saveUserOwns(uid, operatorBO.getUserId());*/

			} else {
				System.out.println("运营商编码不存在");
				throw new ServiceException("请联系该经销商 先登录运营系统完善信息！");
			}
		}

		// 添加店铺基本数据
		Store store = mapper.map(vo, Store.class);
		store.setAddTime(new Date());
		store.setIsShop(true);
		store.setIsO2o(false);
		store.setStoreStatus(StoreConstants.STORE_STATUS_SYS_AUDIT);// 状态 正在审核公司信息5
		store.setCreateUserId(uid);
		store.setLicenseCName(vo.getLicenseCName());
		store.setGcMainId(vo.getGroupMainId());
		// gradeId
		store.setGradeId(CommUtil.null2Long(4));

		Store storeRes = this.saveStoreApply(loginName, store);

		// 添加店铺审核资料
		applyInfo.setAddTime(new Date());
		applyInfo.setStoreId(storeRes.getId());
		StoreApplyInfo storeApplyInfoRes = storeApplyInfoDao.create(applyInfo);
		return storeApplyInfoRes;
	}

	private Store saveStoreApply(String sellerUserName, Store store) {
		if (store.getId() == null) {
			// 新增环境相册
			Album album = new Album();
			album.setAddTime(new Date());
			album.setAlbumName("环境相册");
			album.setAlbumSequence(-9999);
			album.setAlbumDefault(false);
			album.setStoreInfoDefault(true);
			album.setUserId(store.getCreateUserId());
			this.albumDao.save(album);

			// 添加卖家权限
			List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_SELLER);

			List<Long> rids = sellerService.getStoreRole(roles, store);
			this.userService.saveUserRole(store.getCreateUserId(), UserContant.ROLE_TYPE_SELLER,
					rids.toArray(new Long[rids.size()]));
		}

		// 保存商铺
		Store res = this.storeDao.save(store);

		// 保存卖家
		Seller seller = new Seller();
		seller.setUid(store.getCreateUserId());
		seller.setUserName(sellerUserName);
		seller.setReport(0);
		seller.setStatus(1);
		seller.setStoreId(store.getId());
		sellerDao.create(seller);

		return res;
	}

	/***
	 * 修改资料提交
	 * 
	 * @param applyVO
	 * @param storeId
	 */
	@Transactional
	public void supplierUpdate(StoreApplyVO applyVO, Long storeId, Long uid) throws ServiceException {

		/*** 修改提价资料信息 ***/
		StoreApplyInfo info = null;
		if (applyVO != null) {
			info = new StoreApplyInfo();
			BeanUtils.copyProperties(applyVO, info);
			info.setStoreId(storeId);
		}

		// 处理其它附件不超过5个
		if (StringUtils.isNotBlank(applyVO.getOtherPhotoPath())) {
			String[] otherImg = applyVO.getOtherPhotoPath().split(";");
			if (otherImg.length > 5) {
				info.setOtherPhotoPath(StringUtils.join(Arrays.copyOf(otherImg, 5), ";"));
			}
		}
		this.storeApplyInfoDao.update(info);

		/*** 修改关系 ***/
		/*		OperatorBO operatorBO = this.operatorService.getOperatorBOByOperatorCode(applyVO.getOperateNumber());// 推荐人
				userOwnService.deleteOwns(uid);
				this.userOwnService.saveUserOwns(uid, operatorBO.getUserId());*/

		/*** 修改店信息 ***/
		Store store = mapper.map(applyVO, Store.class);
		store.setId(storeId);
		store.setStoreStatus(StoreConstants.STORE_STATUS_SYS_AUDIT);// 状态 正在审核公司信息5
		store.setGcMainId(applyVO.getGroupMainId());// 类型
		this.storeDao.update(store);
	}

	public StoreBO findObjById(Long id) {
		return this.storeDao.findObjById(id);
	}

	public StoreBO findOne(Long id) {
		return this.storeDao.findOne(id);
	}

	/***
	 * 
	 * 检查 供应商 关系
	 * 
	 * @param number
	 * @return
	 */
	public Integer checkOperateNo(String number) {
		Integer resNo = 0;// 默认没填写
		if (StringUtils.isNotBlank(number)) {
			number = number.toUpperCase();
			OperatorBO operatorBO = this.operatorService.getOperatorBOByOperatorCode(number);
			if (null != operatorBO && StringUtils.isNotBlank(operatorBO.getLevel())) {

				if (number.startsWith("YY")) {
					resNo = 1;// 市区级运营商
				} else {
					if (UserContants.OPERATOR_LEVEL_GOLD.equals(operatorBO.getLevel())) {
						resNo = 7;// 金卡 不能推荐供应商
					} else if (UserContants.OPERATOR_LEVEL_SILVER.equals(operatorBO.getLevel())) {
						resNo = 9;// 银卡
					} else if (UserContants.OPERATOR_LEVEL_QUYU.equals(operatorBO.getLevel())) {
						resNo = 3;// vip 经销商
					}
				}
			} else {
				resNo = 0; // 运营商 没完善信息
				UserAccountBO user = userAccountService.findByLoginName(number);
				if(null == user){
					resNo = -1;//运营商不存在
				}
			}
		}
		return resNo;
	}

	/***
	 * 审核绑定关系
	 * 
	 * @param storeId
	 */
	public void checkStoreSaveUserOwns(Long storeId) {
		StoreApplyInfoBO storeApplyInfoBO = this.storeApplyInfoDao.queryStoreApplyInfo(storeId);
		if (null != storeApplyInfoBO && null != storeApplyInfoBO.getOperateNumber()) {
			String code = storeApplyInfoBO.getOperateNumber().toUpperCase();
			StoreBO storeBO = this.storeDao.get(storeApplyInfoBO.getStoreId());
			OperatorBO operatorBO = this.operatorService.getOperatorBOByOperatorCode(code);// 推荐人
			if (null != operatorBO) {
				Integer ownType =2;
				userOwnService.deleteOwns(storeBO.getCreateUserId(),ownType);
				this.userOwnService.saveUserOwns(storeBO.getCreateUserId(), operatorBO.getId(), ownType);
			}
		}

	}

	/**
	 * 审核短信提醒
	 * 
	 * @param storeId
	 *            店铺ID
	 * @param storeStauts
	 *            审核状态（15 审核成功）
	 * @param type
	 *            审核类型 （merchants 商户审核，stroe 供应商审核）
	 * @throws Exception
	 */
	public void sendMsgToAudit(String storeId, Integer storeStauts, String type) throws Exception {
		// 验证店铺ID不为空
		if (CommUtil.isNotNull(storeId)) {
			// 根据店铺ID获取商家信息
			Seller seller = sellerService.findByStore(CommUtil.null2Long(storeId));
			// 发送短信
			if (null != seller && CommUtil.isNotNull(seller.getUserName())) {
				String mark = null;
				String[] params = null;
				if (StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS == storeStauts) { // 审核通过
					switch (type) {
						case StoreConstants.AUDIT_TYPE_MERCHANTS:
							mark = StoreConstants.SMS_MERCHANTS_APPROVED; // 商户审核通过提醒
							break;
						case StoreConstants.AUDIT_TYPE_STORE:
							mark = StoreConstants.SMS_STORE_APPROVED;// 供应商审核通过提醒
							break;
					}
				} else { // 审核未通过
					switch (type) {
						case StoreConstants.AUDIT_TYPE_MERCHANTS:
							mark = StoreConstants.SMS_MERCHANTS_NOT_APPROVED;// 商户审核不通过提醒
							break;
						case StoreConstants.AUDIT_TYPE_STORE:
							mark = StoreConstants.SMS_STORE_NOT_APPROVED;// 供应商审核不通过提醒
							break;
					}
				}
				// 短信发送到类型为手机号的账号上
				UserAccount userAccount = userAccountService.findUserAccount(seller.getUid(),
						UserContant.ACCOUNT_TYPE_2);
				if (null != userAccount) {
					log.info("Seller Mobile===" + userAccount.getLoginName() + "===，mark===" + mark
							+ "===，type===" + type);
					this.msgTools.sendSms(mark, userAccount.getLoginName(), params);
				}
			}
		}
	}
}
