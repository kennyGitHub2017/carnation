package com.sinco.carnation.sys.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.contants.Globals;
import com.sinco.carnation.sys.dao.SysConfigDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.SysConfig;

@Service
@Transactional
public class SysConfigService {

	private final Logger log = LoggerFactory.getLogger(SysConfigService.class);

	@Autowired
	private SysConfigDao sysConfigDAO;

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	private static final String sysConfigKey = "sysConfig";

	// 本地缓存，提高性能，这里设置5秒过期，在集群情况下数据会有5秒延迟
	private LoadingCache<Serializable, SysConfigBO> localCache = CacheBuilder.newBuilder().maximumSize(2)
			.expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<Serializable, SysConfigBO>() {
				public SysConfigBO load(Serializable key) {
					long start = System.currentTimeMillis();
					SysConfigBO sysConfig = toGetSysConfig();
					log.info("get sysconfig  time is:" + (System.currentTimeMillis() - start));
					return sysConfig;
				}
			});

	@Transactional(readOnly = false)
	public boolean delete(SysConfig shopConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 得到sysConfig 先从缓存中得到
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public SysConfigBO getSysConfig() {
		try {

			return localCache.get("1");
		} catch (ExecutionException e) {
			log.error("", e);
			return toGetSysConfig();
		}
	}

	/**
	 * 对内使用
	 * 
	 * @return
	 */
	private SysConfigBO toGetSysConfig() {
		SysConfigBO sysConfig = cacheUtils.get(sysConfigKey, new TypeReference<SysConfigBO>() {});
		if (sysConfig == null) {
			sysConfig = doGetSysConfig();
			cacheUtils.set(sysConfigKey, sysConfig);
		}
		return sysConfig;
	}

	/**
	 * 刷新缓存
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public SysConfigBO refreshSysConfig() {
		SysConfigBO sysConfig = doGetSysConfig();
		cacheUtils.set(sysConfigKey, sysConfig);
		localCache.invalidateAll();
		return sysConfig;
	}

	@Transactional(readOnly = false)
	public void saveSysGrade(String id, SysConfig sc) {
		if (StringUtils.isNotBlank(id)) {
			sysConfigDAO.save(sc);
		}
	}

	@Transactional(readOnly = false)
	public void addConfigAmount(BigDecimal payoffAllAmount, BigDecimal payoffAllAmountReality,
			BigDecimal payoffAllCommission, BigDecimal payoffAllSale) {
		if (payoffAllAmount != null || payoffAllAmountReality != null || payoffAllCommission != null
				|| payoffAllSale != null) {
			sysConfigDAO.addConfigAmount(payoffAllAmount, payoffAllAmountReality, payoffAllCommission,
					payoffAllSale);
			refreshSysConfig();
		}
	}

	private SysConfigBO doGetSysConfig() {
		// TODO Auto-generated method stub
		List<SysConfigBO> configs = this.sysConfigDAO.findAll();

		if (configs != null && configs.size() > 0) {
			SysConfigBO sc = configs.get(0);
			if (sc.getUploadFilePath() == null) {
				sc.setUploadFilePath(Globals.UPLOAD_FILE_PATH);
			}
			if (sc.getSysLanguage() == null) {
				sc.setSysLanguage(Globals.DEFAULT_SYSTEM_LANGUAGE);
			}
			if (sc.getWebsiteName() == null || sc.getWebsiteName().equals("")) {
				sc.setWebsiteName(Globals.DEFAULT_WBESITE_NAME);
			}
			if (sc.getCloseReason() == null || sc.getCloseReason().equals("")) {
				sc.setCloseReason(Globals.DEFAULT_CLOSE_REASON);
			}
			if (sc.getTitle() == null || sc.getTitle().equals("")) {
				sc.setTitle(Globals.DEFAULT_SYSTEM_TITLE);
			}
			if (sc.getImageSaveType() == null || sc.getImageSaveType().equals("")) {
				sc.setImageSaveType(Globals.DEFAULT_IMAGESAVETYPE);
			}
			if (sc.getImageFilesize() == 0) {
				sc.setImageFilesize(Globals.DEFAULT_IMAGE_SIZE);
			}
			if (sc.getSmallWidth() == 0) {
				sc.setSmallWidth(Globals.DEFAULT_IMAGE_SMALL_WIDTH);
			}
			if (sc.getSmallHeight() == 0) {
				sc.setSmallHeight(Globals.DEFAULT_IMAGE_SMALL_HEIGH);
			}
			if (sc.getMiddleWidth() == 0) {
				sc.setMiddleWidth(Globals.DEFAULT_IMAGE_MIDDLE_WIDTH);
			}
			if (sc.getMiddleHeight() == 0) {
				sc.setMiddleHeight(Globals.DEFAULT_IMAGE_MIDDLE_HEIGH);
			}
			if (sc.getBigHeight() == 0) {
				sc.setBigHeight(Globals.DEFAULT_IMAGE_BIG_HEIGH);
			}
			if (sc.getBigWidth() == 0) {
				sc.setBigWidth(Globals.DEFAULT_IMAGE_BIG_WIDTH);
			}
			if (sc.getImageSuffix() == null || sc.getImageSuffix().equals("")) {
				sc.setImageSuffix(Globals.DEFAULT_IMAGE_SUFFIX);
			}
			if (sc.getStoreImage() == null) {
				Accessory storeImage = new Accessory();
				storeImage.setPath(sc.getImageWebServer() + "/resources/style/common/images/store.jpg");
				storeImage.setName("");
				sc.setStoreImage(storeImage);
			}
			if (sc.getGoodsImage() == null) {
				Accessory goodsImage = new Accessory();
				goodsImage.setPath(sc.getImageWebServer() + "/resources/style/common/images/good.jpg");
				goodsImage.setName("good.jpg");
				sc.setGoodsImage(goodsImage);
			}
			if (sc.getMemberIcon() == null) {
				Accessory memberIcon = new Accessory();
				memberIcon.setPath(sc.getImageWebServer() + "resources/style/common/images/member.jpg");
				memberIcon.setName("member.jpg");
				sc.setMemberIcon(memberIcon);
			}
			if (sc.getSecurityCodeType() == null || sc.getSecurityCodeType().equals("")) {
				sc.setSecurityCodeType(Globals.SECURITY_CODE_TYPE);
			}
			if (sc.getWebsiteCss() == null || sc.getWebsiteCss().equals("")) {
				sc.setWebsiteCss(Globals.DEFAULT_THEME);
			}
			if (sc.getPayoffDate() == null) {
				Calendar cale = Calendar.getInstance();
				cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				sc.setPayoffDate(cale.getTime());
			}
			if (sc.getSmsUrl() == null || sc.getSmsUrl().equals("")) {
				sc.setSmsUrl(Globals.DEFAULT_SMS_URL);
			}
			if (sc.getAutoOrderNotice() == 0) {
				sc.setAutoOrderNotice(3);
			}
			if (sc.getAutoOrderEvaluate() == 0) {
				sc.setAutoOrderEvaluate(7);
			}
			if (sc.getAutoOrderReturn() == 0) {
				sc.setAutoOrderReturn(7);
			}
			if (sc.getAutoOrderConfirm() == 0) {
				sc.setAutoOrderConfirm(7);
			}
			if (sc.getGrouplifeOrderReturn() == 0) {
				sc.setGrouplifeOrderReturn(7);
			}
			return sc;
		} else {
			SysConfigBO sc = new SysConfigBO();
			sc.setUploadFilePath(Globals.UPLOAD_FILE_PATH);
			sc.setWebsiteName(Globals.DEFAULT_WBESITE_NAME);
			sc.setSysLanguage(Globals.DEFAULT_SYSTEM_LANGUAGE);
			sc.setTitle(Globals.DEFAULT_SYSTEM_TITLE);
			sc.setSecurityCodeType(Globals.SECURITY_CODE_TYPE);
			sc.setEmailEnable(Globals.EAMIL_ENABLE);
			sc.setCloseReason(Globals.DEFAULT_CLOSE_REASON);
			sc.setImageSaveType(Globals.DEFAULT_IMAGESAVETYPE);
			sc.setImageFilesize(Globals.DEFAULT_IMAGE_SIZE);
			sc.setSmallWidth(Globals.DEFAULT_IMAGE_SMALL_WIDTH);
			sc.setSmallHeight(Globals.DEFAULT_IMAGE_SMALL_HEIGH);
			sc.setMiddleHeight(Globals.DEFAULT_IMAGE_MIDDLE_HEIGH);
			sc.setMiddleWidth(Globals.DEFAULT_IMAGE_MIDDLE_WIDTH);
			sc.setBigHeight(Globals.DEFAULT_IMAGE_BIG_HEIGH);
			sc.setBigWidth(Globals.DEFAULT_IMAGE_BIG_WIDTH);
			sc.setImageSuffix(Globals.DEFAULT_IMAGE_SUFFIX);
			sc.setComplaintTime(Globals.DEFAULT_COMPLAINT_TIME);
			sc.setWebsiteCss(Globals.DEFAULT_THEME);
			sc.setSmsUrl(Globals.DEFAULT_SMS_URL);
			Accessory goodsImage = new Accessory();
			goodsImage.setPath("resources/style/common/images");
			goodsImage.setName("good.jpg");
			sc.setGoodsImage(goodsImage);
			Accessory storeImage = new Accessory();
			storeImage.setPath("resources/style/common/images");
			storeImage.setName("store.jpg");
			sc.setStoreImage(storeImage);
			Accessory memberIcon = new Accessory();
			memberIcon.setPath("resources/style/common/images");
			memberIcon.setName("member.jpg");
			sc.setMemberIcon(memberIcon);
			Calendar cale = Calendar.getInstance();
			cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
			sc.setPayoffDate(cale.getTime());
			sc.setAutoOrderNotice(3);
			sc.setAutoOrderEvaluate(7);
			sc.setAutoOrderReturn(7);
			sc.setAutoOrderConfirm(7);
			sc.setGrouplifeOrderReturn(7);

			// 如果没有新增一份
			this.sysConfigDAO.save(sc);
			return sc;
		}
	}

	@Transactional(readOnly = false)
	public boolean save(SysConfig shopConfig) {
		// TODO Auto-generated method stub
		try {
			this.sysConfigDAO.save(shopConfig);
			this.refreshSysConfig();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional(readOnly = false)
	public void saveSysConfig(SysConfig config) {
		if (null != config.getId()) {
			this.update(config);
		} else {
			config.setAddTime(new Date());
			this.save(config);
		}
	}

	public SysConfig querySysConfig() {
		return doGetSysConfig();
	}

	@SuppressWarnings({"rawtypes", "unused"})
	@Transactional(readOnly = false)
	public void save(SysConfig sysConfig, HttpServletRequest request) {
		SysConfigBO oldSysConfig = this.getSysConfig();
		sysConfig.setId(oldSysConfig.getId());

		// 图片上传开始logo
		String uploadFilePath = oldSysConfig.getUploadFilePath();

		String saveFilePathName = uploadFilePath + File.separator + "system";
		// CommUtil.createFolder(saveFilePathName);
		Map map = new HashMap();
		try {
			String fileName = oldSysConfig.getWebsiteLogo() == null ? "" : oldSysConfig.getWebsiteLogo()
					.getName();

			map = CommUtil.saveFileToServer(request, "websiteLogo", saveFilePathName, fileName, null);
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory logo = new Accessory();
					logo.setName(CommUtil.null2String(map.get("fileName")));
					logo.setExt((String) map.get("mime"));
					logo.setSize(BigDecimal.valueOf((CommUtil.null2Double(map.get("fileSize")))));
					logo.setPath(CommUtil.null2String(map.get("path")));
					logo.setWidth(CommUtil.null2Int(map.get("width")));
					logo.setHeight(CommUtil.null2Int(map.get("heigh")));
					logo.setAddTime(new Date());
					this.accessoryService.save(logo);
					sysConfig.setWebsiteLogoId(logo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory logo = oldSysConfig.getWebsiteLogo();
					logo.setName(CommUtil.null2String(map.get("fileName")));
					logo.setExt(CommUtil.null2String(map.get("mime")));
					logo.setSize(BigDecimal.valueOf((CommUtil.null2Double(map.get("fileSize")))));
					logo.setPath(CommUtil.null2String(map.get("path")));
					logo.setWidth(CommUtil.null2Int(map.get("width")));
					logo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(logo);
					sysConfig.setWebsiteLogoId(logo.getId());
				}
			}
		} catch (IOException e) {
			log.error("save logo error", e);
		}

		// 默认商品图片
		map.clear();
		try {
			map = CommUtil.saveFileToServer(request, "goodsImage", saveFilePathName, null, null);
			String fileName = oldSysConfig.getGoodsImage() == null ? "" : oldSysConfig.getGoodsImage()
					.getName();
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory photo = new Accessory();
					photo.setName(CommUtil.null2String(map.get("fileName")));
					photo.setExt(CommUtil.null2String(map.get("mime")));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("heigh")));
					photo.setAddTime(new Date());
					this.accessoryService.save(photo);
					sysConfig.setGoodsImageId(photo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory photo = oldSysConfig.getGoodsImage();
					photo.setName(CommUtil.null2String(map.get("fileName")));
					photo.setExt(CommUtil.null2String(map.get("mime")));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(photo);
					sysConfig.setGoodsImageId(photo.getId());
				}
			}
		} catch (IOException e) {
			log.error("save 商品默认图片出错", e);
		}
		// 默认店铺标识
		map.clear();
		try {
			map = CommUtil.saveFileToServer(request, "storeImage", saveFilePathName, null, null);
			String fileName = oldSysConfig.getStoreImage() == null ? "" : oldSysConfig.getStoreImage()
					.getName();
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory photo = new Accessory();
					photo.setName((String) map.get("fileName"));
					photo.setExt((String) map.get("mime"));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("heigh")));
					photo.setAddTime(new Date());
					this.accessoryService.save(photo);
					sysConfig.setStoreImageId(photo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory photo = oldSysConfig.getStoreImage();
					photo.setName(CommUtil.null2String(map.get("fileName")));
					photo.setExt(CommUtil.null2String(map.get("mime")));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(photo);
					sysConfig.setStoreImageId(photo.getId());
				}
			}
		} catch (IOException e) {
			log.error("save 默认店铺标识错误", e);
		}
		// 默认会员图片
		map.clear();
		try {
			map = CommUtil.saveFileToServer(request, "memberIcon", saveFilePathName, null, null);
			String fileName = oldSysConfig.getMemberIcon() == null ? "" : oldSysConfig.getMemberIcon()
					.getName();
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory photo = new Accessory();
					photo.setName((String) map.get("fileName"));
					photo.setExt((String) map.get("mime"));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("heigh")));
					photo.setAddTime(new Date());
					this.accessoryService.save(photo);
					sysConfig.setMemberIconId(photo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory photo = oldSysConfig.getMemberIcon();
					photo.setName(CommUtil.null2String(map.get("fileName")));
					photo.setExt(CommUtil.null2String(map.get("mime")));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(photo);
					sysConfig.setMemberIconId(photo.getId());
				}
			}
		} catch (IOException e) {
			log.error("save 默认会员图片 error", e);
		}
		// 平台登录Logo
		map.clear();
		try {
			map = CommUtil.saveFileToServer(request, "admin_login_img", saveFilePathName, null, null);
			String fileName = oldSysConfig.getAdminLoginLogo() == null ? "" : oldSysConfig
					.getAdminLoginLogo().getName();
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory photo = new Accessory();
					photo.setName((String) map.get("fileName"));
					photo.setExt((String) map.get("mime"));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("heigh")));
					photo.setAddTime(new Date());
					this.accessoryService.save(photo);
					sysConfig.setAdminLoginLogoId(photo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory photo = oldSysConfig.getAdminLoginLogo();
					photo.setName(CommUtil.null2String(map.get("fileName")));
					photo.setExt(CommUtil.null2String(map.get("mime")));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(photo);
					sysConfig.setAdminLoginLogoId(photo.getId());
				}
			}
		} catch (IOException e) {
			log.error("save 平台登入logo error", e);
		}
		// 平台管理Logo
		map.clear();
		try {
			map = CommUtil.saveFileToServer(request, "admin_manage_img", saveFilePathName, null, null);
			String fileName = oldSysConfig.getAdminManageLogo() == null ? "" : oldSysConfig
					.getAdminManageLogo().getName();
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory photo = new Accessory();
					photo.setName((String) map.get("fileName"));
					photo.setExt((String) map.get("mime"));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("heigh")));
					photo.setAddTime(new Date());
					this.accessoryService.save(photo);
					sysConfig.setAdminManageLogoId(photo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory photo = oldSysConfig.getAdminManageLogo();
					photo.setName(CommUtil.null2String(map.get("fileName")));
					photo.setExt(CommUtil.null2String(map.get("mime")));
					photo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					photo.setPath(CommUtil.null2String(map.get("path")));
					photo.setWidth(CommUtil.null2Int(map.get("width")));
					photo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(photo);
					sysConfig.setAdminManageLogoId(photo.getId());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("save 平台登入logo error", e);
		}
		// 上传系统二维码中心Logo图片
		map.clear();
		try {
			map = CommUtil.saveFileToServer(request, "qrLogo", saveFilePathName, null, null);
			String fileName = oldSysConfig.getQrLogo() == null ? "" : oldSysConfig.getQrLogo().getName();
			if (fileName.equals("")) {
				if (map.get("fileName") != "") {
					Accessory logo = new Accessory();
					logo.setName((String) map.get("fileName"));
					logo.setExt((String) map.get("mime"));
					logo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					logo.setPath(CommUtil.null2String(map.get("path")));
					logo.setWidth(CommUtil.null2Int(map.get("width")));
					logo.setHeight(CommUtil.null2Int(map.get("heigh")));
					logo.setAddTime(new Date());
					this.accessoryService.save(logo);
					sysConfig.setQrLogoId(logo.getId());
				}
			} else {
				if (map.get("fileName") != "") {
					Accessory logo = oldSysConfig.getQrLogo();
					logo.setName(CommUtil.null2String(map.get("fileName")));
					logo.setExt(CommUtil.null2String(map.get("mime")));
					logo.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
					logo.setPath(CommUtil.null2String(map.get("path")));
					logo.setWidth(CommUtil.null2Int(map.get("width")));
					logo.setHeight(CommUtil.null2Int(map.get("height")));
					this.accessoryService.save(logo);
					sysConfig.setQrLogoId(logo.getId());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("save 二维码登陆logo error", e);
		}
		//
		if (sysConfig.getAppDownload() == 1) {// 开启app下载生成下载链接二维码
			String destPath = System.getProperty("thinkervcb2b2c.root") + uploadFilePath + File.separator
					+ "app";
			if (!CommUtil.fileExist(destPath)) {
				CommUtil.createFolder(destPath);
			}
			String logoPath = "";
			if (oldSysConfig.getQrLogo() != null) {
				logoPath = request.getSession().getServletContext().getRealPath("/")
						+ oldSysConfig.getQrLogo().getPath() + File.separator
						+ oldSysConfig.getQrLogo().getName();
			}
			// String download_url = CommUtil.getURL(request)
			// + "/app_download.htm";
			// QRCodeUtil.encode(download_url, logoPath, destPath +
			// File.separator
			// + "app_dowload.png", true);
		}
		if (sysConfig.getHotSearch() != null && !sysConfig.getHotSearch().equals("")) {
			sysConfig.setHotSearch(sysConfig.getHotSearch().replaceAll("，", ","));// 替换全角分隔号
		}
		if (sysConfig.getKeywords() != null && !sysConfig.getKeywords().equals("")) {
			sysConfig.setKeywords(sysConfig.getKeywords().replaceAll("，", ","));
		}
		// 处理运行上传文件名的后缀,不允许一下后缀名被修改为可以上传的文件
		String imageSuffix = oldSysConfig.getImageSuffix();
		String[] suffix_list = new String[] {"php", "asp", "jsp", "html", "htm", "cgi", "action", "js", "css"};
		for (String suffix : suffix_list) {
			imageSuffix = imageSuffix.replaceAll(suffix, "");
		}
		sysConfig.setImageSuffix(imageSuffix);

		for (int i = 0; i < 4; i++) {
			try {
				map.clear();
				String fileName = "";
				if (oldSysConfig.getLoginImgs() != null && oldSysConfig.getLoginImgs().size() > i) {
					fileName = oldSysConfig.getLoginImgs().get(i).getName();
				}
				map = CommUtil.saveFileToServer(request, "img" + i, saveFilePathName, fileName, null);
				if (fileName.equals("")) {
					if (map.get("fileName") != "") {
						Accessory img = new Accessory();
						img.setName(CommUtil.null2String(map.get("fileName")));
						img.setExt((String) map.get("mime"));
						img.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
						img.setPath(CommUtil.null2String(map.get("path")));
						img.setWidth((Integer) map.get("width"));
						img.setHeight((Integer) map.get("height"));
						img.setAddTime(new Date());
						img.setConfigId(oldSysConfig.getId());
						this.accessoryService.save(img);
					}
				} else {
					if (map.get("fileName") != "") {
						Accessory img = oldSysConfig.getLoginImgs().get(i);
						img.setName(CommUtil.null2String(map.get("fileName")));
						img.setExt(CommUtil.null2String(map.get("mime")));
						img.setSize(BigDecimal.valueOf(CommUtil.null2Double(map.get("fileSize"))));
						img.setPath(CommUtil.null2String(map.get("path")));
						img.setWidth(CommUtil.null2Int(map.get("width")));
						img.setHeight(CommUtil.null2Int(map.get("height")));
						img.setConfigId(oldSysConfig.getId());
						this.accessoryService.save(img);
					}
				}
			} catch (IOException e) {
				log.error("save login img error", e);
			}
		}

		// 保存
		this.save(sysConfig);

		// 刷新缓存
		this.refreshSysConfig();
	}

	@Transactional(readOnly = false)
	public boolean update(SysConfig shopConfig) {
		// TODO Auto-generated method stub
		try {
			this.sysConfigDAO.update(shopConfig);
			this.refreshSysConfig();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
