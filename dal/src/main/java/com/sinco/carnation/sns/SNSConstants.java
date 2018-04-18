package com.sinco.carnation.sns;

public class SNSConstants {
	/**
	 * 用户收藏类型：1帖子，2专家
	 */
	public static String FAVORITES_TYPE_INVITATION = "1";
	public static String FAVORITES_TYPE_EXPERTS = "2";

	public static String ARTICLE_TYPE_USER = "user";

	/** 1:帖子（链接），2商品，3商户，4资讯（云尚项目）（链接）5服务商户 6服务 */
	public static String AD_TYPE_1 = "1";
	public static String AD_TYPE_2 = "2";
	public static String AD_TYPE_3 = "3";
	public static String AD_TYPE_4 = "4";
	public static String AD_TYPE_5 = "5";
	public static String AD_TYPE_6 = "6";

	/**
	 * 资讯审核状态 0创建，10提交审核，20审核通过前台显示，-10审核失败
	 */
	public static Integer CHECK_STATUS_PASS = 20;

	public static final String JG_INVITATION_URL = "/circle/look_invitation?invitationId=";
	public static final String JG_PROJECT_URL = "/information/project_information_detail?informationId=";

}
