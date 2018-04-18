package com.sinco.carnation.o2o.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupEvaluationExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GroupEvaluationExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Long value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Long value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Long value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Long value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Long value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Long> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Long> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Long value1, Long value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Long value1, Long value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andScoreIsNull() {
			addCriterion("score is null");
			return (Criteria) this;
		}

		public Criteria andScoreIsNotNull() {
			addCriterion("score is not null");
			return (Criteria) this;
		}

		public Criteria andScoreEqualTo(Integer value) {
			addCriterion("score =", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotEqualTo(Integer value) {
			addCriterion("score <>", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThan(Integer value) {
			addCriterion("score >", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("score >=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThan(Integer value) {
			addCriterion("score <", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThanOrEqualTo(Integer value) {
			addCriterion("score <=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreIn(List<Integer> values) {
			addCriterion("score in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotIn(List<Integer> values) {
			addCriterion("score not in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreBetween(Integer value1, Integer value2) {
			addCriterion("score between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("score not between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdIsNull() {
			addCriterion("evaluate_user_id is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdIsNotNull() {
			addCriterion("evaluate_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdEqualTo(Long value) {
			addCriterion("evaluate_user_id =", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdNotEqualTo(Long value) {
			addCriterion("evaluate_user_id <>", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdGreaterThan(Long value) {
			addCriterion("evaluate_user_id >", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("evaluate_user_id >=", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdLessThan(Long value) {
			addCriterion("evaluate_user_id <", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdLessThanOrEqualTo(Long value) {
			addCriterion("evaluate_user_id <=", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdIn(List<Long> values) {
			addCriterion("evaluate_user_id in", values, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdNotIn(List<Long> values) {
			addCriterion("evaluate_user_id not in", values, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdBetween(Long value1, Long value2) {
			addCriterion("evaluate_user_id between", value1, value2, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdNotBetween(Long value1, Long value2) {
			addCriterion("evaluate_user_id not between", value1, value2, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdIsNull() {
			addCriterion("evaluate_seller_id is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdIsNotNull() {
			addCriterion("evaluate_seller_id is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdEqualTo(Long value) {
			addCriterion("evaluate_seller_id =", value, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdNotEqualTo(Long value) {
			addCriterion("evaluate_seller_id <>", value, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdGreaterThan(Long value) {
			addCriterion("evaluate_seller_id >", value, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdGreaterThanOrEqualTo(Long value) {
			addCriterion("evaluate_seller_id >=", value, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdLessThan(Long value) {
			addCriterion("evaluate_seller_id <", value, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdLessThanOrEqualTo(Long value) {
			addCriterion("evaluate_seller_id <=", value, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdIn(List<Long> values) {
			addCriterion("evaluate_seller_id in", values, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdNotIn(List<Long> values) {
			addCriterion("evaluate_seller_id not in", values, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdBetween(Long value1, Long value2) {
			addCriterion("evaluate_seller_id between", value1, value2, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andEvaluateSellerIdNotBetween(Long value1, Long value2) {
			addCriterion("evaluate_seller_id not between", value1, value2, "evaluateSellerId");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andReplyContentIsNull() {
			addCriterion("reply_content is null");
			return (Criteria) this;
		}

		public Criteria andReplyContentIsNotNull() {
			addCriterion("reply_content is not null");
			return (Criteria) this;
		}

		public Criteria andReplyContentEqualTo(String value) {
			addCriterion("reply_content =", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentNotEqualTo(String value) {
			addCriterion("reply_content <>", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentGreaterThan(String value) {
			addCriterion("reply_content >", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
			addCriterion("reply_content >=", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentLessThan(String value) {
			addCriterion("reply_content <", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentLessThanOrEqualTo(String value) {
			addCriterion("reply_content <=", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentLike(String value) {
			addCriterion("reply_content like", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentNotLike(String value) {
			addCriterion("reply_content not like", value, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentIn(List<String> values) {
			addCriterion("reply_content in", values, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentNotIn(List<String> values) {
			addCriterion("reply_content not in", values, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentBetween(String value1, String value2) {
			addCriterion("reply_content between", value1, value2, "replyContent");
			return (Criteria) this;
		}

		public Criteria andReplyContentNotBetween(String value1, String value2) {
			addCriterion("reply_content not between", value1, value2, "replyContent");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsIsNull() {
			addCriterion("photo_urls is null");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsIsNotNull() {
			addCriterion("photo_urls is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsEqualTo(String value) {
			addCriterion("photo_urls =", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotEqualTo(String value) {
			addCriterion("photo_urls <>", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsGreaterThan(String value) {
			addCriterion("photo_urls >", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsGreaterThanOrEqualTo(String value) {
			addCriterion("photo_urls >=", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsLessThan(String value) {
			addCriterion("photo_urls <", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsLessThanOrEqualTo(String value) {
			addCriterion("photo_urls <=", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsLike(String value) {
			addCriterion("photo_urls like", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotLike(String value) {
			addCriterion("photo_urls not like", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsIn(List<String> values) {
			addCriterion("photo_urls in", values, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotIn(List<String> values) {
			addCriterion("photo_urls not in", values, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsBetween(String value1, String value2) {
			addCriterion("photo_urls between", value1, value2, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotBetween(String value1, String value2) {
			addCriterion("photo_urls not between", value1, value2, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeIsNull() {
			addCriterion("evaluate_time is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeIsNotNull() {
			addCriterion("evaluate_time is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeEqualTo(Date value) {
			addCriterion("evaluate_time =", value, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeNotEqualTo(Date value) {
			addCriterion("evaluate_time <>", value, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeGreaterThan(Date value) {
			addCriterion("evaluate_time >", value, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("evaluate_time >=", value, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeLessThan(Date value) {
			addCriterion("evaluate_time <", value, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeLessThanOrEqualTo(Date value) {
			addCriterion("evaluate_time <=", value, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeIn(List<Date> values) {
			addCriterion("evaluate_time in", values, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeNotIn(List<Date> values) {
			addCriterion("evaluate_time not in", values, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeBetween(Date value1, Date value2) {
			addCriterion("evaluate_time between", value1, value2, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andEvaluateTimeNotBetween(Date value1, Date value2) {
			addCriterion("evaluate_time not between", value1, value2, "evaluateTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIsNull() {
			addCriterion("reply_time is null");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIsNotNull() {
			addCriterion("reply_time is not null");
			return (Criteria) this;
		}

		public Criteria andReplyTimeEqualTo(Date value) {
			addCriterion("reply_time =", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotEqualTo(Date value) {
			addCriterion("reply_time <>", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeGreaterThan(Date value) {
			addCriterion("reply_time >", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("reply_time >=", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeLessThan(Date value) {
			addCriterion("reply_time <", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
			addCriterion("reply_time <=", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIn(List<Date> values) {
			addCriterion("reply_time in", values, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotIn(List<Date> values) {
			addCriterion("reply_time not in", values, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeBetween(Date value1, Date value2) {
			addCriterion("reply_time between", value1, value2, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
			addCriterion("reply_time not between", value1, value2, "replyTime");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeIsNull() {
			addCriterion("delete_time is null");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeIsNotNull() {
			addCriterion("delete_time is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeEqualTo(Date value) {
			addCriterion("delete_time =", value, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeNotEqualTo(Date value) {
			addCriterion("delete_time <>", value, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeGreaterThan(Date value) {
			addCriterion("delete_time >", value, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("delete_time >=", value, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeLessThan(Date value) {
			addCriterion("delete_time <", value, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
			addCriterion("delete_time <=", value, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeIn(List<Date> values) {
			addCriterion("delete_time in", values, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeNotIn(List<Date> values) {
			addCriterion("delete_time not in", values, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeBetween(Date value1, Date value2) {
			addCriterion("delete_time between", value1, value2, "deleteTime");
			return (Criteria) this;
		}

		public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
			addCriterion("delete_time not between", value1, value2, "deleteTime");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}