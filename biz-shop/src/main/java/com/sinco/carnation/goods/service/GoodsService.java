package com.sinco.carnation.goods.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsPhotoBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.bo.GoodsTypeBO;
import com.sinco.carnation.goods.bo.GoodsTypePropertyBO;
import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.dao.GoodsCartDao;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.dao.GoodsFormatDao;
import com.sinco.carnation.goods.dao.GoodsLogDao;
import com.sinco.carnation.goods.dao.GoodsPhotoDao;
import com.sinco.carnation.goods.dao.GoodsSpecDao;
import com.sinco.carnation.goods.dao.GoodsSpecPropertyDao;
import com.sinco.carnation.goods.dao.GoodsSpecificationDao;
import com.sinco.carnation.goods.dao.GoodsUgcDao;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.carnation.goods.model.GoodsLog;
import com.sinco.carnation.goods.model.GoodsPhoto;
import com.sinco.carnation.goods.model.GoodsSpec;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsTypeProperty;
import com.sinco.carnation.goods.model.GoodsUgc;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.shop.bo.UserSawGoodsBO;
import com.sinco.carnation.shop.dao.EvaluateDao;
import com.sinco.carnation.shop.dao.UserSawGoodsDao;
import com.sinco.carnation.shop.model.UserSawGoods;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.dao.AccessoryDao;
import com.sinco.carnation.sys.dao.SysKeyWordMapDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.dao.AlbumDao;
import com.sinco.carnation.user.dao.UserCustomerFavoritesDao;
import com.sinco.carnation.user.dao.UserGoodsClassDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserFootPoint;
import com.sinco.carnation.user.service.FootPointService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;
import com.sinco.dic.client.model.DicParentBase;

import edu.emory.mathcs.backport.java.util.Collections;

