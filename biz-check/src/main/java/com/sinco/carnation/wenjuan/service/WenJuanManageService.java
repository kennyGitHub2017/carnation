package com.sinco.carnation.wenjuan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.selftest.bo.WenJuanThemeBO;
import com.sinco.carnation.selftest.dao.WenJuanThemeDao;
import com.sinco.carnation.selftest.model.WenJuanTheme;
import com.sinco.carnation.selftest.vo.WenJuanThemeVO;
import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionOptionBO;
import com.sinco.carnation.sns.dao.WenJuanGroupDao;
import com.sinco.carnation.sns.dao.WenJuanGroupResultDao;
import com.sinco.carnation.sns.dao.WenJuanQuestionDao;
import com.sinco.carnation.sns.dao.WenJuanQuestionOptionDao;
import com.sinco.carnation.sns.model.WenJuanGroup;
import com.sinco.carnation.sns.vo.WenJuanGroupResultVO;
import com.sinco.carnation.sns.vo.WenJuanGroupVO;
import com.sinco.dal.common.MyPage;

@Service
public class WenJuanManageService {

	@Autowired
	private WenJuanThemeDao wenJuanThemDao;

	@Autowired
	private WenJuanGroupDao wenJuanGroupDao;

	@Autowired
	private WenJuanGroupResultDao wenJuanGroupResultDao;

	@Autowired
	public WenJuanQuestionDao wenJuanQuestionDao;

	@Autowired
	public WenJuanQuestionOptionDao wenJuanQuestionOptionDao;

	/**
	 * 获取问卷主题
	 * 
	 * @return
	 */
	public List<WenJuanThemeBO> findByPage(MyPage<WenJuanTheme> page, WenJuanThemeVO vo) {
		return wenJuanThemDao.findByPage(page, vo);
	}

	/**
	 * 保存问卷主题
	 * 
	 * @param vo
	 * @return
	 */
	public WenJuanTheme save_wj_Theme(WenJuanThemeVO vo) {
		if (vo.getId() != null && vo.getId() != 0l) {
			this.wenJuanThemDao.update(vo);
			return new WenJuanTheme();
		}
		return wenJuanThemDao.save(vo);
	}

	/**
	 * 删除问卷主题
	 * 
	 * @param list
	 * @return
	 */
	public int del_wj_Theme(List<Long> list) {
		this.wenJuanThemDao.deleteByIds(list);
		return 0;
	}

	/**
	 * 获取主题
	 * 
	 * @param id
	 * @return
	 */
	public WenJuanTheme query_wj_ThemeOne(Long id) {
		return this.wenJuanThemDao.findOne(id);
	}

	/**
	 * 编辑问卷主题
	 * 
	 * @param vo
	 * @return
	 */
	public int update_wj_Theme(WenJuanThemeVO vo) {
		this.wenJuanThemDao.update(vo);
		return 0;
	}

	/**
	 * 获取问卷题组
	 * 
	 * @return
	 */
	public List<WenJuanGroupBO> query_WenJuanGroup_byPage(MyPage<WenJuanGroupVO> page, WenJuanGroupVO vo) {
		List<WenJuanGroupBO> result_list = this.wenJuanGroupDao.findByPage(page, vo);
		List<WenJuanThemeBO> themeList = wenJuanThemDao.findAll();
		Map<Long, String> map = new HashMap<Long, String>();
		for (WenJuanThemeBO theme : themeList) {
			map.put(theme.getId(), theme.getThemeName());
		}
		for (WenJuanGroupBO group : result_list) {
			group.setThemeName(map.get(group.getWjThemeID()));
		}
		return result_list;
	}

	/**
	 * 获取问卷结果评分
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<WenJuanGroupResultBO> query_WenJuanGroupResult_findByPage(MyPage<WenJuanGroupResultVO> page,
			WenJuanGroupResultVO vo) {
		return this.wenJuanGroupResultDao.findByPage(page, vo);
	}

	public List<WenJuanQuestionBO> query_WenJuanQuestion_ByGroupID(Long groupID) {
		return this.wenJuanQuestionDao.queryQuestionByGroupID(groupID);
	}

	/**
	 * 获取选题的选项
	 * 
	 * @param questionID
	 * @return
	 */
	public List<WenJuanQuestionOptionBO> queryQuestionOpetion(Long questionID) {
		List<WenJuanQuestionOptionBO> resultList = null;
		resultList = this.wenJuanQuestionOptionDao.getOpetionByQuestionID(questionID);
		if (resultList == null || resultList.size() == 0) {
			resultList = new ArrayList<WenJuanQuestionOptionBO>();
		}
		return resultList;
	}

	/**
	 * 根据题目ID获取题目信息
	 * 
	 * @param questionID
	 * @return
	 */
	public WenJuanQuestionBO queryQuestionByID(Long questionID) {
		WenJuanQuestionBO question = this.wenJuanQuestionDao.findOne(questionID);
		if (question == null || question.getId() == 0l) {
			return null;
		}
		return question;
	}

	/**
	 * 获取所有主题
	 * 
	 * @return
	 */
	public List<WenJuanThemeBO> queryWenJuanThemeList() {
		List<WenJuanThemeBO> list = this.wenJuanThemDao.findAll();
		return list;
	}

	/**
	 * 获取所有题组
	 * 
	 * @return
	 */
	public List<WenJuanGroupBO> queryWenJuanGroupList() {
		WenJuanGroup obj = new WenJuanGroup();
		obj.setPid(0L);
		List<WenJuanGroupBO> list = this.wenJuanGroupDao.getWenJuanGroupAll(obj);
		return list;
	}

	/**
	 * 新增题组
	 * 
	 * @param vo
	 * @return
	 */
	public WenJuanGroup saveWenJuanGroup(WenJuanGroupVO vo) {
		return this.wenJuanGroupDao.save(vo);
	}
}
