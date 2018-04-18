package com.sinco.carnation.notice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeMessageExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public NoticeMessageExample() {
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Long value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Long value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Long value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Long value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Long value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Long value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Long> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Long> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Long value1, Long value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Long value1, Long value2) {
			addCriterion("uid not between", value1, value2, "uid");
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

		public Criteria andNoticeMessageIsNull() {
			addCriterion("notice_message is null");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageIsNotNull() {
			addCriterion("notice_message is not null");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageEqualTo(String value) {
			addCriterion("notice_message =", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageNotEqualTo(String value) {
			addCriterion("notice_message <>", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageGreaterThan(String value) {
			addCriterion("notice_message >", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageGreaterThanOrEqualTo(String value) {
			addCriterion("notice_message >=", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageLessThan(String value) {
			addCriterion("notice_message <", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageLessThanOrEqualTo(String value) {
			addCriterion("notice_message <=", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageLike(String value) {
			addCriterion("notice_message like", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageNotLike(String value) {
			addCriterion("notice_message not like", value, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageIn(List<String> values) {
			addCriterion("notice_message in", values, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageNotIn(List<String> values) {
			addCriterion("notice_message not in", values, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageBetween(String value1, String value2) {
			addCriterion("notice_message between", value1, value2, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeMessageNotBetween(String value1, String value2) {
			addCriterion("notice_message not between", value1, value2, "noticeMessage");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeIsNull() {
			addCriterion("notice_type is null");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeIsNotNull() {
			addCriterion("notice_type is not null");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeEqualTo(Integer value) {
			addCriterion("notice_type =", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeNotEqualTo(Integer value) {
			addCriterion("notice_type <>", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeGreaterThan(Integer value) {
			addCriterion("notice_type >", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("notice_type >=", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeLessThan(Integer value) {
			addCriterion("notice_type <", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeLessThanOrEqualTo(Integer value) {
			addCriterion("notice_type <=", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeIn(List<Integer> values) {
			addCriterion("notice_type in", values, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeNotIn(List<Integer> values) {
			addCriterion("notice_type not in", values, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeBetween(Integer value1, Integer value2) {
			addCriterion("notice_type between", value1, value2, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("notice_type not between", value1, value2, "noticeType");
			return (Criteria) this;
		}

		public Criteria andPushStatusIsNull() {
			addCriterion("push_status is null");
			return (Criteria) this;
		}

		public Criteria andPushStatusIsNotNull() {
			addCriterion("push_status is not null");
			return (Criteria) this;
		}

		public Criteria andPushStatusEqualTo(Integer value) {
			addCriterion("push_status =", value, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusNotEqualTo(Integer value) {
			addCriterion("push_status <>", value, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusGreaterThan(Integer value) {
			addCriterion("push_status >", value, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("push_status >=", value, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusLessThan(Integer value) {
			addCriterion("push_status <", value, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusLessThanOrEqualTo(Integer value) {
			addCriterion("push_status <=", value, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusIn(List<Integer> values) {
			addCriterion("push_status in", values, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusNotIn(List<Integer> values) {
			addCriterion("push_status not in", values, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusBetween(Integer value1, Integer value2) {
			addCriterion("push_status between", value1, value2, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andPushStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("push_status not between", value1, value2, "pushStatus");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountIsNull() {
			addCriterion("notcie_log_amount is null");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountIsNotNull() {
			addCriterion("notcie_log_amount is not null");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountEqualTo(BigDecimal value) {
			addCriterion("notcie_log_amount =", value, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountNotEqualTo(BigDecimal value) {
			addCriterion("notcie_log_amount <>", value, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountGreaterThan(BigDecimal value) {
			addCriterion("notcie_log_amount >", value, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("notcie_log_amount >=", value, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountLessThan(BigDecimal value) {
			addCriterion("notcie_log_amount <", value, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("notcie_log_amount <=", value, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountIn(List<BigDecimal> values) {
			addCriterion("notcie_log_amount in", values, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountNotIn(List<BigDecimal> values) {
			addCriterion("notcie_log_amount not in", values, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("notcie_log_amount between", value1, value2, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andNotcieLogAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("notcie_log_amount not between", value1, value2, "notcieLogAmount");
			return (Criteria) this;
		}

		public Criteria andRelateIdIsNull() {
			addCriterion("relate_id is null");
			return (Criteria) this;
		}

		public Criteria andRelateIdIsNotNull() {
			addCriterion("relate_id is not null");
			return (Criteria) this;
		}

		public Criteria andRelateIdEqualTo(Long value) {
			addCriterion("relate_id =", value, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdNotEqualTo(Long value) {
			addCriterion("relate_id <>", value, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdGreaterThan(Long value) {
			addCriterion("relate_id >", value, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdGreaterThanOrEqualTo(Long value) {
			addCriterion("relate_id >=", value, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdLessThan(Long value) {
			addCriterion("relate_id <", value, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdLessThanOrEqualTo(Long value) {
			addCriterion("relate_id <=", value, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdIn(List<Long> values) {
			addCriterion("relate_id in", values, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdNotIn(List<Long> values) {
			addCriterion("relate_id not in", values, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdBetween(Long value1, Long value2) {
			addCriterion("relate_id between", value1, value2, "relateId");
			return (Criteria) this;
		}

		public Criteria andRelateIdNotBetween(Long value1, Long value2) {
			addCriterion("relate_id not between", value1, value2, "relateId");
			return (Criteria) this;
		}

		public Criteria andPushtoallIsNull() {
			addCriterion("pushToAll is null");
			return (Criteria) this;
		}

		public Criteria andPushtoallIsNotNull() {
			addCriterion("pushToAll is not null");
			return (Criteria) this;
		}

		public Criteria andPushtoallEqualTo(Integer value) {
			addCriterion("pushToAll =", value, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallNotEqualTo(Integer value) {
			addCriterion("pushToAll <>", value, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallGreaterThan(Integer value) {
			addCriterion("pushToAll >", value, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallGreaterThanOrEqualTo(Integer value) {
			addCriterion("pushToAll >=", value, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallLessThan(Integer value) {
			addCriterion("pushToAll <", value, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallLessThanOrEqualTo(Integer value) {
			addCriterion("pushToAll <=", value, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallIn(List<Integer> values) {
			addCriterion("pushToAll in", values, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallNotIn(List<Integer> values) {
			addCriterion("pushToAll not in", values, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallBetween(Integer value1, Integer value2) {
			addCriterion("pushToAll between", value1, value2, "pushtoall");
			return (Criteria) this;
		}

		public Criteria andPushtoallNotBetween(Integer value1, Integer value2) {
			addCriterion("pushToAll not between", value1, value2, "pushtoall");
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