@Service
@Transactional
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class GoodsService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsPhotoDao goodsPhotoDao;
	@Autowired
	private AccessoryDao accessoryDao;
	@Autowired
	private AlbumDao albumDao;
	@Autowired
	private GoodsSpecDao goodsSpecDao;
	@Autowired
	private GoodsFormatDao goodsFormatDao;
	@Autowired
	private GoodsFormatService goodsFormatService;
	@Autowired
	private GoodsSpecPropertyDao goodsSpecPropertyDao;
	@Autowired
	private GoodsSpecificationDao goodsSpecificationDao;
	@Autowired
	private GoodsCartDao goodsCartDao;
	@Autowired
	private GoodsUgcDao goodsUgcDao;
	@Autowired
	UserCustomerFavoritesDao userCustomerFavoritesDao;
	@Autowired
	private GoodsLogDao goodsLogDao;

	@Autowired
	private EvaluateDao evaluateDao;
	@Autowired
	private ThreadPoolTaskExecutor threadPool;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private UserGoodsClassDao userGoodsClassDao;

	@Autowired
	private GoodsBrandService brandService;

	@Autowired
	private GoodsTypeService goodsTypeService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private GoodsTypePropertyService goodsTypePropertyService;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;
	@Autowired
	private FootPointService footPointService;
	@Autowired
	private SysKeyWordMapDao sysKeyWordMapDao;

	@Autowired
	private GoodsYgClassService goodsYgClassService;
	@Autowired
	private UserSawGoodsDao userSawGoodsDao;

	public List<Long> findAllSellingGoods() {
		return goodsDao.findAllSellingGoods();
	}

	public GoodsClassBO getFullGoodsClassByClassId(String classId) {
		GoodsClassBO gc = dicContent.getTreeDic(GoodsClassBO.class, classId);
		return gc;
	}

	public List<GoodsClassBO> getRelationClassByGcId(GoodsClassBO gc) {
		List<GoodsClassBO> gc_list = new ArrayList<GoodsClassBO>();
		if (gc != null) {
			if (gc.getLevel() == 0) {
				gc_list = goodsClassService.findByParent(gc.getId());
			} else if (gc.getLevel() == 1) {
				gc_list = goodsClassService.findByParent(gc.getParentId());
			} else if (gc.getLevel() == 2) {
				GoodsClassBO dp = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
						String.valueOf(gc.getId()));
				GoodsClassBO dpTow = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class, dp.getParentCode());
				gc_list = goodsClassService.findByParent(Long.parseLong(dpTow.getParentCode()));
			}
		}
		if (CollectionUtils.isNotEmpty(gc_list)) {
			for (GoodsClassBO goodsClassBO : gc_list) {
				List<GoodsClassBO> listDic = dicContent.getDicsConvertByParentCode(GoodsClassBO.class,
						goodsClassBO.getId().toString());
				List<GoodsClassBO> childsList = new ArrayList<GoodsClassBO>();
				if (CollectionUtils.isNotEmpty(listDic)) {
					for (DicBase dicBase : listDic) {
						GoodsClassBO gcTemp = new GoodsClassBO();
						gcTemp = (GoodsClassBO) dicBase;
						childsList.add(gcTemp);
					}
				}
				goodsClassBO.setChilds(childsList);
			}
		}
		return gc_list;
	}

	private List<List<GoodsSpecPropertyBO>> generic_gsp(String gs_ids) {
		List<List<GoodsSpecPropertyBO>> list = new ArrayList<List<GoodsSpecPropertyBO>>();
		String[] gs_id_list = gs_ids.substring(1).split("\\|");
		for (String gd_id_info : gs_id_list) {
			String[] gs_info_list = gd_id_info.split(",");
			List<GoodsSpecPropertyBO> gspList = this.goodsSpecPropertyService
					.selectBOSpecByIds(new String[] {gs_info_list[0]});
			if (CollectionUtils.isNotEmpty(gspList)) {
				GoodsSpecPropertyBO gsp = gspList.get(0);
				boolean create = true;
				for (List<GoodsSpecPropertyBO> gsp_list : list) {
					for (GoodsSpecPropertyBO gsp_temp : gsp_list) {
						if (gsp_temp.getSpec().getId().equals(gsp.getSpec().getId())) {
							gsp_list.add(gsp);
							create = false;
							break;
						}
					}
				}
				if (create) {
					List<GoodsSpecPropertyBO> gsps = new ArrayList<GoodsSpecPropertyBO>();
					gsps.add(gsp);
					list.add(gsps);
				}
			}
		}
		return list;
	}

	public void queryGoodsByClass(GoodsVO vo, GoodsClassBO gc, MyPage<GoodsBO> page) {
		if (vo.getOrderBy() == null || vo.getOrderBy().equals("")) {
			vo.setOrderBy("add_time");
		}
		if (vo.getOrderType() == null || vo.getOrderType().equals("")) {
			vo.setOrderType("desc");
		}

		Set<Long> ids = null;
		if (gc != null) {
			ids = goodsClassService.genericIds(gc.getId());
		}
		vo.setGoodsClassIds(ids);
		if (vo.getGoodsCod() != null) {
			vo.setGoodsCod("0");
		}
		if (StringUtils.isNotBlank(vo.getGoodsTransfee())) {
			vo.setGoodsTransfee("1");
		}
		List<Map<String, String>> goods_property = new ArrayList<Map<String, String>>();
		String brand_ids = vo.getBrandIds();
		if (!CommUtil.null2String(brand_ids).equals("")) {
			if (vo.getBrandIds().indexOf(",") < 0) {
				brand_ids = brand_ids + ",";
			}
			String[] brand_id_list = CommUtil.null2String(brand_ids).split(",");
			Set<Long> brandIdsList = new HashSet<Long>();
			for (int i = 0; i < brand_id_list.length; i++) {
				String brand_id = brand_id_list[i];
				Map<String, String> map = new HashMap<String, String>();
				GoodsBrand brand = this.brandService.getObjById(CommUtil.null2Long(brand_id));
				map.put("name", "品牌");
				map.put("value", brand.getName());
				map.put("type", "brand");
				map.put("id", brand.getId().toString());
				goods_property.add(map);

				brandIdsList.add(CommUtil.null2Long(brand_id));
			}
			if (brand_ids != null && !brand_ids.equals("")) {
				vo.setGoodsBrandIds(brandIdsList);
			}
		}
		String gs_ids = vo.getGsIdsStr();
		if (!CommUtil.null2String(gs_ids).equals("")) {
			List<List<GoodsSpecPropertyBO>> gsp_lists = this.generic_gsp(gs_ids);
			Set<Long> specIdsList = new HashSet<Long>();
			for (int j = 0; j < gsp_lists.size(); j++) {
				List<GoodsSpecPropertyBO> gsp_list = gsp_lists.get(j);
				for (int i = 0; i < gsp_list.size(); i++) {
					GoodsSpecPropertyBO gsp = gsp_list.get(i);
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", gsp.getSpec().getName());
					map.put("value", gsp.getValue());
					map.put("type", "gs");
					map.put("id", gsp.getId().toString());
					goods_property.add(map);
					specIdsList.add(gsp.getId());
				}
			}
			vo.setGoodsSpecIds(specIdsList);
		}

		GoodsTypeBO gtbo = null;
		if (gc.getGoodsTypeId() != null) {
			gtbo = goodsTypeService.getBOById(gc.getGoodsTypeId());
			gc.setGoodsType(gtbo);
		}

		if (!CommUtil.null2String(vo.getProperties()).equals("")) {
			// String[] properties_list =
			// vo.getProperties().substring(1).split("\\|");
			String properties = "";
			if (vo.getProperties().substring(0, 1).equals("|")) {
				properties = vo.getProperties().substring(1);
			} else {
				properties = vo.getProperties();
			}
			String[] properties_list = properties.split("\\|");
			for (int i = 0; i < properties_list.length; i++) {
				String property_info = CommUtil.null2String(properties_list[i]);
				String[] property_info_list = property_info.split(",");
				GoodsTypeProperty gtp = this.goodsTypePropertyService.getObjById(CommUtil
						.null2Long(property_info_list[0]));
				if (gtp != null) {
					if (StringUtils.isNotBlank(gtp.getName()) && StringUtils.isNotBlank(gtp.getValue())) {
						vo.setGtpName(gtp.getName());
						vo.setGtpValue(gtp.getValue());
					}
				}

				Map<String, String> map = new HashMap<String, String>();
				map.put("name", gtp.getName());
				map.put("value", property_info_list[1]);
				map.put("type", "properties");
				map.put("id", gtp.getId().toString());
				goods_property.add(map);
			}

			// 处理筛选类型互斥,|1,超短裙（小于75cm）|2,纯色
			List<GoodsTypePropertyBO> filter_properties = new ArrayList<GoodsTypePropertyBO>();
			List<String> hc_property_list = new ArrayList<String>();// 已经互斥处理过的属性值，在循环中不再处理
			if (gtbo != null) {

				for (GoodsTypePropertyBO gtp : gtbo.getProperties()) {
					boolean flag = true;
					GoodsTypePropertyBO gtp1 = new GoodsTypePropertyBO();
					gtp1.setDisplay(gtp.getDisplay());
					gtp1.setGoodsType(gtbo);
					gtp1.setHcValue(gtp.getHcValue());
					gtp1.setId(gtp.getId());
					gtp1.setName(gtp.getName());
					gtp1.setSequence(gtp.getSequence());
					gtp1.setValue(gtp.getValue());
					for (String hc_property : hc_property_list) {
						String[] hc_list = hc_property.split(":");
						if (hc_list[0].equals(gtp.getName())) {
							String[] hc_temp_list = hc_list[1].split(",");
							String[] defalut_list_value = gtp1.getValue().split(",");
							ArrayList<String> defalut_list = new ArrayList<String>(
									Arrays.asList(defalut_list_value));
							for (String hc_temp : hc_temp_list) {
								defalut_list.remove(hc_temp);
							}
							String value = "";
							for (int i = defalut_list.size() - 1; i >= 0; i--) {
								value = defalut_list.get(i) + "," + value;
							}
							gtp1.setValue(value.substring(0, value.length() - 1));
							flag = false;
							break;
						}

					}
					if (flag) {
						if (!CommUtil.null2String(gtp.getHcValue()).equals("")) {// 取消互斥类型
							// System.out.println(gtp.getHc_value());
							String[] list1 = gtp.getHcValue().split("#");
							for (int i = 0; i < properties_list.length; i++) {
								String property_info = CommUtil.null2String(properties_list[i]);
								String[] property_info_list = property_info.split(",");
								if (property_info_list[1].equals(list1[0])) {// 存在该互斥，则需要进行处理
									hc_property_list.add(list1[1]);
								}
							}

						}
						filter_properties.add(gtp);
					} else {
						filter_properties.add(gtp1);
					}
				}
				vo.setFilterProperties(filter_properties);

			}
		} else {
			// 处理筛选类型互斥
			try {
				vo.setFilterProperties(gtbo.getProperties());
			} catch (Exception e) {
				log.error("FilterProperties is null ,goods id = "+vo.getGoodsId());
			}
		}

		vo.setGoodsProperty(goods_property);

		selectGoodsListByVO(page, vo);
	}

	public List<GoodsBO> queryNearLooks(UserBO current_user, String url) {
		// 查询最近浏览
		List<GoodsBO> nearLooks = new ArrayList<>();
		int count = 0;
		if (current_user != null) {
			List<UserFootPoint> fps = this.footPointService.findListByUserId(current_user.getId(), null);
			userFootPoint: for (UserFootPoint userFootPoint : fps) {
				if (StringUtils.isNotEmpty(userFootPoint.getFpGoodsContent())) {
					List<Map<String, String>> list = Json.fromJson(List.class,
							userFootPoint.getFpGoodsContent());
					if (CollectionUtils.isNotEmpty(list)) {
						for (Map<String, String> map : list) {
							if (count > 2) {
								break userFootPoint;
							}
							GoodsBO bo = new GoodsBO();
							bo.setId(CommUtil.null2Long(map.get("goods_id")));
							bo.setGoodsName(map.get("goods_name"));
							bo.setGoodsMainPhotoPath(StringUtils.isNotEmpty(map.get("goods_img_path")) ? map
									.get("goods_img_path") : url + "/"
									+ this.configService.getSysConfig().getGoodsImage().getPath() + "/"
									+ this.configService.getSysConfig().getGoodsImage().getName());
							bo.setGoodsCurrentPrice(new BigDecimal(map.get("goods_price")));
							nearLooks.add(bo);
							count++;
						}
					}
				}
			}
		}
		return nearLooks;
	}

	public Map<Integer, Integer> findCountByStoreId(Long storeId) {
		Map<Integer, Integer> resultMap = new HashMap<>();
		resultMap.put(1, 0);
		List<Map<String, Integer>> list = goodsDao.findCountByStoreId(storeId);
		if (CollectionUtils.isNotEmpty(list)) {
			for (Map<String, Integer> map : list) {
				if (map.get("goodsStatus").equals(GoodsConstants.GOODS_STATUS_ILLEGAL_DOWN)) {
					resultMap.put(2, CommUtil.null2Int(map.get("count")));
				} else if (map.get("goodsStatus").equals(GoodsConstants.GOODS_STATUS_CHECKING)) {
					resultMap.put(1, resultMap.get(1) + CommUtil.null2Int(map.get("count")));
				} else if (map.get("goodsStatus").equals(GoodsConstants.GOODS_STATUS_STORE)) {
					resultMap.put(1, resultMap.get(1) + CommUtil.null2Int(map.get("count")));
				} else {
					resultMap.put(CommUtil.null2Int(map.get("goodsStatus")),
							CommUtil.null2Int(map.get("count")));
				}
			}
		}
		return resultMap;
	}

	public int findGoodsCountByStoreId(Long storeId) {
		int result = 0;
		List<Map<String, Integer>> list = goodsDao.findCountByStoreId(storeId);
		if (CollectionUtils.isNotEmpty(list)) {
			for (Map<String, Integer> map : list) {
				result += CommUtil.null2Int(map.get("count"));
			}
		}
		return result;
	}

	/**
	 * 得到今天的goods log
	 * 
	 * @param id
	 * @return
	 */
	public GoodsLog getTodayGoodsLog(long id) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date beginDate = cal.getTime();
		now = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date endDate = cal.getTime();
		List<GoodsLog> goodsLogList = this.goodsLogDao.selectByGoodsIdAndTime(id, beginDate, endDate);
		this.goodsLogDao.selectByGoodsIdAndTime(id, beginDate, endDate);
		if (goodsLogList.size() == 0) {
			GoodsBO good = this.goodsDao.findBOByid(id);
			GoodsLog todayGoodsLog = new GoodsLog();
			todayGoodsLog.setAddtime(now);
			todayGoodsLog.setGoodsId(id);
			todayGoodsLog.setGoodsName(good.getGoodsName());
			if (good.getGoodsMainPhotoPath() != null) {
				todayGoodsLog.setImgId(good.getGoodsMainPhotoPath());
			}
			todayGoodsLog.setGcId(good.getGcId());
			if (good.getGoodsBrandId() != null) {
				todayGoodsLog.setGoodsBrandId(good.getGoodsBrandId());
			}
			todayGoodsLog.setPrice(good.getGoodsCurrentPrice());
			Map map = new HashMap();
			todayGoodsLog.setGoodsOrderType(Json.toJson(map, JsonFormat.compact()));
			todayGoodsLog.setGoodsSaleInfo(Json.toJson(map, JsonFormat.compact()));

			if (good.getGoodsType() == 0) {
				todayGoodsLog.setLogForm(0);
			} else {
				todayGoodsLog.setLogForm(1);
				todayGoodsLog.setStoreId(good.getGoodsStoreId());
				todayGoodsLog.setStoreName(good.getGoodsStore().getStoreName());
			}

			// Map preferentialMap = this.query_goods_preferential(id);
			// todayGoodsLog.setPreferential(preferentialMap.get("name").toString());
			// todayGoodsLog.setPreferentialInfo(preferentialMap.get("info").toString());
			this.goodsLogDao.save(todayGoodsLog);
			return todayGoodsLog;
		} else {
			return goodsLogList.get(0);
		}
	}

	/**
	 * 创造商品快照
	 * 
	 * @param servicePath
	 * @param uid
	 * @param goodsId
	 */
	public String createSnapshoot(final Long uid, final Long goodsId) {

		SysConfigBO config = this.configService.getSysConfig();
		final String servicePath = config.getAddress();

		final String genId = uid + UUID.randomUUID().toString() + ".html";

		String uploadFilePath = config.getUploadFilePath();

		final String saveFilePathName = new StringBuilder("/").append(uploadFilePath).append(File.separator)
				.append("snapshoot").append(File.separator).append(genId).toString();

		threadPool.execute(new Runnable() {
			public void run() {
				HttpClient client = new HttpClient();
				HttpMethod method = new GetMethod(servicePath + "/goods_" + String.valueOf(goodsId) + ".htm");
				try {
					client.executeMethod(method);
				} catch (HttpException e2) {
					log.error("商品[" + goodsId + "]快照生成失败：", e2);
				} catch (IOException e2) {
					log.error("商品[" + goodsId + "]快照生成失败：", e2);
				}
				try {
					accessoryService.upload(method.getResponseBodyAsStream(), genId, saveFilePathName);
				} catch (IOException e2) {
					log.error("商品[" + goodsId + "]快照生成失败：", e2);
				} finally {
					method.releaseConnection();
				}
			}
		});
		return accessoryService.getFullUploadPath(saveFilePathName);
	}

	/**
	 * 用于商城列表数据查询
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsBO> findShopListBO(GoodsShowListVO vo) {
		return goodsDao.findShopListBO(vo);
	}

	public GoodsBO findBOByid(Long id) {
		return goodsDao.findBOByid(id);
	}

	public List<UserCustomerFavoritesBO> selectByUserForGoods(long userId) {
		return userCustomerFavoritesDao.selectByUserForGoods(userId);
	}

	public boolean save(GoodsBO goods, Long userId) {
		return save(goods, userId, null);
	}

	public boolean save(GoodsBO goods, Long userId, Store store) {
		Goods obj = null;
		if (goods.getId() == null) {
			goods.setAddTime(new Date());
			if (store != null) {
				StoreGrade grade = storeGradeService.getObjById(store.getGradeId());

				if (null != grade) {
					if (grade.getGoodsAudit() == 0) {// 根据店铺等级判断是否需要平台商审核
						goods.setGoodsStatus(-5);
					} else if (grade.getGoodsAudit() == 1) {
						goods.setGoodsStatus(0);
					}
				} else {
					goods.setGoodsStatus(-5);
				}
				goods.setGoodsStoreId(store.getId());
				goods.setGoodsType(1);
			} else {
				goods.setUserAdminId(userId);
				goods.setGoodsType(0);
			}
		} else {
			obj = this.getObjById(goods.getId());
			goods.setCurrentStatus(CommUtil.null2String(obj.getGoodsStatus()));
			if (store != null) {
				goods.setGoodsStatus(-5);
			}
			BigDecimal old_price = obj.getGoodsCurrentPrice();
			goods.setPriceHistory(old_price);

			if (null != goods.getIsYgb() && goods.getIsYgb().equals(1)) {// 云购币产品
				goods.setGoodsStatus(obj.getGoodsStatus());
			}
		}
		goods.setGoodsCurrentPrice(goods.getStorePrice());
		// 商品名称不可以带有任何html字样，进行过滤
		goods.setGoodsName(Jsoup.clean(goods.getGoodsName(), Whitelist.none()));
		// 商品详情不可以带有违规标签，如script等等
		goods.setGoodsDetails(CommUtil.filterHTML(CommUtil.null2String(goods.getGoodsDetails())));
		// 商品定时发布
		if ("0".equals(goods.getPublishGoodsStatus())) {
			goods.setGoodsSellerTime(new Date());
		}
		if ("2".equals(goods.getPublishGoodsStatus())) {
			String str = goods.getPublishDay() + " " + goods.getPublishHour() + ":" + goods.getPublishMin();
			Date date = CommUtil.formatDate(str, "yyyy-MM-dd HH:mm");
			goods.setGoodsSellerTime(date);
		}
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		String[] properties = goods.getGoodsProperties().split(";");
		for (String property : properties) {
			if (!property.equals("")) {
				String[] list = property.split(",");
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", list[0]);
				map.put("val", list[1]);
				map.put("name", this.goodsTypePropertyService.getObjById(Long.parseLong(list[0])).getName());
				maps.add(map);
			}
		}
		// 如果是商户编辑，需要保留平台加价等设置//TODO
		Map<String, JSONObject> goodsInventoryDetailMap = null;
		if (obj != null) {
			String goodsInventoryDetail = obj.getGoodsInventoryDetail();
			if (StringUtils.isNotBlank(goodsInventoryDetail)) {
				JSONArray jsonArr = JSONArray.fromObject(goodsInventoryDetail);
				if (jsonArr != null && jsonArr.size() > 0) {
					goodsInventoryDetailMap = new HashMap<String, JSONObject>();
					for (int i = 0; i < jsonArr.size(); i++) {
						JSONObject jsonObj = jsonArr.getJSONObject(i);
						String key = jsonObj.getString("id");
						goodsInventoryDetailMap.put(key, jsonObj);
					}
				}
			}
		}

		goods.setGoodsProperty(Json.toJson(maps, JsonFormat.compact()));
		maps.clear();
		String[] inventory_list = goods.getIntentoryDetails().split(";");
		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
			goods.setExPriceFlag(0);
		}
		for (String inventory : inventory_list) {
			if (!inventory.equals("")) {
				String[] list = inventory.split(",");
				if (list.length < 3) {
					continue;
				}
				Map<String, String> map = new HashMap<String, String>();
				Double price = StringUtils.isNotBlank(list[2]) ? Double.parseDouble(list[2]) : 0d;
				// Double addPrice = StringUtils.isNotBlank(list[3]) ? Double.parseDouble(list[3]) : 0d;
				Double needYgb = list.length > 3 && StringUtils.isNotBlank(list[3]) ? Double
						.parseDouble(list[3]) : 0d;
				Double needMoney = list.length > 4 && StringUtils.isNotBlank(list[4]) ? Double
						.parseDouble(list[4]) : 0d;
				Double cnSelfAdd = list.length > 5 && StringUtils.isNotBlank(list[5]) ? Double
						.parseDouble(list[5]) : 0d;
					
				String thisIds=	list[0];
				String resId = this.arraySortId(thisIds);//属性ID排序
				map.put("id", resId);
				map.put("count", list[1]);
				map.put("price", String.valueOf(price));

				if (list.length == 3) {
					// 如果是商户编辑，需要保留平台加价等设置
					if (goodsInventoryDetailMap != null && goodsInventoryDetailMap.get(list[0]) != null) {
						JSONObject oldMap = goodsInventoryDetailMap.get(list[0]);
						map.put("selfAddPrice", oldMap.optString("selfAddPrice", "0"));
						map.put("needYgb", oldMap.optString("needYgb", "0"));
						map.put("needMoney", oldMap.optString("needMoney", "0"));
						map.put("cnSelfAddPrice", oldMap.optString("cnSelfAddPrice", "0"));
						map.put("price", String.valueOf(price + oldMap.optDouble("selfAddPrice", 0)));
					} else {
						map.put("selfAddPrice", "0");
						map.put("needYgb", "0");
						map.put("needMoney", "0");
						map.put("cnSelfAddPrice", "0");
					}
				} else {
					map.put("selfAddPrice", goods.getSelfAddPrice().toString());
					map.put("needYgb", String.valueOf(needYgb));
					map.put("needMoney", String.valueOf(needMoney));
					map.put("cnSelfAddPrice", String.valueOf(cnSelfAdd));
				}

				if (needYgb > 0) {
					map.put("exPriceFlag", "1");
					if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
						goods.setExPriceFlag(1);
					}
				} else {
					map.put("exPriceFlag", "0");
				}
				// 只有自营商品才有这三样
				if (store == null) {
					map.put("mobilePrice", list.length > 6 ? list[6] : "0");
					map.put("integralCount", list.length > 7 ? list[7] : "0");
					map.put("integralPrice", list.length > 8 ? list[8] : "0");
				}
				maps.add(map);
			}
		}
		goods.setGoodsInventoryDetail(Json.toJson(maps, JsonFormat.compact()));

		// 是否为F码商品，是则生成F码
		if (goods.getfSaleType() == 1 && CommUtil.null2Int(goods.getfCodeCount()) > 0) {
			Set<String> set = new HashSet<String>();
			while (true) {
				if (set.size() == CommUtil.null2Int(goods.getfCodeCount())) {
					break;
				}
				set.add((goods.getfCodeProfix() + CommUtil.randomString(12)).toUpperCase());
			}
			List<Map<String, String>> f_code_maps = new ArrayList<Map<String, String>>();
			if (!CommUtil.null2String(goods.getGoodsFCode()).equals("")) {
				f_code_maps = Json.fromJson(List.class, goods.getGoodsFCode());
			}

			for (String code : set) {
				Map<String, String> f_code_map = new HashMap<String, String>();
				f_code_map.put("code", code);
				f_code_map.put("status", "0");// 0表示该F码未使用，1为已经使用
				f_code_maps.add(f_code_map);
			}
			if (f_code_maps.size() > 0) {
				goods.setGoodsFCode(Json.toJson(f_code_maps, JsonFormat.compact()));
			}
		}

		// 添加商品版式
		GoodsFormat gf = this.goodsFormatService.getObjById(goods.getGoodsTopFormatId());
		if (gf != null) {
			goods.setGoodsTopFormatContent(gf.getGfContent());
		} else {
			goods.setGoodsTopFormatContent(null);
		}
		goods.setGoodsBottomFormatId(goods.getGoodsBottomFormatId());
		gf = this.goodsFormatService.getObjById(goods.getGoodsBottomFormatId());
		if (gf != null) {
			goods.setGoodsBottomFormatContent(gf.getGfContent());
		} else {
			goods.setGoodsBottomFormatContent(null);
		}

		if (store != null) {
			// 是否为预售商品，是则加入发货时间
			if (goods.getAdvanceSaleType() == 1) {
				goods.setGoodsStatus(-5);// 预售商品必须经过平台审核
			}
		}

		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝保存goods信息＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		this.goodsDao.save(goods);

		/** 添加关键字 ，先删除,再更新 LKN **/
		/*		this.sysKeyWordMapDao.deleteByTypeIdAdTypeCode(goods.getId(), 
						CommUtil.null2Long(EmSysKeyWordMapType.GoodsType.getValue()));
				String[] arrayStr = goods.getKeyWordIdStr().split(",");
				SysKeyWordMap skm = new SysKeyWordMap();
				for (String kId : arrayStr) {
					skm.setKeyWordId(CommUtil.null2Long(kId));
					skm.setTypeCode(CommUtil.null2Long(EmSysKeyWordMapType.GoodsType.getValue()));
					skm.setTypeId(goods.getId());
					this.sysKeyWordMapDao.insertKeyWordMap(skm);
				}*/

		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝保存goods信息＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝如果是店铺商品的话就保存goods所在店铺分类＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		if (store != null) {
			// 如果是店铺的话，那么他就需要干自己的分类进去
			String[] ugc_ids = goods.getUserClassIds().split(",");
			for (String ugc_id : ugc_ids) {
				if (!ugc_id.equals("")) {
					goodsUgcDao.deleteByGoodsId(goods.getId());
					GoodsUgc goodsUgc = new GoodsUgc();
					goodsUgc.setClassId(CommUtil.null2Long(ugc_id));
					goodsUgc.setGoodsId(goods.getId());
					goodsUgcDao.save(goodsUgc);
				}
			}
		}
		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝如果是店铺商品的话就保存goods所在店铺分类＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝保存图片信息＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		String[] imgs = goods.getImageIds().split("\\|");
		if (imgs.length > 0) {
			Album album = null;
			List<AlbumBO> albumList = this.albumDao.getDefaultAlbum(userId);
			if (CollectionUtils.isNotEmpty(albumList)) {
				album = albumList.get(0);
			}
			if (album == null) {
				album = new Album();
				album.setAddTime(new Date());
				album.setAlbumName("默认相册");
				album.setAlbumSequence(-10000);
				album.setAlbumDefault(true);
				album.setUserId(userId);
				this.albumDao.save(album);
			}

			goodsPhotoDao.deleteByGoodsId(goods.getId());
			for (int i = 0; i < imgs.length; i++) {
				if (StringUtils.isNotBlank(imgs[i])) {
					List<Accessory> listAcc = accessoryDao.findByPath(imgs[i]);
					Accessory accessory = new Accessory();
					if (CollectionUtils.isNotEmpty(listAcc)) {
						accessory = listAcc.get(0);
					} else {
						accessory.setAlbumId(album.getId());
						accessory.setPath(imgs[i]);
						accessory.setAddTime(new Date());
						accessory.setUserId(userId);
						accessoryDao.save(accessory);
					}
					try {
						GoodsPhoto goodsPhoto = new GoodsPhoto();
						goodsPhoto.setGoodsId(goods.getId());
						goodsPhoto.setPhotoId(accessory.getId());
						goodsPhotoDao.save(goodsPhoto);
					} catch (Exception e) {
						log.info("保存唯一键冲突，不做处理", e.getMessage());
					}
				}
			}
		}
		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝保存图片信息＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝保存商品对应的规格值＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		if (StringUtils.isNotEmpty(goods.getGoodsSpecIds())) {
			String[] spec_ids = goods.getGoodsSpecIds().split(",");
			if (spec_ids.length > 0) {
				Long[] longIds = new Long[spec_ids.length];
				for (int i = 0; i < spec_ids.length; i++) {
					longIds[i] = Long.valueOf(spec_ids[i]);
				}
				goodsSpecDao.deleteByGoodsId(goods.getId());

				for (String specId : spec_ids) {
					GoodsSpec goodsSpec = new GoodsSpec();
					goodsSpec.setSpecId(Long.parseLong(specId));
					goodsSpec.setGoodsId(goods.getId());
					goodsSpecDao.save(goodsSpec);//增加规格shop_goods_spec
					
					GoodsSpecProperty record = new GoodsSpecProperty();
					record.setId(CommUtil.null2Long(specId));
					record.setGoodsId(goods.getId());
					this.goodsSpecPropertyDao.update(record);//修改shop_goods_spec_property
				}
			}
		} else {
			goodsSpecDao.deleteByGoodsId(goods.getId());//清空 shop_goods_spec
			this.goodsSpecPropertyDao.deletePropertyByGoodsId(goods.getId());//删除商品shop_goods_spec_property表
			this.goodsSpecDao.deleteGoodsSpecId(goods.getId());//先删除shop_goods_spec_id表
		}
		
		if (StringUtils.isNotEmpty(goods.getImg_pids())) {
			String[] img_pid = goods.getImg_pids().split(";");
			
			if (img_pid != null && img_pid.length >0 ) {
				
				for (int i = 0; i < img_pid.length; i++) {
					String[] result = {};
					result = img_pid[i].split("\\_");
					GoodsSpecProperty property = new GoodsSpecProperty();
					property.setId(CommUtil.null2Long(result[0]));
					property.setSpecImageId(CommUtil.null2String(result[1]));
					this.goodsSpecPropertyDao.update(property);
				}
				
			}
		}
		
		if (StringUtils.isNotEmpty(goods.getGoodsSpecificationIds())) {//增加规格产品和规格关联关系
			this.goodsSpecDao.deleteGoodsSpecId(goods.getId());//先删除.再增加
			String[] SpecificationId = goods.getGoodsSpecificationIds().split(",");
			for (int i = 0; i < SpecificationId.length; i++) {
				goodsSpecDao.insertGoodsSpecId(goods.getId(), Long.parseLong(SpecificationId[i]));
			}
			
		}
		// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝保存商品对应的规格值＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		
		return true;
	}

	public GoodsBO getObjById(Long id) {
		return this.goodsDao.get(id);
	}

	/**
	 * 查找商品有的规格
	 * 
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSpecificationBO> selectGoodsSpecList(Long goodsId) {
		return goodsSpecificationDao.selectGoodsSpecList(goodsId);
	}

	/**
	 * 查找商品有的规格
	 * 
	 * @param goods
	 * @return
	 */
	public List<GoodsSpecificationBO> selectGoodsSpecList(Goods goods) {
		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
			return goodsSpecificationDao.selectGoodsSpecList(goods.getId());
		}
		return new ArrayList<GoodsSpecificationBO>();
	}

	public GoodsBO getFullGoodsById(Long goodsId) {
		GoodsBO goods = this.goodsDao.findBOByid(goodsId);
		if (goods == null) {
			return null;
		}
		if (goods.getSelfAddPrice() == null) {
			goods.setSelfAddPrice(BigDecimal.ZERO);
		}
		if (goods.getCnSelfAddPrice() == null) {
			goods.setCnSelfAddPrice(BigDecimal.ZERO);
		}
		List<GoodsSpecPropertyBO> listSpecProperty = goodsSpecPropertyDao.selectBOSpecBygoodsId(goodsId);
		goods.setGoodsSpecsList(listSpecProperty);

		List<GoodsPhotoBO> goodsPhotosList = goodsPhotoDao.findBOByGoodsId(goodsId);
		goods.setGoodsPhotosList(goodsPhotosList);

		if (goods.getGoodsStoreId() != null) {
			goods.setGoodsUgcs(userGoodsClassDao.selectByGoodsId(goods.getId()));
		}

		return goods;
	}

	public GoodsBO getGoodsBOById(Long goodsId) {
		GoodsBO goods = this.goodsDao.findBOByid(goodsId);
		return goods;
	}

	/**
	 * 根据商品信息，计算该商品默认的规格信息，以各个规格值的第一个为默认值
	 * 
	 * @param goods
	 *            商品
	 * @return 默认规格id组合，如1,2
	 */
	public String genericDefaultGsp(Goods goods) {
		String gsp = "";
		if (goods != null) {
			List<GoodsSpecificationBO> specs = this.selectGoodsSpecList(goods);
			for (GoodsSpecificationBO spec : specs) {
				// for (GoodsSpecProperty prop : goods.getGoods_specs()) {
				// if (prop.getSpec().getId().equals(spec.getId())) {
				// gsp = prop.getId() + "," + gsp;
				// break;
				// }
				// }
				if (spec.getProperties().size() > 0) {
					gsp = spec.getProperties().get(0).getId() + "," + gsp;
				}
			}
		}
		return gsp;
	}

	/**
	 * 根据商品及传递的规格信息，计算该规格商品的价格、库存量
	 * 
	 * @param goods
	 * @param gsp
	 * @return 价格、库存组成的Map
	 */
	public Map genericDefaultInfo(GoodsBO goods, String gsp, UserCustomer user) {
		double price = 0;
		Map map = new HashMap();
		int count = goods.getGoodsInventory();
		price = CommUtil.null2Double(goods.getStorePrice());
		if ("spec".equals(goods.getInventoryType())) {
			if (gsp != null && !gsp.equals("")) {
				List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
				String[] gsp_ids = gsp.split(",");
				for (Map temp : list) {
					String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
					Arrays.sort(gsp_ids);
					Arrays.sort(temp_ids);
					if (Arrays.equals(gsp_ids, temp_ids)) {
						count = CommUtil.null2Int(temp.get("count"));
						price = CommUtil.null2Double(temp.get("price"));
					}
				}
			}
		}
		// if (goods.getGroup() != null && goods.getGroup_buy() == 2) {//
		// 团购商品统一按照团购价格处理
		// for (GroupGoods gg : goods.getGroup_goods_list()) {
		// if (gg.getGroup().getId().equals(goods.getGroup().getId())) {
		// count = gg.getGg_count();
		// price = CommUtil.null2Double(gg.getGg_price());
		// }
		// }
		// } else {

		// }
		// BigDecimal ac_rebate = null;
		// if (goods.getActivityStatus() == 2
		// && SecurityUserHolder.getCurrentUser() != null) {//
		// 如果是促销商品，并且用户已登录，根据规格配置价格计算相应配置的促销价格
		// ActivityGoods actGoods = this.actgoodsService.getObjById(goods
		// .getActivity_goods_id());
		// // 0—铜牌会员1—银牌会员2—金牌会员3—超级会员
		// BigDecimal rebate = BigDecimal.valueOf(0.00);
		// int level = this.integralViewTools.query_user_level(CommUtil
		// .null2String(SecurityUserHolder.getCurrentUser().getId()));
		// if (level == 0) {
		// rebate = actGoods.getAct().getAc_rebate();
		// } else if (level == 1) {
		// rebate = actGoods.getAct().getAc_rebate1();
		// } else if (level == 2) {
		// rebate = actGoods.getAct().getAc_rebate2();
		// } else if (level == 3) {
		// rebate = actGoods.getAct().getAc_rebate3();
		// }
		// price = CommUtil.mul(rebate, price);
		// }
		map.put("price", price);
		map.put("count", count);
		return map;
	}

	public boolean delete(Long id) {
		try {
			// 删除购物车
			goodsCartDao.deleteByGoods(id);
			Goods goods = new Goods();
			goods.setId(id);
			goods.setDeleteStatus(1);
			this.goodsDao.update(goods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletePhoto(Long photoId) {
		try {
			this.goodsPhotoDao.deleteByPhotoId(photoId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteByPhotoIdAndGoodsId(Long photoId, Long goodsId) {
		try {
			this.goodsPhotoDao.deleteByPhotoIdAndGoodsId(photoId, goodsId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goodsIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsIds) {
			delete((Long) id);
		}
		return true;
	}

	public void list(MyPage<GoodsBO> page, GoodsVO vo) {
		if(null != vo.getTgcId() && vo.getTgcId() > 0){
			vo.setSgcId(null);
			vo.setFgcId(null);
		}else if(null != vo.getSgcId() && vo.getSgcId() > 0){
			vo.setFgcId(null);
		}
		goodsDao.selectBOByVO(vo, page);
	}

	public List<GoodsBO> selectGoodsYourLike(Long gcId, Long goodsId, Integer start, Integer offset,
			Set<Long> goodsIds, Set<Long> gcIds) {
		return goodsDao.selectGoodsYourLike(gcId, goodsId, start, offset, goodsIds, gcIds);
	}

	public List<GoodsBO> searchGoodsYourLike(Long gcId, Long goodsId, Set<Long> goodsIds, Set<Long> gcIds,
			MyPage<GoodsBO> page) {
		return goodsDao.searchGoodsYourLike(gcId, goodsId, goodsIds, gcIds, page);
	}

	public List<GoodsBO> selectSameClassGoodsList(Long gcId, Long goodsId, Integer start, Integer offset) {
		return goodsDao.selectSameClassGoodsList(gcId, goodsId, start, offset);
	}

	public void selectGoodsListByVO(MyPage<GoodsBO> page, GoodsVO vo) {
		if (vo.getIsYgb() != null && 1 == vo.getIsYgb()) {
			goodsDao.selectYgGoodsListByVO(vo, page);
		} else {
			goodsDao.selectGoodsListByVO(vo, page);
		}
		if (CollectionUtils.isNotEmpty(page.getContent())) {
			for (int i = 0; i < page.getContent().size(); i++) {
				page.getContent().get(i)
						.setGoodsPhotosList(goodsPhotoDao.findBOByGoodsId(page.getContent().get(i).getId()));
			}
		}
	}

	// public IPageList list(IQueryObject properties) {
	// if (properties == null) {
	// return null;
	// }
	// String query = properties.getQuery();
	// String construct = properties.getConstruct();
	// Map params = properties.getParameters();
	// GenericPageList pList = new GenericPageList(Goods.class, construct,
	// query, params, this.goodsDao);
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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.SERIALIZABLE,rollbackFor=Exception.class)
	public boolean update(Goods goods) {
		try {

			this.goodsDao.update(goods);
			return true;
		} catch (Exception e) {
		    log.error("[modify goods]error",e);
			throw new RuntimeException("[modify goods]error",e);
		}
	}

	// public List<Goods> query(String query, Map params, int begin, int max) {
	// return this.goodsDao.query(query, params, begin, max);
	//
	// }

	// @Override
	// public Goods getObjByProperty(String construct, String propertyName,
	// Object value) {
	// // TODO Auto-generated method stub
	// return this.goodsDao.getBy(construct, propertyName, value);
	// }

	/**
	 * 根据商品及传递的规格信息，计算该规格商品的价格、库存量
	 * 
	 * @param goods
	 * @param gsp
	 * @return 价格、库存组成的Map
	 */
	public Map generic_default_info(Goods goods, String gsp, UserCustomer user) {
		double price = 0;
		Map map = new HashMap();
		int count = goods.getGoodsInventory();
		price = CommUtil.null2Double(goods.getStorePrice());
		if ("spec".equals(goods.getInventoryType())) {
			if (gsp != null && !gsp.equals("")) {
				List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
				String[] gsp_ids = gsp.split(",");
				for (Map temp : list) {
					String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
					Arrays.sort(gsp_ids);
					Arrays.sort(temp_ids);
					if (Arrays.equals(gsp_ids, temp_ids)) {
						count = CommUtil.null2Int(temp.get("count"));
						price = CommUtil.null2Double(temp.get("price"));
					}
				}
			}
		}
		// if (goods.getGroup() != null && goods.getGroup_buy() == 2) {//
		// 团购商品统一按照团购价格处理
		// for (GroupGoods gg : goods.getGroup_goods_list()) {
		// if (gg.getGroup().getId().equals(goods.getGroup().getId())) {
		// count = gg.getGg_count();
		// price = CommUtil.null2Double(gg.getGg_price());
		// }
		// }
		// } else {

		// }
		// BigDecimal ac_rebate = null;
		// if (goods.getActivityStatus() == 2
		// && SecurityUserHolder.getCurrentUser() != null) {//
		// 如果是促销商品，并且用户已登录，根据规格配置价格计算相应配置的促销价格
		// ActivityGoods actGoods = this.actgoodsService.getObjById(goods
		// .getActivity_goods_id());
		// // 0—铜牌会员1—银牌会员2—金牌会员3—超级会员
		// BigDecimal rebate = BigDecimal.valueOf(0.00);
		// int level = this.integralViewTools.query_user_level(CommUtil
		// .null2String(SecurityUserHolder.getCurrentUser().getId()));
		// if (level == 0) {
		// rebate = actGoods.getAct().getAc_rebate();
		// } else if (level == 1) {
		// rebate = actGoods.getAct().getAc_rebate1();
		// } else if (level == 2) {
		// rebate = actGoods.getAct().getAc_rebate2();
		// } else if (level == 3) {
		// rebate = actGoods.getAct().getAc_rebate3();
		// }
		// price = CommUtil.mul(rebate, price);
		// }
		map.put("price", price);
		map.put("count", count);
		return map;
	}

	public void querygoodsYourLike(Long gcId, Long goodsId, MyPage<GoodsBO> page) {
		page.setContent(goodsDao.querygoodsYourLike(gcId, goodsId, page));
	}

	public String genericGoodsClassInfo(GoodsClass gc) {
		String goods_class_info = ">";
		if(gc != null){
			goods_class_info = gc.getClassName() + goods_class_info;
			if (gc.getParentId() != null) {
				DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
						String.valueOf(gc.getId()));
				if (dicClass != null) {
					GoodsClassBO goodsClassBO = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
							dicClass.getParentCode());
					String class_info = genericGoodsClassInfo(goodsClassBO);
					goods_class_info = class_info + goods_class_info;
				}
			}
		}
		return goods_class_info;
	}

	public List<GoodsBO> findPageByVo(MyPage<GoodsBO> page, GoodsVO vo) {
		return this.goodsDao.findPageByVo(page, vo);
	}

	public void getPageByVo(MyPage<GoodsBO> page, GoodsVO vo) {
		List<GoodsBO> list = this.goodsDao.findPageByVo(page, vo);
		page.setContent(list);
	}

	public void queryFavaGoodsPageList(Integer type, Long uid, MyPage<GoodsBO> page) {
		page.setContent(goodsDao.queryFavaGoodsPageList(uid, type, page));
	}

	public List<GoodsBO> searchGoodsLikeByIds(Long[] goodsIds) {
		return goodsDao.searchGoodsLikeByIds(goodsIds);
	}

	public String getPhotoListByGoodId(Long goodId) {
		StringBuilder builder = new StringBuilder();
		List<GoodsPhoto> photoList = goodsPhotoDao.findByGoodsId(goodId);
		if (photoList != null && photoList.size() > 0) {
			for (GoodsPhoto photo : photoList) {
				Accessory accessory = accessoryDao.findOne(photo.getPhotoId());
				builder.append(accessory.getPath()).append(";");
			}
			return builder.toString().substring(0, builder.toString().length() - 1);
		}
		return null;
	}

	public int findCountWarnGoods(Long storeId) {
		return goodsDao.findCountWarnGoods(storeId);
	}

	public List<GoodsBO> findGoodsByVoAndLimit(GoodsVO vo, Integer start, Integer offset) {
		return this.goodsDao.findGoodsByVoAndLimit(vo, start, offset);
	}

	/**
	 * cb
	 */
	public GoodsYgClassBO getFullGoodsYgClassByClassId(String classId) {
		GoodsYgClassBO gc = dicContent.getTreeDic(GoodsYgClassBO.class, classId);
		return gc;
	}

	public List<GoodsYgClassBO> getRelationYgClassByGcId(GoodsYgClassBO gc) {
		List<GoodsYgClassBO> gc_list = new ArrayList<GoodsYgClassBO>();
		if (gc != null) {
			if (gc.getLevel() == 0) {
				gc_list = goodsYgClassService.findByParent(gc.getId());
			} else if (gc.getLevel() == 1) {
				gc_list = goodsYgClassService.findByParent(gc.getParentId());
			} else if (gc.getLevel() == 2) {
				GoodsYgClassBO dp = (GoodsYgClassBO) dicContent.getDic(GoodsYgClassBO.class,
						String.valueOf(gc.getId()));
				GoodsYgClassBO dpTow = (GoodsYgClassBO) dicContent.getDic(GoodsYgClassBO.class,
						dp.getParentCode());
				gc_list = goodsYgClassService.findByParent(Long.parseLong(dpTow.getParentCode()));
			}
		}
		if (CollectionUtils.isNotEmpty(gc_list)) {
			for (GoodsYgClassBO goodsClassBO : gc_list) {
				List<GoodsYgClassBO> listDic = dicContent.getDicsConvertByParentCode(GoodsYgClassBO.class,
						goodsClassBO.getId().toString());
				List<GoodsYgClassBO> childsList = new ArrayList<GoodsYgClassBO>();
				if (CollectionUtils.isNotEmpty(listDic)) {
					for (DicBase dicBase : listDic) {
						GoodsYgClassBO gcTemp = new GoodsYgClassBO();
						gcTemp = (GoodsYgClassBO) dicBase;
						childsList.add(gcTemp);
					}
				}
				goodsClassBO.setChilds(childsList);
			}
		}
		return gc_list;
	}

	public void queryYgGoodsByClass(GoodsVO vo, GoodsYgClassBO gc, MyPage<GoodsBO> page) {
		if (vo.getOrderBy() == null || vo.getOrderBy().equals("")) {
			vo.setOrderBy("add_time");
		}
		if (vo.getOrderType() == null || vo.getOrderType().equals("")) {
			vo.setOrderType("desc");
		}

		Set<Long> ids = null;
		if (gc != null) {
			ids = goodsYgClassService.genericIds(gc.getId());
		}
		// vo.setGoodsClassIds(ids);
		vo.setUserGoodsClassIds(ids);
		if (vo.getGoodsCod() != null) {
			vo.setGoodsCod("0");
		}
		if (vo.getGoodsTransfee() != null) {
			vo.setGoodsTransfee("1");
		}
		List<Map<String, String>> goods_property = new ArrayList<Map<String, String>>();
		// String brand_ids = vo.getBrandIds();
		/*if (!CommUtil.null2String(brand_ids).equals("")) {
			if (vo.getBrandIds().indexOf(",") < 0) {
				brand_ids = brand_ids + ",";
			}
			String[] brand_id_list = CommUtil.null2String(brand_ids).split(",");
			Set<Long> brandIdsList = new HashSet<Long>();
			for (int i = 0; i < brand_id_list.length; i++) {
				String brand_id = brand_id_list[i];
				Map<String, String> map = new HashMap<String, String>();
				GoodsBrand brand = this.brandService.getObjById(CommUtil.null2Long(brand_id));
				map.put("name", "品牌");
				map.put("value", brand.getName());
				map.put("type", "brand");
				map.put("id", brand.getId().toString());
				goods_property.add(map);

				brandIdsList.add(CommUtil.null2Long(brand_id));
			}
			if (brand_ids != null && !brand_ids.equals("")) {
				vo.setGoodsBrandIds(brandIdsList);
			}
		}*/
		String gs_ids = vo.getGsIdsStr();
		if (!CommUtil.null2String(gs_ids).equals("")) {
			List<List<GoodsSpecPropertyBO>> gsp_lists = this.generic_gsp(gs_ids);
			Set<Long> specIdsList = new HashSet<Long>();
			for (int j = 0; j < gsp_lists.size(); j++) {
				List<GoodsSpecPropertyBO> gsp_list = gsp_lists.get(j);
				for (int i = 0; i < gsp_list.size(); i++) {
					GoodsSpecPropertyBO gsp = gsp_list.get(i);
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", gsp.getSpec().getName());
					map.put("value", gsp.getValue());
					map.put("type", "gs");
					map.put("id", gsp.getId().toString());
					goods_property.add(map);
					specIdsList.add(gsp.getId());
				}
			}
			vo.setGoodsSpecIds(specIdsList);
		}

		// GoodsTypeBO gtbo = null;
		// if (gc.getGoodsTypeId() != null) {
		// gtbo = goodsTypeService.getBOById(gc.getGoodsTypeId());
		// gc.setGoodsType(gtbo);
		// }

		if (!CommUtil.null2String(vo.getProperties()).equals("")) {
			// String[] properties_list =
			// vo.getProperties().substring(1).split("\\|");
			String properties = "";
			if (vo.getProperties().substring(0, 1).equals("|")) {
				properties = vo.getProperties().substring(1);
			} else {
				properties = vo.getProperties();
			}
			String[] properties_list = properties.split("\\|");
			for (int i = 0; i < properties_list.length; i++) {
				String property_info = CommUtil.null2String(properties_list[i]);
				String[] property_info_list = property_info.split(",");
				GoodsTypeProperty gtp = this.goodsTypePropertyService.getObjById(CommUtil
						.null2Long(property_info_list[0]));
				if (gtp != null) {
					if (StringUtils.isNotBlank(gtp.getName()) && StringUtils.isNotBlank(gtp.getValue())) {
						vo.setGtpName(gtp.getName());
						vo.setGtpValue(gtp.getValue());
					}
				}

				Map<String, String> map = new HashMap<String, String>();
				map.put("name", gtp.getName());
				map.put("value", property_info_list[1]);
				map.put("type", "properties");
				map.put("id", gtp.getId().toString());
				goods_property.add(map);
			}

			// 处理筛选类型互斥,|1,超短裙（小于75cm）|2,纯色
			List<GoodsTypePropertyBO> filter_properties = new ArrayList<GoodsTypePropertyBO>();
			List<String> hc_property_list = new ArrayList<String>();// 已经互斥处理过的属性值，在循环中不再处理
			/*if (gtbo != null) {

				for (GoodsTypePropertyBO gtp : gtbo.getProperties()) {
					boolean flag = true;
					GoodsTypePropertyBO gtp1 = new GoodsTypePropertyBO();
					gtp1.setDisplay(gtp.getDisplay());
					gtp1.setGoodsType(gtbo);
					gtp1.setHcValue(gtp.getHcValue());
					gtp1.setId(gtp.getId());
					gtp1.setName(gtp.getName());
					gtp1.setSequence(gtp.getSequence());
					gtp1.setValue(gtp.getValue());
					for (String hc_property : hc_property_list) {
						String[] hc_list = hc_property.split(":");
						if (hc_list[0].equals(gtp.getName())) {
							String[] hc_temp_list = hc_list[1].split(",");
							String[] defalut_list_value = gtp1.getValue().split(",");
							ArrayList<String> defalut_list = new ArrayList<String>(Arrays.asList(defalut_list_value));
							for (String hc_temp : hc_temp_list) {
								defalut_list.remove(hc_temp);
							}
							String value = "";
							for (int i = defalut_list.size() - 1; i >= 0; i--) {
								value = defalut_list.get(i) + "," + value;
							}
							gtp1.setValue(value.substring(0, value.length() - 1));
							flag = false;
							break;
						}

					}
					if (flag) {
						if (!CommUtil.null2String(gtp.getHcValue()).equals("")) {// 取消互斥类型
							// System.out.println(gtp.getHc_value());
							String[] list1 = gtp.getHcValue().split("#");
							for (int i = 0; i < properties_list.length; i++) {
								String property_info = CommUtil.null2String(properties_list[i]);
								String[] property_info_list = property_info.split(",");
								if (property_info_list[1].equals(list1[0])) {// 存在该互斥，则需要进行处理
									hc_property_list.add(list1[1]);
								}
							}

						}
						filter_properties.add(gtp);
					} else {
						filter_properties.add(gtp1);
					}
				}
				vo.setFilterProperties(filter_properties);

			}*/
		} else {
			// 处理筛选类型互斥
			// vo.setFilterProperties(gtbo.getProperties());
		}

		vo.setGoodsProperty(goods_property);

		selectGoodsListByVO(page, vo);

	}

	public List<GoodsBO> getByIds(Set<Long> set) {
		return this.goodsDao.queryByIds(set);
	}

	public void updateGoodStateByID(Goods goods) {
		this.goodsDao.updateGoodStateByID(goods);
	}

	public Map<Long, BigDecimal> getCn_self_add_priceMap(List<GoodsBO> paramList) {
		if (paramList != null && paramList.size() > 0) {
			Map<Long, BigDecimal> resultMap = new HashMap<Long, BigDecimal>();
			for (GoodsBO good : paramList) {
				boolean exPriceFlag = good.getExPriceFlag() != null && good.getExPriceFlag() == 1 ? true
						: false;
				boolean boo = good.getCnSelfAddPrice() != null
						&& good.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1 ? true : false;
				if (exPriceFlag && boo) {
					resultMap.put(good.getId(), good.getCnSelfAddPrice());
				}
			}
			return resultMap;
		}
		return new HashMap<Long, BigDecimal>();
	}

	public Map<Long, BigDecimal> getGoodsPriceMap(List<GoodsBO> paramList) {
		if (paramList != null && paramList.size() > 0) {
			Map<Long, BigDecimal> resultMap = new HashMap<Long, BigDecimal>();
			for (GoodsBO good : paramList) {
				String inventory_type = good.getInventoryType();
				if (inventory_type.equals("spec") && good.getGoodsType() == 1) {
					good.getGoodsShowPrice();
					BigDecimal goodsPriceTemp = good.getGoodsPrice().add(good.getSelfAddPrice());
					good.setGoodsPrice(goodsPriceTemp);
				}
				resultMap.put(good.getId(), good.getGoodsPrice());
			}
			return resultMap;
		}
		return new HashMap<Long, BigDecimal>();
	}

	/**
	 * 处理商品多个规格问题 获取JSON规格字段 根据选择规格重新设置needYgb,needMoney,cnSelfAddPrice
	 * 
	 * @param good
	 * @param cart_gsp
	 * @return
	 */
	public void handleGoods(Goods good, String cart_gsp) {
		if (good != null && cart_gsp != null && cart_gsp.trim().length() > 0) {
			String goodsInventoryDetail = good.getGoodsInventoryDetail();
			cart_gsp = cart_gsp.replaceAll(",", "_");
			cart_gsp = cart_gsp + "_";
			if (goodsInventoryDetail != null && goodsInventoryDetail.trim().length() > 0) {
				JSONArray jsonArr = JSONArray.fromObject(goodsInventoryDetail);
				if (jsonArr.size() > 0) {
					for (int i = 0; i < jsonArr.size(); i++) {
						JSONObject json = jsonArr.getJSONObject(i);
						if (json.containsKey("id")) {
							String id = json.getString("id");
							System.out.println(id);
							if (id.equals(cart_gsp)) {
								BigDecimal needYgb = BigDecimal.ZERO, needMoney = BigDecimal.ZERO, cnSelfAddPrice = BigDecimal.ZERO;
								if (json.containsKey("needYgb") && json.containsKey("needMoney")
										&& json.containsKey("cnSelfAddPrice")) {
									needYgb = new BigDecimal(json.getString("needYgb"));
									needMoney = new BigDecimal(json.getString("needMoney"));
									cnSelfAddPrice = new BigDecimal(json.getString("cnSelfAddPrice"));
								}
								good.setNeedYgb(needYgb);
								good.setNeedMoney(needMoney);
								good.setCnSelfAddPrice(cnSelfAddPrice);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 处理CN商品BV值及在多规格下商品价格的呈现 add by yuleijia on 2017.3.17
	 * 
	 * @param orderBo
	 * @param list
	 */
	public void handleCNGoods(GoodsBO orderBo, List<GoodsBO> list) {
		if (orderBo != null) {
			this.handleGoods(orderBo, false);
		}
		if (list != null && list.size() > 0) {
			for (GoodsBO obj : list) {
				this.handleGoods(obj, false);
			}
		}
	}

	/**
	 * 处理CN商品BV值及多规格下价格展示统一方法 add by yuleijia on 2017.3.17
	 * 
	 * @param goods
	 * @param hasCart
	 *            是否为购物车 true:是 false:否
	 */
	private void handleGoods(GoodsBO goods, Boolean hasCart) {
		if (goods == null) {
			return;
		}
		log.debug("<<<<<<<<<<<< goodsName->" + goods.getGoodsName());
		String inventory_type = goods.getInventoryType();
		// 商品多规格
		if ("spec".equals(inventory_type)) { // && goods.getGoodsType() != null && goods.getGoodsType() == 1
			// 处理商品价格多规格
			goods.getGoodsShowPrice();
			if (goods.getGoodsCurrentPrice() == null) {
				goods.setGoodsCurrentPrice(BigDecimal.ZERO);
			}
			if (goods.getSelfAddPrice() == null) {
				goods.setSelfAddPrice(BigDecimal.ZERO);
			}
			log.debug("<<<<<<<<<<<< GoodsType->" + goods.getGoodsType());
			if (null != goods.getGoodsType() && goods.getGoodsType().equals(1)) {
				BigDecimal goodsPrice = goods.getGoodsPrice().add(goods.getSelfAddPrice());
				goods.setGoodsPrice(goodsPrice);/**/// 商品原价
			}

			if (hasCart != null && !hasCart) {
				/**
				 * 商品多规格：显示云购币+现金
				 */
				String goodsInventoryDetail = goods.getGoodsInventoryDetail();
				Map<String, JSONObject> jsonMap = new HashMap<String, JSONObject>();
				Map<String, Double> priceMap = new HashMap<String, Double>();
				List<Double> priceList = new ArrayList<Double>();
				if (goodsInventoryDetail != null && goodsInventoryDetail.length() > 0) {
					JSONArray jsonArr = JSONArray.fromObject(goodsInventoryDetail);
					int size = jsonArr.size();
					if (size > 0) {
						for (int i = 0; i < size; i++) {
							JSONObject json = jsonArr.getJSONObject(i);
							if (json.containsKey("id")) {
								String id = json.getString("id");
								jsonMap.put(id, json);
								if (json.containsKey("price")) {
									priceMap.put(id, new Double(json.getString("price")));
									priceList.add(new Double(json.getString("price")));
								}
							}

						}
						if (priceList.size() > 0) {
							Collections.sort(priceList);
							Double bigPrice = priceList.get(0);
							Iterator<Map.Entry<String, Double>> entries = priceMap.entrySet().iterator();
							while (entries.hasNext()) {
								Map.Entry<String, Double> entry = entries.next();
								if (entry.getValue().equals(bigPrice)) {
									String key = entry.getKey();
									JSONObject jsonObj = jsonMap.get(key);
									if (jsonObj.containsKey("needYgb")) {
										BigDecimal needYgb = new BigDecimal(jsonObj.getString("needYgb"));
										goods.setNeedYgb(needYgb);
										log.debug(">>>>>>>>>>> needYgb->" + needYgb);
									}
									if (jsonObj.containsKey("needMoney")) {
										BigDecimal needMoney = new BigDecimal(jsonObj.getString("needMoney"));
										goods.setNeedMoney(needMoney);
										log.debug(">>>>>>>>>>> needMoney->" + needMoney);
									}
									break;
								}
							}
						}
					}
				}
			}
		}
		/**
		 * 商品：BV值
		 */
		BigDecimal BV = BigDecimal.ZERO;
		boolean is_cn_self_add_price = goods.getCnSelfAddPrice() != null
				&& goods.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1 ? true : false;
		boolean isFlay = goods.getExPriceFlag() != null && goods.getExPriceFlag() == 1 ? true : false;
		if (is_cn_self_add_price && isFlay) {
			BV = goods.getCnSelfAddPrice();
		}
		goods.setCnSelfAddPrice(BV);
		log.debug(">>>>>>>>>>> BV->" + goods.getCnSelfAddPrice() + " currentPrice->"
				+ goods.getGoodsCurrentPrice() + " goodsPrice->" + goods.getGoodsPrice());
	}

	/**
	 * 统计CN商品BV值 add by yuleijia on 2017.3.17
	 * 
	 * @param GoodsOfCart
	 * @return
	 */
	public BigDecimal countBV(List<GoodsBO> goodsList, Map<Long, Integer> cartGoodsNumMap) {
		BigDecimal result = BigDecimal.ZERO;
		if (goodsList != null && goodsList.size() > 0) {
			for (GoodsBO goods : goodsList) {
				BigDecimal bv = BigDecimal.ZERO;
				Long goodID = goods.getId();
				if (cartGoodsNumMap.containsKey(goodID)) {
					bv = goods.getCnSelfAddPrice().multiply(new BigDecimal(cartGoodsNumMap.get(goodID)));
				}
				result = result.add(bv);
			}
		}
		log.debug("<<<<<<<<<<<<< countBv->" + result);
		return result;
	}

	/**
	 * 购物车商品多规格属性的处理，根据购物车所选定规格初始化商品的BV值
	 * 
	 * @param cart
	 * @param goods
	 */
	public void cartGoodsMulSpecHandler(GoodsCartBO cart, Goods goods) {
		if (cart == null || goods == null || cart.getExPriceFlag() != GoodsCart.EXPEICEFLAG_YES) {
			return;
		}
		String[] gsp_ids = cart.getCartGspsId();
		if (gsp_ids != null && gsp_ids.length > 0) {
			if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
				List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
				for (Map temp : list) {
					String str_ids = CommUtil.null2String(temp.get("id"));
					String[] temp_ids = org.springframework.util.StringUtils.tokenizeToStringArray(str_ids,
							"_");
					Arrays.sort(gsp_ids);
					Arrays.sort(temp_ids);
					if (Arrays.equals(gsp_ids, temp_ids)) {
						goods.setNeedMoney(new BigDecimal(CommUtil.null2Double(temp.get("needMoney"))));
						goods.setNeedYgb(new BigDecimal(CommUtil.null2Double(temp.get("needYgb"))));
						goods.setCnSelfAddPrice(new BigDecimal(CommUtil.null2Double(temp
								.get("cnSelfAddPrice"))));
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 处理商品 云购币+现金 BV值
	 * 
	 * @param good
	 */
	public void handleGoods(Goods good, Map<Long, BigDecimal> bvMap, Map<Long, BigDecimal> needIntegralMap,Map<Long, BigDecimal> cashMap,
			Map<Long, BigDecimal> yunGouBiMap, String cart_gsp) {
		if (good != null && bvMap != null && yunGouBiMap != null && cashMap != null && needIntegralMap != null) {
			Long goodID = good.getId();
			good = this.findBOByid(goodID);

			this.handleGoods(good, cart_gsp);
			System.out.println(good.getNeedMoney() + "  " + good.getNeedYgb() + " "
					+ good.getCnSelfAddPrice());

			BigDecimal cash = good.getNeedMoney();
			BigDecimal yunGouBi = good.getNeedYgb();
			BigDecimal bv = good.getCnSelfAddPrice();
			BigDecimal needIntegral = good.getNeedIntegral();
			Integer flag = good.getExPriceFlag();
			BigDecimal zero = BigDecimal.ZERO;
			System.out.println(" goodsName = " + good.getGoodsName() + " needIntegral=" +needIntegral+ " cash=" + cash + " yunGouBi="
					+ yunGouBi + " bv=" + bv + " flag=" + flag);
			if (bv != null && flag != null && flag == 1 && bv.compareTo(BigDecimal.ZERO) == 1) {
				bvMap.put(goodID, bv);
			}
			if(good.getIsYgb() != null && good.getIsYgb() == 1){
				//如果是云购币专区的商品，BV值取selfAddPrice
				bvMap.put(goodID, good.getSelfAddPrice());
			}
			if (cash != null && cash.compareTo(zero) == 1) {
				cashMap.put(goodID, cash);
			}
			if (yunGouBi != null && yunGouBi.compareTo(zero) == 1) {
				yunGouBiMap.put(goodID, yunGouBi);
			}
			if (needIntegral != null && needIntegral.compareTo(zero) == 1) {
				needIntegralMap.put(goodID, needIntegral);
			}
		}
	}
	
	/** 判断商品支付类型  0 普通 1 重消,2购物积分,3购物积分+重消**/
	public int proType(BigDecimal needIntegral , BigDecimal needYgb , int isYgb){
		int proType = 0;
		if(isYgb==1 && null != needIntegral && null != needYgb){
			if(needIntegral.intValue()>0&&needYgb.intValue()>0){
				proType = 3;
			}else if(needIntegral.intValue()>0){
				proType = 2;
			}else if(needYgb.intValue()>0){
				proType = 1;
			}
		}
		return proType;
	}
	
	/***
	 * 属性ID排序
	 * @param ids
	 * @return
	 */
	public String arraySortId(String ids) {
		StringBuffer specIdStr = new StringBuffer();
		String[] id = null;
		if (StringUtils.isNotBlank(ids)) {
			id = ids.split("_");
			Arrays.sort(id);
			for (int i = id.length - 1; i >= 0; i--) {
				specIdStr.append(id[i]).append("_");
			}
		}
		return specIdStr.toString();
	}
	
	public List<GoodsSpec> selectGoodsSpecIdList (Long goodsId) {
		return this.goodsSpecDao.selectGoodsSpecIdList(goodsId);
	}
	
	/***
	 * 用户行为习惯浏览过的商品
	 * @param userId
	 * @param goodsId
	 * 
	 */
	public void saveUserSawGoods (Long userId,Long goodsId) {
		if (userId == null || goodsId == null) {
			return;
		} else {
			GoodsBO goodsBO = this.goodsDao.get(goodsId);
			if (goodsBO == null || goodsBO.getGcId() == null) {
				return;
			}
			UserSawGoodsBO userSawGoodsBO = this.userSawGoodsDao.getByUid(userId);
			UserSawGoods record = new UserSawGoods();
			try {
				if (userSawGoodsBO != null) {//update
					record.setId(userSawGoodsBO.getId());
					record.setUserId(userId);
					if (userSawGoodsBO.getClass3id().length() > 50) { //就近 保存
						record.setClass3id(CommUtil.null2String(goodsBO.getGcId()));
					} else {
						record.setClass3id(userSawGoodsBO.getClass3id()+","+goodsBO.getGcId());
					}
					
					this.userSawGoodsDao.save(record);
				} else {//insert
					record.setUserId(userId);
					record.setClass3id(CommUtil.null2String(goodsBO.getGcId()));
					UserSawGoods userSawGoods = this.userSawGoodsDao.save(record);
				}
			} catch (Exception e) {
				log.error("saveUserSawGoods{}",e);
			}
		}
	}

}
