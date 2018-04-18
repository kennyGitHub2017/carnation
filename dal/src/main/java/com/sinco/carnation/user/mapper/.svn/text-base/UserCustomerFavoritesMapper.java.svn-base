package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.model.UserCustomerFavorites;
import com.sinco.carnation.user.model.UserCustomerFavoritesExample;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;
import com.sinco.dal.common.MyPage;

public interface UserCustomerFavoritesMapper {
	int countByExample(UserCustomerFavoritesExample example);

	int deleteByExample(UserCustomerFavoritesExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserCustomerFavorites record);

	int insertSelective(UserCustomerFavorites record);

	List<UserCustomerFavoritesBO> selectByUserForGoods(@Param("userId") long userId);

	List<UserCustomerFavorites> selectByExample(UserCustomerFavoritesExample example);

	List<UserCustomerFavoritesBO> queryFavorites(@Param("vo") UserCustomerFavoritesVO vo,
			MyPage<UserCustomerFavoritesBO> page);

	UserCustomerFavorites selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserCustomerFavorites record,
			@Param("example") UserCustomerFavoritesExample example);

	int updateByExample(@Param("record") UserCustomerFavorites record,
			@Param("example") UserCustomerFavoritesExample example);

	int updateByPrimaryKeySelective(UserCustomerFavorites record);

	int updateByPrimaryKey(UserCustomerFavorites record);

	int countStoreFavorite(@Param("storeId") Long storeId, @Param("type") int favoriteType);

	List<GroupGoodsBO> queryGroupServiceFavorites(@Param("userId") Long userId, MyPage<GroupGoodsBO> page);

	List<UserExpertsBO> searchFavoriteExperts(@Param("userId") Long userId,
			@Param("nickName") String nickName, MyPage<UserExpertsBO> page);

	List<StoreBO> searchFavoriteStores(@Param("userId") Long userId, @Param("nickName") String nickName,
			@Param("type") String type, MyPage<StoreBO> page);

	List<CircleInvitationBO> searchFavoriteCircleInvitations(@Param("userId") Long userId,
			@Param("nickName") String nickName, MyPage<CircleInvitationBO> page);

	List<GroupGoodsBO> searchFavoriteGroupGoods(@Param("userId") Long userId,
			@Param("nickName") String nickName, @Param("type") String type, MyPage<GroupGoodsBO> page);

	List<GoodsBO> searchFavoriteGoods(@Param("userId") Long userId, @Param("nickName") String nickName,
			MyPage<GoodsBO> page);
}