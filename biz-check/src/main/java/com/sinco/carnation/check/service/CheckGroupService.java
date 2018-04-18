package com.sinco.carnation.check.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.dao.CheckClassGroupDao;
import com.sinco.carnation.sns.dao.CheckGroupDao;
import com.sinco.carnation.sns.model.CheckClassGroup;
import com.sinco.carnation.sns.model.CheckGroup;
import com.sinco.carnation.sns.vo.CheckGroupVO;
import com.sinco.dal.common.MyPage;

@Service
public class CheckGroupService {

	@Autowired
	private CheckGroupDao checkGroupDao;

	@Autowired
	private CheckClassGroupDao checkClassGroupDao;

	@Autowired
	private CheckClassService checkClassService;

	public CheckGroup selectByPrimaryKey(Long id) {
		return checkGroupDao.selectByPrimaryKey(id);
	}

	public MyPage<CheckGroupBO> findPageByVO(CheckGroupVO vo, MyPage<CheckGroupBO> page) {
		if (vo.getClassId() != null) {
			List<Long> classIds = checkClassService.getChildsByClassId(vo.getClassId());
			if (null != classIds && classIds.size() > 0) {
				vo.setClassIds(classIds);
			}
		}
		List<CheckGroupBO> list = checkGroupDao.findList(vo, page);
		page.setContent(list);
		return page;
	}

	public CheckGroupBO findById(Long id) {
		return checkGroupDao.selectById(id);
	}

	@Transactional
	public void addCheckGroup(CheckGroupVO vo, Long userId) {
		CheckGroup checkGroup = new CheckGroup();
		BeanUtils.copyProperties(vo, checkGroup);
		checkGroup.setCreateBy(userId);
		checkGroup.setCreateTime(new Date());
		checkGroup.setIsDeleted(false);

		checkGroup.setIsClosed((byte) 1);// 添加自测题是默认保持关闭
		checkGroupDao.insertSelective(checkGroup);

		CheckClassGroup checkClassGroup = new CheckClassGroup();
		checkClassGroup.setGroupId(checkGroup.getId());
		checkClassGroup.setClassId(vo.getClassId());
		checkClassGroup.setCreateBy(userId);
		checkClassGroup.setCreateTime(new Date());
		checkClassGroupDao.insertSelective(checkClassGroup);
		vo.setId(checkGroup.getId());
	}

	public void updateCheckGroup(CheckGroupVO vo, Long userId) {
		CheckGroup checkGroup = new CheckGroup();
		BeanUtils.copyProperties(vo, checkGroup);
		vo.setUpdateBy(userId);
		vo.setUpdateTime(new Date());
		checkGroupDao.updateById(checkGroup);
		if (null != vo.getClassId()) {
			checkClassGroupDao.updateClassByGroupId(vo.getClassId(), vo.getOldClassId(), vo.getId());
		}
	}

	@Transactional
	public void batchDelete(String[] ids, Long userId) {
		if (null != ids && ids.length > 0) {
			for (String idStr : ids) {
				CheckGroup checkGroup = new CheckGroup();
				checkGroup.setId(CommUtil.null2Long(idStr));
				checkGroup.setUpdateBy(userId);
				checkGroup.setUpdateTime(new Date());
				checkGroup.setIsDeleted(true);
				checkGroupDao.updateById(checkGroup);
			}
		}
	}

	@Transactional
	public void batchUpdateIsClosed(String[] ids, Long userId, int type) {
		if (null != ids && ids.length > 0) {
			for (String idStr : ids) {
				CheckGroup checkGroup = new CheckGroup();
				checkGroup.setId(CommUtil.null2Long(idStr));
				checkGroup.setUpdateBy(userId);
				checkGroup.setUpdateTime(new Date());
				if (type == 0) {// 开启
					checkGroup.setIsClosed((byte) 0);
				} else if (type == 1) {// 关闭
					checkGroup.setIsClosed((byte) 1);
				}
				checkGroupDao.updateById(checkGroup);
			}
		}
	}

	public CheckGroup findBySequence(Long id) {
		List<CheckGroup> groupList = checkGroupDao.findBySequence(id);
		if (groupList != null && !groupList.isEmpty()) {
			CheckGroup group = groupList.get(0);
			return group;
		}

		return null;
	}

}
