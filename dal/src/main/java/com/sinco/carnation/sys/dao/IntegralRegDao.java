package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.IntegralRegBO;
import com.sinco.carnation.sys.mapper.IntegralRegMapper;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.model.IntegralRegExample;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.dal.common.MyPage;

@Repository
public class IntegralRegDao {

	@Autowired
	private IntegralRegMapper mapper;

	/** generate code begin **/
	public List<IntegralRegBO> findAll() {
		IntegralRegExample example = new IntegralRegExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		IntegralRegExample example = new IntegralRegExample();
		return mapper.countByExample(example);
	}

	public List<IntegralReg> save(Iterable<IntegralReg> entities) {
		List<IntegralReg> list = new ArrayList<IntegralReg>();
		for (IntegralReg IntegralReg : entities) {
			list.add(save(IntegralReg));
		}
		return list;
	}

	public IntegralReg save(IntegralReg record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(IntegralReg record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public IntegralRegBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public IntegralRegBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		IntegralRegExample example = new IntegralRegExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<IntegralRegBO> findAll(Iterable<Long> ids) {
		IntegralRegExample example = new IntegralRegExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(IntegralReg entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<IntegralReg> entities) {
		List<Long> ids = Lists.newArrayList();
		for (IntegralReg entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		IntegralRegExample example = new IntegralRegExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		IntegralRegExample example = new IntegralRegExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<IntegralRegBO> selectListByVO(MyPage<IntegralRegBO> page, IntegralRegVO vo) {
		return this.mapper.selectListByVO(page, vo);
	}

	public List<IntegralRegBO> checkIntegral(IntegralRegVO vo) {
		return this.mapper.checkIntegral(vo);
	}

	public IntegralRegBO findByType(String type) {
		IntegralRegExample example = new IntegralRegExample();
		example.createCriteria().andTypeEqualTo(type);
		List<IntegralRegBO> bos = this.mapper.selectByExample(example);
		return bos != null && bos.size() > 0 ? bos.get(0) : null;

	}

	/**
	 * 根据用户ID查询今日积分获取情况
	 * 
	 * @param userid
	 * @return
	 */
	public List<IntegralRegBO> selectRegByUserid(Long userid) {
		if (null != userid) {
			return this.mapper.selectRegByUserid(userid);
		}
		return null;
	}

	public List<IntegralRegBO> selectOtherRegByUserid(Long userid) {
		if (null != userid) {
			return this.mapper.selectOtherRegByUserid(userid);
		}
		return null;
	}

	/**
	 * 积分商城 过期商品下架
	 */
	public int changeShow() {
		return this.mapper.changeShow();
	}
	
	public List<IntegralRegBO> selectAllType(){
		return this.mapper.selectAllType();
	}
}
