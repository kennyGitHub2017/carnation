package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSFilerClient;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.model.Coupon;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

/**
 * 
 * 
 * <p>
 * Title:CouponSeller.java
 * </p>
 * 
 * <p>
 * Description: 卖家中心优惠劵控制器
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
 * @date 2014年5月5日
 * 
 * @version 1.0.1
 */
@Controller
public class CouponSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private CouponInfoService couponinfoService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private WeedFSFilerClient fsClient;

	/**
	 * 优惠券列表信息页面，分页显示优惠券列表信息
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return 优惠券列表信息页
	 */
	@SecurityMapping(title = "优惠券列表", value = "/seller/coupon.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon.htm")
	public ModelAndView coupon(HttpServletRequest request, HttpServletResponse response,
			MyPage<CouponBO> page, String couponName, String couponBeginTime, String couponEndTime) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/coupon_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		this.couponService.queryCouponPageList(userDetails.getStoreId(), couponName, couponBeginTime,
				couponEndTime, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("couponName", couponName);
		mv.addObject("couponBeginTime", couponBeginTime);
		mv.addObject("couponEndTime", couponEndTime);
		return mv;
	}

	/**
	 * 添加优惠券信息
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return 优惠券添加页面
	 */
	@SecurityMapping(title = "优惠券添加", value = "/seller/coupon_add.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_add.htm")
	public ModelAndView coupon_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/coupon_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 编辑优惠券信息
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return 优惠券添加页面
	 */
	@SecurityMapping(title = "优惠券编辑", value = "/seller/coupon_edit.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_edit.htm")
	public ModelAndView coupon_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/coupon_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		Coupon coupon = this.couponService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", coupon);
		mv.addObject("edit", true);
		return mv;
	}

	/**
	 * 优惠券保存，保存或者更新一个优惠券信息
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "优惠券保存", value = "/seller/coupon_save.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_save.htm")
	public void coupon_save(HttpServletRequest request, HttpServletResponse response, String currentPage,
			@RequestParam("couponImg") MultipartFile file) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		WebForm wf = new WebForm();
		Coupon coupon = wf.toPo(request, Coupon.class);
		if (file != null) {
			String imgPath = accessoryService.upload(request, file.getName(), null);
			if (StringUtils.isNotBlank(imgPath)) {
				coupon.setCouponAcc(imgPath);
			}
		}
		if (coupon.getId() == null) {
			coupon.setCouponType(1);// 设置为商家发布
			coupon.setStoreId(userDetails.getStoreId());
			coupon.setAddTime(new Date());
			couponService.save(coupon);
		} else {
			Coupon couponPo = couponService.getObjById(coupon.getId());
			if (couponPo.getStoreId().equals(userDetails.getStoreId())) {
				couponService.save(coupon);
			}
		}

		Map<String, Object> json = new HashMap<>();
		json.put("ret", true);
		json.put("op_title", "优惠券保存成功");
		json.put(
				"url",
				CommUtil.getURL(request) + "/seller/coupon.htm?currentPage="
						+ (StringUtils.isEmpty(currentPage) ? 1 : currentPage));
		this.return_json(Json.toJson(json, JsonFormat.compact()), response);
	}

	@SecurityMapping(title = "优惠券保存成功", value = "/seller/coupon_success.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_success.htm")
	public ModelAndView coupon_success(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_success.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("url", CommUtil.getURL(request) + "/seller/coupon.htm?currentPage=" + currentPage);
		mv.addObject("op_title", "优惠券保存成功");
		return mv;
	}

	/**
	 * 删除优惠券
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return 优惠券添加页面
	 */
	@SecurityMapping(title = "优惠券删除", value = "/seller/coupon_del.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_del.htm")
	public String coupon_del(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String id) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Coupon coupon = this.couponService.getObjById(CommUtil.null2Long(id));
		if (coupon != null && coupon.getStoreId().equals(userDetails.getStoreId())) {
			this.couponService.delete(CommUtil.null2Long(id));
		}
		return "redirect:coupon.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "优惠券发放", value = "/seller/coupon_send.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_send.htm")
	public ModelAndView coupon_send(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/coupon_send.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		mv.addObject("obj", this.couponService.getObjById(CommUtil.null2Long(id)));
		return mv;
	}

	@SecurityMapping(title = "优惠券发放保存", value = "/seller/coupon_send_save.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_send_save.htm")
	public void coupon_send_save(HttpServletRequest request, HttpServletResponse response, String id,
			String type, String users, BigDecimal orderAmount, String currentPage) throws IOException {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		couponService.sendCoipon(type, id, users, userDetails.getStoreId(), orderAmount);
		Map<String, Object> json = new HashMap<>();
		json.put("ret", true);
		json.put("op_title", "优惠券发放成功");
		json.put("url", CommUtil.getURL(request) + "/seller/coupon.htm?currentPage=" + currentPage);
		this.return_json(Json.toJson(json, JsonFormat.compact()), response);
	}

	@SecurityMapping(title = "优惠券详细信息", value = "/seller/coupon_ajax.htm*", rtype = "seller", rname = "优惠券管理", rcode = "coupon_seller", rgroup = "促销推广")
	@RequestMapping("/seller/coupon_info_list.htm")
	public ModelAndView coupon_info_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String couponId, MyPage<CouponInfoBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/coupon_info_list.html",
				configService.getSysConfig(), 0, request, response);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(20);
		couponService.queryCouponInfos(couponId, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("couponId", couponId);
		return mv;
	}

//	private static boolean waterMarkWithText(String filePath, String outPath,
//			String text, String markContentColor, Font font, int left, int top,
//			float qualNum) {
//		ImageIcon imgIcon = new ImageIcon(filePath);
//		Image theImg = imgIcon.getImage();
//		int width = theImg.getWidth(null);
//		int height = theImg.getHeight(null);
//		BufferedImage bimage = new BufferedImage(width, height,
//				BufferedImage.TYPE_INT_RGB);
//		Graphics2D g = bimage.createGraphics();
//		if (font == null) {
//			font = new Font("宋体", Font.BOLD, 20);
//			g.setFont(font);
//		} else {
//			g.setFont(font);
//		}
//		g.setColor(CommUtil.getColor(markContentColor));
//		g.setComposite(AlphaComposite
//				.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
//		g.drawImage(theImg, 0, 0, null);
//		FontMetrics metrics = new FontMetrics(font) {
//		};
//		g.drawString(text, left, top); // 添加水印的文字和设置水印文字出现的内容
//		g.dispose();
//		try {
//			FileOutputStream out = new FileOutputStream(outPath);
//			ImageIO.write(bimage,
//					filePath.substring(filePath.lastIndexOf(".") + 1), out);
//			out.close();
//		} catch (Exception e) {
//			return false;
//		}
//		return true;
//	}

	public void return_json(String json, HttpServletResponse response) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
