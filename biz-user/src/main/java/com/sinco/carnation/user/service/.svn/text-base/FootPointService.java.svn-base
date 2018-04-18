package com.sinco.carnation.user.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.dao.GoodsClassDao;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.user.dao.UserFootPointDao;
import com.sinco.carnation.user.model.UserFootPoint;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class FootPointService {

	@Autowired
	private UserFootPointDao footPointDao;
	@Autowired
	private GoodsClassDao goodsClassDao;

	public boolean save(UserFootPoint footPoint) {
		/**
		 * init other field here
		 */
		try {
			this.footPointDao.save(footPoint);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public UserFootPoint getObjById(Long id) {
		UserFootPoint footPoint = this.footPointDao.get(id);
		if (footPoint != null) {
			return footPoint;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.footPointDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> footPointIds) {
		// TODO Auto-generated method stub
		for (Serializable id : footPointIds) {
			delete((Long) id);
		}
		return true;
	}

	// public IPageList list(IQueryObject properties) {
	// if (properties == null) {
	// return null;
	// }
	// String query = properties.getQuery();
	// String construct = properties.getConstruct();
	// Map params = properties.getParameters();
	// GenericPageList pList = new GenericPageList(UserFootPoint.class,
	// construct,
	// query, params, this.footPointDao);
	// if (properties != null) {
	// PageObject pageObj = properties.getPageObj();
	// if (pageObj != null)
	// pList.doList(
	// pageObj.getCurrentPage() == null ? 0 : pageObj
	// .getCurrentPage(),
	// pageObj.getPageSize() == null ? 0 : pageObj
	// .getPageSize());
	// } else
	// pList.doList(0, -1);
	// return pList;
	// }

	public boolean update(UserFootPoint footPoint) {
		try {
			this.footPointDao.update(footPoint);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public void saveFootPoint(UserBO current_user, GoodsBO obj, String imgPath, String customerNicName) {
		// 登录用户记录浏览足迹信息
		List<UserFootPoint> fps = this.findListByUserId(current_user.getId(),
				CommUtil.formatDate(CommUtil.formatShortDate(new Date())));
		if (fps.size() == 0) {
			UserFootPoint fp = new UserFootPoint();
			fp.setAddtime(new Date());
			fp.setFpDate(new Date());
			fp.setFpUserId(current_user.getId());
			fp.setFpUserName(customerNicName);
			fp.setFpGoodsCount(1);
			Map<String, String> map = new HashMap<String, String>();
			map.put("goods_id", obj.getId().toString());
			map.put("goods_name", obj.getGoodsName());
			map.put("goods_sale", obj.getGoodsSalenum().toString());
			map.put("goods_time", CommUtil.formatLongDate(new Date()));
			map.put("goods_img_path", imgPath);
			map.put("goods_price", obj.getGoodsShowPrice().toString());
			if (null != null && obj.getGcId() != null) {
				map.put("goods_class_id", obj.getGcId().toString());
			}
			GoodsClass gc = goodsClassDao.get(obj.getGcId());
			if (null != gc) {
				map.put("goods_class_name", CommUtil.null2String(gc.getClassName()));
			}
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			list.add(map);
			fp.setFpGoodsContent(Json.toJson(list, JsonFormat.compact()));
			this.save(fp);
		} else {
			UserFootPoint fp = fps.get(0);
			List<Map<String, String>> list = Json.fromJson(List.class, fp.getFpGoodsContent());
			boolean add = true;
			for (Map<String, String> map : list) {// 排除重复的商品足迹
				if (CommUtil.null2Long(map.get("goods_id")).equals(obj.getId())) {
					add = false;
				}
			}
			if (add) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("goods_id", obj.getId().toString());
				map.put("goods_name", obj.getGoodsName());
				map.put("goods_sale", obj.getGoodsSalenum().toString());
				map.put("goods_time", CommUtil.formatLongDate(new Date()));
				map.put("goods_img_path", imgPath);
				map.put("goods_price", CommUtil.null2String(obj.getGoodsCurrentPrice()));
				map.put("goods_class_id", CommUtil.null2String(obj.getGcId()));
				GoodsClass gc = goodsClassDao.get(obj.getGcId());
				if (null != gc) {
					map.put("goods_class_name", CommUtil.null2String(gc.getClassName()));
				}
				list.add(0, map);// 后浏览的总是插入最前面
				fp.setFpGoodsCount(list.size());
				fp.setFpGoodsContent(Json.toJson(list, JsonFormat.compact()));
				this.update(fp);
			}
		}
	}

	public List<UserFootPoint> findListByUserId(Long fpUserId, Date fpDate) {
		return this.footPointDao.findListByUserId(fpUserId, fpDate);
	}

	public void queryByUserId(Long userId, MyPage<UserFootPoint> page) {
		footPointDao.queryByUserId(userId, page);
	}
}
