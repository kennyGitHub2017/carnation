package vc.thinker.b2b2c.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.tools.PaymentTools;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * 
 * <p>
 * Title: PaymentManageAction.java
 * </p>
 * 
 * <p>
 * Description:支付方式控制器,配置系统接受支付的所有支付方式，B2B2C由平台统一收款，只需要运营商配置收款方式，商家无需关心收款方式
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-25
 * 
 * @version 1.0.1
 */
@Controller
public class PaymentManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PaymentTools paymentTools;

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "支付方式列表", value = "/admin/payment_list.htm*", rtype = "admin", rname = "支付方式", rcode = "payment_set", rgroup = "系统管理")
	@RequestMapping("/admin/payment_list.htm")
	public ModelAndView payment_list(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/payment_list.html", configService.getSysConfig(), 0,
				request, response);
		SysConfig config = this.configService.getSysConfig();
		String store_payment = CommUtil.null2String(config.getStorePayment());
		Map map = Json.fromJson(HashMap.class, store_payment);
		if (map != null) {
			for (Iterator it = map.keySet().iterator(); it.hasNext();) {
				String key = (String) it.next();
				Object val = map.get(key);
				mv.addObject(key, val);
			}
		}
		mv.addObject("paymentTools", paymentTools);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "支付方式设置", value = "/admin/payment_set.htm*", rtype = "admin", rname = "支付方式", rcode = "payment_set", rgroup = "系统管理")
	@RequestMapping("/admin/payment_set.htm")
	public ModelAndView payment_set(HttpServletRequest request, HttpServletResponse response, String mark,
			String type, String pay, String config_id) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (CommUtil.null2String(type).equals("admin")) {
			Payment obj = this.paymentService.findByMark(mark);
			if (obj == null) {
				obj = new Payment();
			}

			obj.setAddTime(new Date());
			obj.setMark(mark);
			obj.setInstall(!CommUtil.null2Boolean(pay));
			if (CommUtil.null2String(obj.getName()).equals("")) {
				if (mark.trim().equals("alipay")) {
					obj.setName("支付宝");
				}
				if (mark.trim().equals("balance")) {
					obj.setName("预存款支付");
				}
				if (mark.trim().equals("outline")) {
					obj.setName("线下支付");
				}
				if (mark.trim().equals("tenpay")) {
					obj.setName("财付通");
				}
				if (mark.trim().equals("bill")) {
					obj.setName("快钱支付");
				}
				if (mark.trim().equals("chinabank")) {
					obj.setName("网银在线");
				}
				if (mark.trim().equals("alipay_wap")) {
					obj.setName("支付宝手机网页支付");
				}
			}
			this.paymentService.save(obj);
		}
		if (CommUtil.null2String(type).equals("user")) {
			SysConfig config = this.configService.getSysConfig();
			String store_payment = CommUtil.null2String(config.getStorePayment());
			Map map = Json.fromJson(HashMap.class, store_payment);
			if (map == null)
				map = new HashMap();
			map.put(mark, !CommUtil.null2Boolean(pay));
			store_payment = Json.toJson(map, JsonFormat.compact());
			config.setStorePayment(store_payment);
			if (!CommUtil.null2String(config_id).equals("")) {
				this.configService.update(config);
			} else
				this.configService.save(config);
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/payment_list.htm?type=" + type);
		mv.addObject("op_title", "设置支付方式成功");
		mv.addObject("paymentTools", paymentTools);
		return mv;
	}

	@SecurityMapping(title = "支付方式编辑", value = "/admin/payment_edit.htm*", rtype = "admin", rname = "支付方式", rcode = "payment_set", rgroup = "系统管理")
	@RequestMapping("/admin/payment_edit.htm")
	public ModelAndView payment_edit(HttpServletRequest request, HttpServletResponse response, String mark) {
		ModelAndView mv = new JModelAndView("admin/blue/payment_info.html", configService.getSysConfig(), 0,
				request, response);
		Payment obj = this.paymentService.findByMark(mark);
		if (obj == null) {
			obj = new Payment();
			obj.setMark(mark);
		}
		mv.addObject("obj", obj);
		mv.addObject("edit", true);
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "支付方式保存", value = "/admin/payment_save.htm*", rtype = "admin", rname = "支付方式", rcode = "payment_set", rgroup = "系统管理")
	@RequestMapping("/admin/payment_save.htm")
	public ModelAndView payment_save(HttpServletRequest request, HttpServletResponse response, String mark,
			String list_url) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Payment obj = this.paymentService.findByMark(mark);
		if (obj == null) {
			obj = new Payment();
		}
		if (obj != null) {
			Payment temp = obj;
			WebForm wf = new WebForm();
			obj = (Payment) wf.toPo(request, temp);
		} else {
			WebForm wf = new WebForm();
			obj = wf.toPo(request, Payment.class);
			obj.setAddTime(new Date());
		}
		this.paymentService.save(obj);
		mv.addObject("op_title", "保存支付方式成功");
		mv.addObject("list_url", list_url);
		return mv;
	}
}
