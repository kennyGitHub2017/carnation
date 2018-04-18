package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goods.bo.GoodsLogBO;
import com.sinco.carnation.goods.dao.GoodsLogDao;
import com.sinco.carnation.goods.model.GoodsLog;

@Service
@Transactional
public class GoodsLogService {
	@Autowired
	private GoodsLogDao goodsLogDao;
	@Autowired
	private GoodsService goodsService;

	public List<GoodsLogBO> selectGoodsTop(Long storeId, Date startTime, Date endTime, String orderType,
			Integer offset, Integer start, String columeName) {
		return goodsLogDao.selectGoodsTop(storeId, startTime, endTime, orderType, offset, start, columeName);
	}

	@SuppressWarnings("unchecked")
	public boolean saveClickLog(Long goodsId, String from) {
		GoodsLog todayGoodsLog = this.goodsService.getTodayGoodsLog(goodsId);
		todayGoodsLog.setGoodsClick(todayGoodsLog.getGoodsClick() + 1);
		String click_from_str = todayGoodsLog.getGoodsClickFrom();
		Map<String, Integer> clickmap = (click_from_str != null && !click_from_str.equals("")) ? (Map<String, Integer>) Json
				.fromJson(click_from_str) : new HashMap<String, Integer>();
		if (from != null && !from.equals("")) {
			if (clickmap.containsKey(from)) {
				clickmap.put(from, clickmap.get(from) + 1);
			} else {
				clickmap.put(from, 1);
			}
		} else {
			if (clickmap.containsKey("unknow")) {
				clickmap.put("unknow", clickmap.get("unknow") + 1);
			} else {
				clickmap.put("unknow", 1);
			}
		}
		todayGoodsLog.setGoodsClickFrom(Json.toJson(clickmap, JsonFormat.compact()));
		this.update(todayGoodsLog);
		return true;
	}

	public boolean save(GoodsLog goodsLog) {
		this.goodsLogDao.save(goodsLog);
		return true;
	}

	public GoodsLog getObjById(Long id) {
		GoodsLog goodsLog = this.goodsLogDao.get(id);
		if (goodsLog != null) {
			return goodsLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.goodsLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goodsLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsLogIds) {
			delete((Long) id);
		}
		return true;
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(GoodsLog.class, construct,query,
//				params, this.goodsLogDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
//						.getCurrentPage(), pageObj.getPageSize() == null ? 0
//						: pageObj.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(GoodsLog goodsLog) {
		try {
			this.goodsLogDao.update(goodsLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<GoodsLog> selectByGoodsIdAndTime(Long goodsId, Date beginTime, Date endTime) {
		return this.goodsLogDao.selectByGoodsIdAndTime(goodsId, beginTime, endTime);

	}
}
