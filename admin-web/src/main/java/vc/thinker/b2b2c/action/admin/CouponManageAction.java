package vc.thinker.b2b2c.action.admin;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.model.Coupon;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.carnation.store.bo.StoreGradeBO;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: CouponManageAction.java
 * </p>
 * 
 * <p>
 * Description: 优惠券控制管理器，管理商城系统优惠券信息 优惠券使用方法： 1、管理员添加优惠券，包括优惠券面额、使用条件（订单满多少可以可以用），优惠券数量、使用时间区间
 * 2、优惠券只有平台管理员赠送用户才能获取 3、用户购物订单金额满足优惠券使用条件后可以使用优惠券
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
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class CouponManageAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private CouponService couponService;
	// @Autowired
	// private ICouponInfoService couponinfoService;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private StoreGradeService storeGradeService;

	// @Autowired
	// private IUserService userService;
	// @Autowired
	// private IOrderFormService orderFormService;
	// @Autowired
	// private WeedFSFilerClient fsClient;
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
	@SecurityMapping(title = "优惠券列表", value = "/admin/coupon_list.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_list.htm")
	public ModelAndView coupon_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String couponName, String couponBeginTime, String couponEndTime,
			MyPage<CouponBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/coupon_list.html", configService.getSysConfig(), 0,
				request, response);
		String url = configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(20);
		couponService.queryCouponPageList(couponName, couponBeginTime, couponEndTime, page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/coupon_list.htm", "", "", page, mv);
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
	@SecurityMapping(title = "优惠券添加", value = "/admin/coupon_add.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_add.htm")
	public ModelAndView coupon_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/coupon_add.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 优惠券保存，保存或者更新一个优惠券信息
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "优惠券保存", value = "/admin/coupon_save.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_save.htm")
	public String coupon_save(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		WebForm wf = new WebForm();
		Coupon coupon = wf.toPo(request, Coupon.class);
//		String imgPath = accessoryService.upload(request, file.getName(), null);
//		coupon.setCouponAcc(imgPath);
		coupon.setAddTime(new Date());
		couponService.save(coupon);
		return "redirect:coupon_success.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "优惠券保存成功", value = "/admin/coupon_success.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_success.htm")
	public ModelAndView coupon_success(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/coupon_list.htm");
		mv.addObject("op_title", "优惠券保存成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/coupon_add.htm" + "?currentPage="
				+ currentPage);
		return mv;
	}

	@SecurityMapping(title = "优惠券发放", value = "/admin/coupon_send.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_send.htm")
	public ModelAndView coupon_send(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/coupon_send.html", configService.getSysConfig(), 0,
				request, response);
		List<StoreGradeBO> grades = storeGradeService.queryStoreGradePageList();
		mv.addObject("grades", grades);
		mv.addObject("currentPage", currentPage);
		mv.addObject("obj", this.couponService.getObjById(CommUtil.null2Long(id)));
		return mv;
	}

	@SecurityMapping(title = "优惠券发放保存", value = "/admin/coupon_send_save.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_send_save.htm")
	public ModelAndView coupon_send_save(HttpServletRequest request, HttpServletResponse response, String id,
			String type, String users, String grades, String order_amount) throws IOException {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		couponService.sendCoipon(type, id, users);
		mv.addObject("op_title", "优惠券发放成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/coupon_list.htm");
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "优惠券AJAX更新", value = "/admin/coupon_ajax.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_ajax.htm")
	public void coupon_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		Coupon obj = this.couponService.getObjById(Long.parseLong(id));
		Field[] fields = Coupon.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			// System.out.println(field.getName());
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.String");
				if (field.getType().getName().equals("int")) {
					clz = Class.forName("java.lang.Integer");
				}
				if (field.getType().getName().equals("boolean")) {
					clz = Class.forName("java.lang.Boolean");
				}
				if (!value.equals("")) {
					val = BeanUtils.convertType(value, clz);
				} else {
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.couponService.update(obj);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SecurityMapping(title = "优惠券详细信息", value = "/admin/coupon_info_list.htm*", rtype = "admin", rname = "优惠券管理", rcode = "coupon_admin", rgroup = "商城管理")
	@RequestMapping("/admin/coupon_info_list.htm")
	public ModelAndView coupon_info_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String couponId, MyPage<CouponInfoBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/coupon_info_list.html", configService.getSysConfig(),
				0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(20);
		couponService.queryCouponInfos(couponId, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("coupon_id", couponId);
		return mv;
	}

	@SuppressWarnings("unused")
	private boolean waterMarkWithText(String filePath, String outPath, String text, String markContentColor,
			Font font, int left, int top, float qualNum) {

		/*
		 * try { BufferedImage originalImage =
		 * ImageIO.read(fsClient.download(filePath));
		 * 
		 * // Set up the caption properties String caption = text; //Font f =
		 * new Font("Monospaced", Font.PLAIN, 14); Color c =
		 * CommUtil.getColor(markContentColor); Position position =
		 * Positions.BOTTOM_RIGHT; int insetPixels = 0;
		 * 
		 * // Apply caption to the image Caption filter = new Caption(caption,
		 * font, c, position, insetPixels); BufferedImage captionedImage =
		 * filter.apply(originalImage);
		 * 
		 * ByteArrayOutputStream out = new ByteArrayOutputStream();
		 * ImageIO.write(captionedImage, "JPEG", out);
		 * 
		 * RequestResult result = fsClient.upload(out.toByteArray(),
		 * filePath,FilenameUtils.getBaseName(outPath),"image/"+
		 * FilenameUtils.getExtension(outPath)); } catch (Exception e) { return
		 * false; } return true;
		 */

		// try {
		// ImageIcon imgIcon = new ImageIcon(new URL(filePath));
		// Image theImg = imgIcon.getImage();
		// int width = theImg.getWidth(null);
		// int height = theImg.getHeight(null);
		// BufferedImage bimage = new BufferedImage(width, height,
		// BufferedImage.TYPE_INT_RGB);
		// Graphics2D g = bimage.createGraphics();
		// if (font == null) {
		// font = new Font("宋体", Font.BOLD, 20);
		// g.setFont(font);
		// } else {
		// g.setFont(font);
		// }
		// g.setColor(CommUtil.getColor(markContentColor));
		// g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
		// 1.0f));
		// g.drawImage(theImg, 0, 0, null);
		// FontMetrics metrics = new FontMetrics(font) {
		// };
		// g.drawString(text, left, top); // 添加水印的文字和设置水印文字出现的内容
		// g.dispose();
		//
		// ByteArrayOutputStream out = new ByteArrayOutputStream();
		// ImageIO.write(bimage, "JPEG", out);
		// RequestResult result = fsClient.upload(out.toByteArray(), filePath,
		// FilenameUtils.getBaseName(outPath), "image/" +
		// FilenameUtils.getExtension(outPath));
		// System.out.println(result);
		// /*
		// * FileOutputStream out = new FileOutputStream(outPath);
		// * ImageIO.write(bimage,
		// * filePath.substring(filePath.lastIndexOf(".") + 1), out);
		// * out.close();
		// */
		// } catch (Exception e) {
		// return false;
		// }
		return true;
	}
}