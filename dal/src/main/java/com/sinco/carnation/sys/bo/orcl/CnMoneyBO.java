package com.sinco.carnation.sys.bo.orcl;

public class CnMoneyBO {
	private String WALLET_STATUS;// 钱包状态
	private Double MONEY;// 余额
	private Double SHOP_PV;//积分余额

	public String getWALLET_STATUS() {
		return WALLET_STATUS;
	}

	public void setWALLET_STATUS(String wALLET_STATUS) {
		WALLET_STATUS = wALLET_STATUS;
	}

	public Double getMONEY() {
		return MONEY;
	}

	public void setMONEY(Double mONEY) {
		MONEY = mONEY;
	}

	public Double getSHOP_PV() {
		return SHOP_PV;
	}

	public void setSHOP_PV(Double sHOP_PV) {
		SHOP_PV = sHOP_PV;
	}

}
