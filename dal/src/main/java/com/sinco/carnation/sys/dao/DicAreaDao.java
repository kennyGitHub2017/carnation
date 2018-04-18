package com.sinco.carnation.sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.mapper.DicAreaMapper;
import com.sinco.carnation.sys.model.DicArea;
import com.sinco.carnation.sys.model.DicAreaExample;

/**
 * 
 * 数据访问接口
 * 
 */
@Repository
public class DicAreaDao {

	@Autowired
	private DicAreaMapper mapper;

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(DicArea record) {
		return mapper.insert(record);
	}

	public DicArea findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateById(DicArea record) {
		return mapper.updateByPrimaryKey(record);
	}

	public List<DicArea> findAll() {
		DicAreaExample example = new DicAreaExample();
		example.createCriteria().andCodeNotEqualTo("1").andCodeLike("1-%");
		return mapper.selectByExample(example);
	}
	
	public List<DicArea> findAllChenShi(Long pid) {
		return mapper.findChenShi(pid);
	}
	
	public DicArea findShen(Long pid) {
		return mapper.findShen(pid);
	}
	
}
