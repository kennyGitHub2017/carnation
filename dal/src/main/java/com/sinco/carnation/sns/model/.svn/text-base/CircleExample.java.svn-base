package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CircleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CircleExample() {
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

		public Criteria andAttentionCountIsNull() {
			addCriterion("attention_count is null");
			return (Criteria) this;
		}

		public Criteria andAttentionCountIsNotNull() {
			addCriterion("attention_count is not null");
			return (Criteria) this;
		}

		public Criteria andAttentionCountEqualTo(Integer value) {
			addCriterion("attention_count =", value, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountNotEqualTo(Integer value) {
			addCriterion("attention_count <>", value, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountGreaterThan(Integer value) {
			addCriterion("attention_count >", value, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("attention_count >=", value, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountLessThan(Integer value) {
			addCriterion("attention_count <", value, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountLessThanOrEqualTo(Integer value) {
			addCriterion("attention_count <=", value, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountIn(List<Integer> values) {
			addCriterion("attention_count in", values, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountNotIn(List<Integer> values) {
			addCriterion("attention_count not in", values, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountBetween(Integer value1, Integer value2) {
			addCriterion("attention_count between", value1, value2, "attentionCount");
			return (Criteria) this;
		}

		public Criteria andAttentionCountNotBetween(Integer value1, Integer value2) {
			addCriterion("attention_count not between", value1, value2, "attentionCount");
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

		public Criteria andClassNameIsNull() {
			addCriterion("class_name is null");
			return (Criteria) this;
		}

		public Criteria andClassNameIsNotNull() {
			addCriterion("class_name is not null");
			return (Criteria) this;
		}

		public Criteria andClassNameEqualTo(String value) {
			addCriterion("class_name =", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotEqualTo(String value) {
			addCriterion("class_name <>", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameGreaterThan(String value) {
			addCriterion("class_name >", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameGreaterThanOrEqualTo(String value) {
			addCriterion("class_name >=", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLessThan(String value) {
			addCriterion("class_name <", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLessThanOrEqualTo(String value) {
			addCriterion("class_name <=", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLike(String value) {
			addCriterion("class_name like", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotLike(String value) {
			addCriterion("class_name not like", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameIn(List<String> values) {
			addCriterion("class_name in", values, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotIn(List<String> values) {
			addCriterion("class_name not in", values, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameBetween(String value1, String value2) {
			addCriterion("class_name between", value1, value2, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotBetween(String value1, String value2) {
			addCriterion("class_name not between", value1, value2, "className");
			return (Criteria) this;
		}

		public Criteria andInvitationCountIsNull() {
			addCriterion("invitation_count is null");
			return (Criteria) this;
		}

		public Criteria andInvitationCountIsNotNull() {
			addCriterion("invitation_count is not null");
			return (Criteria) this;
		}

		public Criteria andInvitationCountEqualTo(Integer value) {
			addCriterion("invitation_count =", value, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountNotEqualTo(Integer value) {
			addCriterion("invitation_count <>", value, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountGreaterThan(Integer value) {
			addCriterion("invitation_count >", value, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("invitation_count >=", value, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountLessThan(Integer value) {
			addCriterion("invitation_count <", value, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountLessThanOrEqualTo(Integer value) {
			addCriterion("invitation_count <=", value, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountIn(List<Integer> values) {
			addCriterion("invitation_count in", values, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountNotIn(List<Integer> values) {
			addCriterion("invitation_count not in", values, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountBetween(Integer value1, Integer value2) {
			addCriterion("invitation_count between", value1, value2, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andInvitationCountNotBetween(Integer value1, Integer value2) {
			addCriterion("invitation_count not between", value1, value2, "invitationCount");
			return (Criteria) this;
		}

		public Criteria andRecommendIsNull() {
			addCriterion("recommend is null");
			return (Criteria) this;
		}

		public Criteria andRecommendIsNotNull() {
			addCriterion("recommend is not null");
			return (Criteria) this;
		}

		public Criteria andRecommendEqualTo(Integer value) {
			addCriterion("recommend =", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotEqualTo(Integer value) {
			addCriterion("recommend <>", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendGreaterThan(Integer value) {
			addCriterion("recommend >", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendGreaterThanOrEqualTo(Integer value) {
			addCriterion("recommend >=", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLessThan(Integer value) {
			addCriterion("recommend <", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLessThanOrEqualTo(Integer value) {
			addCriterion("recommend <=", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendIn(List<Integer> values) {
			addCriterion("recommend in", values, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotIn(List<Integer> values) {
			addCriterion("recommend not in", values, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendBetween(Integer value1, Integer value2) {
			addCriterion("recommend between", value1, value2, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotBetween(Integer value1, Integer value2) {
			addCriterion("recommend not between", value1, value2, "recommend");
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

		public Criteria andUserNameIsNull() {
			addCriterion("user_Name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_Name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_Name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_Name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_Name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_Name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_Name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_Name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_Name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_Name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_Name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_Name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_Name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_Name not between", value1, value2, "userName");
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