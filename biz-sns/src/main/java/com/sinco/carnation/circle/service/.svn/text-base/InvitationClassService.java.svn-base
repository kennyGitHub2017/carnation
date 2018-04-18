package com.sinco.carnation.circle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.bo.InvitationClassBO;
import com.sinco.carnation.sns.dao.InvitationClassDao;
import com.sinco.carnation.sns.model.InvitationClass;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class InvitationClassService {

	@Autowired
	private InvitationClassDao invitationClassDao;

	/**
	 * 分页查询
	 * 
	 * @param name
	 * @param parentId
	 * @param page
	 */
	public void queryInvitationClassPage(String name, Long parentId, MyPage<InvitationClassBO> page) {
		List<InvitationClassBO> lists = this.invitationClassDao.queryInvitationClass(name, parentId, page);

		page.setContent(lists);
	}

	public List<InvitationClassBO> queryInvitationClassBoByParentId(Long parentId) {
		return this.invitationClassDao.queryInvitationClassBoByParentId(parentId);
	}

	@Transactional(readOnly = false)
	public void save(InvitationClass invitationClass) {
		this.invitationClassDao.save(invitationClass);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		this.invitationClassDao.delete(id);
	}

	public InvitationClass getById(Long id) {
		return this.invitationClassDao.get(id);
	}

	@Transactional(readOnly = false)
	public void update(InvitationClass record) {
		this.invitationClassDao.update(record);
	}

	public Long countChild(Long id) {
		return this.invitationClassDao.countChild(id);
	}
}
