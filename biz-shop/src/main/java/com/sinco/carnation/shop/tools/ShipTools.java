package com.sinco.carnation.shop.tools;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * <p>
 * Ship
 * </p>
 * 
 * <p>
 * Description:物流查询工具类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014年5月23日
 * 
 * @version 1.0.1
 */
@Component
public class ShipTools {
//	@Autowired
//	private IOrderFormService orderFormService;
//	@Autowired
//	private ISysConfigService configService;
//	@Autowired
//	private IExpressCompanyService expressCompanyService;
//
//	public TransInfo query_ship_getData(String id) {
//		TransInfo info = new TransInfo();
//		OrderForm obj = this.orderFormService
//				.getObjById(CommUtil.null2Long(id));
//		try {
//			ExpressCompany ec = this.queryExpressCompany(obj.getExpress_info());
//			String query_url = "http://api.kuaidi100.com/api?id="
//					+ this.configService.getSysConfig().getKuaidi_id()
//					+ "&com=" + (ec != null ? ec.getCompany_mark() : "")
//					+ "&nu=" + obj.getShipCode() + "&show=0&muti=1&order=asc";
//			URL url = new URL(query_url);
//			URLConnection con = url.openConnection();
//			con.setAllowUserInteraction(false);
//			InputStream urlStream = url.openStream();
//			String type = con.guessContentTypeFromStream(urlStream);
//			String charSet = null;
//			if (type == null)
//				type = con.getContentType();
//			if (type == null || type.trim().length() == 0
//					|| type.trim().indexOf("text/html") < 0)
//				return info;
//			if (type.indexOf("charset=") > 0)
//				charSet = type.substring(type.indexOf("charset=") + 8);
//			byte b[] = new byte[10000];
//			int numRead = urlStream.read(b);
//			String content = new String(b, 0, numRead, charSet);
//			while (numRead != -1) {
//				numRead = urlStream.read(b);
//				if (numRead != -1) {
//					// String newContent = new String(b, 0, numRead);
//					String newContent = new String(b, 0, numRead, charSet);
//					content += newContent;
//				}
//			}
//			info = Json.fromJson(TransInfo.class, content);
//			urlStream.close();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return info;
//	}
//
//	public ExpressCompany queryExpressCompany(String json) {
//		ExpressCompany ec = null;
//		if (json != null && !json.equals("")) {
//			HashMap map = Json.fromJson(HashMap.class, json);
//			ec = this.expressCompanyService.getObjById(CommUtil.null2Long(map
//					.get("express_company_id")));
//		}
//		return ec;
//	}
}
