package vc.thinker.b2b2c.action.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.carnation.config.constant.DictionKey;
import com.sinco.carnation.config.model.ConfigSet;
import com.sinco.carnation.config.service.ConfigSetService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.sys.service.SysConfigService;

@Controller
public class ConfigSetAction {

	@Autowired
	protected SysConfigService configService;

	@Autowired
	private ConfigSetService cfService;

	@Autowired
	private WeedFSClient fsClient;
	
	@Autowired
	private OrderFormService orderFormService;

	@SecurityMapping(title = "双倍积分管理列表", value = "/admin/double_score_set.htm*", rtype = "admin", rname = "双倍积分管理", rcode = "market_double_score_admin", rgroup = "营销")
	@RequestMapping("/admin/double_score_set.htm")
	public ModelAndView doubleScoreList(HttpServletRequest request, HttpServletResponse response,
			Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/double_score/double_score_set.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("objs", cfService.getCfDao().findAll());
		mv.addObject("dictionkey", new DictionKey());

		return mv;
	}

	@SecurityMapping(title = "双倍积分保存", value = "/admin/double_score_save.htm*", rtype = "admin", rname = "双倍积分管理", rcode = "market_double_score_admin", rgroup = "营销")
	@RequestMapping("/admin/double_score_save.htm")
	public ModelAndView doubleScoreSave(HttpServletRequest request, HttpServletResponse response) {

		Enumeration<?> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			if (name.indexOf("+") < 0) {
				String value = request.getParameter(name);
				String id = request.getParameter(name + "+");
				ConfigSet cf = new ConfigSet();
				cf.setNameValue(value);
				cf.setNameKey(name);
				if (id != null) {
					cf.setId(Long.parseLong(id));
				}
				cfService.getCfDao().update(cf);
			}
		}

		return new ModelAndView("redirect:/admin/double_score_set.htm");
	}


}
