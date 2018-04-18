package vc.thinker.b2b2c.exportvo;

import org.apache.commons.lang3.StringUtils;

import com.sinco.office.excel.annotation.ExcelField;

public class AreaOperatorVO {
	@ExcelField(title = "运营商姓名", align = 1, sort = 1)
	private String userName;
	@ExcelField(title = "运营商编号", align = 1, sort = 2)
	private String operatorCode;
	@ExcelField(title = "运营商级别", align = 1, sort = 3)
	private String level;
	@ExcelField(title = "运营商辖区", align = 1, sort = 4)
	private String areaName;
	@ExcelField(title = "联系电话", align = 1, sort = 5)
	private String phone;
	@ExcelField(title = "隶属商户总数", align = 1, sort = 6)
	private String countShop;
	@ExcelField(title = "所属商户的会员总数", align = 1, sort = 7)
	private String countShopMember;
	@ExcelField(title = "注册会员总数", align = 1, sort = 8)
	private String countRegisterUser;
	@ExcelField(title = "会员购买线上服务的总数", align = 1, sort = 9)
	private String countRegisterUserOrder;
	@ExcelField(title = "本周收益统计", align = 1, sort = 10)
	private String currentWeekRebate;
	@ExcelField(title = "本月收益统计", align = 1, sort = 11)
	private String currentMonthRebate;
	@ExcelField(title = "历史收益统计", align = 1, sort = 12)
	private String totle;
	@ExcelField(title = "消费返润总额", align = 1, sort = 13)
	private String rebateConsumeAmount;
	@ExcelField(title = "手续费返润总额", align = 1, sort = 14)
	private String rebateFeeAmount;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountShopMember() {
		return countShopMember;
	}

	public void setCountShopMember(String countShopMember) {
		this.countShopMember = countShopMember;
	}

	public String getCountRegisterUser() {
		return countRegisterUser;
	}

	public void setCountRegisterUser(String countRegisterUser) {
		this.countRegisterUser = countRegisterUser;
	}

	public String getCountRegisterUserOrder() {
		return countRegisterUserOrder;
	}

	public void setCountRegisterUserOrder(String countRegisterUserOrder) {
		this.countRegisterUserOrder = countRegisterUserOrder;
	}

	public String getCurrentWeekRebate() {
		if (StringUtils.isEmpty(currentWeekRebate)) {
			currentWeekRebate = "0";
		}
		return currentWeekRebate;
	}

	public void setCurrentWeekRebate(String currentWeekRebate) {
		this.currentWeekRebate = currentWeekRebate;
	}

	public String getCurrentMonthRebate() {
		if (StringUtils.isEmpty(currentMonthRebate)) {
			currentMonthRebate = "0";
		}
		return currentMonthRebate;
	}

	public void setCurrentMonthRebate(String currentMonthRebate) {
		this.currentMonthRebate = currentMonthRebate;
	}

	public String getTotle() {
		double t = 0;
		if (getRebateFeeAmount() != null) {
			t = t + Double.parseDouble(getRebateFeeAmount());
		}
		if (getRebateConsumeAmount() != null) {
			t = t + Double.parseDouble(getRebateConsumeAmount());
		}
		return String.valueOf(t);
	}

	public void setTotle(String totle) {
		this.totle = totle;
	}

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
}
