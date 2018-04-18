package com.sinco.carnation.user.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.PhysicalKeyWordBO;
import com.sinco.carnation.user.bo.PhysicalKeyWordTypeBO;
import com.sinco.carnation.user.mapper.PhysicalKeyWordMapper;
import com.sinco.carnation.user.model.PhysicalKeyWord;
import com.sinco.carnation.user.model.PhysicalKeyWordExample;
import com.sinco.carnation.user.vo.PhysicalKeyWordVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PhysicalKeyWordDao {

	@Autowired
	private PhysicalKeyWordMapper mapper;

	/** generate code begin **/
	public List<PhysicalKeyWordBO> findAll() {
		PhysicalKeyWordExample example = new PhysicalKeyWordExample();
		return mapper.selectByExample(example);
	}

	List<PhysicalKeyWordBO> findAll(Iterable<Long> ids) {
		PhysicalKeyWordExample example = new PhysicalKeyWordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalKeyWordExample example = new PhysicalKeyWordExample();
		return mapper.countByExample(example);
	}

	/*	public List<PhysicalKeyWord> save(Iterable<PhysicalKeyWord> entities){
			List<PhysicalKeyWord> list=new ArrayList<PhysicalKeyWord>();
			for (PhysicalKeyWord PhysicalKeyWord : entities) {
				list.add(save(PhysicalKeyWord));
			}
			return list;
		}*/

	public PhysicalKeyWord save(PhysicalKeyWordVO vo) {
		if (vo.getId() == null) {
			mapper.insert(vo);
		} else {
			mapper.updateByPrimaryKeySelective(vo);
		}
		return vo;
	}

	public void update(PhysicalKeyWord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PhysicalKeyWordBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalKeyWordExample example = new PhysicalKeyWordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalKeyWord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalKeyWord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalKeyWord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalKeyWordExample example = new PhysicalKeyWordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalKeyWordExample example = new PhysicalKeyWordExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<PhysicalKeyWordBO> selectByVo(PhysicalKeyWordVO vo, MyPage<PhysicalKeyWordBO> page) {
		return this.mapper.selectListByVo(vo, page);
	}

	public List<PhysicalKeyWordBO> selectAll() {
		return this.mapper.selectAll();
	}

	public List<PhysicalKeyWordTypeBO> selectKeyWordTypeList() {
		return this.mapper.selectKeyWordTypeList();
	}

	public List<PhysicalKeyWord> findKeyWordByType(Integer type) {
		return mapper.findKeyWordByType(type);
	}

	/**
	 * 根据关联类型和关联表ID获取PhysicalKeyWord对象
	 * 
	 * @param typeCode
	 *            关联类型 1:体检建议 2:任务 3:帖子 4:商品 5:服务
	 * @param typeId
	 *            关联表的id
	 * 
	 * @return
	 */
	public List<PhysicalKeyWord> findByTypeCodeAndId(Long typeCode, Long typeId) {
		return mapper.findByTypeCodeAndId(typeCode, typeId);
	}
}
