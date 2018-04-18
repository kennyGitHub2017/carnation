package vc.thinker.b2b2c.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.sys.bo.orcl.IntegralSwapBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/****
 * 云购币专区
 * 
 * @author KENNY
 * 
 */

@Controller
public class YunGouViewAtion {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private OrclUserBaseService orclUserBaseService;
	@Autowired
	private UserCustomerService customerService;

	/***
	 * 云购币专区首页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("yunGou/index")
	public ModelAndView yunGouIndex(HttpServletRequest request, HttpServletResponse response, GoodsVO vo,
			MyPage<GoodsBO> page) {
		Long uid = SecurityUserHolder.getCurrentUserId();
		if(uid == null){
			//精品专区只有登陆后才能显示
			return new JModelAndView("404.html", configService.getSysConfig(), 1, request, response);
		}

		ModelAndView mv = new JModelAndView("yungou/index.html", configService.getSysConfig(), 1, request,
				response);
		vo.setIsYgb(1);// 云购币
		page.setPageSize(100);
		
		//登陆用户积分
		UserCustomer userCustomer = customerService.findOneByUserId(uid);
		mv.addObject("userCustomer", userCustomer);
		//购物积分
		UserAccount cnUserAccount = userAccountService.findUserAccount(uid, UserContant.ACCOUNT_TYPE_8);
		if(cnUserAccount != null){
			//CN用户
			mv.addObject("isCN", true);
			IntegralSwapBO integralBO = orclUserBaseService.getMyIntegral(cnUserAccount.getLoginName());
			mv.addObject("cnIntegral", (integralBO == null || integralBO.getSHOP_PV() == null) ? 0 : integralBO.getSHOP_PV());
			integralBO = orclUserBaseService.getMyCXB(cnUserAccount.getLoginName());
			mv.addObject("cnBonusRepeat", (integralBO == null || integralBO.getBONUS_REPEAT() == null) ? 0d : integralBO.getBONUS_REPEAT());
		}else{
			vo.setHasIntegral(1);
		}
		this.goodsService.getPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

}
