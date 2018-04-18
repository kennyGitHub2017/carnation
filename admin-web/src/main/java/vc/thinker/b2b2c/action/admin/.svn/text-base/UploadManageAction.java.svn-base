package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vc.thinker.b2b2c.core.tools.FileUploadTools;

/**
 * 文件统一上传
 * @author zhoufeng.wang
 *
 */
@Controller
public class UploadManageAction {
	/**
	 * 系统编辑器图片上传
	 * 
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 */
	public static final int maxSize = 8 * 1024 * 1024;
	
	@SuppressWarnings({"unchecked", "unused"})
	@RequestMapping("/file/upload.htm")
	public void fileUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("imgFile") MultipartFile file,@RequestParam("module") String module)throws Exception{

		// 限制图片体积
		if (file.getSize() > maxSize) {
			throw new Exception("图片超出限制");
		}

		JSONObject obj = new JSONObject();
		if (file != null) {
			String fileUrl=FileUploadTools.fileUpload(file, module);
			System.out.println("osss name:"+fileUrl);
			obj.put("error", 0);
			obj.put("url", fileUrl);
		} else {
			obj.put("error", "file is null");
		}
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(obj.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
