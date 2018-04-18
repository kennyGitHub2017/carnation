package com.sinco.carnation.sys.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.mapper.ReportMapper;

@Repository
public class ReportDao {

	@Autowired
	private ReportMapper mapper;

	public Map<String, Object> findShopGroup() {

		Map<String, Object> map = mapper.findShopGroup();
		map.putAll(mapper.findShopGroupComplaint());
		map.putAll(mapper.findShopGroupConsult());
		map.putAll(mapper.findShopGroupStore());
		return map;
	}

	public Map<String, Object> findIntegralOrderGroup() {
		Map<String, Object> map = mapper.findIntegralOrderGroup();
		return map;
	}

	public Map<String, Object> findMemberGroup() {
		Map<String, Object> map = mapper.findMemberGroup();
		return map;
	}

	public Map<String, Object> findMerchantGroup() {
		Map<String, Object> map = mapper.findMerchantGroup();
		map.putAll(mapper.findMerchantGroupUnOwn());
		map.putAll(mapper.findMerchantGroupOrder());
		return map;
	}

	public Map<String, Object> findOperatorGroup() {
		Map<String, Object> map = mapper.findOperatorGroup();
		return map;
	}

	public Map<String, Object> findSnsGroup() {
		Map<String, Object> map = mapper.findSnsGroup();
		return map;
	}

	public Map<String, Object> findExportConsultingGroup() {
		Map<String, Object> map = mapper.findExportConsultingGroup();
		return map;
	}

}
