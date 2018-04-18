package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ActivityExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ActivityExample() {
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

		public Criteria andAcBeginTimeIsNull() {
			addCriterion("ac_begin_time is null");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeIsNotNull() {
			addCriterion("ac_begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeEqualTo(Date value) {
			addCriterionForJDBCDate("ac_begin_time =", value, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("ac_begin_time <>", value, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("ac_begin_time >", value, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ac_begin_time >=", value, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeLessThan(Date value) {
			addCriterionForJDBCDate("ac_begin_time <", value, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ac_begin_time <=", value, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeIn(List<Date> values) {
			addCriterionForJDBCDate("ac_begin_time in", values, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("ac_begin_time not in", values, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ac_begin_time between", value1, value2, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcBeginTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ac_begin_time not between", value1, value2, "acBeginTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeIsNull() {
			addCriterion("ac_end_time is null");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeIsNotNull() {
			addCriterion("ac_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeEqualTo(Date value) {
			addCriterionForJDBCDate("ac_end_time =", value, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("ac_end_time <>", value, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("ac_end_time >", value, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ac_end_time >=", value, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeLessThan(Date value) {
			addCriterionForJDBCDate("ac_end_time <", value, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ac_end_time <=", value, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeIn(List<Date> values) {
			addCriterionForJDBCDate("ac_end_time in", values, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("ac_end_time not in", values, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ac_end_time between", value1, value2, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcEndTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ac_end_time not between", value1, value2, "acEndTime");
			return (Criteria) this;
		}

		public Criteria andAcRebateIsNull() {
			addCriterion("ac_rebate is null");
			return (Criteria) this;
		}

		public Criteria andAcRebateIsNotNull() {
			addCriterion("ac_rebate is not null");
			return (Criteria) this;
		}

		public Criteria andAcRebateEqualTo(BigDecimal value) {
			addCriterion("ac_rebate =", value, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateNotEqualTo(BigDecimal value) {
			addCriterion("ac_rebate <>", value, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateGreaterThan(BigDecimal value) {
			addCriterion("ac_rebate >", value, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate >=", value, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateLessThan(BigDecimal value) {
			addCriterion("ac_rebate <", value, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate <=", value, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateIn(List<BigDecimal> values) {
			addCriterion("ac_rebate in", values, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateNotIn(List<BigDecimal> values) {
			addCriterion("ac_rebate not in", values, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate between", value1, value2, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate not between", value1, value2, "acRebate");
			return (Criteria) this;
		}

		public Criteria andAcRebate1IsNull() {
			addCriterion("ac_rebate1 is null");
			return (Criteria) this;
		}

		public Criteria andAcRebate1IsNotNull() {
			addCriterion("ac_rebate1 is not null");
			return (Criteria) this;
		}

		public Criteria andAcRebate1EqualTo(BigDecimal value) {
			addCriterion("ac_rebate1 =", value, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1NotEqualTo(BigDecimal value) {
			addCriterion("ac_rebate1 <>", value, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1GreaterThan(BigDecimal value) {
			addCriterion("ac_rebate1 >", value, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate1 >=", value, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1LessThan(BigDecimal value) {
			addCriterion("ac_rebate1 <", value, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1LessThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate1 <=", value, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1In(List<BigDecimal> values) {
			addCriterion("ac_rebate1 in", values, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1NotIn(List<BigDecimal> values) {
			addCriterion("ac_rebate1 not in", values, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1Between(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate1 between", value1, value2, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate1NotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate1 not between", value1, value2, "acRebate1");
			return (Criteria) this;
		}

		public Criteria andAcRebate2IsNull() {
			addCriterion("ac_rebate2 is null");
			return (Criteria) this;
		}

		public Criteria andAcRebate2IsNotNull() {
			addCriterion("ac_rebate2 is not null");
			return (Criteria) this;
		}

		public Criteria andAcRebate2EqualTo(BigDecimal value) {
			addCriterion("ac_rebate2 =", value, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2NotEqualTo(BigDecimal value) {
			addCriterion("ac_rebate2 <>", value, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2GreaterThan(BigDecimal value) {
			addCriterion("ac_rebate2 >", value, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate2 >=", value, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2LessThan(BigDecimal value) {
			addCriterion("ac_rebate2 <", value, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2LessThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate2 <=", value, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2In(List<BigDecimal> values) {
			addCriterion("ac_rebate2 in", values, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2NotIn(List<BigDecimal> values) {
			addCriterion("ac_rebate2 not in", values, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2Between(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate2 between", value1, value2, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate2NotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate2 not between", value1, value2, "acRebate2");
			return (Criteria) this;
		}

		public Criteria andAcRebate3IsNull() {
			addCriterion("ac_rebate3 is null");
			return (Criteria) this;
		}

		public Criteria andAcRebate3IsNotNull() {
			addCriterion("ac_rebate3 is not null");
			return (Criteria) this;
		}

		public Criteria andAcRebate3EqualTo(BigDecimal value) {
			addCriterion("ac_rebate3 =", value, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3NotEqualTo(BigDecimal value) {
			addCriterion("ac_rebate3 <>", value, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3GreaterThan(BigDecimal value) {
			addCriterion("ac_rebate3 >", value, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate3 >=", value, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3LessThan(BigDecimal value) {
			addCriterion("ac_rebate3 <", value, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3LessThanOrEqualTo(BigDecimal value) {
			addCriterion("ac_rebate3 <=", value, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3In(List<BigDecimal> values) {
			addCriterion("ac_rebate3 in", values, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3NotIn(List<BigDecimal> values) {
			addCriterion("ac_rebate3 not in", values, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3Between(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate3 between", value1, value2, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcRebate3NotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ac_rebate3 not between", value1, value2, "acRebate3");
			return (Criteria) this;
		}

		public Criteria andAcSequenceIsNull() {
			addCriterion("ac_sequence is null");
			return (Criteria) this;
		}

		public Criteria andAcSequenceIsNotNull() {
			addCriterion("ac_sequence is not null");
			return (Criteria) this;
		}

		public Criteria andAcSequenceEqualTo(Integer value) {
			addCriterion("ac_sequence =", value, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceNotEqualTo(Integer value) {
			addCriterion("ac_sequence <>", value, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceGreaterThan(Integer value) {
			addCriterion("ac_sequence >", value, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ac_sequence >=", value, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceLessThan(Integer value) {
			addCriterion("ac_sequence <", value, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("ac_sequence <=", value, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceIn(List<Integer> values) {
			addCriterion("ac_sequence in", values, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceNotIn(List<Integer> values) {
			addCriterion("ac_sequence not in", values, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceBetween(Integer value1, Integer value2) {
			addCriterion("ac_sequence between", value1, value2, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("ac_sequence not between", value1, value2, "acSequence");
			return (Criteria) this;
		}

		public Criteria andAcStatusIsNull() {
			addCriterion("ac_status is null");
			return (Criteria) this;
		}

		public Criteria andAcStatusIsNotNull() {
			addCriterion("ac_status is not null");
			return (Criteria) this;
		}

		public Criteria andAcStatusEqualTo(Integer value) {
			addCriterion("ac_status =", value, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusNotEqualTo(Integer value) {
			addCriterion("ac_status <>", value, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusGreaterThan(Integer value) {
			addCriterion("ac_status >", value, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("ac_status >=", value, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusLessThan(Integer value) {
			addCriterion("ac_status <", value, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusLessThanOrEqualTo(Integer value) {
			addCriterion("ac_status <=", value, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusIn(List<Integer> values) {
			addCriterion("ac_status in", values, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusNotIn(List<Integer> values) {
			addCriterion("ac_status not in", values, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusBetween(Integer value1, Integer value2) {
			addCriterion("ac_status between", value1, value2, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("ac_status not between", value1, value2, "acStatus");
			return (Criteria) this;
		}

		public Criteria andAcTitleIsNull() {
			addCriterion("ac_title is null");
			return (Criteria) this;
		}

		public Criteria andAcTitleIsNotNull() {
			addCriterion("ac_title is not null");
			return (Criteria) this;
		}

		public Criteria andAcTitleEqualTo(String value) {
			addCriterion("ac_title =", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleNotEqualTo(String value) {
			addCriterion("ac_title <>", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleGreaterThan(String value) {
			addCriterion("ac_title >", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleGreaterThanOrEqualTo(String value) {
			addCriterion("ac_title >=", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleLessThan(String value) {
			addCriterion("ac_title <", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleLessThanOrEqualTo(String value) {
			addCriterion("ac_title <=", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleLike(String value) {
			addCriterion("ac_title like", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleNotLike(String value) {
			addCriterion("ac_title not like", value, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleIn(List<String> values) {
			addCriterion("ac_title in", values, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleNotIn(List<String> values) {
			addCriterion("ac_title not in", values, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleBetween(String value1, String value2) {
			addCriterion("ac_title between", value1, value2, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcTitleNotBetween(String value1, String value2) {
			addCriterion("ac_title not between", value1, value2, "acTitle");
			return (Criteria) this;
		}

		public Criteria andAcAccIsNull() {
			addCriterion("ac_acc is null");
			return (Criteria) this;
		}

		public Criteria andAcAccIsNotNull() {
			addCriterion("ac_acc is not null");
			return (Criteria) this;
		}

		public Criteria andAcAccEqualTo(String value) {
			addCriterion("ac_acc =", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccNotEqualTo(String value) {
			addCriterion("ac_acc <>", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccGreaterThan(String value) {
			addCriterion("ac_acc >", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccGreaterThanOrEqualTo(String value) {
			addCriterion("ac_acc >=", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccLessThan(String value) {
			addCriterion("ac_acc <", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccLessThanOrEqualTo(String value) {
			addCriterion("ac_acc <=", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccLike(String value) {
			addCriterion("ac_acc like", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccNotLike(String value) {
			addCriterion("ac_acc not like", value, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccIn(List<String> values) {
			addCriterion("ac_acc in", values, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccNotIn(List<String> values) {
			addCriterion("ac_acc not in", values, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccBetween(String value1, String value2) {
			addCriterion("ac_acc between", value1, value2, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAccNotBetween(String value1, String value2) {
			addCriterion("ac_acc not between", value1, value2, "acAcc");
			return (Criteria) this;
		}

		public Criteria andAcAcc2IsNull() {
			addCriterion("ac_acc2 is null");
			return (Criteria) this;
		}

		public Criteria andAcAcc2IsNotNull() {
			addCriterion("ac_acc2 is not null");
			return (Criteria) this;
		}

		public Criteria andAcAcc2EqualTo(String value) {
			addCriterion("ac_acc2 =", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2NotEqualTo(String value) {
			addCriterion("ac_acc2 <>", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2GreaterThan(String value) {
			addCriterion("ac_acc2 >", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2GreaterThanOrEqualTo(String value) {
			addCriterion("ac_acc2 >=", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2LessThan(String value) {
			addCriterion("ac_acc2 <", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2LessThanOrEqualTo(String value) {
			addCriterion("ac_acc2 <=", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2Like(String value) {
			addCriterion("ac_acc2 like", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2NotLike(String value) {
			addCriterion("ac_acc2 not like", value, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2In(List<String> values) {
			addCriterion("ac_acc2 in", values, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2NotIn(List<String> values) {
			addCriterion("ac_acc2 not in", values, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2Between(String value1, String value2) {
			addCriterion("ac_acc2 between", value1, value2, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc2NotBetween(String value1, String value2) {
			addCriterion("ac_acc2 not between", value1, value2, "acAcc2");
			return (Criteria) this;
		}

		public Criteria andAcAcc3IsNull() {
			addCriterion("ac_acc3 is null");
			return (Criteria) this;
		}

		public Criteria andAcAcc3IsNotNull() {
			addCriterion("ac_acc3 is not null");
			return (Criteria) this;
		}

		public Criteria andAcAcc3EqualTo(String value) {
			addCriterion("ac_acc3 =", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3NotEqualTo(String value) {
			addCriterion("ac_acc3 <>", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3GreaterThan(String value) {
			addCriterion("ac_acc3 >", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3GreaterThanOrEqualTo(String value) {
			addCriterion("ac_acc3 >=", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3LessThan(String value) {
			addCriterion("ac_acc3 <", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3LessThanOrEqualTo(String value) {
			addCriterion("ac_acc3 <=", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3Like(String value) {
			addCriterion("ac_acc3 like", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3NotLike(String value) {
			addCriterion("ac_acc3 not like", value, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3In(List<String> values) {
			addCriterion("ac_acc3 in", values, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3NotIn(List<String> values) {
			addCriterion("ac_acc3 not in", values, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3Between(String value1, String value2) {
			addCriterion("ac_acc3 between", value1, value2, "acAcc3");
			return (Criteria) this;
		}

		public Criteria andAcAcc3NotBetween(String value1, String value2) {
			addCriterion("ac_acc3 not between", value1, value2, "acAcc3");
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