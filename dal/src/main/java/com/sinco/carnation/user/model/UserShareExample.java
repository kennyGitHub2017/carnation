package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserShareExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserShareExample() {
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

		public Criteria andShareGoodsIdIsNull() {
			addCriterion("share_goods_id is null");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdIsNotNull() {
			addCriterion("share_goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdEqualTo(Long value) {
			addCriterion("share_goods_id =", value, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdNotEqualTo(Long value) {
			addCriterion("share_goods_id <>", value, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdGreaterThan(Long value) {
			addCriterion("share_goods_id >", value, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("share_goods_id >=", value, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdLessThan(Long value) {
			addCriterion("share_goods_id <", value, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("share_goods_id <=", value, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdIn(List<Long> values) {
			addCriterion("share_goods_id in", values, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdNotIn(List<Long> values) {
			addCriterion("share_goods_id not in", values, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdBetween(Long value1, Long value2) {
			addCriterion("share_goods_id between", value1, value2, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("share_goods_id not between", value1, value2, "shareGoodsId");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameIsNull() {
			addCriterion("share_goods_name is null");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameIsNotNull() {
			addCriterion("share_goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameEqualTo(String value) {
			addCriterion("share_goods_name =", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameNotEqualTo(String value) {
			addCriterion("share_goods_name <>", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameGreaterThan(String value) {
			addCriterion("share_goods_name >", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("share_goods_name >=", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameLessThan(String value) {
			addCriterion("share_goods_name <", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("share_goods_name <=", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameLike(String value) {
			addCriterion("share_goods_name like", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameNotLike(String value) {
			addCriterion("share_goods_name not like", value, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameIn(List<String> values) {
			addCriterion("share_goods_name in", values, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameNotIn(List<String> values) {
			addCriterion("share_goods_name not in", values, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameBetween(String value1, String value2) {
			addCriterion("share_goods_name between", value1, value2, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsNameNotBetween(String value1, String value2) {
			addCriterion("share_goods_name not between", value1, value2, "shareGoodsName");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoIsNull() {
			addCriterion("share_goods_photo is null");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoIsNotNull() {
			addCriterion("share_goods_photo is not null");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoEqualTo(String value) {
			addCriterion("share_goods_photo =", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoNotEqualTo(String value) {
			addCriterion("share_goods_photo <>", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoGreaterThan(String value) {
			addCriterion("share_goods_photo >", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("share_goods_photo >=", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoLessThan(String value) {
			addCriterion("share_goods_photo <", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoLessThanOrEqualTo(String value) {
			addCriterion("share_goods_photo <=", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoLike(String value) {
			addCriterion("share_goods_photo like", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoNotLike(String value) {
			addCriterion("share_goods_photo not like", value, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoIn(List<String> values) {
			addCriterion("share_goods_photo in", values, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoNotIn(List<String> values) {
			addCriterion("share_goods_photo not in", values, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoBetween(String value1, String value2) {
			addCriterion("share_goods_photo between", value1, value2, "shareGoodsPhoto");
			return (Criteria) this;
		}

		public Criteria andShareGoodsPhotoNotBetween(String value1, String value2) {
			addCriterion("share_goods_photo not between", value1, value2, "shareGoodsPhoto");
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

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
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