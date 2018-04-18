package vc.thinker.b2b2c.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 
 * <p>
 * Title: YunByMoneyViewAction.java
 * </p>
 * 
 * <p>
 * Description:云购币专区
 */
@Controller
public class YunByMoneyViewAction {

	@Autowired
	private SysConfigService configService;

	/**
	 * 云购币专区首页
	 * 
	 * @param request
	 * @param response
	 * @param apCode
	 * @return
	 */
	@RequestMapping("/YunByMoney/index.htm")
	public ModelAndView yungoubi(HttpServletRequest request, HttpServletResponse response, String apCode) {
		ModelAndView mv = new JModelAndView("YunByMoney/index.html", configService.getSysConfig(), 1,
				request, response);

		return mv;
	}

}
