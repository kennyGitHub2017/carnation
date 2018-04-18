package vc.thinker.b2b2c.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sinco.office.excel.annotation.ExcelField;

public class OperatorExportVO {
	@ExcelField(title = "编码", align = 1, sort = 1)
	private String operatorCode;
	@ExcelField(title = "级别", align = 1, sort = 1)
	private String level;
	@ExcelField(title = "名称", align = 1, sort = 1)
	private String operatorName;
	@ExcelField(title = "姓名", align = 1, sort = 1)
	private String userName;
	@ExcelField(title = "身份证", align = 1, sort = 1)
	private String idCard;
	@ExcelField(title = "电话", align = 1, sort = 1)
	private String phone;
	@ExcelField(title = "运营地", align = 1, sort = 1)
	private String areaName;
	@ExcelField(title = "推荐人编码", align = 1, sort = 1)
	private String refereeOperatorCode;
	@ExcelField(title = "推荐人姓名", align = 1, sort = 1)
	private String refereeUserName;
	@ExcelField(title = "状态", align = 1, sort = 1)
	private String status;
	@ExcelField(title = "创建时间", align = 1, sort = 1)
	private Date createTime;

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getLevel() {
		switch (level) {
			case "1":
				level = "市级";
				break;
			case "2":
				level = "区级";
				break;
			case "3":
				level = "区域级";
				break;
		}
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRefereeOperatorCode() {
		if (StringUtils.isNotEmpty(refereeOperatorCode)) {
			return refereeOperatorCode;
		} else {
			return "无";
		}
	}

	public void setRefereeOperatorCode(String refereeOperatorCode) {
		this.refereeOperatorCode = refereeOperatorCode;
	}

	public String getRefereeUserName() {
		if (StringUtils.isNotEmpty(refereeUserName)) {
			return refereeUserName;
		} else {
			return "无";
		}
	}

	public void setRefereeUserName(String refereeUserName) {
		this.refereeUserName = refereeUserName;
	}

	public String getStatus() {
		switch (status) {
			case "0":
				status = "审核中";
				break;
			case "1":
				status = "审核通过";
				break;
			case "-1":
				status = "审核不通过";
				break;
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
