package com.sinco.carnation.wenjuan.service;

import java.util.ArrayList;
import java.util.List;

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
import com.sinco.carnation.sns.vo.WenJuanGroupVO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.UserCustomer;

/**
 * 
 */
@Service
public class WenJuanGropService {

	@Autowired
	private WenJuanGroupDao wenJuanGropDao;

	@Autowired
	private WenJuanQuestionDao wenJuanQuestionDao;

	@Autowired
	private WenJuanQuestionOptionDao wenJuanQuestionOptionDao;

	@Autowired
	private WenJuanGroupResultDao wenJuanGroupResultDao;

	@Autowired
	private WenJuanresultHistoryDao wenJuanresultHistoryDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private WenJuanProposalDao wenJuanProposalDao;

	@Autowired
	private WenJuanProposalDetailedDao wenJuanProposalDetailedDao;

	@Autowired
	private UserHealthtaskDao userHealthTaskDao;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public WenJuanGroupBO getWenJuan(long themeID) {
		WenJuanGroup obj = new WenJuanGroup();
		obj.setIsDeleted(false);
		obj.setWjThemeID(themeID);
		List<WenJuanGroupBO> list = this.wenJuanGropDao.getWenJuanGroupAll(obj);
		if (list != null && list.size() > 0) {
			WenJuanGroupBO result_Obj = new WenJuanGroupBO();

			List<Long> groupIDList = new ArrayList<Long>();
			for (WenJuanGroupBO group : list) {
				groupIDList.add(group.getId());
			}
			List<WenJuanQuestionBO> questionList = this.wenJuanQuestionDao.queryQuestionListByID(groupIDList);
			long questionID = 0L;
			List<WenJuanQuestionOptionBO> question_Option_List = null;
			List<WenJuanQuestionBO> returl_list = new ArrayList<WenJuanQuestionBO>();
			for (WenJuanQuestionBO question : questionList) {
				questionID = question.getId();
				question_Option_List = this.wenJuanQuestionOptionDao.getOpetionByQuestionID(questionID);
				question.setQuestion_option_List(question_Option_List);
				returl_list.add(question);
			}
			result_Obj.setQuestionList(returl_list);
			return result_Obj;
		}
		return new WenJuanGroupBO();
	}

	/**
	 * 获取基本问卷调查题及其题目选项
	 * 
	 * @param themeID
	 * @return
	 */
	public List<WenJuanGroupBO> getWenJuanList(Long themeID) {
		List<WenJuanGroupBO> resultList = new ArrayList<WenJuanGroupBO>();

		WenJuanGroup obj = new WenJuanGroup();
		obj.setIsDeleted(false);
		obj.setWjThemeID(themeID);
		// 获取问卷组
		List<WenJuanGroupBO> list = this.wenJuanGropDao.getWenJuanGroupAll(obj);
		for (WenJuanGroupBO group : list) {
			WenJuanGroupBO tempObj = group;
			List<Long> groupIDList = new ArrayList<Long>();
			groupIDList.add(group.getId());
			// 获取选题
			List<WenJuanQuestionBO> questionList = this.wenJuanQuestionDao.queryQuestionListByID(groupIDList);

			long questionID = 0L;
			List<WenJuanQuestionOptionBO> question_Option_List = null;
			List<WenJuanQuestionBO> returl_list = new ArrayList<WenJuanQuestionBO>();

			for (WenJuanQuestionBO question : questionList) {
				questionID = question.getId();
				// 获取选题选项
				question_Option_List = this.wenJuanQuestionOptionDao.getOpetionByQuestionID(questionID);
				question.setQuestion_option_List(question_Option_List);
				returl_list.add(question);
			}
			tempObj.setQuestionList(returl_list);
			resultList.add(tempObj);
		}
		return resultList;
	}

