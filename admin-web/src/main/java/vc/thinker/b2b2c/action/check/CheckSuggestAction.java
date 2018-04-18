package vc.thinker.b2b2c.action.check;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.sys.bo.SysKeyWordMapBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.vo.SysKeyWordMapVO;
import com.sinco.carnation.user.bo.PhysicalSuggestBO;
import com.sinco.carnation.user.enums.EmPhysicalResultType;
import com.sinco.carnation.user.enums.EmPhysicalSuggestType;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.vo.PhysicalSuggestVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

/***
 * 体检建议管理
 * 
 * @author LKN
 * 
 */
@Controller
@RequestMapping("admin/checkSuggest")
public class CheckSuggestAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private PhysicalService physicalService;

	/**
	 * 体检建议列表
	 * 
	 * @return
	 */
	@SecurityMapping(title = "体检建议列表", value = "/pageList.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("pageList.htm")
	public ModelAndView physical_suggest_list(HttpServletRequest request, HttpServletResponse response,
			PhysicalSuggestVO vo, MyPage<PhysicalSuggestBO> page) {

		ModelAndView mv = new JModelAndView("admin/blue/physical/check_physical_suggest.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		this.physicalService.findPageByVo(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("typeList", this.physicalService.findPhysicalTypeAll());
		mv.addObject("physicalResult", EmPhysicalResultType.getPhysicalResultTypeMap());
		mv.addObject("suggestType", EmPhysicalSuggestType.getPhysicalSuggestTypeMap());
		mv.addObject("vo", vo);
		return mv;
	}

	/***
	 * 添加体检建议页面
	 * 
	 * @return
	 */
	@SecurityMapping(title = "体检建议编辑页面", value = "/addPage.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("addPage.htm")
	public ModelAndView add_suggest_page(HttpServletRequest request, HttpServletResponse response, Long id,
			String flag) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/physical_suggest_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("typeList", this.physicalService.findPhysicalTypeAll());// 体检项目
		mv.addObject("physicalResult", EmPhysicalResultType.getPhysicalResultTypeMap());// 体检结果
		mv.addObject("keyWordList", this.physicalService.findKeyWordAll());// 体检关键字
		mv.addObject("keyWordType", this.physicalService.selectKeyWordTypeList());// 关键字类型
		if (flag != null && flag.equals("1")) {// 添加
			PhysicalSuggestBO result = this.physicalService.getSuggestById(id);
			SysKeyWordMapVO vo = new SysKeyWordMapVO();
			vo.setTypeId(id);
			List<SysKeyWordMapBO> skm = this.physicalService.getKeyWordMapByVo(vo); // 关联表/添加的关键字
			mv.addObject("suggestBo", result);
			mv.addObject("skmResult", skm);
			mv.addObject("flag", flag);
		}

		return mv;
	}

	/***
	 * 编辑体检建内容
	 * 
	 * @param vo
	 * @return
	 */
	@SecurityMapping(title = "体检建议编辑", value = "/editSuggest.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("editSuggest.htm")
	public String edit_suggest(PhysicalSuggestVO vo) {
		this.physicalService.editPhysicalSuggest(vo);
		return "redirect:/admin/checkSuggest/pageList.htm";
	}

	/***
	 * 根据Id删除
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "体检建议删除", value = "/deleteById.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("deleteById.htm")
	public String delete_suggest(Long id) {
		this.physicalService.deleteSuggest(id);
		return "redirect:/admin/checkSuggest/pageList.htm";
	}

	/****
	 * 修改体检建议
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping("updateSuggest.htm")
	public String update_suggest(PhysicalSuggestVO vo) {
		this.physicalService.modifySuggest(vo);
		return "redirect:/admin/checkSuggest/pageList.htm";

	}

}
