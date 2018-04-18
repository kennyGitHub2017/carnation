package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.service.SaleActivityMessageService;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * @info 系统ajax数据加载控制器
 * @since V1.0
 * 
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked"})
public class LoadAction {
	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private DicContent dicContant;

	@Autowired
	private StoreService sotreService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private SaleActivityMessageService saleActivityMessageService;

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;

	/**
	 * 根据父id加载下级区域，返回json格式数据，这里只返回id和areaName，根据需要可以修改返回数据
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@RequestMapping("/load_area.htm")
	public void load_area(HttpServletRequest request, HttpServletResponse response, String pid) {

		List<Area> areas = this.dicContant.getDicsConvertByParentCode(Area.class, pid);
		Collections.sort(areas);

		List<Map> list = new ArrayList<Map>();
		for (DicBase area : areas) {
			Map map = new HashMap();
			map.put("id", area.getCode());
			map.put("areaName", area.getName());
			list.add(map);
		}
		String temp = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据父id查找服务子类
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@RequestMapping("/load_group_class.htm")
	public void loadGroupClass(HttpServletRequest request, HttpServletResponse response, String pid) {

		List<GroupClassBO> gcs = this.dicContant.getDicsConvertByParentCode(GroupClassBO.class, pid);
		Collections.sort(gcs);

		List<Map> list = new ArrayList<Map>();
		for (DicBase area : gcs) {
			Map map = new HashMap();
			map.put("id", area.getCode());
			map.put("gcName", area.getName());
			list.add(map);
		}
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

	@RequestMapping("/load_store_map.htm")
	public ModelAndView loadStoreMap(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("storeId") Long storeId) {
		ModelAndView mv = new JModelAndView("o2o/store_map.html", configService.getSysConfig(), 1, request,
				response);
		Store store = sotreService.getObjById(storeId);
		mv.addObject("store", store);
		return mv;
	}

	/**
	 * 根据活动id获取该活动下面的商品数据
	 * goodsType 商品类型  0我们数据的商品 1 卷皮商品
	 * @param request
	 * @param response
	 * @param pid
	 */
	@RequestMapping("/load_act_goods.htm")
	public void load_act_goods(HttpServletRequest request, HttpServletResponse response, Long actId) {
		Map<String, Object> maps = new HashMap<>();
		ActivitySaleMessageBO activitySaleMessageBO = saleActivityMessageService.getSaleMessageByActId(actId);
		if (activitySaleMessageBO == null) {
			try {
				throw new ServiceException("活动未开启");
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		String goods_ids = activitySaleMessageBO.getGoodsId();
		List<Map<String, Object>> list = new ArrayList<>();
		if (goods_ids != null && !goods_ids.equals("")) {
			String ids[] = goods_ids.split(",");
			for (String gid : ids) {
				if (!gid.equals("")) {
					Map<String, Object> map = new HashMap<String, Object>();
					
					if (gid.contains("jp_")) {
						String[] thisId = gid.split("_");
						JuanpiGoodsBO juanpiGoodsBO = this.juanpiGoodsService.findOne(CommUtil.null2Long(thisId[1]));
						if (juanpiGoodsBO != null) {
							map.put("goodsId", juanpiGoodsBO.getId());
							map.put("goodsName", juanpiGoodsBO.getGoodsTitle());
							map.put("goodsMainPhotoPath", juanpiGoodsBO.getImageUrl());//图片
							map.put("goodsShowPrice", juanpiGoodsBO.getGoodsCprice());//显示价格
							map.put("goodsInventory", 999);//库存
							map.put("goodsPrice", juanpiGoodsBO.getGoodsPrice());//划掉的价格
							map.put("targetUrlM", juanpiGoodsBO.getTargetUrlM());
							if (juanpiGoodsBO.getIsTuangou() == 1) {
								map.put("tuanCprice", juanpiGoodsBO.getTuanCprice());//团购价
							}
							map.put("goodsType", 1);
							list.add(map);
						}
					} else {
						GoodsBO goods = this.goodsService.getObjById(CommUtil.null2Long(gid));
						map.put("goodsId", goods.getId());
						map.put("goodsName", goods.getGoodsName());
						map.put("goodsMainPhotoPath", goods.getGoodsMainPhotoPath());//图片
						map.put("goodsShowPrice", goods.getGoodsShowPrice());//显示价格
						map.put("goodsInventory", goods.getGoodsInventory());//库存
						map.put("goodsPrice", goods.getGoodsPrice());//划掉的价格
						map.put("goodsType",0);
						map.put("targetUrlM", "");
						map.put("tuanCprice", "0");
						list.add(map);
					}
					
			
				}
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			maps.put("result", "success");
			maps.put("goods", list);
			String temp = Json.toJson(maps, JsonFormat.compact());
//			String test = JSON.toJSONString(list);
			writer = response.getWriter();
			writer.print(temp);
//			writer.print(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			maps.put("result", "failure");
			e.printStackTrace();
		}
	}
//	@RequestMapping("/load_group_area.htm")
//	public void load_group_area(HttpServletRequest request,
//			HttpServletResponse response, String pid) {
//		Map params = new HashMap();
//		params.put("pid", CommUtil.null2Long(pid));
//		List<GroupArea> areas = this.groupAreaService.query(
//				"select obj from GroupArea obj where obj.parent.id=:pid", params,
//				-1, -1);
//		List<Map> list = new ArrayList<Map>();
//		for (GroupArea area : areas) {
//			Map map = new HashMap();
//			map.put("id", area.getId());
//			map.put("areaName", area.getGa_name());
//			list.add(map);
//		}
//		String temp = Json.toJson(list, JsonFormat.compact());
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(temp);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
