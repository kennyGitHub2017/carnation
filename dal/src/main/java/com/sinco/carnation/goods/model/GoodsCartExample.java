package com.sinco.carnation.goods.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsCartExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsCartExample() {
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNull() {
			addCriterion("add_time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_time not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNull() {
			addCriterion("delete_status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Integer value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Integer value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Integer value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Integer value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Integer> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Integer> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdIsNull() {
			addCriterion("cart_mobile_id is null");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdIsNotNull() {
			addCriterion("cart_mobile_id is not null");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdEqualTo(String value) {
			addCriterion("cart_mobile_id =", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdNotEqualTo(String value) {
			addCriterion("cart_mobile_id <>", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdGreaterThan(String value) {
			addCriterion("cart_mobile_id >", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdGreaterThanOrEqualTo(String value) {
			addCriterion("cart_mobile_id >=", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdLessThan(String value) {
			addCriterion("cart_mobile_id <", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdLessThanOrEqualTo(String value) {
			addCriterion("cart_mobile_id <=", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdLike(String value) {
			addCriterion("cart_mobile_id like", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdNotLike(String value) {
			addCriterion("cart_mobile_id not like", value, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdIn(List<String> values) {
			addCriterion("cart_mobile_id in", values, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdNotIn(List<String> values) {
			addCriterion("cart_mobile_id not in", values, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdBetween(String value1, String value2) {
			addCriterion("cart_mobile_id between", value1, value2, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartMobileIdNotBetween(String value1, String value2) {
			addCriterion("cart_mobile_id not between", value1, value2, "cartMobileId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdIsNull() {
			addCriterion("cart_session_id is null");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdIsNotNull() {
			addCriterion("cart_session_id is not null");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdEqualTo(String value) {
			addCriterion("cart_session_id =", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdNotEqualTo(String value) {
			addCriterion("cart_session_id <>", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdGreaterThan(String value) {
			addCriterion("cart_session_id >", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdGreaterThanOrEqualTo(String value) {
			addCriterion("cart_session_id >=", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdLessThan(String value) {
			addCriterion("cart_session_id <", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdLessThanOrEqualTo(String value) {
			addCriterion("cart_session_id <=", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdLike(String value) {
			addCriterion("cart_session_id like", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdNotLike(String value) {
			addCriterion("cart_session_id not like", value, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdIn(List<String> values) {
			addCriterion("cart_session_id in", values, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdNotIn(List<String> values) {
			addCriterion("cart_session_id not in", values, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdBetween(String value1, String value2) {
			addCriterion("cart_session_id between", value1, value2, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartSessionIdNotBetween(String value1, String value2) {
			addCriterion("cart_session_id not between", value1, value2, "cartSessionId");
			return (Criteria) this;
		}

		public Criteria andCartStatusIsNull() {
			addCriterion("cart_status is null");
			return (Criteria) this;
		}

		public Criteria andCartStatusIsNotNull() {
			addCriterion("cart_status is not null");
			return (Criteria) this;
		}

		public Criteria andCartStatusEqualTo(Integer value) {
			addCriterion("cart_status =", value, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusNotEqualTo(Integer value) {
			addCriterion("cart_status <>", value, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusGreaterThan(Integer value) {
			addCriterion("cart_status >", value, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("cart_status >=", value, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusLessThan(Integer value) {
			addCriterion("cart_status <", value, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusLessThanOrEqualTo(Integer value) {
			addCriterion("cart_status <=", value, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusIn(List<Integer> values) {
			addCriterion("cart_status in", values, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusNotIn(List<Integer> values) {
			addCriterion("cart_status not in", values, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusBetween(Integer value1, Integer value2) {
			addCriterion("cart_status between", value1, value2, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("cart_status not between", value1, value2, "cartStatus");
			return (Criteria) this;
		}

		public Criteria andCartTypeIsNull() {
			addCriterion("cart_type is null");
			return (Criteria) this;
		}

		public Criteria andCartTypeIsNotNull() {
			addCriterion("cart_type is not null");
			return (Criteria) this;
		}

		public Criteria andCartTypeEqualTo(String value) {
			addCriterion("cart_type =", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeNotEqualTo(String value) {
			addCriterion("cart_type <>", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeGreaterThan(String value) {
			addCriterion("cart_type >", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeGreaterThanOrEqualTo(String value) {
			addCriterion("cart_type >=", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeLessThan(String value) {
			addCriterion("cart_type <", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeLessThanOrEqualTo(String value) {
			addCriterion("cart_type <=", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeLike(String value) {
			addCriterion("cart_type like", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeNotLike(String value) {
			addCriterion("cart_type not like", value, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeIn(List<String> values) {
			addCriterion("cart_type in", values, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeNotIn(List<String> values) {
			addCriterion("cart_type not in", values, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeBetween(String value1, String value2) {
			addCriterion("cart_type between", value1, value2, "cartType");
			return (Criteria) this;
		}

		public Criteria andCartTypeNotBetween(String value1, String value2) {
			addCriterion("cart_type not between", value1, value2, "cartType");
			return (Criteria) this;
		}

		public Criteria andCombinMainIsNull() {
			addCriterion("combin_main is null");
			return (Criteria) this;
		}

		public Criteria andCombinMainIsNotNull() {
			addCriterion("combin_main is not null");
			return (Criteria) this;
		}

		public Criteria andCombinMainEqualTo(Integer value) {
			addCriterion("combin_main =", value, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainNotEqualTo(Integer value) {
			addCriterion("combin_main <>", value, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainGreaterThan(Integer value) {
			addCriterion("combin_main >", value, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_main >=", value, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainLessThan(Integer value) {
			addCriterion("combin_main <", value, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainLessThanOrEqualTo(Integer value) {
			addCriterion("combin_main <=", value, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainIn(List<Integer> values) {
			addCriterion("combin_main in", values, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainNotIn(List<Integer> values) {
			addCriterion("combin_main not in", values, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainBetween(Integer value1, Integer value2) {
			addCriterion("combin_main between", value1, value2, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMainNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_main not between", value1, value2, "combinMain");
			return (Criteria) this;
		}

		public Criteria andCombinMarkIsNull() {
			addCriterion("combin_mark is null");
			return (Criteria) this;
		}

		public Criteria andCombinMarkIsNotNull() {
			addCriterion("combin_mark is not null");
			return (Criteria) this;
		}

		public Criteria andCombinMarkEqualTo(String value) {
			addCriterion("combin_mark =", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkNotEqualTo(String value) {
			addCriterion("combin_mark <>", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkGreaterThan(String value) {
			addCriterion("combin_mark >", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkGreaterThanOrEqualTo(String value) {
			addCriterion("combin_mark >=", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkLessThan(String value) {
			addCriterion("combin_mark <", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkLessThanOrEqualTo(String value) {
			addCriterion("combin_mark <=", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkLike(String value) {
			addCriterion("combin_mark like", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkNotLike(String value) {
			addCriterion("combin_mark not like", value, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkIn(List<String> values) {
			addCriterion("combin_mark in", values, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkNotIn(List<String> values) {
			addCriterion("combin_mark not in", values, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkBetween(String value1, String value2) {
			addCriterion("combin_mark between", value1, value2, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinMarkNotBetween(String value1, String value2) {
			addCriterion("combin_mark not between", value1, value2, "combinMark");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsIsNull() {
			addCriterion("combin_suit_ids is null");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsIsNotNull() {
			addCriterion("combin_suit_ids is not null");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsEqualTo(String value) {
			addCriterion("combin_suit_ids =", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsNotEqualTo(String value) {
			addCriterion("combin_suit_ids <>", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsGreaterThan(String value) {
			addCriterion("combin_suit_ids >", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsGreaterThanOrEqualTo(String value) {
			addCriterion("combin_suit_ids >=", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsLessThan(String value) {
			addCriterion("combin_suit_ids <", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsLessThanOrEqualTo(String value) {
			addCriterion("combin_suit_ids <=", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsLike(String value) {
			addCriterion("combin_suit_ids like", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsNotLike(String value) {
			addCriterion("combin_suit_ids not like", value, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsIn(List<String> values) {
			addCriterion("combin_suit_ids in", values, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsNotIn(List<String> values) {
			addCriterion("combin_suit_ids not in", values, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsBetween(String value1, String value2) {
			addCriterion("combin_suit_ids between", value1, value2, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdsNotBetween(String value1, String value2) {
			addCriterion("combin_suit_ids not between", value1, value2, "combinSuitIds");
			return (Criteria) this;
		}

		public Criteria andCountIsNull() {
			addCriterion("count is null");
			return (Criteria) this;
		}

		public Criteria andCountIsNotNull() {
			addCriterion("count is not null");
			return (Criteria) this;
		}

		public Criteria andCountEqualTo(Integer value) {
			addCriterion("count =", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotEqualTo(Integer value) {
			addCriterion("count <>", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountGreaterThan(Integer value) {
			addCriterion("count >", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("count >=", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountLessThan(Integer value) {
			addCriterion("count <", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountLessThanOrEqualTo(Integer value) {
			addCriterion("count <=", value, "count");
			return (Criteria) this;
		}

		public Criteria andCountIn(List<Integer> values) {
			addCriterion("count in", values, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotIn(List<Integer> values) {
			addCriterion("count not in", values, "count");
			return (Criteria) this;
		}

		public Criteria andCountBetween(Integer value1, Integer value2) {
			addCriterion("count between", value1, value2, "count");
			return (Criteria) this;
		}

		public Criteria andCountNotBetween(Integer value1, Integer value2) {
			addCriterion("count not between", value1, value2, "count");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(BigDecimal value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(BigDecimal value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(BigDecimal value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(BigDecimal value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<BigDecimal> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<BigDecimal> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Long value) {
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Long value) {
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Long value) {
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Long value) {
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Long> values) {
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Long> values) {
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Long value1, Long value2) {
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_id not between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andCartGspIsNull() {
			addCriterion("cart_gsp is null");
			return (Criteria) this;
		}

		public Criteria andCartGspIsNotNull() {
			addCriterion("cart_gsp is not null");
			return (Criteria) this;
		}

		public Criteria andCartGspEqualTo(String value) {
			addCriterion("cart_gsp =", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspNotEqualTo(String value) {
			addCriterion("cart_gsp <>", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspGreaterThan(String value) {
			addCriterion("cart_gsp >", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspGreaterThanOrEqualTo(String value) {
			addCriterion("cart_gsp >=", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspLessThan(String value) {
			addCriterion("cart_gsp <", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspLessThanOrEqualTo(String value) {
			addCriterion("cart_gsp <=", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspLike(String value) {
			addCriterion("cart_gsp like", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspNotLike(String value) {
			addCriterion("cart_gsp not like", value, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspIn(List<String> values) {
			addCriterion("cart_gsp in", values, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspNotIn(List<String> values) {
			addCriterion("cart_gsp not in", values, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspBetween(String value1, String value2) {
			addCriterion("cart_gsp between", value1, value2, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCartGspNotBetween(String value1, String value2) {
			addCriterion("cart_gsp not between", value1, value2, "cartGsp");
			return (Criteria) this;
		}

		public Criteria andCombinVersionIsNull() {
			addCriterion("combin_version is null");
			return (Criteria) this;
		}

		public Criteria andCombinVersionIsNotNull() {
			addCriterion("combin_version is not null");
			return (Criteria) this;
		}

		public Criteria andCombinVersionEqualTo(String value) {
			addCriterion("combin_version =", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionNotEqualTo(String value) {
			addCriterion("combin_version <>", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionGreaterThan(String value) {
			addCriterion("combin_version >", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionGreaterThanOrEqualTo(String value) {
			addCriterion("combin_version >=", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionLessThan(String value) {
			addCriterion("combin_version <", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionLessThanOrEqualTo(String value) {
			addCriterion("combin_version <=", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionLike(String value) {
			addCriterion("combin_version like", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionNotLike(String value) {
			addCriterion("combin_version not like", value, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionIn(List<String> values) {
			addCriterion("combin_version in", values, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionNotIn(List<String> values) {
			addCriterion("combin_version not in", values, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionBetween(String value1, String value2) {
			addCriterion("combin_version between", value1, value2, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andCombinVersionNotBetween(String value1, String value2) {
			addCriterion("combin_version not between", value1, value2, "combinVersion");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftIsNull() {
			addCriterion("whether_choose_gift is null");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftIsNotNull() {
			addCriterion("whether_choose_gift is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftEqualTo(Integer value) {
			addCriterion("whether_choose_gift =", value, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftNotEqualTo(Integer value) {
			addCriterion("whether_choose_gift <>", value, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftGreaterThan(Integer value) {
			addCriterion("whether_choose_gift >", value, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftGreaterThanOrEqualTo(Integer value) {
			addCriterion("whether_choose_gift >=", value, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftLessThan(Integer value) {
			addCriterion("whether_choose_gift <", value, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftLessThanOrEqualTo(Integer value) {
			addCriterion("whether_choose_gift <=", value, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftIn(List<Integer> values) {
			addCriterion("whether_choose_gift in", values, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftNotIn(List<Integer> values) {
			addCriterion("whether_choose_gift not in", values, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftBetween(Integer value1, Integer value2) {
			addCriterion("whether_choose_gift between", value1, value2, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andWhetherChooseGiftNotBetween(Integer value1, Integer value2) {
			addCriterion("whether_choose_gift not between", value1, value2, "whetherChooseGift");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralIsNull() {
			addCriterion("exchange_integral is null");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralIsNotNull() {
			addCriterion("exchange_integral is not null");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralEqualTo(Integer value) {
			addCriterion("exchange_integral =", value, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralNotEqualTo(Integer value) {
			addCriterion("exchange_integral <>", value, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralGreaterThan(Integer value) {
			addCriterion("exchange_integral >", value, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("exchange_integral >=", value, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralLessThan(Integer value) {
			addCriterion("exchange_integral <", value, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("exchange_integral <=", value, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralIn(List<Integer> values) {
			addCriterion("exchange_integral in", values, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralNotIn(List<Integer> values) {
			addCriterion("exchange_integral not in", values, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralBetween(Integer value1, Integer value2) {
			addCriterion("exchange_integral between", value1, value2, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andExchangeIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("exchange_integral not between", value1, value2, "exchangeIntegral");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceIsNull() {
			addCriterion("goods_integral_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceIsNotNull() {
			addCriterion("goods_integral_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceEqualTo(BigDecimal value) {
			addCriterion("goods_integral_price =", value, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceNotEqualTo(BigDecimal value) {
			addCriterion("goods_integral_price <>", value, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceGreaterThan(BigDecimal value) {
			addCriterion("goods_integral_price >", value, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_integral_price >=", value, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceLessThan(BigDecimal value) {
			addCriterion("goods_integral_price <", value, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_integral_price <=", value, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceIn(List<BigDecimal> values) {
			addCriterion("goods_integral_price in", values, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceNotIn(List<BigDecimal> values) {
			addCriterion("goods_integral_price not in", values, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_integral_price between", value1, value2, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsIntegralPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_integral_price not between", value1, value2, "goodsIntegralPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceIsNull() {
			addCriterion("goods_mobile_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceIsNotNull() {
			addCriterion("goods_mobile_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceEqualTo(BigDecimal value) {
			addCriterion("goods_mobile_price =", value, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceNotEqualTo(BigDecimal value) {
			addCriterion("goods_mobile_price <>", value, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceGreaterThan(BigDecimal value) {
			addCriterion("goods_mobile_price >", value, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_mobile_price >=", value, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceLessThan(BigDecimal value) {
			addCriterion("goods_mobile_price <", value, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_mobile_price <=", value, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceIn(List<BigDecimal> values) {
			addCriterion("goods_mobile_price in", values, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceNotIn(List<BigDecimal> values) {
			addCriterion("goods_mobile_price not in", values, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_mobile_price between", value1, value2, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andGoodsMobilePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_mobile_price not between", value1, value2, "goodsMobilePrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceIsNull() {
			addCriterion("self_add_price is null");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceIsNotNull() {
			addCriterion("self_add_price is not null");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceEqualTo(BigDecimal value) {
			addCriterion("self_add_price =", value, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceNotEqualTo(BigDecimal value) {
			addCriterion("self_add_price <>", value, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceGreaterThan(BigDecimal value) {
			addCriterion("self_add_price >", value, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("self_add_price >=", value, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceLessThan(BigDecimal value) {
			addCriterion("self_add_price <", value, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("self_add_price <=", value, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceIn(List<BigDecimal> values) {
			addCriterion("self_add_price in", values, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceNotIn(List<BigDecimal> values) {
			addCriterion("self_add_price not in", values, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("self_add_price between", value1, value2, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andSelfAddPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("self_add_price not between", value1, value2, "selfAddPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionIsNull() {
			addCriterion("goods_version is null");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionIsNotNull() {
			addCriterion("goods_version is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionEqualTo(Integer value) {
			addCriterion("goods_version =", value, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionNotEqualTo(Integer value) {
			addCriterion("goods_version <>", value, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionGreaterThan(Integer value) {
			addCriterion("goods_version >", value, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_version >=", value, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionLessThan(Integer value) {
			addCriterion("goods_version <", value, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionLessThanOrEqualTo(Integer value) {
			addCriterion("goods_version <=", value, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionIn(List<Integer> values) {
			addCriterion("goods_version in", values, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionNotIn(List<Integer> values) {
			addCriterion("goods_version not in", values, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionBetween(Integer value1, Integer value2) {
			addCriterion("goods_version between", value1, value2, "goodsVersion");
			return (Criteria) this;
		}

		public Criteria andGoodsVersionNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_version not between", value1, value2, "goodsVersion");
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