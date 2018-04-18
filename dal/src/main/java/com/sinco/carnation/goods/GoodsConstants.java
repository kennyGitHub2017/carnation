package com.sinco.carnation.goods;

public class GoodsConstants {
	/**
	 * 版式分类，0为商铺版式，1为自营版式
	 */
	public static Integer GOODS_FORMAT_SELF = 1;
	public static Integer GOODS_FORMAT_SHOP = 0;
	/**
	 * 版式分类，0为商铺版式，1为自营版式
	 */
	public static Integer GOODS_SPECI_SELF = 0;
	public static Integer GOODS_SPECI_SHOP = 1;

	/**
	 * 商品类型 0为自营商品，1为第三方经销商
	 */
	public static Integer GOODS_TYPE_SELF = 0;
	public static Integer GOODS_TYPE_SHOP = 1;

	/**
	 * 商品运费承担方式 0为买家承担，1为卖家承担
	 */
	public static Integer goods_Transfee_0 = 0;
	public static Integer goods_Transfee_1 = 1;

	/** 是否支持货到付款 0为支持，-1为不支持 **/
	public static Integer GOODS_COD_NO_1 = -1;
	public static Integer GOODS_COD_0 = -1;

	/***
	 * 运费模版类型－0自营，1店铺
	 */
	public static final String TRANSPORT_TYPE_SELF = "0";
	/***
	 * 运费模版类型－0自营，1店铺
	 */
	public static final String TRANSPORT_TYPE_SHOP = "1";

	/**
	 * 商品状态 0为上架，1为在仓库中，2为定时自动上架，3为店铺过期自动下架，-1为手动下架状态，-2为违规下架状态,-3被举报禁售, -5在审核中
	 */
	public static Integer GOODS_STATUS_SELLING = 0;
	public static Integer GOODS_STATUS_STORE = 1;
	public static Integer GOODS_STATUS_TIMING = 2;
	public static Integer GOODS_STATUS_AUTO_DOWN = 3;
	public static Integer GOODS_STATUS_HAND_DOWN = -1;
	public static Integer GOODS_STATUS_ILLEGAL_DOWN = -2;
	public static Integer GOODS_STATUS_REPORT_DOWN = -3;
	public static Integer GOODS_STATUS_CHECKING = -5;
	/**
	 * 审核不通过
	 */
	public static Integer GOODS_STATUS_CHECKING_NOTPASS = -6;

	/** 规格类型，0为平台自营规格，1为商家规格，商家规格时需要有对应的店铺 **/
	public final static Integer SPEC_TYPE_1 = 1;
	/** 规格类型，0为平台自营规格，1为商家规格，商家规格时需要有对应的店铺 **/
	public final static Integer SPEC_TYPE_0 = 0;

	/** 品牌 是否通过审核 1 通过 0 不通过 **/
	public final static Integer GB_AUDIT_1 = 1;
	/** 品牌 是否通过审核 1 通过 0 不通过 **/
	public final static Integer GB_AUDIT_0 = 0;

	/**
	 * 购物车状态 用户购物车状态，0表示没有提交为订单， 1表示已经提交为订单，已经提交为订单信息的不再为缓存购物车， 2表示立即购买 同时定时器也不进行删除操作
	 **/
	public final static Integer GOODS_CART_STATUS_1 = 1;
	public final static Integer GOODS_CART_STATUS_0 = 0;
	public final static Integer GOODS_CART_STATUS_2 = 2;

	/** 商品是否实体 0实体商品 **/
	public final static Integer GOODS_CHOICE_TYPE_ENTITY = 0;
	/** 商品是否实体 1为虚拟商品 **/
	public final static Integer GOODS_CHOICE_TYPE_VIRTUAL = 1;

	/** All为全局库存，spec按规格库存 **/
	public final static String GOODS_INVENTORY_TYPE_ALL = "All";
	public final static String GOODS_INVENTORY_TYPE_SPEC = "spec";

	/**
	 * 默认为空，组合销售时候为"combin"
	 */
	public final static String GOODS_CART_TYPE_COMBIN = "combin";
	public final static String GOODS_CART_TYPE_GROUP = "group";

	/** 商品退货状态 -2为超过退货时间未能输入退货物流 -1为申请被拒绝，1为可以退货 5为退货申请中 6为审核通过可进行退货 7为退货中，10为退货完成,等待退款，11为平台退款完成 **/
	public final static String GOODS_RETURN_STATUS_1 = "1";
	public final static String GOODS_RETURN_STATUS_6 = "6";
	public final static String GOODS_RETURN_STATUS_7 = "7";
	public final static String GOODS_RETURN_STATUS_8 = "8";
	public final static String GOODS_RETURN_STATUS_2 = "2";
	public final static String GOODS_RETURN_STATUS_5 = "5";
	public final static String GOODS_RETURN_STATUS_10 = "10";
	public final static String GOODS_RETURN_STATUS_11 = "11";

}
