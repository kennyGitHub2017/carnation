package com.sinco.carnation.resource.vo.physical;

import com.sinco.api.annotation.Param;

/**
 * 体检宝
 * 
 * @author king
 * 
 */
public class WebPhysicalVO extends PhysicalVO {

	@Param(desc = "终端类型：0:PC,1:android,2:ios")
	private Integer terminalType;// 终端类型：0:PC，1:android，2:ios

}
