package com.sinco.carnation.wenjuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.dao.WenJuanGroupResultDao;
import com.sinco.carnation.sns.vo.WenJuanGroupResultVO;

@Service
public class WenJuanGroupResultService {

	@Autowired
	private WenJuanGroupResultDao dao;

	/**
	 * 获取题目结果最大和最小分数
	 * 
	 * @param themeID
	 * @return
	 */
	public WenJuanGroupResultBO queryResultMaxAndMinSoreByThemeID(Long themeID) {
		return this.dao.selectMaxAndMinByThemeID(themeID);
	}

	/**
	 * 获取题目结果最大和最小分数
	 * 
	 * @param groupID
	 * @return
	 */
	public WenJuanGroupResultBO queryResultMaxAndMinSoreByGroupID(Long groupID) {
		return this.dao.selectMaxAndMinByGroupID(groupID);
	}

	/**
	 * 添加
	 * 
	 * @param vo
	 * @return
	 */
	public Long saveWenJuanGroupResult(WenJuanGroupResultVO vo) {
		return this.dao.save(vo).getId();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByID(Long id) {
		this.dao.delete(id);
		return 0;
	}
}
