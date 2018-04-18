package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.shop.model.TransportExample;
import com.sinco.carnation.shop.vo.TransportVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TransportMapper {

	List<TransportBO> findPageByType(MyPage<TransportBO> page, @Param("type") String type,
			@Param("storeId") Long storeId);

	int countByExample(TransportExample example);

	int deleteByExample(TransportExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Transport record);

	int insertSelective(Transport record);

	List<Transport> selectByExampleWithBLOBs(TransportExample example);

	List<Transport> selectByExample(TransportExample example);

	Transport selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Transport record, @Param("example") TransportExample example);

	int updateByExampleWithBLOBs(@Param("record") Transport record, @Param("example") TransportExample example);

	int updateByExample(@Param("record") Transport record, @Param("example") TransportExample example);

	int updateByPrimaryKeySelective(Transport record);

	int updateByPrimaryKeyWithBLOBs(Transport record);

	int updateByPrimaryKey(Transport record);

	List<TransportBO> selectByVo(@Param("vo") TransportVO vo);
}