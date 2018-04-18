package com.sinco.carnation.shop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.TransAreaBO;
import com.sinco.carnation.shop.dao.TransAreaDao;
import com.sinco.carnation.shop.model.TransArea;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicLoadData;
import com.sinco.dic.client.model.DicBase;

@Service
@Transactional(readOnly = true)
public class TransAreaServiceImpl {

	@Autowired
	private TransAreaDao transAreaDao;

	@Autowired
	private DicContent dicContent;

	@PostConstruct
	public void init() {

		// 设置地区数据字典
		dicContent.setDicCache(TransArea.class, new DicLoadData() {
			@Override
			public List<DicBase> loadDate() {
				List<TransAreaBO> areas = transAreaDao.findAll();
				return Lists.newArrayList(areas.toArray(new DicBase[areas.size()]));
			}
		}, false);
	}

	/* grey added begin */
	/**
	 * 根据父id来查询区域（因为些方法没走数据字典，所以仅用于维护）
	 * 
	 * @param parentId
	 * @return
	 */
	public List<TransAreaBO> findByParentId(Long parentId) {
		return transAreaDao.findByParentId(parentId);
	}

	/**
	 * 查询所有的父区域（因为些方法没走数据字典，所以仅用于维护）
	 * 
	 * @return
	 */
	public List<TransAreaBO> findParentArea() {
		return transAreaDao.findByParentId(null);
	}

	/**
	 * 查询所有快递地区，此方法走数据字典
	 * 
	 * @return
	 */
	public List<TransArea> getAllTransAreas() {
		List<TransArea> listArea = new ArrayList<TransArea>();
		Collection<DicBase> list = dicContent.getDics(TransArea.class);
		if (CollectionUtils.isNotEmpty(list)) {
			for (DicBase dicBase : list) {
				if (StringUtils.isEmpty(((TransArea) dicBase).getParentCode())) {
					TransArea transArea = dicContent.getTreeDic(TransArea.class, dicBase.getCode());
					listArea.add(transArea);
				}
			}
		}
		return listArea;
	}

	/* grey added end */

	public TransArea queryTransAreaById(Long id) {
		return transAreaDao.findOne(id);
	}

	/**
	 * 根据id查询区域
	 * 
	 * @param pid
	 * @param page
	 */
	public void queryTransAreaList(Long pid, MyPage<TransArea> page) {
		page.setContent(transAreaDao.queryTransAreaList(pid, page));
	}

	@SuppressWarnings("unused")
	@Transactional(readOnly = false)
	public void batchSave(String areaId, String pid, String count, HttpServletRequest request) {
		// 批量更新
		if (areaId == null) {
		} else {
			String[] ids = areaId.split(",");
			int i = 1;
			for (String id : ids) {
				String areaName = request.getParameter("areaName_" + i);
				TransArea area = queryTransAreaById(CommUtil.null2Long(request.getParameter("id_" + i)));
				area.setAreaName(areaName);
				String sequence = request.getParameter("sequence_" + i);
				area.setSequence(CommUtil.null2Int(sequence));
				transAreaDao.update(area);
				i++;
			}
		}
		// 批量更新完毕
		// 批量保存
		TransArea parent = null;
		if (StringUtils.isNotBlank(pid))
			parent = queryTransAreaById(Long.parseLong(pid));
		for (int i = 1; i <= CommUtil.null2Int(count); i++) {
			TransArea area = new TransArea();
			area.setAddTime(new Date());
			String areaName = request.getParameter("new_areaName_" + i);
			int sequence = CommUtil.null2Int(request.getParameter("new_sequence_" + i));
			if (parent != null) {
				area.setLevel(parent.getLevel() + 1);
				area.setParentId(parent.getId());
			} else {
				area.setLevel(0);
			}
			area.setAreaName(areaName);
			area.setSequence(sequence);
			transAreaDao.save(area);
		}
		// 批量保存完毕
		// 刷新缓存
		dicContent.refreshDicCache(TransArea.class);
	}

	@Transactional(readOnly = false)
	public void update(TransArea transArea) {
		transAreaDao.update(transArea);
	}

	@Transactional(readOnly = false)
	public void batchDel(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			for (String id : ids) {
				genericIds(queryTransAreaById(CommUtil.null2Long(id)));
			}
		}
		// 刷新缓存
		dicContent.refreshDicCache(TransArea.class);
	}

	private void genericIds(TransArea obj) {

		List<TransAreaBO> list = transAreaDao.findByParentId(obj.getId());
		for (TransAreaBO area : list) {
			genericIds(area);
		}
		transAreaDao.delete(obj.getId());
	}
}
