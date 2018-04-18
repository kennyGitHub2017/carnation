package vc.thinker.b2b2c.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.service.GoodsBrandCategoryService;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.dal.common.MyPage;

/***
 * 品牌馆action
 * 
 * @author kenny
 * 
 */
@Controller
public class BrandStoreViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsBrandCategoryService goodsBrandCategoryService;
	@Autowired
	private UserAccountService userAccountService;

	/***
	 * 品牌馆首页
	 * 
	 * @return
	 */
	@RequestMapping("brand-index.htm")
	public ModelAndView brandStroreIndex(HttpServletRequest request, HttpServletResponse response,
			GoodsShowListVO vo) {
		ModelAndView mv = new JModelAndView("web_mobile/brand_store_index.html",
				configService.getSysConfig(), 1, request, response);
		List<GoodsBrandCategoryBO> category = this.goodsBrandCategoryService.findAll();
		GoodsBrand gb = new GoodsBrand();
		gb.setDeleteStatus(false);
		List<GoodsBrandBO> brandList = this.goodsBrandService.findByVo(gb);

		mv.addObject("categoryList", category);// 品牌类型
		mv.addObject("brandList", brandList);// 品牌列表

		List<GoodsBO> goodsList = this.goodsService.findShopListBO(vo);
		mv.addObject("goodsList", goodsList);

		return mv;
	}

	/****
	 * 点击品牌，品牌产品列表
	 * 
	 * @param request
	 * @param brandId
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("goods-list-ByBrand.htm")
	public ModelAndView goodsListByBrand(HttpServletRequest request, String brandId,
			HttpServletResponse response,
			@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage, GoodsVO vo,
			MyPage<GoodsBO> page) {

		ModelAndView mv = new JModelAndView("web_mobile/brand_goods_list.html", configService.getSysConfig(),
				1, request, response);
		page.setCurrentPage(currentPage);// 页数
		page.setPageSize(100);// 设定分页查询，每页24件商品
		vo.setBrandIds(brandId);
		this.goodsService.getPageByVo(page, vo);

		page.getOrderBy();

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("currentPage", currentPage);
		mv.addObject("brandId", brandId);
		mv.addObject("orderBy", vo.getOrderBy());
		mv.addObject("orderType", vo.getOrderType());
		mv.addObject("goodsInventory", vo.getGoodsInventory());
		mv.addObject("goodsTransfee", vo.getGoodsTransfee());
		mv.addObject("exPriceFlag", vo.getExPriceFlag());

		// 加入CN用户判断 2017-3-16 tw
		Long uid = SecurityUserHolder.getCurrentUserId();
		if (uid != null) {
			UserAccount cnUserAccount = userAccountService.findUserAccount(uid, UserContant.ACCOUNT_TYPE_8);
			boolean isCN = cnUserAccount != null;
			mv.addObject("isCN", isCN);
		}
		return mv;
	}

	/****
	 * 点击品牌，品牌产品列表
	 * 
	 * @param request
	 * @param brandId
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("goods-list-ByBrand.htm1")
	public ModelAndView goodsListByBrand1(HttpServletRequest request, String brandId,
			HttpServletResponse response, GoodsVO vo, MyPage<GoodsBO> page) {
		ModelAndView mv = new JModelAndView("goodsList.html", configService.getSysConfig(), 1, request,
				response);
		page.setPageSize(100);// 设定分页查询，每页24件商品
		vo.setBrandIds(brandId);
		this.goodsService.getPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

}
