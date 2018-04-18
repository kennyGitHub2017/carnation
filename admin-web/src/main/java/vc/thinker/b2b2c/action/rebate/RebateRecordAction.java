package vc.thinker.b2b2c.action.rebate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * @ClassName: RebateRecordAction
 * @Description: TODO(返润明细)
 * @author Tang
 * @date 2015年10月20日 下午4:05:47
 * 
 */
@Controller
public class RebateRecordAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private RebateRecordService rebateRecordService;

	@SecurityMapping(title = "运营商返润列表", value = "/admin/operator_rebate_list.htm*", rtype = "admin", rname = "运营商返润查询", rcode = "operator_rebate", rgroup = "运营商")
	@RequestMapping("/admin/operator_rebate_list.htm")
	public ModelAndView operatorRebateList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<RebateRecordBO> page, RebateRecordVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_rebate_list.html",
				configService.getSysConfig(), 0, request, response);
		rebateRecordService.selectOperatorRebateCode(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);

		return mv;
	}

}
