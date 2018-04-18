package com.sinco.carnation.sys.bo.orcl;

/**
 * 用户积分兑换
 * @author Tivan
 *
 */
public class IntegralSwapBO {
	/**
	 * 积分兑换状态100兑换成功 |12兑换积分必须大于0|13会员编号不能为空|15流水号不能为空|16同一流水号重复兑换|90交易密码不正确|91直销会员不存在|93请先修改初始交易密码|21积分不足|22非CN用户|23平台用户不存在|24系统错误
	 */
	private Integer RETURN_STATUS;
	/**
	 * 用户积分
	 */
	private Integer SHOP_PV;
	/**
	 * 重消
	 */
	private Double BONUS_REPEAT;
	
	public Integer getRETURN_STATUS() {
		return RETURN_STATUS;
	}
	public void setRETURN_STATUS(Integer rETURN_STATUS) {
		RETURN_STATUS = rETURN_STATUS;
	}
	public Integer getSHOP_PV() {
		return SHOP_PV;
	}
	public void setSHOP_PV(Integer sHOP_PV) {
		SHOP_PV = sHOP_PV;
	}
	public Double getBONUS_REPEAT() {
		return BONUS_REPEAT;
	}
	public void setBONUS_REPEAT(Double bONUS_REPEAT) {
		BONUS_REPEAT = bONUS_REPEAT;
	}
	public String getStatusMsg(){
		if(RETURN_STATUS != null){
			switch (RETURN_STATUS) {
			case 100:
				return "兑换成功";
			case 12:
				return "兑换积分必须大于0";
			case 13:
				return "会员编号不能为空";
			case 15:
				return "流水号不能为空";
			case 16:
				return "同一流水号重复兑换";
			case 90:
				return "交易密码不正确";
			case 91:
				return "直销会员不存在";
			case 93:
				return "请先修改初始交易密码";
			case 21:
				return "积分不足";
			case 22:
				return "非CN用户";
			case 23:
				return "平台用户不存在";
			case 24:
				return "系统错误";
			default:
				break;
			}
		}
		return "";
	}

}
