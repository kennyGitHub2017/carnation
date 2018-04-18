package com.sinco.carnation.resource.vo.merchant;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
/**
 * 商户入驻-注册会员
 * @author yuleijia
 * 		2017.4.14
 */
public class MerchantRegisterVO extends BasicParamVO{

	@Param(desc = "手机号码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;
	
	@Param(desc = "验证码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String verCode;
	
	@Param(desc = "密码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String passWord;
	
	@Param(desc = "邀请码")
	private String invitationCode;
	
	@Param(desc = "微信UnionID")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String unionid;
	
	@Param(desc = "微信头像")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String headImgUrl;
	
	@Param(desc = "微信openID")
	private String openID;
	
	@Param(desc = "微信昵称")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String nickName;
	
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVerCode() {
		return verCode;
	}

	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	
	
}
