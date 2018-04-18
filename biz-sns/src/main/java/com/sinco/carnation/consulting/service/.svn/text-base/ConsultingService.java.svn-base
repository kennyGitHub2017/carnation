package com.sinco.carnation.consulting.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sns.bo.ConsultingRepayBO;
import com.sinco.carnation.sns.bo.ExpertKnowledgeBO;
import com.sinco.carnation.sns.bo.KnowledgeClassBO;
import com.sinco.carnation.sns.dao.ConsultingDao;
import com.sinco.carnation.sns.dao.ConsultingRepayDao;
import com.sinco.carnation.sns.dao.ExpertKnowledgeDao;
import com.sinco.carnation.sns.dao.KnowledgeClassDao;
import com.sinco.carnation.sns.model.Consulting;
import com.sinco.carnation.sns.model.ConsultingRepay;
import com.sinco.carnation.sns.model.ExpertKnowledge;
import com.sinco.carnation.sns.model.KnowledgeClass;
import com.sinco.carnation.sns.vo.ConsultingVO;
import com.sinco.dal.common.MyPage;
import com.sinco.messager.mobile.MobileMessageHandler;
import com.sinco.messager.mobile.jpush.AliasMobileChannel;
import com.sinco.messager.mobile.jpush.MessageMobileMessage;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional(readOnly = true)
public class ConsultingService {

	@Autowired
	private ConsultingDao consultingDao;

	@Autowired
	private ConsultingRepayDao consultingRepayDao;
	@Autowired
	private ExpertKnowledgeDao expertKnowledDao;
	@Autowired
	private KnowledgeClassDao knowDao;

	@Resource(name = "jpushMobileMessageHandler")
	private MobileMessageHandler mobileMessageHandler;

	public ConsultingBO selectConsultingDetailById(Long id) {
		ConsultingBO consultingBO = consultingDao.selectConsultingById(id);
		if (consultingBO != null) {
			List<ConsultingRepayBO> listRepay = consultingRepayDao.consultReplyList(id);
			consultingBO.setListRepay(listRepay);
		}
		return consultingBO;
	}

	public Consulting selectConsultingById(Long id) {
		Consulting consulting = consultingDao.selectConsultingModelById(id);
		return consulting;
	}

	public void selectConsultingPageByUserId(Long userId, MyPage<ConsultingBO> page) {
		page.setContent(consultingDao.selectConsultingPageByUserId(userId, page));
	}

	@Transactional(readOnly = false)
	public Consulting saveConsulting(Consulting consulting) {
		return consultingDao.save(consulting);
	}

	@Transactional(readOnly = false)
	public ConsultingRepay saveConsultingRepay(ConsultingRepay consulting, Long userid) {
		ConsultingRepay consulting2 = consultingRepayDao.save(consulting);
		// 修改问题标记和回复时间
		Consulting con = new Consulting();
		con.setUpdateTime(new Date());
		con.setId(consulting.getConsultingId());
		con.setMark("1");
		con.setReplyUserId(userid);
		consultingDao.updateConsulting(con);
		return consulting2;
	}

	public void queryConsulListByExp(Long uid, ConsultingVO vo, MyPage<ConsultingBO> page) {
		vo.setExpertsUserId(uid);
		List<ConsultingBO> list = consultingDao.queryConsulListByExp(uid, vo, page);
		page.setContent(list);
	}

	public void queryConsulList(ConsultingVO vo, MyPage<ConsultingBO> page) {
		consultingDao.queryConsulList(vo, page);
	}

	public ConsultingBO queryConsulDetails(Long conId) {
		return consultingDao.queryConsulDetails(conId);
	}

	public List<ConsultingRepayBO> consultReplyList(Long conId) {
		return consultingRepayDao.consultReplyList(conId);
	}

	@Transactional(readOnly = false)
	public int repyConsulting(String id, String content, String userId) {
		ConsultingRepay repay = new ConsultingRepay();
		repay.setContent(content);
		repay.setConsultingId(Long.parseLong(id));
		repay.setCreateTime(new Date());
		repay.setCurrentUserId(userId);
		repay.setIsDeleted(false);
		int num = consultingRepayDao.insert(repay);
		// 修改问题标记和回复时间
		Consulting consulting = new Consulting();
		consulting.setUpdateTime(new Date());
		consulting.setId(Long.parseLong(id));
		consulting.setMark("0");
		consulting.setReplyUserId(Long.parseLong(userId));
		consultingDao.updateConsulting(consulting);
		return num;
	}

	/**
	 * 发送回复的消息
	 * 
	 * @param consulting
	 * @param cr
	 */
	public void sendRepayMessage(Consulting consulting, ConsultingRepay cr) {
		MessageMobileMessage message = new MessageMobileMessage("您咨询的问题" + consulting.getTitle()
				+ "有了新的回复，请去查看");

		// 附加参数，需要什么自己加
		Map<String, String> exts = Maps.newHashMap();
		exts.put("id", String.valueOf(consulting.getId()));
		exts.put("messageType", "1");
		exts.put("replyTime", cr.getCreateTime().toString());
		message.setExts(exts);
		// message.setMessage("您咨询的问题"+consulting.getTitle()+"有了新的回复，请去查看！");

		// 消息的渠道分为 Alias 和 tag ,消息内容分为 alert 和 message
		mobileMessageHandler.sendMessage(new AliasMobileChannel(String.valueOf(consulting.getUserId())),
				message);
	}

	public ConsultingRepay selectById(Long id) {
		return consultingRepayDao.selectById(id);
	}

	public List<ConsultingBO> queryNotDoConsulListByExp(Long id) {
		return consultingDao.queryNotDoConsulListByExp(id);
	}

	public void queryConsultingByExpId(Long expId, String title, MyPage<ConsultingBO> page) {
		page.setContent(consultingDao.queryConsultingByExpId(expId, title, page));
	}

	public void queryExpertKnowledgeList(String title, MyPage<ExpertKnowledgeBO> page) {
		page.setContent(expertKnowledDao.queryExpertKnowledgeList(title, page));
	}

	public ExpertKnowledgeBO getByExpertKnowledge(Long id) {
		return expertKnowledDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void knowledgeSave(ExpertKnowledge knowledge) {
		expertKnowledDao.save(knowledge);
	}

	@Transactional(readOnly = false)
	public void knowledgeSave(String ids) {
		String[] idList = ids.split(",");
		for (String id : idList) {
			expertKnowledDao.delete(CommUtil.null2Long(id));
		}
	}

	public void queryKnowClassAll(String className, MyPage<KnowledgeClassBO> page) {
		page.setContent(knowDao.queryKnowClassAll(className, page));
	}

	public List<KnowledgeClassBO> findAll() {
		return knowDao.findAll();
	}

	public KnowledgeClassBO knowledgeClassDetails(String id) {
		return knowDao.findOne(CommUtil.null2Long(id));
	}

	@Transactional(readOnly = false)
	public void knowledgeClassSave(KnowledgeClass knowledgeClass) {
		knowDao.save(knowledgeClass);
	}

	@Transactional(readOnly = false)
	public void knowledgeClassDel(String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			knowDao.delete(CommUtil.null2Long(id));
		}
	}

	public List<ExpertKnowledgeBO> query(String id) {
		return expertKnowledDao.queryKnowledgeByclassId(CommUtil.null2Long(id));
	}

	public List<ExpertKnowledgeBO> search(String id, String name) {
		return expertKnowledDao.searchKnowList(id, name);
	}
}
