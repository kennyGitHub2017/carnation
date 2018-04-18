package com.sinco.carnation.resource.bo.healthcircle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserBO", desc = "健康圈个人首页个人信息")
public class UserBO {
	@JsonProperty("uid")
	@FieldMapping(desc = "用户uid")
	private Long uid;

	@JsonProperty("nickname")
	@FieldMapping(desc = "用户名称")
	private String nickname;

	@JsonProperty("headImgPath")
	@FieldMapping(desc = "用户头像")
	private String headImgPath;

	@JsonProperty("sex")
	@FieldMapping(desc = "用户性别,1:男, 2:女 保密 -1")
	private Integer sex;

	@JsonProperty("level")
	@FieldMapping(desc = "用户等级")
	private Integer level;

	@JsonProperty("userSignature")
	@FieldMapping(desc = "用户签名")
	private String userSignature;

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

}
