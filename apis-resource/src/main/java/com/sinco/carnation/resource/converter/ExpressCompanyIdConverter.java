package com.sinco.carnation.resource.converter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;
import org.nutz.json.Json;

public class ExpressCompanyIdConverter extends DozerConverter<String, Long> {

	public ExpressCompanyIdConverter() {
		super(String.class, Long.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long convertTo(String source, Long destination) {
		if (StringUtils.isNotBlank(source)) {
			Map express_map = Json.fromJson(Map.class, source);
			if (express_map.containsKey("express_company_id")) {
				return Long.parseLong(express_map.get("express_company_id").toString());
			}
		}
		return null;
	}

	@Override
	public String convertFrom(Long source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}
}