	/**
	 * 基本健康评估结果
	 * 
	 * @param questionID
	 *            问卷调查题ID
	 * @param totalScroe
	 *            总分数
	 * @return
	 */
	public WenJuanresultHistoryBO saveWenJuanResult(Long themeID, Integer totalScroe, Long userID) {
		synchronized (this) {
			logger.info("<<<<<< themeID:" + themeID + " totalScroe:" + totalScroe);
			// 获取问卷调查对应的评分标准
			List<WenJuanGroupResultBO> list = this.wenJuanGroupResultDao
					.select_groupResults_byThemeID(themeID);

			if (list == null || list.size() == 0) {
				return null;
			}

			Long groupResultID = new Long("0");
			WenJuanGroupResultBO wenJuanGroupResult = null;
			for (WenJuanGroupResultBO obj : list) {
				int startScore = obj.getStartScore();
				int endScore = obj.getEndScore();
				if (totalScroe >= startScore && totalScroe <= endScore) {
					groupResultID = obj.getId();
					wenJuanGroupResult = obj;
					break;
				}
			}

			long wenJuan = 10L;
			// 获取用户的问卷调查记录，如果已有记录，则假删除
			// WenJuanresultHistoryBO obj =
			// this.wenJuanresultHistoryDao.select_result_by_UserID(userID,wenJuan).get(0);
			List<WenJuanresultHistoryBO> historyList = this.wenJuanresultHistoryDao.select_result_by_UserID(
					userID, wenJuan);
			if (historyList != null && historyList.size() > 0) {
				long id = historyList.get(0).getId();
				this.wenJuanresultHistoryDao.update_result_deleted(id);
			}
			// 用户问卷调查记录日子保存
			WenJuanresultHistory history = new WenJuanresultHistory();
			history.setIsDeleted(Long.parseLong("0"));
			history.setTotalScore(totalScroe);
			history.setUserId(userID);
			history.setWjGroupResultId(groupResultID);
			history.setTypes(wenJuan);

			this.wenJuanresultHistoryDao.save_Result_History(history);

			WenJuanresultHistoryBO bo = new WenJuanresultHistoryBO();
			bo.setTotalScore(totalScroe); // 健康评估分数
			bo.setGroupResultBo(wenJuanGroupResult); // 健康状态

			return bo;
		}

	}

	/**
	 * 获取调查建议详细
	 * 
	 * @param userID
	 *            用户ID
	 * @param proposalID
	 *            调查建议题ID
	 * @return
	 */
	public WenJuanresultHistoryBO getHealthAssesDetailed(Long userID, String proposalID) {
		List<WenJuanProposalDetailedBO> proposalDetail_list = this.wenJuanProposalDetailedDao
				.select_ProposalDetailed_By_ProposalID(Long.parseLong(proposalID));
		WenJuanresultHistoryBO history = this.wenJuanresultHistoryDao.select_result_by_UserID(userID, 10L)
				.get(0);

		if (proposalDetail_list != null && proposalDetail_list.size() > 0 && history != null) {
			long groupResultID = history.getWjGroupResultId();
			WenJuanGroupResultBO groupResultBO = this.wenJuanGroupResultDao.findOne(groupResultID);

			UserCustomer userCustomer = this.userCustomerDao.findById(userID);
			WenJuanresultHistoryBO bo1 = new WenJuanresultHistoryBO();
			/* 获取健康任务 start */
			int task_num = 3;
			List<UserHealthtaskBO> taskList = this.userHealthTaskDao.getHealthTaskListList(task_num);
			/* 获取健康任务 end */
			bo1.setUserCustomer(userCustomer);
			bo1.setTotalScore(history.getTotalScore());
			bo1.setGroupResultBo(groupResultBO);
			bo1.setProposalDetailedBO_List(proposalDetail_list);
			bo1.setUserHealthtaskBO_List(taskList);
			return bo1;
		}
		return null;
	}

