package com.sinco.carnation.user.mapper;

import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.vo.GoodsYgClassCountVO;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.model.UserGoodsClassExample;
import com.sinco.carnation.user.vo.UserGoodsClassVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserGoodsClassMapper {
	int countByExample(UserGoodsClassExample example);

	int deleteByExample(UserGoodsClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserGoodsClass record);

	int insertSelective(UserGoodsClass record);

	List<UserGoodsClassBO> selectParentPageByVO(@Param("vo") UserGoodsClassVO vo,
			MyPage<UserGoodsClassBO> page);

	List<UserGoodsClassBO> selectByGoodsId(@Param("goodsId") Long goodsId);

	List<UserGoodsClass> selectByExample(UserGoodsClassExample example);

	UserGoodsClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserGoodsClass record,
			@Param("example") UserGoodsClassExample example);

	int updateByExample(@Param("record") UserGoodsClass record,
			@Param("example") UserGoodsClassExample example);

	int updateByPrimaryKeySelective(UserGoodsClass record);

	int updateByPrimaryKey(UserGoodsClass record);

	List<GoodsYgClassBO> findByParent(@Param("parentId") Long parentId);

	List<GoodsYgClassBO> findYgNormalAll(@Param("vo") GoodsYgClassCountVO vo);
}