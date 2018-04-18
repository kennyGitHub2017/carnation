package com.sinco.carnation.pay.tools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.weixin.mp.util.WxMsgType.ButtonType;

/**
 * @author JG-yes
 * 
 */
@Component
public class WxMpMenueToops {

	/**
	 * 菜单按钮类型：Button
	 */
	private static final String MenueButtonTypeClick = "click";

	/**
	 * 菜单按钮类型：view 调整到url
	 */
	private static final String MenueButtonTypeView = "view";

	/**
	 * 微信一级菜单
	 * 
	 * @author JG-yes
	 * 
	 */
	public class WxMenueRootItem {

		public WxMenueRootItem(String name, List<WxMenueItemBase> sub_button) {
			super();
			this.name = name;
			this.sub_button = sub_button;
		}

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private List<WxMenueItemBase> sub_button;

		public List<WxMenueItemBase> getSub_button() {
			return sub_button;
		}

		public void setSub_button(List<WxMenueItemBase> sub_button) {
			this.sub_button = sub_button;
		}
	}

	/**
	 * 菜单基类
	 * 
	 * @author JG-yes
	 * 
	 */
	public class WxMenueItemBase {

		public WxMenueItemBase(String type, String name) {
			super();
			this.type = type;
			this.name = name;
		}

		private String type;
		private String name;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public class WxMenueButton extends WxMenueItemBase {
		private String key;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public WxMenueButton(String name, String key) {
			super(MenueButtonTypeClick, name);
			this.key = key;
		}

	}

	public class WxMenueUrl extends WxMenueItemBase {
		private String url;

		public String getKey() {
			return url;
		}

		public void setKey(String key) {
			this.url = key;
		}

		public WxMenueUrl(String name, String key) {
			super(MenueButtonTypeView, name);
			this.url = key;
		}

	}

//	public static void main(String[] args) {
//		WxMpMenueToops p = new WxMpMenueToops();
//		String str = Json.toJson(p.getInitMenueList("http://www.ysysgo.com"));
//		System.out.println(str);
//	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map getInitMenueList(String invatationUrl) {
		List<WxMenueRootItem> list = new ArrayList<WxMenueRootItem>();

		List<WxMenueItemBase> listFirst = new ArrayList<WxMenueItemBase>();
		listFirst.add(new WxMenueUrl("APP", "http://www.ysysgo.com/p/download#slide-4"));
		listFirst.add(new WxMenueUrl("了解云尚", "http://www.ysysgo.com/p/download"));
		listFirst.add(new WxMenueUrl("关于我们", "http://www.ysysgo.com/p/about"));
		listFirst.add(new WxMenueButton("诚聘英才", ButtonType.JG_ZHAO_PIN));
		listFirst.add(new WxMenueUrl("联系我们", "http://www.ysysgo.com/p/contact"));

		list.add(new WxMenueRootItem("云尚", listFirst));

		List<WxMenueItemBase> listSecond = new ArrayList<WxMenueItemBase>();

		listSecond.add(new WxMenueButton("最新活动", ButtonType.JG_NEW_ACT));
		listSecond.add(new WxMenueButton("乐购商城", ButtonType.JG_MALL));
		listSecond.add(new WxMenueButton("附近商店", ButtonType.JG_LOCATION_SHOP));
		listSecond.add(new WxMenueButton("到店体验", ButtonType.JG_GO_SHOP));
		listSecond.add(new WxMenueUrl("商户APP", "http://www.ysysgo.com/p/app"));

		list.add(new WxMenueRootItem("商城商圈", listSecond));

		List<WxMenueItemBase> listThird = new ArrayList<WxMenueItemBase>();

		listThird.add(new WxMenueButton("个人中心", ButtonType.JG_ZHAO_PIN));
		listThird.add(new WxMenueButton("搜索商品", ButtonType.JG_SEARCH_GOODS));
		listThird.add(new WxMenueButton("在线客服", ButtonType.JG_CUSTOMER_SERVICE));
		listThird.add(new WxMenueUrl("推荐二维码", invatationUrl));
		listThird.add(new WxMenueButton("帮助中心", ButtonType.JG_HELP));

		list.add(new WxMenueRootItem("我的服务", listThird));

		Map map = new LinkedHashMap<String, Object>();
		map.put("button", list);
		return map;
	}

	public String getButtonClickMsg(String buttonKey) {
		if (buttonKey.equals(ButtonType.JG_CUSTOMER_SERVICE)) { // 回复图文消息

		}

		return "感谢您对云尚健康管理综合服务平台的关注，我们正在完善此功能。服务热线：xxxxxxxx";
	}
}
