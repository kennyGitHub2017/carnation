package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.DocumentBO;
import com.sinco.carnation.sys.model.Document;
import com.sinco.carnation.sys.model.DocumentExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
	int countByExample(DocumentExample example);

	int deleteByExample(DocumentExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Document record);

	int insertSelective(Document record);

	List<DocumentBO> selectByExampleWithBLOBs(DocumentExample example);

	List<DocumentBO> selectByExample(DocumentExample example);

	DocumentBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

	int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentExample example);

	int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

	int updateByPrimaryKeySelective(Document record);

	int updateByPrimaryKeyWithBLOBs(Document record);

	int updateByPrimaryKey(Document record);

	List<DocumentBO> queryDocumetAllList(@Param("page") MyPage<DocumentBO> page);
}