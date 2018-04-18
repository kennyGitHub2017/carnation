package com.sinco.carnation.goods.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GoodsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()),
					property);
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

		public Criteria andActivityGoodsIdIsNull() {
			addCriterion("activity_goods_id is null");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdIsNotNull() {
			addCriterion("activity_goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdEqualTo(Long value) {
			addCriterion("activity_goods_id =", value, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdNotEqualTo(Long value) {
			addCriterion("activity_goods_id <>", value, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdGreaterThan(Long value) {
			addCriterion("activity_goods_id >", value, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("activity_goods_id >=", value, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdLessThan(Long value) {
			addCriterion("activity_goods_id <", value, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("activity_goods_id <=", value, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdIn(List<Long> values) {
			addCriterion("activity_goods_id in", values, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdNotIn(List<Long> values) {
			addCriterion("activity_goods_id not in", values, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdBetween(Long value1, Long value2) {
			addCriterion("activity_goods_id between", value1, value2, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("activity_goods_id not between", value1, value2, "activityGoodsId");
			return (Criteria) this;
		}

		public Criteria andActivityStatusIsNull() {
			addCriterion("activity_status is null");
			return (Criteria) this;
		}

		public Criteria andActivityStatusIsNotNull() {
			addCriterion("activity_status is not null");
			return (Criteria) this;
		}

		public Criteria andActivityStatusEqualTo(Integer value) {
			addCriterion("activity_status =", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusNotEqualTo(Integer value) {
			addCriterion("activity_status <>", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusGreaterThan(Integer value) {
			addCriterion("activity_status >", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("activity_status >=", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusLessThan(Integer value) {
			addCriterion("activity_status <", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusLessThanOrEqualTo(Integer value) {
			addCriterion("activity_status <=", value, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusIn(List<Integer> values) {
			addCriterion("activity_status in", values, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusNotIn(List<Integer> values) {
			addCriterion("activity_status not in", values, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusBetween(Integer value1, Integer value2) {
			addCriterion("activity_status between", value1, value2, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andActivityStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("activity_status not between", value1, value2, "activityStatus");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateIsNull() {
			addCriterion("advance_date is null");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateIsNotNull() {
			addCriterion("advance_date is not null");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateEqualTo(Date value) {
			addCriterionForJDBCDate("advance_date =", value, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("advance_date <>", value, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateGreaterThan(Date value) {
			addCriterionForJDBCDate("advance_date >", value, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("advance_date >=", value, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateLessThan(Date value) {
			addCriterionForJDBCDate("advance_date <", value, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("advance_date <=", value, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateIn(List<Date> values) {
			addCriterionForJDBCDate("advance_date in", values, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("advance_date not in", values, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("advance_date between", value1, value2, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("advance_date not between", value1, value2, "advanceDate");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeIsNull() {
			addCriterion("advance_sale_type is null");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeIsNotNull() {
			addCriterion("advance_sale_type is not null");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeEqualTo(Integer value) {
			addCriterion("advance_sale_type =", value, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeNotEqualTo(Integer value) {
			addCriterion("advance_sale_type <>", value, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeGreaterThan(Integer value) {
			addCriterion("advance_sale_type >", value, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("advance_sale_type >=", value, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeLessThan(Integer value) {
			addCriterion("advance_sale_type <", value, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeLessThanOrEqualTo(Integer value) {
			addCriterion("advance_sale_type <=", value, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeIn(List<Integer> values) {
			addCriterion("advance_sale_type in", values, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeNotIn(List<Integer> values) {
			addCriterion("advance_sale_type not in", values, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeBetween(Integer value1, Integer value2) {
			addCriterion("advance_sale_type between", value1, value2, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andAdvanceSaleTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("advance_sale_type not between", value1, value2, "advanceSaleType");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateIsNull() {
			addCriterion("bad_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateIsNotNull() {
			addCriterion("bad_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateEqualTo(BigDecimal value) {
			addCriterion("bad_evaluate =", value, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("bad_evaluate <>", value, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateGreaterThan(BigDecimal value) {
			addCriterion("bad_evaluate >", value, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("bad_evaluate >=", value, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateLessThan(BigDecimal value) {
			addCriterion("bad_evaluate <", value, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("bad_evaluate <=", value, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateIn(List<BigDecimal> values) {
			addCriterion("bad_evaluate in", values, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("bad_evaluate not in", values, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("bad_evaluate between", value1, value2, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBadEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("bad_evaluate not between", value1, value2, "badEvaluate");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountIsNull() {
			addCriterion("buy_gift_amount is null");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountIsNotNull() {
			addCriterion("buy_gift_amount is not null");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountEqualTo(BigDecimal value) {
			addCriterion("buy_gift_amount =", value, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountNotEqualTo(BigDecimal value) {
			addCriterion("buy_gift_amount <>", value, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountGreaterThan(BigDecimal value) {
			addCriterion("buy_gift_amount >", value, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_gift_amount >=", value, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountLessThan(BigDecimal value) {
			addCriterion("buy_gift_amount <", value, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_gift_amount <=", value, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountIn(List<BigDecimal> values) {
			addCriterion("buy_gift_amount in", values, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountNotIn(List<BigDecimal> values) {
			addCriterion("buy_gift_amount not in", values, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_gift_amount between", value1, value2, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_gift_amount not between", value1, value2, "buyGiftAmount");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdIsNull() {
			addCriterion("buy_gift_id is null");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdIsNotNull() {
			addCriterion("buy_gift_id is not null");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdEqualTo(Long value) {
			addCriterion("buy_gift_id =", value, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdNotEqualTo(Long value) {
			addCriterion("buy_gift_id <>", value, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdGreaterThan(Long value) {
			addCriterion("buy_gift_id >", value, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdGreaterThanOrEqualTo(Long value) {
			addCriterion("buy_gift_id >=", value, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdLessThan(Long value) {
			addCriterion("buy_gift_id <", value, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdLessThanOrEqualTo(Long value) {
			addCriterion("buy_gift_id <=", value, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdIn(List<Long> values) {
			addCriterion("buy_gift_id in", values, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdNotIn(List<Long> values) {
			addCriterion("buy_gift_id not in", values, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdBetween(Long value1, Long value2) {
			addCriterion("buy_gift_id between", value1, value2, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andBuyGiftIdNotBetween(Long value1, Long value2) {
			addCriterion("buy_gift_id not between", value1, value2, "buyGiftId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdIsNull() {
			addCriterion("combin_parts_id is null");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdIsNotNull() {
			addCriterion("combin_parts_id is not null");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdEqualTo(Long value) {
			addCriterion("combin_parts_id =", value, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdNotEqualTo(Long value) {
			addCriterion("combin_parts_id <>", value, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdGreaterThan(Long value) {
			addCriterion("combin_parts_id >", value, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("combin_parts_id >=", value, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdLessThan(Long value) {
			addCriterion("combin_parts_id <", value, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdLessThanOrEqualTo(Long value) {
			addCriterion("combin_parts_id <=", value, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdIn(List<Long> values) {
			addCriterion("combin_parts_id in", values, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdNotIn(List<Long> values) {
			addCriterion("combin_parts_id not in", values, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdBetween(Long value1, Long value2) {
			addCriterion("combin_parts_id between", value1, value2, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinPartsIdNotBetween(Long value1, Long value2) {
			addCriterion("combin_parts_id not between", value1, value2, "combinPartsId");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIsNull() {
			addCriterion("combin_status is null");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIsNotNull() {
			addCriterion("combin_status is not null");
			return (Criteria) this;
		}

		public Criteria andCombinStatusEqualTo(Integer value) {
			addCriterion("combin_status =", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotEqualTo(Integer value) {
			addCriterion("combin_status <>", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusGreaterThan(Integer value) {
			addCriterion("combin_status >", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_status >=", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusLessThan(Integer value) {
			addCriterion("combin_status <", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusLessThanOrEqualTo(Integer value) {
			addCriterion("combin_status <=", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIn(List<Integer> values) {
			addCriterion("combin_status in", values, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotIn(List<Integer> values) {
			addCriterion("combin_status not in", values, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusBetween(Integer value1, Integer value2) {
			addCriterion("combin_status between", value1, value2, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_status not between", value1, value2, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdIsNull() {
			addCriterion("combin_suit_id is null");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdIsNotNull() {
			addCriterion("combin_suit_id is not null");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdEqualTo(Long value) {
			addCriterion("combin_suit_id =", value, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdNotEqualTo(Long value) {
			addCriterion("combin_suit_id <>", value, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdGreaterThan(Long value) {
			addCriterion("combin_suit_id >", value, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdGreaterThanOrEqualTo(Long value) {
			addCriterion("combin_suit_id >=", value, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdLessThan(Long value) {
			addCriterion("combin_suit_id <", value, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdLessThanOrEqualTo(Long value) {
			addCriterion("combin_suit_id <=", value, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdIn(List<Long> values) {
			addCriterion("combin_suit_id in", values, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdNotIn(List<Long> values) {
			addCriterion("combin_suit_id not in", values, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdBetween(Long value1, Long value2) {
			addCriterion("combin_suit_id between", value1, value2, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andCombinSuitIdNotBetween(Long value1, Long value2) {
			addCriterion("combin_suit_id not between", value1, value2, "combinSuitId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIsNull() {
			addCriterion("delivery_area is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIsNotNull() {
			addCriterion("delivery_area is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaEqualTo(String value) {
			addCriterion("delivery_area =", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaNotEqualTo(String value) {
			addCriterion("delivery_area <>", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaGreaterThan(String value) {
			addCriterion("delivery_area >", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaGreaterThanOrEqualTo(String value) {
			addCriterion("delivery_area >=", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaLessThan(String value) {
			addCriterion("delivery_area <", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaLessThanOrEqualTo(String value) {
			addCriterion("delivery_area <=", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaLike(String value) {
			addCriterion("delivery_area like", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaNotLike(String value) {
			addCriterion("delivery_area not like", value, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIn(List<String> values) {
			addCriterion("delivery_area in", values, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaNotIn(List<String> values) {
			addCriterion("delivery_area not in", values, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaBetween(String value1, String value2) {
			addCriterion("delivery_area between", value1, value2, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaNotBetween(String value1, String value2) {
			addCriterion("delivery_area not between", value1, value2, "deliveryArea");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdIsNull() {
			addCriterion("delivery_area_id is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdIsNotNull() {
			addCriterion("delivery_area_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdEqualTo(Long value) {
			addCriterion("delivery_area_id =", value, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdNotEqualTo(Long value) {
			addCriterion("delivery_area_id <>", value, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdGreaterThan(Long value) {
			addCriterion("delivery_area_id >", value, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("delivery_area_id >=", value, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdLessThan(Long value) {
			addCriterion("delivery_area_id <", value, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdLessThanOrEqualTo(Long value) {
			addCriterion("delivery_area_id <=", value, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdIn(List<Long> values) {
			addCriterion("delivery_area_id in", values, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdNotIn(List<Long> values) {
			addCriterion("delivery_area_id not in", values, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdBetween(Long value1, Long value2) {
			addCriterion("delivery_area_id between", value1, value2, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAreaIdNotBetween(Long value1, Long value2) {
			addCriterion("delivery_area_id not between", value1, value2, "deliveryAreaId");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIsNull() {
			addCriterion("description_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIsNotNull() {
			addCriterion("description_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateEqualTo(Long value) {
			addCriterion("description_evaluate =", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotEqualTo(Long value) {
			addCriterion("description_evaluate <>", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateGreaterThan(Long value) {
			addCriterion("description_evaluate >", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateGreaterThanOrEqualTo(Long value) {
			addCriterion("description_evaluate >=", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateLessThan(Long value) {
			addCriterion("description_evaluate <", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateLessThanOrEqualTo(Long value) {
			addCriterion("description_evaluate <=", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIn(List<Long> values) {
			addCriterion("description_evaluate in", values, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotIn(List<Long> values) {
			addCriterion("description_evaluate not in", values, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateBetween(Long value1, Long value2) {
			addCriterion("description_evaluate between", value1, value2, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotBetween(Long value1, Long value2) {
			addCriterion("description_evaluate not between", value1, value2, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeIsNull() {
			addCriterion("ems_trans_fee is null");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeIsNotNull() {
			addCriterion("ems_trans_fee is not null");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeEqualTo(BigDecimal value) {
			addCriterion("ems_trans_fee =", value, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeNotEqualTo(BigDecimal value) {
			addCriterion("ems_trans_fee <>", value, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeGreaterThan(BigDecimal value) {
			addCriterion("ems_trans_fee >", value, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ems_trans_fee >=", value, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeLessThan(BigDecimal value) {
			addCriterion("ems_trans_fee <", value, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ems_trans_fee <=", value, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeIn(List<BigDecimal> values) {
			addCriterion("ems_trans_fee in", values, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeNotIn(List<BigDecimal> values) {
			addCriterion("ems_trans_fee not in", values, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ems_trans_fee between", value1, value2, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEmsTransFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ems_trans_fee not between", value1, value2, "emsTransFee");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceIsNull() {
			addCriterion("enough_reduce is null");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceIsNotNull() {
			addCriterion("enough_reduce is not null");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceEqualTo(Integer value) {
			addCriterion("enough_reduce =", value, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceNotEqualTo(Integer value) {
			addCriterion("enough_reduce <>", value, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceGreaterThan(Integer value) {
			addCriterion("enough_reduce >", value, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceGreaterThanOrEqualTo(Integer value) {
			addCriterion("enough_reduce >=", value, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceLessThan(Integer value) {
			addCriterion("enough_reduce <", value, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceLessThanOrEqualTo(Integer value) {
			addCriterion("enough_reduce <=", value, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceIn(List<Integer> values) {
			addCriterion("enough_reduce in", values, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceNotIn(List<Integer> values) {
			addCriterion("enough_reduce not in", values, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceBetween(Integer value1, Integer value2) {
			addCriterion("enough_reduce between", value1, value2, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceNotBetween(Integer value1, Integer value2) {
			addCriterion("enough_reduce not between", value1, value2, "enoughReduce");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeIsNull() {
			addCriterion("express_trans_fee is null");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeIsNotNull() {
			addCriterion("express_trans_fee is not null");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeEqualTo(BigDecimal value) {
			addCriterion("express_trans_fee =", value, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeNotEqualTo(BigDecimal value) {
			addCriterion("express_trans_fee <>", value, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeGreaterThan(BigDecimal value) {
			addCriterion("express_trans_fee >", value, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("express_trans_fee >=", value, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeLessThan(BigDecimal value) {
			addCriterion("express_trans_fee <", value, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("express_trans_fee <=", value, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeIn(List<BigDecimal> values) {
			addCriterion("express_trans_fee in", values, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeNotIn(List<BigDecimal> values) {
			addCriterion("express_trans_fee not in", values, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("express_trans_fee between", value1, value2, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andExpressTransFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("express_trans_fee not between", value1, value2, "expressTransFee");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeIsNull() {
			addCriterion("f_sale_type is null");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeIsNotNull() {
			addCriterion("f_sale_type is not null");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeEqualTo(Integer value) {
			addCriterion("f_sale_type =", value, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeNotEqualTo(Integer value) {
			addCriterion("f_sale_type <>", value, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeGreaterThan(Integer value) {
			addCriterion("f_sale_type >", value, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("f_sale_type >=", value, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeLessThan(Integer value) {
			addCriterion("f_sale_type <", value, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeLessThanOrEqualTo(Integer value) {
			addCriterion("f_sale_type <=", value, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeIn(List<Integer> values) {
			addCriterion("f_sale_type in", values, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeNotIn(List<Integer> values) {
			addCriterion("f_sale_type not in", values, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeBetween(Integer value1, Integer value2) {
			addCriterion("f_sale_type between", value1, value2, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andFSaleTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("f_sale_type not between", value1, value2, "fSaleType");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdIsNull() {
			addCriterion("goods_bottom_format_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdIsNotNull() {
			addCriterion("goods_bottom_format_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdEqualTo(Long value) {
			addCriterion("goods_bottom_format_id =", value, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdNotEqualTo(Long value) {
			addCriterion("goods_bottom_format_id <>", value, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdGreaterThan(Long value) {
			addCriterion("goods_bottom_format_id >", value, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_bottom_format_id >=", value, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdLessThan(Long value) {
			addCriterion("goods_bottom_format_id <", value, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_bottom_format_id <=", value, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdIn(List<Long> values) {
			addCriterion("goods_bottom_format_id in", values, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdNotIn(List<Long> values) {
			addCriterion("goods_bottom_format_id not in", values, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdBetween(Long value1, Long value2) {
			addCriterion("goods_bottom_format_id between", value1, value2, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsBottomFormatIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_bottom_format_id not between", value1, value2, "goodsBottomFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeIsNull() {
			addCriterion("goods_choice_type is null");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeIsNotNull() {
			addCriterion("goods_choice_type is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeEqualTo(Integer value) {
			addCriterion("goods_choice_type =", value, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeNotEqualTo(Integer value) {
			addCriterion("goods_choice_type <>", value, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeGreaterThan(Integer value) {
			addCriterion("goods_choice_type >", value, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_choice_type >=", value, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeLessThan(Integer value) {
			addCriterion("goods_choice_type <", value, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeLessThanOrEqualTo(Integer value) {
			addCriterion("goods_choice_type <=", value, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeIn(List<Integer> values) {
			addCriterion("goods_choice_type in", values, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeNotIn(List<Integer> values) {
			addCriterion("goods_choice_type not in", values, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeBetween(Integer value1, Integer value2) {
			addCriterion("goods_choice_type between", value1, value2, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsChoiceTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_choice_type not between", value1, value2, "goodsChoiceType");
			return (Criteria) this;
		}

		public Criteria andGoodsClickIsNull() {
			addCriterion("goods_click is null");
			return (Criteria) this;
		}

		public Criteria andGoodsClickIsNotNull() {
			addCriterion("goods_click is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsClickEqualTo(Integer value) {
			addCriterion("goods_click =", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickNotEqualTo(Integer value) {
			addCriterion("goods_click <>", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickGreaterThan(Integer value) {
			addCriterion("goods_click >", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_click >=", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickLessThan(Integer value) {
			addCriterion("goods_click <", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickLessThanOrEqualTo(Integer value) {
			addCriterion("goods_click <=", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickIn(List<Integer> values) {
			addCriterion("goods_click in", values, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickNotIn(List<Integer> values) {
			addCriterion("goods_click not in", values, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickBetween(Integer value1, Integer value2) {
			addCriterion("goods_click between", value1, value2, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_click not between", value1, value2, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsCodIsNull() {
			addCriterion("goods_cod is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCodIsNotNull() {
			addCriterion("goods_cod is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCodEqualTo(Integer value) {
			addCriterion("goods_cod =", value, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodNotEqualTo(Integer value) {
			addCriterion("goods_cod <>", value, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodGreaterThan(Integer value) {
			addCriterion("goods_cod >", value, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_cod >=", value, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodLessThan(Integer value) {
			addCriterion("goods_cod <", value, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodLessThanOrEqualTo(Integer value) {
			addCriterion("goods_cod <=", value, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodIn(List<Integer> values) {
			addCriterion("goods_cod in", values, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodNotIn(List<Integer> values) {
			addCriterion("goods_cod not in", values, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodBetween(Integer value1, Integer value2) {
			addCriterion("goods_cod between", value1, value2, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCodNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_cod not between", value1, value2, "goodsCod");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIsNull() {
			addCriterion("goods_collect is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIsNotNull() {
			addCriterion("goods_collect is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectEqualTo(Integer value) {
			addCriterion("goods_collect =", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotEqualTo(Integer value) {
			addCriterion("goods_collect <>", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectGreaterThan(Integer value) {
			addCriterion("goods_collect >", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_collect >=", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectLessThan(Integer value) {
			addCriterion("goods_collect <", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectLessThanOrEqualTo(Integer value) {
			addCriterion("goods_collect <=", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIn(List<Integer> values) {
			addCriterion("goods_collect in", values, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotIn(List<Integer> values) {
			addCriterion("goods_collect not in", values, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectBetween(Integer value1, Integer value2) {
			addCriterion("goods_collect between", value1, value2, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_collect not between", value1, value2, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceIsNull() {
			addCriterion("goods_current_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceIsNotNull() {
			addCriterion("goods_current_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceEqualTo(BigDecimal value) {
			addCriterion("goods_current_price =", value, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceNotEqualTo(BigDecimal value) {
			addCriterion("goods_current_price <>", value, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceGreaterThan(BigDecimal value) {
			addCriterion("goods_current_price >", value, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_current_price >=", value, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceLessThan(BigDecimal value) {
			addCriterion("goods_current_price <", value, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_current_price <=", value, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceIn(List<BigDecimal> values) {
			addCriterion("goods_current_price in", values, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceNotIn(List<BigDecimal> values) {
			addCriterion("goods_current_price not in", values, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_current_price between", value1, value2, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsCurrentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_current_price not between", value1, value2, "goodsCurrentPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeIsNull() {
			addCriterion("goods_fee is null");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeIsNotNull() {
			addCriterion("goods_fee is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeEqualTo(String value) {
			addCriterion("goods_fee =", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeNotEqualTo(String value) {
			addCriterion("goods_fee <>", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeGreaterThan(String value) {
			addCriterion("goods_fee >", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeGreaterThanOrEqualTo(String value) {
			addCriterion("goods_fee >=", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeLessThan(String value) {
			addCriterion("goods_fee <", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeLessThanOrEqualTo(String value) {
			addCriterion("goods_fee <=", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeLike(String value) {
			addCriterion("goods_fee like", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeNotLike(String value) {
			addCriterion("goods_fee not like", value, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeIn(List<String> values) {
			addCriterion("goods_fee in", values, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeNotIn(List<String> values) {
			addCriterion("goods_fee not in", values, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeBetween(String value1, String value2) {
			addCriterion("goods_fee between", value1, value2, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsFeeNotBetween(String value1, String value2) {
			addCriterion("goods_fee not between", value1, value2, "goodsFee");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryIsNull() {
			addCriterion("goods_inventory is null");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryIsNotNull() {
			addCriterion("goods_inventory is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryEqualTo(Integer value) {
			addCriterion("goods_inventory =", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryNotEqualTo(Integer value) {
			addCriterion("goods_inventory <>", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryGreaterThan(Integer value) {
			addCriterion("goods_inventory >", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_inventory >=", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryLessThan(Integer value) {
			addCriterion("goods_inventory <", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryLessThanOrEqualTo(Integer value) {
			addCriterion("goods_inventory <=", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryIn(List<Integer> values) {
			addCriterion("goods_inventory in", values, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryNotIn(List<Integer> values) {
			addCriterion("goods_inventory not in", values, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryBetween(Integer value1, Integer value2) {
			addCriterion("goods_inventory between", value1, value2, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_inventory not between", value1, value2, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNull() {
			addCriterion("goods_name is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNotNull() {
			addCriterion("goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameEqualTo(String value) {
			addCriterion("goods_name =", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotEqualTo(String value) {
			addCriterion("goods_name <>", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThan(String value) {
			addCriterion("goods_name >", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("goods_name >=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThan(String value) {
			addCriterion("goods_name <", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("goods_name <=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLike(String value) {
			addCriterion("goods_name like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotLike(String value) {
			addCriterion("goods_name not like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIn(List<String> values) {
			addCriterion("goods_name in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotIn(List<String> values) {
			addCriterion("goods_name not in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameBetween(String value1, String value2) {
			addCriterion("goods_name between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotBetween(String value1, String value2) {
			addCriterion("goods_name not between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNull() {
			addCriterion("goods_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNotNull() {
			addCriterion("goods_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceEqualTo(BigDecimal value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(BigDecimal value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<BigDecimal> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendIsNull() {
			addCriterion("goods_recommend is null");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendIsNotNull() {
			addCriterion("goods_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendEqualTo(Boolean value) {
			addCriterion("goods_recommend =", value, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendNotEqualTo(Boolean value) {
			addCriterion("goods_recommend <>", value, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendGreaterThan(Boolean value) {
			addCriterion("goods_recommend >", value, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("goods_recommend >=", value, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendLessThan(Boolean value) {
			addCriterion("goods_recommend <", value, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendLessThanOrEqualTo(Boolean value) {
			addCriterion("goods_recommend <=", value, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendIn(List<Boolean> values) {
			addCriterion("goods_recommend in", values, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendNotIn(List<Boolean> values) {
			addCriterion("goods_recommend not in", values, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendBetween(Boolean value1, Boolean value2) {
			addCriterion("goods_recommend between", value1, value2, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsRecommendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("goods_recommend not between", value1, value2, "goodsRecommend");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumIsNull() {
			addCriterion("goods_salenum is null");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumIsNotNull() {
			addCriterion("goods_salenum is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumEqualTo(Integer value) {
			addCriterion("goods_salenum =", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumNotEqualTo(Integer value) {
			addCriterion("goods_salenum <>", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumGreaterThan(Integer value) {
			addCriterion("goods_salenum >", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_salenum >=", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumLessThan(Integer value) {
			addCriterion("goods_salenum <", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumLessThanOrEqualTo(Integer value) {
			addCriterion("goods_salenum <=", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumIn(List<Integer> values) {
			addCriterion("goods_salenum in", values, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumNotIn(List<Integer> values) {
			addCriterion("goods_salenum not in", values, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumBetween(Integer value1, Integer value2) {
			addCriterion("goods_salenum between", value1, value2, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_salenum not between", value1, value2, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeIsNull() {
			addCriterion("goods_seller_time is null");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeIsNotNull() {
			addCriterion("goods_seller_time is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeEqualTo(Date value) {
			addCriterion("goods_seller_time =", value, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeNotEqualTo(Date value) {
			addCriterion("goods_seller_time <>", value, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeGreaterThan(Date value) {
			addCriterion("goods_seller_time >", value, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("goods_seller_time >=", value, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeLessThan(Date value) {
			addCriterion("goods_seller_time <", value, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeLessThanOrEqualTo(Date value) {
			addCriterion("goods_seller_time <=", value, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeIn(List<Date> values) {
			addCriterion("goods_seller_time in", values, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeNotIn(List<Date> values) {
			addCriterion("goods_seller_time not in", values, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeBetween(Date value1, Date value2) {
			addCriterion("goods_seller_time between", value1, value2, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSellerTimeNotBetween(Date value1, Date value2) {
			addCriterion("goods_seller_time not between", value1, value2, "goodsSellerTime");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialIsNull() {
			addCriterion("goods_serial is null");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialIsNotNull() {
			addCriterion("goods_serial is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialEqualTo(String value) {
			addCriterion("goods_serial =", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialNotEqualTo(String value) {
			addCriterion("goods_serial <>", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialGreaterThan(String value) {
			addCriterion("goods_serial >", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialGreaterThanOrEqualTo(String value) {
			addCriterion("goods_serial >=", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialLessThan(String value) {
			addCriterion("goods_serial <", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialLessThanOrEqualTo(String value) {
			addCriterion("goods_serial <=", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialLike(String value) {
			addCriterion("goods_serial like", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialNotLike(String value) {
			addCriterion("goods_serial not like", value, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialIn(List<String> values) {
			addCriterion("goods_serial in", values, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialNotIn(List<String> values) {
			addCriterion("goods_serial not in", values, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialBetween(String value1, String value2) {
			addCriterion("goods_serial between", value1, value2, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsSerialNotBetween(String value1, String value2) {
			addCriterion("goods_serial not between", value1, value2, "goodsSerial");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusIsNull() {
			addCriterion("goods_status is null");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusIsNotNull() {
			addCriterion("goods_status is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusEqualTo(Integer value) {
			addCriterion("goods_status =", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusNotEqualTo(Integer value) {
			addCriterion("goods_status <>", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusGreaterThan(Integer value) {
			addCriterion("goods_status >", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_status >=", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusLessThan(Integer value) {
			addCriterion("goods_status <", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
			addCriterion("goods_status <=", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusIn(List<Integer> values) {
			addCriterion("goods_status in", values, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusNotIn(List<Integer> values) {
			addCriterion("goods_status not in", values, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
			addCriterion("goods_status between", value1, value2, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_status not between", value1, value2, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdIsNull() {
			addCriterion("goods_top_format_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdIsNotNull() {
			addCriterion("goods_top_format_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdEqualTo(Long value) {
			addCriterion("goods_top_format_id =", value, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdNotEqualTo(Long value) {
			addCriterion("goods_top_format_id <>", value, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdGreaterThan(Long value) {
			addCriterion("goods_top_format_id >", value, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_top_format_id >=", value, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdLessThan(Long value) {
			addCriterion("goods_top_format_id <", value, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_top_format_id <=", value, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdIn(List<Long> values) {
			addCriterion("goods_top_format_id in", values, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdNotIn(List<Long> values) {
			addCriterion("goods_top_format_id not in", values, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdBetween(Long value1, Long value2) {
			addCriterion("goods_top_format_id between", value1, value2, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTopFormatIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_top_format_id not between", value1, value2, "goodsTopFormatId");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeIsNull() {
			addCriterion("goods_transfee is null");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeIsNotNull() {
			addCriterion("goods_transfee is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeEqualTo(Integer value) {
			addCriterion("goods_transfee =", value, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeNotEqualTo(Integer value) {
			addCriterion("goods_transfee <>", value, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeGreaterThan(Integer value) {
			addCriterion("goods_transfee >", value, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_transfee >=", value, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeLessThan(Integer value) {
			addCriterion("goods_transfee <", value, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeLessThanOrEqualTo(Integer value) {
			addCriterion("goods_transfee <=", value, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeIn(List<Integer> values) {
			addCriterion("goods_transfee in", values, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeNotIn(List<Integer> values) {
			addCriterion("goods_transfee not in", values, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeBetween(Integer value1, Integer value2) {
			addCriterion("goods_transfee between", value1, value2, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTransfeeNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_transfee not between", value1, value2, "goodsTransfee");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIsNull() {
			addCriterion("goods_type is null");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIsNotNull() {
			addCriterion("goods_type is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeEqualTo(Integer value) {
			addCriterion("goods_type =", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotEqualTo(Integer value) {
			addCriterion("goods_type <>", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeGreaterThan(Integer value) {
			addCriterion("goods_type >", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_type >=", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeLessThan(Integer value) {
			addCriterion("goods_type <", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
			addCriterion("goods_type <=", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIn(List<Integer> values) {
			addCriterion("goods_type in", values, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotIn(List<Integer> values) {
			addCriterion("goods_type not in", values, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
			addCriterion("goods_type between", value1, value2, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_type not between", value1, value2, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeIsNull() {
			addCriterion("goods_volume is null");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeIsNotNull() {
			addCriterion("goods_volume is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeEqualTo(BigDecimal value) {
			addCriterion("goods_volume =", value, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeNotEqualTo(BigDecimal value) {
			addCriterion("goods_volume <>", value, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeGreaterThan(BigDecimal value) {
			addCriterion("goods_volume >", value, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_volume >=", value, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeLessThan(BigDecimal value) {
			addCriterion("goods_volume <", value, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_volume <=", value, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeIn(List<BigDecimal> values) {
			addCriterion("goods_volume in", values, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeNotIn(List<BigDecimal> values) {
			addCriterion("goods_volume not in", values, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_volume between", value1, value2, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_volume not between", value1, value2, "goodsVolume");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryIsNull() {
			addCriterion("goods_warn_inventory is null");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryIsNotNull() {
			addCriterion("goods_warn_inventory is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryEqualTo(Integer value) {
			addCriterion("goods_warn_inventory =", value, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryNotEqualTo(Integer value) {
			addCriterion("goods_warn_inventory <>", value, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryGreaterThan(Integer value) {
			addCriterion("goods_warn_inventory >", value, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_warn_inventory >=", value, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryLessThan(Integer value) {
			addCriterion("goods_warn_inventory <", value, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryLessThanOrEqualTo(Integer value) {
			addCriterion("goods_warn_inventory <=", value, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryIn(List<Integer> values) {
			addCriterion("goods_warn_inventory in", values, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryNotIn(List<Integer> values) {
			addCriterion("goods_warn_inventory not in", values, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryBetween(Integer value1, Integer value2) {
			addCriterion("goods_warn_inventory between", value1, value2, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWarnInventoryNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_warn_inventory not between", value1, value2, "goodsWarnInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightIsNull() {
			addCriterion("goods_weight is null");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightIsNotNull() {
			addCriterion("goods_weight is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightEqualTo(BigDecimal value) {
			addCriterion("goods_weight =", value, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightNotEqualTo(BigDecimal value) {
			addCriterion("goods_weight <>", value, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightGreaterThan(BigDecimal value) {
			addCriterion("goods_weight >", value, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_weight >=", value, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightLessThan(BigDecimal value) {
			addCriterion("goods_weight <", value, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_weight <=", value, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightIn(List<BigDecimal> values) {
			addCriterion("goods_weight in", values, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightNotIn(List<BigDecimal> values) {
			addCriterion("goods_weight not in", values, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_weight between", value1, value2, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGoodsWeightNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_weight not between", value1, value2, "goodsWeight");
			return (Criteria) this;
		}

		public Criteria andGroupBuyIsNull() {
			addCriterion("group_buy is null");
			return (Criteria) this;
		}

		public Criteria andGroupBuyIsNotNull() {
			addCriterion("group_buy is not null");
			return (Criteria) this;
		}

		public Criteria andGroupBuyEqualTo(Integer value) {
			addCriterion("group_buy =", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyNotEqualTo(Integer value) {
			addCriterion("group_buy <>", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyGreaterThan(Integer value) {
			addCriterion("group_buy >", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyGreaterThanOrEqualTo(Integer value) {
			addCriterion("group_buy >=", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyLessThan(Integer value) {
			addCriterion("group_buy <", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyLessThanOrEqualTo(Integer value) {
			addCriterion("group_buy <=", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyIn(List<Integer> values) {
			addCriterion("group_buy in", values, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyNotIn(List<Integer> values) {
			addCriterion("group_buy not in", values, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyBetween(Integer value1, Integer value2) {
			addCriterion("group_buy between", value1, value2, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyNotBetween(Integer value1, Integer value2) {
			addCriterion("group_buy not between", value1, value2, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeIsNull() {
			addCriterion("inventory_type is null");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeIsNotNull() {
			addCriterion("inventory_type is not null");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeEqualTo(String value) {
			addCriterion("inventory_type =", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotEqualTo(String value) {
			addCriterion("inventory_type <>", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeGreaterThan(String value) {
			addCriterion("inventory_type >", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("inventory_type >=", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeLessThan(String value) {
			addCriterion("inventory_type <", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeLessThanOrEqualTo(String value) {
			addCriterion("inventory_type <=", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeLike(String value) {
			addCriterion("inventory_type like", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotLike(String value) {
			addCriterion("inventory_type not like", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeIn(List<String> values) {
			addCriterion("inventory_type in", values, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotIn(List<String> values) {
			addCriterion("inventory_type not in", values, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeBetween(String value1, String value2) {
			addCriterion("inventory_type between", value1, value2, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotBetween(String value1, String value2) {
			addCriterion("inventory_type not between", value1, value2, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeIsNull() {
			addCriterion("mail_trans_fee is null");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeIsNotNull() {
			addCriterion("mail_trans_fee is not null");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeEqualTo(BigDecimal value) {
			addCriterion("mail_trans_fee =", value, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeNotEqualTo(BigDecimal value) {
			addCriterion("mail_trans_fee <>", value, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeGreaterThan(BigDecimal value) {
			addCriterion("mail_trans_fee >", value, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("mail_trans_fee >=", value, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeLessThan(BigDecimal value) {
			addCriterion("mail_trans_fee <", value, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("mail_trans_fee <=", value, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeIn(List<BigDecimal> values) {
			addCriterion("mail_trans_fee in", values, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeNotIn(List<BigDecimal> values) {
			addCriterion("mail_trans_fee not in", values, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("mail_trans_fee between", value1, value2, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMailTransFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("mail_trans_fee not between", value1, value2, "mailTransFee");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateIsNull() {
			addCriterion("middle_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateIsNotNull() {
			addCriterion("middle_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateEqualTo(BigDecimal value) {
			addCriterion("middle_evaluate =", value, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("middle_evaluate <>", value, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateGreaterThan(BigDecimal value) {
			addCriterion("middle_evaluate >", value, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("middle_evaluate >=", value, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateLessThan(BigDecimal value) {
			addCriterion("middle_evaluate <", value, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("middle_evaluate <=", value, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateIn(List<BigDecimal> values) {
			addCriterion("middle_evaluate in", values, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("middle_evaluate not in", values, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("middle_evaluate between", value1, value2, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMiddleEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("middle_evaluate not between", value1, value2, "middleEvaluate");
			return (Criteria) this;
		}

		public Criteria andMobileHotIsNull() {
			addCriterion("mobile_hot is null");
			return (Criteria) this;
		}

		public Criteria andMobileHotIsNotNull() {
			addCriterion("mobile_hot is not null");
			return (Criteria) this;
		}

		public Criteria andMobileHotEqualTo(Integer value) {
			addCriterion("mobile_hot =", value, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotNotEqualTo(Integer value) {
			addCriterion("mobile_hot <>", value, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotGreaterThan(Integer value) {
			addCriterion("mobile_hot >", value, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotGreaterThanOrEqualTo(Integer value) {
			addCriterion("mobile_hot >=", value, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotLessThan(Integer value) {
			addCriterion("mobile_hot <", value, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotLessThanOrEqualTo(Integer value) {
			addCriterion("mobile_hot <=", value, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotIn(List<Integer> values) {
			addCriterion("mobile_hot in", values, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotNotIn(List<Integer> values) {
			addCriterion("mobile_hot not in", values, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotBetween(Integer value1, Integer value2) {
			addCriterion("mobile_hot between", value1, value2, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHotNotBetween(Integer value1, Integer value2) {
			addCriterion("mobile_hot not between", value1, value2, "mobileHot");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeIsNull() {
			addCriterion("mobile_hotTime is null");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeIsNotNull() {
			addCriterion("mobile_hotTime is not null");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_hotTime =", value, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_hotTime <>", value, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeGreaterThan(Date value) {
			addCriterionForJDBCDate("mobile_hotTime >", value, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_hotTime >=", value, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeLessThan(Date value) {
			addCriterionForJDBCDate("mobile_hotTime <", value, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_hotTime <=", value, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_hotTime in", values, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_hotTime not in", values, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_hotTime between", value1, value2, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileHottimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_hotTime not between", value1, value2, "mobileHottime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendIsNull() {
			addCriterion("mobile_recommend is null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendIsNotNull() {
			addCriterion("mobile_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendEqualTo(Integer value) {
			addCriterion("mobile_recommend =", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendNotEqualTo(Integer value) {
			addCriterion("mobile_recommend <>", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendGreaterThan(Integer value) {
			addCriterion("mobile_recommend >", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendGreaterThanOrEqualTo(Integer value) {
			addCriterion("mobile_recommend >=", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendLessThan(Integer value) {
			addCriterion("mobile_recommend <", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendLessThanOrEqualTo(Integer value) {
			addCriterion("mobile_recommend <=", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendIn(List<Integer> values) {
			addCriterion("mobile_recommend in", values, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendNotIn(List<Integer> values) {
			addCriterion("mobile_recommend not in", values, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendBetween(Integer value1, Integer value2) {
			addCriterion("mobile_recommend between", value1, value2, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendNotBetween(Integer value1, Integer value2) {
			addCriterion("mobile_recommend not between", value1, value2, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeIsNull() {
			addCriterion("mobile_recommendTime is null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeIsNotNull() {
			addCriterion("mobile_recommendTime is not null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommendTime =", value, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommendTime <>", value, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeGreaterThan(Date value) {
			addCriterionForJDBCDate("mobile_recommendTime >", value, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommendTime >=", value, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeLessThan(Date value) {
			addCriterionForJDBCDate("mobile_recommendTime <", value, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommendTime <=", value, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_recommendTime in", values, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_recommendTime not in", values, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_recommendTime between", value1, value2, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendtimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_recommendTime not between", value1, value2, "mobileRecommendtime");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusIsNull() {
			addCriterion("order_enough_give_status is null");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusIsNotNull() {
			addCriterion("order_enough_give_status is not null");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusEqualTo(Integer value) {
			addCriterion("order_enough_give_status =", value, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusNotEqualTo(Integer value) {
			addCriterion("order_enough_give_status <>", value, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusGreaterThan(Integer value) {
			addCriterion("order_enough_give_status >", value, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_enough_give_status >=", value, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusLessThan(Integer value) {
			addCriterion("order_enough_give_status <", value, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusLessThanOrEqualTo(Integer value) {
			addCriterion("order_enough_give_status <=", value, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusIn(List<Integer> values) {
			addCriterion("order_enough_give_status in", values, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusNotIn(List<Integer> values) {
			addCriterion("order_enough_give_status not in", values, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusBetween(Integer value1, Integer value2) {
			addCriterion("order_enough_give_status between", value1, value2, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughGiveStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("order_enough_give_status not between", value1, value2, "orderEnoughGiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveIsNull() {
			addCriterion("order_enough_if_give is null");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveIsNotNull() {
			addCriterion("order_enough_if_give is not null");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveEqualTo(Integer value) {
			addCriterion("order_enough_if_give =", value, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveNotEqualTo(Integer value) {
			addCriterion("order_enough_if_give <>", value, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveGreaterThan(Integer value) {
			addCriterion("order_enough_if_give >", value, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_enough_if_give >=", value, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveLessThan(Integer value) {
			addCriterion("order_enough_if_give <", value, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveLessThanOrEqualTo(Integer value) {
			addCriterion("order_enough_if_give <=", value, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveIn(List<Integer> values) {
			addCriterion("order_enough_if_give in", values, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveNotIn(List<Integer> values) {
			addCriterion("order_enough_if_give not in", values, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveBetween(Integer value1, Integer value2) {
			addCriterion("order_enough_if_give between", value1, value2, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughIfGiveNotBetween(Integer value1, Integer value2) {
			addCriterion("order_enough_if_give not between", value1, value2, "orderEnoughIfGive");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdIsNull() {
			addCriterion("order_enough_reduce_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdIsNotNull() {
			addCriterion("order_enough_reduce_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdEqualTo(String value) {
			addCriterion("order_enough_reduce_id =", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdNotEqualTo(String value) {
			addCriterion("order_enough_reduce_id <>", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdGreaterThan(String value) {
			addCriterion("order_enough_reduce_id >", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdGreaterThanOrEqualTo(String value) {
			addCriterion("order_enough_reduce_id >=", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdLessThan(String value) {
			addCriterion("order_enough_reduce_id <", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdLessThanOrEqualTo(String value) {
			addCriterion("order_enough_reduce_id <=", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdLike(String value) {
			addCriterion("order_enough_reduce_id like", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdNotLike(String value) {
			addCriterion("order_enough_reduce_id not like", value, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdIn(List<String> values) {
			addCriterion("order_enough_reduce_id in", values, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdNotIn(List<String> values) {
			addCriterion("order_enough_reduce_id not in", values, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdBetween(String value1, String value2) {
			addCriterion("order_enough_reduce_id between", value1, value2, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andOrderEnoughReduceIdNotBetween(String value1, String value2) {
			addCriterion("order_enough_reduce_id not between", value1, value2, "orderEnoughReduceId");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryIsNull() {
			addCriterion("price_history is null");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryIsNotNull() {
			addCriterion("price_history is not null");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryEqualTo(BigDecimal value) {
			addCriterion("price_history =", value, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryNotEqualTo(BigDecimal value) {
			addCriterion("price_history <>", value, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryGreaterThan(BigDecimal value) {
			addCriterion("price_history >", value, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("price_history >=", value, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryLessThan(BigDecimal value) {
			addCriterion("price_history <", value, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryLessThanOrEqualTo(BigDecimal value) {
			addCriterion("price_history <=", value, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryIn(List<BigDecimal> values) {
			addCriterion("price_history in", values, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryNotIn(List<BigDecimal> values) {
			addCriterion("price_history not in", values, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price_history between", value1, value2, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPriceHistoryNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price_history not between", value1, value2, "priceHistory");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusIsNull() {
			addCriterion("publish_goods_status is null");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusIsNotNull() {
			addCriterion("publish_goods_status is not null");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusEqualTo(Integer value) {
			addCriterion("publish_goods_status =", value, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusNotEqualTo(Integer value) {
			addCriterion("publish_goods_status <>", value, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusGreaterThan(Integer value) {
			addCriterion("publish_goods_status >", value, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("publish_goods_status >=", value, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusLessThan(Integer value) {
			addCriterion("publish_goods_status <", value, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusLessThanOrEqualTo(Integer value) {
			addCriterion("publish_goods_status <=", value, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusIn(List<Integer> values) {
			addCriterion("publish_goods_status in", values, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusNotIn(List<Integer> values) {
			addCriterion("publish_goods_status not in", values, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusBetween(Integer value1, Integer value2) {
			addCriterion("publish_goods_status between", value1, value2, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andPublishGoodsStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("publish_goods_status not between", value1, value2, "publishGoodsStatus");
			return (Criteria) this;
		}

		public Criteria andQrImgPathIsNull() {
			addCriterion("qr_img_path is null");
			return (Criteria) this;
		}

		public Criteria andQrImgPathIsNotNull() {
			addCriterion("qr_img_path is not null");
			return (Criteria) this;
		}

		public Criteria andQrImgPathEqualTo(String value) {
			addCriterion("qr_img_path =", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathNotEqualTo(String value) {
			addCriterion("qr_img_path <>", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathGreaterThan(String value) {
			addCriterion("qr_img_path >", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathGreaterThanOrEqualTo(String value) {
			addCriterion("qr_img_path >=", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathLessThan(String value) {
			addCriterion("qr_img_path <", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathLessThanOrEqualTo(String value) {
			addCriterion("qr_img_path <=", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathLike(String value) {
			addCriterion("qr_img_path like", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathNotLike(String value) {
			addCriterion("qr_img_path not like", value, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathIn(List<String> values) {
			addCriterion("qr_img_path in", values, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathNotIn(List<String> values) {
			addCriterion("qr_img_path not in", values, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathBetween(String value1, String value2) {
			addCriterion("qr_img_path between", value1, value2, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andQrImgPathNotBetween(String value1, String value2) {
			addCriterion("qr_img_path not between", value1, value2, "qrImgPath");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsIsNull() {
			addCriterion("seo_keywords is null");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsIsNotNull() {
			addCriterion("seo_keywords is not null");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsEqualTo(String value) {
			addCriterion("seo_keywords =", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotEqualTo(String value) {
			addCriterion("seo_keywords <>", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsGreaterThan(String value) {
			addCriterion("seo_keywords >", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsGreaterThanOrEqualTo(String value) {
			addCriterion("seo_keywords >=", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsLessThan(String value) {
			addCriterion("seo_keywords <", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsLessThanOrEqualTo(String value) {
			addCriterion("seo_keywords <=", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsLike(String value) {
			addCriterion("seo_keywords like", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotLike(String value) {
			addCriterion("seo_keywords not like", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsIn(List<String> values) {
			addCriterion("seo_keywords in", values, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotIn(List<String> values) {
			addCriterion("seo_keywords not in", values, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsBetween(String value1, String value2) {
			addCriterion("seo_keywords between", value1, value2, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotBetween(String value1, String value2) {
			addCriterion("seo_keywords not between", value1, value2, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andStorePriceIsNull() {
			addCriterion("store_price is null");
			return (Criteria) this;
		}

		public Criteria andStorePriceIsNotNull() {
			addCriterion("store_price is not null");
			return (Criteria) this;
		}

		public Criteria andStorePriceEqualTo(BigDecimal value) {
			addCriterion("store_price =", value, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceNotEqualTo(BigDecimal value) {
			addCriterion("store_price <>", value, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceGreaterThan(BigDecimal value) {
			addCriterion("store_price >", value, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_price >=", value, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceLessThan(BigDecimal value) {
			addCriterion("store_price <", value, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_price <=", value, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceIn(List<BigDecimal> values) {
			addCriterion("store_price in", values, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceNotIn(List<BigDecimal> values) {
			addCriterion("store_price not in", values, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_price between", value1, value2, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStorePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_price not between", value1, value2, "storePrice");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendIsNull() {
			addCriterion("store_recommend is null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendIsNotNull() {
			addCriterion("store_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendEqualTo(Boolean value) {
			addCriterion("store_recommend =", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendNotEqualTo(Boolean value) {
			addCriterion("store_recommend <>", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendGreaterThan(Boolean value) {
			addCriterion("store_recommend >", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("store_recommend >=", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendLessThan(Boolean value) {
			addCriterion("store_recommend <", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendLessThanOrEqualTo(Boolean value) {
			addCriterion("store_recommend <=", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendIn(List<Boolean> values) {
			addCriterion("store_recommend in", values, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendNotIn(List<Boolean> values) {
			addCriterion("store_recommend not in", values, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendBetween(Boolean value1, Boolean value2) {
			addCriterion("store_recommend between", value1, value2, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("store_recommend not between", value1, value2, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeIsNull() {
			addCriterion("store_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeIsNotNull() {
			addCriterion("store_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeEqualTo(Date value) {
			addCriterion("store_recommend_time =", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeNotEqualTo(Date value) {
			addCriterion("store_recommend_time <>", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeGreaterThan(Date value) {
			addCriterion("store_recommend_time >", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("store_recommend_time >=", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeLessThan(Date value) {
			addCriterion("store_recommend_time <", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterion("store_recommend_time <=", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeIn(List<Date> values) {
			addCriterion("store_recommend_time in", values, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeNotIn(List<Date> values) {
			addCriterion("store_recommend_time not in", values, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeBetween(Date value1, Date value2) {
			addCriterion("store_recommend_time between", value1, value2, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterion("store_recommend_time not between", value1, value2, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceIsNull() {
			addCriterion("tax_invoice is null");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceIsNotNull() {
			addCriterion("tax_invoice is not null");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceEqualTo(Integer value) {
			addCriterion("tax_invoice =", value, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceNotEqualTo(Integer value) {
			addCriterion("tax_invoice <>", value, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceGreaterThan(Integer value) {
			addCriterion("tax_invoice >", value, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceGreaterThanOrEqualTo(Integer value) {
			addCriterion("tax_invoice >=", value, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceLessThan(Integer value) {
			addCriterion("tax_invoice <", value, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceLessThanOrEqualTo(Integer value) {
			addCriterion("tax_invoice <=", value, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceIn(List<Integer> values) {
			addCriterion("tax_invoice in", values, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceNotIn(List<Integer> values) {
			addCriterion("tax_invoice not in", values, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceBetween(Integer value1, Integer value2) {
			addCriterion("tax_invoice between", value1, value2, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andTaxInvoiceNotBetween(Integer value1, Integer value2) {
			addCriterion("tax_invoice not between", value1, value2, "taxInvoice");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusIsNull() {
			addCriterion("warn_inventory_status is null");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusIsNotNull() {
			addCriterion("warn_inventory_status is not null");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusEqualTo(Integer value) {
			addCriterion("warn_inventory_status =", value, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusNotEqualTo(Integer value) {
			addCriterion("warn_inventory_status <>", value, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusGreaterThan(Integer value) {
			addCriterion("warn_inventory_status >", value, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("warn_inventory_status >=", value, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusLessThan(Integer value) {
			addCriterion("warn_inventory_status <", value, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusLessThanOrEqualTo(Integer value) {
			addCriterion("warn_inventory_status <=", value, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusIn(List<Integer> values) {
			addCriterion("warn_inventory_status in", values, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusNotIn(List<Integer> values) {
			addCriterion("warn_inventory_status not in", values, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusBetween(Integer value1, Integer value2) {
			addCriterion("warn_inventory_status between", value1, value2, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWarnInventoryStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("warn_inventory_status not between", value1, value2, "warnInventoryStatus");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateIsNull() {
			addCriterion("well_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateIsNotNull() {
			addCriterion("well_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateEqualTo(BigDecimal value) {
			addCriterion("well_evaluate =", value, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("well_evaluate <>", value, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateGreaterThan(BigDecimal value) {
			addCriterion("well_evaluate >", value, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("well_evaluate >=", value, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateLessThan(BigDecimal value) {
			addCriterion("well_evaluate <", value, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("well_evaluate <=", value, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateIn(List<BigDecimal> values) {
			addCriterion("well_evaluate in", values, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("well_evaluate not in", values, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("well_evaluate between", value1, value2, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWellEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("well_evaluate not between", value1, value2, "wellEvaluate");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIsNull() {
			addCriterion("whether_free is null");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIsNotNull() {
			addCriterion("whether_free is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeEqualTo(Integer value) {
			addCriterion("whether_free =", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotEqualTo(Integer value) {
			addCriterion("whether_free <>", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeGreaterThan(Integer value) {
			addCriterion("whether_free >", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeGreaterThanOrEqualTo(Integer value) {
			addCriterion("whether_free >=", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeLessThan(Integer value) {
			addCriterion("whether_free <", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeLessThanOrEqualTo(Integer value) {
			addCriterion("whether_free <=", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIn(List<Integer> values) {
			addCriterion("whether_free in", values, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotIn(List<Integer> values) {
			addCriterion("whether_free not in", values, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeBetween(Integer value1, Integer value2) {
			addCriterion("whether_free between", value1, value2, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotBetween(Integer value1, Integer value2) {
			addCriterion("whether_free not between", value1, value2, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeIsNull() {
			addCriterion("ztc_apply_time is null");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeIsNotNull() {
			addCriterion("ztc_apply_time is not null");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeEqualTo(Date value) {
			addCriterion("ztc_apply_time =", value, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeNotEqualTo(Date value) {
			addCriterion("ztc_apply_time <>", value, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeGreaterThan(Date value) {
			addCriterion("ztc_apply_time >", value, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ztc_apply_time >=", value, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeLessThan(Date value) {
			addCriterion("ztc_apply_time <", value, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeLessThanOrEqualTo(Date value) {
			addCriterion("ztc_apply_time <=", value, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeIn(List<Date> values) {
			addCriterion("ztc_apply_time in", values, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeNotIn(List<Date> values) {
			addCriterion("ztc_apply_time not in", values, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeBetween(Date value1, Date value2) {
			addCriterion("ztc_apply_time between", value1, value2, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcApplyTimeNotBetween(Date value1, Date value2) {
			addCriterion("ztc_apply_time not between", value1, value2, "ztcApplyTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeIsNull() {
			addCriterion("ztc_begin_time is null");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeIsNotNull() {
			addCriterion("ztc_begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeEqualTo(Date value) {
			addCriterionForJDBCDate("ztc_begin_time =", value, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("ztc_begin_time <>", value, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("ztc_begin_time >", value, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ztc_begin_time >=", value, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeLessThan(Date value) {
			addCriterionForJDBCDate("ztc_begin_time <", value, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ztc_begin_time <=", value, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeIn(List<Date> values) {
			addCriterionForJDBCDate("ztc_begin_time in", values, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("ztc_begin_time not in", values, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ztc_begin_time between", value1, value2, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcBeginTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ztc_begin_time not between", value1, value2, "ztcBeginTime");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumIsNull() {
			addCriterion("ztc_click_num is null");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumIsNotNull() {
			addCriterion("ztc_click_num is not null");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumEqualTo(Integer value) {
			addCriterion("ztc_click_num =", value, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumNotEqualTo(Integer value) {
			addCriterion("ztc_click_num <>", value, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumGreaterThan(Integer value) {
			addCriterion("ztc_click_num >", value, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_click_num >=", value, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumLessThan(Integer value) {
			addCriterion("ztc_click_num <", value, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_click_num <=", value, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumIn(List<Integer> values) {
			addCriterion("ztc_click_num in", values, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumNotIn(List<Integer> values) {
			addCriterion("ztc_click_num not in", values, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumBetween(Integer value1, Integer value2) {
			addCriterion("ztc_click_num between", value1, value2, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcClickNumNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_click_num not between", value1, value2, "ztcClickNum");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceIsNull() {
			addCriterion("ztc_dredge_price is null");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceIsNotNull() {
			addCriterion("ztc_dredge_price is not null");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceEqualTo(Integer value) {
			addCriterion("ztc_dredge_price =", value, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceNotEqualTo(Integer value) {
			addCriterion("ztc_dredge_price <>", value, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceGreaterThan(Integer value) {
			addCriterion("ztc_dredge_price >", value, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_dredge_price >=", value, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceLessThan(Integer value) {
			addCriterion("ztc_dredge_price <", value, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_dredge_price <=", value, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceIn(List<Integer> values) {
			addCriterion("ztc_dredge_price in", values, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceNotIn(List<Integer> values) {
			addCriterion("ztc_dredge_price not in", values, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceBetween(Integer value1, Integer value2) {
			addCriterion("ztc_dredge_price between", value1, value2, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcDredgePriceNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_dredge_price not between", value1, value2, "ztcDredgePrice");
			return (Criteria) this;
		}

		public Criteria andZtcGoldIsNull() {
			addCriterion("ztc_gold is null");
			return (Criteria) this;
		}

		public Criteria andZtcGoldIsNotNull() {
			addCriterion("ztc_gold is not null");
			return (Criteria) this;
		}

		public Criteria andZtcGoldEqualTo(Integer value) {
			addCriterion("ztc_gold =", value, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldNotEqualTo(Integer value) {
			addCriterion("ztc_gold <>", value, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldGreaterThan(Integer value) {
			addCriterion("ztc_gold >", value, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_gold >=", value, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldLessThan(Integer value) {
			addCriterion("ztc_gold <", value, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_gold <=", value, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldIn(List<Integer> values) {
			addCriterion("ztc_gold in", values, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldNotIn(List<Integer> values) {
			addCriterion("ztc_gold not in", values, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldBetween(Integer value1, Integer value2) {
			addCriterion("ztc_gold between", value1, value2, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcGoldNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_gold not between", value1, value2, "ztcGold");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusIsNull() {
			addCriterion("ztc_pay_status is null");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusIsNotNull() {
			addCriterion("ztc_pay_status is not null");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusEqualTo(Integer value) {
			addCriterion("ztc_pay_status =", value, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusNotEqualTo(Integer value) {
			addCriterion("ztc_pay_status <>", value, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusGreaterThan(Integer value) {
			addCriterion("ztc_pay_status >", value, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_pay_status >=", value, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusLessThan(Integer value) {
			addCriterion("ztc_pay_status <", value, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_pay_status <=", value, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusIn(List<Integer> values) {
			addCriterion("ztc_pay_status in", values, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusNotIn(List<Integer> values) {
			addCriterion("ztc_pay_status not in", values, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusBetween(Integer value1, Integer value2) {
			addCriterion("ztc_pay_status between", value1, value2, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPayStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_pay_status not between", value1, value2, "ztcPayStatus");
			return (Criteria) this;
		}

		public Criteria andZtcPriceIsNull() {
			addCriterion("ztc_price is null");
			return (Criteria) this;
		}

		public Criteria andZtcPriceIsNotNull() {
			addCriterion("ztc_price is not null");
			return (Criteria) this;
		}

		public Criteria andZtcPriceEqualTo(Integer value) {
			addCriterion("ztc_price =", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceNotEqualTo(Integer value) {
			addCriterion("ztc_price <>", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceGreaterThan(Integer value) {
			addCriterion("ztc_price >", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_price >=", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceLessThan(Integer value) {
			addCriterion("ztc_price <", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_price <=", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceIn(List<Integer> values) {
			addCriterion("ztc_price in", values, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceNotIn(List<Integer> values) {
			addCriterion("ztc_price not in", values, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceBetween(Integer value1, Integer value2) {
			addCriterion("ztc_price between", value1, value2, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_price not between", value1, value2, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcStatusIsNull() {
			addCriterion("ztc_status is null");
			return (Criteria) this;
		}

		public Criteria andZtcStatusIsNotNull() {
			addCriterion("ztc_status is not null");
			return (Criteria) this;
		}

		public Criteria andZtcStatusEqualTo(Integer value) {
			addCriterion("ztc_status =", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusNotEqualTo(Integer value) {
			addCriterion("ztc_status <>", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusGreaterThan(Integer value) {
			addCriterion("ztc_status >", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_status >=", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusLessThan(Integer value) {
			addCriterion("ztc_status <", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_status <=", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusIn(List<Integer> values) {
			addCriterion("ztc_status in", values, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusNotIn(List<Integer> values) {
			addCriterion("ztc_status not in", values, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusBetween(Integer value1, Integer value2) {
			addCriterion("ztc_status between", value1, value2, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_status not between", value1, value2, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andGcIdIsNull() {
			addCriterion("gc_id is null");
			return (Criteria) this;
		}

		public Criteria andGcIdIsNotNull() {
			addCriterion("gc_id is not null");
			return (Criteria) this;
		}

		public Criteria andGcIdEqualTo(Long value) {
			addCriterion("gc_id =", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotEqualTo(Long value) {
			addCriterion("gc_id <>", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdGreaterThan(Long value) {
			addCriterion("gc_id >", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gc_id >=", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdLessThan(Long value) {
			addCriterion("gc_id <", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdLessThanOrEqualTo(Long value) {
			addCriterion("gc_id <=", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdIn(List<Long> values) {
			addCriterion("gc_id in", values, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotIn(List<Long> values) {
			addCriterion("gc_id not in", values, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdBetween(Long value1, Long value2) {
			addCriterion("gc_id between", value1, value2, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotBetween(Long value1, Long value2) {
			addCriterion("gc_id not between", value1, value2, "gcId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdIsNull() {
			addCriterion("goods_brand_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdIsNotNull() {
			addCriterion("goods_brand_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdEqualTo(Long value) {
			addCriterion("goods_brand_id =", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdNotEqualTo(Long value) {
			addCriterion("goods_brand_id <>", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdGreaterThan(Long value) {
			addCriterion("goods_brand_id >", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_brand_id >=", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdLessThan(Long value) {
			addCriterion("goods_brand_id <", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_brand_id <=", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdIn(List<Long> values) {
			addCriterion("goods_brand_id in", values, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdNotIn(List<Long> values) {
			addCriterion("goods_brand_id not in", values, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdBetween(Long value1, Long value2) {
			addCriterion("goods_brand_id between", value1, value2, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_brand_id not between", value1, value2, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdIsNull() {
			addCriterion("goods_main_photo_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdIsNotNull() {
			addCriterion("goods_main_photo_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdEqualTo(Long value) {
			addCriterion("goods_main_photo_id =", value, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdNotEqualTo(Long value) {
			addCriterion("goods_main_photo_id <>", value, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdGreaterThan(Long value) {
			addCriterion("goods_main_photo_id >", value, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_main_photo_id >=", value, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdLessThan(Long value) {
			addCriterion("goods_main_photo_id <", value, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_main_photo_id <=", value, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdIn(List<Long> values) {
			addCriterion("goods_main_photo_id in", values, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdNotIn(List<Long> values) {
			addCriterion("goods_main_photo_id not in", values, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdBetween(Long value1, Long value2) {
			addCriterion("goods_main_photo_id between", value1, value2, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsMainPhotoIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_main_photo_id not between", value1, value2, "goodsMainPhotoId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdIsNull() {
			addCriterion("goods_store_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdIsNotNull() {
			addCriterion("goods_store_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdEqualTo(Long value) {
			addCriterion("goods_store_id =", value, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdNotEqualTo(Long value) {
			addCriterion("goods_store_id <>", value, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdGreaterThan(Long value) {
			addCriterion("goods_store_id >", value, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_store_id >=", value, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdLessThan(Long value) {
			addCriterion("goods_store_id <", value, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_store_id <=", value, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdIn(List<Long> values) {
			addCriterion("goods_store_id in", values, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdNotIn(List<Long> values) {
			addCriterion("goods_store_id not in", values, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdBetween(Long value1, Long value2) {
			addCriterion("goods_store_id between", value1, value2, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGoodsStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_store_id not between", value1, value2, "goodsStoreId");
			return (Criteria) this;
		}

		public Criteria andGroupIdIsNull() {
			addCriterion("group_id is null");
			return (Criteria) this;
		}

		public Criteria andGroupIdIsNotNull() {
			addCriterion("group_id is not null");
			return (Criteria) this;
		}

		public Criteria andGroupIdEqualTo(Long value) {
			addCriterion("group_id =", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdNotEqualTo(Long value) {
			addCriterion("group_id <>", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdGreaterThan(Long value) {
			addCriterion("group_id >", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
			addCriterion("group_id >=", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdLessThan(Long value) {
			addCriterion("group_id <", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdLessThanOrEqualTo(Long value) {
			addCriterion("group_id <=", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdIn(List<Long> values) {
			addCriterion("group_id in", values, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdNotIn(List<Long> values) {
			addCriterion("group_id not in", values, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdBetween(Long value1, Long value2) {
			addCriterion("group_id between", value1, value2, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdNotBetween(Long value1, Long value2) {
			addCriterion("group_id not between", value1, value2, "groupId");
			return (Criteria) this;
		}

		public Criteria andTransportIdIsNull() {
			addCriterion("transport_id is null");
			return (Criteria) this;
		}

		public Criteria andTransportIdIsNotNull() {
			addCriterion("transport_id is not null");
			return (Criteria) this;
		}

		public Criteria andTransportIdEqualTo(Long value) {
			addCriterion("transport_id =", value, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdNotEqualTo(Long value) {
			addCriterion("transport_id <>", value, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdGreaterThan(Long value) {
			addCriterion("transport_id >", value, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdGreaterThanOrEqualTo(Long value) {
			addCriterion("transport_id >=", value, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdLessThan(Long value) {
			addCriterion("transport_id <", value, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdLessThanOrEqualTo(Long value) {
			addCriterion("transport_id <=", value, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdIn(List<Long> values) {
			addCriterion("transport_id in", values, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdNotIn(List<Long> values) {
			addCriterion("transport_id not in", values, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdBetween(Long value1, Long value2) {
			addCriterion("transport_id between", value1, value2, "transportId");
			return (Criteria) this;
		}

		public Criteria andTransportIdNotBetween(Long value1, Long value2) {
			addCriterion("transport_id not between", value1, value2, "transportId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdIsNull() {
			addCriterion("user_admin_id is null");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdIsNotNull() {
			addCriterion("user_admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdEqualTo(Long value) {
			addCriterion("user_admin_id =", value, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdNotEqualTo(Long value) {
			addCriterion("user_admin_id <>", value, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdGreaterThan(Long value) {
			addCriterion("user_admin_id >", value, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_admin_id >=", value, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdLessThan(Long value) {
			addCriterion("user_admin_id <", value, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("user_admin_id <=", value, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdIn(List<Long> values) {
			addCriterion("user_admin_id in", values, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdNotIn(List<Long> values) {
			addCriterion("user_admin_id not in", values, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdBetween(Long value1, Long value2) {
			addCriterion("user_admin_id between", value1, value2, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andUserAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("user_admin_id not between", value1, value2, "userAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdIsNull() {
			addCriterion("ztc_admin_id is null");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdIsNotNull() {
			addCriterion("ztc_admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdEqualTo(Long value) {
			addCriterion("ztc_admin_id =", value, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdNotEqualTo(Long value) {
			addCriterion("ztc_admin_id <>", value, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdGreaterThan(Long value) {
			addCriterion("ztc_admin_id >", value, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ztc_admin_id >=", value, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdLessThan(Long value) {
			addCriterion("ztc_admin_id <", value, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("ztc_admin_id <=", value, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdIn(List<Long> values) {
			addCriterion("ztc_admin_id in", values, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdNotIn(List<Long> values) {
			addCriterion("ztc_admin_id not in", values, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdBetween(Long value1, Long value2) {
			addCriterion("ztc_admin_id between", value1, value2, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andZtcAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("ztc_admin_id not between", value1, value2, "ztcAdminId");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountIsNull() {
			addCriterion("evaluate_count is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountIsNotNull() {
			addCriterion("evaluate_count is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountEqualTo(Integer value) {
			addCriterion("evaluate_count =", value, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountNotEqualTo(Integer value) {
			addCriterion("evaluate_count <>", value, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountGreaterThan(Integer value) {
			addCriterion("evaluate_count >", value, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_count >=", value, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountLessThan(Integer value) {
			addCriterion("evaluate_count <", value, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_count <=", value, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountIn(List<Integer> values) {
			addCriterion("evaluate_count in", values, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountNotIn(List<Integer> values) {
			addCriterion("evaluate_count not in", values, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_count between", value1, value2, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andEvaluateCountNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_count not between", value1, value2, "evaluateCount");
			return (Criteria) this;
		}

		public Criteria andWeixinHotIsNull() {
			addCriterion("weixin_hot is null");
			return (Criteria) this;
		}

		public Criteria andWeixinHotIsNotNull() {
			addCriterion("weixin_hot is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinHotEqualTo(Integer value) {
			addCriterion("weixin_hot =", value, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotNotEqualTo(Integer value) {
			addCriterion("weixin_hot <>", value, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotGreaterThan(Integer value) {
			addCriterion("weixin_hot >", value, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotGreaterThanOrEqualTo(Integer value) {
			addCriterion("weixin_hot >=", value, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotLessThan(Integer value) {
			addCriterion("weixin_hot <", value, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotLessThanOrEqualTo(Integer value) {
			addCriterion("weixin_hot <=", value, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotIn(List<Integer> values) {
			addCriterion("weixin_hot in", values, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotNotIn(List<Integer> values) {
			addCriterion("weixin_hot not in", values, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotBetween(Integer value1, Integer value2) {
			addCriterion("weixin_hot between", value1, value2, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHotNotBetween(Integer value1, Integer value2) {
			addCriterion("weixin_hot not between", value1, value2, "weixinHot");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeIsNull() {
			addCriterion("weixin_hotTime is null");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeIsNotNull() {
			addCriterion("weixin_hotTime is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_hotTime =", value, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_hotTime <>", value, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeGreaterThan(Date value) {
			addCriterionForJDBCDate("weixin_hotTime >", value, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_hotTime >=", value, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeLessThan(Date value) {
			addCriterionForJDBCDate("weixin_hotTime <", value, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_hotTime <=", value, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_hotTime in", values, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_hotTime not in", values, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_hotTime between", value1, value2, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinHottimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_hotTime not between", value1, value2, "weixinHottime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendIsNull() {
			addCriterion("weixin_recommend is null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendIsNotNull() {
			addCriterion("weixin_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendEqualTo(Integer value) {
			addCriterion("weixin_recommend =", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendNotEqualTo(Integer value) {
			addCriterion("weixin_recommend <>", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendGreaterThan(Integer value) {
			addCriterion("weixin_recommend >", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendGreaterThanOrEqualTo(Integer value) {
			addCriterion("weixin_recommend >=", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendLessThan(Integer value) {
			addCriterion("weixin_recommend <", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendLessThanOrEqualTo(Integer value) {
			addCriterion("weixin_recommend <=", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendIn(List<Integer> values) {
			addCriterion("weixin_recommend in", values, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendNotIn(List<Integer> values) {
			addCriterion("weixin_recommend not in", values, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendBetween(Integer value1, Integer value2) {
			addCriterion("weixin_recommend between", value1, value2, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendNotBetween(Integer value1, Integer value2) {
			addCriterion("weixin_recommend not between", value1, value2, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeIsNull() {
			addCriterion("weixin_recommendTime is null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeIsNotNull() {
			addCriterion("weixin_recommendTime is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommendTime =", value, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommendTime <>", value, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeGreaterThan(Date value) {
			addCriterionForJDBCDate("weixin_recommendTime >", value, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommendTime >=", value, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeLessThan(Date value) {
			addCriterionForJDBCDate("weixin_recommendTime <", value, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommendTime <=", value, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_recommendTime in", values, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_recommendTime not in", values, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_recommendTime between", value1, value2, "weixinRecommendtime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendtimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_recommendTime not between", value1, value2, "weixinRecommendtime");
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