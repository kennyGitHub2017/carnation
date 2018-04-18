package com.sinco.carnation.user.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.WxInvitationRelationBO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.WxInvitationRelationDao;
import com.sinco.carnation.user.model.WxInvitationRelation;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * @ClassName: UserWeiXinRelationService
 * @Description: TODO(微信推荐关系)
 * @author linbu
 * @date 2016年01月30日
 * 
 */
@Service
public class UserWeiXinRelationService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WxInvitationRelationDao weixinRelationDao;

	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private IntegralService integralService;

	/**
	 * 判断用户是否已经通过微信注册
	 * 
	 * @param openId
	 * @param ownerId
	 * @return
	 */
	public boolean isRegisterByWeiXin(String unionId) {
		boolean flag = false;
		UserAccountBO userAccountBO = userService.findByLoginName(unionId, UserContant.ACCOUNT_TYPE_4);
		//
		if (userAccountBO != null) {
			flag = true;
		}
		return flag;
		// 根据openId判断用户是否已存在
		// return userRelationDao.get(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String createAndBindRelateByWeixin(String unionId, String openId, String nickName,
			String headImgPath, Long ownerId) {

		try {
			if (this.isRegisterByWeiXin(unionId)) {// unionId用户记录已存在sys_user_account
				return "您的微信号已注册";
			}

			// 如果没有绑定微信关系，则创建
			WxInvitationRelationBO bo = weixinRelationDao.findByUnionId(unionId);
			if (bo != null) {// 已绑定关系
				return "您的微信号已被推荐";
			}

			// 1.创建关系时
			WxInvitationRelation record = new WxInvitationRelation();
			record.setCreateTime(new Date());
			record.setUnionId(unionId);
			record.setOpenId(openId);
			record.setOwnerId(ownerId);
			record.setNickName(nickName);
			record.setHeadImgPath(headImgPath);
			weixinRelationDao.save(record);

			// 2.给ownerId加20积分
			integralService.addIntegral(IntegralConstants.INTEGRAL_INVITE_FRIENDS, ownerId, null);

		} catch (Exception e) {
			log.error("关系绑定异常:{}", CommUtil.getStackTrace(e));
			return "关系绑定异常";
		}

		return null;

	}

}
