package com.sinco.carnation.kuaidi100.post;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * <p>
 * Title: JacksonHelper.java
 * </p>
 * 
 * <p>
 * Description: 该实体类来自快递100提供的接口
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
 * @date 2014-12-9
 * 
 * @version 1.0.1
 */
public class JacksonHelper {
	private static ObjectMapper toJSONMapper = new ObjectMapper();
	private static ObjectMapper fromJSONMapper = new ObjectMapper();
	static {
		fromJSONMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		fromJSONMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	public static String toJSON(Object obj) {
		ObjectMapper mapper = toJSONMapper;
		StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, obj);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return writer.toString();
	}

	public static void toJSON(Object obj, OutputStream stream, String charset) {
		ObjectMapper mapper = toJSONMapper;
		try {
			OutputStreamWriter writer = new OutputStreamWriter(stream, charset);
			mapper.writeValue(writer, obj);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJSON(String json, Class<T> clazz) {
		ObjectMapper mapper = fromJSONMapper;
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJSON(InputStream json, Class<T> clazz) {
		ObjectMapper mapper = fromJSONMapper;
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> boolean toJSONList(List<T> list) {
		String jsonVal = null;
		try {
			jsonVal = toJSONMapper.writeValueAsString(list);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return jsonVal == null ? false : true;
	}

	public static <T> List<T> fromJSONList(String jsonVal, Class<?> clazz) {

		List<T> list = null;
		try {
			list = fromJSONMapper.readValue(jsonVal, new TypeReference<List<T>>() {});
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
