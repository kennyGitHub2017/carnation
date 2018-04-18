package com.sinco.carnation.kuaidi100.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.kuaidi100.pojo.TaskRequest;
import com.sinco.carnation.kuaidi100.pojo.TaskResponse;
import com.sinco.carnation.kuaidi100.post.HttpRequest;
import com.sinco.carnation.kuaidi100.post.JacksonHelper;
import com.sinco.carnation.shop.dao.ExpressInfoDao;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.ExpressInfo;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.TransContent;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.service.SysConfigService;

@Service
public class TransInfoService {

	private static final Logger log = LoggerFactory.getLogger(TransInfoService.class);

	@Autowired
	private SysConfigService configService;

	@Autowired
	private ExpressCompanyService expressCompayService;

	@Autowired
	private ExpressInfoDao expressInfoDao;

	// kuaidi key
	private final static String EXPRESS_KEY = "wKUdnOwl7349";
	private final static String CUSTOMER_NO = "C843FF6353EDFA07C212826C43E5188F";
	private final static String EXPRESS_URL = "http://poll.kuaidi100.com/poll/query.do";

	/**
	 * 通知快递100，建立订单物流查询推送
	 * 
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public void createExpressSearchSend(OrderForm obj) {
		SysConfigBO config = this.configService.getSysConfig();

		// 如果是收费接口，则通知快递100，建立订单物流查询推送
		if (config.getKuaidiType() == 1) {
			TaskRequest req = new TaskRequest();
			Map express_map = Json.fromJson(Map.class, obj.getExpressInfo());
			req.setCompany(CommUtil.null2String(express_map.get("express_company_mark")));
			String from_addr = obj.getShipAddr();
			req.setFrom(from_addr);
			req.setTo(obj.getReceiverArea());
			req.setNumber(obj.getShipCode());
			req.getParameters().put("callbackurl",
					config.getAddress() + "/kuaidi100_callback.htm?order_id=" + obj.getId() + "&orderType=0");
			req.getParameters().put("salt", Md5Encrypt.md5(CommUtil.null2String(obj.getId())).toLowerCase());
			req.setKey(config.getKuaidiId2());
			HashMap<String, String> p = new HashMap<String, String>();
			p.put("schema", "json");
			p.put("param", JacksonHelper.toJSON(req));
			try {
				String ret = HttpRequest.postData("http://www.kuaidi100.com/poll", p, "UTF-8");
				TaskResponse resp = JacksonHelper.fromJSON(ret, TaskResponse.class);
				if (resp.getResult() == true) {
					ExpressInfo ei = new ExpressInfo();
					ei.setAddTime(new Date());
					ei.setOrderId(obj.getId());
					ei.setOrderExpressId(obj.getShipCode());
					ei.setOrderType(0);
					Map map = Json.fromJson(Map.class, CommUtil.null2String(obj.getExpressInfo()));
					if (map != null) {
						ei.setOrderExpressName(CommUtil.null2String(map.get("express_company_name")));
					}
					// System.out.println(Json.toJson(result.getData(),JsonFormat.compact()));
					this.expressInfoDao.save(ei);
					System.out.println("订阅成功");
				} else {
					System.out.println("订阅失败");
				}
			} catch (Exception e) {
				log.error("订阅快递100失败", e);
			}
		}
	}

	/**
	 * 查找快递公司
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ExpressCompany queryExpressCompany(String json) {
		ExpressCompany ec = null;
		if (json != null && !json.equals("")) {
			HashMap map = Json.fromJson(HashMap.class, json);
			ec = expressCompayService.getObjById(CommUtil.null2Long(map.get("express_company_id")));
		}
		return ec;
	}

	/**
	 * 查询快递单信息
	 * 
	 * @param expressInfo
	 * @param shipCode
	 * @return
	 */
	public TransInfo queryShipInfo(String expressInfo, String shipCode) {
		return queryShipInfo(expressInfo, shipCode, null);
	}

//	/**
//	 * 查询快递单信息
//	 * @param expressInfo
//	 * @param shipCode
//	 * @param orderId 如果系统可调用收费接口，补充信息
//	 * @return
//	 */
//	public TransInfo queryShipInfo(String expressInfo,String shipCode,Long orderId) {
//		TransInfo info = new TransInfo();
//		SysConfigBO config=this.configService.getSysConfig();
//		if (config.getKuaidiType() == 0) {// 免费物流接口
//			try {
//				ExpressCompany ec = this.queryExpressCompany(expressInfo);
//				String query_url = "http://api.kuaidi100.com/api?id=" + config.getKuaidiId() + ""
//						+ "&com=" + (ec != null ? ec.getCompanyMark() : "") + "&nu="
//						+ shipCode + "&show=0&muti=1&order=asc";
//				URL url = new URL(query_url);
//				URLConnection con = url.openConnection();
//				con.setAllowUserInteraction(false);
//				InputStream urlStream = url.openStream();
//				String type = con.guessContentTypeFromStream(urlStream);
//				String charSet = null;
//				if (type == null)
//					type = con.getContentType();
//				if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
//					return info;
//				if (type.indexOf("charset=") > 0)
//					charSet = type.substring(type.indexOf("charset=") + 8);
//				byte b[] = new byte[10000];
//				int numRead = urlStream.read(b);
//				String content = new String(b, 0, numRead, charSet);
//				while (numRead != -1) {
//					numRead = urlStream.read(b);
//					if (numRead != -1) {
//						// String newContent = new String(b, 0, numRead);
//						String newContent = new String(b, 0, numRead, charSet);
//						content += newContent;
//					}
//				}
//				info = Json.fromJson(TransInfo.class, content);
//				urlStream.close();
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		if (config.getKuaidiType() == 1 && orderId != null) {// 收费物流接口
//			ExpressInfo ei = expressInfoDao.findByOrderId(orderId);
//			if (ei != null) {
//				List<TransContent> data = (List<TransContent>) 
//						Json.fromJson(CommUtil.null2String(ei.getOrderExpressInfo()));
//				info.setData(data);
//				info.setStatus("1");
//			}
//		}
//		return info;
//	}

	@SuppressWarnings("unchecked")
	public TransInfo queryShipInfo(String expressInfo, String shipCode, Long orderId) {
		TransInfo info = new TransInfo();
		SysConfigBO config = this.configService.getSysConfig();
		if (config.getKuaidiType() == 0) {// 免费物流接口
			ExpressCompany ec = this.queryExpressCompany(expressInfo);
			if (null != ec) {
				String json = getOrderExpress(shipCode, ec.getCompanyMark());
				if (StringUtils.isNotBlank(json)) {
					info = Json.fromJson(TransInfo.class, json);
				}
			}
			info.setExpress_company_name(ec.getCompanyName());
			info.setExpress_ship_code(shipCode);
		}
		if (config.getKuaidiType() == 1 && orderId != null) {// 收费物流接口
			ExpressInfo ei = expressInfoDao.findByOrderId(orderId);
			if (ei != null) {
				List<TransContent> data = (List<TransContent>) Json.fromJson(CommUtil.null2String(ei
						.getOrderExpressInfo()));
				info.setData(data);
				info.setStatus("1");
			}
		}
		return info;
	}

	/**
	 * 查找快递详情
	 * 
	 * @param companyId
	 * @param shipCode
	 * @return
	 */
	public TransInfo queryShipInfo(Long companyId, String shipCode) {
		TransInfo info = new TransInfo();
		SysConfigBO config = this.configService.getSysConfig();
		if (config.getKuaidiType() == 0) {// 免费物流接口
			ExpressCompany ec = expressCompayService.getObjById(companyId);
			if (null != ec) {
				String json = getOrderExpress(shipCode, ec.getCompanyMark());
				if (StringUtils.isNotBlank(json)) {
					info = Json.fromJson(TransInfo.class, json);
				}
			}
		}
		return info;
	}

	/**
	 * 通过网页形式查看快递信息
	 * 
	 * @param oid
	 * @param code
	 * @return
	 */
	public static String getOrderExpress(String oid, String code) {
		if (StringUtils.isNotBlank(oid) && StringUtils.isNotBlank(code)) {
			/**
			 * 根据物流方式和物流单号，在快递中进行查询
			 */
			String url = "http://api.kuaidi.com/openapi.html?id=" + EXPRESS_KEY + "&com=" + code + "&nu="
					+ oid;
			try {
				Document doc = Jsoup.connect(url).ignoreContentType(true).get();
				Elements elements = doc.select("body");
				if (null != elements && !elements.isEmpty() && StringUtils.isNotBlank(elements.text())) {
					JSONObject json = JSON.parseObject(elements.text());
					if (StringUtils.isNotBlank(json.getString("status"))) {
						if ("true".equals(json.getString("success"))) {
							json.put("status", "1");
						} else {
							// 再次调用快递100接口
							return getOrderExpress100(oid, code);
						}
						return json.toJSONString();
					}
				}
			} catch (Exception e) {
				// e.printStackTrace();
				log.error("根据物流单号去http://api.kuaidi.com查询物流信息出错：", e);
			}
		}

		return StringUtils.EMPTY;
	}

	/**
	 * 通过网页形式查看快递信息 快递100
	 * 
	 * @param oid
	 * @param code
	 * @return
	 */
	public static String getOrderExpress100(String oid, String code) {
		if (StringUtils.isNotBlank(oid) && StringUtils.isNotBlank(code)) {
			/**
			 * 根据物流方式和物流单号，在快递100中进行查询
			 */
			String url = "http://m.kuaidi100.com/query?type=" + code + "&postid=" + oid;
			try {
				Document doc = Jsoup
						.connect(url)
						.userAgent(
								"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:37.0) Gecko/20100101 Firefox/37.0")
						.timeout(3000).get();
				Elements elements = doc.select("body");
				if (null != elements && !elements.isEmpty() && StringUtils.isNotBlank(elements.text())) {
					JSONObject json = JSON.parseObject(elements.text());
					if (StringUtils.isNotBlank(json.getString("status"))) {
						if ("200".equals(json.getString("status"))) {
							json.put("status", "1");
						} else {
							json.put("status", "0");
						}
						return json.toJSONString();
					}
				}
			} catch (Exception e) {
				log.error("根据物流单号去http://m.kuaidi100.com查询物流信息出错：", e);
			}
		}

		return StringUtils.EMPTY;
	}

	/***
	 * 2016-11-03 请求快递100
	 * 
	 * @param param
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public String getExpress100Info(Map param) {
		String res = "";
		try {
			res = HttpRequest.postData(EXPRESS_URL, param, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/***
	 * 2016-11-03 组装请求快递100参数
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map getExpress100Params(String param) {
		String paramVal = param + EXPRESS_KEY + CUSTOMER_NO;
		String sign = Md5Encrypt.md5(paramVal).toUpperCase();
		Map params = new HashMap();
		params.put("customer", CUSTOMER_NO);
		params.put("sign", sign);
		params.put("param", param);
		return params;
	}

	/***
	 * 2016-11-03 请求快递信息对外服务
	 * 
	 * @param param
	 */
	@SuppressWarnings("rawtypes")
	public String getOrderExpressInfo(String param) {
		Map mapParams = this.getExpress100Params(param);
		String res = this.getExpress100Info(mapParams);
		return res;
	}

}
