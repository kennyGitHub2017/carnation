package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FreeGoodsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FreeGoodsExample() {
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

		public Criteria andApplyCountIsNull() {
			addCriterion("apply_count is null");
			return (Criteria) this;
		}

		public Criteria andApplyCountIsNotNull() {
			addCriterion("apply_count is not null");
			return (Criteria) this;
		}

		public Criteria andApplyCountEqualTo(Integer value) {
			addCriterion("apply_count =", value, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountNotEqualTo(Integer value) {
			addCriterion("apply_count <>", value, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountGreaterThan(Integer value) {
			addCriterion("apply_count >", value, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("apply_count >=", value, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountLessThan(Integer value) {
			addCriterion("apply_count <", value, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountLessThanOrEqualTo(Integer value) {
			addCriterion("apply_count <=", value, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountIn(List<Integer> values) {
			addCriterion("apply_count in", values, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountNotIn(List<Integer> values) {
			addCriterion("apply_count not in", values, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountBetween(Integer value1, Integer value2) {
			addCriterion("apply_count between", value1, value2, "applyCount");
			return (Criteria) this;
		}

		public Criteria andApplyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("apply_count not between", value1, value2, "applyCount");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIsNull() {
			addCriterion("begin_time is null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIsNotNull() {
			addCriterion("begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeEqualTo(Date value) {
			addCriterion("begin_time =", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotEqualTo(Date value) {
			addCriterion("begin_time <>", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThan(Date value) {
			addCriterion("begin_time >", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("begin_time >=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThan(Date value) {
			addCriterion("begin_time <", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
			addCriterion("begin_time <=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIn(List<Date> values) {
			addCriterion("begin_time in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotIn(List<Date> values) {
			addCriterion("begin_time not in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeBetween(Date value1, Date value2) {
			addCriterion("begin_time between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
			addCriterion("begin_time not between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNull() {
			addCriterion("class_id is null");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNotNull() {
			addCriterion("class_id is not null");
			return (Criteria) this;
		}

		public Criteria andClassIdEqualTo(Long value) {
			addCriterion("class_id =", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotEqualTo(Long value) {
			addCriterion("class_id <>", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThan(Long value) {
			addCriterion("class_id >", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThanOrEqualTo(Long value) {
			addCriterion("class_id >=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThan(Long value) {
			addCriterion("class_id <", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThanOrEqualTo(Long value) {
			addCriterion("class_id <=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdIn(List<Long> values) {
			addCriterion("class_id in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotIn(List<Long> values) {
			addCriterion("class_id not in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdBetween(Long value1, Long value2) {
			addCriterion("class_id between", value1, value2, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotBetween(Long value1, Long value2) {
			addCriterion("class_id not between", value1, value2, "classId");
			return (Criteria) this;
		}

		public Criteria andCurrentCountIsNull() {
			addCriterion("current_count is null");
			return (Criteria) this;
		}

		public Criteria andCurrentCountIsNotNull() {
			addCriterion("current_count is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentCountEqualTo(Integer value) {
			addCriterion("current_count =", value, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountNotEqualTo(Integer value) {
			addCriterion("current_count <>", value, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountGreaterThan(Integer value) {
			addCriterion("current_count >", value, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("current_count >=", value, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountLessThan(Integer value) {
			addCriterion("current_count <", value, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountLessThanOrEqualTo(Integer value) {
			addCriterion("current_count <=", value, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountIn(List<Integer> values) {
			addCriterion("current_count in", values, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountNotIn(List<Integer> values) {
			addCriterion("current_count not in", values, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountBetween(Integer value1, Integer value2) {
			addCriterion("current_count between", value1, value2, "currentCount");
			return (Criteria) this;
		}

		public Criteria andCurrentCountNotBetween(Integer value1, Integer value2) {
			addCriterion("current_count not between", value1, value2, "currentCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountIsNull() {
			addCriterion("default_count is null");
			return (Criteria) this;
		}

		public Criteria andDefaultCountIsNotNull() {
			addCriterion("default_count is not null");
			return (Criteria) this;
		}

		public Criteria andDefaultCountEqualTo(Integer value) {
			addCriterion("default_count =", value, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountNotEqualTo(Integer value) {
			addCriterion("default_count <>", value, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountGreaterThan(Integer value) {
			addCriterion("default_count >", value, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("default_count >=", value, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountLessThan(Integer value) {
			addCriterion("default_count <", value, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountLessThanOrEqualTo(Integer value) {
			addCriterion("default_count <=", value, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountIn(List<Integer> values) {
			addCriterion("default_count in", values, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountNotIn(List<Integer> values) {
			addCriterion("default_count not in", values, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountBetween(Integer value1, Integer value2) {
			addCriterion("default_count between", value1, value2, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andDefaultCountNotBetween(Integer value1, Integer value2) {
			addCriterion("default_count not between", value1, value2, "defaultCount");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andFailedReasonIsNull() {
			addCriterion("failed_reason is null");
			return (Criteria) this;
		}

		public Criteria andFailedReasonIsNotNull() {
			addCriterion("failed_reason is not null");
			return (Criteria) this;
		}

		public Criteria andFailedReasonEqualTo(String value) {
			addCriterion("failed_reason =", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonNotEqualTo(String value) {
			addCriterion("failed_reason <>", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonGreaterThan(String value) {
			addCriterion("failed_reason >", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonGreaterThanOrEqualTo(String value) {
			addCriterion("failed_reason >=", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonLessThan(String value) {
			addCriterion("failed_reason <", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonLessThanOrEqualTo(String value) {
			addCriterion("failed_reason <=", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonLike(String value) {
			addCriterion("failed_reason like", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonNotLike(String value) {
			addCriterion("failed_reason not like", value, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonIn(List<String> values) {
			addCriterion("failed_reason in", values, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonNotIn(List<String> values) {
			addCriterion("failed_reason not in", values, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonBetween(String value1, String value2) {
			addCriterion("failed_reason between", value1, value2, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFailedReasonNotBetween(String value1, String value2) {
			addCriterion("failed_reason not between", value1, value2, "failedReason");
			return (Criteria) this;
		}

		public Criteria andFreeStatusIsNull() {
			addCriterion("free_status is null");
			return (Criteria) this;
		}

		public Criteria andFreeStatusIsNotNull() {
			addCriterion("free_status is not null");
			return (Criteria) this;
		}

		public Criteria andFreeStatusEqualTo(Integer value) {
			addCriterion("free_status =", value, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusNotEqualTo(Integer value) {
			addCriterion("free_status <>", value, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusGreaterThan(Integer value) {
			addCriterion("free_status >", value, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("free_status >=", value, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusLessThan(Integer value) {
			addCriterion("free_status <", value, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusLessThanOrEqualTo(Integer value) {
			addCriterion("free_status <=", value, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusIn(List<Integer> values) {
			addCriterion("free_status in", values, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusNotIn(List<Integer> values) {
			addCriterion("free_status not in", values, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusBetween(Integer value1, Integer value2) {
			addCriterion("free_status between", value1, value2, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("free_status not between", value1, value2, "freeStatus");
			return (Criteria) this;
		}

		public Criteria andFreeTypeIsNull() {
			addCriterion("free_type is null");
			return (Criteria) this;
		}

		public Criteria andFreeTypeIsNotNull() {
			addCriterion("free_type is not null");
			return (Criteria) this;
		}

		public Criteria andFreeTypeEqualTo(Integer value) {
			addCriterion("free_type =", value, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeNotEqualTo(Integer value) {
			addCriterion("free_type <>", value, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeGreaterThan(Integer value) {
			addCriterion("free_type >", value, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("free_type >=", value, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeLessThan(Integer value) {
			addCriterion("free_type <", value, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeLessThanOrEqualTo(Integer value) {
			addCriterion("free_type <=", value, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeIn(List<Integer> values) {
			addCriterion("free_type in", values, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeNotIn(List<Integer> values) {
			addCriterion("free_type not in", values, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeBetween(Integer value1, Integer value2) {
			addCriterion("free_type between", value1, value2, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("free_type not between", value1, value2, "freeType");
			return (Criteria) this;
		}

		public Criteria andFreeNameIsNull() {
			addCriterion("free_name is null");
			return (Criteria) this;
		}

		public Criteria andFreeNameIsNotNull() {
			addCriterion("free_name is not null");
			return (Criteria) this;
		}

		public Criteria andFreeNameEqualTo(String value) {
			addCriterion("free_name =", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameNotEqualTo(String value) {
			addCriterion("free_name <>", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameGreaterThan(String value) {
			addCriterion("free_name >", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameGreaterThanOrEqualTo(String value) {
			addCriterion("free_name >=", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameLessThan(String value) {
			addCriterion("free_name <", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameLessThanOrEqualTo(String value) {
			addCriterion("free_name <=", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameLike(String value) {
			addCriterion("free_name like", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameNotLike(String value) {
			addCriterion("free_name not like", value, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameIn(List<String> values) {
			addCriterion("free_name in", values, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameNotIn(List<String> values) {
			addCriterion("free_name not in", values, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameBetween(String value1, String value2) {
			addCriterion("free_name between", value1, value2, "freeName");
			return (Criteria) this;
		}

		public Criteria andFreeNameNotBetween(String value1, String value2) {
			addCriterion("free_name not between", value1, value2, "freeName");
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

		public Criteria andFreeAccPathIsNull() {
			addCriterion("free_acc_path is null");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathIsNotNull() {
			addCriterion("free_acc_path is not null");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathEqualTo(String value) {
			addCriterion("free_acc_path =", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathNotEqualTo(String value) {
			addCriterion("free_acc_path <>", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathGreaterThan(String value) {
			addCriterion("free_acc_path >", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathGreaterThanOrEqualTo(String value) {
			addCriterion("free_acc_path >=", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathLessThan(String value) {
			addCriterion("free_acc_path <", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathLessThanOrEqualTo(String value) {
			addCriterion("free_acc_path <=", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathLike(String value) {
			addCriterion("free_acc_path like", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathNotLike(String value) {
			addCriterion("free_acc_path not like", value, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathIn(List<String> values) {
			addCriterion("free_acc_path in", values, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathNotIn(List<String> values) {
			addCriterion("free_acc_path not in", values, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathBetween(String value1, String value2) {
			addCriterion("free_acc_path between", value1, value2, "freeAccPath");
			return (Criteria) this;
		}

		public Criteria andFreeAccPathNotBetween(String value1, String value2) {
			addCriterion("free_acc_path not between", value1, value2, "freeAccPath");
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

		public Criteria andMobileRecommendTimeIsNull() {
			addCriterion("mobile_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeIsNotNull() {
			addCriterion("mobile_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time =", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time <>", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time >", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time >=", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeLessThan(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time <", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time <=", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_recommend_time in", values, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_recommend_time not in", values, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_recommend_time between", value1, value2, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_recommend_time not between", value1, value2,
					"mobileRecommendTime");
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

		public Criteria andWeixinRecommendTimeIsNull() {
			addCriterion("weixin_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeIsNotNull() {
			addCriterion("weixin_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time =", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time <>", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time >", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time >=", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeLessThan(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time <", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time <=", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_recommend_time in", values, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_recommend_time not in", values, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_recommend_time between", value1, value2, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_recommend_time not between", value1, value2,
					"weixinRecommendTime");
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