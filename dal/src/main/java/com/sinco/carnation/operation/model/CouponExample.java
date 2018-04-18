package com.sinco.carnation.operation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CouponExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CouponExample() {
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

		public Criteria andCouponAmountIsNull() {
			addCriterion("coupon_amount is null");
			return (Criteria) this;
		}

		public Criteria andCouponAmountIsNotNull() {
			addCriterion("coupon_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCouponAmountEqualTo(Long value) {
			addCriterion("coupon_amount =", value, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountNotEqualTo(Long value) {
			addCriterion("coupon_amount <>", value, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountGreaterThan(Long value) {
			addCriterion("coupon_amount >", value, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_amount >=", value, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountLessThan(Long value) {
			addCriterion("coupon_amount <", value, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountLessThanOrEqualTo(Long value) {
			addCriterion("coupon_amount <=", value, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountIn(List<Long> values) {
			addCriterion("coupon_amount in", values, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountNotIn(List<Long> values) {
			addCriterion("coupon_amount not in", values, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountBetween(Long value1, Long value2) {
			addCriterion("coupon_amount between", value1, value2, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponAmountNotBetween(Long value1, Long value2) {
			addCriterion("coupon_amount not between", value1, value2, "couponAmount");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeIsNull() {
			addCriterion("coupon_begin_time is null");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeIsNotNull() {
			addCriterion("coupon_begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_begin_time =", value, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_begin_time <>", value, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("coupon_begin_time >", value, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_begin_time >=", value, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeLessThan(Date value) {
			addCriterionForJDBCDate("coupon_begin_time <", value, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_begin_time <=", value, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeIn(List<Date> values) {
			addCriterionForJDBCDate("coupon_begin_time in", values, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("coupon_begin_time not in", values, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("coupon_begin_time between", value1, value2, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponBeginTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("coupon_begin_time not between", value1, value2, "couponBeginTime");
			return (Criteria) this;
		}

		public Criteria andCouponCountIsNull() {
			addCriterion("coupon_count is null");
			return (Criteria) this;
		}

		public Criteria andCouponCountIsNotNull() {
			addCriterion("coupon_count is not null");
			return (Criteria) this;
		}

		public Criteria andCouponCountEqualTo(Integer value) {
			addCriterion("coupon_count =", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountNotEqualTo(Integer value) {
			addCriterion("coupon_count <>", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountGreaterThan(Integer value) {
			addCriterion("coupon_count >", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_count >=", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountLessThan(Integer value) {
			addCriterion("coupon_count <", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_count <=", value, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountIn(List<Integer> values) {
			addCriterion("coupon_count in", values, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountNotIn(List<Integer> values) {
			addCriterion("coupon_count not in", values, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountBetween(Integer value1, Integer value2) {
			addCriterion("coupon_count between", value1, value2, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_count not between", value1, value2, "couponCount");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeIsNull() {
			addCriterion("coupon_end_time is null");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeIsNotNull() {
			addCriterion("coupon_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_end_time =", value, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_end_time <>", value, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("coupon_end_time >", value, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_end_time >=", value, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeLessThan(Date value) {
			addCriterionForJDBCDate("coupon_end_time <", value, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("coupon_end_time <=", value, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeIn(List<Date> values) {
			addCriterionForJDBCDate("coupon_end_time in", values, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("coupon_end_time not in", values, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("coupon_end_time between", value1, value2, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponEndTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("coupon_end_time not between", value1, value2, "couponEndTime");
			return (Criteria) this;
		}

		public Criteria andCouponNameIsNull() {
			addCriterion("coupon_name is null");
			return (Criteria) this;
		}

		public Criteria andCouponNameIsNotNull() {
			addCriterion("coupon_name is not null");
			return (Criteria) this;
		}

		public Criteria andCouponNameEqualTo(String value) {
			addCriterion("coupon_name =", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotEqualTo(String value) {
			addCriterion("coupon_name <>", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameGreaterThan(String value) {
			addCriterion("coupon_name >", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_name >=", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLessThan(String value) {
			addCriterion("coupon_name <", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLessThanOrEqualTo(String value) {
			addCriterion("coupon_name <=", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameLike(String value) {
			addCriterion("coupon_name like", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotLike(String value) {
			addCriterion("coupon_name not like", value, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameIn(List<String> values) {
			addCriterion("coupon_name in", values, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotIn(List<String> values) {
			addCriterion("coupon_name not in", values, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameBetween(String value1, String value2) {
			addCriterion("coupon_name between", value1, value2, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponNameNotBetween(String value1, String value2) {
			addCriterion("coupon_name not between", value1, value2, "couponName");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountIsNull() {
			addCriterion("coupon_order_amount is null");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountIsNotNull() {
			addCriterion("coupon_order_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountEqualTo(Long value) {
			addCriterion("coupon_order_amount =", value, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountNotEqualTo(Long value) {
			addCriterion("coupon_order_amount <>", value, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountGreaterThan(Long value) {
			addCriterion("coupon_order_amount >", value, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_order_amount >=", value, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountLessThan(Long value) {
			addCriterion("coupon_order_amount <", value, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountLessThanOrEqualTo(Long value) {
			addCriterion("coupon_order_amount <=", value, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountIn(List<Long> values) {
			addCriterion("coupon_order_amount in", values, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountNotIn(List<Long> values) {
			addCriterion("coupon_order_amount not in", values, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountBetween(Long value1, Long value2) {
			addCriterion("coupon_order_amount between", value1, value2, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponOrderAmountNotBetween(Long value1, Long value2) {
			addCriterion("coupon_order_amount not between", value1, value2, "couponOrderAmount");
			return (Criteria) this;
		}

		public Criteria andCouponTypeIsNull() {
			addCriterion("coupon_type is null");
			return (Criteria) this;
		}

		public Criteria andCouponTypeIsNotNull() {
			addCriterion("coupon_type is not null");
			return (Criteria) this;
		}

		public Criteria andCouponTypeEqualTo(Integer value) {
			addCriterion("coupon_type =", value, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeNotEqualTo(Integer value) {
			addCriterion("coupon_type <>", value, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeGreaterThan(Integer value) {
			addCriterion("coupon_type >", value, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("coupon_type >=", value, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeLessThan(Integer value) {
			addCriterion("coupon_type <", value, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeLessThanOrEqualTo(Integer value) {
			addCriterion("coupon_type <=", value, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeIn(List<Integer> values) {
			addCriterion("coupon_type in", values, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeNotIn(List<Integer> values) {
			addCriterion("coupon_type not in", values, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeBetween(Integer value1, Integer value2) {
			addCriterion("coupon_type between", value1, value2, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("coupon_type not between", value1, value2, "couponType");
			return (Criteria) this;
		}

		public Criteria andCouponAccIsNull() {
			addCriterion("coupon_acc is null");
			return (Criteria) this;
		}

		public Criteria andCouponAccIsNotNull() {
			addCriterion("coupon_acc is not null");
			return (Criteria) this;
		}

		public Criteria andCouponAccEqualTo(String value) {
			addCriterion("coupon_acc =", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccNotEqualTo(String value) {
			addCriterion("coupon_acc <>", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccGreaterThan(String value) {
			addCriterion("coupon_acc >", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccGreaterThanOrEqualTo(String value) {
			addCriterion("coupon_acc >=", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccLessThan(String value) {
			addCriterion("coupon_acc <", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccLessThanOrEqualTo(String value) {
			addCriterion("coupon_acc <=", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccLike(String value) {
			addCriterion("coupon_acc like", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccNotLike(String value) {
			addCriterion("coupon_acc not like", value, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccIn(List<String> values) {
			addCriterion("coupon_acc in", values, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccNotIn(List<String> values) {
			addCriterion("coupon_acc not in", values, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccBetween(String value1, String value2) {
			addCriterion("coupon_acc between", value1, value2, "couponAcc");
			return (Criteria) this;
		}

		public Criteria andCouponAccNotBetween(String value1, String value2) {
			addCriterion("coupon_acc not between", value1, value2, "couponAcc");
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