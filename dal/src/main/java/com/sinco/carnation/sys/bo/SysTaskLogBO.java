package com.sinco.carnation.sys.bo;

import com.sinco.carnation.sys.model.SysTaskLog;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class SysTaskLogBO extends SysTaskLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -371891054846200332L;

	private String nickname;
	private String taskName;
	private String content;

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

}