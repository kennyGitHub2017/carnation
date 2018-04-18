package com.sinco.carnation.sys.bo.orcl;

/**
 * 获取CN账户的奖金与重消
 * 
 * @author Administrator
 * 
 */
public class CnUserMoneyBO {
	private Integer ISPAY;// 0:不可支付,1可支付
	private Long USER_ID;// 会员id
	private String USER_ALIAS;// 会员编号CN
	private Double BONUS;// 奖金余额
	private Double BONUS_REPEAT;// 重消余额

	public Integer getISPAY() {
		return ISPAY;
	}

	public void setISPAY(Integer iSPAY) {
		ISPAY = iSPAY;
	}

	public Long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_ALIAS() {
		return USER_ALIAS;
	}

	public void setUSER_ALIAS(String uSER_ALIAS) {
		USER_ALIAS = uSER_ALIAS;
	}

	public Double getBONUS() {
		if (null == BONUS) {
			return new Double(0);
		}
		return BONUS;
	}

	public void setBONUS(Double bONUS) {
		BONUS = bONUS;
	}

	public Double getBONUS_REPEAT() {
		if (null == BONUS_REPEAT) {
			return new Double(0);
		}
		return BONUS_REPEAT;
	}

	public void setBONUS_REPEAT(Double bONUS_REPEAT) {
		BONUS_REPEAT = bONUS_REPEAT;
	}

}
