package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.UserSawGoodsBO;
import com.sinco.carnation.shop.model.UserSawGoods;
import com.sinco.carnation.shop.model.UserSawGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSawGoodsMapper {
    int countByExample(UserSawGoodsExample example);

    int deleteByExample(UserSawGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSawGoods record);

    int insertSelective(UserSawGoods record);

    List<UserSawGoodsBO> selectByExample(UserSawGoodsExample example);

    UserSawGoodsBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSawGoods record, @Param("example") UserSawGoodsExample example);

    int updateByExample(@Param("record") UserSawGoods record, @Param("example") UserSawGoodsExample example);

    int updateByPrimaryKeySelective(UserSawGoods record);

    int updateByPrimaryKey(UserSawGoods record);
    
    UserSawGoodsBO getByUid(@Param("userId")Long id);
}