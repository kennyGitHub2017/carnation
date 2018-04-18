package com.sinco.carnation.juanpi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.dao.JuanpiGoodsClassDao;
import com.sinco.carnation.juanpi.model.JuanpiGoodsClass;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsClassVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class JuanpiGoodsClassService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JuanpiGoodsClassDao juanpiGoodsClassDao;
	
	public List<JuanpiGoodsClassBO> findByClass3Id(Long classId) {
		return juanpiGoodsClassDao.findByClass3Id(classId);
	}

	/**
	 * 根据条件查询分页
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<JuanpiGoodsClassBO> pageClassByVO(MyPage<JuanpiGoodsClassBO> page, JuanpiGoodsClassVO vo) {
		if (null == vo) {
			return new ArrayList<JuanpiGoodsClassBO>();
		}
		List<JuanpiGoodsClassBO> list = juanpiGoodsClassDao.pageByVO(page, vo);
		return list;
	}

	/**
	 * 根据条件查询分页
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<JuanpiGoodsClassBO> pageViewClassByVO(MyPage<JuanpiGoodsClassBO> page, JuanpiGoodsClassVO vo,
			ModelAndView mv) {
		if (null == vo) {
			return new ArrayList<JuanpiGoodsClassBO>();
		}
		List<JuanpiGoodsClassBO> list = juanpiGoodsClassDao.pageByVO(page, vo);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return list;
	}
	
	public JuanpiGoodsClassBO findOne(Long id){
		return juanpiGoodsClassDao.findOne(id);
	}

	/**
	 * 保存分类信息
	 * 
	 * @param record
	 * @throws ServiceException
	 */
	public void save(JuanpiGoodsClass record) throws ServiceException {
		if (null == record) {
			log.error("[JuanpiGoodsClassService] save error: record is null");
			return;
		}
		if (juanpiGoodsClassDao.saveResult(record) < 1) {
			throw new ServiceException("保存失败");
		}
	}

	/**
	 * 编辑分类信息
	 * 
	 * @param record
	 * @throws ServiceException
	 */
	public void edit(JuanpiGoodsClass record) throws ServiceException {
		if (record == null) {
			log.error("[JuanpiGoodsClassService] save error: record is null");
			throw new ServiceException("获取分类信息失败");
		}
		if (record.getId() == null) {
			throw new ServiceException("获取id失败,请重试");
		}
		if (record.getClass3Id() == null) {
			throw new ServiceException("选择的分类必须是三级分类");
		}
		record.setIsJoin(1);
		save(record);
	}
	
	/**
	 * 根据lavel,id查询分类信息
	 * 用于ajax加载卷皮分类
	 * @param level
	 * @param classId
	 * @return
	 */
	public List<JuanpiGoodsClassBO> listByLevelId(String level ,Long classId, Integer isJoin){
		List<JuanpiGoodsClassBO> result = juanpiGoodsClassDao.listByLevelId(level, classId , isJoin);
		return result;
	}
}
