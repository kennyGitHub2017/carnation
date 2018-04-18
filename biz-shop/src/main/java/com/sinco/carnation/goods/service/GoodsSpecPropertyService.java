package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.dao.GoodsSpecDao;
import com.sinco.carnation.goods.dao.GoodsSpecPropertyDao;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class GoodsSpecPropertyService {

	@Autowired
	private GoodsSpecPropertyDao goodsSpecPropertyDao;

	@Autowired
	private GoodsSpecDao goodsSpecDao;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	public List<GoodsSpecPropertyBO> selectBOSpecBygoodsId(Long goodsId) {
		return goodsSpecPropertyDao.selectBOSpecBygoodsId(goodsId);
	}

	public boolean save(GoodsSpecProperty goodsSpecProperty) {
		/**
		 * init other field here
		 */
		try {
			this.goodsSpecPropertyDao.save(goodsSpecProperty);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public GoodsSpecProperty getObjById(Long id) {
		GoodsSpecProperty goodsSpecProperty = this.goodsSpecPropertyDao.get(id);
		if (goodsSpecProperty != null) {
			return goodsSpecProperty;
		}
		return null;
	}

	public List<GoodsSpecPropertyBO> selectBOSpecByIds(String[] ids) {
		return goodsSpecPropertyDao.selectBOSpecByIds(ids);
	}

	public List<GoodsSpecificationBO> getSpecificationByIds(String[] property_ids) {
		List<GoodsSpecPropertyBO> gsps = goodsSpecPropertyDao.selectBOSpecByIds(property_ids);

		Map<Long, GoodsSpecificationBO> specsMap = new HashMap<Long, GoodsSpecificationBO>();
		for (GoodsSpecPropertyBO gsp : gsps) {
			if (!specsMap.containsKey(gsp.getSpecId())) {
				specsMap.put(gsp.getSpecId(), gsp.getSpec());
			}
		}
		List<GoodsSpecificationBO> specs = new ArrayList<GoodsSpecificationBO>();
		Iterator<Long> it = specsMap.keySet().iterator();
		while (it.hasNext()) {
			Long key = it.next();
			specs.add(specsMap.get(key));
		}
		for (GoodsSpecificationBO spec : specs) {
			spec.getProperties().clear();
			for (GoodsSpecPropertyBO gsp : gsps) {
				if (gsp.getSpec().getId().equals(spec.getId())) {
					spec.getProperties().add(gsp);
				}
			}
		}
		return specs;
	}

	/**
	 * 生成库存组合
	 * 
	 * @param specs
	 * @return
	 */
	@SuppressWarnings({"static-access"})
	public List<List<GoodsSpecPropertyBO>> genericSpecProperty(List<GoodsSpecificationBO> specs) {
		List<List<GoodsSpecPropertyBO>> result_list = new ArrayList<List<GoodsSpecPropertyBO>>();
		List<List<GoodsSpecPropertyBO>> list = new ArrayList<List<GoodsSpecPropertyBO>>();
		int max = 1;
		for (GoodsSpecificationBO spec : specs) {
			list.add(spec.getProperties());
		}
		// 将List<List<GoodsSpecProperty>> 转换为二维数组
		GoodsSpecPropertyBO[][] gsps = this.list2group(list);
		for (int i = 0; i < gsps.length; i++) {
			max *= gsps[i].length;
		}
		for (int i = 0; i < max; i++) {
			List<GoodsSpecPropertyBO> temp_list = new ArrayList<GoodsSpecPropertyBO>();
			int temp = 1; // 注意这个temp的用法。
			for (int j = 0; j < gsps.length; j++) {
				temp *= gsps[j].length;
				temp_list.add(j, gsps[j][i / (max / temp) % gsps[j].length]);
			}
			GoodsSpecPropertyBO[] temp_gsps = temp_list.toArray(new GoodsSpecPropertyBO[temp_list.size()]);

			// 增加属性ID,解决多属性价格不显示问题
			/*			Arrays.sort(temp_gsps, new Comparator() {
							public int compare(Object obj1, Object obj2) {
								// TODO Auto-generated method stub
								GoodsSpecPropertyBO a = (GoodsSpecPropertyBO) obj1;
								GoodsSpecPropertyBO b = (GoodsSpecPropertyBO) obj2;
								if (a.getId() == b.getId()) {
									return 0;
							} else {
									return a.getId() > b.getId()? 1 : -1;
								}
							}
					});*/

			result_list.add(Arrays.asList(temp_gsps));
		}
		return result_list;
	}

	/**
	 * arraylist转化为二维数组
	 * 
	 * @param list
	 * @return
	 */
	public static GoodsSpecPropertyBO[][] list2group(List<List<GoodsSpecPropertyBO>> list) {
		GoodsSpecPropertyBO[][] gps = new GoodsSpecPropertyBO[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			gps[i] = list.get(i).toArray(new GoodsSpecPropertyBO[list.get(i).size()]);
		}
		return gps;
	}

	public boolean delete(Long id) throws ServiceException {
		GoodsSpecProperty goodsSpecProperty = this.goodsSpecPropertyDao.get(id);
		if (goodsSpecProperty == null) {
			return false;
		}

		// 删除图片
		if (StringUtils.isNotBlank(goodsSpecProperty.getSpecImageId())) {
			this.accessoryService.delete(goodsSpecProperty.getSpecImageId());
		}

		if (goodsSpecDao.countBySpec(id) > 0) {
			throw new ServiceException("该属性已有商品使用，无法删除");
		}

		this.goodsSpecDao.deleteBySpecId(id);

		this.goodsSpecPropertyDao.remove(id);

		return true;
	}

	public boolean batchDelete(List<Serializable> goodsSpecPropertyIds) throws ServiceException {
		// TODO Auto-generated method stub
		for (Serializable id : goodsSpecPropertyIds) {
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
//		GenericPageList pList = new GenericPageList(GoodsSpecProperty.class,construct, query,
//				params, this.goodsSpecPropertyDao);
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

	public boolean update(GoodsSpecProperty goodsSpecProperty) {
		try {
			this.goodsSpecPropertyDao.update(goodsSpecProperty);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<GoodsSpecProperty> findAll() {
		return goodsSpecPropertyDao.findAll();
	}

	public void removeProperty(Long id) throws ServiceException {
		this.goodsSpecPropertyDao.remove(id);
	}

	public List<GoodsSpecPropertyBO> getGoodsPropertyByStoreId(Long specId, Long storeId) {
		return this.goodsSpecPropertyDao.getGoodsPropertyByStoreId(specId, storeId);
	}

	public int addProperty(GoodsSpecProperty goodsSpecProperty) {
		return this.goodsSpecPropertyDao.insertSelective(goodsSpecProperty);
	}

	@SuppressWarnings("rawtypes")
	public List getPropertyByGoodsIdAndSpec(Long goodsId, Long specId) {
		return this.goodsSpecPropertyDao.getPropertyByGoodsIdAndSpec(goodsId, specId);
	}
	
	/**
	 * 生成库存组合 根据属性ID排序
	 * 
	 * @param specs
	 * @return
	 */
	@SuppressWarnings({"static-access", "unchecked", "rawtypes"})
	public List<List<GoodsSpecPropertyBO>> genericSpecPropertySort(List<GoodsSpecificationBO> specs) {
		List<List<GoodsSpecPropertyBO>> result_list = new ArrayList<List<GoodsSpecPropertyBO>>();
		List<List<GoodsSpecPropertyBO>> list = new ArrayList<List<GoodsSpecPropertyBO>>();
		int max = 1;
		for (GoodsSpecificationBO spec : specs) {
			list.add(spec.getProperties());
		}
		// 将List<List<GoodsSpecProperty>> 转换为二维数组
		GoodsSpecPropertyBO[][] gsps = this.list2group(list);
		for (int i = 0; i < gsps.length; i++) {
			max *= gsps[i].length;
		}
		for (int i = 0; i < max; i++) {
			List<GoodsSpecPropertyBO> temp_list = new ArrayList<GoodsSpecPropertyBO>();
			int temp = 1; // 注意这个temp的用法。
			for (int j = 0; j < gsps.length; j++) {
				temp *= gsps[j].length;
				temp_list.add(j, gsps[j][i / (max / temp) % gsps[j].length]);
			}
			GoodsSpecPropertyBO[] temp_gsps = temp_list.toArray(new GoodsSpecPropertyBO[temp_list.size()]);

			// 增加属性ID,解决多属性价格不显示问题
						Arrays.sort(temp_gsps, new Comparator() {
							public int compare(Object obj1, Object obj2) {
								GoodsSpecPropertyBO a = (GoodsSpecPropertyBO) obj1;
								GoodsSpecPropertyBO b = (GoodsSpecPropertyBO) obj2;
								if (a.getId() == b.getId()) {
									return 0;
							} else {
									return a.getId() > b.getId()? 1 : -1;
								}
							}
					});

			result_list.add(Arrays.asList(temp_gsps));
		}
		return result_list;
	}
}
