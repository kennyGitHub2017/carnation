package com.sinco.carnation.user.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class Seller extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6913579214329983394L;

	/**  **/
	private Long uid;

	/** 用户名 */
	private String userName;

	/** 姓名 **/
	private String name;

	/** 昵称 **/
	private String nickname;

	/**  **/
	private String msn;

	/**  **/
	private String qq;

	/** 旺旺 **/
	private String ww;

	/** 公司地址 **/
	private String companyAddress;

	/** 公司名称 **/
	private String companyName;

	/** 公司性质 **/
	private String companyNature;

	/** 公司员工人数 **/
	private String companyPersonNum;

	/** 购买类型 **/
	private String companyPurpose;

	/** 公司行业 **/
	private String companyTrade;

	/** 公司网址 **/
	private String companyUrl;

	/** 公司联系人 **/
	private String contactUser;

	/** 公司联系人所在部门 **/
	private String department;

	/**  **/
	private String email;

	/**  **/
	private String mobile;

	/** 是否允许举报商品,0为允许，-1为不允许 **/
	private Integer report;

	/** 状态 **/
	private Integer status;

	/** 店铺申请进行的步骤，默认为0,总共分为0、1、2、3、4、5、6、7、8 **/
	private Integer storeApplyStep;

	/**  **/
	private String telephone;

	/** 如果为卖家子账号，则该属性不为空，通过该属性获取卖家子账号对应的店铺信息 **/
	private Long parentId;

	/**  **/
	private String photoPath;

	/** 店铺 **/
	private Long storeId;

	/** 用户店铺常用分类，使用json管理[{"id",1"name":"女装"},{"id",3"name":"男装"}]这里只记录最底层分类的id **/
	private String stapleGc;

	/** 用户保密 **/
	private String userMark;

	/** 商户创建时间 **/
	private Date createTime;

	/** 机具编号 **/
	private String implementNumber;
	
	private Long id;//主键ID

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWw() {
		return ww;
	}

	public void setWw(String ww) {
		this.ww = ww;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyNature() {
		return companyNature;
	}

	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}

	public String getCompanyPersonNum() {
		return companyPersonNum;
	}

	public void setCompanyPersonNum(String companyPersonNum) {
		this.companyPersonNum = companyPersonNum;
	}

	public String getCompanyPurpose() {
		return companyPurpose;
	}

	public void setCompanyPurpose(String companyPurpose) {
		this.companyPurpose = companyPurpose;
	}

	public String getCompanyTrade() {
		return companyTrade;
	}

	public void setCompanyTrade(String companyTrade) {
		this.companyTrade = companyTrade;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getReport() {
		return report;
	}

	public void setReport(Integer report) {
		this.report = report;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStoreApplyStep() {
		return storeApplyStep;
	}

	public void setStoreApplyStep(Integer storeApplyStep) {
		this.storeApplyStep = storeApplyStep;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStapleGc() {
		return stapleGc;
	}

	public void setStapleGc(String stapleGc) {
		this.stapleGc = stapleGc;
	}

	public String getUserMark() {
		return userMark;
	}

	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getImplementNumber() {
		return implementNumber;
	}

	public void setImplementNumber(String implementNumber) {
		this.implementNumber = implementNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}