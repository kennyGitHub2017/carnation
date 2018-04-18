package vc.thinker.b2b2c.core.tools;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * <p>
 * Title: TemplateEngine.java
 * </p>
 * 
 * <p>
 * Description:velcocity模板合成引擎，用来合成静态html信息
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
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
@Component
@SuppressWarnings({"unchecked", "rawtypes"})
public class TemplateEngine {
	@Autowired
	private VelocityEngine velocityEngine;

	public String generateWithTemplate(String templateName, Map map) {
		try {
			return VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, templateName, "UTF-8",
					map);
		} catch (VelocityException e) {
			e.printStackTrace();
		}
		return "";
	}

	@SuppressWarnings("deprecation")
	public String generateWithString(String content, Map map) {
		try {
			StringWriter writer = new StringWriter();
			VelocityEngineUtils.mergeTemplate(this.velocityEngine, content, map, writer);
			return writer.toString();
		} catch (VelocityException e) {
			e.printStackTrace();
		}
		return "";
	}
}
