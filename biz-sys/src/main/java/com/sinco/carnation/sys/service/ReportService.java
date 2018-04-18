/**
 * 
 */
package com.sinco.carnation.sys.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.sys.dao.ReportDao;

/**
 * <p>
 * Title:首页报表服务
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author： 陈舟
 * 
 * @date：2016年2月24日 下午4:39:26
 * @version V1.0
 */
@Service
public class ReportService {
	@Autowired
	private ReportDao reportDao;

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	private final String shopKey = "Rrp:Index:Shop";
	private final String integralKey = "Rrp:Index:Integral";
	private final String memberKey = "Rrp:Index:Member";
	private final String merchantKey = "Rrp:Index:Merchant";
	private final String operatorKey = "Rrp:Index:Operator";
	private final String snsKey = "Rrp:Index:Sns";
	private final String exportConsultingKey = "Rrp:Index:ExportConsulting";

	private final Integer expireTime = 300;

	/**
	 * <p>
	 * Title:查询Map接口
	 * </p>
	 */
	public interface IFindMap {
		Map<String, Object> findMap();
	}

	/**
	 * 从redis中查询数据，如果redis中失效，则直接查询；
	 * 
	 * @param redisKey
	 * @param findMap
	 * @return
	 */
	public Map<String, Object> getMapFromRedis(String redisKey, IFindMap findMap) {
		Map<String, Object> map = cacheUtils.get(redisKey, new TypeReference<Map<String, Object>>() {});
		if (MapUtils.isEmpty(map)) {
			map = findMap.findMap();
			cacheUtils.set(redisKey, map, expireTime);
		}
		return map;
	}

	public Map<String, Object> findShopGroup() {
		return getMapFromRedis(this.shopKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findShopGroup();
			}
		});
	}

	public Map<String, Object> findIntegralOrderGroup() {

		return getMapFromRedis(this.integralKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findIntegralOrderGroup();
			}
		});
	}

	public Map<String, Object> findMemberGroup() {

		return getMapFromRedis(this.memberKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findMemberGroup();
			}
		});
	}

	public Map<String, Object> findMerchantGroup() {
		return getMapFromRedis(this.merchantKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findMerchantGroup();
			}
		});
	}

	public Map<String, Object> findOperatorGroup() {
		return getMapFromRedis(this.operatorKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findOperatorGroup();
			}
		});
	}

	public Map<String, Object> findSnsGroup() {
		return getMapFromRedis(this.snsKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findSnsGroup();
			}
		});
	}

	public Map<String, Object> findExportConsultingGroup() {
		return getMapFromRedis(this.exportConsultingKey, new IFindMap() {
			@Override
			public Map<String, Object> findMap() {
				return reportDao.findExportConsultingGroup();
			}
		});
	}
}
