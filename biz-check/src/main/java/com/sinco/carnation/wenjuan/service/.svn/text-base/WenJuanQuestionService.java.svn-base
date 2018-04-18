package com.sinco.carnation.wenjuan.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.dao.WenJuanQuestionDao;
import com.sinco.carnation.sns.dao.WenJuanQuestionOptionDao;
import com.sinco.carnation.sns.model.WenJuanQuestion;
import com.sinco.carnation.sns.model.WenJuanQuestionOption;

@Service
public class WenJuanQuestionService {

	@Autowired
	private WenJuanQuestionDao questionDao;
	@Autowired
	private WenJuanQuestionOptionDao questionOptionDao;

	@Transactional
	public void addQuestion(Long id, Long groupId, String questionTitle, Integer questionIndex,
			Integer[] optionIndex, String[] optionDesc, Integer[] score, Long userId) {
		WenJuanQuestion question = new WenJuanQuestion();
		question.setWjGroupId(groupId);
		question.setQuestionTitle(questionTitle);
		question.setQuestionIndex(questionIndex);
		question.setCreateBy(userId);
		question.setCreateTime(new Date());
		question.setIsDeleted(false);
		this.questionDao.save(question);
		if (null != optionDesc && optionDesc.length > 0) {
			for (int i = 0; i < optionDesc.length; i++) {
				WenJuanQuestionOption questionOption = new WenJuanQuestionOption();
				questionOption.setWjQuestionId(question.getId());
				questionOption.setOptionDesc(optionDesc[i]);
				questionOption.setOptionIndex(optionIndex[i]);
				questionOption.setScore(score[i]);
				questionOption.setCreateBy(userId);
				questionOption.setCreateTime(new Date());
				questionOption.setIsDeleted(false);
				this.questionOptionDao.save(questionOption);
			}
		}

	}

	@Transactional
	public void updateQuestion(Long id, Long groupId, String questionTitle, Integer questionIndex,
			Long[] optionId, Integer[] optionIndex, String[] optionDesc, Integer[] score, Long userId) {
		WenJuanQuestion question = new WenJuanQuestion();
		question.setId(id);
		question.setWjGroupId(groupId);
		question.setQuestionTitle(questionTitle);
		question.setQuestionIndex(questionIndex);
		question.setUpdateBy(userId);
		question.setUpdateTime(new Date());
		question.setIsDeleted(false);
		this.questionDao.update(question);
		if (null != optionId && optionId.length > 0) {
			for (int i = 0; i < optionId.length; i++) {
				WenJuanQuestionOption questionOption = new WenJuanQuestionOption();
				questionOption.setWjQuestionId(question.getId());
				questionOption.setOptionDesc(optionDesc[i]);
				questionOption.setOptionIndex(optionIndex[i]);
				questionOption.setScore(score[i]);
				if (optionId[i] != 0) {
					questionOption.setId(optionId[i]);
					questionOption.setUpdateBy(userId);
					questionOption.setUpdateTime(new Date());
					this.questionOptionDao.updateById(questionOption);
				} else {
					questionOption.setCreateBy(userId);
					questionOption.setCreateTime(new Date());
					questionOption.setIsDeleted(false);
					this.questionOptionDao.addOption(questionOption);
				}
			}
		}
	}

	public void deleteQuestionAndOption(Long questionID) {
		this.questionDao.delete(questionID);
		this.questionOptionDao.deleteByQuestionID(questionID);
	}

	public void delteQuestionOptionByID(Long id) {
		this.questionOptionDao.delete(id);
	}
}
