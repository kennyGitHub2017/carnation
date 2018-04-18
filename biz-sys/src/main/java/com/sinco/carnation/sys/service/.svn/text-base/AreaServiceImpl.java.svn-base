package com.sinco.carnation.sys.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.lbs.LbsBiz;
import vc.thinker.lbs.model.LbsArea;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sinco.carnation.sys.bo.AreaBO;
import com.sinco.carnation.sys.dao.AreaDao;
import com.sinco.carnation.sys.model.Area;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicLoadData;
import com.sinco.dic.client.model.DicBase;

import edu.emory.mathcs.backport.java.util.Collections;

@Service
@Transactional(readOnly = true)
public class AreaServiceImpl {

	private final static Logger log = LoggerFactory.getLogger(AreaServiceImpl.class);

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private DicContent dicContent;

	@Autowired
	private LbsBiz lbsBiz;

	private Properties areaPinyinDic;

	@PostConstruct
	public void init() {

		// 设置地区数据字典
		dicContent.setDicCache(Area.class, new DicLoadData() {
			@Override
			public List<DicBase> loadDate() {
				List<Area> areas = areaDao.findAll();
				return Lists.newArrayList(areas.toArray(new DicBase[areas.size()]));
			}
		}, false);

		// 加载城市拼音字典（主要是多音字）
		Resource res = new ClassPathResource("pinyin_dic.properties");
		areaPinyinDic = new Properties();
		InputStream is = null;
		try {
			is = res.getInputStream();
			areaPinyinDic.load(is);
		} catch (Exception e) {
			log.warn("加载配置文件失败：pinyin_dic.properties", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}

	}

	/**
	 * 查找服务热闹城市
	 * 
	 * @return
	 */
	public List<Area> findGroupHotCity() {
		return areaDao.findGroupHotCity();
	}

	/**
	 * 查找服务热闹城市
	 * 
	 * @return
	 */
	public List<AreaBO> findGroupHotCityByPage(@Param("page") Page<AreaBO> page) {
		return areaDao.findGroupHotCityByPage(page);
	}

	public List<Area> getAllParentIsNull() {
		List<Area> listArea = dicContent.getRootDics(Area.class);
		Collections.sort(listArea);
		return listArea;
	}

	/**
	 * 缓存中根据parentid 查找
	 * 
	 * @param parentId
	 * @return
	 */
	public Collection<Area> getCacheAll() {
		return dicContent.getDicsConvert(Area.class);
	}

	public Area getCacheById(Long id) {
		return (Area) dicContent.getDic(Area.class, String.valueOf(id));
	}

	/**
	 * 返回首字母
	 * 
	 * @param parentId
	 * @return
	 */
	public Map<String, List<Area>> findPinyinMap() {
		Collection<Area> areaAll = this.getCacheAll();

		Map<String, List<Area>> cityAll = Maps.newTreeMap();

		for (Area area : areaAll) {
			if (area.getLevel().equals(1)) {
				String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(area.getAreaName().charAt(0));
				String firstChar = String.valueOf(pinyinArray[0].charAt(0)).toUpperCase();

				// 处理多音字的问题
				if (areaPinyinDic != null && areaPinyinDic.getProperty(area.getAreaName()) != null) {
					firstChar = areaPinyinDic.getProperty(area.getAreaName()).substring(0, 1).toUpperCase();
				}

				List<Area> citys = cityAll.get(firstChar);
				area.setFirstChar(firstChar);
				if (citys == null) {
					citys = new ArrayList<>();
					cityAll.put(firstChar, citys);
				}
				citys.add(area);
			}
		}
		// 排序
		for (Map.Entry<String, List<Area>> entry : cityAll.entrySet()) {
			Collections.sort(entry.getValue());
		}
		return cityAll;
	}

	/**
	 * 缓存中根据parentid 查找
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Area> getCacheByParentId(String parentId) {
		List<Area> listArea = dicContent.getDicsConvertByParentCode(Area.class, parentId);
		Collections.sort(listArea);
		return listArea;
	}

	/***
	 * 根据ip查找对应的城市
	 * 
	 * @param ip
	 * @return
	 */
	public Area findCityByIp(String ip) {
		try {
			LbsArea lbsArea = lbsBiz.findByIP(ip);

			return areaDao.findCityByName(lbsArea.getCity());
		} catch (Exception e) {
			log.error("connect error", e);
			return null;
		}
	}

	/**
	 * 根据父id来查询区域
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Area> findByParentId(Long parentId) {
		return areaDao.findByParentId(parentId);
	}

	/**
	 * 查询所有的父地区
	 * 
	 * @return
	 */
	public List<Area> findParentArea() {
		return areaDao.findByParentId(null);
	}

	/**
	 * 获取父级地址
	 * 
	 * @param id
	 * @return
	 */
	public Area getParentObjById(Long id) {
		Area a3 = getObjById(id);
		if (null == a3 || null == a3.getParentId()) {
			return null;
		}
		return getObjById(a3.getParentId());
	}

	public Area getObjById(Long id) {
		return this.areaDao.get(id);
	}

	/**
	 * 地区全称（详细地区，包括省市县）
	 * 
	 * @param areaId
	 * @return
	 */
	public String fullName(long areaId) {
		Area a3 = getObjById(areaId);
		Area a2 = getObjById(a3.getParentId());
		Area a1 = getObjById(a2.getParentId());

		return a1.getAreaName() + a2.getAreaName() + a3.getAreaName();
	}

	public String areaName(long areaId) {
		Area a3 = getObjById(areaId);
		Area a2 = getObjById(a3.getParentId());

		return a2.getAreaName() + a3.getAreaName();
	}

	public String isFullName(long areaId) {
		Area a3 = getObjById(areaId);
		Area a2 = null;
		if (null != a3) {
			a2 = getObjById(a3.getParentId());
		}
		Area a1 = null;
		if (a2 != null && a2.getParentId() != null) {
			a1 = getObjById(a2.getParentId());
		}
		if (a1 != null)
			return a1.getAreaName() + a2.getAreaName() + a3.getAreaName();
		else if (null != a2)
			return a2.getAreaName() + a3.getAreaName();
		else if (null != a3)
			return a3.getAreaName();
		else
			return "";
	}

	public List<Area> queryAreaByParentId(Long parentId) {
		return areaDao.queryAreaByParentId(parentId);
	}

	/**
	 * 查询所有的顶级地区
	 * 
	 * @return
	 */
	public List<Area> queryParentArea() {
		return areaDao.queryParentArea();
	}

	public Area queryAreaById(Long id) {
		return areaDao.findOne(id);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectByProvince() {
		return areaDao.selectByProvince();
	}

	public void queryAreaList(Long pid, MyPage<Area> page) {
		page.setContent(areaDao.queryAreaList(pid, page));
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
				Area area = queryAreaById(Long.parseLong(request.getParameter("id_" + i)));
				area.setAreaName(areaName);
				String sequence = request.getParameter("sequence_" + i);
				area.setSequence(CommUtil.null2Int(sequence));
				areaDao.update(area);
				i++;
			}
		}
		// 批量更新完毕
		// 批量保存
		Area parent = null;
		if (StringUtils.isNotBlank(pid))
			parent = queryAreaById(Long.parseLong(pid));
		for (int i = 1; i <= CommUtil.null2Int(count); i++) {
			Area area = new Area();
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
			area.setCommon(false);
			areaDao.save(area);
		}
		// 批量保存完毕
		dicContent.refreshDicCache(Area.class);
	}

