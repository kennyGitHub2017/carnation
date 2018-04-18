/**   
 * @(#)XmlUtil.java	2016年11月22日	下午6:43:59	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * xml工具类
 * 
 * <p>
 * 修改历史: <br>
 * 修改日期 修改人员 版本 修改内容<br>
 * -------------------------------------------------<br>
 * 2016年11月22日 下午6:43:59 user 1.0 初始化创建<br>
 * </p>
 * 
 * @author user
 * @version 1.0
 * @since JDK1.7
 */
public class XmlUtil {

	/**
	 * 
	 * 对象转XML字符串
	 * 
	 * @param value
	 * @return
	 * @throws JAXBException
	 */
	public static String objectToXml(Object value) throws JAXBException {
		String str = null;

		JAXBContext context = null;

		StringWriter writer = null;
		try {
			context = JAXBContext.newInstance(value.getClass());
			Marshaller mar = context.createMarshaller();
			writer = new StringWriter();
			mar.marshal(value, writer);
			str = writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (context != null)
				context = null;
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				writer = null;
			}
		}

		return str;
	}

	/**
	 * 
	 * xml字符串转换为对象
	 * 
	 * @param str
	 * @param 目标对象类型
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToObject(String str, Class<T> clazz) throws JAXBException {
		JAXBContext context = null;
		T obj = null;

		try {
			context = JAXBContext.newInstance(clazz);
			File file = new File(str);
			Unmarshaller unmar = context.createUnmarshaller();
			obj = (T) unmar.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
		return obj;
	}
}
