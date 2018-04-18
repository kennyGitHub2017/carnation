package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Relation", desc = "邀请明细")
public class RelationBO {

	@JsonProperty("uid")
	@FieldMapping(desc = "用户id")
	private Long uid;

	@JsonProperty("refereeUserId")
	@FieldMapping(desc = "邀请人用户id")
	private Long refereeUserId;

	/** 姓名 **/
	@JsonProperty("name")
	@FieldMapping(desc = "姓名")
	private String name;

	/** 昵称 **/
	@JsonProperty("nickname")
	@FieldMapping(desc = "昵称")
	private String nickname;

	/** 头像路径 **/
	@JsonProperty("headImgPath")
	@FieldMapping(desc = "头像路径 ")
	private String headImgPath;

	/** 手机 **/
	@JsonProperty("mobile")
	@FieldMapping(desc = "手机")
	private String mobile;

	@JsonProperty("registerTime")
	@FieldMapping(desc = "注册时间")
	private Date registerTime;

	@JsonProperty("time")
	@FieldMapping(desc = "注册时间")
	private String time;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRefereeUserId() {
		return refereeUserId;
	}

	public void setRefereeUserId(Long refereeUserId) {
		this.refereeUserId = refereeUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
