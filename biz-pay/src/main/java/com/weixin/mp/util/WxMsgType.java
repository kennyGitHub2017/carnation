package com.weixin.mp.util;

/**
 * 微信消息接收类型
 * 
 * @author JG-yes
 * 
 */
public class WxMsgType {

	/**
	 * 文本消息
	 */
	public static final String TEXT = "text";

	/**
	 * 图片消息
	 */
	public static final String IMAGE = "image";

	/**
	 * 语音消息
	 */
	public static final String VOICE = "voice";

	/**
	 * 视频消息
	 */
	public static final String VIDEO = "video";

	/**
	 * 小视频消息
	 */
	public static final String SHORTVIDEO = "shortvideo";

	/**
	 * 地理位置消息
	 */
	public static final String LOCATION = "location";
	/**
	 * 链接消息
	 */
	public static final String LINK = "link";

	/**
	 * 事件消息
	 */
	public static final String EVENT = "event";

	public class WxEventType {

		/**
		 * 关注
		 */
		public static final String SUBSCRIBE = "subscribe";

		/**
		 * 已关注
		 */
		public static final String SCAN = "SCAN";

		/**
		 * 菜单点击
		 */
		public static final String CLICK = "click";

	}

	public class ButtonType {

		/**
		 * 诚聘英才
		 */
		public static final String JG_ZHAO_PIN = "JG_ZHAO_PIN";

		/**
		 * 最新活动
		 */
		public static final String JG_NEW_ACT = "JG_NEW_ACT";
		/**
		 * 乐购商城
		 */
		public static final String JG_MALL = "JG_MALL";
		/**
		 * 附近商店
		 */
		public static final String JG_LOCATION_SHOP = "JG_LOCATION_SHOP";
		/**
		 * 到店体验
		 */
		public static final String JG_GO_SHOP = "JG_GO_SHOP";

		/**
		 * 个人中心
		 */
		public static final String JG_PERSON_INFO = "JG_PERSON_INFO";
		/**
		 * 搜索商品
		 */
		public static final String JG_SEARCH_GOODS = "JG_SEARCH_GOODS";
		/**
		 * 在线客服
		 */
		public static final String JG_CUSTOMER_SERVICE = "JG_CUSTOMER_SERVICE";

		/**
		 * 帮助中心
		 */
		public static final String JG_HELP = "JG_HELP";

	}

}
