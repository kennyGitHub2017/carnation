package com.sinco.carnation.goods.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.dao.GoodsClassDao;
import com.sinco.carnation.goods.dao.GoodsSpecDao;
import com.sinco.carnation.goods.dao.GoodsSpecGcDetailDao;
import com.sinco.carnation.goods.dao.GoodsSpecPropertyDao;
import com.sinco.carnation.goods.dao.GoodsSpecificationDao;
import com.sinco.carnation.goods.model.GoodsSpecGcDetail;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsSpecification;
import com.sinco.carnation.goods.vo.GoodsSpecificationVO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class GoodsSpecificationService {

	@Autowired
	private GoodsSpecificationDao goodsSpecificationDao;

	@Autowired
	private GoodsSpecGcDetailDao goodsSpecGcDetailDao;

	@Autowired
	private GoodsClassDao goodsClassDao;

	@Autowired
	private GoodsSpecPropertyDao goodsSpecPropertyDao;

	@Autowired
	private GoodsSpecGcDetailDao gcDetailDao;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private GoodsSpecDao goodsSpecDao;

	public List<GoodsSpecificationBO> findSpecGCDetail(List<GoodsSpecificationBO> listBO, Long goodsClass) {
		List<GoodsSpecificationBO> listResult = new ArrayList<GoodsSpecificationBO>();
		if (CollectionUtils.isNotEmpty(listBO)) {
			for (GoodsSpecificationBO goodsSpecificationBO : listBO) {
				List<GoodsClassBO> goodsClasss = this.goodsClassDao.findBySpecAndClassId(
						goodsSpecificationBO.getId(), goodsClass);
				if (CollectionUtils.isNotEmpty(goodsClasss)) {
					goodsSpecificationBO.setSpecGoodsClassDetail(goodsClasss);
					listResult.add(goodsSpecificationBO);
				}
			}
		}
		return listResult;
	}

	public List<GoodsSpecificationBO> findSpecProperty(List<GoodsSpecification> listSpec) {
		List<GoodsSpecificationBO> listResult = new ArrayList<GoodsSpecificationBO>();

		if (CollectionUtils.isNotEmpty(listSpec)) {
			List<GoodsSpecProperty> list = goodsSpecPropertyDao.findAll();
			for (GoodsSpecification goodsSpecification : listSpec) {
				List<GoodsSpecPropertyBO> properties = new ArrayList<GoodsSpecPropertyBO>();
				for (GoodsSpecProperty goodsSpecProperty : list) {
					if (goodsSpecification.getId().intValue() == goodsSpecProperty.getSpecId().intValue()) {
						GoodsSpecPropertyBO bo = new GoodsSpecPropertyBO();
						BeanUtils.copyProperties(goodsSpecProperty, bo);
						properties.add(bo);
					}
				}
				GoodsSpecificationBO bo = new GoodsSpecificationBO();
				BeanUtils.copyProperties(goodsSpecification, bo);
				bo.setProperties(properties);
				listResult.add(bo);
			}
		}
		return listResult;
	}

	/**
	 * 
	 * @return
	 */
	public int countByNameAndSpecType(String name, Integer specType, Long id) {
		return goodsSpecificationDao.countByNameAndSpecType(name, specType, id);
	}

	public int countByNameAndStoreId(String name, Long storeId, Long id) {
		return goodsSpecificationDao.countByNameAndStoreId(name, storeId, id);
	}

	/**
	 * 得到bo，会加载相关数据
	 * 
	 * @param id
	 * @return
	 */
	public GoodsSpecificationBO findBOById(Long id) {
		GoodsSpecificationBO bo = this.goodsSpecificationDao.findBOById(id);
		if (bo != null) {
			List<GoodsClassBO> goodsClasss = this.goodsClassDao.findBySpec(id);
			bo.setSpecGoodsClassDetail(goodsClasss);
			List<GoodsSpecPropertyBO> propertys = this.goodsSpecPropertyDao.findBySpec(id);
			bo.setProperties(propertys);

			bo.setGoodsClass(goodsClassDao.getBO(bo.getGoodsClassId()));
		}
		return bo;
	}

	/**
	 * 保存方法
	 * 
	 * @param goodsSpecification
	 * @param gcIds
	 * @param properties
	 * @return
	 */
	public boolean save(GoodsSpecification goodsSpecification, List<Long> gcIds,
			List<GoodsSpecProperty> properties) {

		if (goodsSpecification.getId() == null) {
			goodsSpecification.setAddTime(new Date());
			if (goodsSpecification.getSpecType() == null) {
				goodsSpecification.setSpecType(GoodsConstants.SPEC_TYPE_0);
			}
		} else {
			// 先删除关联分类
			gcDetailDao.deleteBySpecId(goodsSpecification.getId());
		}

		this.goodsSpecificationDao.save(goodsSpecification);

		List<GoodsSpecGcDetail> gcDetails = Lists.newArrayList();
		for (Long gcId : gcIds) {
			GoodsSpecGcDetail gsgd = new GoodsSpecGcDetail();
			gsgd.setSpecGcId(gcId);
			gsgd.setSpecId(goodsSpecification.getId());
			gcDetails.add(gsgd);
		}
		// 保存关联分类
		this.gcDetailDao.save(gcDetails);

		// 保存属性
		for (GoodsSpecProperty gsp : properties) {
			gsp.setSpecId(goodsSpecification.getId());
		}
		goodsSpecPropertyDao.save(properties);

		return true;
	}

	public GoodsSpecification getObjById(Long id) {
		GoodsSpecification goodsSpecification = this.goodsSpecificationDao.get(id);
		if (goodsSpecification != null) {
			return goodsSpecification;
		}
		return null;
	}

	public boolean delete(Long id) throws ServiceException {

		GoodsSpecification gs = this.goodsSpecificationDao.get(id);
		if (gs == null) {
			return false;
		}

		List<GoodsSpecPropertyBO> propertys = this.goodsSpecPropertyDao.findBySpec(id);
		if (propertys.size() > 0) {
			Long[] propIds = new Long[propertys.size()];

			for (int i = 0; i < propertys.size(); i++) {
				propIds[i] = propertys.get(i).getId();
			}

			// 判断是否有商品使用
			if (this.goodsSpecDao.countBySpec(propIds) > 0) {
				throw new ServiceException("[" + gs.getName() + "]规格已有商品再使用，无法删除！");
			}
			// 删除商品与规格关系 (这里处理掉逻辑删除商品的规格数据)
			this.goodsSpecDao.deleteBySpec(propIds);

			// 删除图片
			for (GoodsSpecPropertyBO property : propertys) {
				if (StringUtils.isNotBlank(property.getSpecImageId())) {
					accessoryService.delete(property.getSpecImageId());
				}
			}
		}

		// 删除属性
		this.goodsSpecPropertyDao.deleteBySpec(id);

		// 删除规格
		this.goodsSpecificationDao.remove(id);

		return true;
	}

	public boolean batchDelete(List<Long> goodsSpecificationIds) throws ServiceException {
		// TODO Auto-generated method stub
		for (Long id : goodsSpecificationIds) {
			delete((Long) id);
		}
		return true;
	}

	public void list(MyPage<GoodsSpecificationBO> page, Integer type) {
		this.goodsSpecificationDao.findBOPage(page, type, null);
	}

	public void listByStoreyId(MyPage<GoodsSpecificationBO> page, Long storeId) {
		this.goodsSpecificationDao.findBOPage(page, null, storeId);
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(GoodsSpecification.class,construct, query,
//				params, this.goodsSpecificationDao);
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

	public boolean update(GoodsSpecification goodsSpecification) {
		try {
			this.goodsSpecificationDao.update(goodsSpecification);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<GoodsSpecification> findByType(Integer specType) {
		return this.goodsSpecificationDao.findByType(specType);
	}

	public List<GoodsSpecification> findByStoreId(Long storeId) {
		return this.goodsSpecificationDao.findByStoreId(storeId);
	}

	public List<GoodsSpecification> findByTypeAndClassId(Integer specType, Long goodsClassId) {
		return this.goodsSpecificationDao.findByTypeAndClassId(specType, goodsClassId);
	}

	public List<GoodsSpecification> findByStoreIdAndClassId(Long storeId, Long goodsClassId) {
		return this.goodsSpecificationDao.findByStoreIdAndClassId(storeId, goodsClassId);
	}

	public List<GoodsSpecificationBO> findByVO(MyPage<GoodsSpecificationBO> page, GoodsSpecificationVO vo) {
		return goodsSpecificationDao.findByVO(page, vo);
	}
	
	public GoodsSpecification saveGoodsSpecification(GoodsSpecification record) {
		return this.goodsSpecificationDao.save(record);
	}
	
	/***
	 * 修改规格 shop_goods_specification
	 * @param specId
	 * @throws ServiceException
	 */
	public void updateDeleteStatus(List<Long> specId) throws ServiceException {
		for (Long id : specId) {
			GoodsSpecification goodsSpec = new GoodsSpecification();
			goodsSpec.setId(id);
			goodsSpec.setDeleteStatus(1);
			this.update(goodsSpec);
		}
	}
}
