package com.sinco.carnation.check.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.bo.CheckGroupResultBO;
import com.sinco.carnation.sns.dao.CheckGroupDao;
import com.sinco.carnation.sns.dao.CheckGroupResultDao;
import com.sinco.carnation.sns.model.CheckGroupResult;
import com.sinco.carnation.sns.vo.CheckGroupResultVO;
import com.sinco.carnation.user.dao.CheckResultHistoryDao;
import com.sinco.carnation.user.model.CheckResultHistory;

@Service
public class CheckGroupResultService {

	@Autowired
	private CheckGroupDao checkGroupDao;

	@Autowired
	private CheckGroupResultDao checkGroupResultDao;

	@Autowired
	private CheckResultHistoryDao checkResultHistoryDao;

	public CheckGroupResultBO findGroupResult(Long groupId, Integer score, Long currentUserId) {
		List<CheckGroupResultBO> resultList = findListByGroup(groupId);
		if (!CollectionUtils.isEmpty(resultList)) {
			for (CheckGroupResultBO checkGroupResultBO : resultList) {
				if (checkGroupResultBO != null && score >= checkGroupResultBO.getStartScore()
						&& score <= checkGroupResultBO.getEndScore()) {
					CheckGroupBO checkGroupBO = checkGroupDao.selectById(groupId);
					CheckResultHistory checkResultHistory = new CheckResultHistory();
					checkResultHistory.setCurrentUserId(String.valueOf(currentUserId));
					checkResultHistory.setUserId(currentUserId);
					checkResultHistory.setGroupId(groupId);
					checkResultHistory.setScore(score);
					checkResultHistory.setGroupTitle(checkGroupBO.getGroupTitle());
					checkResultHistory.setResultDesc(checkGroupResultBO.getResultDesc());
					checkResultHistory.setCreateBy(String.valueOf(currentUserId));
					checkResultHistory.setCreateTime(new Date());
					checkResultHistoryDao.save(checkResultHistory);
					return checkGroupResultBO;
				}
			}
		}
		return null;
	}

	public List<CheckGroupResultBO> findListByGroup(Long groupId) {
		return checkGroupResultDao.findListByGroup(groupId);
	}

	public void addCheckGroupResult(CheckGroupResultVO vo, Long userId) {
		CheckGroupResult result = new CheckGroupResult();
		BeanUtils.copyProperties(vo, result);
		result.setCreateBy(userId);
		result.setCreateTime(new Date());
		checkGroupResultDao.insertSelective(result);
	}

	public void deleteCheckGroupResult(Long id) {
		checkGroupResultDao.deleteById(id);
	}

	public void updateById(CheckGroupResultVO vo, Long userId) {
		CheckGroupResult result = new CheckGroupResult();
		BeanUtils.copyProperties(vo, result);
		result.setUpdateBy(userId);
		result.setUpdateTime(new Date());
		checkGroupResultDao.updateById(result);
	}

	public CheckGroupResultBO findById(Long id) {
		return checkGroupResultDao.findById(id);
	}

	public Integer findMaxEndScoreByGroup(Long groupId) {
		return checkGroupResultDao.selectMaxEndScoreByGroup(groupId);
	}

	public Integer findExistsRecordHistory(Long userId, Long groupId) {
		return checkGroupResultDao.findExistsRecordHistory(userId, groupId);
	}

}
