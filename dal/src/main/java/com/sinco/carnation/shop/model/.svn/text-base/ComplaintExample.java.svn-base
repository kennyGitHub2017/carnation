package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ComplaintExample() {
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

		public Criteria andAppealTimeIsNull() {
			addCriterion("appeal_time is null");
			return (Criteria) this;
		}

		public Criteria andAppealTimeIsNotNull() {
			addCriterion("appeal_time is not null");
			return (Criteria) this;
		}

		public Criteria andAppealTimeEqualTo(Date value) {
			addCriterion("appeal_time =", value, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeNotEqualTo(Date value) {
			addCriterion("appeal_time <>", value, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeGreaterThan(Date value) {
			addCriterion("appeal_time >", value, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("appeal_time >=", value, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeLessThan(Date value) {
			addCriterion("appeal_time <", value, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeLessThanOrEqualTo(Date value) {
			addCriterion("appeal_time <=", value, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeIn(List<Date> values) {
			addCriterion("appeal_time in", values, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeNotIn(List<Date> values) {
			addCriterion("appeal_time not in", values, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeBetween(Date value1, Date value2) {
			addCriterion("appeal_time between", value1, value2, "appealTime");
			return (Criteria) this;
		}

		public Criteria andAppealTimeNotBetween(Date value1, Date value2) {
			addCriterion("appeal_time not between", value1, value2, "appealTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeIsNull() {
			addCriterion("handle_time is null");
			return (Criteria) this;
		}

		public Criteria andHandleTimeIsNotNull() {
			addCriterion("handle_time is not null");
			return (Criteria) this;
		}

		public Criteria andHandleTimeEqualTo(Date value) {
			addCriterion("handle_time =", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeNotEqualTo(Date value) {
			addCriterion("handle_time <>", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeGreaterThan(Date value) {
			addCriterion("handle_time >", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("handle_time >=", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeLessThan(Date value) {
			addCriterion("handle_time <", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
			addCriterion("handle_time <=", value, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeIn(List<Date> values) {
			addCriterion("handle_time in", values, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeNotIn(List<Date> values) {
			addCriterion("handle_time not in", values, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeBetween(Date value1, Date value2) {
			addCriterion("handle_time between", value1, value2, "handleTime");
			return (Criteria) this;
		}

		public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
			addCriterion("handle_time not between", value1, value2, "handleTime");
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

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andCsIdIsNull() {
			addCriterion("cs_id is null");
			return (Criteria) this;
		}

		public Criteria andCsIdIsNotNull() {
			addCriterion("cs_id is not null");
			return (Criteria) this;
		}

		public Criteria andCsIdEqualTo(Long value) {
			addCriterion("cs_id =", value, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdNotEqualTo(Long value) {
			addCriterion("cs_id <>", value, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdGreaterThan(Long value) {
			addCriterion("cs_id >", value, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cs_id >=", value, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdLessThan(Long value) {
			addCriterion("cs_id <", value, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdLessThanOrEqualTo(Long value) {
			addCriterion("cs_id <=", value, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdIn(List<Long> values) {
			addCriterion("cs_id in", values, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdNotIn(List<Long> values) {
			addCriterion("cs_id not in", values, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdBetween(Long value1, Long value2) {
			addCriterion("cs_id between", value1, value2, "csId");
			return (Criteria) this;
		}

		public Criteria andCsIdNotBetween(Long value1, Long value2) {
			addCriterion("cs_id not between", value1, value2, "csId");
			return (Criteria) this;
		}

		public Criteria andFromAcc1IsNull() {
			addCriterion("from_acc1 is null");
			return (Criteria) this;
		}

		public Criteria andFromAcc1IsNotNull() {
			addCriterion("from_acc1 is not null");
			return (Criteria) this;
		}

		public Criteria andFromAcc1EqualTo(String value) {
			addCriterion("from_acc1 =", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1NotEqualTo(String value) {
			addCriterion("from_acc1 <>", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1GreaterThan(String value) {
			addCriterion("from_acc1 >", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1GreaterThanOrEqualTo(String value) {
			addCriterion("from_acc1 >=", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1LessThan(String value) {
			addCriterion("from_acc1 <", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1LessThanOrEqualTo(String value) {
			addCriterion("from_acc1 <=", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1Like(String value) {
			addCriterion("from_acc1 like", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1NotLike(String value) {
			addCriterion("from_acc1 not like", value, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1In(List<String> values) {
			addCriterion("from_acc1 in", values, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1NotIn(List<String> values) {
			addCriterion("from_acc1 not in", values, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1Between(String value1, String value2) {
			addCriterion("from_acc1 between", value1, value2, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc1NotBetween(String value1, String value2) {
			addCriterion("from_acc1 not between", value1, value2, "fromAcc1");
			return (Criteria) this;
		}

		public Criteria andFromAcc2IsNull() {
			addCriterion("from_acc2 is null");
			return (Criteria) this;
		}

		public Criteria andFromAcc2IsNotNull() {
			addCriterion("from_acc2 is not null");
			return (Criteria) this;
		}

		public Criteria andFromAcc2EqualTo(String value) {
			addCriterion("from_acc2 =", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2NotEqualTo(String value) {
			addCriterion("from_acc2 <>", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2GreaterThan(String value) {
			addCriterion("from_acc2 >", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2GreaterThanOrEqualTo(String value) {
			addCriterion("from_acc2 >=", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2LessThan(String value) {
			addCriterion("from_acc2 <", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2LessThanOrEqualTo(String value) {
			addCriterion("from_acc2 <=", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2Like(String value) {
			addCriterion("from_acc2 like", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2NotLike(String value) {
			addCriterion("from_acc2 not like", value, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2In(List<String> values) {
			addCriterion("from_acc2 in", values, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2NotIn(List<String> values) {
			addCriterion("from_acc2 not in", values, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2Between(String value1, String value2) {
			addCriterion("from_acc2 between", value1, value2, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc2NotBetween(String value1, String value2) {
			addCriterion("from_acc2 not between", value1, value2, "fromAcc2");
			return (Criteria) this;
		}

		public Criteria andFromAcc3IsNull() {
			addCriterion("from_acc3 is null");
			return (Criteria) this;
		}

		public Criteria andFromAcc3IsNotNull() {
			addCriterion("from_acc3 is not null");
			return (Criteria) this;
		}

		public Criteria andFromAcc3EqualTo(String value) {
			addCriterion("from_acc3 =", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3NotEqualTo(String value) {
			addCriterion("from_acc3 <>", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3GreaterThan(String value) {
			addCriterion("from_acc3 >", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3GreaterThanOrEqualTo(String value) {
			addCriterion("from_acc3 >=", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3LessThan(String value) {
			addCriterion("from_acc3 <", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3LessThanOrEqualTo(String value) {
			addCriterion("from_acc3 <=", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3Like(String value) {
			addCriterion("from_acc3 like", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3NotLike(String value) {
			addCriterion("from_acc3 not like", value, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3In(List<String> values) {
			addCriterion("from_acc3 in", values, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3NotIn(List<String> values) {
			addCriterion("from_acc3 not in", values, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3Between(String value1, String value2) {
			addCriterion("from_acc3 between", value1, value2, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromAcc3NotBetween(String value1, String value2) {
			addCriterion("from_acc3 not between", value1, value2, "fromAcc3");
			return (Criteria) this;
		}

		public Criteria andFromUserIdIsNull() {
			addCriterion("from_user_id is null");
			return (Criteria) this;
		}

		public Criteria andFromUserIdIsNotNull() {
			addCriterion("from_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andFromUserIdEqualTo(Long value) {
			addCriterion("from_user_id =", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdNotEqualTo(Long value) {
			addCriterion("from_user_id <>", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdGreaterThan(Long value) {
			addCriterion("from_user_id >", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("from_user_id >=", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdLessThan(Long value) {
			addCriterion("from_user_id <", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdLessThanOrEqualTo(Long value) {
			addCriterion("from_user_id <=", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdIn(List<Long> values) {
			addCriterion("from_user_id in", values, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdNotIn(List<Long> values) {
			addCriterion("from_user_id not in", values, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdBetween(Long value1, Long value2) {
			addCriterion("from_user_id between", value1, value2, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdNotBetween(Long value1, Long value2) {
			addCriterion("from_user_id not between", value1, value2, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdIsNull() {
			addCriterion("handle_user_id is null");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdIsNotNull() {
			addCriterion("handle_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdEqualTo(Long value) {
			addCriterion("handle_user_id =", value, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdNotEqualTo(Long value) {
			addCriterion("handle_user_id <>", value, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdGreaterThan(Long value) {
			addCriterion("handle_user_id >", value, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("handle_user_id >=", value, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdLessThan(Long value) {
			addCriterion("handle_user_id <", value, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdLessThanOrEqualTo(Long value) {
			addCriterion("handle_user_id <=", value, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdIn(List<Long> values) {
			addCriterion("handle_user_id in", values, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdNotIn(List<Long> values) {
			addCriterion("handle_user_id not in", values, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdBetween(Long value1, Long value2) {
			addCriterion("handle_user_id between", value1, value2, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andHandleUserIdNotBetween(Long value1, Long value2) {
			addCriterion("handle_user_id not between", value1, value2, "handleUserId");
			return (Criteria) this;
		}

		public Criteria andOfIdIsNull() {
			addCriterion("of_id is null");
			return (Criteria) this;
		}

		public Criteria andOfIdIsNotNull() {
			addCriterion("of_id is not null");
			return (Criteria) this;
		}

		public Criteria andOfIdEqualTo(Long value) {
			addCriterion("of_id =", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotEqualTo(Long value) {
			addCriterion("of_id <>", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdGreaterThan(Long value) {
			addCriterion("of_id >", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdGreaterThanOrEqualTo(Long value) {
			addCriterion("of_id >=", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdLessThan(Long value) {
			addCriterion("of_id <", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdLessThanOrEqualTo(Long value) {
			addCriterion("of_id <=", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdIn(List<Long> values) {
			addCriterion("of_id in", values, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotIn(List<Long> values) {
			addCriterion("of_id not in", values, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdBetween(Long value1, Long value2) {
			addCriterion("of_id between", value1, value2, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotBetween(Long value1, Long value2) {
			addCriterion("of_id not between", value1, value2, "ofId");
			return (Criteria) this;
		}

		public Criteria andToAcc1IsNull() {
			addCriterion("to_acc1 is null");
			return (Criteria) this;
		}

		public Criteria andToAcc1IsNotNull() {
			addCriterion("to_acc1 is not null");
			return (Criteria) this;
		}

		public Criteria andToAcc1EqualTo(String value) {
			addCriterion("to_acc1 =", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1NotEqualTo(String value) {
			addCriterion("to_acc1 <>", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1GreaterThan(String value) {
			addCriterion("to_acc1 >", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1GreaterThanOrEqualTo(String value) {
			addCriterion("to_acc1 >=", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1LessThan(String value) {
			addCriterion("to_acc1 <", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1LessThanOrEqualTo(String value) {
			addCriterion("to_acc1 <=", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1Like(String value) {
			addCriterion("to_acc1 like", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1NotLike(String value) {
			addCriterion("to_acc1 not like", value, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1In(List<String> values) {
			addCriterion("to_acc1 in", values, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1NotIn(List<String> values) {
			addCriterion("to_acc1 not in", values, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1Between(String value1, String value2) {
			addCriterion("to_acc1 between", value1, value2, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc1NotBetween(String value1, String value2) {
			addCriterion("to_acc1 not between", value1, value2, "toAcc1");
			return (Criteria) this;
		}

		public Criteria andToAcc2IsNull() {
			addCriterion("to_acc2 is null");
			return (Criteria) this;
		}

		public Criteria andToAcc2IsNotNull() {
			addCriterion("to_acc2 is not null");
			return (Criteria) this;
		}

		public Criteria andToAcc2EqualTo(String value) {
			addCriterion("to_acc2 =", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2NotEqualTo(String value) {
			addCriterion("to_acc2 <>", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2GreaterThan(String value) {
			addCriterion("to_acc2 >", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2GreaterThanOrEqualTo(String value) {
			addCriterion("to_acc2 >=", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2LessThan(String value) {
			addCriterion("to_acc2 <", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2LessThanOrEqualTo(String value) {
			addCriterion("to_acc2 <=", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2Like(String value) {
			addCriterion("to_acc2 like", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2NotLike(String value) {
			addCriterion("to_acc2 not like", value, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2In(List<String> values) {
			addCriterion("to_acc2 in", values, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2NotIn(List<String> values) {
			addCriterion("to_acc2 not in", values, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2Between(String value1, String value2) {
			addCriterion("to_acc2 between", value1, value2, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc2NotBetween(String value1, String value2) {
			addCriterion("to_acc2 not between", value1, value2, "toAcc2");
			return (Criteria) this;
		}

		public Criteria andToAcc3IsNull() {
			addCriterion("to_acc3 is null");
			return (Criteria) this;
		}

		public Criteria andToAcc3IsNotNull() {
			addCriterion("to_acc3 is not null");
			return (Criteria) this;
		}

		public Criteria andToAcc3EqualTo(String value) {
			addCriterion("to_acc3 =", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3NotEqualTo(String value) {
			addCriterion("to_acc3 <>", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3GreaterThan(String value) {
			addCriterion("to_acc3 >", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3GreaterThanOrEqualTo(String value) {
			addCriterion("to_acc3 >=", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3LessThan(String value) {
			addCriterion("to_acc3 <", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3LessThanOrEqualTo(String value) {
			addCriterion("to_acc3 <=", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3Like(String value) {
			addCriterion("to_acc3 like", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3NotLike(String value) {
			addCriterion("to_acc3 not like", value, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3In(List<String> values) {
			addCriterion("to_acc3 in", values, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3NotIn(List<String> values) {
			addCriterion("to_acc3 not in", values, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3Between(String value1, String value2) {
			addCriterion("to_acc3 between", value1, value2, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToAcc3NotBetween(String value1, String value2) {
			addCriterion("to_acc3 not between", value1, value2, "toAcc3");
			return (Criteria) this;
		}

		public Criteria andToUserIdIsNull() {
			addCriterion("to_user_id is null");
			return (Criteria) this;
		}

		public Criteria andToUserIdIsNotNull() {
			addCriterion("to_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andToUserIdEqualTo(Long value) {
			addCriterion("to_user_id =", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdNotEqualTo(Long value) {
			addCriterion("to_user_id <>", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdGreaterThan(Long value) {
			addCriterion("to_user_id >", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("to_user_id >=", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdLessThan(Long value) {
			addCriterion("to_user_id <", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdLessThanOrEqualTo(Long value) {
			addCriterion("to_user_id <=", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdIn(List<Long> values) {
			addCriterion("to_user_id in", values, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdNotIn(List<Long> values) {
			addCriterion("to_user_id not in", values, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdBetween(Long value1, Long value2) {
			addCriterion("to_user_id between", value1, value2, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdNotBetween(Long value1, Long value2) {
			addCriterion("to_user_id not between", value1, value2, "toUserId");
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