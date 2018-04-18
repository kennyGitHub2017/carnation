package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefundLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RefundLogExample() {
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

		public Criteria andRefundIsNull() {
			addCriterion("refund is null");
			return (Criteria) this;
		}

		public Criteria andRefundIsNotNull() {
			addCriterion("refund is not null");
			return (Criteria) this;
		}

		public Criteria andRefundEqualTo(BigDecimal value) {
			addCriterion("refund =", value, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundNotEqualTo(BigDecimal value) {
			addCriterion("refund <>", value, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundGreaterThan(BigDecimal value) {
			addCriterion("refund >", value, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("refund >=", value, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundLessThan(BigDecimal value) {
			addCriterion("refund <", value, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundLessThanOrEqualTo(BigDecimal value) {
			addCriterion("refund <=", value, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundIn(List<BigDecimal> values) {
			addCriterion("refund in", values, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundNotIn(List<BigDecimal> values) {
			addCriterion("refund not in", values, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("refund between", value1, value2, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("refund not between", value1, value2, "refund");
			return (Criteria) this;
		}

		public Criteria andRefundIdIsNull() {
			addCriterion("refund_id is null");
			return (Criteria) this;
		}

		public Criteria andRefundIdIsNotNull() {
			addCriterion("refund_id is not null");
			return (Criteria) this;
		}

		public Criteria andRefundIdEqualTo(String value) {
			addCriterion("refund_id =", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdNotEqualTo(String value) {
			addCriterion("refund_id <>", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdGreaterThan(String value) {
			addCriterion("refund_id >", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdGreaterThanOrEqualTo(String value) {
			addCriterion("refund_id >=", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdLessThan(String value) {
			addCriterion("refund_id <", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdLessThanOrEqualTo(String value) {
			addCriterion("refund_id <=", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdLike(String value) {
			addCriterion("refund_id like", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdNotLike(String value) {
			addCriterion("refund_id not like", value, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdIn(List<String> values) {
			addCriterion("refund_id in", values, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdNotIn(List<String> values) {
			addCriterion("refund_id not in", values, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdBetween(String value1, String value2) {
			addCriterion("refund_id between", value1, value2, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundIdNotBetween(String value1, String value2) {
			addCriterion("refund_id not between", value1, value2, "refundId");
			return (Criteria) this;
		}

		public Criteria andRefundLogIsNull() {
			addCriterion("refund_log is null");
			return (Criteria) this;
		}

		public Criteria andRefundLogIsNotNull() {
			addCriterion("refund_log is not null");
			return (Criteria) this;
		}

		public Criteria andRefundLogEqualTo(String value) {
			addCriterion("refund_log =", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogNotEqualTo(String value) {
			addCriterion("refund_log <>", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogGreaterThan(String value) {
			addCriterion("refund_log >", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogGreaterThanOrEqualTo(String value) {
			addCriterion("refund_log >=", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogLessThan(String value) {
			addCriterion("refund_log <", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogLessThanOrEqualTo(String value) {
			addCriterion("refund_log <=", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogLike(String value) {
			addCriterion("refund_log like", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogNotLike(String value) {
			addCriterion("refund_log not like", value, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogIn(List<String> values) {
			addCriterion("refund_log in", values, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogNotIn(List<String> values) {
			addCriterion("refund_log not in", values, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogBetween(String value1, String value2) {
			addCriterion("refund_log between", value1, value2, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundLogNotBetween(String value1, String value2) {
			addCriterion("refund_log not between", value1, value2, "refundLog");
			return (Criteria) this;
		}

		public Criteria andRefundTypeIsNull() {
			addCriterion("refund_type is null");
			return (Criteria) this;
		}

		public Criteria andRefundTypeIsNotNull() {
			addCriterion("refund_type is not null");
			return (Criteria) this;
		}

		public Criteria andRefundTypeEqualTo(String value) {
			addCriterion("refund_type =", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeNotEqualTo(String value) {
			addCriterion("refund_type <>", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeGreaterThan(String value) {
			addCriterion("refund_type >", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeGreaterThanOrEqualTo(String value) {
			addCriterion("refund_type >=", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeLessThan(String value) {
			addCriterion("refund_type <", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeLessThanOrEqualTo(String value) {
			addCriterion("refund_type <=", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeLike(String value) {
			addCriterion("refund_type like", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeNotLike(String value) {
			addCriterion("refund_type not like", value, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeIn(List<String> values) {
			addCriterion("refund_type in", values, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeNotIn(List<String> values) {
			addCriterion("refund_type not in", values, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeBetween(String value1, String value2) {
			addCriterion("refund_type between", value1, value2, "refundType");
			return (Criteria) this;
		}

		public Criteria andRefundTypeNotBetween(String value1, String value2) {
			addCriterion("refund_type not between", value1, value2, "refundType");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdIsNull() {
			addCriterion("return_log_id is null");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdIsNotNull() {
			addCriterion("return_log_id is not null");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdEqualTo(Long value) {
			addCriterion("return_log_id =", value, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdNotEqualTo(Long value) {
			addCriterion("return_log_id <>", value, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdGreaterThan(Long value) {
			addCriterion("return_log_id >", value, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdGreaterThanOrEqualTo(Long value) {
			addCriterion("return_log_id >=", value, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdLessThan(Long value) {
			addCriterion("return_log_id <", value, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdLessThanOrEqualTo(Long value) {
			addCriterion("return_log_id <=", value, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdIn(List<Long> values) {
			addCriterion("return_log_id in", values, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdNotIn(List<Long> values) {
			addCriterion("return_log_id not in", values, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdBetween(Long value1, Long value2) {
			addCriterion("return_log_id between", value1, value2, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogIdNotBetween(Long value1, Long value2) {
			addCriterion("return_log_id not between", value1, value2, "returnLogId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdIsNull() {
			addCriterion("return_log_user_id is null");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdIsNotNull() {
			addCriterion("return_log_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdEqualTo(Long value) {
			addCriterion("return_log_user_id =", value, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdNotEqualTo(Long value) {
			addCriterion("return_log_user_id <>", value, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdGreaterThan(Long value) {
			addCriterion("return_log_user_id >", value, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("return_log_user_id >=", value, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdLessThan(Long value) {
			addCriterion("return_log_user_id <", value, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdLessThanOrEqualTo(Long value) {
			addCriterion("return_log_user_id <=", value, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdIn(List<Long> values) {
			addCriterion("return_log_user_id in", values, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdNotIn(List<Long> values) {
			addCriterion("return_log_user_id not in", values, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdBetween(Long value1, Long value2) {
			addCriterion("return_log_user_id between", value1, value2, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserIdNotBetween(Long value1, Long value2) {
			addCriterion("return_log_user_id not between", value1, value2, "returnLogUserId");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameIsNull() {
			addCriterion("return_log_user_name is null");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameIsNotNull() {
			addCriterion("return_log_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameEqualTo(String value) {
			addCriterion("return_log_user_name =", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameNotEqualTo(String value) {
			addCriterion("return_log_user_name <>", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameGreaterThan(String value) {
			addCriterion("return_log_user_name >", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("return_log_user_name >=", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameLessThan(String value) {
			addCriterion("return_log_user_name <", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameLessThanOrEqualTo(String value) {
			addCriterion("return_log_user_name <=", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameLike(String value) {
			addCriterion("return_log_user_name like", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameNotLike(String value) {
			addCriterion("return_log_user_name not like", value, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameIn(List<String> values) {
			addCriterion("return_log_user_name in", values, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameNotIn(List<String> values) {
			addCriterion("return_log_user_name not in", values, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameBetween(String value1, String value2) {
			addCriterion("return_log_user_name between", value1, value2, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnLogUserNameNotBetween(String value1, String value2) {
			addCriterion("return_log_user_name not between", value1, value2, "returnLogUserName");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIsNull() {
			addCriterion("return_service_id is null");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIsNotNull() {
			addCriterion("return_service_id is not null");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdEqualTo(String value) {
			addCriterion("return_service_id =", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotEqualTo(String value) {
			addCriterion("return_service_id <>", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdGreaterThan(String value) {
			addCriterion("return_service_id >", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdGreaterThanOrEqualTo(String value) {
			addCriterion("return_service_id >=", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLessThan(String value) {
			addCriterion("return_service_id <", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLessThanOrEqualTo(String value) {
			addCriterion("return_service_id <=", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLike(String value) {
			addCriterion("return_service_id like", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotLike(String value) {
			addCriterion("return_service_id not like", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIn(List<String> values) {
			addCriterion("return_service_id in", values, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotIn(List<String> values) {
			addCriterion("return_service_id not in", values, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdBetween(String value1, String value2) {
			addCriterion("return_service_id between", value1, value2, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotBetween(String value1, String value2) {
			addCriterion("return_service_id not between", value1, value2, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdIsNull() {
			addCriterion("refund_user_id is null");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdIsNotNull() {
			addCriterion("refund_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdEqualTo(Long value) {
			addCriterion("refund_user_id =", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdNotEqualTo(Long value) {
			addCriterion("refund_user_id <>", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdGreaterThan(Long value) {
			addCriterion("refund_user_id >", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("refund_user_id >=", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdLessThan(Long value) {
			addCriterion("refund_user_id <", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdLessThanOrEqualTo(Long value) {
			addCriterion("refund_user_id <=", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdIn(List<Long> values) {
			addCriterion("refund_user_id in", values, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdNotIn(List<Long> values) {
			addCriterion("refund_user_id not in", values, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdBetween(Long value1, Long value2) {
			addCriterion("refund_user_id between", value1, value2, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdNotBetween(Long value1, Long value2) {
			addCriterion("refund_user_id not between", value1, value2, "refundUserId");
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