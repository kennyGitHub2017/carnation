package vc.thinker.b2b2c.action.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: ConsultSellerAction.java
 * </p>
 * 
 * <p>
 * Description:卖家咨询管理器，显示所有卖家咨询信息，卖家在这里可以回复买家的咨询及其他咨询信息的操作
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
 * @date 2014-9-29
 * 
 * @version 1.0.1
 */
@Controller
public class ConsultSellerAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private StoreService storeService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private UserService userService;
//	@Autowired
//	private ITemplateService templateService;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private GoodsViewTools GoodsViewTools;
	@Autowired
	private UserCustomerService userCustomerService;

	@SecurityMapping(title = "卖家咨询列表", value = "/seller/consult.htm*", rtype = "seller", rname = "咨询管理", rcode = "consult_seller", rgroup = "客户服务")
	@RequestMapping("/seller/consult.htm")
	public ModelAndView consult(HttpServletRequest request, HttpServletResponse response, String reply,
			MyPage<ConsultBO> page) {
		ConsultVO vo = new ConsultVO();
		ModelAndView mv = new JModelAndView("user/default/sellercenter/consult.html",
				configService.getSysConfig(), 0, request, response);
		if (!CommUtil.null2String(reply).equals("")) {
			vo.setReply(CommUtil.null2Boolean(reply));
		}
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				vo.setStoreId(userDetails.getStoreId() + "");
			}
		}
		consultService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("reply", CommUtil.null2String(reply));
		mv.addObject("GoodsViewTools", GoodsViewTools);
		return mv;
	}

	@SecurityMapping(title = "卖家咨询回复", value = "/seller/consult_reply.htm*", rtype = "seller", rname = "咨询管理", rcode = "consult_seller", rgroup = "客户服务")
	@RequestMapping("/seller/consult_reply.htm")
	public ModelAndView consult_reply(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/consult_reply.html",
				configService.getSysConfig(), 0, request, response);
		Consult obj = this.consultService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "卖家咨询回复保存", value = "/seller/consult_reply_save.htm*", rtype = "seller", rname = "咨询管理", rcode = "consult_seller", rgroup = "客户服务")
	@RequestMapping("/seller/consult_reply_save.htm")
	public String consult_reply_save(HttpServletRequest request, HttpServletResponse response, String id,
			String consultReply, String currentPage) throws Exception {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String url = CommUtil.getURL(request);
		consultService.consultReplySave(id, consultReply, userDetails.getUsername(), userDetails.getId(),
				userDetails.getStoreId(), url);
		return "redirect:consult.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "卖家咨询删除", value = "/seller/consult_del.htm*", rtype = "seller", rname = "咨询管理", rcode = "consult_seller", rgroup = "客户服务")
	@RequestMapping("/seller/consult_del.htm")
	public String consult_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String[] ids = mulitId.split(",");
		consultService.deleteConsults(ids, userDetails.getStoreId());
		return "redirect:consult.htm?currentPage=" + currentPage;
	}
}
