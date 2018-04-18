package com.sinco.carnation.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.AdContentBO;
import com.sinco.carnation.sys.dao.AdContentDao;
import com.sinco.carnation.sys.dao.DicAreaDao;
import com.sinco.carnation.sys.model.AdContent;
import com.sinco.carnation.sys.model.DicArea;
import com.sinco.carnation.sys.vo.AdContentVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class ContentService {

	@Autowired
	private AdContentDao adContentDao;
	
	@Autowired
	private DicAreaDao dicAreaDao;

	public List<AdContentBO> findContentByPage(MyPage<AdContentBO> page, AdContentVO vo) {
		return adContentDao.findContentsByPage(page, vo);
	}
	

	public int saveAdContent(AdContent record) {
		return adContentDao.save(record);
	}
	
	public List<AdContentBO> findAllName(AdContentVO vo) {
		return adContentDao.findAllName(vo);
	}
	
	public List<AdContentBO> findAll() {
		return adContentDao.findAll();
	}
	
	/**
	 * 修改区域下所有子级排序
	 * @param record
	 * @return
	 */
	public int updateAllOrdersById(AdContent record){
		return adContentDao.updateAllOrdersById(record);
	}
	
	public DicArea findExplmeById(Long id){
		return dicAreaDao.findById(id);
	}
	
	public List<DicArea> findAllChenShi(Long pid){
		return dicAreaDao.findAllChenShi(pid);
	}
	
	
	
	public DicArea findShen(Long pid){
		return dicAreaDao.findShen(pid);
	}
	
	/**
	 * 根据vo查询分页
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<AdContentBO> listByVO(AdContentVO vo, MyPage<AdContentBO> page, String queryType) {
		return adContentDao.listByVO(vo, page, queryType);
	}

	/**
	 * 根据id精确查询
	 * 
	 * @param id
	 * @return
	 */
	public AdContentBO findById(Long id) {
		if (null == id) {
			return new AdContentBO();
		}
		return adContentDao.findOne(id);
	}

	
	
	
	/**
	 * 不带id保存/带id编辑
	 * 
	 * @param record
	 * @return
	 */
	public boolean save(AdContent record) {
		boolean result = false;
		if (null == record) {
			return result;
		}
		if (adContentDao.save(record) == 1) {
			result = true;
		}
		return result;
	}

	public boolean deleteById(Long id) {
		boolean result = adContentDao.delete(id);
		return result;
	}

	/**
	 * 获取区域广告列表
	 * 
	 * @param adContent
	 * @return
	 */
	public List<AdContentBO> getContentList(String code,Long areaId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("areaId", areaId);
		return adContentDao.queryContentsList(map);
	}
	
	public int findCountByAreaAdId(long areaAdId) {
		return adContentDao.findCountByAreaAdId(areaAdId);
	}

}
