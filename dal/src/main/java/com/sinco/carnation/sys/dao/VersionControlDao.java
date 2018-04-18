package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.bo.VersionControlBO;
import com.sinco.carnation.sys.mapper.VersionControlMapper;
import com.sinco.carnation.sys.model.VersionControl;
import com.sinco.carnation.sys.model.VersionControlExample;
import com.sinco.carnation.sys.vo.VersionControlVO;
import com.sinco.dal.common.MyPage;

@Repository
public class VersionControlDao {

	@Autowired
	private VersionControlMapper mapper;

	/** generate code begin **/
	public List<VersionControlBO> findAll() {
		VersionControlExample example = new VersionControlExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		VersionControlExample example = new VersionControlExample();
		return mapper.countByExample(example);
	}

	public List<VersionControl> save(Iterable<VersionControl> entities) {
		List<VersionControl> list = new ArrayList<VersionControl>();
		for (VersionControl VersionControl : entities) {
			list.add(save(VersionControl));
		}
		return list;
	}

	public VersionControl save(VersionControl record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(VersionControl record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public VersionControlBO findOne(java.lang.Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Integer id) {
		VersionControlExample example = new VersionControlExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(VersionControl entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void deleteAll() {
		VersionControlExample example = new VersionControlExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public VersionControlBO findOneByTypeNew(int type) {
		return mapper.findOneByTypeNew(type);
	}

	public List<VersionControlBO> selectListByVO(MyPage<VersionControlBO> page, VersionControlVO vo) {
		return mapper.selectListByVO(page, vo);
	}
}
