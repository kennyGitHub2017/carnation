package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.dao.GoodsClassDao;
import com.sinco.carnation.goods.dao.GoodsTypePropertyDao;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.vo.GoodsClassCountVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicUtils;
import com.sinco.dic.client.model.DicBase;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional
public class GoodsClassService {
	@Autowired
	private GoodsClassDao goodsClassDao;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private GoodsTypePropertyDao goodsTypePropertyDao;

	@Autowired
	private DicContent dicContent;
	
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsService goodsService;

	public List<GoodsClassBO> findRelatedGoodsClass(Integer level, String className) {
		return goodsClassDao.findRelatedGoodsClass(level, className);
	}

	/**
	 * 商品一级分类列表
	 * 
	 * @return
	 */
	public List<GoodsClassBO> rootGoodsClassList() {
		return dicContent.getRootDics(GoodsClassBO.class);
	}

	/**
	 * 根据父id得到子集对象列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<DicBase> childGoodsClassList(String parentId) {
		return dicContent.getDicsByParentCode(GoodsClassBO.class, parentId);
	}

	/**
	 * 取缓存中数据，目前缓存放在数据字典中
	 * 
	 * @param ids
	 * @return
	 */
	public Collection<GoodsClassBO> findByCache(Long... ids) {
		String[] codes = new String[ids.length];
		for (int i = 0; i < codes.length; i++) {
			codes[i] = String.valueOf(ids[i]);
		}
		return dicContent.getDicsConvert(GoodsClassBO.class, codes);
	}

	/**
	 * 取缓存中数据，目前缓存放在数据字典中
	 * 
	 * @param ids
	 * @return
	 */
	public GoodsClassBO findByCache(Long id) {
		return (GoodsClassBO) dicContent.getDic(GoodsClassBO.class, String.valueOf(id));
	}

	/**
	 * 刷新数据字典缓存
	 */
	public void refreshDicCache() {
		dicContent.refreshDicCache(GoodsClassBO.class);
	}

	/**
	 * 按级别整理好的对象,从缓存中得到
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findLevelAll() {
		return goodsClassDao.findLevelAll(null);
	}

	/**
	 * 按级别整理好的对象,从缓存中得到
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findLevelAll(Boolean display) {
		return goodsClassDao.findLevelAll(display);
	}

	/**
	 * 判断名称是否存在
	 * 
	 * @param name
	 * @param id
	 * @param parentId
	 * @return
	 */
	public int countByName(String name, Long id, Long parentId) {
		return goodsClassDao.countByName(name, id, parentId);
	}

	/**
	 * 查找子集
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsClassBO> findByParent(Long parentId) {
		return goodsClassDao.findByParent(parentId);
	}

	/**
	 * 分页查找
	 * 
	 * @param page
	 * @return
	 */
	public List<GoodsClassBO> findParentIsNullPage(@Param("page") Page<GoodsClassBO> page) {
		return goodsClassDao.findParentIsNullPage(page);
	}

	/**
	 * 查找父为空的
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findParnetIsNull() {
		return goodsClassDao.findParnetIsNull();
	}

	/**
	 * 得到所有子对象,递归
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findAllChild(Long... ids) {
		return goodsClassDao.findAllChild(ids);
	}

	/**
	 * 得到所有子的id
	 * 
	 * @return
	 */
	public Set<Long> genericIds(Long id) {
		Collection<DicBase> dicData = dicContent.getDics(GoodsClassBO.class);
		Set<Long> result = new HashSet<Long>();
		result.add(id);
		if (dicData == null) {
			return result;
		}
		Set<String> dicCodes = DicUtils.findAllChildCode(dicData, String.valueOf(id));
		for (String code : dicCodes) {
			result.add(Long.parseLong(code));
		}
		return result;
	}

