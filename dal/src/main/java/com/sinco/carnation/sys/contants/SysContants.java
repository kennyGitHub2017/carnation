package com.sinco.carnation.sys.contants;

public class SysContants {

	/**
	 * 导航类型，diy为自定义导航、goodsclass为商品分类、articleclass为文章分类、activity为系统活动，、sparegoods为闲置商品页面导航
	 */
	public final static String NAV_TYPE_SPAREGOODS = "sparegoods";
	/**
	 * 导航类型，diy为自定义导航、goodsclass为商品分类、articleclass为文章分类、activity为系统活动，、sparegoods为闲置商品页面导航
	 */
	public final static String NAV_TYPE_DIY = "diy";

	/**
	 * 导航位置,-1为顶部、0为中间、1为底部
	 */
	public final static Integer NAV_LOCATION_1 = 1;
	/**
	 * 导航位置,-1为顶部、0为中间、1为底部
	 */
	public final static Integer NAV_LOCATION_0 = 0;
	/**
	 * 导航位置,-1为顶部、0为中间、1为底部
	 */
	public final static Integer NAV_LOCATION_NOT_1 = -1;

	/** 文章类型，默认为user，商家公告为store，store类型只能商家才能查看 **/
	public final static String ARTICLE_TYPE_USER = "user";
	public final static String ARTICLE_TYPE_STORE = "store";

	/** 短信状态0是未读，1为已读 **/
	public final static int MESSAGE_STATUS_1 = 1;
	public final static int MESSAGE_STATUS_0 = 0;
	/** 拦截器过滤 **/
	public static final String NO_INTERCEPTOR_PATH = ".*/((cn_bandphone)|(user/login)|(resources)|(reg_code_get)|(cn_bind_code_get)|(cn_bindMobile.htm)|(login_success.htm)|(verify.htm)|(b2b2c_logout.htm)|(weChat/login.htm)|(weChat/callBack.htm)).*"; // 不对匹配该值的访问路径拦截（正则）

}
