package com.sinco.carnation.store.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.elasticsearch.common.collect.Sets;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.FacetedPage;
import org.springframework.data.elasticsearch.core.facet.request.TermFacetRequest;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.dao.GroupGoodsDao;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.store.search.StoreDocument.StoreOrderType;
import com.sinco.carnation.store.search.StoreSearchResult;
import com.sinco.carnation.store.tools.DistanceUtils;
import com.sinco.carnation.store.vo.StoreSearchVO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.data.core.Page;
import com.sinco.dic.client.DicContent;

import edu.emory.mathcs.backport.java.util.Collections;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneVo;

/**
 * 
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: 用于商户搜索
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
 * @date 2014-6-5
 * 
 * @version 1.0.1
 */
@Component
public class StoreSearchService {
	private Logger logger = LoggerFactory.getLogger(StoreSearchService.class);
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private GroupGoodsDao groupGoodsDao;

	@Autowired
	private Mapper mapper;

	@Autowired
	private DicContent dicContent;

	@Autowired
	private AreaServiceImpl areaServiceImpl;

	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryServiceImpl;
	@Autowired
	private GroupClassService groupClassService;

	/**
	 * 更新
	 * 
	 * @param storeId
	 */
	@Async
	public void updateIndex(Long... storeId) {
		Assert.notNull(storeId, "store id is null");
		for (Long id : storeId) {
			logger.info("[update store index], init store index，store id = " + id);
			StoreBO store = storeDao.get(id);
			if (store == null) {
				logger.error("[update store index],current shop is empty , store id =" + id);
				continue;
			}
			if (store.getIsO2o()) {
				if (store.getStoreStatus() == StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
					StoreDocument doc = mapper.map(store, StoreDocument.class);
					// 设置target
					if (StringUtils.isNotBlank(store.getStoreTarget())) {
						doc.setTarget(store.getStoreTarget().split(",|，"));
					}
					// 设置图片
					if(StringUtils.isNotBlank(store.getStoreCoverPath())){
						doc.setStoreMainInfoPath(store.getStoreCoverPath());
					}else{
						AlbumBO albumBO = albumService.getStoreAlbum(store.getCreateUserId());
						if (albumBO != null) {
							Accessory accessory = accessoryServiceImpl.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
							if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
								doc.setStoreMainInfoPath(accessory.getPath());
							}
						}
					}
					// 设置评分
					doc.setEvaluationAverage(store.getStoreEvaluationAverage());
					doc.setId(id.toString());
					if (null != store.getStoreLat() && null != store.getStoreLon()) {
						doc.setLocation(new GeoPoint(store.getStoreLat().doubleValue(), store.getStoreLon()
								.doubleValue()));
					} else {
						logger.error("[update store index],current shop hav'ot lat or lon , store id =" + id);
					}
					Area area = areaServiceImpl.getObjById(store.getAreaId());
					// dicContent.getDic(Area.class,
					// String.valueOf(store.getAreaId()));
					if (null != area && null != area.getParentId()) {
						doc.setCityId(area.getParentId());
					} else {
						logger.error("[update store index],current shop Area hav'ot city , store id =" + id);
					}
					Set<Long> classIds = Sets.newHashSet();
					classIds.add(store.getGroupMainId());
					// 设置总销量
					doc.setSales(groupGoodsDao.sumSelledCountByStore(id));
					// 总上架服务数量
					doc.setNormalGoodsCount(groupGoodsDao.countByNormal(id));
					if (store.getGroupDetailInfo() != null) {
						for (String gcId : store.getGroupDetailInfo().split(",")) {
							classIds.add(Long.parseLong(gcId));
						}
					}
					doc.setClassIds(classIds.toArray(new Long[classIds.size()]));
					update(doc, false);
					logger.info("[update store index],init store index success , store id =" + id);
				} else {
					// 状态不正常删除索引
					deleteIndex(id.toString());
					logger.error("[update store index],init store index faile , store id =" + id);
				}
			}
		}
		if (elasticsearchTemplate.indexExists(StoreDocument.class)) {
			elasticsearchTemplate.refresh(StoreDocument.class, true);
		}
	}

	/**
	 * 此方法为无特定类型的默认排序，
	 * 
	 * @param keyword
	 * @param pageNo
	 * @return
	 */
	public StoreSearchResult search(StoreSearchVO vo, Page<StoreDocument> page) {
		if (StringUtils.isBlank(page.getOrder())) {
			return search(vo, page, StoreOrderType.DEFAULT, SortOrder.DESC);
		} else {
			StoreOrderType orderyType = StoreOrderType.fromString(page.getOrderBy());;
			SortOrder order = SortOrder.ASC;
			if (Page.ASC.equals(page.getOrder())) {
				order = SortOrder.ASC;
			} else if (Page.DESC.equals(page.getOrder())) {
				order = SortOrder.DESC;
			}
			return search(vo, page, orderyType, order);
		}
	}

	/**
	 * 此方法为无特定类型的默认排序，
	 * 
	 * @param keyword
	 * @param pageNo
	 * @return
	 */
	public StoreSearchResult search(StoreSearchVO vo, Page<StoreDocument> page, StoreOrderType orderBy,
			SortOrder order) {

		final BoolQueryBuilder builder = QueryBuilders.boolQuery();
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();

		if (StringUtils.isNotBlank(vo.getKeyword())) {
			builder.must(QueryBuilders.queryString(vo.getKeyword()).analyzeWildcard(true).field("storeName"));
		}
		if (vo.getCityId() != null) {
			builder.must(QueryBuilders.termQuery("cityId", vo.getCityId()));
			// 默认深圳，此处后期需要修改
			/*builder.must(QueryBuilders.termQuery("cityId","4524157"));*/
		}
		if (vo.getAreaId() != null) {
			builder.must(QueryBuilders.termQuery("areaId", vo.getAreaId()));
		}
		if (vo.getClassId() != null && vo.getClassId() > 0) {
			builder.must(QueryBuilders.termQuery("classIds", vo.getClassId()));
		}
		if (vo.getIsGoods() != null) {
			if (vo.getIsGoods()) {
				builder.must(QueryBuilders.rangeQuery("normalGoodsCount").gt(0));
			} else {
				builder.must(QueryBuilders.termQuery("normalGoodsCount", 0));
			}
		}
		if(orderBy.equals(StoreOrderType.DISTANCE)){
			if(vo.getDistance() == null || vo.getDistance() <=0){
				vo.setDistance(1000000);
			}
		}
		if (vo.getStoreLat() != null && vo.getStoreLon() != null && vo.getDistance() != null) {
			searchQueryBuilder.withFilter(FilterBuilders.geoDistanceFilter("location")
					.point(vo.getStoreLat().doubleValue(), vo.getStoreLon().doubleValue())
					.distance(vo.getDistance(), DistanceUnit.METERS));
		}
		// 排除排序错误
		if (orderBy.equals(StoreOrderType.DISTANCE) && (vo.getStoreLat() == null || vo.getStoreLon() == null)) {
			orderBy = StoreOrderType.DEFAULT;
		}

		searchQueryBuilder.withQuery(builder);

		switch (orderBy) {
			case DEFAULT:
				searchQueryBuilder.withSort(SortBuilders.fieldSort("storeEvaluationAverage").order(order))
						.withSort(SortBuilders.fieldSort("sales").order(order));
				break;
			case DISTANCE:
				// searchQueryBuilder.withSort(SortBuilders.geoDistanceSort("location").point(vo.getStoreLat().doubleValue(),
				// vo.getStoreLon().doubleValue()).order(order));
				break;
			case CREDIT:
				searchQueryBuilder.withSort(SortBuilders.fieldSort("storeEvaluationAverage").order(order));
				break;
			case SALES:
				searchQueryBuilder.withSort(SortBuilders.fieldSort("sales").order(order));
				break;
		}

		SearchQuery searchQuery = searchQueryBuilder.build();

		if (StoreOrderType.DISTANCE == orderBy && vo.getStoreLat() != null && vo.getStoreLon() != null) {
			// 如果是按距离
			Long count = elasticsearchTemplate.count(searchQuery, StoreDocument.class);
			if (count > 0) {
				searchQueryBuilder.withPageable(new PageRequest(0, count.intValue()));
			} else{
				searchQueryBuilder.withPageable(new PageRequest(page.getPageNumber() <= 0 ? 0
						: page.getPageNumber() - 1, page.getPageSize()));
			}
			searchQuery = searchQueryBuilder.build();
		} else {
			searchQueryBuilder.withPageable(new PageRequest(page.getPageNumber() <= 0 ? 0
					: page.getPageNumber() - 1, page.getPageSize()));
			searchQuery = searchQueryBuilder.build();
		}

		FacetedPage<StoreDocument> result = elasticsearchTemplate.queryForPage(searchQuery,
				StoreDocument.class);
		page.setContent(result.getContent());
		page.setTotal(result.getTotalElements());

		if (page.getContent() != null && page.getContent().size() > 0) {
			// 设置距离
			if (vo.getStoreLat() != null && vo.getStoreLon() != null) {
				List<StoreDocument> datas = new ArrayList<StoreDocument>();
				for (StoreDocument storeDocument : page.getContent()) {
					if (storeDocument.getLocation() != null) {
						Double distance = DistanceUtils.GetDistance(storeDocument.getLocation().getLon(),
								storeDocument.getLocation().getLat(), vo.getStoreLon(), vo.getStoreLat());
						storeDocument.setDistance(distance.intValue());
					} else {
						storeDocument.setDistance(0);
					}
					datas.add(storeDocument);
				}

				if (StoreOrderType.DISTANCE == orderBy) {
					// 按照距离升序
					Collections.sort(datas, new Comparator<StoreDocument>() {
						public int compare(StoreDocument arg0, StoreDocument arg1) {
							return arg0.getDistance().compareTo(arg1.getDistance());
						}
					});
					// 分页
					int start = (page.getPageNumber() <= 0 ? 0 : page.getPageNumber() - 1)
							* page.getPageSize();
					int end = page.getPageSize() * page.getPageNumber();
					if (start >= datas.size()) {
						start = datas.size();
					}
					if (end >= datas.size()) {
						end = datas.size();
					}
					if(start > end){
						end = start;
					}
					List<StoreDocument> list = datas.subList(start, end);
					page.setContent(list);
				}
			}
		}
		StoreSearchResult storeResult = new StoreSearchResult();
		storeResult.setPage(page);
		return storeResult;
	}

	/**
	 * 更新索引
	 */
	public void update(StoreDocument store, Boolean isRefresh) {

		if (!elasticsearchTemplate.indexExists(StoreDocument.class)) {
			elasticsearchTemplate.createIndex(StoreDocument.class);
			elasticsearchTemplate.putMapping(StoreDocument.class);
		}

		IndexQuery indexQuery = new IndexQueryBuilder().withId(store.getId()).withObject(store).build();
		elasticsearchTemplate.index(indexQuery);
		if (isRefresh) {
			elasticsearchTemplate.refresh(StoreDocument.class, true);
		}
	}

	/**
	 * 删除索引文件
	 * 
	 * @param id
	 */
	public void deleteIndex(String id) {

		elasticsearchTemplate.delete(StoreDocument.class, id);
		elasticsearchTemplate.refresh(StoreDocument.class, true);
	}

	/**
	 * 删除索引文件
	 * 
	 * @param id
	 */
	public void deleteIndex() {
		elasticsearchTemplate.deleteIndex(StoreDocument.class);
	}

	public List<StoreDocument> searchRecommedStore(String[] target, Double storeLat, Double storeLon,
			Page<StoreDocument> page) {
		final BoolQueryBuilder builder = QueryBuilders.boolQuery();
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();

		builder.must(QueryBuilders.termsQuery("target", Lists.newArrayList(target)));
		searchQueryBuilder.withQuery(builder);

		searchQueryBuilder.withPageable(new PageRequest(page.getPageNumber() <= 0 ? 0
				: page.getPageNumber() - 1, page.getPageSize()));
		SearchQuery searchQuery = searchQueryBuilder.build();

		if (storeLat != null && storeLon != null) {
			searchQueryBuilder.withSort(SortBuilders.geoDistanceSort("location").point(storeLat, storeLon)
					.order(SortOrder.ASC));
		}

		FacetedPage<StoreDocument> result = elasticsearchTemplate.queryForPage(searchQuery,
				StoreDocument.class);
		// 设置距离
		if (storeLat != null && storeLon != null) {
			for (StoreDocument storeDocument : result) {
				Double distance = DistanceUtils.GetDistance(storeDocument.getLocation().getLon(),
						storeDocument.getLocation().getLat(), storeLon, storeLat);
				storeDocument.setDistance(distance.intValue());
			}
		}

		return result.getContent();
	}

	public List<GoodsDocument> searchRecommedGoods(String[] target, Page<GoodsDocument> page) {
		final BoolQueryBuilder builder = QueryBuilders.boolQuery();
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();

		builder.must(QueryBuilders.termsQuery("target", Lists.newArrayList(target)));
		searchQueryBuilder.withQuery(builder);

		TermFacetRequest request = new TermFacetRequest(LuceneVo.GOODS_CLASS);
		request.setFields(LuceneVo.GOODS_CLASS);
		searchQueryBuilder.withFacet(request);

		searchQueryBuilder.withPageable(new PageRequest(page.getPageNumber() <= 0 ? 0
				: page.getPageNumber() - 1, page.getPageSize()));
		SearchQuery searchQuery = searchQueryBuilder.build();

		FacetedPage<GoodsDocument> result = elasticsearchTemplate.queryForPage(searchQuery,
				GoodsDocument.class);

		return result.getContent();
	}
}
