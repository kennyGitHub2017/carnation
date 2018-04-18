package com.sinco.carnation.resource.bo.healthManage;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserCustomerBO", desc = "用户")
public class UserCustomerBO {

	@JsonProperty("uid")
	@FieldMapping(desc = "uid")
	private Long uid;

	@JsonProperty("name")
	@FieldMapping(desc = "会员名称")
	private String name;

	@JsonProperty("nickName")
	@FieldMapping(desc = "会员昵称")
	private String nickName;

	@JsonProperty("headImgPath")
	@FieldMapping(desc = "头像路径")
	private String headImgPath;

	@JsonProperty("currentRank")
	@FieldMapping(desc = "当前等级")
	private Integer currentRank;

	@JsonProperty("highestRank")
	@FieldMapping(desc = "最高等级")
	private Integer highestRank;

	@JsonProperty("rankJiFen")
	@FieldMapping(desc = "等级积分| eg:1:10|2:20|3:30|4:40|5:50|6:60|7:70|8:80|9:90|10:100 ")
	private String rankJiFen;

	@JsonProperty("sex")
	@FieldMapping(desc = "性别 | 1:男 2:女")
	private Integer sex;

	@JsonProperty("integral")
	@FieldMapping(desc = "用户积分")
	private Integer integral;

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long id) {
		this.uid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public Integer getCurrentRank() {
		return currentRank;
	}

	public void setCurrentRank(Integer currentRank) {
		this.currentRank = currentRank;
	}

	public Integer getHighestRank() {
		return highestRank;
	}

	public void setHighestRank(Integer highestRank) {
		this.highestRank = highestRank;
	}

	public String getRankJiFen() {
		return rankJiFen;
	}

	public void setRankJiFen(String rankJiFen) {
		this.rankJiFen = rankJiFen;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 10);
		map.put("2", 20);
		map.put("2", 20);

		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

}
