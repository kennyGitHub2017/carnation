package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.ShareBO;
import com.sinco.carnation.sys.model.Share;
import com.sinco.carnation.sys.model.ShareExample;
import com.sinco.carnation.sys.vo.ShareVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShareMapper {
    int countByExample(ShareExample example);

    int deleteByExample(ShareExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Share record);

    int insertSelective(Share record);

    List<ShareBO> selectByExampleWithBLOBs(ShareExample example);

    List<ShareBO> selectByExample(ShareExample example);

    ShareBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByExampleWithBLOBs(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByExample(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKeyWithBLOBs(Share record);

    int updateByPrimaryKey(Share record);
    
    public ShareBO findOneByGoodsId(@Param("goodsId")Long id);

	public List<ShareBO> listByVO(@Param("vo")ShareVO vo);
}