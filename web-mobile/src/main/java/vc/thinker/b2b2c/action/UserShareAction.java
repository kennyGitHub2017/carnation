package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinco.carnation.user.model.UserShare;
import com.sinco.carnation.user.service.UserShareService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: SnsUserShareAction.java
 * </p>
 * 
 * <p>
 * Description: 前台分享控制器
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
 * @date 2014-12-12
 * 
 * @version 1.0.1
 */
@Controller
public class UserShareAction {
	@Autowired
	private UserShareService userShareService;

	@SecurityMapping(title = "商品分享", value = "/share_goods.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/share_goods.htm")
	public void share_goods(HttpServletResponse response, String share_content, String share_goods_id,
			String share_goods_name, String share_goods_photo) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		UserShare userShare = new UserShare();
		userShare.setAddTime(new Date());
		userShare.setUserName(userDetails.getUsername());
		userShare.setUserId(userDetails.getId());
		userShare.setShareContent(share_content);
		userShare.setShareGoodsId(CommUtil.null2Long(share_goods_id));
		userShare.setShareGoodsName(share_goods_name);
		userShare.setShareGoodsPhoto(share_goods_photo);
		boolean ret = this.userShareService.save(userShare);
		if (ret) {
			response.setContentType("text/plain");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.print(ret);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
