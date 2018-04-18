package vc.thinker.b2b2c.action.weChat;

/**
 * 微信用户个人信息
 * 
 * @author yuleijia
 */
public class WCUserInfoBO {

	/**
	 * 普通用户的标识，对当前开发者帐号唯一
	 */
	private String openid;
	/**
	 * 普通用户昵称
	 */
	private String nickName;
	/**
	 * 普通用户性别，1为男性，2为女性
	 */
	private String sex;
	/**
	 * 普通用户个人资料填写的省份
	 */
	private String province;
	/**
	 * 普通用户个人资料填写的城市
	 */
	private String city;
	/**
	 * 国家，如中国为CN
	 */
	private String country;
	/**
	 * 用户头像
	 */
	private String headimgurl;
	/**
	 * 用户特权信息，json数组
	 */
	private String privilege;
	/**
	 * 用户统一标识
	 */
	private String unionid;

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	/*
	 * 微信授权接口文档
	 * https://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
	 */
}
