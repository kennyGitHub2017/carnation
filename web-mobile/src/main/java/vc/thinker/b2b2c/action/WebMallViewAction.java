/**
 * 
 */
package vc.thinker.b2b2c.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jfree.util.Log;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsFloorBO;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsFloorService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsCaseViewTools;
import com.sinco.carnation.goods.tools.GoodsClassViewTools;
import com.sinco.carnation.goods.tools.GoodsFloorViewTools;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.PartnerBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.PartnerService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.tools.NavViewTools;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dic.client.model.DicBase;
import com.sinco.dic.client.util.WebUtils;

/**
 * @author Administrator
 * 
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked"})
public class WebMallViewAction {
	/**
	 * 微信分享公众号信息
	 */
	String _appId = "wx9d38abce10c26432";
	String _appSecret = "ff29a5f99cc707ae720c0d210ab666f6";

	@Autowired
	private ArticleService articleService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private NavViewTools navTools;

	@Autowired
	private GoodsClassViewTools gcViewTools;

	@Autowired
	private GoodsClassService goodsClassService;

	@Autowired
	private GoodsCaseViewTools goodsCaseViewTools;

	@Autowired
	private GoodsCartService goodsCartService;

	@Autowired
	private GoodsFloorService goodsFloorService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private GoodsFloorViewTools gf_tools;

	@Autowired
	private AdvertService advertService;

	@Autowired
	private UserAccountService userAccountService;

	// 通用日志记录
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * h5商城首页
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/index.htm")
	public ModelAndView web_index(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * ModelAndView mv = new JModelAndView("web_index.html",
		 * configService.getSysConfig(), 1, request, response);
		 */
		ModelAndView mv = new JModelAndView("health_index.html", configService.getSysConfig(), 1, request,
				response);

		List<PartnerBO> img_partners = this.partnerService.findImg(false);
		mv.addObject("img_partners", img_partners);

		List<PartnerBO> text_partners = this.partnerService.findImg(true);
		mv.addObject("text_partners", text_partners);

		/*
		 * String[] class_marks = { "gonggao" }; // 首页右上角公告区分类的标识，通过后台添加
		 * Map<String, List<ArticleBO>> articles = Maps.newLinkedHashMap(); for
		 * (String m : class_marks) { List<ArticleBO> article =
		 * this.articleService
		 * .findByParentClassMark(SysContants.ARTICLE_TYPE_USER,
		 * Lists.newArrayList(m), true, 6); articles.put(m, article); }
		 * mv.addObject("articles", articles);
		 */
		// APP首页广告
		List<Advert> advList = advertService.findTopByCode("H5_SHOP_INDEX_BANNER", 5L);
		mv.addObject("advList", advList);

		mv.addObject("goodsCaseViewTools", goodsCaseViewTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("storeViewTools", storeViewTools);
		// 首页大分类楼层
		List<GoodsFloorBO> floors = this.goodsFloorService.findLevelByDisplay(true);
		mv.addObject("floors", floors);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("url", CommUtil.getURL(request));

		if (SecurityUserHolder.getCurrentUser() != null) {
			mv.addObject("user", this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId()));
			// 加入CN用户判断 2017-3-16 tw
			Long uid = SecurityUserHolder.getCurrentUserId();
			UserAccountBO account1 = new UserAccountBO();
			account1.setUid(uid);
			account1.setAccountType(UserContant.ACCOUNT_TYPE_8);
			UserAccountBO cnUserAccount = userAccountService.findAccountByVo(account1);
			boolean isCN = cnUserAccount != null;
			mv.addObject("isCN", isCN);
		}

		mv.addObject("navTools", navTools);

		return mv;
	}

	/**
	 * 全文搜索
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/head.htm")
	public ModelAndView head(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * ModelAndView mv = new
		 * JModelAndView("head.html",configService.getSysConfig(),1, request,
		 * response);
		 */
		/* H5 */
		ModelAndView mv = new JModelAndView("web_mobile/search.html", configService.getSysConfig(), 1,
				request, response);

		String type = CommUtil.null2String(request.getAttribute("type"));

		String cart_session_id = this.goodsCaseViewTools.getCartSessionId(request, response);

		// 这里应该改造成数量
		int cartCount = goodsCartService
				.countCartCalc(SecurityUserHolder.getCurrentUserId(), cart_session_id);

		mv.addObject("cartCount", cartCount);
		mv.addObject("type", type.equals("") ? "goods" : type);
		return mv;
	}

	/**
	 * 通用页尾
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/wx_foot.htm")
	public ModelAndView wx_foot(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("web_mobile/wx_foot.html", configService.getSysConfig(), 1,
				request, response);
		if (SecurityUserHolder.getCurrentUser() != null) {
			mv.addObject("user", this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId()));
		}
		return mv;
	}

	@RequestMapping("/wx_foot2.htm")
	public ModelAndView wx_foot2(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("web_mobile/wx_foot2.html", configService.getSysConfig(), 1,
				request, response);
		if (SecurityUserHolder.getCurrentUser() != null) {
			mv.addObject("user", this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId()));
		}
		return mv;
	}

	@RequestMapping("/wx_foot3.htm")
	public ModelAndView wx_foot3(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("web_mobile/wx_foot3.html", configService.getSysConfig(), 1,
				request, response);
		if (SecurityUserHolder.getCurrentUser() != null) {
			mv.addObject("user", this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId()));
		}
		return mv;
	}

	@RequestMapping("/wx_foot4.htm")
	public ModelAndView wx_foot4(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("web_mobile/wx_foot4.html", configService.getSysConfig(), 1,
				request, response);
		if (SecurityUserHolder.getCurrentUser() != null) {
			mv.addObject("user", this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId()));
		}
		return mv;
	}

	/**
	 * h5商城商品分类导航页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/web_goods_class.htm")
	public ModelAndView goods_class(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("web_mobile/fenlei.html", configService.getSysConfig(), 1,
				request, response);
		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll(true);
		mv.addObject("gcs", gcs);

		return mv;
	}

	/**
	 * 根据父ID查询子集对象列表
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@RequestMapping("/load_goods_class")
	@ResponseBody
	public String load_area(HttpServletRequest request, HttpServletResponse response, String pid) {
		try {
			Map resultMap = new HashMap<String, Object>();
			List<DicBase> gc = goodsClassService.childGoodsClassList(pid);
			resultMap.put("gc", gc);
			return Json.toJson(ActionResult.NewSuccess(resultMap));
		} catch (Exception e) {
			Log.error(String.format("%s", CommUtil.getStackTrace(e)));
			return Json.toJson(ActionResult.NewFail("服务器异常"));
		}
	}

	/**
	 * 产品展示
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/productShow.htm")
	public ModelAndView productShow(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("web_mobile/productShow.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	/**
	 * 微信分享所需配置信息
	 * 
	 * @param mv
	 * @param request
	 * @return
	 */

	public ModelAndView wxShareMv(ModelAndView mv, HttpServletRequest request) {

		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		String url = request.getRequestURL().toString();
		currentUrl.append(url);
		if (StringUtils.isNotBlank(request.getQueryString())) {
			currentUrl.append("?" + request.getQueryString());
		}

		// currentUrl = new wx9d38abce10c26432
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken(_appId, _appSecret);
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());

		// String path =
		// request.getSession().getServletContext().getRealPath("/");

		// 将界面说需要的参数返回
		mv.addObject("appId", _appId);
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));

		mv.addObject("token", token);
		mv.addObject("ticket", ticket);
		mv.addObject("currentUrl", currentUrl);
		return mv;
	}

	/**
	 * 获取token
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	private String getToken(String appId, String secret) {
		String token = "";

		Map<String, String> params = Maps.newHashMap();
		params.put("grant_type", "client_credential");
		params.put("appid", _appId);
		params.put("secret", _appSecret);

		String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			String jsonStr = WebUtils.doGet(getTokenUrl, params);
			// {"access_token":"xxx","expires_in":7200}
			// {"errcode":40125,"errmsg":"invalid appsecret, view more at
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || StringUtils.isBlank(map.get("errcode").toString())) {
				token = map.get("access_token").toString();
			} else {
				logger.info("获取Token错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取Token异常" + e.getMessage());
		}
		return token;

	}

	/**
	 * 获取token
	 * 
	 * @param token
	 * @return
	 */
	private String getTicken(String token) {
		String ticket = "";

		Map<String, String> params = Maps.newHashMap();
		params.put("access_token", token);
		params.put("type", "jsapi");
		String getTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
		try {
			String jsonStr = WebUtils.doGet(getTicketUrl, params);
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || map.get("errcode").toString().equals("0")) {
				ticket = map.get("ticket").toString();
			} else {
				logger.info("获取ticket错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取ticket异常" + e.getMessage());
		}
		return ticket;
	}

	/**
	 * 获取加密签名
	 * 
	 * @param jsapi_ticket
	 * @param url
	 * @return
	 */
	private Map<String, String> sign(String jsapi_ticket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp
				+ "&url=" + url;
		System.out.println(string1);

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	/**
	 * 转为16禁止
	 * 
	 * @param hash
	 * @return
	 */
	private String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * @return
	 */
	private String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	/**
	 * @return
	 */
	private String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

}