	@Transactional(readOnly = false)
	public void update(Area area) {
		areaDao.update(area);
	}

	@Transactional(readOnly = false)
	public void batchDel(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			for (String id : ids) {
				genericIds(queryAreaById(CommUtil.null2Long(id)));
			}
		}
		dicContent.refreshDicCache(Area.class);
	}

	private void genericIds(Area obj) {

		List<Area> list = areaDao.queryAreaByParentId(obj.getId());
		for (Area area : list) {
			genericIds(area);
		}
		areaDao.delete(obj.getId());
	}

	/**
	 * 简单实现获取对象，及层级父类
	 * 
	 * @param id
	 * @return
	 */
	public Area fetchAndAllParent(Long id) {
		Area area = areaDao.get(id);
		if (area != null && area.getParentId() != null) {
			Area parent = areaDao.get(area.getParentId());
			if (null != parent && parent.getParentId() != null) {
				Area grandpa = areaDao.get(parent.getParentId());
				parent.setParent(grandpa);
			}
			area.setParent(parent);
		}
		return area;

	}

	public List<Area> getAreaList(Integer num, Long parentId) {
		switch (num) {
			case 1:
				return dicContent.getRootDics(Area.class);
			case 2:
				return dicContent.getDicsConvertByParentCode(Area.class, CommUtil.null2String(parentId));
			case 3:
				return dicContent.getDicsConvertByParentCode(Area.class, CommUtil.null2String(parentId));
			default:
				return null;
		}
	}

	/**
	 * 根据城市名查询id
	 * 
	 * @param areaName
	 * @return
	 */
	public Area queryAreaByName(String areaName) {
		return areaDao.queryAreaByName(areaName);
	}

	/**
	 * 根据上级地区id和本地区名查本地区id (县区名有些地方是重复的)
	 */
	public Area queryAreaByPidAndName(Long parentId, String areaName) {
		return areaDao.queryAreaByPidAndName(parentId, areaName);
	}

	/**
	 * 根据area_id查询 省-市-区 名
	 */
	public AreaBO selectNameByAreaId(Long areaId) {
		return areaDao.selectNameByAreaId(areaId);
	}

	public Area findOneById(java.lang.Long id) {
		return areaDao.findOne(id);
	}
}
