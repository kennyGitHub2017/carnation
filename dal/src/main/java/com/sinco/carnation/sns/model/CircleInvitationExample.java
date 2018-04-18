package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CircleInvitationExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CircleInvitationExample() {
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
			addCriterion("add_Time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_Time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_Time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_Time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_Time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_Time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_Time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_Time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_Time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_Time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_Time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_Time not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNull() {
			addCriterion("delete_Status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_Status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Integer value) {
			addCriterion("delete_Status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Integer value) {
			addCriterion("delete_Status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Integer value) {
			addCriterion("delete_Status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_Status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Integer value) {
			addCriterion("delete_Status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_Status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Integer> values) {
			addCriterion("delete_Status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Integer> values) {
			addCriterion("delete_Status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
			addCriterion("delete_Status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_Status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andCircleIdIsNull() {
			addCriterion("circle_id is null");
			return (Criteria) this;
		}

		public Criteria andCircleIdIsNotNull() {
			addCriterion("circle_id is not null");
			return (Criteria) this;
		}

		public Criteria andCircleIdEqualTo(Long value) {
			addCriterion("circle_id =", value, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdNotEqualTo(Long value) {
			addCriterion("circle_id <>", value, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdGreaterThan(Long value) {
			addCriterion("circle_id >", value, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdGreaterThanOrEqualTo(Long value) {
			addCriterion("circle_id >=", value, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdLessThan(Long value) {
			addCriterion("circle_id <", value, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdLessThanOrEqualTo(Long value) {
			addCriterion("circle_id <=", value, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdIn(List<Long> values) {
			addCriterion("circle_id in", values, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdNotIn(List<Long> values) {
			addCriterion("circle_id not in", values, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdBetween(Long value1, Long value2) {
			addCriterion("circle_id between", value1, value2, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleIdNotBetween(Long value1, Long value2) {
			addCriterion("circle_id not between", value1, value2, "circleId");
			return (Criteria) this;
		}

		public Criteria andCircleNameIsNull() {
			addCriterion("circle_name is null");
			return (Criteria) this;
		}

		public Criteria andCircleNameIsNotNull() {
			addCriterion("circle_name is not null");
			return (Criteria) this;
		}

		public Criteria andCircleNameEqualTo(String value) {
			addCriterion("circle_name =", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameNotEqualTo(String value) {
			addCriterion("circle_name <>", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameGreaterThan(String value) {
			addCriterion("circle_name >", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameGreaterThanOrEqualTo(String value) {
			addCriterion("circle_name >=", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameLessThan(String value) {
			addCriterion("circle_name <", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameLessThanOrEqualTo(String value) {
			addCriterion("circle_name <=", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameLike(String value) {
			addCriterion("circle_name like", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameNotLike(String value) {
			addCriterion("circle_name not like", value, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameIn(List<String> values) {
			addCriterion("circle_name in", values, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameNotIn(List<String> values) {
			addCriterion("circle_name not in", values, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameBetween(String value1, String value2) {
			addCriterion("circle_name between", value1, value2, "circleName");
			return (Criteria) this;
		}

		public Criteria andCircleNameNotBetween(String value1, String value2) {
			addCriterion("circle_name not between", value1, value2, "circleName");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectIsNull() {
			addCriterion("invitaion_perfect is null");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectIsNotNull() {
			addCriterion("invitaion_perfect is not null");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectEqualTo(Integer value) {
			addCriterion("invitaion_perfect =", value, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectNotEqualTo(Integer value) {
			addCriterion("invitaion_perfect <>", value, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectGreaterThan(Integer value) {
			addCriterion("invitaion_perfect >", value, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectGreaterThanOrEqualTo(Integer value) {
			addCriterion("invitaion_perfect >=", value, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectLessThan(Integer value) {
			addCriterion("invitaion_perfect <", value, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectLessThanOrEqualTo(Integer value) {
			addCriterion("invitaion_perfect <=", value, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectIn(List<Integer> values) {
			addCriterion("invitaion_perfect in", values, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectNotIn(List<Integer> values) {
			addCriterion("invitaion_perfect not in", values, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectBetween(Integer value1, Integer value2) {
			addCriterion("invitaion_perfect between", value1, value2, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionPerfectNotBetween(Integer value1, Integer value2) {
			addCriterion("invitaion_perfect not between", value1, value2, "invitaionPerfect");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopIsNull() {
			addCriterion("invitaion_top is null");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopIsNotNull() {
			addCriterion("invitaion_top is not null");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopEqualTo(Integer value) {
			addCriterion("invitaion_top =", value, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopNotEqualTo(Integer value) {
			addCriterion("invitaion_top <>", value, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopGreaterThan(Integer value) {
			addCriterion("invitaion_top >", value, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopGreaterThanOrEqualTo(Integer value) {
			addCriterion("invitaion_top >=", value, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopLessThan(Integer value) {
			addCriterion("invitaion_top <", value, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopLessThanOrEqualTo(Integer value) {
			addCriterion("invitaion_top <=", value, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopIn(List<Integer> values) {
			addCriterion("invitaion_top in", values, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopNotIn(List<Integer> values) {
			addCriterion("invitaion_top not in", values, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopBetween(Integer value1, Integer value2) {
			addCriterion("invitaion_top between", value1, value2, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andInvitaionTopNotBetween(Integer value1, Integer value2) {
			addCriterion("invitaion_top not between", value1, value2, "invitaionTop");
			return (Criteria) this;
		}

		public Criteria andPraiseCountIsNull() {
			addCriterion("praise_count is null");
			return (Criteria) this;
		}

		public Criteria andPraiseCountIsNotNull() {
			addCriterion("praise_count is not null");
			return (Criteria) this;
		}

		public Criteria andPraiseCountEqualTo(Integer value) {
			addCriterion("praise_count =", value, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountNotEqualTo(Integer value) {
			addCriterion("praise_count <>", value, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountGreaterThan(Integer value) {
			addCriterion("praise_count >", value, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("praise_count >=", value, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountLessThan(Integer value) {
			addCriterion("praise_count <", value, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountLessThanOrEqualTo(Integer value) {
			addCriterion("praise_count <=", value, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountIn(List<Integer> values) {
			addCriterion("praise_count in", values, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountNotIn(List<Integer> values) {
			addCriterion("praise_count not in", values, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountBetween(Integer value1, Integer value2) {
			addCriterion("praise_count between", value1, value2, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andPraiseCountNotBetween(Integer value1, Integer value2) {
			addCriterion("praise_count not between", value1, value2, "praiseCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountIsNull() {
			addCriterion("reply_count is null");
			return (Criteria) this;
		}

		public Criteria andReplyCountIsNotNull() {
			addCriterion("reply_count is not null");
			return (Criteria) this;
		}

		public Criteria andReplyCountEqualTo(Integer value) {
			addCriterion("reply_count =", value, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountNotEqualTo(Integer value) {
			addCriterion("reply_count <>", value, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountGreaterThan(Integer value) {
			addCriterion("reply_count >", value, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("reply_count >=", value, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountLessThan(Integer value) {
			addCriterion("reply_count <", value, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
			addCriterion("reply_count <=", value, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountIn(List<Integer> values) {
			addCriterion("reply_count in", values, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountNotIn(List<Integer> values) {
			addCriterion("reply_count not in", values, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountBetween(Integer value1, Integer value2) {
			addCriterion("reply_count between", value1, value2, "replyCount");
			return (Criteria) this;
		}

		public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("reply_count not between", value1, value2, "replyCount");
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

		public Criteria andCircleTypeIsNull() {
			addCriterion("circle_type is null");
			return (Criteria) this;
		}

		public Criteria andCircleTypeIsNotNull() {
			addCriterion("circle_type is not null");
			return (Criteria) this;
		}

		public Criteria andCircleTypeEqualTo(Integer value) {
			addCriterion("circle_type =", value, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeNotEqualTo(Integer value) {
			addCriterion("circle_type <>", value, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeGreaterThan(Integer value) {
			addCriterion("circle_type >", value, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("circle_type >=", value, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeLessThan(Integer value) {
			addCriterion("circle_type <", value, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeLessThanOrEqualTo(Integer value) {
			addCriterion("circle_type <=", value, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeIn(List<Integer> values) {
			addCriterion("circle_type in", values, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeNotIn(List<Integer> values) {
			addCriterion("circle_type not in", values, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeBetween(Integer value1, Integer value2) {
			addCriterion("circle_type between", value1, value2, "circleType");
			return (Criteria) this;
		}

		public Criteria andCircleTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("circle_type not between", value1, value2, "circleType");
			return (Criteria) this;
		}

		public Criteria andReplyNameIsNull() {
			addCriterion("reply_name is null");
			return (Criteria) this;
		}

		public Criteria andReplyNameIsNotNull() {
			addCriterion("reply_name is not null");
			return (Criteria) this;
		}

		public Criteria andReplyNameEqualTo(Integer value) {
			addCriterion("reply_name =", value, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameNotEqualTo(Integer value) {
			addCriterion("reply_name <>", value, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameGreaterThan(Integer value) {
			addCriterion("reply_name >", value, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameGreaterThanOrEqualTo(Integer value) {
			addCriterion("reply_name >=", value, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameLessThan(Integer value) {
			addCriterion("reply_name <", value, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameLessThanOrEqualTo(Integer value) {
			addCriterion("reply_name <=", value, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameIn(List<Integer> values) {
			addCriterion("reply_name in", values, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameNotIn(List<Integer> values) {
			addCriterion("reply_name not in", values, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameBetween(Integer value1, Integer value2) {
			addCriterion("reply_name between", value1, value2, "reply_name");
			return (Criteria) this;
		}

		public Criteria andReplyNameNotBetween(Integer value1, Integer value2) {
			addCriterion("reply_name not between", value1, value2, "reply_name");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Integer value) {
			addCriterion("update_time =", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Integer value) {
			addCriterion("update_time <>", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Integer value) {
			addCriterion("update_time >", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("update_time >=", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Integer value) {
			addCriterion("update_time <", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
			addCriterion("update_time <=", value, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Integer> values) {
			addCriterion("update_time in", values, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Integer> values) {
			addCriterion("update_time not in", values, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
			addCriterion("update_time between", value1, value2, "update_time");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("update_time not between", value1, value2, "update_time");
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