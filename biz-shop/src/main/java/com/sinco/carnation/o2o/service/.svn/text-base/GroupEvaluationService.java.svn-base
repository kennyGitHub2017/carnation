package com.sinco.carnation.o2o.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.elasticsearch.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.bo.GroupEvaluationStoreTotalBO;
import com.sinco.carnation.o2o.dao.GroupEvaluationDao;
import com.sinco.carnation.o2o.dao.GroupEvaluationStoreTotalDao;
import com.sinco.carnation.o2o.dao.GroupOrderDao;
import com.sinco.carnation.o2o.model.GroupEvaluation;
import com.sinco.carnation.o2o.model.GroupEvaluationExample;
import com.sinco.carnation.o2o.model.GroupEvaluationExample.Criteria;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotal;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotalExample;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.service.exceptions.CheckException;
import com.sinco.carnation.o2o.service.exceptions.EvaluationContentSizeExcepiton;
import com.sinco.carnation.o2o.service.exceptions.EvaluationPhotoSizeExcepiton;
import com.sinco.carnation.o2o.service.exceptions.EvaluationScoreZeroException;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.dal.common.MyPage;
import com.sinco.dal.utils.DateUtils;

/**
 * 团购评价业务层
 * 
 * @author Young
 * 
 */
@Service
@Transactional
public class GroupEvaluationService {
	@Autowired
	private GroupEvaluationDao dao;
	@Autowired
	private GroupOrderDao orderDao;
	@Autowired
	private GroupEvaluationStoreTotalDao totalDao;
	@Autowired
	private StoreSearchService storeSearchService;
	@Autowired
	private IntegralService integralService;

	@Autowired
	private OrderFormTools orderFormTools;

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	private static String groupEvaluation_cached_key = "groupEvaluation_cached_key";

	private final Integer expireTime = 300;

	private static final Logger logger = LoggerFactory.getLogger(IntegralService.class);

	/**
	 * 修改用户上传图片链接 如上传图片 如删除图片
	 * 
	 * @param photoUrls
	 *            需要保存的链接
	 * @return
	 * @throws EvaluationPhotoSizeExcepiton
	 * @throws Exception
	 */
	public boolean updatePhotos(long evaluateUserId, long orderId, String photoUrls) throws CheckException,
			EvaluationPhotoSizeExcepiton {
		if (orderId < 1)
			throw new CheckException("提交的参数有误");// 不存在的订单

		GroupOrder groupOrder = orderDao.findOne(orderId);
		if (groupOrder.getOrderStatus() != 30)
			throw new CheckException("提交的参数有误");// 只能评价订单状态为30的订单

		if (!Strings.isNullOrEmpty(photoUrls) && photoUrls.split(";").length > 6)
			throw new EvaluationPhotoSizeExcepiton("限制最多上传6张图片");

		Date date = new Date();
		GroupEvaluation evaluation = new GroupEvaluation();
		evaluation.setPhotoUrls(photoUrls);
		evaluation.setUpdateTime(date);
		evaluation.setOrderId(orderId);

		// 限制订单号 唯一
		GroupEvaluationBO bo = dao.findOne(orderId);

		if (null == bo) {
			evaluation.setEvaluateUserId(evaluateUserId);
			evaluation.setCreateTime(date);
			evaluation.setStatus(1);
			evaluation = dao.insert(evaluation);
			return null != evaluation;
		}

		if (bo.getStatus() != 1)
			throw new CheckException("所传参数有误");// 只能针对评价记录status=1的状态评价

		boolean b = dao.updateIgnoreNull(evaluation) > 0;
		refreshGroupCase(Long.valueOf(groupOrder.getStoreId()));// 刷新缓存-cc
		return b;
	}

	public List<GroupEvaluationBO> query(GroupEvaluationExample example) {
		return dao.query(example);
	}

