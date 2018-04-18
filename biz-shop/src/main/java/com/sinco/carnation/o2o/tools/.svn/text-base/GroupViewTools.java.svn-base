package com.sinco.carnation.o2o.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupCaseBO;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.service.GroupCaseService;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.vo.GroupCaseShowVO;
import com.sinco.carnation.o2o.vo.GroupGoodsListShowVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.store.search.StoreSearchResult;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreSearchVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.dal.common.MyPage;

@Component
public class GroupViewTools {
	@Autowired
	private GroupGoodsService groupGoodsService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private GroupClassService classService;

	@Autowired
	private StoreSearchService searchService;

	@Autowired
	private GroupCaseService groupCaseService;

	@Autowired
	private GroupEvaluationService evaluationService;

	@Autowired
	private StoreService storeService;

	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<GroupGoods> query_goods(String group_id, int count) {
		List<GroupGoods> list = new ArrayList<GroupGoods>();
		Map params = new HashMap();
		params.put("group_id", CommUtil.null2Long(group_id));
//		list = this.groupGoodsService
//				.query(
//						"select obj from GroupGoods obj where obj.group.id=:group_id order by obj.addTime desc",
//						params, 0, count);
		return list;
	}

	@SuppressWarnings({"unused", "unchecked"})
	public List<GroupGoods> findGroupByClassId(Long classId, Area city) {
		Long areaId = null;
		MyPage<StoreDocument> page = new MyPage<>();
		page.setPageSize(24);
		List<GroupClassBO> gcList = null;
		if (classId == null) {
			// 加载全部一级
			gcList = classService.findCacheRoot();
		} else {
			// 加载全部一级
			GroupClassBO selectGc = classService.findTreeCacheById(classId);
			if (selectGc.getParentId() != null) {
				gcList = classService.findCahceByParent(selectGc.getParentId());
			} else {
				gcList = Lists.newArrayList(selectGc.getChilds());
				java.util.Collections.sort(gcList);
			}
		}
		StoreSearchVO vo = new StoreSearchVO();
		vo.setCityId(city.getId());
		vo.setClassId(classId);
		vo.setAreaId(areaId);

		StoreSearchResult result = searchService.search(vo, page);
		List<GroupGoods> grouplist = page.getResult();
		return grouplist;
	}

	/**
	 * 根据楼层和city查橱窗服务
	 * 
	 * @param city
	 * @param count
	 * @return
	 */
	public List<GroupGoodsBO> caseGroup(Area city, int count) {
		/*int caseNum = Integer.valueOf(count);*/
		int caseNum = count - 1;
		// 加载橱窗
		GroupCaseShowVO caseVO = new GroupCaseShowVO();
		caseVO.setCount(4);
		caseVO.setDisplay(true);
		List<GroupCaseBO> caseList = groupCaseService.findShow(caseVO);
		GroupGoodsListShowVO caseGoodsVO = new GroupGoodsListShowVO();
		if (caseList.size() > 0) {
			GroupCaseBO groupCase = caseList.get(caseNum);
			caseGoodsVO.setCaseId(groupCase.getId());
			caseGoodsVO.setCityId(city.getId());
			List<GroupGoodsBO> caseGoodsList = groupGoodsService.findListShow(caseGoodsVO);
			/*mv.addObject("caseGoodsList", caseGoodsList);
			mv.addObject("groupCase",groupCase);*/
			return caseGoodsList;
		}
		return null;
	}

	/**
	 * 通过店铺ID查询店铺评价
	 * 
	 * @param id
	 * @return
	 */
	public GroupEvaluationBO storeScore(Long id) {
		// 店铺的评价总分和总评价人数
		GroupEvaluationBO storeTotal = evaluationService.fetchStoreTotal_(Long.valueOf(id));
		return storeTotal;
	}

	/**
	 * 通过ID查询店铺信息
	 * 
	 * @param id
	 * @return
	 */
	public StoreBO storeInfo(Long id) {
		StoreBO store = storeService.getObjById_(id);
		return store;
	}

	/**
	 * 通过评价查询好评率
	 * 
	 * @param storeTotal
	 * @return
	 */
	public Double storeGoodScore(GroupEvaluationBO storeTotal) {
		// 店铺好评率
		double storeRate = 0;
		if (null != storeTotal && null != storeTotal.getNum() && storeTotal.getNum() > 0) {
			if (storeTotal.getTotalScore() % (long) storeTotal.getNum() == 0) {
				storeRate = (double) (storeTotal.getTotalScore() / (double) storeTotal.getNum());
				return storeRate;
			} else {
				DecimalFormat df = new DecimalFormat("0.0");
				double a = storeTotal.getTotalScore() * 1.0 / (long) storeTotal.getNum();
				double result = Double.parseDouble(df.format(a));
				String res = String.valueOf(result);
				return Double.valueOf(res);
			}

		}
		return storeRate;
	}

	public static Double getRate(Double group_price, Double cost_price) {
		double ret = 0.0;
		if (!CommUtil.null2String(group_price).equals("") && !CommUtil.null2String(cost_price).equals("")) {
			BigDecimal e = new BigDecimal(CommUtil.null2String(group_price));
			BigDecimal f = new BigDecimal(CommUtil.null2String(cost_price));
			if (CommUtil.null2Float(f) > 0)
				ret = e.divide(f, 3, BigDecimal.ROUND_DOWN).doubleValue();
		}
		DecimalFormat df = new DecimalFormat("0.00");
		Double re = CommUtil.mul(Double.valueOf(df.format(ret)), 10);
		return re;
	}
}
