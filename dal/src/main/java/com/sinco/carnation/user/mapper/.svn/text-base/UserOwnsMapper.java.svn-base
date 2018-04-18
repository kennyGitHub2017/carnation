package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.model.UserOwns;
import com.sinco.carnation.user.model.UserOwnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOwnsMapper {
	int countByExample(UserOwnsExample example);

	int deleteByExample(UserOwnsExample example);

	int deleteByPrimaryKey(@Param("sellerUserId")Long sellerUserId,@Param("ownType")Integer ownType);

	int insert(UserOwns record);

	int insertSelective(UserOwns record);

	List<UserOwnsBO> selectByExample(UserOwnsExample example);

	UserOwnsBO selectByPrimaryKey(@Param("sellerUserId")Long sellerUserId, @Param("ownType")Integer ownType);

	public UserOwnsBO selectBOBySellerId(@Param("sellerUserId")Long id, @Param("ownType")Integer ownType);

	int updateByExampleSelective(@Param("record") UserOwns record, @Param("example") UserOwnsExample example);

	int updateByExample(@Param("record") UserOwns record, @Param("example") UserOwnsExample example);

	int updateByPrimaryKeySelective(UserOwns record);

	int updateByPrimaryKey(UserOwns record);

	List<UserOwnsBO> findAllSellerByOperId(@Param("operId") Long operId);

	List<UserOwnsBO> findAllSellerNotBySellerUID(@Param("operId") Long operId,
			@Param("sellerUID") Long sellerUID);
}