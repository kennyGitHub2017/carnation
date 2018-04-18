package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.security.SecurityManager;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.user.service.OperatorService;

/**
 * 
 * <p>
 * Title: BaseSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商家后台基础管理器 主要功能包括商家后台的基础管理、快捷菜单设置等
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-6-10
 * 
 * 
 * @version 1.0.1
 */
@Controller
public class BaseOperatorAction implements ServletContextAware {
	
	private ServletContext servletContext;
	@Autowired
	private SecurityManager securityManager;
	@Autowired
	private OperatorService operatorService;
	

	@Autowired
	private WeedFSClient fsClient;
	
	
	/**
	 * 初始化权限
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/operator/initRole.htm")
	public @ResponseBody String initSellerRole(HttpServletRequest request, HttpServletResponse response){
		List<Class> clzs = new ArrayList<Class>();
		//权限
		clzs.add(IndexAction.class);
		clzs.add(BaseOperatorAction.class);
		clzs.add(ComplaintManagerAction.class);
		clzs.add(LoginAction.class);
		clzs.add(OperatorCashAction.class);
		clzs.add(OperatorAdAction.class);
		clzs.add(OperatorCheckAction.class);
		clzs.add(OperatorManageAction.class);
		clzs.add(OperatorNoticesAction.class);
		
		List<SecurityMapping> mappings=new ArrayList<SecurityMapping>();
		for (Class clz : clzs) {
			Method[] ms = clz.getMethods();
			for (Method m : ms) {
				Annotation[] annotation = m.getAnnotations();
				for (Annotation tag : annotation) {
					if (SecurityMapping.class.isAssignableFrom(tag
							.annotationType())) {
						mappings.add((SecurityMapping)tag);
					}
				}
			}
		}
		operatorService.initOperatorRole(mappings);
		
		// 重新加载系统权限
		Map<String, String> urlAuthorities = this.securityManager.loadUrlAuthorities();
		this.servletContext.setAttribute("urlAuthorities", urlAuthorities);
		
		return "init role ok!!";
	}
	
	@RequestMapping("/operator/authority.htm")
	public String authority(Model model)
	{
		return "authority.html";
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
	}

	/**
	 * 系统编辑器图片上传
	 *
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 */
	public static final int maxSize = 8 * 1024 * 1024;
	@SuppressWarnings({"unchecked", "unused"})
	@RequestMapping("/upload.htm")
	public void upload(HttpServletRequest request, HttpServletResponse response,@RequestParam("imgFile") MultipartFile file)
		//	throws ClassNotFoundException {
			throws Exception{
		//限制图片体积
		if(file.getSize() > maxSize){
			throw new Exception("图片超出限制");
		}

		JSONObject obj = new JSONObject();
		try {
			if(file!=null){
				String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				obj.put("error", 0);
				obj.put("url", fileUrl);
			}else{
				obj.put("error", "file is null");
			}
		} catch (IOException e) {
			obj.put("error", 1);
			obj.put("message", e.getMessage());
			e.printStackTrace();
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
