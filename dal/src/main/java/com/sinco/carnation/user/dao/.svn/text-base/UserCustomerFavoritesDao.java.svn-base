package com.sinco.carnation.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.mapper.UserCustomerFavoritesMapper;
import com.sinco.carnation.user.model.UserCustomerFavorites;
import com.sinco.carnation.user.model.UserCustomerFavoritesExample;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class UserCustomerFavoritesDao {

	@Autowired
	private UserCustomerFavoritesMapper mapper;
	@Autowired
	private DicNameMappingHandle dicNameMappingHandle;

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(UserCustomerFavorites record) {
		return mapper.insert(record);
	}

	public UserCustomerFavorites findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateById(UserCustomerFavorites record) {
		return mapper.updateByPrimaryKey(record);
	}

	public List<UserCustomerFavoritesBO> selectByUserForGoods(long userId) {
		return mapper.selectByUserForGoods(userId);
	}

	public void queryFavorites(UserCustomerFavoritesVO vo, MyPage<UserCustomerFavoritesBO> page) {
//		 favorites = new UserCustomerFavoritesVO();
//		favorites.setUid(uid);
//		favorites.setType(type);
		mapper.queryFavorites(vo, page);

		dicNameMappingHandle.mappinHandle(page.getContent());
	}

	/**
	 * 用户查找收藏
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	public UserCustomerFavorites findFavoritesByFid(Long uid, String fid, String type) {
		UserCustomerFavoritesExample example = new UserCustomerFavoritesExample();
		example.createCriteria().andUidEqualTo(uid).andFidEqualTo(fid).andTypeEqualTo(type);
		List<UserCustomerFavorites> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 用户添加收藏
	 * 
	 * @param favorites
	 * @return
	 */
	public int addFavorites(UserCustomerFavorites favorites) {
		return mapper.insert(favorites);
	}

	public int updateFavorites(UserCustomerFavorites favorites) {
//		UserCustomerFavoritesExample example=new UserCustomerFavoritesExample();
//		example.createCriteria().andIdEqualTo(favorites.getId());
//		return mapper.updateByExampleSelective(favorites, example);
		return mapper.updateByPrimaryKeySelective(favorites);
	}

	public int cancleFavorites(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public UserCustomerFavorites findFavorites(Long uid, String fid, String type) {
		UserCustomerFavoritesExample example = new UserCustomerFavoritesExample();
		example.createCriteria().andUidEqualTo(uid).andFidEqualTo(fid).andTypeEqualTo(type);
		List<UserCustomerFavorites> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public int countStoreFavorite(Long storeId, int favoriteType) {
		return mapper.countStoreFavorite(storeId, favoriteType);
	}

	public void queryGroupServiceFavorites(Long userId, MyPage<GroupGoodsBO> page) {
		mapper.queryGroupServiceFavorites(userId, page);
	}

	/**
	 * 搜索用户收藏的专家
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param page
	 */
	public void searchFavoriteExperts(Long uid, String nickName, MyPage<UserExpertsBO> page) {
		mapper.searchFavoriteExperts(uid, nickName, page);
	}

	/**
	 * 搜索用户收藏的店铺
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param type
	 *            商户或者店铺
	 * @param page
	 */
	public void searchFavoriteStores(Long uid, String nickName, String type, MyPage<StoreBO> page) {
		mapper.searchFavoriteStores(uid, nickName, type, page);
	}

	/**
	 * 搜索用户收藏的服务
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param type
	 *            套餐券或者现金券
	 * @param page
	 */
	public void searchFavoriteGroupGoods(Long uid, String nickName, String type, MyPage<GroupGoodsBO> page) {
		mapper.searchFavoriteGroupGoods(uid, nickName, type, page);
	}

	/**
	 * 搜索用户收藏的商品
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param page
	 */
	public void searchFavoriteGoods(Long uid, String nickName, MyPage<GoodsBO> page) {
		mapper.searchFavoriteGoods(uid, nickName, page);
	}

	/**
	 * 搜索用户收藏的帖子
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param page
	 */
	public void searchFavoriteCircleInvitations(Long uid, String nickName, MyPage<CircleInvitationBO> page) {
		mapper.searchFavoriteCircleInvitations(uid, nickName, page);
	}
}
