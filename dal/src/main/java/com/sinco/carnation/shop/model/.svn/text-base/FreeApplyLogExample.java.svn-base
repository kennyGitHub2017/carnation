package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreeApplyLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FreeApplyLogExample() {
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

		public Criteria andDeleteStatusEqualTo(Boolean value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusIsNull() {
			addCriterion("apply_status is null");
			return (Criteria) this;
		}

		public Criteria andApplyStatusIsNotNull() {
			addCriterion("apply_status is not null");
			return (Criteria) this;
		}

		public Criteria andApplyStatusEqualTo(Integer value) {
			addCriterion("apply_status =", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusNotEqualTo(Integer value) {
			addCriterion("apply_status <>", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusGreaterThan(Integer value) {
			addCriterion("apply_status >", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("apply_status >=", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusLessThan(Integer value) {
			addCriterion("apply_status <", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
			addCriterion("apply_status <=", value, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusIn(List<Integer> values) {
			addCriterion("apply_status in", values, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusNotIn(List<Integer> values) {
			addCriterion("apply_status not in", values, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusBetween(Integer value1, Integer value2) {
			addCriterion("apply_status between", value1, value2, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("apply_status not between", value1, value2, "applyStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusIsNull() {
			addCriterion("evaluate_status is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusIsNotNull() {
			addCriterion("evaluate_status is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusEqualTo(Integer value) {
			addCriterion("evaluate_status =", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusNotEqualTo(Integer value) {
			addCriterion("evaluate_status <>", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusGreaterThan(Integer value) {
			addCriterion("evaluate_status >", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_status >=", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusLessThan(Integer value) {
			addCriterion("evaluate_status <", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_status <=", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusIn(List<Integer> values) {
			addCriterion("evaluate_status in", values, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusNotIn(List<Integer> values) {
			addCriterion("evaluate_status not in", values, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_status between", value1, value2, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_status not between", value1, value2, "evaluateStatus");
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

		public Criteria andFreeGoodsIdIsNull() {
			addCriterion("free_goods_id is null");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdIsNotNull() {
			addCriterion("free_goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdEqualTo(Long value) {
			addCriterion("free_goods_id =", value, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdNotEqualTo(Long value) {
			addCriterion("free_goods_id <>", value, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdGreaterThan(Long value) {
			addCriterion("free_goods_id >", value, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("free_goods_id >=", value, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdLessThan(Long value) {
			addCriterion("free_goods_id <", value, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("free_goods_id <=", value, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdIn(List<Long> values) {
			addCriterion("free_goods_id in", values, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdNotIn(List<Long> values) {
			addCriterion("free_goods_id not in", values, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdBetween(Long value1, Long value2) {
			addCriterion("free_goods_id between", value1, value2, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("free_goods_id not between", value1, value2, "freeGoodsId");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameIsNull() {
			addCriterion("free_goods_name is null");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameIsNotNull() {
			addCriterion("free_goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameEqualTo(String value) {
			addCriterion("free_goods_name =", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameNotEqualTo(String value) {
			addCriterion("free_goods_name <>", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameGreaterThan(String value) {
			addCriterion("free_goods_name >", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("free_goods_name >=", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameLessThan(String value) {
			addCriterion("free_goods_name <", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("free_goods_name <=", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameLike(String value) {
			addCriterion("free_goods_name like", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameNotLike(String value) {
			addCriterion("free_goods_name not like", value, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameIn(List<String> values) {
			addCriterion("free_goods_name in", values, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameNotIn(List<String> values) {
			addCriterion("free_goods_name not in", values, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameBetween(String value1, String value2) {
			addCriterion("free_goods_name between", value1, value2, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andFreeGoodsNameNotBetween(String value1, String value2) {
			addCriterion("free_goods_name not between", value1, value2, "freeGoodsName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNull() {
			addCriterion("receiver_name is null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNotNull() {
			addCriterion("receiver_name is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameEqualTo(String value) {
			addCriterion("receiver_name =", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotEqualTo(String value) {
			addCriterion("receiver_name <>", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThan(String value) {
			addCriterion("receiver_name >", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_name >=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThan(String value) {
			addCriterion("receiver_name <", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThanOrEqualTo(String value) {
			addCriterion("receiver_name <=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLike(String value) {
			addCriterion("receiver_name like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotLike(String value) {
			addCriterion("receiver_name not like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIn(List<String> values) {
			addCriterion("receiver_name in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotIn(List<String> values) {
			addCriterion("receiver_name not in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameBetween(String value1, String value2) {
			addCriterion("receiver_name between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotBetween(String value1, String value2) {
			addCriterion("receiver_name not between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIsNull() {
			addCriterion("receiver_area is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIsNotNull() {
			addCriterion("receiver_area is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaEqualTo(String value) {
			addCriterion("receiver_area =", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotEqualTo(String value) {
			addCriterion("receiver_area <>", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaGreaterThan(String value) {
			addCriterion("receiver_area >", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_area >=", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLessThan(String value) {
			addCriterion("receiver_area <", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLessThanOrEqualTo(String value) {
			addCriterion("receiver_area <=", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLike(String value) {
			addCriterion("receiver_area like", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotLike(String value) {
			addCriterion("receiver_area not like", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIn(List<String> values) {
			addCriterion("receiver_area in", values, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotIn(List<String> values) {
			addCriterion("receiver_area not in", values, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaBetween(String value1, String value2) {
			addCriterion("receiver_area between", value1, value2, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotBetween(String value1, String value2) {
			addCriterion("receiver_area not between", value1, value2, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIsNull() {
			addCriterion("receiver_area_info is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIsNotNull() {
			addCriterion("receiver_area_info is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoEqualTo(String value) {
			addCriterion("receiver_area_info =", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotEqualTo(String value) {
			addCriterion("receiver_area_info <>", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoGreaterThan(String value) {
			addCriterion("receiver_area_info >", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_area_info >=", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLessThan(String value) {
			addCriterion("receiver_area_info <", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLessThanOrEqualTo(String value) {
			addCriterion("receiver_area_info <=", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLike(String value) {
			addCriterion("receiver_area_info like", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotLike(String value) {
			addCriterion("receiver_area_info not like", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIn(List<String> values) {
			addCriterion("receiver_area_info in", values, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotIn(List<String> values) {
			addCriterion("receiver_area_info not in", values, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoBetween(String value1, String value2) {
			addCriterion("receiver_area_info between", value1, value2, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotBetween(String value1, String value2) {
			addCriterion("receiver_area_info not between", value1, value2, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIsNull() {
			addCriterion("receiver_mobile is null");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIsNotNull() {
			addCriterion("receiver_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileEqualTo(String value) {
			addCriterion("receiver_mobile =", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotEqualTo(String value) {
			addCriterion("receiver_mobile <>", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileGreaterThan(String value) {
			addCriterion("receiver_mobile >", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_mobile >=", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLessThan(String value) {
			addCriterion("receiver_mobile <", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
			addCriterion("receiver_mobile <=", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLike(String value) {
			addCriterion("receiver_mobile like", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotLike(String value) {
			addCriterion("receiver_mobile not like", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIn(List<String> values) {
			addCriterion("receiver_mobile in", values, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotIn(List<String> values) {
			addCriterion("receiver_mobile not in", values, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileBetween(String value1, String value2) {
			addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotBetween(String value1, String value2) {
			addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIsNull() {
			addCriterion("receiver_telephone is null");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIsNotNull() {
			addCriterion("receiver_telephone is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneEqualTo(String value) {
			addCriterion("receiver_telephone =", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotEqualTo(String value) {
			addCriterion("receiver_telephone <>", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneGreaterThan(String value) {
			addCriterion("receiver_telephone >", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_telephone >=", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLessThan(String value) {
			addCriterion("receiver_telephone <", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLessThanOrEqualTo(String value) {
			addCriterion("receiver_telephone <=", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLike(String value) {
			addCriterion("receiver_telephone like", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotLike(String value) {
			addCriterion("receiver_telephone not like", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIn(List<String> values) {
			addCriterion("receiver_telephone in", values, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotIn(List<String> values) {
			addCriterion("receiver_telephone not in", values, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneBetween(String value1, String value2) {
			addCriterion("receiver_telephone between", value1, value2, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotBetween(String value1, String value2) {
			addCriterion("receiver_telephone not between", value1, value2, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIsNull() {
			addCriterion("receiver_zip is null");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIsNotNull() {
			addCriterion("receiver_zip is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverZipEqualTo(String value) {
			addCriterion("receiver_zip =", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotEqualTo(String value) {
			addCriterion("receiver_zip <>", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipGreaterThan(String value) {
			addCriterion("receiver_zip >", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_zip >=", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLessThan(String value) {
			addCriterion("receiver_zip <", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLessThanOrEqualTo(String value) {
			addCriterion("receiver_zip <=", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLike(String value) {
			addCriterion("receiver_zip like", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotLike(String value) {
			addCriterion("receiver_zip not like", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIn(List<String> values) {
			addCriterion("receiver_zip in", values, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotIn(List<String> values) {
			addCriterion("receiver_zip not in", values, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipBetween(String value1, String value2) {
			addCriterion("receiver_zip between", value1, value2, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotBetween(String value1, String value2) {
			addCriterion("receiver_zip not between", value1, value2, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andShipCodeIsNull() {
			addCriterion("ship_code is null");
			return (Criteria) this;
		}

		public Criteria andShipCodeIsNotNull() {
			addCriterion("ship_code is not null");
			return (Criteria) this;
		}

		public Criteria andShipCodeEqualTo(String value) {
			addCriterion("ship_code =", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotEqualTo(String value) {
			addCriterion("ship_code <>", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeGreaterThan(String value) {
			addCriterion("ship_code >", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ship_code >=", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLessThan(String value) {
			addCriterion("ship_code <", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLessThanOrEqualTo(String value) {
			addCriterion("ship_code <=", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLike(String value) {
			addCriterion("ship_code like", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotLike(String value) {
			addCriterion("ship_code not like", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeIn(List<String> values) {
			addCriterion("ship_code in", values, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotIn(List<String> values) {
			addCriterion("ship_code not in", values, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeBetween(String value1, String value2) {
			addCriterion("ship_code between", value1, value2, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotBetween(String value1, String value2) {
			addCriterion("ship_code not between", value1, value2, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdIsNull() {
			addCriterion("ship_addr_id is null");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdIsNotNull() {
			addCriterion("ship_addr_id is not null");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdEqualTo(Long value) {
			addCriterion("ship_addr_id =", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdNotEqualTo(Long value) {
			addCriterion("ship_addr_id <>", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdGreaterThan(Long value) {
			addCriterion("ship_addr_id >", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ship_addr_id >=", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdLessThan(Long value) {
			addCriterion("ship_addr_id <", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdLessThanOrEqualTo(Long value) {
			addCriterion("ship_addr_id <=", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdIn(List<Long> values) {
			addCriterion("ship_addr_id in", values, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdNotIn(List<Long> values) {
			addCriterion("ship_addr_id not in", values, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdBetween(Long value1, Long value2) {
			addCriterion("ship_addr_id between", value1, value2, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdNotBetween(Long value1, Long value2) {
			addCriterion("ship_addr_id not between", value1, value2, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreIdEqualTo(Long value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(Long value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(Long value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(Long value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<Long> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<Long> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(Long value1, Long value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
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

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfIsNull() {
			addCriterion("whether_self is null");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfIsNotNull() {
			addCriterion("whether_self is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfEqualTo(Integer value) {
			addCriterion("whether_self =", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfNotEqualTo(Integer value) {
			addCriterion("whether_self <>", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfGreaterThan(Integer value) {
			addCriterion("whether_self >", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfGreaterThanOrEqualTo(Integer value) {
			addCriterion("whether_self >=", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfLessThan(Integer value) {
			addCriterion("whether_self <", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfLessThanOrEqualTo(Integer value) {
			addCriterion("whether_self <=", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfIn(List<Integer> values) {
			addCriterion("whether_self in", values, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfNotIn(List<Integer> values) {
			addCriterion("whether_self not in", values, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfBetween(Integer value1, Integer value2) {
			addCriterion("whether_self between", value1, value2, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfNotBetween(Integer value1, Integer value2) {
			addCriterion("whether_self not between", value1, value2, "whetherSelf");
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