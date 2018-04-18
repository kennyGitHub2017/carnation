package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ConsultExample() {
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

		public Criteria andDeleteStatusEqualTo(Boolean value) {
			addCriterion("delete_Status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value) {
			addCriterion("delete_Status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value) {
			addCriterion("delete_Status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_Status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value) {
			addCriterion("delete_Status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_Status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values) {
			addCriterion("delete_Status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values) {
			addCriterion("delete_Status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_Status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_Status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andConsultEmailIsNull() {
			addCriterion("consult_email is null");
			return (Criteria) this;
		}

		public Criteria andConsultEmailIsNotNull() {
			addCriterion("consult_email is not null");
			return (Criteria) this;
		}

		public Criteria andConsultEmailEqualTo(String value) {
			addCriterion("consult_email =", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailNotEqualTo(String value) {
			addCriterion("consult_email <>", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailGreaterThan(String value) {
			addCriterion("consult_email >", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailGreaterThanOrEqualTo(String value) {
			addCriterion("consult_email >=", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailLessThan(String value) {
			addCriterion("consult_email <", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailLessThanOrEqualTo(String value) {
			addCriterion("consult_email <=", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailLike(String value) {
			addCriterion("consult_email like", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailNotLike(String value) {
			addCriterion("consult_email not like", value, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailIn(List<String> values) {
			addCriterion("consult_email in", values, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailNotIn(List<String> values) {
			addCriterion("consult_email not in", values, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailBetween(String value1, String value2) {
			addCriterion("consult_email between", value1, value2, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultEmailNotBetween(String value1, String value2) {
			addCriterion("consult_email not between", value1, value2, "consultEmail");
			return (Criteria) this;
		}

		public Criteria andConsultTypeIsNull() {
			addCriterion("consult_type is null");
			return (Criteria) this;
		}

		public Criteria andConsultTypeIsNotNull() {
			addCriterion("consult_type is not null");
			return (Criteria) this;
		}

		public Criteria andConsultTypeEqualTo(String value) {
			addCriterion("consult_type =", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeNotEqualTo(String value) {
			addCriterion("consult_type <>", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeGreaterThan(String value) {
			addCriterion("consult_type >", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeGreaterThanOrEqualTo(String value) {
			addCriterion("consult_type >=", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeLessThan(String value) {
			addCriterion("consult_type <", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeLessThanOrEqualTo(String value) {
			addCriterion("consult_type <=", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeLike(String value) {
			addCriterion("consult_type like", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeNotLike(String value) {
			addCriterion("consult_type not like", value, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeIn(List<String> values) {
			addCriterion("consult_type in", values, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeNotIn(List<String> values) {
			addCriterion("consult_type not in", values, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeBetween(String value1, String value2) {
			addCriterion("consult_type between", value1, value2, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultTypeNotBetween(String value1, String value2) {
			addCriterion("consult_type not between", value1, value2, "consultType");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdIsNull() {
			addCriterion("consult_user_id is null");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdIsNotNull() {
			addCriterion("consult_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdEqualTo(Long value) {
			addCriterion("consult_user_id =", value, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdNotEqualTo(Long value) {
			addCriterion("consult_user_id <>", value, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdGreaterThan(Long value) {
			addCriterion("consult_user_id >", value, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("consult_user_id >=", value, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdLessThan(Long value) {
			addCriterion("consult_user_id <", value, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdLessThanOrEqualTo(Long value) {
			addCriterion("consult_user_id <=", value, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdIn(List<Long> values) {
			addCriterion("consult_user_id in", values, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdNotIn(List<Long> values) {
			addCriterion("consult_user_id not in", values, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdBetween(Long value1, Long value2) {
			addCriterion("consult_user_id between", value1, value2, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserIdNotBetween(Long value1, Long value2) {
			addCriterion("consult_user_id not between", value1, value2, "consultUserId");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameIsNull() {
			addCriterion("consult_user_name is null");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameIsNotNull() {
			addCriterion("consult_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameEqualTo(String value) {
			addCriterion("consult_user_name =", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameNotEqualTo(String value) {
			addCriterion("consult_user_name <>", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameGreaterThan(String value) {
			addCriterion("consult_user_name >", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("consult_user_name >=", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameLessThan(String value) {
			addCriterion("consult_user_name <", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameLessThanOrEqualTo(String value) {
			addCriterion("consult_user_name <=", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameLike(String value) {
			addCriterion("consult_user_name like", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameNotLike(String value) {
			addCriterion("consult_user_name not like", value, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameIn(List<String> values) {
			addCriterion("consult_user_name in", values, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameNotIn(List<String> values) {
			addCriterion("consult_user_name not in", values, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameBetween(String value1, String value2) {
			addCriterion("consult_user_name between", value1, value2, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andConsultUserNameNotBetween(String value1, String value2) {
			addCriterion("consult_user_name not between", value1, value2, "consultUserName");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Long value) {
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Long value) {
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Long value) {
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Long value) {
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Long> values) {
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Long> values) {
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Long value1, Long value2) {
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_id not between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andReplyIsNull() {
			addCriterion("reply is null");
			return (Criteria) this;
		}

		public Criteria andReplyIsNotNull() {
			addCriterion("reply is not null");
			return (Criteria) this;
		}

		public Criteria andReplyEqualTo(Boolean value) {
			addCriterion("reply =", value, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyNotEqualTo(Boolean value) {
			addCriterion("reply <>", value, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyGreaterThan(Boolean value) {
			addCriterion("reply >", value, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyGreaterThanOrEqualTo(Boolean value) {
			addCriterion("reply >=", value, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyLessThan(Boolean value) {
			addCriterion("reply <", value, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyLessThanOrEqualTo(Boolean value) {
			addCriterion("reply <=", value, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyIn(List<Boolean> values) {
			addCriterion("reply in", values, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyNotIn(List<Boolean> values) {
			addCriterion("reply not in", values, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyBetween(Boolean value1, Boolean value2) {
			addCriterion("reply between", value1, value2, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyNotBetween(Boolean value1, Boolean value2) {
			addCriterion("reply not between", value1, value2, "reply");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIsNull() {
			addCriterion("reply_time is null");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIsNotNull() {
			addCriterion("reply_time is not null");
			return (Criteria) this;
		}

		public Criteria andReplyTimeEqualTo(Date value) {
			addCriterion("reply_time =", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotEqualTo(Date value) {
			addCriterion("reply_time <>", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeGreaterThan(Date value) {
			addCriterion("reply_time >", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("reply_time >=", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeLessThan(Date value) {
			addCriterion("reply_time <", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
			addCriterion("reply_time <=", value, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeIn(List<Date> values) {
			addCriterion("reply_time in", values, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotIn(List<Date> values) {
			addCriterion("reply_time not in", values, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeBetween(Date value1, Date value2) {
			addCriterion("reply_time between", value1, value2, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
			addCriterion("reply_time not between", value1, value2, "replyTime");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdIsNull() {
			addCriterion("reply_user_id is null");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdIsNotNull() {
			addCriterion("reply_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdEqualTo(Long value) {
			addCriterion("reply_user_id =", value, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdNotEqualTo(Long value) {
			addCriterion("reply_user_id <>", value, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdGreaterThan(Long value) {
			addCriterion("reply_user_id >", value, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("reply_user_id >=", value, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdLessThan(Long value) {
			addCriterion("reply_user_id <", value, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdLessThanOrEqualTo(Long value) {
			addCriterion("reply_user_id <=", value, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdIn(List<Long> values) {
			addCriterion("reply_user_id in", values, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdNotIn(List<Long> values) {
			addCriterion("reply_user_id not in", values, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdBetween(Long value1, Long value2) {
			addCriterion("reply_user_id between", value1, value2, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserIdNotBetween(Long value1, Long value2) {
			addCriterion("reply_user_id not between", value1, value2, "replyUserId");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameIsNull() {
			addCriterion("reply_user_name is null");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameIsNotNull() {
			addCriterion("reply_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameEqualTo(String value) {
			addCriterion("reply_user_name =", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameNotEqualTo(String value) {
			addCriterion("reply_user_name <>", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameGreaterThan(String value) {
			addCriterion("reply_user_name >", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("reply_user_name >=", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameLessThan(String value) {
			addCriterion("reply_user_name <", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameLessThanOrEqualTo(String value) {
			addCriterion("reply_user_name <=", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameLike(String value) {
			addCriterion("reply_user_name like", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameNotLike(String value) {
			addCriterion("reply_user_name not like", value, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameIn(List<String> values) {
			addCriterion("reply_user_name in", values, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameNotIn(List<String> values) {
			addCriterion("reply_user_name not in", values, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameBetween(String value1, String value2) {
			addCriterion("reply_user_name between", value1, value2, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andReplyUserNameNotBetween(String value1, String value2) {
			addCriterion("reply_user_name not between", value1, value2, "replyUserName");
			return (Criteria) this;
		}

		public Criteria andSatisfyIsNull() {
			addCriterion("satisfy is null");
			return (Criteria) this;
		}

		public Criteria andSatisfyIsNotNull() {
			addCriterion("satisfy is not null");
			return (Criteria) this;
		}

		public Criteria andSatisfyEqualTo(Integer value) {
			addCriterion("satisfy =", value, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyNotEqualTo(Integer value) {
			addCriterion("satisfy <>", value, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyGreaterThan(Integer value) {
			addCriterion("satisfy >", value, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyGreaterThanOrEqualTo(Integer value) {
			addCriterion("satisfy >=", value, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyLessThan(Integer value) {
			addCriterion("satisfy <", value, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyLessThanOrEqualTo(Integer value) {
			addCriterion("satisfy <=", value, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyIn(List<Integer> values) {
			addCriterion("satisfy in", values, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyNotIn(List<Integer> values) {
			addCriterion("satisfy not in", values, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyBetween(Integer value1, Integer value2) {
			addCriterion("satisfy between", value1, value2, "satisfy");
			return (Criteria) this;
		}

		public Criteria andSatisfyNotBetween(Integer value1, Integer value2) {
			addCriterion("satisfy not between", value1, value2, "satisfy");
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

		public Criteria andStoreNameIsNull() {
			addCriterion("store_name is null");
			return (Criteria) this;
		}

		public Criteria andStoreNameIsNotNull() {
			addCriterion("store_name is not null");
			return (Criteria) this;
		}

		public Criteria andStoreNameEqualTo(String value) {
			addCriterion("store_name =", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotEqualTo(String value) {
			addCriterion("store_name <>", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThan(String value) {
			addCriterion("store_name >", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
			addCriterion("store_name >=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThan(String value) {
			addCriterion("store_name <", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThanOrEqualTo(String value) {
			addCriterion("store_name <=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLike(String value) {
			addCriterion("store_name like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotLike(String value) {
			addCriterion("store_name not like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameIn(List<String> values) {
			addCriterion("store_name in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotIn(List<String> values) {
			addCriterion("store_name not in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameBetween(String value1, String value2) {
			addCriterion("store_name between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotBetween(String value1, String value2) {
			addCriterion("store_name not between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyIsNull() {
			addCriterion("unsatisfy is null");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyIsNotNull() {
			addCriterion("unsatisfy is not null");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyEqualTo(Integer value) {
			addCriterion("unsatisfy =", value, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyNotEqualTo(Integer value) {
			addCriterion("unsatisfy <>", value, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyGreaterThan(Integer value) {
			addCriterion("unsatisfy >", value, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyGreaterThanOrEqualTo(Integer value) {
			addCriterion("unsatisfy >=", value, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyLessThan(Integer value) {
			addCriterion("unsatisfy <", value, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyLessThanOrEqualTo(Integer value) {
			addCriterion("unsatisfy <=", value, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyIn(List<Integer> values) {
			addCriterion("unsatisfy in", values, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyNotIn(List<Integer> values) {
			addCriterion("unsatisfy not in", values, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyBetween(Integer value1, Integer value2) {
			addCriterion("unsatisfy between", value1, value2, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andUnsatisfyNotBetween(Integer value1, Integer value2) {
			addCriterion("unsatisfy not between", value1, value2, "unsatisfy");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfIsNull() {
			addCriterion("whether_self is null");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfIsNotNull() {
			addCriterion("whether_self is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfEqualTo(Integer value) {
			addCriterion("whether_self =", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfNotEqualTo(Integer value) {
			addCriterion("whether_self <>", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfGreaterThan(Integer value) {
			addCriterion("whether_self >", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfGreaterThanOrEqualTo(Integer value) {
			addCriterion("whether_self >=", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfLessThan(Integer value) {
			addCriterion("whether_self <", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfLessThanOrEqualTo(Integer value) {
			addCriterion("whether_self <=", value, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfIn(List<Integer> values) {
			addCriterion("whether_self in", values, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfNotIn(List<Integer> values) {
			addCriterion("whether_self not in", values, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfBetween(Integer value1, Integer value2) {
			addCriterion("whether_self between", value1, value2, "whetherSelf");
			return (Criteria) this;
		}

		public Criteria andWhetherSelfNotBetween(Integer value1, Integer value2) {
			addCriterion("whether_self not between", value1, value2, "whetherSelf");
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