	/**
	 * 查找是否存在评价
	 * 
	 * @param evaluationId
	 *            评价id
	 * @param status
	 *            评价状态
	 * @return
	 */
	public long countByStatus(Long orderId, int status) {
		GroupEvaluationExample example = new GroupEvaluationExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId).andStatusEqualTo(status);
		return dao.count(example);
	}

	/**
	 * 保存评价 已上传图片则修改 未上传则新建
	 * 
	 * @param evaluation
	 * @return
	 * @throws EvaluationPhotoSizeExcepiton
	 * @throws EvaluationContentSizeExcepiton
	 * @throws EvaluationScoreZeroException
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public boolean save(GroupEvaluation evaluation) throws CheckException, EvaluationPhotoSizeExcepiton,
			EvaluationContentSizeExcepiton, EvaluationScoreZeroException {
		// -------检测必填参数
		if (null == evaluation.getOrderId() || evaluation.getOrderId() < 1
				|| evaluation.getEvaluateUserId() < 1)
			throw new CheckException("提交的参数有误");//

		if (!Strings.isNullOrEmpty(evaluation.getPhotoUrls())
				&& evaluation.getPhotoUrls().split(";").length > 6)
			throw new EvaluationPhotoSizeExcepiton("限制最多上传6张图片");

		if (null == evaluation.getContent() || evaluation.getContent().trim().equals("")
				|| evaluation.getContent().getBytes().length > 500 * 3)
			throw new EvaluationContentSizeExcepiton("内容不能为空且不超过500个字符");

		if (null == evaluation.getScore() || evaluation.getScore() < 1 || evaluation.getScore() > 5)
			throw new EvaluationScoreZeroException("评分项不能为空且1~5");

		GroupOrder groupOrder = orderDao.findOne(evaluation.getOrderId());
		if (groupOrder.getOrderStatus() != 30)
			throw new CheckException("提交的参数有误");// 只能评价订单状态为30的订单

		// 限制订单号 唯一
		GroupEvaluationBO bo = dao.findOne(evaluation.getOrderId());

		Date date = new Date();
		evaluation.setUpdateTime(date);
		evaluation.setStatus(2);
		evaluation.setEvaluateTime(date);
		evaluation.setContent(CommUtil.filterHTML(evaluation.getContent()));
		if (null == bo) {
			evaluation.setCreateTime(date);
			evaluation = dao.insert(evaluation);
			GroupOrder order = new GroupOrder();
			order.setId(groupOrder.getId());
			order.setOrderStatus(50);
			orderDao.update(order);
			boolean b = null != evaluation;
			if (b)
				try {
					integralService.addIntegral(IntegralConstants.INTEGRAL_EVALUATE,
							evaluation.getEvaluateUserId(), null);
				} catch (Exception e) {
					logger.error("add integral is unsuccess userid = evaluation.getEvaluateUserId()");
				}
			refreshGroupCase(Long.valueOf(groupOrder.getStoreId()));// 刷新缓存-cc
			return b;
		}

		if (bo.getStatus() != 1)
			throw new CheckException("所传参数有误");// 只能针对评价记录status=1的状态评价

		boolean b = dao.updateIgnoreNull(evaluation) > 0;
		if (b) {
			// 这里不直接用上面fetch到的groupOrder是防止并发被改变值了
			GroupOrder order = new GroupOrder();
			order.setId(groupOrder.getId());
			order.setOrderStatus(50);
			orderDao.update(order);
			try {
				integralService.addIntegral(IntegralConstants.INTEGRAL_EVALUATE,
						evaluation.getEvaluateUserId(), null);
			} catch (Exception e) {
				logger.error("add integral is unsuccess userid = evaluation.getEvaluateUserId()");
			}
			refreshGroupCase(Long.valueOf(groupOrder.getStoreId()));// 刷新缓存-cc
		}
		return b;
	}

	/**
	 * 商家回复
	 * 
	 * @param evaluateId
	 *            评价id
	 * @param replyContent
	 *            商家回复内容
	 * @return
	 * @throws CheckException
	 * @throws EvaluationContentSizeExcepiton
	 */
	@Transactional(readOnly = false)
	public boolean reply(long sellerId, long orderId, String replyContent) throws CheckException,
			EvaluationContentSizeExcepiton {
		if (null == replyContent || replyContent.getBytes().length > 500 * 2)
			throw new EvaluationContentSizeExcepiton("内容不能为空且不超过500个字符");

		if (countByStatus(orderId, 2) == 0) // 只能评价已评价订单
			throw new CheckException("提交参数有误");

		// GroupEvaluation groupEvaluation = dao.findOne(orderId);

		// 这里的检验没必要了，因为是后台的
		// GroupOrder groupOrder =
		// orderDao.findOne(groupEvaluation.getOrderId());
		// if (groupOrder.getOrderStatus() != 50)
		// throw new CheckException("提交的参数有误");// 只能评价订单状态为30的订单

		GroupEvaluation evaluation = new GroupEvaluation();
		evaluation.setReplyContent(CommUtil.filterHTML(replyContent));
		evaluation.setEvaluateSellerId(sellerId);
		evaluation.setReplyTime(new Date());
		evaluation.setUpdateTime(evaluation.getEvaluateTime());
		evaluation.setStatus(3);
		evaluation.setOrderId(orderId);

		boolean b = dao.updateIgnoreNull(evaluation) > 0;
		if (b) {
			// 这里不直接用上面fetch到的groupOrder是防止并发被改变值了
			GroupOrder order = new GroupOrder();
			order.setOrderStatus(60);
			order.setId(orderId);
			orderDao.update(order);
		}
		return b;
	}

	public GroupEvaluationBO fetch(Long orderId) {
		return dao.findOne(orderId);
	}

	public void query(GroupEvaluationVO vo, MyPage<GroupEvaluationBO> page) {
		dao.query(vo, page);
	}

	public void queryByVO(GroupEvaluationVO vo, MyPage<GroupEvaluationBO> page) {
		dao.queryByVO(vo, page);
//		if(StringUtils.isNotBlank(vo.getGoodsName())){
//			List<GroupEvaluationBO> list = page.getContent();
//			List<GroupEvaluationBO> newList = new ArrayList<GroupEvaluationBO>();
//			for(GroupEvaluationBO bo:list){
//				Map map = orderFormTools.queryGroupInfo( bo.getGroupInfo());
//				String groupName = map.get("goods_name").toString();
//				if(groupName.contains(vo.getGoodsName())){
//					newList.add(bo);
//				}
//			}
//			page.setContent(newList);
//		}
	}

	public void queryByStoreName(String storeName, MyPage<GroupEvaluationBO> page) {
		if (null != storeName && storeName.trim().equals(""))
			storeName = null;
		else if (null != storeName)
			storeName = storeName.trim();
		dao.queryByStoreName(storeName, page);

	}

	/**
	 * 店铺总评价人数 和 总评分
	 * 
	 * @param storeId
	 * @return
	 */
	public GroupEvaluationBO fetchStoreTotal(Long storeId) {
		return dao.fetchStoreTotal(storeId);
	}

	/**
	 * 店铺按各个评分的汇总
	 * 
	 * @param storeId
	 * @return
	 */
	public List<GroupEvaluationBO> queryStoreByScores(Long storeId) {
		return dao.queryStoreByScores(storeId);
	}

	/**
	 * 商品/服务总评价人数 和 总评分
	 * 
	 * @param storeId
	 * @return
	 */
	public GroupEvaluationBO fetchGoodsTotal(Long storeId) {
		// 无此需求
		return null;
	}

	/**
	 * 商品/服务按各个评分的汇总
	 * 
	 * @param storeId
	 * @return
	 */
	public List<GroupEvaluationBO> queryGoodsByScores(Long storeId) {
		// 无此需求
		return null;
	}

	// /**
	// * 查询店铺评价
	// * 评价按店铺和
	// * @param storeId
	// * @return
	// */
	// public GroupEvaluationBO fetchStoreTotal(Long storeId){
	// return dao.fetchStoreTotal(storeId);
	// }
	// public List<GroupEvaluationBO> queryScoreTotal(Long storeId){
	// return dao.queryScoreTotal(storeId);
	// }
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void dataToTotal(int n) {
		// 查找最近n分钟未更新的合计记录
		Date date = DateUtils.addMinutes(new Date(), -n);

		// 当前时间之前的记录
		GroupEvaluationStoreTotalExample totalExample = new GroupEvaluationStoreTotalExample();
		totalExample.createCriteria().andUpdateTimeLessThanOrEqualTo(date);
		List<GroupEvaluationStoreTotalBO> totalBOs = totalDao.queryByExample(totalExample);

		// 没有更新时间的记录
		totalExample = new GroupEvaluationStoreTotalExample();
		totalExample.createCriteria().andUpdateTimeIsNull();
		totalBOs.addAll(totalDao.queryByExample(totalExample));

		for (GroupEvaluationStoreTotalBO bo : totalBOs) {
			// 按店查询各个分数的数量
			List<GroupEvaluationBO> scores = dao.queryStoreByScores(bo.getStoreId());
			if (null != scores && scores.size() > 0) {
				for (GroupEvaluationBO score : scores) {
					switch (score.getScore()) {
						case 1:
							bo.setOne(score.getNum());
							break;
						case 2:
							bo.setTwo(score.getNum());
							break;
						case 3:
							bo.setThree(score.getNum());
							break;
						case 4:
							bo.setFour(score.getNum());
							break;
						case 5:
							bo.setFive(score.getNum());
							break;
					}

					GroupEvaluationStoreTotal e = totalDao.findOne(bo.getStoreId());
					bo.setUpdateTime(new Date());
					if (null == e)
						totalDao.add(bo);
					else
						totalDao.update(bo);
					storeSearchService.updateIndex(bo.getStoreId());
				}
			}

		}

	}

	/**
	 * 刷新缓存
	 * 
	 * @return cc
	 */
	@Transactional(readOnly = true)
	public GroupEvaluationBO refreshGroupCase(Long id) {
		StringBuilder key = new StringBuilder(groupEvaluation_cached_key);
		key.append(":").append(id);
		GroupEvaluationBO evaluationBO = fetchStoreTotal(id);
		cacheUtils.set(key.toString(), evaluationBO, expireTime);
		// localCache.invalidateAll();
		return evaluationBO;
	}

	/**
	 * 对内使用//查询是否存在该店铺id所对应评价等缓存，不存在则重新load缓存
	 * 
	 * @return cc
	 */
	private GroupEvaluationBO toGetGroupCase(Long id) {
		StringBuilder key = new StringBuilder(groupEvaluation_cached_key);
		key.append(":").append(id);
		GroupEvaluationBO evaluationBO = cacheUtils.get(key.toString(),
				new TypeReference<GroupEvaluationBO>() {});
		if (evaluationBO == null) {
			evaluationBO = fetchStoreTotal(id);
			if (evaluationBO == null) {
				evaluationBO = new GroupEvaluationBO();
			}
			cacheUtils.set(key.toString(), evaluationBO, expireTime);
		}
		return evaluationBO;
	}

	/**
	 * 店铺总评价人数 和 总评分仅用于刷新缓存
	 * 
	 * @param storeId
	 * @return
	 */
	public GroupEvaluationBO fetchStoreTotal_(Long storeId) {
		return toGetGroupCase(storeId);
	}
}
