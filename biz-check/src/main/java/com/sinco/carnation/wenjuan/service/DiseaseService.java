package com.sinco.carnation.wenjuan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.bo.WenJuanProposalBO;
import com.sinco.carnation.sns.bo.WenJuanProposalDetailedBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionOptionBO;
import com.sinco.carnation.sns.bo.WenJuanresultHistoryBO;
import com.sinco.carnation.sns.dao.UserHealthtaskDao;
import com.sinco.carnation.sns.dao.WenJuanGroupDao;
import com.sinco.carnation.sns.dao.WenJuanGroupResultDao;
import com.sinco.carnation.sns.dao.WenJuanProposalDao;
import com.sinco.carnation.sns.dao.WenJuanProposalDetailedDao;
import com.sinco.carnation.sns.dao.WenJuanQuestionDao;
import com.sinco.carnation.sns.dao.WenJuanQuestionOptionDao;
import com.sinco.carnation.sns.dao.WenJuanresultHistoryDao;
import com.sinco.carnation.sns.model.WenJuanGroup;
import com.sinco.carnation.sns.model.WenJuanresultHistory;

/**
 * 用户疾病自测Service
 * 
 * @author yuleijia
 */
@Service
public class DiseaseService {

	@Autowired
	private WenJuanGroupDao wenJuanGropDao;

	@Autowired
	private WenJuanQuestionDao wenJuanQuestionDao;

	@Autowired
	private WenJuanQuestionOptionDao wenJuanQuestionOptionDao;

	@Autowired
	private WenJuanGroupResultDao wenJuanGroupResultDao;

	@Autowired
	private WenJuanProposalDao wenJuanProposalDao;

	@Autowired
	private UserHealthtaskDao userHealthTaskDao;

	@Autowired
	private WenJuanresultHistoryDao wenJuanresultHistoryDao;

	@Autowired
	private WenJuanProposalDetailedDao wenJuanProposalDetailedDao;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取疾病自测题
	 * 
	 * @param themeID
	 * @return
	 */
	public List<WenJuanGroupBO> query_Disease_list(Long themeID) {
		List<WenJuanGroupBO> list = null;
		if (themeID != null) {
			WenJuanGroup group = new WenJuanGroup();
			group.setWjThemeID(themeID);
			group.setIsDeleted(Boolean.valueOf("0"));
			group.setPid(new Long("0"));
			list = this.wenJuanGropDao.getWenJuanGroupAll(group);
			List<WenJuanGroupBO> subNodeList = new ArrayList<WenJuanGroupBO>();
			int size = list.size();
			logger.info("......." + size);
			WenJuanGroup tempObj = null;
			for (int i = 0; i < size; i++) {
				long id = list.get(i).getId();
				tempObj = new WenJuanGroup();
				tempObj.setPid(id);
				tempObj.setIsDeleted(Boolean.valueOf("0"));
				/*获取附属题*/
				subNodeList = this.wenJuanGropDao.getWenJuanGroupAll(tempObj);
				logger.info(".... subNodeList size:" + subNodeList.size());
				list.get(i).setSubNodeList(subNodeList);
			}
		}
		return list;
	}

	/**
	 * 获取自测题对应的题目
	 * 
	 * @param list
	 *            groupID List
	 * @return
	 */
	public List<WenJuanQuestionBO> queryQuestionListByGroupID(List<Long> list) {
		List<WenJuanQuestionBO> questionList = this.wenJuanQuestionDao.queryQuestionListByID(list);
		logger.info(".... resultList size:" + questionList.size());

		/*List<WenJuanQuestionBO> questionList = this.wenJuanQuestionDao.queryQuestionListByID(groupIDList);*/
		long questionID = 0L;
		List<WenJuanQuestionOptionBO> question_Option_List = null;
		List<WenJuanQuestionBO> returl_list = new ArrayList<WenJuanQuestionBO>();
		int questionIndex = 1;
		for (WenJuanQuestionBO question : questionList) {
			questionID = question.getId();
			question_Option_List = this.wenJuanQuestionOptionDao.getOpetionByQuestionID(questionID);
			question.setQuestion_option_List(question_Option_List);
			question.setQuestionIndex(questionIndex);
			returl_list.add(question);
			questionIndex++;
		}
		return returl_list;
	}

