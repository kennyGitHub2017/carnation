package com.sinco.carnation.user.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.SellerExample;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.dal.common.MyPage;

public interface SellerMapper {

	int findSellerMemberById(@Param("sellerId") Long sellerId);

	int findSellerOwnMemberById(@Param("sellerId") Long sellerId);

	int findSellerOwnSellerById(@Param("sellerId") Long sellerId);

	int findSellerAllOrderCount(@Param("sellerId") Long sellerId);

	int findSellerWeekOrderCount(@Param("sellerId") Long sellerId);

	BigDecimal findSellerRebateOrderCount(@Param("sellerId") Long sellerId);

	BigDecimal findSellerWeekRebateOrderCount(@Param("sellerId") Long sellerId);

	BigDecimal findSellerMonthRebateOrderCount(@Param("sellerId") Long sellerId);

	SellerBO findSessionById(@Param("uid")Long uid,@Param("group")Boolean group,@Param("shop")Boolean shop);

	int selectOperatorSellerCount(@Param("vo") SellerVO vo);

	int selectOperatorRegisterSellerCount(@Param("vo") SellerVO vo);

	int selectOperatorRegisterGoodsSellerCount(@Param("vo") SellerVO vo);

	int selectSellerRegisterUserCount(@Param("operaid") Long operaid, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * @Title: selectOperatorSellerPageList
	 * @Description: TODO(查询运营商所属商户列表)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	List<SellerBO> selectOperatorSellerPageList(MyPage<SellerBO> page, @Param("vo") SellerVO vo);

	/**
	 * 
	 * @Title: selectOperatorSellerPageList
	 * @Description: TODO(查询运营商所属商户列表 这里没有消费反润总额计算，比上个方法简单)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	List<SellerBO> selectOperatorSellerSimplePageList(MyPage<SellerBO> page, @Param("vo") SellerVO vo);

	/**
	 * 
	 * @Title: selectOperatorRegisterSellerPageList
	 * @Description: TODO(查询运营商注册商户)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	List<SellerBO> selectOperatorRegisterSellerPageList(MyPage<SellerBO> page, @Param("vo") SellerVO vo);

	int countByExample(SellerExample example);

	int deleteByExample(SellerExample example);

	int deleteByPrimaryKey(Long uid);

	int insert(Seller record);

	int insertSelective(Seller record);

	List<Seller> selectByExampleWithBLOBs(SellerExample example);

	List<Seller> selectByExample(SellerExample example);

	SellerBO selectByStore(@Param("storeId") String storeId);

	SellerBO selectByPrimaryKey(Long uid);

	int updateByExampleSelective(@Param("record") Seller record, @Param("example") SellerExample example);

	int updateByExampleWithBLOBs(@Param("record") Seller record, @Param("example") SellerExample example);

	int updateByExample(@Param("record") Seller record, @Param("example") SellerExample example);

	int updateByPrimaryKeySelective(Seller record);

	int updateByCondition(Seller record);

	int updateByPrimaryKeyWithBLOBs(Seller record);

	int updateByPrimaryKey(Seller record);

	SellerBO selectByUsername(@Param("username") String username);

	Seller findByUid(@Param("uid") Long uid);

	public List<Seller> selectSellerinUIDList(@Param("list") List<Long> uidList);

	public Integer sellerIsO2oByUid(@Param("uid") Long uid);
	public Integer sellerIsB2CByUid(@Param("uid") Long uid);

	public List<Seller> listAllSeller();
	@SuppressWarnings("rawtypes")
	public List findSellerByUIdList(Long uid);
	
}