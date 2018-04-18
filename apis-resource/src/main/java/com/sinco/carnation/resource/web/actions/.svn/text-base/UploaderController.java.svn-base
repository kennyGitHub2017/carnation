package com.sinco.carnation.resource.web.actions;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.web.response.FileItem;
import com.sinco.carnation.resource.web.response.Result;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.constant.PropertyConfigure;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.ImagePornDetection;
import com.sinco.carnation.sys.tools.MsgTools;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "图片上传API", namespace = "upload")
public class UploaderController extends BasicApiController {

	@Autowired
	private net.weedfs.client.WeedFSClient imageWeedClient;
	@Autowired
	private UserService userService;
	@Resource(name = "propertyConfigure")
	private PropertyConfigure propertyConfigure;

	@Autowired
	private MsgTools msgTools;

	protected int EXTRACT_FRANME_NUMBER = 50;

	private Logger log = Logger.getLogger(this.getClass().getName());

	@RequestMapping(value = "/testdesc", method = RequestMethod.GET)
	@ResponseBody
	public Result test(Model model, HttpServletRequest request) {
		System.out.println(request.getHeader("DTS_TRACE_ID"));
		return null;
	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	@ResponseBody
	@MethodMapping(desc = "图片上传")
	public Result imageProcessUpload(@RequestParam("file") MultipartFile[] files,
			@RequestParam(value = "suffix", required = false, defaultValue = "") String suffix, Model model,
			HttpServletRequest request) {
		String module=request.getHeader("module");
		// 取得用户的信息
		Long userId = ActionsUtil.getOwnerUid();
		UserBO userBO = userService.findById(userId);

		Boolean isYellow = false;
//		String token = request.getParameter("auth_token");
//		log.info("upload token:" + token);

		String[] suffixes = suffix.split(",");

		Result result = new Result();

		if (StringUtils.isNotEmpty(suffix) && suffixes.length != files.length) {
			result.setSuccess(false);
			result.setMessage("500");
		}
		int version = files.length;
		try {
			// Assignation a = imageWeedClient.assign(new AssignParams());
			for (int i = 0; i < version; i++) {
				MultipartFile file = files[i];
				/*判断文件是否大于5M，大于5M拒绝上传*/
				long fileLength = file.getInputStream().available();
				long m = fileLength / 1048576;
				if (m >= 8) {
					result.setSuccess(false);
					result.setMessage("500");
					Map<String, String> errorParam = new HashMap<>();
					errorParam.put("param", "8M");
					result.putErrorMessage("4.sys.image.size.over.max", errorParam);
					break;
				}
				/*
				 * if(i>0){ a.weedFSFile.version = i; }
				 */
				// 文件上传到weedfs服务
//				RequestResult res = imageWeedClient.upload(file.getInputStream(), file.getOriginalFilename(),
//						URLConnection.guessContentTypeFromName((file.getOriginalFilename())));
				// imageWeedClient.write(a.weedFSFile, a.location,
				// file.getBytes(), file.getOriginalFilename());
				// log.info("upload file location:" + a.location.toString() +
				// ",file name:" + file.getOriginalFilename()
				// +",assign:"+a.toString());
				// String fid = a.weedFSFile.fid;
				// if(i>0) fid = fid + "_" + a.weedFSFile.version;
				// log.info("upload file url:" +
				// publicNgxUrl(a.location.publicUrl) + "/" + fid +
				// (StringUtils.isNotEmpty(suffix)? "." + suffixes[i]:""));
				
				String fileUrl=FileUploadTools.fileUpload(file, module==null?UploadConstants.APP:module);
				
				// 图片监黄
				Float rate = ImagePornDetection.syncImageDetection(fileUrl);
				/*分值大于50后为黄图*/
				if (rate >= Float.parseFloat(propertyConfigure.getPornRate())) {
					isYellow = true;
					// 文件服务器上删除该图片
					FileUploadTools.fileDelete(fileUrl);
					//imageWeedClient.delete(res.getFid());
					// 发短信通知管理员
					msgTools.sendSms("sms_image_porn_notify", propertyConfigure.getPornSmsMobile(),
							userId.toString(), userBO.getUserName() == null ? "null" : userBO.getUserName(),
							rate.toString());
					break;
				}
				result.addItems(new FileItem(fileUrl
						+ (StringUtils.isNotEmpty(suffix) ? "." + suffixes[i] : "")));
				// result.addItems(new FileItem(publicNgxUrl(res.getUrl())
				// + (StringUtils.isNotEmpty(suffix) ? "." + suffixes[i] : "")));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			log.info(ex.getMessage());
			result.setSuccess(false);
			result.setMessage("500");
		}
		if (isYellow) {
			result.setSuccess(false);
			result.setMessage("500");
			result.putErrorMessage("4.sys.image.pron");
		}
		return result;
	}

//	@RequestMapping(value = "/audio",method=RequestMethod.POST)
//	@ResponseBody public Result audioProcessUpload(@RequestParam MultipartFile file, Model model) throws IOException {
//		Result result = new Result();
//		try{
//			Assignation a = audioWeedClient.assign(new AssignParams());
//			audioWeedClient.write(a.weedFSFile, a.location, file.getInputStream(), file.getOriginalFilename());
//			result.addItems(new FileItem(publicNgxUrl(a.location.publicUrl) + "/" + a.weedFSFile.fid));
//		}catch(Exception ex){
//			ex.printStackTrace();
//			log.info(ex.getMessage());
//			result.setSuccess(false);
//			result.setMessage("500");
//
//		}
//
//		return result;
//	}
//	@RequestMapping(value = "/video",method=RequestMethod.POST)
//	@ResponseBody public Result videoProcessUpload(@RequestParam MultipartFile file,@RequestParam(value="thumbnail", required = false) MultipartFile thumbnail,@RequestParam(value="suffix", required = false, defaultValue="") String suffix ,Model model) throws Exception {
//		Result result = new Result();
//		try{
//			Assignation a = videoWeedClient.assign(new AssignParams());
//
//			videoWeedClient.write(a.weedFSFile, a.location, file.getBytes(), "video"+System.currentTimeMillis()+".mp4");
//
//			Assignation i = imageWeedClient.assign(new AssignParams());
//
//			imageWeedClient.write(i.weedFSFile, i.location , thumbnail.getBytes(), thumbnail.getOriginalFilename());
//			result.addItems(new FileItem(publicNgxUrl(a.location.publicUrl) + "/" + a.weedFSFile.fid,publicNgxUrl(i.location.publicUrl) + "/" + i.weedFSFile.fid + suffix));
//		}catch(Exception ex){
//			ex.printStackTrace();
//			log.info(ex.getMessage());
//			result.setSuccess(false);
//			result.setMessage("500");
//
//		}
//		return result;
//	}

	public String publicNgxUrl(String publicUrl) {
		String result = "";
		try {
			int port = new URL(publicUrl).getPort();
			result = publicUrl.replace(":" + port, "");
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return result;
	}

}
