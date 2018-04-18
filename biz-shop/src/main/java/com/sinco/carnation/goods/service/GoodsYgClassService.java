package com.sinco.carnation.goods.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.vo.GoodsYgClassCountVO;
import com.sinco.carnation.user.dao.UserGoodsClassDao;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicLoadData;
import com.sinco.dic.client.DicUtils;
import com.sinco.dic.client.model.DicBase;
import com.sinco.dic.client.model.DicParentBase;

import edu.emory.mathcs.backport.java.util.Collections;

@Service
@Transactional
public class GoodsYgClassService {
	@Autowired
	private UserGoodsClassDao userGoodsClassDao;
	@Autowired
	private DicContent dicContent;

	@PostConstruct
	public void init() {
		dicContent.setDicCache(GoodsYgClassBO.class, new DicLoadData() {
			@Override
			public List<DicBase> loadDate() {
				List<GoodsYgClassBO> list = findYgNormalAll();
				return Lists.newArrayList(list.toArray(new DicBase[list.size()]));
			}
		}, false);
	}

	/**
	 * 得到正常的数据
	 * 
	 * @return
	 */
	public List<GoodsYgClassBO> findYgNormalAll() {
		GoodsYgClassCountVO vo = new GoodsYgClassCountVO();
		vo.setIsyg(true);
		return userGoodsClassDao.findYgNormalAll(vo);
	}

	/**
	 * 刷新数据字典缓存
	 */
	public void refreshDicCache() {
		dicContent.refreshDicCache(GoodsYgClassBO.class);
	}

	/**
	 * 查找子集
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsYgClassBO> findByParent(Long parentId) {
		return userGoodsClassDao.findByParent(parentId);
	}

	/**
	 * 得到所有子的id
	 * 
	 * @return
	 */
	public Set<Long> genericIds(Long id) {
		Collection<DicBase> dicData = dicContent.getDics(GoodsYgClassBO.class);
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

	public Collection<GoodsYgClassBO> findLevelByCount(GoodsYgClassCountVO vo) {
		Collection<DicBase> dicData = dicContent.getDics(GoodsYgClassBO.class);
		List<GoodsYgClassBO> list = Lists.newArrayList();
		for (DicBase dicBase : dicData) {
			GoodsYgClassBO gc = (GoodsYgClassBO) dicBase;
			System.out.println(gc.getClassname());
			boolean isAdd = true;
			if (vo.getDisplay() != null) {
				if (!vo.getDisplay().equals(gc.getDisplay())) {
					isAdd = false;
				}
			}
			if (isAdd) {
				list.add(gc);
			}
		}
		Collection<GoodsYgClassBO> result = new TreeSet<GoodsYgClassBO>();
		System.out.println(list.size());
		for (GoodsYgClassBO ac : list) {
			if (vo.getCount() != null && vo.getCount() >= 0) {
				if (result.size() >= vo.getCount()) {
					break;
				}
			}
			if (ac.getParentId() == null) {
				ac.setChilds(findChild(list, ac.getId()));
				result.add(ac);
			}
		}
		return result;
	}

	public List<GoodsYgClassBO> findLevelByCountList(GoodsYgClassCountVO vo) {
		Collection<DicBase> dicData = dicContent.getDics(GoodsYgClassBO.class);
		List<GoodsYgClassBO> list = Lists.newArrayList();
		for (DicBase dicBase : dicData) {
			GoodsYgClassBO gc = (GoodsYgClassBO) dicBase;
			System.out.println(gc.getClassname());
			boolean isAdd = true;
			if (vo.getDisplay() != null) {
				if (!vo.getDisplay().equals(gc.getDisplay())) {
					isAdd = false;
				}
			}
			if (isAdd) {
				list.add(gc);
			}
		}
		List<GoodsYgClassBO> result = new ArrayList<GoodsYgClassBO>();
		System.out.println(list.size());
		for (GoodsYgClassBO ac : list) {
			if (vo.getCount() != null && vo.getCount() >= 0) {
				if (result.size() >= vo.getCount()) {
					break;
				}
			}
			if (ac.getParentId() == null) {
				ac.setChilds(findChild(list, ac.getId()));
				result.add(ac);
			}
		}
		return result;
	}

	/**
	 * 得到子对象
	 * 
	 * @return
	 */
	public Collection<GoodsYgClassBO> findChild(List<GoodsYgClassBO> allList, Long id) {
		List<GoodsYgClassBO> list = Lists.newArrayList();
		for (GoodsYgClassBO ac : allList) {
			if (id.equals(ac.getParentId())) {
				list.add(ac);
			}
		}
		Collections.sort(list);
		for (GoodsYgClassBO ac : list) {
			ac.setChilds(findChild(allList, ac.getId()));
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	public String genericGoodsClassInfo(GoodsYgClassBO gc) {
		String goods_class_info = gc.getClassname() + ">";
		if (gc.getParentId() != null) {
			DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsYgClassBO.class,
					String.valueOf(gc.getId()));
			GoodsYgClassBO goodsClassBO = (GoodsYgClassBO) dicContent.getDic(GoodsYgClassBO.class,
					dicClass.getParentCode());
			String class_info = genericGoodsClassInfo(goodsClassBO);
			goods_class_info = class_info + goods_class_info;
		}
		return goods_class_info;
	}

}
