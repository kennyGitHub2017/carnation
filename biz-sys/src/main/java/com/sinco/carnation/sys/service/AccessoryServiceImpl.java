package com.sinco.carnation.sys.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.weedfs.client.WeedFSClient;
import net.weedfs.client.WeedFSFilerClient;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.goods.dao.GoodsPhotoDao;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.dao.AccessoryDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.dal.common.MyPage;

@Service
public class AccessoryServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AccessoryServiceImpl.class);

	@Autowired
	private AccessoryDao accessoryDAO;

	@Autowired
	private SysConfigService sysConfigService;

	@Autowired
	private GoodsPhotoDao goodsPhotoDao;

	@Autowired
	private WeedFSClient client;

	@Autowired
	private WeedFSFilerClient filerClient;

	@Value("${fs.filerserver.puburl}")
	private String fileServerPuburlHost;

	@Value("${fs.filerserver.port}")
	private int fileServerPort;

	/**
	 * 查找服务商品附件
	 * 
	 * @param goodsId
	 * @return
	 */
	public List<Accessory> selectGroupGoodsByGoodsId(Long goodsId) {
		return this.accessoryDAO.selectGroupGoodsByGoodsId(goodsId);
	}

	public List<Accessory> selectGoodsPhotos(Long goodsId) {
		return this.accessoryDAO.selectGoodsPhontListByGoodsId(goodsId);
	}

	public void deleteByPhotoId(java.lang.Long photoId) {
		goodsPhotoDao.deleteByPhotoId(photoId);
	}

	/**
	 * 根据路径删除图片
	 * 
	 * @param path
	 */
	public void delete(String path) {
		try {
			filerClient.delete(path);
		} catch (Exception e) {
			log.error("删除文件出错", e);
		}
	}
	
	/**
	 * 指定路径上传，文件名字固定，商家资料
	 * @param request
	 * @param fileParamName
	 * @param oldPath
	 * @return
	 */
	public String uploadForPath(HttpServletRequest request, String fileParamName, String oldPath) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileParamName);
		if (file != null && !file.isEmpty()) {
			try {
				return FileUploadTools.fileUpload(file, oldPath,UploadConstants.DATA);
			} catch (Exception e) {
				log.error("上传附件失败：", e);
			}
		}

		return oldPath;
	}
	
	/**
	 * 指定路径上传，文件名自生成
	 * @param request
	 * @param fileParamName
	 * @param module
	 * @return
	 */
	public String uploadForPath2(HttpServletRequest request,String fileParamName, String module) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileParamName);
		if (file != null && !file.isEmpty()) {
			try {
				return FileUploadTools.fileUpload(file, null,UploadConstants.DATA+"/"+module);
			} catch (Exception e) {
				log.error("上传附件失败：", e);
			}
		}
		return null;
	}
	

	/**
	 * 附件上传，不添加附件记录直接返回路径
	 * 
	 * @param request
	 * @param fileParamName
	 * @param path
	 * @return
	 */
	public String upload(HttpServletRequest request, String fileParamName, String oldPath) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileParamName);
		if (file != null && !file.isEmpty()) {
			try {
				return FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				// 已有地址就替换之前的
//				if (StringUtils.isNotBlank(oldPath)) {
//					String filePath = oldPath.substring(oldPath.indexOf("/"));
//					RequestResult result = filerClient.upload(file.getInputStream(), filePath,
//							file.getOriginalFilename(),
//							URLConnection.guessContentTypeFromName(file.getOriginalFilename()));
//					return result.getUrl();
//				} else {
//					try {
//						return FileUploadTools.imageUpload(file, UploadConstants.EDITOR);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					
//					return null;
//				}
			} catch (Exception e) {
				log.error("上传附件失败：", e);
			}
		}

		return oldPath;

	}
	/**
	 * 附件上传，不添加附件记录直接返回路径
	 * 
	 * @param request
	 * @param fileParamName
	 * @param path
	 * @return
	 */
	public String uploadForModule(HttpServletRequest request, String fileParamName, String oldPath,String module) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileParamName);
		if (file != null && !file.isEmpty()) {
			try {
				return FileUploadTools.fileUpload(file, module);
			} catch (Exception e) {
				log.error("上传附件失败：", e);
			}
		}
		return oldPath;
	}

	/**
	 * 附件上传，不添加附件记录直接返回路径
	 * 
	 * @param request
	 * @param fileParamName
	 * @param path
	 * @return
	 */
	public String uploadReplace(HttpServletRequest request, String fileParamName, String oldPath) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileParamName);
		if (file != null && !file.isEmpty()) {
			try {
				return FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				// 已有地址就替换之前的
//				if (StringUtils.isNotBlank(oldPath)) {
//					String filePath = oldPath;
//					RequestResult result = filerClient.upload(file.getInputStream(), filePath,
//							file.getOriginalFilename(),
//							URLConnection.guessContentTypeFromName(file.getOriginalFilename()));
//					return result.getUrl();
//				} else {
//					try {
//						return FileUploadTools.imageUpload(file, UploadConstants.EDITOR);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					return null;
//				}
			} catch (Exception e) {
				log.error("上传附件失败：", e);
			}
		}

		return oldPath;

	}

	/**
	 * 得到完整的上传地址
	 * 
	 * @return
	 */
	public String getFullUploadPath(String path) {
		return new StringBuilder("http://").append(fileServerPuburlHost).append("/").append(path).toString();
	}
	

	/**
	 * 附件上传，不添加附件记录直接返回路径
	 * 
	 * @param request
	 * @param fileParamName
	 * @param path
	 * @return
	 */
	public String upload(InputStream inputstream, String fileName, String oldPath) {
		if (inputstream != null) {
			// 已有地址就替换之前的
//			if (StringUtils.isNotBlank(oldPath)) {
//				String filePath = oldPath.substring(oldPath.indexOf("/"));
//				RequestResult result = filerClient.upload(inputstream, filePath, fileName,
//						URLConnection.guessContentTypeFromName(fileName));
//
//				return result.getUrl();
//
//			} else {
//				
//				return null;
//			}
			try {
				return FileUploadTools.fileUpload(inputstream, UploadConstants.EDITOR);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return oldPath;

	}

	/**
	 * 保存
	 * 
	 * @param request
	 * @param folder
	 * @param fileParamName
	 * @param photo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Accessory save(HttpServletRequest request, String folder, String fileParamName, Accessory photo) {

		SysConfigBO oldSysConfig = sysConfigService.getSysConfig();

		String uploadFilePath = oldSysConfig.getUploadFilePath();

		String saveFilePathName = uploadFilePath + File.separator + folder;
		// CommUtil.createFolder(saveFilePathName);
		Map map = null;
		try {
			String fileName = photo == null ? "" : photo.getName();

			map = CommUtil.saveFileToServer(request, fileParamName, saveFilePathName, fileName, null);

			if (map.get("fileName") != "") {
				if (photo == null) {
					photo = new Accessory();
				}
				photo.setName(CommUtil.null2String(map.get("fileName")));
				photo.setExt(CommUtil.null2String(map.get("mime")));
				photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
				photo.setPath(CommUtil.null2String(map.get("path")));
				photo.setWidth(CommUtil.null2Int(map.get("width")));
				photo.setHeight(CommUtil.null2Int(map.get("height")));
				photo.setAddTime(new Date());
				this.save(photo);
			}

		} catch (IOException e) {
			log.error("上传文件失败", e);
		}

		return photo;
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		try {
			this.accessoryDAO.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Accessory getObjById(Long id) {
		return accessoryDAO.get(id);
	}

	public boolean save(Accessory acc) {
		// TODO Auto-generated method stub
		this.accessoryDAO.save(acc);
		return true;
	}

	public boolean update(Accessory acc) {
		// TODO Auto-generated method stub
		try {
			this.accessoryDAO.update(acc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void queryAccessoriesById(Long albumId, MyPage<AccessoryBO> page) {
		accessoryDAO.queryAccessoriesById(null, albumId, page);
	}

	public List<AccessoryBO> queryAccessoriesByIdAndUserId(Long userId, Long albumId, MyPage<AccessoryBO> page) {
		return accessoryDAO.queryAccessoriesById(userId, albumId, page);
	}

	@Transactional(readOnly = false)
	public void deleteAccessoryById(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] accIds = ids.split(",");
			Long[] longIds = new Long[accIds.length];
			for (int i = 0; i < accIds.length; i++) {
				longIds[i] = CommUtil.null2Long(accIds[i]);
			}
			accessoryDAO.deleteAccessotyById(longIds);
		}
	}

	@Transactional(readOnly = false)
	public void updateAlbumTransfer(String accIds, String toAlbumId, Long albumId) {
		if (StringUtils.isNotBlank(accIds) && StringUtils.isNotBlank(toAlbumId)) {
			String[] ids = accIds.split(",");
			Long[] longIds = new Long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				longIds[i] = CommUtil.null2Long(ids[i]);
			}
			accessoryDAO.updateAlbumTransfer(longIds, Long.parseLong(toAlbumId), albumId);
		}
	}

	@Transactional(readOnly = false)
	public void accessoryImgSave(HttpServletRequest request, String fileParamName, String albumId) {
		accessoryImgSave(request, fileParamName, albumId, null);
	}

	@Transactional(readOnly = false)
	public void accessoryImgSave(HttpServletRequest request, String fileParamName, String albumId, Long userId) {
		if (StringUtils.isNotBlank(albumId)) {
			String imgUrl = upload(request, fileParamName, null);
			if (StringUtils.isNotBlank(imgUrl)) {
				Accessory accessory = new Accessory();
				accessory.setAddTime(new Date());
				accessory.setAlbumId(CommUtil.null2Long(albumId));
				accessory.setPath(imgUrl);
				if (userId != null) {
					accessory.setUserId(userId);
				}
				accessoryDAO.save(accessory);
			}
		}
	}
	
	/**
	 * 商家相册图片上传
	 * @param request
	 * @param fileParamName
	 * @param albumId
	 * @param userId
	 * @param module
	 */
	@Transactional(readOnly = false)
	public void accessoryImgSave(HttpServletRequest request, String fileParamName, String albumId, Long userId,String module) {
		if (StringUtils.isNotBlank(albumId)) {
			String imgUrl = uploadForModule(request, fileParamName, null,module);
			if (StringUtils.isNotBlank(imgUrl)) {
				Accessory accessory = new Accessory();
				accessory.setAddTime(new Date());
				accessory.setAlbumId(CommUtil.null2Long(albumId));
				accessory.setPath(imgUrl);
				if (userId != null) {
					accessory.setUserId(userId);
				}
				accessoryDAO.save(accessory);
			}
		}
	}

	public List<Accessory> queryAccessroyByAlbumId(Long albumId) {
		return accessoryDAO.queryAccessroyByAlbumId(albumId);
	}
//	/**
//	 * 查找评价图片
//	 * @param userId
//	 * @return
//	 */
//	public List<Accessory> queryForEvaluate(Long userId){
//		return accessoryDAO.queryForEvaluate(userId);
//	}
}
