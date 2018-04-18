package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.label.bo.LabelClassBO;
import com.sinco.carnation.label.dao.LabelClassDao;
import com.sinco.carnation.label.model.LabelClass;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class LabelClassService {
	@Autowired
	private LabelClassDao labelClassDao;

	public List<LabelClassBO> findByPage(MyPage<LabelClassBO> page) {
		return labelClassDao.findByPage(page);
	}

	public List<LabelClassBO> findAllOrder() {
		// TODO Auto-generated method stub
		return labelClassDao.findAllOrder();
	}

	public LabelClass getObjById(long id) {
		LabelClass articleClass = this.labelClassDao.get(id);
		if (articleClass != null) {
			return articleClass;
		}
		return null;
	}

	public boolean save(LabelClass articleClass) {
		this.labelClassDao.save(articleClass);
		return true;

	}

	public boolean delete(Long... ids) {
		for (Long id : ids) {
			delete(id);
		}
		return true;
	}

	/**
	 * 删除，并删除所有子节点
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id) {
		int result = this.labelClassDao.remove(id);
		if (result > 0) {
			List<LabelClassBO> list = labelClassDao.findAllChild(id);
			List<Long> ids = new ArrayList<Long>();
			for (LabelClassBO ac : list) {
				ids.add(ac.getId());
			}
			if (ids.size() > 0) {
				labelClassDao.deleteByIds(ids);
			}
		}
		return true;
	}

	public List<LabelClassBO> findByParent(long parnetId) {
		return labelClassDao.findByParent(parnetId);
	}

	public int countByName(String className, Long id) {
		// TODO Auto-generated method stub
		return labelClassDao.countByName(className, id);
	}
}
