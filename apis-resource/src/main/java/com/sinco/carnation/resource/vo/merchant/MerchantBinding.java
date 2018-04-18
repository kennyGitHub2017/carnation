package com.sinco.carnation.resource.vo.merchant;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * 绑定会员VO
 * @author yuleijia
 *
 */
public class MerchantBinding extends BasicParamVO{

	@Param(desc = "手机号码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;
	
	@Param(desc = "验证码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String verCode;
	
	@Param(desc = "密码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String passWord;
	
	@Param(desc = "微信UnionID")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String unionid;

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
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
	
	
}
