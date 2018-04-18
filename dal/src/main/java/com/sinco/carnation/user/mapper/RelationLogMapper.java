package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.RelationLogBO;
import com.sinco.carnation.user.model.RelationLog;
import com.sinco.carnation.user.model.RelationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationLogMapper {
    int countByExample(RelationLogExample example);

    int deleteByExample(RelationLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RelationLog record);

    int insertSelective(RelationLog record);

    List<RelationLogBO> selectByExampleWithBLOBs(RelationLogExample example);

    List<RelationLogBO> selectByExample(RelationLogExample example);

    RelationLogBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RelationLog record, @Param("example") RelationLogExample example);

    int updateByExampleWithBLOBs(@Param("record") RelationLog record, @Param("example") RelationLogExample example);

    int updateByExample(@Param("record") RelationLog record, @Param("example") RelationLogExample example);

    int updateByPrimaryKeySelective(RelationLog record);

    int updateByPrimaryKeyWithBLOBs(RelationLog record);

    int updateByPrimaryKey(RelationLog record);
}