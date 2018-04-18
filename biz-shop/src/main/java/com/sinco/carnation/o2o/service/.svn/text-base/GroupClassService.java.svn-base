package com.sinco.carnation.o2o.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.dao.GroupClassDao;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicLoadData;
import com.sinco.dic.client.model.DicBase;

import edu.emory.mathcs.backport.java.util.Collections;

@Service
@Transactional
public class GroupClassService {
	@Autowired
	private GroupClassDao groupClassDao;

	@Autowired
	private DicContent dicContent;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@PostConstruct
	public void init() {
		dicContent.setDicCache(GroupClassBO.class, new DicLoadData() {
			@Override
			public List<DicBase> loadDate() {
				List<GroupClassBO> list = groupClassDao.findNormalAll();
				return Lists.newArrayList(list.toArray(new DicBase[list.size()]));
			}
		}, false);
	}

	/**
	 * 从缓存中得到按级别整理好的对象
	 * 
	 * @return
	 */
	public List<GroupClassBO> findCacheLevelAll() {
		List<GroupClassBO> dicData = dicContent.getRootTreeDic(GroupClassBO.class);

		Collections.sort(dicData);

		return dicData;
	}

	/**
	 * 从缓存中得到按级别整理好的对象
	 * 
	 * @return
	 */
	public List<GroupClassBO> findCacheRoot() {
		List<GroupClassBO> dicData = dicContent.getRootDics(GroupClassBO.class);

		Collections.sort(dicData);

		return dicData;
	}

	/**
	 * 从缓存
	 * 
	 * @return
	 */
	public GroupClassBO findTreeCacheById(Long id) {
		return dicContent.getTreeDic(GroupClassBO.class, String.valueOf(id));
	}

	public List<GroupClassBO> findCahceByParent(Long parentId) {
		List<GroupClassBO> list = dicContent.getDicsConvertByParentCode(GroupClassBO.class,
				String.valueOf(parentId));
		Collections.sort(list);
		return list;
	}

	/**
	 * 刷新数据字典缓存
	 */
	public void refreshDicCache() {
		dicContent.refreshDicCache(GroupClassBO.class);
	}

	public boolean save(GroupClass groupClass, HttpServletRequest request) {
		// 上传图标
		// web端图标
		String webIcon = accessoryService.upload(request, "webIcon", null);
		groupClass.setWebIcon(webIcon);
		// 移动端图标
		String mobileIcon = accessoryService.upload(request, "mobileIcon", null);
		groupClass.setMobileIcon(mobileIcon);
		this.groupClassDao.save(groupClass);
		return true;
	}

	public GroupClass getObjById(Long id) {
		GroupClass groupClass = this.groupClassDao.get(id);
		if (groupClass != null) {
			return groupClass;
		}
		return null;
	}

	public boolean delete(Long id) {
		this.groupClassDao.remove(id);
		return true;
	}

	public boolean batchDelete(List<Serializable> groupClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : groupClassIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(GroupClass groupClass, HttpServletRequest request) {
		// 上传图标
		// web端图标
		String webIcon = accessoryService.upload(request, "webIcon", null);
		groupClass.setWebIcon(webIcon);
		// 移动端图标
		String mobileIcon = accessoryService.upload(request, "mobileIcon", null);
		groupClass.setMobileIcon(mobileIcon);
		this.groupClassDao.update(groupClass);
		return true;
	}

	public boolean update(GroupClass groupClass) {
		this.groupClassDao.update(groupClass);
		return true;
	}

	/**
	 * 分页查找
	 * 
	 * @param page
	 * @return
	 */
	public List<GroupClassBO> findParentIsNullPage(@Param("page") Page<GroupClassBO> page) {
		return groupClassDao.findParentIsNullPage(page);
	}

	/**
	 * 查找子分类
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GroupClassBO> findByParent(@Param("parentId") Long parentId) {
		return groupClassDao.findByParent(parentId);
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
		return groupClassDao.countByName(name, id, parentId);
	}

	/**
	 * 得到所有子对象,递归
	 * 
	 * @return
	 */
	public List<GroupClassBO> findAllChild(Long... ids) {
		return groupClassDao.findAllChild(ids);
	}

	public List<GroupClassBO> findChildList(Long id) {
		return this.findAllChild(id);
	}

	public List<GroupClassBO> findAllParents() {
		return groupClassDao.findAllParents();
	}

	public void queryGroupClassList(MyPage<GroupClassBO> page) {
		page.setContent(groupClassDao.queryGroupClassList(page));
	}
}
