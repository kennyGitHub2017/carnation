package com.sinco.carnation.sns.contants;

public class AdvertContant {

	/** 展示方式，0为只有一则广告，1为可以投放很多，随机出现 **/
	public static final Integer AP_SHOW_TYPE_0 = 0;

	/** 展示方式，0为只有一则广告，1为可以投放很多，随机出现 **/
	public static final Integer AP_SHOW_TYPE_1 = 1;

	/** 广告未审核 */
	public static final Integer AD_STATUS_NO_AUDIT = 0;
	/** 广告审核通过 */
	public static final Integer AD_STATUS_PASS = 1;
	/** 广告审核不通过 */
	public static final Integer AD_STATUS_FAILE = 2;

	/**
	 * 广告位状态 0为关闭，1为启用
	 */
	public static final Integer AP_STATUS_0 = 0;

	/**
	 * 广告位状态 0为关闭，1为启用
	 */
	public static final Integer AP_STATUS_1 = 1;

	/** 系统广告位 */
	public static final Integer IS_AP_SYS_TYPE = 0;
	/** 自定义广告位 */
	public static final Integer IS_NOT_AP_SYS_TYPE = 1;

	/** 广告位位置，Pc为电脑端、Mobile为手机端 **/
	public static final String AP_LOCATION_PC = "Pc";

	/** 广告位位置，Pc为电脑端、Mobile为手机端 **/
	public static final String AP_LOCATION_MOBILE = "Mobile";

	/** 广告类别,目前有幻灯slide、滚动scroll、图片img、文字text、背景幻灯bg_slide5种 **/
	public static final String AP_TYPE_IMG = "img";
	public static final String AP_TYPE_TEXT = "text";
	public static final String AP_TYPE_SCROLL = "scroll";
	public static final String AP_TYPE_SLIDE = "slide";
	public static final String AP_TYPE_BG_SLIDE = "bg_slide";

	/** 推荐类型：1：资讯（链接） */
	public static final String ADVERT_TPYE_INFOMATION = "1";
	/** 推荐类型：2：商品 */
	public static final String ADVERT_TPYE_GOODS = "2";
	/** 推荐类型：3：商户 */
	public static final String ADVERT_TPYE_MERCHANT = "3";
	/** 推荐类型：4：云尚项目（链接） */
	public static final String ADVERT_TPYE_JG_PROJECT = "4";
	/** 推荐类型：5：服务商户 */
	public static final String ADVERT_TPYE_GROUP_MERCHANT = "5";
	/** 推荐类型：6：服务 */
	public static final String ADVERT_TPYE_SERVE = "6";
	/** 推荐类型：7：原生(APP用) */
	public static final String ADVERT_TPYE_APP = "7";
	/** 推荐类型：8：卷皮商品 */
	public static final String ADVERT_TPYE_JUANPI_GOODS = "8";
}
