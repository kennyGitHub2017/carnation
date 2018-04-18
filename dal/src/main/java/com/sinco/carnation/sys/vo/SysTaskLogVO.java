package com.sinco.carnation.sys.vo;

import com.sinco.carnation.sys.model.SysTaskLog;

public class SysTaskLogVO extends SysTaskLog {

	private static final long serialVersionUID = 3524730758030505551L;
	/** 昵称 **/
	private String nickname;
	/** 任务名 **/
	private String taskName;
	/** 任务内容 **/
	private String content;

	private String reminderTimeStr;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReminderTimeStr() {
		return reminderTimeStr;
	}

	public void setReminderTimeStr(String reminderTimeStr) {
		this.reminderTimeStr = reminderTimeStr;
	}

}