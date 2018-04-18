package com.sinco.carnation.recommend.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableSortedSet;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.dao.GroupGoodsDao;
import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.bo.AdvertExBO;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.bo.InformationBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.dao.AdvertDao;
import com.sinco.carnation.sns.dao.CircleInvitationDao;
import com.sinco.carnation.sns.dao.InformationDao;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.vo.AdvertVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.dao.AreaDao;
import com.sinco.carnation.sys.model.Area;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class AdvertService {

	@Autowired
	AreaDao areaDao;

	@Autowired
	private AdvertDao advertDao;

	@Autowired
	private CircleInvitationDao circleInvitationDao;

	@Autowired
	private InformationDao informationDao;

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private GroupGoodsDao groupGoodsDao;

	@Autowired
	private Mapper mapper;

	/**
	 * 增加点击数
	 * 
	 * @param id
	 * @return
	 */
	public int increaseClickNum(Long id) {
		return advertDao.increaseClickNum(id);
	}

	/**
	 * 根据推荐位找推荐
	 * 
	 * @param adApId
	 * @param status
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<Advert> findListByAdApId(Long adApId, Integer status, Date beginDate, Date endDate) {
		return advertDao.findListByAdApId(adApId, status, beginDate, endDate);
	}

	public List<AdvertBO> findAdByCode(String sadCode, String timeStamp, Long cityId) {
		
		if (StringUtils.isNotBlank(timeStamp)) {
			int count = advertDao.selectCountByAddTime(sadCode, timeStamp);
			if (count > 0)
				return advertDao.findAdByCode(sadCode, cityId, null);
			else
				return null;
		}
		
		//advertDao.findAdByCode(sadCode, cityId);
		
		List<AdvertBO> resBanner = new ArrayList<AdvertBO>();
		
		if (sadCode.equals("GROUP_HOME_SLIDE") || sadCode.equals("APP_GROUP_INDEX")) {//周边
			
			List<AdvertBO> resCity = advertDao.findAdByCode(sadCode, cityId, "center");// 20170407改动kenny// 查询城市的的广告
			List<AdvertBO> resCom = this.advertDao.findAdByCode(sadCode,CommUtil.null2Long(0), "center"); // 查询平台的广告
	
			if (null != resCity && resCity.size() > 0) {
				if (null != resCom && resCom.size() > 0) {
					
					resCity.addAll(resCom);
				}
				resBanner = resCity;
			} else {
				if (null != resCom && resCom.size() > 0) {
					resBanner = resCom;
				}
			}
			
		} else {
			
			resBanner = advertDao.findAdByCode(sadCode, cityId, null);
		}
/*		if (sadCode.equals("APP_SHOP_INDEX")) {
			List<AdvertBO> indexAdvert = this.advertDao.findAdByCode(sadCode, null, "center"); //健康商城
			if(indexAdvert != null && indexAdvert.size() > 0) {
				resBanner = indexAdvert;
			}
		}*/
		
		return resBanner;
				
	}

	public List<AdvertBO> currCityGroupHomeAdver(Area currCity) {
		List<AdvertBO> list = advertDao.findByApCode("GROUP_HOME_SLIDE"); //
		List<AdvertBO> abs = new ArrayList<>();
		String cityId = currCity.getId().toString();
		/*
		 * group/view_{id}.htm group/store.htm?id=
		 */
		for (AdvertBO bo : list) {
			try {
				if ("5".equals(bo.getAdType())) { // 商户
					Area parent = areaDao.findParentById(bo.getStroeCity().longValue());// [店铺存的是区,父级是市]
					if (parent.getId().toString().equals(cityId)) //
						abs.add(bo);
				} else if ("6".equals(bo.getAdType())) { // 具体的服务
					if (bo.getGoodsCity().toString().equals(cityId))
						abs.add(bo);
				}
			} catch (NullPointerException e) {
				// 如果广告找不到对应的店铺或服务，会抛出此异常
			}
		}

		return abs;
	}

	public boolean save(Advert advert) {
		/**
		 * init other field here
		 */
		try {
			this.advertDao.save(advert);
			this.advertDao.updateAdSlideSequenceAddOne(advert.getId(), advert.getAdApId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Advert getObjById(Long id) {
		Advert advert = this.advertDao.get(id);
		if (advert != null) {
			return advert;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			// Advert advert = advertDao.get(id);
			// if (advert != null && advert.getAdStatus() !=
			// AdvertContant.AD_STATUS_PASS) { // 审核通过的不给删除
			this.advertDao.remove(id);
			return true;
			// } else {
			// return false;
			// }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> advertIds) {
		// TODO Auto-generated method stub
		for (Serializable id : advertIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(Advert advert) {
		try {
			this.advertDao.update(advert);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* grey added begin */
	@Transactional(readOnly = true)
	public MyPage<AdvertBO> findPageByVO(AdvertVO vo, MyPage<AdvertBO> page) {
		List<AdvertBO> list = advertDao.findList(vo, page);
		page.setContent(list);
		return page;
	}

	@Transactional(readOnly = true)
	public AdvertBO getBoById(Long id) {
		return advertDao.getBoById(id);
	}

	@Transactional(readOnly = true)
	public List<Advert> findListByAdApId(Long adApId) {
		return advertDao.findListByAdApId(adApId);
	}

	public void batchUpdate(List<Advert> list) {
		for (Advert advert : list) {
			advertDao.update(advert);
		}
	}

	/* grey added end */

	/**
	 * 新的广告位查询接口 add by david
	 * 
	 * @param sadCode
	 * @param timeStamp
	 * @param cityId
	 * @return
	 */
	public List<AdvertExBO> findAdByCRC(String sadCode, String timeStamp, Long cityId) {
		List<AdvertBO> list = new ArrayList<AdvertBO>();
		List<AdvertExBO> ll = new ArrayList<AdvertExBO>();
		// 综合top 5
		if (StringUtils.isNotBlank(timeStamp)) {
			int count = advertDao.selectCountByAddTime(sadCode, timeStamp);
			if (count > 0) {
				list.addAll(advertDao.findAdByCode(sadCode, null, null));
			}

		} else {
			list.addAll(advertDao.findAdByCode(sadCode, null, null));
		}
		// 综合top 5 和地区top 5 合并
		List<AdvertBO> lis = new ArrayList<AdvertBO>();
		if (null != cityId) {
			for (AdvertBO advertBO : list) {
				if (!(null != advertBO.getAreaId() && !cityId.equals(advertBO.getAreaId()))) {
					lis.add(advertBO);
				}
			}

			List<AdvertBO> li = advertDao.findAdByCode(sadCode, cityId, null);
			if (null != li) {
				lis.addAll(li);
			}
		} else {
			lis = list;
		}
		if (!lis.isEmpty()) {
			// 去除重复的
			lis = ImmutableSortedSet.copyOf(lis).asList();
			// 按照排序字段排序后获取top n条目
			Collections.sort(new ArrayList<AdvertBO>(lis));
			// 按照类型分类
			Map<String, Set<Long>> map = new HashMap<String, Set<Long>>();
			for (AdvertBO advertBO : lis) {
				if (map.containsKey(advertBO.getAdType())) {
					if (isNumer(advertBO.getAdUrl())) {
						map.get(advertBO.getAdType()).add(Long.valueOf(advertBO.getAdUrl()));
					}
				} else {
					if (isNumer(advertBO.getAdUrl())) {
						Set<Long> set = new HashSet<Long>();
						set.add(Long.valueOf(advertBO.getAdUrl()));
						map.put(advertBO.getAdType(), set);
					}
				}
			}

			// 按照类型查询不同的附属信息
			Map<String, JSONObject> m = this.queryJSONAllType(map);
			// 为不同推荐广告组合不同的附属信息

			for (AdvertBO advertBO : lis) {
				AdvertExBO bo = new AdvertExBO();
				mapper.map(advertBO, bo);
				String adType = bo.getAdType();
				if (m.containsKey(bo.getAdType() + "-" + bo.getAdUrl())) {
					JSONObject object = m.get(bo.getAdType() + "-" + bo.getAdUrl());
					if (AdvertContant.ADVERT_TPYE_INFOMATION.equals(adType)) {
						CircleInvitationBO o = JSONObject.toJavaObject(object, CircleInvitationBO.class);
						bo.setCircleInvitationBO(o);
					} else if (AdvertContant.ADVERT_TPYE_GOODS.equals(adType)) {
						GoodsBO o = JSONObject.toJavaObject(object, GoodsBO.class);
						bo.setGoodsBO(o);
					} else if (AdvertContant.ADVERT_TPYE_MERCHANT.equals(adType)) {
						StoreBO o = JSONObject.toJavaObject(object, StoreBO.class);
						bo.setStoreBO(o);
					} else if (AdvertContant.ADVERT_TPYE_JG_PROJECT.equals(adType)) {
						InformationBO o = JSONObject.toJavaObject(object, InformationBO.class);
						bo.setInformationBO(o);
					} else if (AdvertContant.ADVERT_TPYE_GROUP_MERCHANT.equals(adType)) {
						StoreBO o = JSONObject.toJavaObject(object, StoreBO.class);
						bo.setStoreBO(o);
					} else if (AdvertContant.ADVERT_TPYE_SERVE.equals(adType)) {
						GroupGoodsBO o = JSONObject.toJavaObject(object, GroupGoodsBO.class);
						bo.setGroupGoodsBO(o);
					}
				}
				ll.add(bo);
			}
		}
		if (ll.size() > 5) {
			ll = ll.subList(0, 5);
		}

		return ll;
	}

	/**
	 * 循环查询不同类型的广告－需要的附属信息
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, JSONObject> queryJSONAllType(Map<String, Set<Long>> map) {
		Map<String, JSONObject> m = new HashMap<String, JSONObject>();
		for (Map.Entry<String, Set<Long>> entry : map.entrySet()) {
			String adType = entry.getKey();
			Set<Long> set = entry.getValue();
			m.putAll(this.queryJSONByType(adType, set));
		}

		return m;
	}

	/**
	 * 根据类型查询广告的附属信息
	 * 
	 * @param adType
	 * @param set
	 * @return
	 */
	public Map<String, JSONObject> queryJSONByType(String adType, Set<Long> set) {
		Map<String, JSONObject> map = new HashMap<String, JSONObject>();
		if (AdvertContant.ADVERT_TPYE_INFOMATION.equals(adType)) {
			List<CircleInvitationBO> bos = circleInvitationDao.queryByIds(set);
			for (CircleInvitationBO bo : bos) {
				JSONObject object = new JSONObject();
				object.put("id", bo.getId());
				object.put("title", bo.getTitle());
				map.put(adType + "-" + bo.getId(), object);
			}
		} else if (AdvertContant.ADVERT_TPYE_GOODS.equals(adType)) {
			List<GoodsBO> bos = goodsDao.queryByIds(set);
			for (GoodsBO bo : bos) {
				JSONObject object = new JSONObject();
				object.put("id", bo.getId());
				object.put("goodsName", bo.getGoodsName());
				object.put("hasMobilePrice", bo.getHasMobilePrice());
				object.put("goodsMobilePrice", bo.getGoodsMobilePrice());
				object.put("goodsCurrentPrice", bo.getGoodsCurrentPrice());
				object.put("goodsShowPrice", bo.getGoodsShowPrice());
				map.put(adType + "-" + bo.getId(), object);
			}
		} else if (AdvertContant.ADVERT_TPYE_MERCHANT.equals(adType)) {
			List<StoreBO> bos = storeDao.queryByIds(set);
			for (StoreBO bo : bos) {
				JSONObject object = new JSONObject();
				object.put("id", bo.getId());
				object.put("storeName", bo.getStoreName());
				object.put("storeAddress", bo.getStoreAddress());
				object.put("evaluationAverage", bo.getEvaluationAverage());
				object.put("storeLat", bo.getStoreLat());
				object.put("storeLon", bo.getStoreLon());
				map.put(adType + "-" + bo.getId(), object);
			}
		} else if (AdvertContant.ADVERT_TPYE_JG_PROJECT.equals(adType)) {
			List<InformationBO> bos = informationDao.queryByIds(set);
			for (InformationBO bo : bos) {
				JSONObject object = new JSONObject();
				object.put("id", bo.getId());
				object.put("title", bo.getTitle());
				map.put(adType + "-" + bo.getId(), object);
			}
		} else if (AdvertContant.ADVERT_TPYE_GROUP_MERCHANT.equals(adType)) {
			List<StoreBO> bos = storeDao.queryByIds(set);
			for (StoreBO bo : bos) {
				JSONObject object = new JSONObject();
				object.put("id", bo.getId());
				object.put("storeName", bo.getStoreName());
				object.put("storeAddress", bo.getStoreAddress());
				object.put("storeLat", bo.getStoreLat());
				object.put("storeLon", bo.getStoreLon());
				object.put("evaluationAverage", bo.getStoreEvaluationAverage());
				map.put(adType + "-" + bo.getId(), object);
			}
		} else if (AdvertContant.ADVERT_TPYE_SERVE.equals(adType)) {
			List<GroupGoodsBO> bos = groupGoodsDao.queryByIds(set);
			for (GroupGoodsBO bo : bos) {
				JSONObject object = new JSONObject();
				object.put("id", bo.getId());
				object.put("ggName", bo.getGgName());
				object.put("groupPrice", bo.getGroupPrice());
				object.put("storeName", bo.getStoreName());
				object.put("storeAddress", bo.getStoreAddress());
				object.put("storeLat", bo.getStoreLat());
				object.put("storeLon", bo.getStoreLon());
				object.put("evaluationAverage", bo.getStoreEvaluationAverage());
				map.put(adType + "-" + bo.getId(), object);
			}
		}

		return map;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumer(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 查询公司动态
	 * 
	 * @return
	 */
	public List<Advert> findAdForCompanyDynamic() {
		return advertDao.findTopAdByApCode("WEB_COMPANY_DYNAMIC", 4L);
	}

	public List<Advert> findIndexSlide() {
		return advertDao.findTopAdByApCode("WEB_INDEX_SLIDE", 5L);
	}

	public List<Advert> findZSIndexSlide() {
		return advertDao.findTopAdByApCode("ZS_INDEX_SLIDE", 5L);
	}

	public List<Advert> findZSIndexEvent() {
		return advertDao.findTopAdByApCode("ZS_INDEX_EVENT", 1L);
	}

	public List<Advert> findZSIndexVideo() {
		return advertDao.findTopAdByApCode("ZS_INDEX_VIDEO", 1L);
	}

	public List<Advert> findZS_BUSINESSVideo() {
		return advertDao.findTopAdByApCode("ZS_BUSINESS", 5L);
	}

	/**
	 * 根据广告位CODE查询所属广告并限制条数
	 * 
	 * @param code
	 *            广告位CODE
	 * @param count
	 *            显示数目
	 */
	public List<Advert> findTopByCode(String code, Long count) {
		return advertDao.findTopAdByApCode(code, count);
	}
}
