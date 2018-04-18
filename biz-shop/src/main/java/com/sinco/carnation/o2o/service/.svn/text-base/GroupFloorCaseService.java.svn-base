package com.sinco.carnation.o2o.service;

import java.sql.Date;
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

/**
 * <p>
 * Title: GroupCaseService.java
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
public class GroupFloorCaseService {

	@Autowired
	private GroupFloorDao groupFloorDao;

	@Autowired
	private GroupFloorContentDao groupFloorContentDao;

	/**
	 * 保存团购 楼层
	 * 
	 * @param groupFloorVO
	 * @return isSuccess
	 */
	public boolean save(GroupFloorVO groupFloorVO) {
		try {
			String caseContent = groupFloorVO.getCaseContent();
			String[] goodsIds;
			groupFloorDao.save(groupFloorVO);
			if (caseContent != null && !caseContent.equals("")) {
				goodsIds = caseContent.split(",");
				if (goodsIds != null && goodsIds.length > 0) {
					for (String goodsId : goodsIds) {
						if (!goodsId.equals("")) {
							GroupFloorContent groupFloorContent = new GroupFloorContent();
							groupFloorContent.setFloorId(groupFloorVO.getId());
							groupFloorContent.setStoreId(Long.parseLong(goodsId));
							groupFloorContent.setAddTime(new Date(System.currentTimeMillis()));
							groupFloorContent.setCityId(groupFloorVO.getGroupFloorStoreCityId());
							groupFloorContentDao.save(groupFloorContent);
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
	 * 修改团购楼层
	 * 
	 * @param groupFloorVO
	 * @return isSuccess
	 */
	public boolean update(GroupFloorVO groupFloorVO) {
		try {
			String caseContent = groupFloorVO.getCaseContent();
			String[] goodsIds;
			groupFloorDao.update(groupFloorVO);
			groupFloorContentDao.deleteByFloorId(groupFloorVO.getId());
			if (caseContent != null && !caseContent.equals("")) {
				goodsIds = caseContent.split(",");
				if (goodsIds != null && goodsIds.length > 0) {
					for (String goodsId : goodsIds) {
						if (!goodsId.equals("")) {
							GroupFloorContent groupFloorContent = new GroupFloorContent();
							groupFloorContent.setFloorId(groupFloorVO.getId());
							groupFloorContent.setStoreId(Long.parseLong(goodsId));
							groupFloorContent.setAddTime(new Date(System.currentTimeMillis()));
							groupFloorContent.setCityId(groupFloorVO.getGroupFloorStoreCityId());
							groupFloorContentDao.save(groupFloorContent);
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
	 * 删除楼层
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
	 * 根据id查找楼层
	 * 
	 * @param id
	 * @return groupFloorBO
	 */
	public GroupFloorBO getObjById(Long id) {
		GroupFloorBO groupFloorBO = this.groupFloorDao.get(id);
		if (groupFloorBO != null) {
			return groupFloorBO;
		}
		return null;
	}

	public List<GroupFloorBO> findPageByVO(GroupFloorVO vo, MyPage<GroupFloorVO> page) {
		return this.groupFloorDao.findPageByVO(vo, page);
	}
}