	public List<GoodsClassBO> findAllParents() {
		return goodsClassDao.findAllParents();
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public boolean save(GoodsClass goodsClass, HttpServletRequest request, boolean childLink,
			boolean commissionLink, boolean guaranteeLink, String gc_adv_url, String adv_type) {

		// 上传图标
		String iconAcc = accessoryService.upload(request, "iconAcc", goodsClass.getIconAccId());
		goodsClass.setIconAccId(iconAcc);

		String mobileIconAcc = accessoryService.upload(request, "mobileIconAcc", goodsClass.getMobileIcon());
		goodsClass.setMobileIcon(mobileIconAcc);

		String clickIconAcc = accessoryService.upload(request, "clickIconAcc", goodsClass.getClickIcon());
		goodsClass.setClickIcon(clickIconAcc);

		String unClickIconAcc = accessoryService.upload(request, "unClickIconAcc", goodsClass.getUnclickIcon());
		goodsClass.setUnclickIcon(unClickIconAcc);

		// 分类广告
		Accessory advAcc = null;
		if (goodsClass.getId() != null) {
			GoodsClass oldGc = goodsClassDao.get(goodsClass.getId());
			Map json_map = (Map) Json.fromJson(oldGc.getGcAdvert());
			String acc_id = CommUtil.null2String(json_map.get("acc_id"));
			advAcc = this.accessoryService.getObjById(CommUtil.null2Long(acc_id));
		}
		advAcc = accessoryService.save(request, "class_icon", "gc_adv", advAcc);
		if (advAcc != null) {
			Map map_temp = new HashMap();
			map_temp.put("acc_id", advAcc.getId());
			map_temp.put("acc_url", gc_adv_url);
			goodsClass.setGcAdvert(Json.toJson(map_temp, JsonFormat.compact()));
		}
		// 设置分类广告类型
		if (goodsClass.getGcAdvert() != null) {
			Map map_temp = (Map) Json.fromJson(goodsClass.getGcAdvert());
			map_temp.put("adv_type", CommUtil.null2Int(adv_type));
			goodsClass.setGcAdvert(Json.toJson(map_temp, JsonFormat.compact()));
		} else {
			Map map_temp = new HashMap();
			map_temp.put("adv_Type", CommUtil.null2Int(adv_type));
			goodsClass.setGcAdvert(Json.toJson(map_temp, JsonFormat.compact()));
		}

		// 如果是修改
		if (goodsClass.getId() != null) {
			// 得到所有子集
			List<GoodsClassBO> childs = findAllChild(goodsClass.getId());

			if (childs.size() > 0) {
				List<Long> childIds = new ArrayList<Long>();
				for (GoodsClassBO gc : childs) {
					childIds.add(gc.getId());
				}

				GoodsClass updateChild = new GoodsClass();
				// 将商品类型关联到下级商品分类
				if (childLink) {
					updateChild.setGoodsTypeId(goodsClass.getGoodsTypeId());
				}
				// 将佣金比例关联到下级商品分类
				if (commissionLink) {
					updateChild.setCommissionRate(goodsClass.getCommissionRate());
				}
				// 将保证金关联到下级商品分类
				if (guaranteeLink) {
					updateChild.setGuarantee(goodsClass.getGuarantee());
				}
				if (childLink || commissionLink || guaranteeLink) {
					this.goodsClassDao.updateByIds(updateChild, childIds);
				}

			}
		}
		this.goodsClassDao.save(goodsClass);

		return true;
	}

	public GoodsClass getObjById(Long id) {
		GoodsClass goodsClass = this.goodsClassDao.get(id);
		return goodsClass;
	}

	public GoodsClassBO getBOById(Long id) {
		GoodsClassBO goodsClass = this.goodsClassDao.getBO(id);

		return goodsClass;
	}

	public GoodsClassBO getBOAndTpyePropertyById(Long id) {
		GoodsClassBO goodsClass = this.goodsClassDao.getBO(id);
		if (goodsClass != null && goodsClass.getGoodsTypeId() != null) {
			goodsClass
					.setGoodsTypeProperty(goodsTypePropertyDao.findByGoodsType(goodsClass.getGoodsTypeId()));
		}
		return goodsClass;
	}

	/**
	 * 删除记录，并删除所有子集，逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long... ids) {
		// 得到所有子集
		List<GoodsClassBO> childs = goodsClassDao.findAllChild(ids);

		List<Long> childIds = new ArrayList<Long>();
		for (GoodsClassBO gc : childs) {
			childIds.add(gc.getId());
		}
		GoodsClass gc = new GoodsClass();
		gc.setDeleteStatus(true);

		// 加上自己
		childIds.addAll(Lists.newArrayList(ids));

		this.goodsClassDao.updateByIds(gc, childIds);

		return true;
	}

	public boolean batchDelete(List<Serializable> goodsClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsClassIds) {
			delete((Long) id);
		}
		return true;
	}

	/**
	 * 修改推荐
	 * 
	 * @param recommend
	 * @param ids
	 * @return
	 */
	public boolean updateRecommend(boolean recommend, List<Long> ids) {
		GoodsClass gc = new GoodsClass();
		gc.setRecommend(recommend);
		this.goodsClassDao.updateByIds(gc, ids);
		return true;
	}

	/**
	 * 修改
	 * 
	 * @param recommend
	 * @param ids
	 * @return
	 */
	public boolean update(GoodsClass gc) {
		this.goodsClassDao.update(gc);
		return true;
	}

	public List<GoodsClassBO> findChildList(Long id) {
		return this.findAllChild(id);
	}

	public GoodsClassBO getBOWithParentById(Long id) {
		GoodsClassBO goodsClass = this.goodsClassDao.getBOWithParent(id);
		return goodsClass;
	}

	public List<GoodsClassBO> findGoodsClassByLevel(Integer level) {
		return this.goodsClassDao.findGoodsClassByLevel(level);
	}
	
	/** 
	 * 根据条件查询
	 * @param vo
	 * @return
	 */
	public List<GoodsClassBO> findByCount(GoodsClassCountVO vo) {
		return this.goodsClassDao.findByCount(vo);
	}
	public List<GoodsClassBO> findByCountVO(GoodsClassCountVO vo) {
		return this.goodsClassDao.findByCountVO(vo);
	}
	
	public String findBnameById(String id){
		return this.goodsClassDao.findBnameById(id);
	}
	
	/**
	 * 商品列表根据分类搜索查询
	 * @param page
	 * @param vo
	 * @param mv
	 */
	public void GoodsClassMv(MyPage<GoodsBO> page,GoodsVO vo, ModelAndView mv){

		Long gcId = vo.getGcId();
		Long fgcId = vo.getFgcId();
		Long sgcId = vo.getSgcId();
		Long tgcId = vo.getTgcId();
		List<GoodsBrand> gbs = this.goodsBrandService.findAll();
		List<GoodsClassBO> gcs = this.findAllParents();
		List<GoodsClassBO> gcs2 = this.findByParent(vo.getFgcId());
		List<GoodsClassBO> gcs3 = this.findByParent(vo.getSgcId());
		if(null != vo.getFgcId()){
			gcs2 = this.findByParent(vo.getFgcId());
		}
		if(null != vo.getSgcId()){
			gcs3 = this.findByParent(vo.getSgcId());
		}
		mv.addObject("gbs", gbs);
		mv.addObject("gcs", gcs);
		mv.addObject("gcs2", gcs2);
		mv.addObject("gcs3", gcs3);		
		
		this.goodsService.list(page, vo);
		vo.setGcId(gcId);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		vo.setFgcId(fgcId);
		vo.setSgcId(sgcId);
		vo.setTgcId(tgcId);
		mv.addObject("vo", vo);
	}
}
