package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlbumExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public AlbumExample() {
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

		public Criteria andAlbumDefaultIsNull() {
			addCriterion("album_default is null");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultIsNotNull() {
			addCriterion("album_default is not null");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultEqualTo(Boolean value) {
			addCriterion("album_default =", value, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultNotEqualTo(Boolean value) {
			addCriterion("album_default <>", value, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultGreaterThan(Boolean value) {
			addCriterion("album_default >", value, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultGreaterThanOrEqualTo(Boolean value) {
			addCriterion("album_default >=", value, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultLessThan(Boolean value) {
			addCriterion("album_default <", value, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultLessThanOrEqualTo(Boolean value) {
			addCriterion("album_default <=", value, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultIn(List<Boolean> values) {
			addCriterion("album_default in", values, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultNotIn(List<Boolean> values) {
			addCriterion("album_default not in", values, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultBetween(Boolean value1, Boolean value2) {
			addCriterion("album_default between", value1, value2, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumDefaultNotBetween(Boolean value1, Boolean value2) {
			addCriterion("album_default not between", value1, value2, "albumDefault");
			return (Criteria) this;
		}

		public Criteria andAlbumNameIsNull() {
			addCriterion("album_name is null");
			return (Criteria) this;
		}

		public Criteria andAlbumNameIsNotNull() {
			addCriterion("album_name is not null");
			return (Criteria) this;
		}

		public Criteria andAlbumNameEqualTo(String value) {
			addCriterion("album_name =", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameNotEqualTo(String value) {
			addCriterion("album_name <>", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameGreaterThan(String value) {
			addCriterion("album_name >", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
			addCriterion("album_name >=", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameLessThan(String value) {
			addCriterion("album_name <", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameLessThanOrEqualTo(String value) {
			addCriterion("album_name <=", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameLike(String value) {
			addCriterion("album_name like", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameNotLike(String value) {
			addCriterion("album_name not like", value, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameIn(List<String> values) {
			addCriterion("album_name in", values, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameNotIn(List<String> values) {
			addCriterion("album_name not in", values, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameBetween(String value1, String value2) {
			addCriterion("album_name between", value1, value2, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumNameNotBetween(String value1, String value2) {
			addCriterion("album_name not between", value1, value2, "albumName");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceIsNull() {
			addCriterion("album_sequence is null");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceIsNotNull() {
			addCriterion("album_sequence is not null");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceEqualTo(Integer value) {
			addCriterion("album_sequence =", value, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceNotEqualTo(Integer value) {
			addCriterion("album_sequence <>", value, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceGreaterThan(Integer value) {
			addCriterion("album_sequence >", value, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("album_sequence >=", value, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceLessThan(Integer value) {
			addCriterion("album_sequence <", value, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("album_sequence <=", value, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceIn(List<Integer> values) {
			addCriterion("album_sequence in", values, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceNotIn(List<Integer> values) {
			addCriterion("album_sequence not in", values, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceBetween(Integer value1, Integer value2) {
			addCriterion("album_sequence between", value1, value2, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("album_sequence not between", value1, value2, "albumSequence");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdIsNull() {
			addCriterion("album_cover_id is null");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdIsNotNull() {
			addCriterion("album_cover_id is not null");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdEqualTo(Long value) {
			addCriterion("album_cover_id =", value, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdNotEqualTo(Long value) {
			addCriterion("album_cover_id <>", value, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdGreaterThan(Long value) {
			addCriterion("album_cover_id >", value, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdGreaterThanOrEqualTo(Long value) {
			addCriterion("album_cover_id >=", value, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdLessThan(Long value) {
			addCriterion("album_cover_id <", value, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdLessThanOrEqualTo(Long value) {
			addCriterion("album_cover_id <=", value, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdIn(List<Long> values) {
			addCriterion("album_cover_id in", values, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdNotIn(List<Long> values) {
			addCriterion("album_cover_id not in", values, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdBetween(Long value1, Long value2) {
			addCriterion("album_cover_id between", value1, value2, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andAlbumCoverIdNotBetween(Long value1, Long value2) {
			addCriterion("album_cover_id not between", value1, value2, "albumCoverId");
			return (Criteria) this;
		}

		public Criteria andStoreInfoDefaultEqualTo(Integer value) {
			addCriterion("store_info_default =", value, "storeInfoDefault");
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