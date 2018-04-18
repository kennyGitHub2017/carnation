package vc.thinker.b2b2c.action.payment;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.service.SellerService;

import vc.thinker.b2b2c.core.mv.JModelAndView;

/**
 * 云尚App支付
 * 
 * @author xing.wen
 * 
 */
@Controller
public class YunAPPPayAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private GroupOrderService groupOrderService;

	private static final Logger logger = LoggerFactory.getLogger(YunAPPPayAction.class);

	/**
	 * 云尚App扫描支付订单生成
	 * 
	 * @param request
	 * @param response
	 * @param sellerID
	 */
	@RequestMapping(value = "yun_shang/wap.htm", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView yun_wap(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "sellerUid") String sellerUid, @RequestParam(value = "uid") String uid,
			@RequestParam(value = "money") BigDecimal money, 
			@RequestParam(value = "orderType") String orderType) {
		logger.debug("[app scan,YUN_SHANG] arguments uid=" + uid + ",sellerUid=" + sellerUid + ",money"
				+ money);
		//区分描码支付还是优惠买单类型，默认为扫码支付
		Integer odType = "3".equals(orderType) ? 3 : 2;
		//SellerBO sellerBO = sellerService.findByUid(Long.valueOf(sellerUid));
		SellerBO sellerBO = this.sellerService.findSessionById(Long.valueOf(sellerUid), true, false);
		Long orderid = groupOrderService.createGroupOrder(Long.valueOf(uid), sellerBO.getStoreId(),
				"云尚App扫描支付", money, odType);
		if (null == orderid) {
			return null;
		}
		GroupOrderBO groupOrderBO = groupOrderService.getGroupOrderBOById(orderid);
		if (null == groupOrderBO) {
			return null;
		}
		ModelAndView mv = null;
		mv = new JModelAndView("qr_pay/ajax/yun_app_san_pay_result.html", configService.getSysConfig(), 1,
				request, response);
		mv.addObject("sellerUid", sellerUid);
		mv.addObject("uid", uid);
		mv.addObject("orderId", orderid);
		// 给端判断是否是服务订单
		mv.addObject("orderType", odType);
		mv.addObject("orderNum", groupOrderBO.getOrderId());
		mv.addObject("money", money);
		return mv;
	}
}
