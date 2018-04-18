package com.sinco.carnation.sys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sys.bo.VersionControlBO;
import com.sinco.carnation.sys.model.VersionControl;
import com.sinco.carnation.sys.vo.VersionControlVO;
import com.sinco.carnation.sys.dao.VersionControlDao;
import com.sinco.dal.common.MyPage;

@Service
public class VersionControlService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(VersionControlService.class);

	@Autowired
	private VersionControlDao versionControlDao;

	/*	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)*/

	public VersionControlBO findOneById(int id) {
		return versionControlDao.findOne(id);
	}

	public VersionControlBO findOneByTypeNew(int type) {
		VersionControlBO versionControlBO = versionControlDao.findOneByTypeNew(type);
		return versionControlBO;
	}

	public List<VersionControlBO> selectListByVO(MyPage<VersionControlBO> page, VersionControlVO vo) {
		List<VersionControlBO> list = versionControlDao.selectListByVO(page, vo);
		page.setContent(list);
		return list;
	}

	public boolean update(VersionControl record) {
		try {
			versionControlDao.update(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean save(VersionControl record) {
		try {
			versionControlDao.save(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
