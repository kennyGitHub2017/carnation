package com.sinco.carnation.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MessageExample() {
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

		public Criteria andMsgCatIsNull() {
			addCriterion("msg_cat is null");
			return (Criteria) this;
		}

		public Criteria andMsgCatIsNotNull() {
			addCriterion("msg_cat is not null");
			return (Criteria) this;
		}

		public Criteria andMsgCatEqualTo(Integer value) {
			addCriterion("msg_cat =", value, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatNotEqualTo(Integer value) {
			addCriterion("msg_cat <>", value, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatGreaterThan(Integer value) {
			addCriterion("msg_cat >", value, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatGreaterThanOrEqualTo(Integer value) {
			addCriterion("msg_cat >=", value, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatLessThan(Integer value) {
			addCriterion("msg_cat <", value, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatLessThanOrEqualTo(Integer value) {
			addCriterion("msg_cat <=", value, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatIn(List<Integer> values) {
			addCriterion("msg_cat in", values, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatNotIn(List<Integer> values) {
			addCriterion("msg_cat not in", values, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatBetween(Integer value1, Integer value2) {
			addCriterion("msg_cat between", value1, value2, "msgCat");
			return (Criteria) this;
		}

		public Criteria andMsgCatNotBetween(Integer value1, Integer value2) {
			addCriterion("msg_cat not between", value1, value2, "msgCat");
			return (Criteria) this;
		}

		public Criteria andReplyStatusIsNull() {
			addCriterion("reply_status is null");
			return (Criteria) this;
		}

		public Criteria andReplyStatusIsNotNull() {
			addCriterion("reply_status is not null");
			return (Criteria) this;
		}

		public Criteria andReplyStatusEqualTo(Integer value) {
			addCriterion("reply_status =", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusNotEqualTo(Integer value) {
			addCriterion("reply_status <>", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusGreaterThan(Integer value) {
			addCriterion("reply_status >", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("reply_status >=", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusLessThan(Integer value) {
			addCriterion("reply_status <", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusLessThanOrEqualTo(Integer value) {
			addCriterion("reply_status <=", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusIn(List<Integer> values) {
			addCriterion("reply_status in", values, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusNotIn(List<Integer> values) {
			addCriterion("reply_status not in", values, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusBetween(Integer value1, Integer value2) {
			addCriterion("reply_status between", value1, value2, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("reply_status not between", value1, value2, "replyStatus");
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
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

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
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

		public Criteria andParentIdIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(Long value) {
			addCriterion("parent_id =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(Long value) {
			addCriterion("parent_id <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(Long value) {
			addCriterion("parent_id >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("parent_id >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(Long value) {
			addCriterion("parent_id <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(Long value) {
			addCriterion("parent_id <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<Long> values) {
			addCriterion("parent_id in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<Long> values) {
			addCriterion("parent_id not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(Long value1, Long value2) {
			addCriterion("parent_id between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(Long value1, Long value2) {
			addCriterion("parent_id not between", value1, value2, "parentId");
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