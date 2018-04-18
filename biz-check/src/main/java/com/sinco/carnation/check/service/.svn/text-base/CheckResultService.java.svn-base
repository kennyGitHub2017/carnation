package com.sinco.carnation.check.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.bo.CheckResultDetailsBO;
import com.sinco.carnation.sns.bo.CheckResultGroupBO;
import com.sinco.carnation.sns.bo.CheckResultItemBO;
import com.sinco.carnation.sns.bo.CheckResultReplyBO;
import com.sinco.carnation.sns.dao.CheckResultDetailsDao;
import com.sinco.carnation.sns.dao.CheckResultGroupDao;
import com.sinco.carnation.sns.dao.CheckResultItemDao;
import com.sinco.carnation.sns.dao.CheckResultReplyDao;
import com.sinco.carnation.sns.model.CheckResultDetails;
import com.sinco.carnation.sns.model.CheckResultGroup;
import com.sinco.carnation.sns.model.CheckResultItem;
import com.sinco.carnation.sns.model.CheckResultReply;
import com.sinco.carnation.sns.vo.CheckResultGroupVO;
import com.sinco.carnation.sns.vo.CheckResultItemVO;
import com.sinco.carnation.sns.vo.CheckResultReplyVO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class CheckResultService {
	@Autowired
	UserCustomerDao userCustomerDao;
	@Autowired
	private CheckResultReplyDao checkResultReplyDao;
	@Autowired
	CheckResultGroupDao checkResultGroupDao;
	@Autowired
	private CheckResultItemDao checkResultItemDao;
	@Autowired
	private CheckResultDetailsDao checkResultDetailsDao;

	/**
	 * 搜索体检报告
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<CheckResultReplyBO> search(CheckResultReplyVO vo, MyPage<CheckResultReplyBO> page) {
		return checkResultReplyDao.search(vo, page);
	}

	/**
	 * 报告详情
	 * 
	 * @param replyId
	 * @return
	 */
	public CheckResultReplyBO detailed(Long replyId) {
		CheckResultReplyBO bo = get(replyId);
		bo.setUserCustomerBO(userCustomerDao.queryUserByUid(bo.getCreateBy()));
		bo.setCheckResultDetailsBOList(checkResultDetailsDao.findByReply(replyId));
		int normalNumber = 0, overproofNumber = 0;
		for (CheckResultDetailsBO crd : bo.getCheckResultDetailsBOList()) {
			if ("0".equals(crd.getResult()))
				normalNumber++;
			else
				overproofNumber++;
		}
		bo.setNormalNumber(normalNumber);
		bo.setOverproofNumber(overproofNumber);

		return bo;
	}

	/**
	 * 修改体检报告
	 * 
	 * @param record
	 */
	public void update(CheckResultReply record) {
		checkResultReplyDao.update(record);
	}

	/**
	 * 获取指定体检报告
	 * 
	 * @param id
	 * @return
	 */
	public CheckResultReplyBO get(java.lang.Long id) {
		return checkResultReplyDao.get(id);
	}

	/**
	 * 保存体检报告
	 * 
	 * @param reply
	 * @return
	 */
	public CheckResultReply resultReplySave(CheckResultReply reply) {
		return checkResultReplyDao.save(reply);
	}

	/**
	 * 搜索分类
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<CheckResultGroupBO> searchCheckResultGroupBO(CheckResultGroupVO vo,
			MyPage<CheckResultGroupBO> page) {
		return checkResultGroupDao.search(vo, page);
	}

	/**
	 * 查看某个分类
	 * 
	 * @param id
	 * @return
	 */
	public CheckResultGroupBO findCheckResultGroupBO(Long id) {
		return checkResultGroupDao.findOne(id);
	}

	/**
	 * 修改分类
	 * 
	 * @param record
	 */
	public void updateCheckResultGroup(CheckResultGroup record) {
		checkResultGroupDao.update(record);
	}

	/**
	 * 删除分类
	 * 
	 * @param id
	 */
	public void deleteCheckResultGroup(Long id) {
		checkResultGroupDao.delete(id);
	}

	/**
	 * 添加分类
	 */
	public CheckResultGroup saveCheckResultGroup(CheckResultGroup record) {
		record.setCreateTime(new Date());
		record.setIsDeleted(false);
		return checkResultGroupDao.save(record);
	}

	/**
	 * 分类列表
	 * 
	 * @return
	 */
	public List<CheckResultGroupBO> queryCheckResultGroupList() {
		return checkResultGroupDao.queryCheckResultGroupList();
	}

	/**
	 * 体检项列表
	 * 
	 * @param groupId
	 * @return
	 */
	public List<CheckResultItemBO> queryResultByGroupId(Long groupId) {
		return checkResultItemDao.queryResultByGroupId(groupId);
	}

	/**
	 * 常用体检项
	 * 
	 * @param usingId
	 * @return
	 */
	public List<CheckResultItemBO> queryResultByUsing(Long usingId) {
		return checkResultItemDao.queryResultByUsing(usingId);
	}

	/**
	 * 搜索体检项
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<CheckResultItemBO> searchCheckResultItemBO(CheckResultItemVO vo,
			MyPage<CheckResultItemBO> page) {
		return checkResultItemDao.search(vo, page);
	}

	/**
	 * 加载体检项实体
	 * 
	 * @param id
	 * @return
	 */
	public CheckResultItemBO loadCheckResultItemBO(Long id) {
		return checkResultItemDao.findOne(id);
	}

	/**
	 * 添加体检项
	 * 
	 * @param record
	 * @return
	 */
	public CheckResultItem saveCheckResultItem(CheckResultItem record) {
		record.setCreateTime(new Date());
		record.setUsing(1);

		return checkResultItemDao.save(record);
	}

	/**
	 * 修改体检项
	 * 
	 * @param record
	 */
	public void updateCheckResultItem(CheckResultItem record) {
		checkResultItemDao.update(record);
	}

	/**
	 * 删除体检项
	 * 
	 * @param id
	 */
	public void deleteCheckResultItem(Long id) {
		checkResultItemDao.delete(id);
	}

	/**
	 * 体检明细列表
	 * 
	 * @param replyId
	 * @param page
	 */
	public void queryResultDetailsList(Long replyId, MyPage<CheckResultDetailsBO> page) {
		page.setContent(checkResultDetailsDao.queryResultDetailsList(replyId, page));
	}

	/**
	 * 查询体检项结果
	 * 
	 * @param id
	 * @param result
	 * @return
	 */
	public int queryResultStatusCount(Long id, Integer result) {
		return checkResultDetailsDao.queryResultStatusCount(id, result);
	}

	/**
	 * 根据id查体检项信息
	 * 
	 * @param id
	 * @return
	 */
	public CheckResultItemBO queryResultItemById(Long id) {
		return checkResultItemDao.get(id);
	}

	/**
	 * 保存体检项
	 * 
	 * @param details
	 * @return
	 */
	@Transactional(readOnly = false)
	public CheckResultDetails savaResultDetails(CheckResultDetails details, Long replyId) {
		if (replyId == null) {
			return checkResultDetailsDao.save(details);
		}
		// 修改报告状态
		CheckResultReplyBO reply = this.get(replyId);
		reply.setStatus(1);
		reply.setResult("");
		this.update(reply);
		return checkResultDetailsDao.save(details);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public CheckResultDetailsBO queryCheckResultDetails(Long id) {
		return checkResultDetailsDao.get(id);
	}

	/**
	 * 搜索体检项
	 * 
	 * @param name
	 * @return
	 */
	public List<CheckResultItemBO> queryItemSearch(String name) {
		return checkResultItemDao.queryItemSearch(name);
	}

	/**
	 * 根据id查询体检报告
	 * 
	 * @param id
	 * @return
	 */
	public CheckResultReplyBO queryReplyDetails(Long id) {
		return checkResultReplyDao.get(id);
	}
}
