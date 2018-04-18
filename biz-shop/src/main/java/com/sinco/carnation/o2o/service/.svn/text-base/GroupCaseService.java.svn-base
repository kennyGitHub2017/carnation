package com.sinco.carnation.o2o.service;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.o2o.bo.GroupCaseBO;
import com.sinco.carnation.o2o.dao.GroupCaseContentDao;
import com.sinco.carnation.o2o.dao.GroupCaseDao;
import com.sinco.carnation.o2o.model.GroupCase;
import com.sinco.carnation.o2o.model.GroupCaseContent;
import com.sinco.carnation.o2o.vo.GroupCaseShowVO;
import com.sinco.carnation.o2o.vo.GroupCaseVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dal.common.mapper.JsonMapper;

/**
 * <p>
 * Title: GroupCaseService.java
 * </p>
 * 
 * <p>
 * Description: 团购橱窗相关业务实现
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
 * @date 2015-9-8
 * @version 1.0.1
 */

@Service
@Transactional
public class GroupCaseService {

	@Autowired
	private GroupCaseDao groupCaseDao;

	@Autowired
	private GroupCaseContentDao groupCaseContentDao;

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	private static String groupCase_cached_key = "groupCase_cached";

	private final Integer expireTime = 300;

	/**
	 * 查找显示的橱窗
	 * 
	 * @param vo
	 * @return
	 */
	public List<GroupCaseBO> findShow(GroupCaseShowVO vo) {
		return toGetGroupCase(vo);
	}

	/**
	 * 保存团购 橱窗
	 * 
	 * @param groupCase
	 * @return isSuccess
	 */
	@SuppressWarnings("unchecked")
	public boolean save(GroupCaseVO groupCaseVO) {
		try {
			String caseContent = groupCaseVO.getGroupCaseGoods();
			JsonMapper objectMapper = new JsonMapper();
			LinkedHashMap<String, Object> groupGoodsMap = objectMapper.fromJson(caseContent,
					LinkedHashMap.class);
			groupCaseDao.save(groupCaseVO);

			if (groupGoodsMap != null) {
				for (String key : groupGoodsMap.keySet()) {
					if (groupGoodsMap.get(key) != null) {
						String[] goodsIds = ((String) groupGoodsMap.get(key)).split(",");
						for (String goodsId : goodsIds) {
							if (!goodsId.equals("")) {
								GroupCaseContent groupCaseContent = new GroupCaseContent();
								groupCaseContent.setCaseId(groupCaseVO.getId());
								groupCaseContent.setGoodsId(Long.parseLong(goodsId));
								groupCaseContent.setAddTime(new Date(System.currentTimeMillis()));
								groupCaseContent.setCityId(Long.parseLong(key));
								groupCaseContentDao.save(groupCaseContent);
							}
						}
					}
				}
			}
			refreshGroupCase();// cc
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 修改团购橱窗
	 * 
	 * @param groupCase
	 * @return isSuccess
	 */
	@SuppressWarnings("unchecked")
	public boolean update(GroupCaseVO groupCaseVO) {
		try {
			groupCaseDao.update(groupCaseVO);
			String caseContent = groupCaseVO.getGroupCaseGoods();
			JsonMapper objectMapper = new JsonMapper();
			LinkedHashMap<String, Object> goodsMap = objectMapper.fromJson(caseContent, LinkedHashMap.class);
			if (goodsMap != null) {
				for (String key : goodsMap.keySet()) {
					// System.out.println("key= "+ key + " and value= " +
					// map.get(key));
					groupCaseContentDao
							.deleteGoodsByCaseIdAndCityId(groupCaseVO.getId(), Long.parseLong(key));

					if (goodsMap.get(key) != null) {
						String[] goodsIds = ((String) goodsMap.get(key)).split(",");
						for (String goodsId : goodsIds) {
							if (!goodsId.equals("")) {
								GroupCaseContent groupCaseContent = new GroupCaseContent();
								groupCaseContent.setCaseId(groupCaseVO.getId());
								groupCaseContent.setGoodsId(Long.parseLong(goodsId));
								groupCaseContent.setAddTime(new Date(System.currentTimeMillis()));
								groupCaseContent.setCityId(Long.parseLong(key));
								groupCaseContentDao.save(groupCaseContent);
							}
						}
					}
				}
			}
			refreshGroupCase();// cc
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
			groupCaseDao.remove(id);
			groupCaseContentDao.deleteByCaseId(id);
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
	public GroupCase getObjById(Long id) {
		GroupCase groupCase = this.groupCaseDao.get(id);
		if (groupCase != null) {
			return groupCase;
		}
		return null;
	}

	public List<GroupCaseBO> findPageByVO(GroupCaseVO vo, MyPage<GroupCaseBO> page) {
		return this.groupCaseDao.findPageByVO(vo, page);
	}

	public void updateDisplay(Long id, int display) {
		groupCaseDao.updateDisplay(id, display);
	}

	public void updateSequnce(Long id, int seq) {
		groupCaseDao.updateSequnce(id, seq);
	}

	/**
	 * 查找显示的橱窗
	 * 
	 * @param vo
	 * @return cc
	 */
	public List<GroupCaseBO> findListShow(GroupCaseShowVO vo) {
		return groupCaseDao.findShow(vo);
	}

	/**
	 * 默认刷新4条缓存
	 * 
	 * @return cc
	 */
	@Transactional(readOnly = true)
	public List<GroupCaseBO> refreshGroupCase() {
		GroupCaseShowVO caseVO = new GroupCaseShowVO();
		caseVO.setCount(4);
		caseVO.setDisplay(true);
		List<GroupCaseBO> list = findListShow(caseVO);
		cacheUtils.set(groupCase_cached_key, list, expireTime);
		// localCache.invalidateAll();
		return list;
	}

	/**
	 * 对内使用
	 * 
	 * @return cc
	 */
	private List<GroupCaseBO> toGetGroupCase(GroupCaseShowVO vo) {
		// 暂时隐藏缓存部分
//		List<GroupCaseBO> list = cacheUtils.get(groupCase_cached_key,
//				new TypeReference<List<GroupCaseBO>>() {
//				});

		// if (null == list) {
		List<GroupCaseBO> list = findListShow(vo);
		// // 先删除对应的缓存数据
		// cacheUtils.del(groupCase_cached_key);
		// // 保存进缓存
		// cacheUtils.set(groupCase_cached_key, list, expireTime);
		// }
		return list;
	}
}
