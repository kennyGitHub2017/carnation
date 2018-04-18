package com.sinco.carnation.sns.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.CheckClassBO;
import com.sinco.carnation.sns.mapper.CheckClassMapper;
import com.sinco.carnation.sns.model.CheckClass;
import com.sinco.carnation.sns.model.CheckClassExample;
import com.sinco.carnation.sns.vo.CheckClassVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckClassDao {

	@Autowired
	private CheckClassMapper mapper;

	public List<CheckClassBO> findAll() {
		return mapper.selectAll();
	}

	public List<CheckClassBO> findPageByVO(MyPage<CheckClassBO> page, CheckClassVO vo) {
		return this.mapper.findPageByVO(page, vo);
	}

	public List<CheckClass> findListByParentId(Long pid) {
		CheckClassExample ex = new CheckClassExample();
		ex.createCriteria().andParentIdEqualTo(pid).andIsDeletedEqualTo(false);
		return this.mapper.selectByExample(ex);
	}

	public CheckClass getById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public void update(CheckClass gc) {
		this.mapper.updateByPrimaryKeySelective(gc);
	}

	public void save(CheckClass cc) {
		this.mapper.insert(cc);
	}

	public List<CheckClass> countByName(String className, Long id, Long pid) {
		CheckClassExample ex = new CheckClassExample();
		CheckClassExample.Criteria c = ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE)
				.andClassNameEqualTo(className);
		if (id != null && id > 0) {
			c.andIdEqualTo(id);
		}
		if (pid != null && pid > 0) {
			c.andParentIdEqualTo(pid);
		} else {
			c.andParentIdEqualTo(new Long(0));
		}
		return mapper.selectByExample(ex);
	}

	public List<CheckClass> findByIds(Long... ids) {
		return mapper.findByIds(ids);
	}

	public void updateDeleteStatusByIds(List<Long> allListWithChildren) {
		this.mapper.updateDeleteStatusByIds(allListWithChildren);
	}

	public List<CheckClassBO> selectCheckClaaaList(Long parentId) {
		return mapper.selectCheckClaaaList(parentId);
	}
}
