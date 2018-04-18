package vc.thinker.b2b2c.lucene;

import static org.elasticsearch.index.query.QueryBuilders.queryString;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.search.sort.SortBuilder;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.nutz.lang.util.ArraySet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.FacetedPageImpl;
import org.springframework.data.elasticsearch.core.facet.request.TermFacetRequest;
import org.springframework.data.elasticsearch.core.facet.result.Term;
import org.springframework.data.elasticsearch.core.facet.result.TermResult;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.pool.LuceneThreadPool;

/**
 * 
 * <p>
 * Title: LuceneUtil.java
 * </p>
 * 
 * <p>
 * Description: lucene搜索工具类,用来写入索引，搜索数据
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
@SuppressWarnings({"unchecked", "rawtypes", "unused", "deprecation"})
public class LuceneUtil {
	private static Logger logger = LoggerFactory.getLogger(LuceneUtil.class);
	private static File index_file = null;// 索引文件
	private static Analyzer analyzer = null;// 搜索分词器
	private static LuceneUtil lucence = new LuceneUtil();// 搜索工具类单例
	private static QueryParser parser;// 查询解析器
	private static String index_path;// 索引路径
	private static int gc_size;// 商品分类大小
	private int textmaxlength = 100;// 截取字符串长度，该长度类关键词高亮显示
	private static String prefixHTML = "<font color='red'>";// 高亮html前置
	private static String suffixHTML = "</font>";// 高亮html后置
	private int pageSize = 24;
	private static int lucenenQueue = 0;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public ElasticsearchTemplate getElasticsearchTemplate() {
		return elasticsearchTemplate;
	}

	public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
		this.elasticsearchTemplate = elasticsearchTemplate;
	}

	/** 初始化工具 * */
	public LuceneUtil() {

	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

	public static File getIndex_filer() {
		return index_file;
	}

	/** 返回一个单例 * */
	public static LuceneUtil instance() {
		return lucence;
	}

	public static void setGc_size(int gc_size) {
		LuceneUtil.gc_size = gc_size;
	}

	public static void setLucenenQueue(int lucenenQueue) {
		LuceneUtil.lucenenQueue = lucenenQueue;
	}

	/**
	 * 此方法为特定类型的排序
	 * 
	 * @param params
	 * @param after
	 * @return
	 */
	public LuceneResult _search(String keyword, int currentPage, String goods_inventory, String goods_type,
			String goods_class, String goods_transfee, String goods_cod, Sort sort, String goods_cat,
			String goods_area, String gb_name) {
		LuceneResult pList = new LuceneResult();
		IndexSearcher isearcher = null;
		List<LuceneVo> vo_list = new ArrayList<LuceneVo>();
		IndexReader reader = null;
		int pages = 0;
		int rows = 0;
		String params = "";
		try {
			// 创建索引搜索器 且只读
			index_file = new File(index_path);
			if (!index_file.exists()) {
				return pList;
			}
			reader = IndexReader.open(FSDirectory.open(index_file));
			isearcher = new IndexSearcher(reader);
			// 在索引器中使用IKSimilarity相似度评估器
			// isearcher.setSimilarity(new IKSimilarity());
			// 处理查询筛选条件
			if (gb_name != null && !gb_name.equals("")) {// 此为品牌主页请求
				String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
				Pattern pat = Pattern.compile(regEx);
				Matcher mat = pat.matcher(gb_name);
				gb_name = mat.replaceAll("").trim();
				params = "(goods_brand:" + gb_name + ")";
			} else {
				if (keyword != null && !"".equals(keyword) && keyword.indexOf("title:") < 0) {
					params = "(title:" + keyword + " OR content:" + keyword + " OR goods_brand: " + keyword
							+ ")";
				} else {
					params = "(title:*)";
				}
			}
			if (goods_inventory != null && goods_inventory.equals("0")) {
				params = params + " AND goods_inventory:[1 TO " + Integer.MAX_VALUE + "]";
			}
			if (goods_type != null && !goods_type.equals("-1")) {
				params = params + " AND goods_type:" + goods_type;
			}
			if (goods_class != null && !goods_class.equals("")) {
				params = params + " AND goods_class:" + goods_class;
			}
			if (goods_transfee != null && !goods_transfee.equals("")) {
				params = params + " AND goods_transfee:" + goods_transfee;
			}
			if (goods_cod != null && !goods_cod.equals("")) {
				params = params + " AND goods_cod:" + goods_cod;
			}
			if (goods_cat != null && !goods_cat.equals("")) {
				params = params + " AND (goods_cat : " + goods_cat + ")";
			}
			if (goods_area != null && !goods_area.equals("")) {
				params = params + " AND (goods_area : " + goods_area + ")";
			}
			parser.setAllowLeadingWildcard(true);
			Query query = parser.parse(params);
			TopDocs topDocs = null;
			int start = (currentPage - 1) * this.pageSize;
			if (currentPage == 0) {// currentPage为零，该请求为搜索请求
				topDocs = isearcher.search(query, this.pageSize, sort);
				pages = (topDocs.totalHits + this.pageSize - 1) / this.pageSize; // 记算总页数
				rows = topDocs.totalHits;// 计算总记录数
				currentPage = 1;
				start = 0;
			} else if (currentPage != 0) {// currentPage非零，该请求为分页请求
				topDocs = isearcher.search(query, start + this.pageSize, sort);
				pages = (topDocs.totalHits + this.pageSize - 1) / this.pageSize; // 记算总页数
				rows = topDocs.totalHits;// 计算总记录数
			}
			int end = (this.pageSize + start) < topDocs.totalHits ? (this.pageSize + start)
					: topDocs.totalHits;
			for (int i = start; i < end; i++) {
				Document doc = isearcher.doc(topDocs.scoreDocs[i].doc);
				LuceneVo vo = new LuceneVo();
				// 对商品名称进行关键字高亮
				String title = doc.get(LuceneVo.TITLE);
				if (gb_name == null || gb_name.equals("")) {// 非品牌主页请求，对商品名称进行关键字高亮显示
					if (!"(title:*)".equals(keyword) && !"(title:*)".equals(pages)) {
						SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(prefixHTML,
								suffixHTML);
						Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
						highlighter.setTextFragmenter(new SimpleFragmenter(textmaxlength));
						title = highlighter.getBestFragment(analyzer, keyword, doc.get(LuceneVo.TITLE));
					}
				}
				// 商品id，名称，图片
				vo.setVo_id(CommUtil.null2Long(doc.get(LuceneVo.ID)));
				if (title == null) {
					vo.setVo_title(doc.get(LuceneVo.TITLE));
				} else {
					vo.setVo_title(title);
				}
				vo.setVo_main_photo_url(doc.get(LuceneVo.MAIN_PHOTO_URL));
				vo.setVo_photos_url(doc.get(LuceneVo.PHOTOS_URL));
				// 价格，销量，评论，类型
				vo.setVo_store_price(CommUtil.null2Double(doc.get(LuceneVo.STORE_PRICE)));
				vo.setVo_goods_salenum(CommUtil.null2Int(doc.get(LuceneVo.GOODS_SALENUM)));
				vo.setVo_goods_evas(CommUtil.null2Int(doc.get(LuceneVo.GOODS_EVAS)));
				vo.setVo_goods_type(CommUtil.null2Int(doc.get(LuceneVo.GOODS_TYPE)));
				vo.setVo_whether_active(CommUtil.null2Int(doc.get(LuceneVo.WHETHER_ACTIVE)));
				vo.setVo_f_sale_type(CommUtil.null2Int(doc.get(LuceneVo.F_SALE_TYPE)));
				// CN会员登陆商城页面需要展示BV值，添加 2017-02-27 tw
				vo.setVo_goods_price(CommUtil.null2Double(doc.get(LuceneVo.GOODS_PRICE)));
				vo.setVo_self_add_price(CommUtil.null2Double(doc.get(LuceneVo.SELF_ADD_PRICE)));
				vo.setVo_cn_self_add_price(CommUtil.null2Double(doc.get(LuceneVo.CN_SELF_ADD_PRICE)));
				vo.setVo_ex_price_flag(CommUtil.null2Int(doc.get(LuceneVo.EX_PRICE_FLAG)));
				vo_list.add(vo);
			}
			pList.setPages(pages);
			pList.setRows(rows);
			pList.setCurrentPage(currentPage);
			pList.setVo_list(vo_list);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (isearcher != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error("[search] error,parameter=" + params, e);
					throw new RuntimeException("[search] error", e);
				}
			}
		}

		return pList;
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Client client = null;
		try {
			LuceneUtil luceneutil = new LuceneUtil();
			Settings settings = ImmutableSettings.builder().put("client.transport.sniff", "true")
					.put("cluster.name", "elasticsearch").put("node.name", "searchClient").build();
			TransportAddress address = new InetSocketTransportAddress("192.168.1.209", 9300);
			client = new TransportClient(settings).addTransportAddress(address);
			ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(client);
			luceneutil.setElasticsearchTemplate(elasticsearchTemplate);
			// luceneutil.delete_index(GoodsDocument.class, "1884");
			luceneutil.search(GoodsDocument.class, "滋补食材", 0, null, null, null, null, null, null, null, null,
					null, null, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (client != null)
				client.close();
		}

	}
	
	

	/**
	 * 此方法为无特定类型的默认排序，
	 * 
	 * @param keyword
	 * @param pageNo
	 * @return
	 */
	public LuceneResult search(Class clazz, String keyword, int currentPage, String goods_inventory,
			String goods_type, String goods_class, String goods_transfee, String goods_cod, String goods_cat,
			String goods_area, String gb_name, SortBuilder sortBuilder, Boolean onlyCN, Integer isYgb, 
			Boolean excludeJuanpi, Boolean isTuangou, String juanpi_class) {
		return search(clazz, keyword, currentPage, pageSize, goods_inventory, goods_type, goods_class, goods_transfee, 
				goods_cod, goods_cat, goods_area, gb_name, sortBuilder, onlyCN, isYgb, excludeJuanpi, isTuangou, juanpi_class);
	}
	public LuceneResult search(Class clazz, String keyword, int currentPage, int pageSize, String goods_inventory,
			String goods_type, String goods_class, String goods_transfee, String goods_cod, String goods_cat,
			String goods_area, String gb_name, SortBuilder sortBuilder, Boolean onlyCN, Integer isYgb, 
			Boolean excludeJuanpi, Boolean isTuangou, String juanpi_class) {
		LuceneResult pList = new LuceneResult();
		pList.setPageSize(pageSize);
		List<LuceneVo> vo_list = new ArrayList<LuceneVo>();
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
		Set<String> list = new ArraySet<String>();
		String params = "";
		try {

			if (gb_name != null && !gb_name.equals("")) {// 此为品牌主页请求
				String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
				Pattern pat = Pattern.compile(regEx);
				Matcher mat = pat.matcher(gb_name);
				gb_name = mat.replaceAll("").trim();
				params = "(goods_brand:" + gb_name + ")";
			} else {
				if (keyword != null && !"".equals(keyword) && keyword.indexOf("title:") < 0) {
					params = "(title:" + keyword + " OR content:" + keyword + " OR goods_brand: " + keyword
							+ ")";
				} else {
					params = "(title:*)";
				}
			}
			if (goods_inventory != null && goods_inventory.equals("0")) {
				params = params + " AND goods_inventory:[1 TO " + Integer.MAX_VALUE + "]";
			}
			if (StringUtils.isNotBlank(goods_type) && !goods_type.equals("-1")) {
				params = params + " AND goods_type:" + goods_type;
			}
			if (StringUtils.isNotBlank(goods_class) && StringUtils.isNotBlank(juanpi_class)) {
				params = params + " AND (goods_class:" + goods_class;
				String[] ids = StringUtils.splitByWholeSeparatorPreserveAllTokens(juanpi_class, ",");
				if(ids != null && ids.length > 0){
					for(int i = 0; i < ids.length; i++){
						params += " OR juanpi_class:" + ids[i];
					}
				}
				params += ")";
			}else if(StringUtils.isNotBlank(goods_class)){
				params = params + " AND goods_class:" + goods_class;
			}else if(StringUtils.isNotBlank(juanpi_class)){
				String[] ids = StringUtils.splitByWholeSeparatorPreserveAllTokens(juanpi_class, ",");
				if(ids != null && ids.length > 0){
					params += " AND (";
					for(int i = 0; i < ids.length; i++){
						if(i > 0){
							params += " OR juanpi_class:" + ids[i];
						}else{
							params += "juanpi_class:" + ids[i];
						}
					}
					params += ")";
				}
			}
			if (goods_transfee != null && !goods_transfee.equals("")) {
				params = params + " AND goods_transfee:" + goods_transfee;
			}
			if (goods_cod != null && !goods_cod.equals("")) {
				params = params + " AND goods_cod:" + goods_cod;
			}
			if (goods_cat != null && !goods_cat.equals("")) {
				params = params + " AND (goods_cat : " + goods_cat + ")";
			}
			if (goods_area != null && !goods_area.equals("")) {
				params = params + " AND (goods_area : " + goods_area + ")";
			}
			if (onlyCN != null && onlyCN) {
				params = params + " AND bv :[1 TO " + Integer.MAX_VALUE + "]";
			}
			if (isYgb != null) {
				params = params + " AND is_ygb:" + isYgb;
			}
			if(excludeJuanpi != null && excludeJuanpi){
				params = params + " AND is_juanpi:0";
			}
			if(isTuangou != null && isTuangou){
				params = params + " AND is_tuangou:1";
			}
			logger.debug("[search],search key parameter =" + params);
			searchQueryBuilder.withQuery(queryString(params).analyzeWildcard(true).field("title", 1.2f)
					.field("content", 1.2f));
			TermFacetRequest request = new TermFacetRequest(LuceneVo.GOODS_CLASS);
			request.setFields(LuceneVo.GOODS_CLASS);
			searchQueryBuilder.withFacet(request);
			if (sortBuilder != null) {
				searchQueryBuilder.withSort(sortBuilder);
			}
			searchQueryBuilder.withPageable(new PageRequest(currentPage, pageSize));
			SearchQuery searchQuery = searchQueryBuilder.build();
			FacetedPageImpl<GoodsDocument> result = (FacetedPageImpl<GoodsDocument>) elasticsearchTemplate
					.queryForPage(searchQuery, clazz);
			for (Object o : result.getContent()) {
				if (null == o) {
					continue;
				}
				// 对商品名称进行关键字高亮
				GoodsDocument doc = (GoodsDocument) o;
				logger.debug("[search] is running, get goods data:" + doc.toString());
				LuceneVo vo = new LuceneVo();
				// 商品id，名称，图片
				if(doc.getId().startsWith("JP")){//卷皮商品ID默认JP前缀
					vo.setVo_id(Long.parseLong(doc.getId().substring(2)));
				}else{
					vo.setVo_id(Long.parseLong(doc.getId()));
				}
				vo.setVo_title(doc.getTitle());
				vo.setVo_main_photo_url(doc.getMain_photo_url());
				vo.setVo_photos_url(doc.getPhotos_url());
				vo.setVo_target_url_m(doc.getTarget_url_m());
				// 价格，销量，评论，类型
				vo.setVo_store_price(doc.getStore_price());
				vo.setVo_goods_salenum(doc.getGoods_salenum());
				vo.setVo_goods_evas(Integer.parseInt(doc.getGoods_evas()));
				vo.setVo_goods_type(Integer.parseInt(doc.getGoods_type()));
				vo.setVo_whether_active(Integer.parseInt(doc.getWhether_active()));
				vo.setVo_f_sale_type(Integer.parseInt(doc.getF_sale_type()));
				vo.setVo_has_exchange_integral(doc.getHas_exchange_integral());
				vo.setVo_has_mobile_price(doc.getHas_mobile_price());
				vo.setVo_mobile_price(doc.getMobile_price());
				// 非CN会员登陆需要过滤精品专区商品，添加 2017-07-11 tw
				vo.setVo_is_ygb(doc.getIs_ygb());
				// CN会员登陆商城页面需要展示BV值，添加 2017-02-27 tw
				double goods_price = doc.getGoods_price();
				double store_price = doc.getStore_price();
				if (doc.getGoods_type() != null && doc.getInventory_type() != null) {
					if (doc.getGoods_type().equals("1") && doc.getInventory_type().equals("spec")) {
						goods_price = goods_price + doc.getSelf_add_price();
						store_price = store_price + doc.getSelf_add_price();
					}
				}
				vo.setVo_store_price(store_price);
				vo.setVo_goods_price(goods_price);
				vo.setVo_self_add_price(doc.getSelf_add_price());
				vo.setVo_cn_self_add_price(doc.getCn_self_add_price());
				vo.setVo_ex_price_flag(doc.getEx_price_flag());
				vo.setVo_inventory_type(doc.getInventory_type());
				vo.setVo_is_juanpi(doc.getIs_juanpi());
				vo.setVo_is_tuangou(doc.getIs_tuangou());
				vo.setVo_tuangou_price(doc.getTuangou_price());
				vo_list.add(vo);
			}
			TermResult res = (TermResult) result.getFacet(LuceneVo.GOODS_CLASS);
			List<Term> terms = res.getTerms();
			for (Term term : terms) {
				list.add(term.getTerm());
			}
			pList.setPages(result.getTotalPages());
			pList.setRows(Integer.parseInt(String.valueOf(result.getTotalElements())));
			pList.setCurrentPage(currentPage + 1);
			pList.setVo_list(vo_list);
			pList.setGoodsClassList(list);
		} catch (Exception e) {
			logger.error("[search] error,parameter=" + params, e);
			throw new RuntimeException("[search] error", e);
		} finally {
		}
		return pList;
	}

	/**
	 * 添加单个到索引库中
	 * 
	 * @erikzhang
	 * @param LuceneVo
	 * @throws IOException
	 */
	public void writeIndex(LuceneVo vo) {
		IndexWriter writer = null;
		if (lucenenQueue == 1) {
			LuceneThreadPool pool = LuceneThreadPool.instance();
			final LuceneVo lu_vo = vo;
			pool.addThread(new Runnable() {
				EsDocument doc = builderDocument(lu_vo);

				public void run() {
					IndexQuery indexQuery = null;
					if (doc instanceof GoodsDocument) {
						GoodsDocument indexDoc = (GoodsDocument) doc;
						indexQuery = new IndexQueryBuilder().withId(indexDoc.getId()).withObject(indexDoc)
								.build();
						if (indexQuery != null) {
							elasticsearchTemplate.index(indexQuery);
							elasticsearchTemplate.refresh(GoodsDocument.class, true);
						}
					}
					if (doc instanceof LifeGoodsDocument) {
						LifeGoodsDocument indexDoc = (LifeGoodsDocument) doc;
						indexQuery = new IndexQueryBuilder().withId(indexDoc.getId()).withObject(indexDoc)
								.build();
						if (indexQuery != null) {
							elasticsearchTemplate.index(indexQuery);
							elasticsearchTemplate.refresh(LifeGoodsDocument.class, true);
						}
					}
					if (doc instanceof GroupGoodsDocument) {
						GroupGoodsDocument indexDoc = (GroupGoodsDocument) doc;
						indexQuery = new IndexQueryBuilder().withId(indexDoc.getId()).withObject(indexDoc)
								.build();
						if (indexQuery != null) {
							elasticsearchTemplate.index(indexQuery);
							elasticsearchTemplate.refresh(GroupGoodsDocument.class, true);
						}
					}
					// TODO Auto-generated method stub
					/*
					 * try { if (writer.isLocked(writer.getDirectory())) {
					 * writer.unlock(writer.getDirectory()); }
					 * writer.addDocument(document); writer.commit(); } catch
					 * (IOException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					System.out.println("writeIndex begin....");
				}
			});
		} else {
			/*
			 * try { writer = this.openIndexWriter(); if
			 * (writer.isLocked(writer.getDirectory())) {
			 * writer.unlock(writer.getDirectory()); } Document document =
			 * builderDocument(vo); writer.addDocument(document);
			 * writer.commit(); writer.close(); } catch (IOException e1) { //
			 * TODO Auto-generated catch block e1.printStackTrace(); }
			 */
			EsDocument document = builderDocument(vo);
			System.out.println("writeIndex begin....");
		}

	}
	
	/**
	 * 更新索引
	 */
	public void update(EsDocument doc){
		IndexQuery indexQuery = null;
		if (doc instanceof GoodsDocument) {
			if (!elasticsearchTemplate.indexExists(GoodsDocument.class)) {
				elasticsearchTemplate.createIndex(GoodsDocument.class);
				elasticsearchTemplate.putMapping(GoodsDocument.class);
			}

			GoodsDocument indexDoc = (GoodsDocument) doc;
			indexQuery = new IndexQueryBuilder().withId(indexDoc.getId()).withObject(indexDoc).build();
		}
		if (doc instanceof LifeGoodsDocument) {
			if (!elasticsearchTemplate.indexExists(LifeGoodsDocument.class)) {
				elasticsearchTemplate.createIndex(LifeGoodsDocument.class);
				elasticsearchTemplate.putMapping(LifeGoodsDocument.class);
			}
			LifeGoodsDocument indexDoc = (LifeGoodsDocument) doc;
			indexQuery = new IndexQueryBuilder().withId(indexDoc.getId()).withObject(indexDoc).build();
		}
		if (doc instanceof GroupGoodsDocument) {
			if (!elasticsearchTemplate.indexExists(GroupGoodsDocument.class)) {
				elasticsearchTemplate.createIndex(GroupGoodsDocument.class);
				elasticsearchTemplate.putMapping(GroupGoodsDocument.class);
			}
			GroupGoodsDocument indexDoc = (GroupGoodsDocument) doc;
			indexQuery = new IndexQueryBuilder().withId(indexDoc.getId()).withObject(indexDoc).build();
		}
		if (indexQuery != null) {
			elasticsearchTemplate.index(indexQuery);
			if (doc instanceof GoodsDocument) {
				elasticsearchTemplate.refresh(GoodsDocument.class, true);
			}
			if (doc instanceof LifeGoodsDocument) {
				elasticsearchTemplate.refresh(LifeGoodsDocument.class, true);
			}
			if (doc instanceof GroupGoodsDocument) {
				elasticsearchTemplate.refresh(GroupGoodsDocument.class, true);
			}
		}
	}

	/**
	 * 更新索引
	 */
	public void update(String id, LuceneVo vo) {
		update(builderDocument(vo));
	}

	/**
	 * 删除索引文件
	 * 
	 * @param id
	 */
	public void delete_index(Class clazz, String id) {

		elasticsearchTemplate.delete(clazz, id);
		elasticsearchTemplate.refresh(clazz, true);
	}

	public void deleteFileByIndex(String index) {
		elasticsearchTemplate.deleteIndex(index);
	}

	/**
	 * 删除所有索引文件
	 * 
	 * @erikzhang
	 */
	private void deleteAllFile() {

		elasticsearchTemplate.deleteIndex("goods");
		elasticsearchTemplate.deleteIndex("groupgoods");
		elasticsearchTemplate.deleteIndex("lifegoods");
	}

	@SuppressWarnings("static-access")
	private EsDocument builderDocument(LuceneVo luceneVo) {
		// Document document = new Document();
		Whitelist white = new Whitelist();

		if ("goods".equals(luceneVo.getVo_type())) {
			GoodsDocument document = new GoodsDocument();
			document.setId(String.valueOf(luceneVo.getVo_id()));
			document.setTitle(Jsoup.clean(luceneVo.getVo_title(), white.none()));
			document.setContent(Jsoup.clean(luceneVo.getVo_content(), white.none()));
			document.setType(luceneVo.getVo_type());
			document.setAdd_time(luceneVo.getVo_add_time());
			document.setGoods_salenum(luceneVo.getVo_goods_salenum());
			document.setGoods_collect(luceneVo.getVo_goods_collect());
			document.setWell_evaluate(luceneVo.getVo_well_evaluate());
			document.setStore_price(luceneVo.getVo_store_price());
			document.setMobile_price(luceneVo.getVo_mobile_price());
			document.setTarget(luceneVo.getTarget());
			// CN会员登陆商城页面需要展示BV值，添加 2017-02-27 tw
			document.setGoods_price(luceneVo.getVo_goods_price());
			document.setSelf_add_price(luceneVo.getVo_self_add_price());
			document.setCn_self_add_price(luceneVo.getVo_cn_self_add_price());
			document.setEx_price_flag(luceneVo.getVo_ex_price_flag());
			document.setInventory_type(luceneVo.getVo_inventory_type());
			document.setBv(luceneVo.getBv());
			// 非CN会员登陆需要过滤精品专区商品，添加 2017-07-11 tw
			document.setIs_ygb(luceneVo.getVo_is_ygb());
			// 库存改为数值型字段
			document.setGoods_inventory(luceneVo.getVo_goods_inventory());
			document.setGoods_type(CommUtil.null2String(luceneVo.getVo_goods_type()));

			if (luceneVo.getVo_main_photo_url() != null) {
				document.setMain_photo_url(CommUtil.null2String(luceneVo.getVo_main_photo_url()));

			}
			document.setPhotos_url(CommUtil.null2String(luceneVo.getVo_photos_url()));
			document.setGoods_evas(CommUtil.null2String(luceneVo.getVo_goods_evas()));

			// 由于品牌名较短，所以此处即使不加强该域的权重，该域的优先级也较高。
			// 此域采用不分词分析器
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern pat = Pattern.compile(regEx);
			Matcher mat = pat.matcher(CommUtil.null2String(luceneVo.getVo_goods_brandname()));
			String gb_name = mat.replaceAll("").trim().toLowerCase();

			document.setGoods_brandname(gb_name);
			document.setGoods_class(CommUtil.null2String(luceneVo.getVo_goods_class()));
			document.setGoods_transfee(CommUtil.null2String(luceneVo.getVo_goods_transfee()));

			document.setGoods_cod(CommUtil.null2String(luceneVo.getVo_goods_cod()));
			document.setWhether_active(CommUtil.null2String(luceneVo.getVo_whether_active()));

			document.setF_sale_type(CommUtil.null2String(luceneVo.getVo_f_sale_type()));
			document.setHas_exchange_integral(luceneVo.isVo_has_exchange_integral());
			document.setHas_mobile_price(luceneVo.isVo_has_mobile_price());
			//卷皮数据
			document.setIs_juanpi(luceneVo.getVo_is_juanpi());
			document.setIs_tuangou(luceneVo.getVo_is_tuangou());
			document.setJuanpi_class(luceneVo.getVo_juanpi_class());
			document.setTuangou_price(luceneVo.getVo_tuangou_price());
			document.setTarget_url_m(luceneVo.getVo_target_url_m());
			return document;
		} else if ("lifegoods".equals(luceneVo.getVo_type())) {
			LifeGoodsDocument document = new LifeGoodsDocument();
			document.setId(String.valueOf(luceneVo.getVo_id()));
			document.setTitle(Jsoup.clean(luceneVo.getVo_title(), white.none()));
			document.setContent(Jsoup.clean(luceneVo.getVo_content(), white.none()));
			document.setType(luceneVo.getVo_type());
			document.setStore_price(luceneVo.getVo_store_price());
			document.setAdd_time(luceneVo.getVo_add_time());
			document.setGoods_salenum(CommUtil.null2String(luceneVo.getVo_goods_salenum()));
			document.setGoods_cat(CommUtil.null2String(luceneVo.getVo_cat()));

			if (luceneVo.getVo_main_photo_url() != null) {
				document.setMain_photo_url(CommUtil.null2String(luceneVo.getVo_main_photo_url()));

			}
			document.setGoods_area(CommUtil.null2String(luceneVo.getVo_goods_area()));
			document.setGoods_rate(CommUtil.null2String(luceneVo.getVo_rate()));
			document.setCost_price(CommUtil.null2String(luceneVo.getVo_cost_price()));
			return document;
		} else if ("groupgoods".equals(luceneVo.getVo_type())) {
			GroupGoodsDocument document = new GroupGoodsDocument();
			document.setId(String.valueOf(luceneVo.getVo_id()));
			document.setTitle(Jsoup.clean(luceneVo.getVo_title(), white.none()));
			document.setContent(Jsoup.clean(luceneVo.getVo_content(), white.none()));
			document.setType(luceneVo.getVo_type());
			document.setStore_price(luceneVo.getVo_store_price());
			document.setAdd_time(luceneVo.getVo_add_time());
			document.setGoods_salenum(CommUtil.null2String(luceneVo.getVo_goods_salenum()));
			document.setGoods_cat(CommUtil.null2String(luceneVo.getVo_cat()));

			if (luceneVo.getVo_main_photo_url() != null) {
				document.setMain_photo_url(CommUtil.null2String(luceneVo.getVo_main_photo_url()));

			}
			document.setGoods_area(CommUtil.null2String(luceneVo.getVo_goods_area()));
			document.setGoods_rate(CommUtil.null2String(luceneVo.getVo_rate()));
			document.setCost_price(CommUtil.null2String(luceneVo.getVo_cost_price()));
			return document;
		} else {
			return new EsDocument();
		}
		// return document;
	}

}
