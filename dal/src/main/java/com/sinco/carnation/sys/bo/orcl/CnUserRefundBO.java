package com.sinco.carnation.sys.bo.orcl;

/**
 * CN账户退款返回结果
 * 
 * @author Administrator
 * 
 */
public class CnUserRefundBO {
	private String ISREFUND;// 1代表退款成功
	private String REFUNFNO;// 直销系统返回的，退款流水号

	public String getISREFUND() {
		return ISREFUND;
	}

	public void setISREFUND(String iSREFUND) {
		ISREFUND = iSREFUND;
	}

	public String getREFUNFNO() {
		return REFUNFNO;
	}

	public void setREFUNFNO(String rEFUNFNO) {
		REFUNFNO = rEFUNFNO;
	}

}
