package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserRelationStatisBO;
import com.sinco.carnation.user.model.UserRelationStatis;
import com.sinco.carnation.user.model.UserRelationStatisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRelationStatisMapper {
    int countByExample(UserRelationStatisExample example);

    int deleteByExample(UserRelationStatisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRelationStatis record);

    int insertSelective(UserRelationStatis record);

    List<UserRelationStatisBO> selectByExample(UserRelationStatisExample example);

    UserRelationStatisBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRelationStatis record, @Param("example") UserRelationStatisExample example);

    int updateByExample(@Param("record") UserRelationStatis record, @Param("example") UserRelationStatisExample example);

    int updateByPrimaryKeySelective(UserRelationStatis record);

    int updateByPrimaryKey(UserRelationStatis record);
    
    List<UserRelationStatisBO> findByUid(Long uid);

    int countByLoginNames(List<String> loginNames);
    int countStoreByLoginNames(List<String> loginNames);
    
    
}