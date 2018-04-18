package com.sinco.carnation.sys.bo;

import com.sinco.carnation.sys.model.SysReminderTask;
import com.sinco.carnation.user.model.PhysicalKeyWord;

import java.util.List;

/**
 * BO 用于返回数据
 */
public class SysReminderTaskBO extends SysReminderTask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1344182865802066895L;
	/** 任务的关联类型 */
	public static final Long TASK_TYPE_CODE = 2L;
	/** 关键字 */
	private List<PhysicalKeyWord> keyWords;
	/** 参与人数 */
	private Long userCount;

	public SysReminderTaskBO() {
	}

	public List<PhysicalKeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<PhysicalKeyWord> keyWords) {
		this.keyWords = keyWords;
	}

	public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}
}