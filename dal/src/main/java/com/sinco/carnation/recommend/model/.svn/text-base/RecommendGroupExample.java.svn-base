package com.sinco.carnation.recommend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendGroupExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RecommendGroupExample() {
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

		public Criteria andGroupKeyIsNull() {
			addCriterion("group_key is null");
			return (Criteria) this;
		}

		public Criteria andGroupKeyIsNotNull() {
			addCriterion("group_key is not null");
			return (Criteria) this;
		}

		public Criteria andGroupKeyEqualTo(String value) {
			addCriterion("group_key =", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyNotEqualTo(String value) {
			addCriterion("group_key <>", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyGreaterThan(String value) {
			addCriterion("group_key >", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyGreaterThanOrEqualTo(String value) {
			addCriterion("group_key >=", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyLessThan(String value) {
			addCriterion("group_key <", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyLessThanOrEqualTo(String value) {
			addCriterion("group_key <=", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyLike(String value) {
			addCriterion("group_key like", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyNotLike(String value) {
			addCriterion("group_key not like", value, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyIn(List<String> values) {
			addCriterion("group_key in", values, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyNotIn(List<String> values) {
			addCriterion("group_key not in", values, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyBetween(String value1, String value2) {
			addCriterion("group_key between", value1, value2, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupKeyNotBetween(String value1, String value2) {
			addCriterion("group_key not between", value1, value2, "groupKey");
			return (Criteria) this;
		}

		public Criteria andGroupNameIsNull() {
			addCriterion("group_name is null");
			return (Criteria) this;
		}

		public Criteria andGroupNameIsNotNull() {
			addCriterion("group_name is not null");
			return (Criteria) this;
		}

		public Criteria andGroupNameEqualTo(String value) {
			addCriterion("group_name =", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameNotEqualTo(String value) {
			addCriterion("group_name <>", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameGreaterThan(String value) {
			addCriterion("group_name >", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
			addCriterion("group_name >=", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameLessThan(String value) {
			addCriterion("group_name <", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameLessThanOrEqualTo(String value) {
			addCriterion("group_name <=", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameLike(String value) {
			addCriterion("group_name like", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameNotLike(String value) {
			addCriterion("group_name not like", value, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameIn(List<String> values) {
			addCriterion("group_name in", values, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameNotIn(List<String> values) {
			addCriterion("group_name not in", values, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameBetween(String value1, String value2) {
			addCriterion("group_name between", value1, value2, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupNameNotBetween(String value1, String value2) {
			addCriterion("group_name not between", value1, value2, "groupName");
			return (Criteria) this;
		}

		public Criteria andGroupDescIsNull() {
			addCriterion("group_desc is null");
			return (Criteria) this;
		}

		public Criteria andGroupDescIsNotNull() {
			addCriterion("group_desc is not null");
			return (Criteria) this;
		}

		public Criteria andGroupDescEqualTo(String value) {
			addCriterion("group_desc =", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescNotEqualTo(String value) {
			addCriterion("group_desc <>", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescGreaterThan(String value) {
			addCriterion("group_desc >", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescGreaterThanOrEqualTo(String value) {
			addCriterion("group_desc >=", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescLessThan(String value) {
			addCriterion("group_desc <", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescLessThanOrEqualTo(String value) {
			addCriterion("group_desc <=", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescLike(String value) {
			addCriterion("group_desc like", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescNotLike(String value) {
			addCriterion("group_desc not like", value, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescIn(List<String> values) {
			addCriterion("group_desc in", values, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescNotIn(List<String> values) {
			addCriterion("group_desc not in", values, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescBetween(String value1, String value2) {
			addCriterion("group_desc between", value1, value2, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andGroupDescNotBetween(String value1, String value2) {
			addCriterion("group_desc not between", value1, value2, "groupDesc");
			return (Criteria) this;
		}

		public Criteria andImgWidthIsNull() {
			addCriterion("img_width is null");
			return (Criteria) this;
		}

		public Criteria andImgWidthIsNotNull() {
			addCriterion("img_width is not null");
			return (Criteria) this;
		}

		public Criteria andImgWidthEqualTo(Integer value) {
			addCriterion("img_width =", value, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthNotEqualTo(Integer value) {
			addCriterion("img_width <>", value, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthGreaterThan(Integer value) {
			addCriterion("img_width >", value, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("img_width >=", value, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthLessThan(Integer value) {
			addCriterion("img_width <", value, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthLessThanOrEqualTo(Integer value) {
			addCriterion("img_width <=", value, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthIn(List<Integer> values) {
			addCriterion("img_width in", values, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthNotIn(List<Integer> values) {
			addCriterion("img_width not in", values, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthBetween(Integer value1, Integer value2) {
			addCriterion("img_width between", value1, value2, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("img_width not between", value1, value2, "imgWidth");
			return (Criteria) this;
		}

		public Criteria andImgHeightIsNull() {
			addCriterion("img_height is null");
			return (Criteria) this;
		}

		public Criteria andImgHeightIsNotNull() {
			addCriterion("img_height is not null");
			return (Criteria) this;
		}

		public Criteria andImgHeightEqualTo(Integer value) {
			addCriterion("img_height =", value, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightNotEqualTo(Integer value) {
			addCriterion("img_height <>", value, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightGreaterThan(Integer value) {
			addCriterion("img_height >", value, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("img_height >=", value, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightLessThan(Integer value) {
			addCriterion("img_height <", value, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightLessThanOrEqualTo(Integer value) {
			addCriterion("img_height <=", value, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightIn(List<Integer> values) {
			addCriterion("img_height in", values, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightNotIn(List<Integer> values) {
			addCriterion("img_height not in", values, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightBetween(Integer value1, Integer value2) {
			addCriterion("img_height between", value1, value2, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andImgHeightNotBetween(Integer value1, Integer value2) {
			addCriterion("img_height not between", value1, value2, "imgHeight");
			return (Criteria) this;
		}

		public Criteria andUpdateByIsNull() {
			addCriterion("update_by is null");
			return (Criteria) this;
		}

		public Criteria andUpdateByIsNotNull() {
			addCriterion("update_by is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateByEqualTo(Long value) {
			addCriterion("update_by =", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotEqualTo(Long value) {
			addCriterion("update_by <>", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThan(Long value) {
			addCriterion("update_by >", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
			addCriterion("update_by >=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThan(Long value) {
			addCriterion("update_by <", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThanOrEqualTo(Long value) {
			addCriterion("update_by <=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByIn(List<Long> values) {
			addCriterion("update_by in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotIn(List<Long> values) {
			addCriterion("update_by not in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByBetween(Long value1, Long value2) {
			addCriterion("update_by between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotBetween(Long value1, Long value2) {
			addCriterion("update_by not between", value1, value2, "updateBy");
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

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNull() {
			addCriterion("create_by is null");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNotNull() {
			addCriterion("create_by is not null");
			return (Criteria) this;
		}

		public Criteria andCreateByEqualTo(Long value) {
			addCriterion("create_by =", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotEqualTo(Long value) {
			addCriterion("create_by <>", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThan(Long value) {
			addCriterion("create_by >", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
			addCriterion("create_by >=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThan(Long value) {
			addCriterion("create_by <", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThanOrEqualTo(Long value) {
			addCriterion("create_by <=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByIn(List<Long> values) {
			addCriterion("create_by in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotIn(List<Long> values) {
			addCriterion("create_by not in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByBetween(Long value1, Long value2) {
			addCriterion("create_by between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotBetween(Long value1, Long value2) {
			addCriterion("create_by not between", value1, value2, "createBy");
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

		public Criteria andIsDeletedIsNull() {
			addCriterion("is_deleted is null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIsNotNull() {
			addCriterion("is_deleted is not null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedEqualTo(Boolean value) {
			addCriterion("is_deleted =", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotEqualTo(Boolean value) {
			addCriterion("is_deleted <>", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThan(Boolean value) {
			addCriterion("is_deleted >", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_deleted >=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThan(Boolean value) {
			addCriterion("is_deleted <", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_deleted <=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIn(List<Boolean> values) {
			addCriterion("is_deleted in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotIn(List<Boolean> values) {
			addCriterion("is_deleted not in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_deleted between", value1, value2, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_deleted not between", value1, value2, "isDeleted");
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