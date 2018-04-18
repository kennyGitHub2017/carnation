package cn.eeepay;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 第三方刷卡的注册返回结果
 * 
 * @author james
 * 
 */
public class EeePayRegisterResult {
	/**
	 * 错误信息
	 */
	private String errMsg;

	/**
	 * 错误提示
	 */
	private String error;

	private boolean succeed;

	private String merchantNo;

	private String sdkKey;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isSucceed() {
		return succeed;
	}

	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getSdkKey() {
		return sdkKey;
	}

	public void setSdkKey(String sdkKey) {
		this.sdkKey = sdkKey;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}
}
