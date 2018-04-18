package com.sinco.carnation.o2o.service;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.o2o.bo.GroupFloorBO;
import com.sinco.carnation.o2o.dao.GroupFloorContentDao;
import com.sinco.carnation.o2o.dao.GroupFloorDao;
import com.sinco.carnation.o2o.model.GroupFloorContent;
import com.sinco.carnation.o2o.vo.GroupFloorVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dal.common.mapper.JsonMapper;

/**
 * <p>
 * Title: GroupFloorService.java
 * </p>
 * 
 * <p>
 * Description: 团购楼层相关业务实现
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author t2w
 * @date 2015-9-10
 * @version 1.0.1
 */
@Service
@Transactional
public class GroupFloorService {

	@Autowired
	private GroupFloorDao groupFloorDao;

	@Autowired
	private GroupFloorContentDao groupFloorContentDao;

	/**
	 * 得到显示的数据
	 * 
	 * @return
	 */
	public List<GroupFloorBO> findDisplayAll() {
		return groupFloorDao.findDisplayAll();
	}

	/**
	 * 保存团购楼层
	 * 
	 * @param groupCase
	 * @return isSuccess
	 */
	@SuppressWarnings("unchecked")
	public boolean save(GroupFloorVO groupFloorVO) {
		try {
			String caseContent = groupFloorVO.getGroupFloorStores();
			JsonMapper objectMapper = new JsonMapper();
			LinkedHashMap<String, Object> storeMap = objectMapper.fromJson(caseContent, LinkedHashMap.class);
			groupFloorDao.save(groupFloorVO);
			if (storeMap != null) {
				for (String key : storeMap.keySet()) {
					// System.out.println("key= "+ key + " and value= " +
					// map.get(key));
					if (storeMap.get(key) != null) {
						String[] storeIds = ((String) storeMap.get(key)).split(",");
						for (String storeId : storeIds) {
							if (!storeId.equals("")) {
								GroupFloorContent groupFloorContent = new GroupFloorContent();
								groupFloorContent.setFloorId(groupFloorVO.getId());
								groupFloorContent.setStoreId(Long.parseLong(storeId));
								groupFloorContent.setAddTime(new Date(System.currentTimeMillis()));
								groupFloorContent.setCityId(Long.parseLong(key));
								groupFloorContentDao.save(groupFloorContent);
							}
						}
					}
				}
			}
			/**
			 * if (caseContent != null && !caseContent.equals("")) { storeIds = caseContent.split(","); if
			 * (storeIds != null && storeIds.length > 0) { for (String storeId : storeIds) { if
			 * (!storeId.equals("")) { GroupFloorContent groupFloorContent = new GroupFloorContent();
			 * groupFloorContent.setFloorId(groupFloorVO.getId());
			 * groupFloorContent.setStoreId(Long.parseLong(storeId)); groupFloorContent.setAddTime(new
			 * Date(System.currentTimeMillis()));
			 * groupFloorContent.setCityId(groupFloorVO.getGroupFloorStoreCityId ());
			 * groupFloorContentDao.save(groupFloorContent); } } } }
			 **/
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 修改团购楼层
	 * 
	 * @param groupCase
	 * @return isSuccess
	 */
	@SuppressWarnings("unchecked")
	public boolean update(GroupFloorVO groupFloorVO) {
		try {

			groupFloorDao.update(groupFloorVO);
			// groupFloorContentDao.deleteByFloorId(groupFloorVO.getId());
			String caseContent = groupFloorVO.getGroupFloorStores();
			JsonMapper objectMapper = new JsonMapper();
			LinkedHashMap<String, Object> storeMap = objectMapper.fromJson(caseContent, LinkedHashMap.class);
			if (storeMap != null) {
				for (String key : storeMap.keySet()) {
					// System.out.println("key= "+ key + " and value= " +
					// map.get(key));
					groupFloorContentDao.deleteByFloorIdAndCityId(groupFloorVO.getId(), Long.parseLong(key));

					if (storeMap.get(key) != null) {
						String[] storeIds = ((String) storeMap.get(key)).split(",");
						for (String storeId : storeIds) {
							if (!storeId.equals("")) {
								GroupFloorContent groupFloorContent = new GroupFloorContent();
								groupFloorContent.setFloorId(groupFloorVO.getId());
								groupFloorContent.setStoreId(Long.parseLong(storeId));
								groupFloorContent.setAddTime(new Date(System.currentTimeMillis()));
								groupFloorContent.setCityId(Long.parseLong(key));
								groupFloorContentDao.save(groupFloorContent);
							}
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 删除 橱窗
	 * 
	 * @param id
	 * @return isSuccess
	 */
	public boolean delete(Long id) {
		try {
			groupFloorDao.remove(id);
			groupFloorContentDao.deleteByFloorId(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据id查找橱窗
	 * 
	 * @param id
	 * @return groupCase
	 */
	public GroupFloorBO getObjById(Long id) {
		GroupFloorBO groupFloor = this.groupFloorDao.get(id);
		if (groupFloor != null) {
			return groupFloor;
		}
		return null;
	}

	public List<GroupFloorBO> findPageByVO(GroupFloorVO vo, MyPage<GroupFloorVO> page) {
		return this.groupFloorDao.findPageByVO(vo, page);
	}

	public void updateDisplay(Long id, String display) {
		groupFloorDao.updateDisplay(id, display);
	}

	public void updateSequnce(Long id, int seq) {
		groupFloorDao.updateSequnce(id, seq);
	}
}
