package vc.thinker.b2b2c.action.food;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.food.service.FoodCaloriesService;
import com.sinco.carnation.food.service.FoodClassService;
import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.bo.FoodClassBO;
import com.sinco.carnation.sns.model.FoodCalories;
import com.sinco.carnation.sns.model.FoodClass;
import com.sinco.carnation.sns.vo.FoodCaloriesVO;
import com.sinco.carnation.sns.vo.FoodClassVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

@Controller
public class FoodManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private FoodCaloriesService foodCaloriesService;
	@Autowired
	private FoodClassService foodClassService;

	/**
	 * 食物热量分类列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "食物热量分类列表", value = "/admin/food_class_list.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_class_list.htm")
	public ModelAndView food_class_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, FoodClassVO vo, MyPage<FoodClassBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/food_class_list.html", configService.getSysConfig(),
				0, request, response);
		this.foodClassService.findPageByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	/**
	 * 新增食物热量分类
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "新增食物热量分类", value = "/admin/food_class_add.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_class_add.htm")
	public ModelAndView food_class_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/food_class_add.html", configService.getSysConfig(),
				0, request, response);

		List<FoodClassBO> list = this.foodClassService.findAll();
		mv.addObject("gcs", list);

		return mv;
	}

	/**
	 * 编辑食物热量分类
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "编辑食物热量分类", value = "/admin/food_class_edit.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_class_edit.htm")
	public ModelAndView food_class_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/food_class_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && id > 0) {
			FoodClass obj = this.foodClassService.getById(id);
			mv.addObject("obj", obj);

			List<FoodClassBO> list = this.foodClassService.findAll();
			mv.addObject("gcs", list);
		}
		mv.addObject("edit", true);
		return mv;
	}

	/**
	 * 保存食物热量分类
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param addUrl
	 * @param listUrl
	 * @param foodClass
	 * @return
	 */
	@SecurityMapping(title = "保存食物热量分类", value = "/admin/food_class_save.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_class_save.htm")
	public ModelAndView food_class_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String addUrl, String listUrl, FoodClass foodClass) {
		ModelAndView mv = null;
		boolean flag = Boolean.FALSE;

		if (foodClass != null) {
			foodClass.setDeleteStatus(false);
			if (foodClass.getParentId() == null) {
				foodClass.setParentId(new Long(0));
			}

			if (foodClass.getId() == null) {// 新增
				flag = this.foodClassService.save(foodClass);
			} else {// 更新
				flag = this.foodClassService.update(foodClass);
			}
		}

		if (flag) {
			mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "食物分类成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "自测题分类保存失败！");
		}

		mv.addObject("list_url", listUrl);
		if (addUrl != null) {
			mv.addObject("add_url", addUrl);
		}

		return mv;
	}

	/**
	 * 删除食物热量分类
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "删除食物热量分类", value = "/admin/food_class_del.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_class_del.htm")
	public String food_class_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		this.foodClassService.delete(idList.toArray(new Long[idList.size()]));

		return "redirect:food_class_list.htm";
	}

	/**
	 * 食物热量列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "食物热量列表", value = "/admin/food_calories_list.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_calories_list.htm")
	public ModelAndView food_calories_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, FoodCaloriesVO vo, MyPage<FoodCaloriesBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/food_calories_list.html",
				configService.getSysConfig(), 0, request, response);
		List<FoodClassBO> foodClassList = this.foodClassService.findAll();
		mv.addObject("classes", foodClassList);

		this.foodCaloriesService.findPageByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		mv.addObject("vo", vo);

		return mv;
	}

	/**
	 * 增加食物热量
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "增加食物热量", value = "/admin/food_calories_add.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_calories_add.htm")
	public ModelAndView food_calories_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/food_calories_add.html",
				configService.getSysConfig(), 0, request, response);

		List<FoodClassBO> list = this.foodClassService.findAll();
		mv.addObject("gcs", list);

		return mv;
	}

	/**
	 * 编辑食物热量
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "编辑食物热量", value = "/admin/food_calories_edit.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_calories_edit.htm")
	public ModelAndView food_calories_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/food_calories_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && id > 0) {
			List<FoodClassBO> list = this.foodClassService.findAll();
			mv.addObject("gcs", list);

			FoodCaloriesBO obj = this.foodCaloriesService.getById(id);
			mv.addObject("obj", obj);
		}
		mv.addObject("edit", true);
		return mv;
	}

	/**
	 * 编辑食物热量
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "编辑食物热量", value = "/admin/food_calories_save.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_calories_save.htm")
	public ModelAndView food_calories_save(HttpServletRequest request, HttpServletResponse response,
			FoodCalories foodCalories, String addUrl, String listUrl) {
		ModelAndView mv = null;
		boolean flag = Boolean.FALSE;

		if (foodCalories != null) {

			if (foodCalories.getId() == null) {// 新增
				flag = this.foodCaloriesService.save(foodCalories);
			} else {// 更新
				flag = this.foodCaloriesService.update(foodCalories);
			}
		}

		if (flag) {
			mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "食物分类保存成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "食物分类保存失败！");
		}

		mv.addObject("list_url", listUrl);
		if (addUrl != null) {
			mv.addObject("add_url", addUrl);
		}

		return mv;
	}

	/**
	 * 删除食物热量分类
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "删除食物热量分类", value = "/admin/food_calories_del.htm*", rtype = "admin", rname = "食物热量分类", rcode = "food_admin", rgroup = "内容管理")
	@RequestMapping("/admin/food_calories_del.htm")
	public String food_calories_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		this.foodCaloriesService.delete(idList.toArray(new Long[idList.size()]));

		return "redirect:food_calories_list.htm";
	}
}