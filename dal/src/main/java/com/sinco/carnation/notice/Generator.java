package com.sinco.carnation.notice;

import com.sinco.mybatis.generator.MyBatisGeneratorTool;

/**
 * 代码自动产生
 * 
 * @author 林补
 * 
 */
public class Generator {

	public static void main(String[] args) {
		String genCfg = "/generator/notice/generatorConfig.xml";
		args = new String[1];
		args[0] = genCfg;
		MyBatisGeneratorTool.main(args);
		System.out.println("代码生成成功");
	}

}
