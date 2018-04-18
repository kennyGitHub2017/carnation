package com.sinco.carnation.user.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.PhysicalValuationBO;
import com.sinco.carnation.user.mapper.PhysicalValuationMapper;
import com.sinco.carnation.user.model.PhysicalValuation;
import com.sinco.carnation.user.model.PhysicalValuationExample;
import com.sinco.carnation.user.vo.PhysicalValuationVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PhysicalValuationDao {

	@Autowired
	private PhysicalValuationMapper mapper;

	/** generate code begin **/
	public List<PhysicalValuationBO> findAll() {
		PhysicalValuationExample example = new PhysicalValuationExample();
		return mapper.selectByExample(example);
	}

	List<PhysicalValuationBO> findAll(Iterable<Long> ids) {
		PhysicalValuationExample example = new PhysicalValuationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalValuationExample example = new PhysicalValuationExample();
		return mapper.countByExample(example);
	}

	/*	public List<PhysicalValuation> save(Iterable<PhysicalValuation> entities){
			List<PhysicalValuation> list=new ArrayList<PhysicalValuation>();
			for (PhysicalValuation PhysicalValuation : entities) {
				list.add(save(PhysicalValuation));
			}
			return list;
		}
	*/
	public void update(PhysicalValuation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PhysicalValuationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalValuationExample example = new PhysicalValuationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalValuation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalValuation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalValuation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalValuationExample example = new PhysicalValuationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalValuationExample example = new PhysicalValuationExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/** kenny **/
	public List<PhysicalValuationBO> findList(PhysicalValuationVO vo, MyPage<PhysicalValuationBO> page) {
		return this.mapper.selectListByVo(vo, page);
	}

	public List<PhysicalValuationBO> findList() {
		return this.mapper.selectList();
	}

	public void save(PhysicalValuationVO vo) {
		if (vo.getId() == null) {
			mapper.insert(vo);
		} else {
			mapper.updateByPrimaryKeySelective(vo);
		}
	}

	/**
	 * 根据体检项id查询
	 * 
	 * @param id
	 * @return
	 */
	public List<PhysicalValuationBO> findByPhysicalTypeId(java.lang.Long typeId) {
		PhysicalValuationExample example = new PhysicalValuationExample();
		example.createCriteria().andPhysicalTypeEqualTo(typeId);
		example.setOrderByClause(" range_min asc");
		return mapper.selectByExample(example);
	}

	public List<PhysicalValuationBO> selectCheckResultByVo(PhysicalValuationVO vo,
			MyPage<PhysicalValuationBO> page) {
		return this.mapper.selectCheckResultByVo(vo, page);
	}

}
