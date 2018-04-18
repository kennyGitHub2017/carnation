package vc.thinker.b2b2c.action.check;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.PhysicalKeyWordBO;
import com.sinco.carnation.user.model.PhysicalKeyWord;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.vo.PhysicalKeyWordVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

@RequestMapping("admin/physicalKeyWord")
@Controller
public class PhysicalKeyWordAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private PhysicalService physicalService;

	/***
	 * 体检关键字列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "关键字列表", value = "/pageList.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("pageList.htm")
	public ModelAndView keyWord_list(HttpServletRequest request, HttpServletResponse response,
			PhysicalKeyWordVO vo, MyPage<PhysicalKeyWordBO> page) {

		ModelAndView mv = new JModelAndView("admin/blue/physical/physical_key_word.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		this.physicalService.findPageKeyWord(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	/***
	 * 编辑关键字页面
	 * 
	 * @return
	 */
	@SecurityMapping(title = "关键字编辑页面", value = "/editKeyWordPage.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("editKeyWordPage.htm")
	public ModelAndView edit_keyWord_page(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/key_word_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("keyWordType", this.physicalService.selectKeyWordTypeList());
		return mv;
	}

	/***
	 * 编辑关键字
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "关键字编辑", value = "/editKeyWord.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("editKeyWord.htm")
	public String edit_KeyWord(HttpServletRequest request, HttpServletResponse response, PhysicalKeyWordVO vo) {

		this.physicalService.editKeyWord(vo);

		return "redirect:/admin/physicalKeyWord/pageList.htm";
	}

	/***
	 * 删除关键字
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "关键字删除", value = "/deleteKeyWord.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("deleteKeyWord.htm")
	public String deleteKeyWord(Long id) {
		this.physicalService.deleteKeyWord(id);
		return "redirect:/admin/physicalKeyWord/pageList.htm";
	}

	/**
	 * 给js调用，根据关键字类型获取关键字列表
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping("getKeyWordByType.htm")
	@ResponseBody
	public String findKeyWordByType(Integer type) {
		List<PhysicalKeyWord> list = physicalService.findKeyWordByType(type);
		return Json.toJson(ActionResult.NewSuccess(list));
	}

	/***
	 * 根据条件查询关键字
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping("getKeyWordByVo.htm")
	@ResponseBody
	public void getKeyWordByVo(HttpServletRequest request, HttpServletResponse response, PhysicalKeyWordVO vo) {
		List<PhysicalKeyWordBO> list = this.physicalService.selectKeyWordByVo(vo);

		String temp = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
