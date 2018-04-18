package vc.thinker.b2b2c.action.glodEgg;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.service.ActGlodEggService;
import com.sinco.carnation.goldEgg.service.GlodEggItemService;
import com.sinco.carnation.goldEgg.service.GlodEggRecordService;
import com.sinco.carnation.goldEgg.vo.GlodEggRecordVO;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.model.ActivityHotSale;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class GlodEggActivityAction {

	@Autowired
	private ActGlodEggService actGlodEggService;
	@Autowired
	private GlodEggItemService glodEggItemService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private SaleActivityService saleActivityService;
	@Autowired
	private GlodEggRecordService glodEggRecordService;

//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/admin/gold_egg_edit.htm")
	public ModelAndView gold_egg_edit_Activity(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/glodEgg_Table.html", configService.getSysConfig(), 0,
				request, response);

		ActivityHotSaleBO activityHotSaleBO = new ActivityHotSaleBO();
		activityHotSaleBO.setVcode("GOLD_EGG");
		activityHotSaleBO.setIsEnabled((byte) 1); // 启用
		activityHotSaleBO.setDeleteStatus((byte) 0); // 未删除
		List<ActivityHotSale> activityHotSaleList = saleActivityService
				.findByActHotSaleGoodsList(activityHotSaleBO);

		if (activityHotSaleList != null && activityHotSaleList.size() > 0) {
			ActivityHotSale activityHotSale = activityHotSaleList.get(0);
			Long activityHotSaleID = activityHotSale.getId();
			List<ActGlodEggBO> actGlodEggList = actGlodEggService.findListByActID(activityHotSaleID);
			if (actGlodEggList != null && actGlodEggList.size() > 0) {
				ActGlodEggBO actGlodEgg = actGlodEggList.get(0);
				long actGlodEggID = actGlodEgg.getId();
				List<GlodEggItemBO> glodEggItemList = this.glodEggItemService.findByGlodEggID(actGlodEggID);
				mv.addObject("actGlodEggBO", actGlodEgg);
				mv.addObject("glodEggItemList", glodEggItemList);
			}
		}
		return mv;
	}

	@RequestMapping("/admin/modify_Gold_Egg.htm")
	public ModelAndView modify_Gold_Egg(HttpServletRequest request, HttpServletResponse response,
			String[] glodEggItemArray, String actGlodEggID, String dayLimitMoney, String priority) {
		Long totalCount_ = 0L;
		Long totalMoney_ = 0L;
		for (String str : glodEggItemArray) {
			JSONObject json = JSONObject.fromObject(str);
			GlodEggItemBO glodEggItem = new GlodEggItemBO();
			glodEggItem.setId(Long.valueOf(json.getString("id")));
			glodEggItem.setTotalCount(Long.valueOf(json.getString("totalCount")));
			glodEggItem.setTotalMoney(new BigDecimal(json.getString("totalMoney")));
			glodEggItem.setModifyTime(new Date());
			totalCount_ += glodEggItem.getTotalCount();
			totalMoney_ += glodEggItem.getTotalMoney().longValue();
			this.glodEggItemService.update(glodEggItem);
		}

		ActGlodEggBO actGlodEgg = new ActGlodEggBO();
		actGlodEgg.setId(Long.parseLong(actGlodEggID));
		actGlodEgg.setTotalCount(totalCount_);
		actGlodEgg.setDayLimitMoney(new BigDecimal(dayLimitMoney));
		actGlodEgg.setTotalMoney(new BigDecimal(totalMoney_).multiply(new BigDecimal(totalCount_)));
		actGlodEgg.setPriority(Integer.valueOf(priority));
		this.actGlodEggService.update(actGlodEgg);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		String webPath = CommUtil.getURL(request);
		mv.addObject("op_title", "编辑成功");
		mv.addObject("list_url", webPath + "/admin/gold_egg_edit.htm");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/admin/glod_egg_record_list.htm")
	public ModelAndView glod_egg_record_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<GlodEggRecordBO> page, GlodEggRecordVO vo, String beginTime,
			String endTime) {
		ModelAndView mv = new JModelAndView("admin/blue/glod_egg_record_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		this.glodEggRecordService.findPageByVO(page, vo);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<GlodEggRecordBO> resultList = page.getResult();
		for (GlodEggRecordBO record : resultList) {
			record.setAddTime(format.format(record.getCreateTime()));
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}
}
