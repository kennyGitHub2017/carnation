package com.sinco.carnation.recommend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendItemExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RecommendItemExample() {
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

		public Criteria andShowTextIsNull() {
			addCriterion("show_text is null");
			return (Criteria) this;
		}

		public Criteria andShowTextIsNotNull() {
			addCriterion("show_text is not null");
			return (Criteria) this;
		}

		public Criteria andShowTextEqualTo(String value) {
			addCriterion("show_text =", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotEqualTo(String value) {
			addCriterion("show_text <>", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextGreaterThan(String value) {
			addCriterion("show_text >", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextGreaterThanOrEqualTo(String value) {
			addCriterion("show_text >=", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextLessThan(String value) {
			addCriterion("show_text <", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextLessThanOrEqualTo(String value) {
			addCriterion("show_text <=", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextLike(String value) {
			addCriterion("show_text like", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotLike(String value) {
			addCriterion("show_text not like", value, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextIn(List<String> values) {
			addCriterion("show_text in", values, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotIn(List<String> values) {
			addCriterion("show_text not in", values, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextBetween(String value1, String value2) {
			addCriterion("show_text between", value1, value2, "showText");
			return (Criteria) this;
		}

		public Criteria andShowTextNotBetween(String value1, String value2) {
			addCriterion("show_text not between", value1, value2, "showText");
			return (Criteria) this;
		}

		public Criteria andShowDescIsNull() {
			addCriterion("show_desc is null");
			return (Criteria) this;
		}

		public Criteria andShowDescIsNotNull() {
			addCriterion("show_desc is not null");
			return (Criteria) this;
		}

		public Criteria andShowDescEqualTo(String value) {
			addCriterion("show_desc =", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescNotEqualTo(String value) {
			addCriterion("show_desc <>", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescGreaterThan(String value) {
			addCriterion("show_desc >", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescGreaterThanOrEqualTo(String value) {
			addCriterion("show_desc >=", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescLessThan(String value) {
			addCriterion("show_desc <", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescLessThanOrEqualTo(String value) {
			addCriterion("show_desc <=", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescLike(String value) {
			addCriterion("show_desc like", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescNotLike(String value) {
			addCriterion("show_desc not like", value, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescIn(List<String> values) {
			addCriterion("show_desc in", values, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescNotIn(List<String> values) {
			addCriterion("show_desc not in", values, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescBetween(String value1, String value2) {
			addCriterion("show_desc between", value1, value2, "showDesc");
			return (Criteria) this;
		}

		public Criteria andShowDescNotBetween(String value1, String value2) {
			addCriterion("show_desc not between", value1, value2, "showDesc");
			return (Criteria) this;
		}

		public Criteria andImgPathIsNull() {
			addCriterion("img_path is null");
			return (Criteria) this;
		}

		public Criteria andImgPathIsNotNull() {
			addCriterion("img_path is not null");
			return (Criteria) this;
		}

		public Criteria andImgPathEqualTo(String value) {
			addCriterion("img_path =", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathNotEqualTo(String value) {
			addCriterion("img_path <>", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathGreaterThan(String value) {
			addCriterion("img_path >", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathGreaterThanOrEqualTo(String value) {
			addCriterion("img_path >=", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathLessThan(String value) {
			addCriterion("img_path <", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathLessThanOrEqualTo(String value) {
			addCriterion("img_path <=", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathLike(String value) {
			addCriterion("img_path like", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathNotLike(String value) {
			addCriterion("img_path not like", value, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathIn(List<String> values) {
			addCriterion("img_path in", values, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathNotIn(List<String> values) {
			addCriterion("img_path not in", values, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathBetween(String value1, String value2) {
			addCriterion("img_path between", value1, value2, "imgPath");
			return (Criteria) this;
		}

		public Criteria andImgPathNotBetween(String value1, String value2) {
			addCriterion("img_path not between", value1, value2, "imgPath");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeIsNull() {
			addCriterion("recommend_type is null");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeIsNotNull() {
			addCriterion("recommend_type is not null");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeEqualTo(String value) {
			addCriterion("recommend_type =", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeNotEqualTo(String value) {
			addCriterion("recommend_type <>", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeGreaterThan(String value) {
			addCriterion("recommend_type >", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeGreaterThanOrEqualTo(String value) {
			addCriterion("recommend_type >=", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeLessThan(String value) {
			addCriterion("recommend_type <", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeLessThanOrEqualTo(String value) {
			addCriterion("recommend_type <=", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeLike(String value) {
			addCriterion("recommend_type like", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeNotLike(String value) {
			addCriterion("recommend_type not like", value, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeIn(List<String> values) {
			addCriterion("recommend_type in", values, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeNotIn(List<String> values) {
			addCriterion("recommend_type not in", values, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeBetween(String value1, String value2) {
			addCriterion("recommend_type between", value1, value2, "recommendType");
			return (Criteria) this;
		}

		public Criteria andRecommendTypeNotBetween(String value1, String value2) {
			addCriterion("recommend_type not between", value1, value2, "recommendType");
			return (Criteria) this;
		}

		public Criteria andLinkIsNull() {
			addCriterion("link is null");
			return (Criteria) this;
		}

		public Criteria andLinkIsNotNull() {
			addCriterion("link is not null");
			return (Criteria) this;
		}

		public Criteria andLinkEqualTo(String value) {
			addCriterion("link =", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotEqualTo(String value) {
			addCriterion("link <>", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkGreaterThan(String value) {
			addCriterion("link >", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkGreaterThanOrEqualTo(String value) {
			addCriterion("link >=", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkLessThan(String value) {
			addCriterion("link <", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkLessThanOrEqualTo(String value) {
			addCriterion("link <=", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkLike(String value) {
			addCriterion("link like", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotLike(String value) {
			addCriterion("link not like", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkIn(List<String> values) {
			addCriterion("link in", values, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotIn(List<String> values) {
			addCriterion("link not in", values, "link");
			return (Criteria) this;
		}

		public Criteria andLinkBetween(String value1, String value2) {
			addCriterion("link between", value1, value2, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotBetween(String value1, String value2) {
			addCriterion("link not between", value1, value2, "link");
			return (Criteria) this;
		}

		public Criteria andUdpateByIsNull() {
			addCriterion("udpate_by is null");
			return (Criteria) this;
		}

		public Criteria andUdpateByIsNotNull() {
			addCriterion("udpate_by is not null");
			return (Criteria) this;
		}

		public Criteria andUdpateByEqualTo(Long value) {
			addCriterion("udpate_by =", value, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByNotEqualTo(Long value) {
			addCriterion("udpate_by <>", value, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByGreaterThan(Long value) {
			addCriterion("udpate_by >", value, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByGreaterThanOrEqualTo(Long value) {
			addCriterion("udpate_by >=", value, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByLessThan(Long value) {
			addCriterion("udpate_by <", value, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByLessThanOrEqualTo(Long value) {
			addCriterion("udpate_by <=", value, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByIn(List<Long> values) {
			addCriterion("udpate_by in", values, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByNotIn(List<Long> values) {
			addCriterion("udpate_by not in", values, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByBetween(Long value1, Long value2) {
			addCriterion("udpate_by between", value1, value2, "udpateBy");
			return (Criteria) this;
		}

		public Criteria andUdpateByNotBetween(Long value1, Long value2) {
			addCriterion("udpate_by not between", value1, value2, "udpateBy");
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