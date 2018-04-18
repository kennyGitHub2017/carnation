package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RebateTrackExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RebateTrackExample() {
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

		public Criteria andRebateCodeIsNull() {
			addCriterion("rebate_code is null");
			return (Criteria) this;
		}

		public Criteria andRebateCodeIsNotNull() {
			addCriterion("rebate_code is not null");
			return (Criteria) this;
		}

		public Criteria andRebateCodeEqualTo(String value) {
			addCriterion("rebate_code =", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeNotEqualTo(String value) {
			addCriterion("rebate_code <>", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeGreaterThan(String value) {
			addCriterion("rebate_code >", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeGreaterThanOrEqualTo(String value) {
			addCriterion("rebate_code >=", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeLessThan(String value) {
			addCriterion("rebate_code <", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeLessThanOrEqualTo(String value) {
			addCriterion("rebate_code <=", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeLike(String value) {
			addCriterion("rebate_code like", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeNotLike(String value) {
			addCriterion("rebate_code not like", value, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeIn(List<String> values) {
			addCriterion("rebate_code in", values, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeNotIn(List<String> values) {
			addCriterion("rebate_code not in", values, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeBetween(String value1, String value2) {
			addCriterion("rebate_code between", value1, value2, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateCodeNotBetween(String value1, String value2) {
			addCriterion("rebate_code not between", value1, value2, "rebateCode");
			return (Criteria) this;
		}

		public Criteria andRebateTypeIsNull() {
			addCriterion("rebate_type is null");
			return (Criteria) this;
		}

		public Criteria andRebateTypeIsNotNull() {
			addCriterion("rebate_type is not null");
			return (Criteria) this;
		}

		public Criteria andRebateTypeEqualTo(String value) {
			addCriterion("rebate_type =", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotEqualTo(String value) {
			addCriterion("rebate_type <>", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeGreaterThan(String value) {
			addCriterion("rebate_type >", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeGreaterThanOrEqualTo(String value) {
			addCriterion("rebate_type >=", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeLessThan(String value) {
			addCriterion("rebate_type <", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeLessThanOrEqualTo(String value) {
			addCriterion("rebate_type <=", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeLike(String value) {
			addCriterion("rebate_type like", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotLike(String value) {
			addCriterion("rebate_type not like", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeIn(List<String> values) {
			addCriterion("rebate_type in", values, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotIn(List<String> values) {
			addCriterion("rebate_type not in", values, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeBetween(String value1, String value2) {
			addCriterion("rebate_type between", value1, value2, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotBetween(String value1, String value2) {
			addCriterion("rebate_type not between", value1, value2, "rebateType");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdIsNull() {
			addCriterion("seller_user_id is null");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdIsNotNull() {
			addCriterion("seller_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdEqualTo(Long value) {
			addCriterion("seller_user_id =", value, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdNotEqualTo(Long value) {
			addCriterion("seller_user_id <>", value, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdGreaterThan(Long value) {
			addCriterion("seller_user_id >", value, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("seller_user_id >=", value, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdLessThan(Long value) {
			addCriterion("seller_user_id <", value, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdLessThanOrEqualTo(Long value) {
			addCriterion("seller_user_id <=", value, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdIn(List<Long> values) {
			addCriterion("seller_user_id in", values, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdNotIn(List<Long> values) {
			addCriterion("seller_user_id not in", values, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdBetween(Long value1, Long value2) {
			addCriterion("seller_user_id between", value1, value2, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andSellerUserIdNotBetween(Long value1, Long value2) {
			addCriterion("seller_user_id not between", value1, value2, "sellerUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdIsNull() {
			addCriterion("own_operator_user_id is null");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdIsNotNull() {
			addCriterion("own_operator_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdEqualTo(Long value) {
			addCriterion("own_operator_user_id =", value, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdNotEqualTo(Long value) {
			addCriterion("own_operator_user_id <>", value, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdGreaterThan(Long value) {
			addCriterion("own_operator_user_id >", value, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("own_operator_user_id >=", value, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdLessThan(Long value) {
			addCriterion("own_operator_user_id <", value, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdLessThanOrEqualTo(Long value) {
			addCriterion("own_operator_user_id <=", value, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdIn(List<Long> values) {
			addCriterion("own_operator_user_id in", values, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdNotIn(List<Long> values) {
			addCriterion("own_operator_user_id not in", values, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdBetween(Long value1, Long value2) {
			addCriterion("own_operator_user_id between", value1, value2, "ownOperatorUserId");
			return (Criteria) this;
		}

		public Criteria andOwnOperatorUserIdNotBetween(Long value1, Long value2) {
			addCriterion("own_operator_user_id not between", value1, value2, "ownOperatorUserId");
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