package com.sinco.carnation.check.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sns.bo.CheckQuestionBO;
import com.sinco.carnation.sns.bo.CheckQuestionOptionBO;
import com.sinco.carnation.sns.dao.CheckQuestionDao;
import com.sinco.carnation.sns.dao.CheckQuestionOptionDao;
import com.sinco.carnation.sns.model.CheckQuestion;
import com.sinco.carnation.sns.model.CheckQuestionOption;
import com.sinco.carnation.sns.vo.CheckQuestionVO;

@Service
public class CheckQuestionService {

	@Autowired
	private CheckQuestionDao checkQuestionDao;

	@Autowired
	private CheckQuestionOptionDao checkQuestionOptionDao;

	public List<CheckQuestionBO> findListByGroup(Long groupId) {
		List<CheckQuestionBO> list = checkQuestionDao.selectListByGroup(groupId);
		return list;
	}

	public int addQuestion(CheckQuestionVO vo, Long userId) {
		CheckQuestion question = new CheckQuestion();
		question.setCreateBy(userId);
		question.setCreateTime(new Date());
		question.setIsDeleted(false);
		return checkQuestionDao.insertSelective(question);
	}

	public int updateById(CheckQuestionVO vo, Long userId) {
		CheckQuestion question = new CheckQuestion();
		question.setUpdateBy(userId);
		question.setUpdateTime(new Date());
		return checkQuestionDao.updateById(question);
	}

	public int deleteById(Long id, Long userId) {
		CheckQuestion question = new CheckQuestion();
		question.setId(id);
		question.setUpdateBy(userId);
		question.setUpdateTime(new Date());
		return checkQuestionDao.updateById(question);
	}

	@Transactional
	public void batchDelete(String[] ids, Long userId) {
		if (null != ids && ids.length > 0) {
			for (String idStr : ids) {
				CheckQuestion question = new CheckQuestion();
				question.setId(CommUtil.null2Long(idStr));
				question.setUpdateBy(userId);
				question.setUpdateTime(new Date());
				question.setIsDeleted(true);
				checkQuestionDao.updateById(question);
			}
		}
	}

	public CheckQuestionBO findCheckQuestionById(Long id) {
		CheckQuestionBO question = checkQuestionDao.findById(id);
		if (null != question) {
			List<CheckQuestionOptionBO> options = checkQuestionOptionDao.selectListByQuestion(id);
			question.setOptions(options);
		}
		return question;
	}

	@Transactional
	public void addQuestion(Long id, Long groupId, String questionTitle, Integer questionIndex,
			Integer[] optionIndex, String[] optionDesc, Integer[] score, Long userId) {
		CheckQuestion question = new CheckQuestion();
		question.setGroupId(groupId);
		question.setQuestionTitle(questionTitle);
		question.setQuestionIndex(questionIndex);
		question.setCreateBy(userId);
		question.setCreateTime(new Date());
		question.setIsDeleted(false);
		checkQuestionDao.insertSelective(question);
		if (null != optionDesc && optionDesc.length > 0) {
			for (int i = 0; i < optionDesc.length; i++) {
				CheckQuestionOption option = new CheckQuestionOption();
				option.setQuestionId(question.getId());
				option.setOptionDesc(optionDesc[i]);
				option.setOptionIndex(optionIndex[i]);
				option.setScore(score[i]);
				option.setCreateBy(userId);
				option.setCreateTime(new Date());
				option.setIsDeleted(false);
				checkQuestionOptionDao.addOption(option);
			}
		}
	}

	@Transactional
	public void updateQuestion(Long id, Long groupId, String questionTitle, Integer questionIndex,
			Long[] optionId, Integer[] optionIndex, String[] optionDesc, Integer[] score, Long userId) {
		CheckQuestion question = new CheckQuestion();
		question.setId(id);
		question.setGroupId(groupId);
		question.setQuestionTitle(questionTitle);
		question.setQuestionIndex(questionIndex);
		question.setUpdateBy(userId);
		question.setUpdateTime(new Date());
		checkQuestionDao.updateById(question);
		if (null != optionId && optionId.length > 0) {
			for (int i = 0; i < optionId.length; i++) {
				CheckQuestionOption option = new CheckQuestionOption();
				option.setQuestionId(question.getId());
				option.setOptionDesc(optionDesc[i]);
				option.setOptionIndex(optionIndex[i]);
				option.setScore(score[i]);
				if (optionId[i] != 0) {
					option.setId(optionId[i]);
					option.setUpdateBy(userId);
					option.setUpdateTime(new Date());
					checkQuestionOptionDao.updateById(option);
				} else {
					option.setCreateBy(userId);
					option.setCreateTime(new Date());
					option.setIsDeleted(false);
					checkQuestionOptionDao.addOption(option);
				}
			}
		}
	}

	@Transactional
	public void updateQuestionIndex(Long[] ids, Integer[] questionIndexs, Long userId) {
		if ((null != ids && ids.length > 0) && (null != questionIndexs && questionIndexs.length > 0)) {
			Map<Long, Integer> map_Data = new HashMap<Long, Integer>();
			if (ids.length == questionIndexs.length) {
				for (int i = 0; i < ids.length; i++) {
					map_Data.put(ids[i], questionIndexs[i]);
				}
				// 将Map转化为List集合，List采用ArrayList
				List<Map.Entry<Long, Integer>> list_Data = new ArrayList<Map.Entry<Long, Integer>>(
						map_Data.entrySet());
				// 通过Collections.sort(List I,Comparator c)方法进行排序
				Collections.sort(list_Data, new Comparator<Map.Entry<Long, Integer>>() {
					@Override
					public int compare(Entry<Long, Integer> o1, Entry<Long, Integer> o2) {
						return (o1.getValue() - o2.getValue());
					}
				});

				for (int h = 0; h < list_Data.size(); h++) {
					for (int i = 0; i < list_Data.size(); i++) {
						if (ids[h] == list_Data.get(i).getKey()) {
							questionIndexs[h] = i + 1;
							break;
						}
					}
				}
			}

			for (int i = 0; i < ids.length; i++) {
				CheckQuestion question = new CheckQuestion();
				question.setId(ids[i]);
				question.setQuestionIndex(questionIndexs[i]);
				question.setUpdateBy(userId);
				question.setUpdateTime(new Date());
				checkQuestionDao.updateById(question);
			}
		}
	}

	public void deleteOption(Long id, Long userId) {
		CheckQuestionOption option = new CheckQuestionOption();
		option.setId(id);
		option.setUpdateBy(userId);
		option.setUpdateTime(new Date());
		option.setIsDeleted(true);
		checkQuestionOptionDao.updateById(option);
	}

	public CheckQuestionBO selectQuestionByGroupAndIndex(CheckQuestionVO vo) {
		CheckQuestionBO checkQuestionBO = checkQuestionDao.selectQuestionByGroupAndIndex(vo);
		if (checkQuestionBO != null) {
			List<CheckQuestionOptionBO> listBO = checkQuestionOptionDao.selectListByQuestion(checkQuestionBO
					.getId());
			checkQuestionBO.setOptions(listBO);
		}
		return checkQuestionBO;
	}

	public CheckQuestionBO queryQuestionSorceRange(Long groupId) {
		return checkQuestionDao.queryQuestionSorceRange(groupId);
	}
}
