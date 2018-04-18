package com.sinco.carnation.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.user.bo.FeedbackBO;
import com.sinco.carnation.user.dao.FeedbackDao;
import com.sinco.carnation.user.model.Feedback;
import com.sinco.carnation.user.vo.FeedbackVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public void query(FeedbackVO vo, MyPage<FeedbackBO> page) {
		feedbackDao.query(vo, page);
	}

	public FeedbackBO fetch(Long id) {
		return feedbackDao.findOne(id);
	}

	/**
	 * 管理员处理
	 * 
	 * @param id
	 * @param status
	 * @param page
	 * @throws ServiceException
	 */
	public void deal(Long id, Integer status) throws ServiceException {
		if (status != 1 && status != 2)
			throw new ServiceException("参数有误");

		Feedback feedback = feedbackDao.findOne(id);
		if (null == feedback || feedback.getStatus() != 0)
			throw new ServiceException("参数有误");

		feedback.setStatus(status);
		feedback.setDealTime(new Date());

		feedbackDao.save(feedback);

	}

	/**
	 * 保存问题反馈
	 * 
	 * @param feed
	 * @return
	 */
	@Transactional(readOnly = false)
	public Feedback saveFeedBack(Feedback feed) {
		return feedbackDao.save(feed);
	}

	public List<FeedbackBO> findForExcel(MyPage<FeedbackBO> page, FeedbackVO vo) {
		return feedbackDao.query(vo, page);
	}
}
