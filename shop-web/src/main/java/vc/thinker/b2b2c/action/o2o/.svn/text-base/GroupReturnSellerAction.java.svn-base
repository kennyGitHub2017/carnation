package vc.thinker.b2b2c.action.o2o;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.tools.GroupOrderTools;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * Description 商户服务退款管理控制器
 */
@Controller
public class GroupReturnSellerAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupInfoService groupInfoService;
	@Autowired
	private GroupOrderTools groupOrderTools;

	@SecurityMapping(title = "线上服务退款列表", value = "/seller/group_return.htm*", rtype = "seller", rname = "线上服务退款", rcode = "seller_group_return", rgroup = "客户服务")
	@RequestMapping("/seller/group_return.htm")
	public ModelAndView seller_group_return(HttpServletRequest request, HttpServletResponse response,
			GroupInfoVO vo, MyPage<GroupInfoBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_return.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
				vo.setStoreId(userDetails.getStoreId());
			}
		}
		groupInfoService.findPageByStoreId(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("store", store);
		mv.addObject("groupOrderTools", groupOrderTools);
		return mv;
	}
}
