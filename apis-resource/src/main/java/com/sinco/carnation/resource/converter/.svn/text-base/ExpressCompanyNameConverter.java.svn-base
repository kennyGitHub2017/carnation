package com.sinco.carnation.resource.converter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;
import org.nutz.json.Json;

public class ExpressCompanyNameConverter extends DozerConverter<String, String> {

	public ExpressCompanyNameConverter() {
		super(String.class, String.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertTo(String source, String destination) {
		if (StringUtils.isNotBlank(source)) {
			Map express_map = Json.fromJson(Map.class, source);
			if (express_map.containsKey("express_company_name")) {
				return express_map.get("express_company_name").toString();
			}
		}
		return null;
	}

	@Override
	public String convertFrom(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}
}
