package vc.thinker.b2b2c.exportvo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sinco.office.excel.annotation.ExcelField;

public class AreaSellerVO {
	@ExcelField(title = "商户店名", align = 1, sort = 1)
	private String shopName;
	@ExcelField(title = "经营地址", align = 1, sort = 2)
	private String shopAddress;
	@ExcelField(title = "商户类型", align = 1, sort = 3)
	private String gcName;
	@ExcelField(title = "手机号码", align = 1, sort = 4)
	private String mobile;
	@ExcelField(title = "提供的消费反润总额", align = 1, sort = 5)
	private String rebateConsumeAmount;
	@ExcelField(title = "提供的消费反润总额", align = 1, sort = 6)
	private String rebateFeeAmount;
	@ExcelField(title = "注册时间", align = 1, sort = 7)
	private Date createTime;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
