package vc.thinker.b2b2c.exportvo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sinco.office.excel.annotation.ExcelField;

public class RegisterOperatorVO {
	@ExcelField(title = "运营商姓名", align = 1, sort = 1)
	private String userName;
	@ExcelField(title = "运营商编号", align = 1, sort = 2)
	private String operatorCode;
	@ExcelField(title = "运营商级别", align = 1, sort = 3)
	private String level;
	@ExcelField(title = "运营商辖区", align = 1, sort = 4)
	private String areaName;
	@ExcelField(title = "消费返润", align = 1, sort = 5)
	private String rebateConsumeAmount;
	@ExcelField(title = "手续费返润", align = 1, sort = 6)
	private String rebateFeeAmount;
	@ExcelField(title = "隶属商户", align = 1, sort = 7)
	private String countShop;
	@ExcelField(title = "注册时间", align = 1, sort = 8)
	private Date createTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		if (StringUtils.isNotEmpty(level)) {
			switch (level) {
				case "1":
					level = "市级运营商";
					break;
				case "2":
					level = "区级运营商";
					break;
				case "3":
					level = "区域级运营商";
					break;
			}
		}
		this.level = level;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRebateConsumeAmount() {
		if (StringUtils.isEmpty(rebateConsumeAmount)) {
			rebateConsumeAmount = "0";
		}
		return rebateConsumeAmount;
	}

	public void setRebateConsumeAmount(String rebateConsumeAmount) {
		this.rebateConsumeAmount = rebateConsumeAmount;
	}

	public String getRebateFeeAmount() {
		if (StringUtils.isEmpty(rebateFeeAmount)) {
			rebateFeeAmount = "0";
		}
		return rebateFeeAmount;
	}

	public void setRebateFeeAmount(String rebateFeeAmount) {
		this.rebateFeeAmount = rebateFeeAmount;
	}

	public String getCountShop() {
		return countShop;
	}

	public void setCountShop(String countShop) {
		this.countShop = countShop;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