	public WenJuanresultHistoryBO getHealthProposal(Long userID) {
		WenJuanresultHistoryBO bo = this.wenJuanresultHistoryDao.select_result_by_UserID(userID);
		if (bo != null) {
			long groupResultID = bo.getWjGroupResultId();
			WenJuanGroupResultBO groupResultBO = this.wenJuanGroupResultDao.findOne(groupResultID);
			List<WenJuanProposalBO> proposalBO_List = this.wenJuanProposalDao
					.select_proposal_by_groupResultID(groupResultID);
			// 获取当前用户
			UserCustomer userCustomer = this.userCustomerDao.findById(userID);
			bo.setUserCustomer(userCustomer);
			bo.setProposalBO_List(proposalBO_List);
			bo.setGroupResultBo(groupResultBO);
		}
		return null;
	}

	public WenJuanresultHistoryBO queryQuestionnairByUid(Long userID) {
		// WenJuanresultHistoryBO historyBO =
		// this.wenJuanresultHistoryDao.select_result_by_UserID(userID,10L).get(0);
		List<WenJuanresultHistoryBO> historyList = this.wenJuanresultHistoryDao.select_result_by_UserID(
				userID, 10L);
		WenJuanresultHistoryBO historyBO = null;
		if (historyList != null && historyList.size() > 0) {
			historyBO = historyList.get(0);
			long groupResultID = historyBO.getWjGroupResultId();
			WenJuanGroupResultBO groupResultBO = this.wenJuanGroupResultDao.findOne(groupResultID);
			/*
			int daiGaiJin = WenJuanProposalBO.proposalType_DaiGaiJing; //待改进
			int jianYi = WenJuanProposalBO.proposalType_JianYi;   //建议
			 */
			List<WenJuanProposalBO> daiGaiJin_List = this.wenJuanProposalDao.selectByGroupResultIDTypeDao(
					groupResultID, null);
			// List<WenJuanProposalBO> jianYi_List =
			// this.wenJuanProposalDao.selectByGroupResultIDTypeDao(groupResultID, jianYi);

			// historyBO.setJianYi_List(jianYi_List);
			historyBO.setProposalBO_List(daiGaiJin_List);
			historyBO.setGroupResultBo(groupResultBO);
		}
		return historyBO;
	}

	public boolean query_JiBing_History(long userID) {
		long type = 20L;
		List<WenJuanresultHistoryBO> obj = this.wenJuanresultHistoryDao.select_result_by_UserIDType(userID,
				type);
		if (obj != null && obj.size() > 0) {
			return true;
		}
		return false;
	}

	public WenJuanGroupBO query_WenJuanGroupByID(Long id) {
		WenJuanGroupBO bo = null;
		bo = this.wenJuanGropDao.findOne(id);
		return bo;
	}

	public int updateWenJuanGroupByID(WenJuanGroupVO vo) {
		return this.wenJuanGropDao.updateWenJuanByID(vo);
	}

	public int deleteByID(Long id) {
		this.wenJuanGropDao.delete(id);
		return 0;
	}

	/*记录入库
	this.wenJuanresultHistoryDao.save_Result_History(history);
	//获取当前用户
	UserCustomer userCustomer = this.userCustomerDao.findById(userID);
	//获取评分结果的建议信息
	List<WenJuanProposalBO> list_Proposal = this.wenJuanProposalDao.select_proposal_by_groupResultID(groupResultID);
	
	for(WenJuanProposalBO proposal:list_Proposal)
	{
		Long proposalID = proposal.getId();
		List<WenJuanProposalDetailedBO> list00 
			= this.wenJuanProposalDetailedDao.select_ProposalDetailed_By_ProposalID(proposalID);
		proposal.setDetailedList(list00);  //建议信息详细信息
	}
	
	wenJuanGroupResult.setProposal_List(list_Proposal);
	
	WenJuanresultHistoryBO bo = new WenJuanresultHistoryBO();
	bo.setUserCustomer(userCustomer);  //当前用户
	bo.setGroupResultBo(wenJuanGroupResult);  //健康评估
	bo.setTotalScore(totalScroe);  //总分数
	*/

}
