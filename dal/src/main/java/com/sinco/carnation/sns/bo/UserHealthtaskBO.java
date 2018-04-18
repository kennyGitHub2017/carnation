package com.sinco.carnation.sns.bo;

import com.sinco.carnation.sns.model.UserHealthtask;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class UserHealthtaskBO extends UserHealthtask {

	private static final long serialVersionUID = 3937634161657882310L;

	/**
	 * 健康任务完成状态 0：未完成 1：已完成
	 */
	private int finishState;

	private String yinDaoURL;
	/**
	 * 已完成任务查看链接地址
	 */
	private String finishTaskURL;

	public String getFinishTaskURL() {
		return finishTaskURL;
	}

	public void setFinishTaskURL(String finishTaskURL) {
		this.finishTaskURL = finishTaskURL;
	}

	public String getYinDaoURL() {
		return yinDaoURL;
	}

	public void setYinDaoURL(String yinDaoURL) {
		this.yinDaoURL = yinDaoURL;
	}

	public int getFinishState() {
		return finishState;
	}

	public void setFinishState(int finishState) {
		this.finishState = finishState;
	}

	/**
	 * 成功返回码
	 */
	public static final int result_succ = 200;
	/**
	 * 返回对象为空
	 */
	public static final int result_succ_empty = 210;
	/**
	 * 失败返回码
	 */
	public static final int result_fail = 400;
	/**
	 * 错误返回码
	 */
	public static final int result_error = 500;

	public static final String content_empty = "无当前记录";

}