	/**
	 * 获取疾病自测评估结果
	 * 
	 * @param groupIDs
	 * @param map
	 * @return
	 */
	public List<WenJuanProposalBO> questionWenJuanProposal(List<Long> groupIDs, Map<Long, Integer> map,
			long userID) {
		if (groupIDs == null || map == null) {
			return null;
		}
		List<Long> groupResultIDList = new ArrayList<Long>();
		// 清空疾病自测历史记录 以便记录最新信息
		this.wenJuanresultHistoryDao.deleteResultHistoryByUserIDAndTypes(userID, 20L, null);
		for (int i = 0; i < groupIDs.size(); i++) {
			long groupID = groupIDs.get(i);
			int score = map.get(groupID);
			List<WenJuanGroupResultBO> list = wenJuanGroupResultDao.select_groupResults_byGroupID(groupID);
			for (WenJuanGroupResultBO obj : list) {
				int startScore = obj.getStartScore();
				int endScore = obj.getEndScore();
				if (score >= startScore && score <= endScore) {
					groupResultIDList.add(obj.getId());
					/*this.wenJuanresultHistoryDao.deleteResultHistoryByUserIDAndTypes(userID, 20L,groupID);*/
					WenJuanresultHistory history = new WenJuanresultHistory();
					history.setIsDeleted(Long.parseLong("0"));
					history.setTotalScore(score);
					history.setUserId(userID);
					history.setWjGroupResultId(groupID);
					history.setTypes(20L);// 疾病自测
					this.wenJuanresultHistoryDao.save_Result_History(history);
				}
			}
		}
		if (groupResultIDList.size() == 0) {
			return null;
		}
		List<WenJuanProposalBO> resilt_List = this.wenJuanProposalDao
				.selectProposalByInGroupResultID(groupResultIDList);
		logger.info("....... result list size:" + resilt_List.size());
		return resilt_List;
	}

	/**
	 * 获取健康任务
	 * 
	 * @return
	 */
	public List<UserHealthtaskBO> question_HealthTaskList() {
		int task_num = 3;
		List<UserHealthtaskBO> taskList = this.userHealthTaskDao.getHealthTaskListList(task_num);
		return taskList;
	}

	public List<WenJuanProposalDetailedBO> query_ProposalDetailed(long userID, long types) {
		logger.info("<<<<<<<<<<<<<<<<< userID:" + userID + " types:" + types);
		long historyType = 20L;
		List<WenJuanresultHistoryBO> resultObj = this.wenJuanresultHistoryDao.select_result_by_UserIDType(
				userID, historyType);
		List<Long> resultIDs = new ArrayList<Long>();
		List<WenJuanProposalDetailedBO> resultList = new ArrayList<WenJuanProposalDetailedBO>();
		for (WenJuanresultHistoryBO obj : resultObj) {
			resultIDs.add(obj.getWjGroupResultId());
		}
		List<WenJuanProposalBO> proposalList = new ArrayList<WenJuanProposalBO>();
		for (Long id : resultIDs) {
			WenJuanProposalBO pro = this.wenJuanProposalDao.selectByWJGroupResultID(id);
			if (pro != null) {
				proposalList.add(pro);
			}
		}
		for (WenJuanProposalBO proposalObj : proposalList) {
			long proposalID = proposalObj.getId() == null ? 0L : proposalObj.getId();
			WenJuanProposalDetailedBO detailObj = this.wenJuanProposalDetailedDao
					.selectOneByProposalIDAndType(proposalID, types);
			resultList.add(detailObj);
		}
		return resultList;
	}
	
	public List<WenJuanresultHistoryBO> listWenJuanHistoryByType(Long types){
		return wenJuanresultHistoryDao.listWenJuanHistoryByType(types);
	}
}
