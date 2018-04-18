package com.sinco.carnation.kuaidi100.post;

import java.util.HashMap;

import com.sinco.carnation.kuaidi100.pojo.TaskRequest;
import com.sinco.carnation.kuaidi100.pojo.TaskResponse;

/**
 * 
 * <p>
 * Title: PostOrder.java
 * </p>
 * 
 * <p>
 * Description: 快递100接口测试类
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
 * @date 2014-12-9
 * 
 * @version 1.0.1
 */
public class PostOrder {

	public static void main(String[] args) {
		TaskRequest req = new TaskRequest();
		req.setCompany("yuantong");
		req.setFrom("上海浦东新区");
		req.setTo("广东深圳南山区");
		req.setNumber("12345678");
		req.getParameters().put("callbackurl", "http://www.yourdmain.com/kuaidi");
		req.setKey("PaSQwmsf4785");

		HashMap<String, String> p = new HashMap<String, String>();
		p.put("schema", "json");
		p.put("param", JacksonHelper.toJSON(req));
		try {
			String ret = HttpRequest.postData("http://www.kuaidi100.com/poll", p, "UTF-8");
			TaskResponse resp = JacksonHelper.fromJSON(ret, TaskResponse.class);
			if (resp.getResult() == true) {
				System.out.println("订阅成功");
			} else {
				System.out.println("订阅失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
