package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.model.UserAccountExample;
import com.sinco.carnation.user.vo.UpdateWxVO;

public interface UserAccountMapper {
	UserAccount findUserAccount(@Param("uid") Long uid, @Param("accountType") Integer accountType);

	UserAccount findUserAccount2(@Param("loginName") String loginName,
			@Param("accountType") Integer accountType);

	UserAccountBO findLastLogin(@Param("uid") Long uid);

	int countByExample(UserAccountExample example);

	int deleteByExample(UserAccountExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserAccount record);

	int insertSelective(UserAccount record);

	List<UserAccount> selectByExample(UserAccountExample example);

	List<UserAccountBO> selectByExampleBO(UserAccountExample example);

	UserAccount selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserAccount record,
			@Param("example") UserAccountExample example);

	int updatePassWordByUID(@Param("record") UserAccount record);

	int updatePassWordAndUIDByID(@Param("record") UserAccount record);

	int updatePassWordByID(@Param("record") UserAccount record);

	int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

	int updateByPrimaryKeySelective(UserAccount record);

	int updateByPrimaryKey(UserAccount record);

	List<UserAccountBO> findUserAccountByUid(@Param("uid") Long uid);

	UserAccountBO queryAccountByOpenId(@Param("openId") String openId, @Param("type") Integer type);

	UserAccountBO queryAccountByOpenId2(@Param("openId") String openId, @Param("type") Integer type);

	UserAccountBO findAccountByVo(@Param("vo") UserAccountBO vo);

	UserAccountBO queryAccountByUnionid(@Param("unionid") String unionid, @Param("type") Integer type);

	public int updatePassWordAndUIDByOuid(@Param("record") UserAccount record, @Param("ouid") Long ouid);

	void updateWx(@Param("accountup") UpdateWxVO accountup);

	public UserAccountBO queryByUserAccount(@Param("vo") UserAccount record);

	public int updateUserAccountForIsDeleted(@Param("uid") Long uid, @Param("isDeleted") Boolean isDeleted,
			@Param("updateBy") Long updateBy);

	public int deleteByUID(@Param("uid") Long uid);

	UserAccountBO selectAcocountByCnUserAlias(@Param("loginName") String loginName);

	UserAccountBO selectAcocountOperatorByCnUserAlias(@Param("loginName") String loginName);

	public int updateRecordBalance();
	
	public List<UserAccount> listCNUser();

}