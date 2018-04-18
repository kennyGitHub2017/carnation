package com.sinco.carnation.user.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.UserOwnsDao;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.model.UserOwns;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicParentBase;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * @ClassName: UserOwnService
 * @Description: TODO(用户隶属关系)
 * @author Tang
 * @date 2015年9月8日 下午8:01:05
 * 
 */
@Service
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class UserOwnService {
	@Autowired
	private UserOwnsDao userOwnsDao;
	@Autowired
	private OperatorDao operatorDao;
	@Autowired
	private DicContent dicContent;

	@Transactional(readOnly = false)
	public void deleteOwns(Long sellerUserId,Integer ownType) {
		userOwnsDao.delete(sellerUserId,ownType);
	}

	public boolean sellerHasOperator(Long sellerId,Integer ownType) {
		UserOwnsBO userOwns = userOwnsDao.get(sellerId, ownType);
		if (userOwns != null && (userOwns.getOwnOperatorId() != null)) {
			return true;
		}
		return false;
	}

	/**
	 * @throws ServiceException
	 * 
	 * @Title: updateUserOwns
	 * @Description: TODO(手动更新用户隶属关系)
	 * @param @param sellerId
	 * @param @param operatorCode 设定文件
	 * @return void 返回类型
	 * @author Tang
	 * @throws
	 */
	@Transactional(readOnly = false)
	public String updateUserOwns(Long sellerId, String operatorCode, Long areaId, Integer ownType) throws ServiceException {
		String resultOperatorCode = operatorCode;
		if (sellerId == null) {
			throw new ServiceException("参数不正确！");
		}
		UserOwnsBO userOwns = userOwnsDao.get(sellerId,ownType);
		if (userOwns == null) {
			return createUserOwns(sellerId, operatorCode, CommUtil.null2String(areaId),ownType);
		} else {
			if (StringUtils.isNotEmpty(operatorCode)) {
				setSellerOwns(operatorCode, userOwns, CommUtil.null2String(areaId));
			}
			userOwns.setUpdateTime(new Date());
			userOwnsDao.update(userOwns);
		}
		return resultOperatorCode;
	}

	/**
	 * @throws ServiceException
	 * 
	 * @Title: createUserOwns
	 * @Description: TODO(创建商户运营商隶属关系)
	 * @param @param sellerId
	 * @param @param operatorCode 设定文件
	 * @return void 返回类型
	 * @author Tang
	 * @throws
	 */
	@Transactional(readOnly = false)
	public String createUserOwns(Long sellerId, String operatorCode, String areaId,Integer ownType) throws ServiceException {
		String resultOperatorCode = null;

		if (sellerId == null) {
			throw new ServiceException("商户ID不能为空！");
		}
		UserOwns userOwns = new UserOwns();
		userOwns.setSellerUserId(sellerId);
		userOwns.setUpdateTime(new Date());
		userOwns.setCreateTime(new Date());
		userOwns.setOwnType(ownType);//增加类型

		/*
		 * 如果有填写运营商编码，就按照运营商编码来，如果没有的话呢，那就需要进行轮播
		 * 轮播的规则是：
		 * 	如果区，市，区域全部都没有都话（或者，区，区域没有），那么就添加一个空的隶属关系就行了
		 * 	如果区域，区存在其中任何一个的话，那根据分配时间顺序排列来分配，分配完了之后更新分配时间，相当于排队机制
		 * 
		 */
		if (StringUtils.isNotEmpty(operatorCode)) {
			setSellerOwns(operatorCode, userOwns, areaId);
			resultOperatorCode = operatorCode;
		} else // 如果说没有的话，那么就要拿到当前商户所在的地区区匹配，只轮询区和区域
		{
			if (StringUtils.isEmpty(areaId)) {
				throw new ServiceException("该服务商所在地区为空！");
			}
			// 查询出该地区下的所有运营商(这里只包括区级、区域级)
			List<OperatorBO> listOperator = operatorDao
					.getOperatorBOByOperatorAreaIdOrderByAssignedTime(areaId);
			if (CollectionUtils.isNotEmpty(listOperator)) {
				// 如果在这个区中有任何运营商的话，那么拿到排序过的第一个，分配给第一个运营商
				OperatorBO giveOperator = listOperator.get(0);
				resultOperatorCode = giveOperator.getOperatorCode();
				userOwns.setOwnOperatorId(giveOperator.getId());
				// 那如果这个分过了之后就要把这个时间更新到最新时间，重新排队
				Operator update = new Operator();
				update.setId(giveOperator.getId());
				update.setAssignedTime(new Date());
				update.setUpdateTime(new Date());
				operatorDao.update(update);
			}
		}
		userOwnsDao.insert(userOwns);
		return resultOperatorCode;
	}

	private void setSellerOwns(String operatorCode, UserOwns userOwns, String areaId) throws ServiceException {
		OperatorBO operatorBO = operatorDao.getOperatorBOByOperatorCode(operatorCode);
		if (operatorBO == null) {
			throw new ServiceException("您的推荐人尚未完成基本信息，如需快速入驻，请联系您的推荐人，下载运营商APP完善基本信息，确保您的隶属关系。请在官网（www.ysysgo.com）下载运营商APP");
		}
		if (StringUtils.isEmpty(areaId)) {
			throw new ServiceException("该服务商所在地区为空！");
		}
		if (null == operatorBO.getLevel()) {
			throw new ServiceException("您输入的邀请码不是运营商、金卡或VIP！请确认后再重新提交！");
		}
		Area area = (Area) dicContent.getDic(Area.class, String.valueOf(areaId));
		String cityCode = null;
		if (area != null) {
			cityCode = area.getParentCode();
		}
		if (cityCode == null) {
			throw new ServiceException("商户地区错误！");
		}

		// 判断填写的运营商是哪个级别

		switch (operatorBO.getLevel()) {
			case UserContants.OPERATOR_LEVEL_SHI:
				// 如果市级和商户地区得出的市级不同的话，那么是不允许的
				if (!cityCode.equals(operatorBO.getOperatorAreaId())) {
					throw new ServiceException("您的推荐人不是本市运营商或金卡、VIP会员！请确认后再重新提交！");
				}
				break;
			default:
				// 如果是区级的话，那么二级运营商都是该市级
				// 要查询处当前区域的市级
//				OperatorBO parentShi = getParentOperator(operatorBO.getOperatorAreaId(),
//						UserContants.OPERATOR_LEVEL_SHI);
				Area area01 = (Area) dicContent.getDic(Area.class, String.valueOf(operatorBO.getOperatorAreaId()));
				String operatorcityCode = area01.getParentCode();
//				if (parentShi != null) {
					// 如果市级和商户地区得出的市级不同的话，那么是不允许的
					if (!cityCode.equals(operatorcityCode)) {
						throw new ServiceException("您的推荐人不是本市运营商或金卡、VIP会员！请确认后再重新提交！");
					}
//				}
				userOwns.setOwnOperatorId(operatorBO.getId());
				break;
		}
		userOwns.setOwnOperatorId(operatorBO.getId());

	}

	private OperatorBO getParentOperator(String operatorAreaId, String level) {
		@SuppressWarnings("rawtypes")
		DicParentBase dicArea = (DicParentBase) dicContent.getDic(Area.class, operatorAreaId);
		String parentAreaId = dicArea.getParentCode();
		List<OperatorBO> list = operatorDao.getOperatorBOByOperatorAreaIdAndLevel(parentAreaId, level);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	public OperatorBO getParentOperator(Long operatorAreaId, String level)
	{
		return this.getParentOperator(String.valueOf(operatorAreaId), level);
	}

	public UserOwnsBO findOne(java.lang.Long id,Integer ownType) {
		return userOwnsDao.findOne(id,ownType);
	}

	public UserOwnsBO get(java.lang.Long id,Integer ownType) {
		return userOwnsDao.get(id,ownType);
	}

	/**
	 * 根据商户用户ID获取商户隶属运营商用户名称
	 * 
	 * @param id
	 * @return
	 */
	public String getUserName(java.lang.Long id,Integer ownType) {
		String userName = StringUtils.EMPTY;
		UserOwnsBO bo = userOwnsDao.get(id,ownType);
		if (bo != null && bo.getOwnOperatorId() != null) {
			OperatorBO uo = operatorDao.get(bo.getOwnOperatorId());
			if (uo != null) {
				userName = uo.getUserName();
			}
		}
		return userName;
	}

	/**
	 * 根据商户用户ID获取商户隶属运营商名称-operatorName
	 * 
	 * @param id
	 * @return
	 */
	public String getOperatorName(java.lang.Long id,Integer ownType) {
		String operatorName = StringUtils.EMPTY;
		UserOwnsBO bo = userOwnsDao.get(id,ownType);
		if (bo != null && bo.getOwnOperatorId() != null) {
			OperatorBO uo = operatorDao.get(bo.getOwnOperatorId());
			if (uo != null) {
				operatorName = uo.getOperatorName();
			}
		}
		return operatorName;
	}

	public List<UserOwnsBO> findAllSellerByOperId(Long operId) {
		return this.userOwnsDao.findAllSellerByOperId(operId);
	}

	/***
	 * 增加运营商所属关系
	 * 
	 * @return
	 */
	public UserOwns saveUserOwns(Long sellerUserId, Long ownOperatorId,Integer ownType) {
		UserOwns userOwns = new UserOwns();
		userOwns.setOwnOperatorId(ownOperatorId);
		userOwns.setSellerUserId(sellerUserId);
		userOwns.setCreateTime(new Date());
		userOwns.setUpdateTime(new Date());
		userOwns.setOwnType(ownType);
		return this.userOwnsDao.insert(userOwns);
	}
}
