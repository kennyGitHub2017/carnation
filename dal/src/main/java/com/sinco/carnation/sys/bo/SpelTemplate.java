package com.sinco.carnation.sys.bo;

import org.springframework.expression.ParserContext;

/**
 * 
 * <p>
 * Title: SpelTemplate.java
 * </p>
 * 
 * <p>
 * * Description:自定义SPEL模板。定义为以${#user.userName} 获取 user对象的userName。
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-2-27
 * 
 * @version 1.0.1
 */
public class SpelTemplate implements ParserContext {
	@Override
	public String getExpressionPrefix() {
		// TODO Auto-generated method stub
		return "${";
	}

	@Override
	public String getExpressionSuffix() {
		// TODO Auto-generated method stub
		return "}";
	}

	@Override
	public boolean isTemplate() {
		// TODO Auto-generated method stub
		return true;
	}
}
