package com.sinco.carnation.resource.vo.healthTask;

import javax.validation.constraints.NotNull;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.annotation.Param;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * 用户健康任务接收数据类
 * 
 * @author yuleijia
 */
public class HealthTaskVO extends BasicPageParamVo {

	@Param(desc = "操作类型 | 10:参与任务  20:创建任务")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer operType;

	@Param(desc = "任务id")
	private Long id;

	@Param(desc = "任务名")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String taskName;

	@Param(desc = "提醒时间")
	private String remindTime;
	/**
	 * 提醒周期 0：代表每天 1：周一 2：周二 ....... 多个周期：1,2,3
	 */
	@Param(desc = "提醒周期")
	private String remindWeek;

	@Param(desc = "任务是否开启 0：N,1:Y")
	private int isOpen = 1;

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public String getRemindWeek() {
		return remindWeek;
	}

	public void setRemindWeek(String remindWeek) {
		this.remindWeek = remindWeek;
	}

	public Integer getOperType() {
		return operType;
	}

	public void setOperType(Integer operType) {
		this.operType = operType;
	}
}
