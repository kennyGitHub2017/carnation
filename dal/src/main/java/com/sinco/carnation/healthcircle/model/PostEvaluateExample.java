package com.sinco.carnation.healthcircle.model;

import com.sinco.carnation.healthcircle.bo.PostEvaluateBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostEvaluateExample extends AbstractExample<PostEvaluateBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public PostEvaluateExample() {
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

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public void setLimit(int count) {
		this.limit = String.valueOf(count);
	}

	public void setLimit(int offset, int rows) {
		this.limit = new StringBuilder().append(String.valueOf(offset)).append(",")
				.append(String.valueOf(rows)).toString();
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

		public Criteria andPostIdIsNull() {
			addCriterion("post_id is null");
			return (Criteria) this;
		}

		public Criteria andPostIdIsNotNull() {
			addCriterion("post_id is not null");
			return (Criteria) this;
		}

		public Criteria andPostIdEqualTo(Long value) {
			addCriterion("post_id =", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotEqualTo(Long value) {
			addCriterion("post_id <>", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdGreaterThan(Long value) {
			addCriterion("post_id >", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdGreaterThanOrEqualTo(Long value) {
			addCriterion("post_id >=", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLessThan(Long value) {
			addCriterion("post_id <", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdLessThanOrEqualTo(Long value) {
			addCriterion("post_id <=", value, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdIn(List<Long> values) {
			addCriterion("post_id in", values, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotIn(List<Long> values) {
			addCriterion("post_id not in", values, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdBetween(Long value1, Long value2) {
			addCriterion("post_id between", value1, value2, "postId");
			return (Criteria) this;
		}

		public Criteria andPostIdNotBetween(Long value1, Long value2) {
			addCriterion("post_id not between", value1, value2, "postId");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
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

		public Criteria andToUseridIsNull() {
			addCriterion("to_userid is null");
			return (Criteria) this;
		}

		public Criteria andToUseridIsNotNull() {
			addCriterion("to_userid is not null");
			return (Criteria) this;
		}

		public Criteria andToUseridEqualTo(Long value) {
			addCriterion("to_userid =", value, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridNotEqualTo(Long value) {
			addCriterion("to_userid <>", value, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridGreaterThan(Long value) {
			addCriterion("to_userid >", value, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridGreaterThanOrEqualTo(Long value) {
			addCriterion("to_userid >=", value, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridLessThan(Long value) {
			addCriterion("to_userid <", value, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridLessThanOrEqualTo(Long value) {
			addCriterion("to_userid <=", value, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridIn(List<Long> values) {
			addCriterion("to_userid in", values, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridNotIn(List<Long> values) {
			addCriterion("to_userid not in", values, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridBetween(Long value1, Long value2) {
			addCriterion("to_userid between", value1, value2, "toUserid");
			return (Criteria) this;
		}

		public Criteria andToUseridNotBetween(Long value1, Long value2) {
			addCriterion("to_userid not between", value1, value2, "toUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridIsNull() {
			addCriterion("from_userid is null");
			return (Criteria) this;
		}

		public Criteria andFromUseridIsNotNull() {
			addCriterion("from_userid is not null");
			return (Criteria) this;
		}

		public Criteria andFromUseridEqualTo(Long value) {
			addCriterion("from_userid =", value, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridNotEqualTo(Long value) {
			addCriterion("from_userid <>", value, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridGreaterThan(Long value) {
			addCriterion("from_userid >", value, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridGreaterThanOrEqualTo(Long value) {
			addCriterion("from_userid >=", value, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridLessThan(Long value) {
			addCriterion("from_userid <", value, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridLessThanOrEqualTo(Long value) {
			addCriterion("from_userid <=", value, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridIn(List<Long> values) {
			addCriterion("from_userid in", values, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridNotIn(List<Long> values) {
			addCriterion("from_userid not in", values, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridBetween(Long value1, Long value2) {
			addCriterion("from_userid between", value1, value2, "fromUserid");
			return (Criteria) this;
		}

		public Criteria andFromUseridNotBetween(Long value1, Long value2) {
			addCriterion("from_userid not between", value1, value2, "fromUserid");
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