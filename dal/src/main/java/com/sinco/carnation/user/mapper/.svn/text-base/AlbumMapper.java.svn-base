package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.model.AlbumExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AlbumMapper {
	int countByExample(AlbumExample example);

	int deleteByExample(AlbumExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Album record);

	int insertSelective(Album record);

	List<AlbumBO> selectByExampleWithBLOBs(AlbumExample example);

	List<AlbumBO> selectByExample(AlbumExample example);

	AlbumBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

	int updateByExampleWithBLOBs(@Param("record") Album record, @Param("example") AlbumExample example);

	int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

	int updateByPrimaryKeySelective(Album record);

	int updateByPrimaryKeyWithBLOBs(Album record);

	int updateByPrimaryKey(Album record);

	List<AlbumBO> queryAlbumList(@Param("userId") Long userId, @Param("page") MyPage<AlbumBO> page);

	int ablumDelete(@Param("ids") Long[] ids);

	List<AlbumBO> queryAblumAccessory(@Param("coverId") Long coverId, @Param("userId") Long userId);

	List<AlbumBO> queryAlbumByUserNameList(@Param("loginName") String loginName,
			@Param("page") MyPage<AlbumBO> page);

	public List<AlbumBO> albumUserList(@Param("albumName") String albumName,
			@Param("page") MyPage<AlbumBO> page);

	public List<AlbumBO> queryAlbumListByUid(@Param("userId") Long userId);

	public AlbumBO fetchStoreInfoDefaultAlbum(@Param("userId") Long userId);

	List<AlbumBO> queryStoreAlbumList(@Param("userId") Long userId, @Param("page") MyPage<AlbumBO> page);
}