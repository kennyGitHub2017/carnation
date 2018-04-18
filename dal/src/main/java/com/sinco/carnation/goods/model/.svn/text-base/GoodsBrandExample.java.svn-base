package com.sinco.carnation.goods.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GoodsBrandExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsBrandExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()),
					property);
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

		public Criteria andAuditIsNull() {
			addCriterion("audit is null");
			return (Criteria) this;
		}

		public Criteria andAuditIsNotNull() {
			addCriterion("audit is not null");
			return (Criteria) this;
		}

		public Criteria andAuditEqualTo(Integer value) {
			addCriterion("audit =", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditNotEqualTo(Integer value) {
			addCriterion("audit <>", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditGreaterThan(Integer value) {
			addCriterion("audit >", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditGreaterThanOrEqualTo(Integer value) {
			addCriterion("audit >=", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditLessThan(Integer value) {
			addCriterion("audit <", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditLessThanOrEqualTo(Integer value) {
			addCriterion("audit <=", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditIn(List<Integer> values) {
			addCriterion("audit in", values, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditNotIn(List<Integer> values) {
			addCriterion("audit not in", values, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditBetween(Integer value1, Integer value2) {
			addCriterion("audit between", value1, value2, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditNotBetween(Integer value1, Integer value2) {
			addCriterion("audit not between", value1, value2, "audit");
			return (Criteria) this;
		}

		public Criteria andFirstWordIsNull() {
			addCriterion("first_word is null");
			return (Criteria) this;
		}

		public Criteria andFirstWordIsNotNull() {
			addCriterion("first_word is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWordEqualTo(String value) {
			addCriterion("first_word =", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordNotEqualTo(String value) {
			addCriterion("first_word <>", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordGreaterThan(String value) {
			addCriterion("first_word >", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordGreaterThanOrEqualTo(String value) {
			addCriterion("first_word >=", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordLessThan(String value) {
			addCriterion("first_word <", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordLessThanOrEqualTo(String value) {
			addCriterion("first_word <=", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordLike(String value) {
			addCriterion("first_word like", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordNotLike(String value) {
			addCriterion("first_word not like", value, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordIn(List<String> values) {
			addCriterion("first_word in", values, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordNotIn(List<String> values) {
			addCriterion("first_word not in", values, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordBetween(String value1, String value2) {
			addCriterion("first_word between", value1, value2, "firstWord");
			return (Criteria) this;
		}

		public Criteria andFirstWordNotBetween(String value1, String value2) {
			addCriterion("first_word not between", value1, value2, "firstWord");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendIsNull() {
			addCriterion("mobile_recommend is null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendIsNotNull() {
			addCriterion("mobile_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendEqualTo(Integer value) {
			addCriterion("mobile_recommend =", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendNotEqualTo(Integer value) {
			addCriterion("mobile_recommend <>", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendGreaterThan(Integer value) {
			addCriterion("mobile_recommend >", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendGreaterThanOrEqualTo(Integer value) {
			addCriterion("mobile_recommend >=", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendLessThan(Integer value) {
			addCriterion("mobile_recommend <", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendLessThanOrEqualTo(Integer value) {
			addCriterion("mobile_recommend <=", value, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendIn(List<Integer> values) {
			addCriterion("mobile_recommend in", values, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendNotIn(List<Integer> values) {
			addCriterion("mobile_recommend not in", values, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendBetween(Integer value1, Integer value2) {
			addCriterion("mobile_recommend between", value1, value2, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendNotBetween(Integer value1, Integer value2) {
			addCriterion("mobile_recommend not between", value1, value2, "mobileRecommend");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeIsNull() {
			addCriterion("mobile_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeIsNotNull() {
			addCriterion("mobile_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time =", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time <>", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time >", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time >=", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeLessThan(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time <", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mobile_recommend_time <=", value, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_recommend_time in", values, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("mobile_recommend_time not in", values, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_recommend_time between", value1, value2, "mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andMobileRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mobile_recommend_time not between", value1, value2,
					"mobileRecommendTime");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
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

		public Criteria andRecommendEqualTo(Boolean value) {
			addCriterion("recommend =", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotEqualTo(Boolean value) {
			addCriterion("recommend <>", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendGreaterThan(Boolean value) {
			addCriterion("recommend >", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("recommend >=", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLessThan(Boolean value) {
			addCriterion("recommend <", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLessThanOrEqualTo(Boolean value) {
			addCriterion("recommend <=", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendIn(List<Boolean> values) {
			addCriterion("recommend in", values, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotIn(List<Boolean> values) {
			addCriterion("recommend not in", values, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendBetween(Boolean value1, Boolean value2) {
			addCriterion("recommend between", value1, value2, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("recommend not between", value1, value2, "recommend");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNull() {
			addCriterion("sequence is null");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNotNull() {
			addCriterion("sequence is not null");
			return (Criteria) this;
		}

		public Criteria andSequenceEqualTo(Integer value) {
			addCriterion("sequence =", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotEqualTo(Integer value) {
			addCriterion("sequence <>", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThan(Integer value) {
			addCriterion("sequence >", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("sequence >=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThan(Integer value) {
			addCriterion("sequence <", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("sequence <=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceIn(List<Integer> values) {
			addCriterion("sequence in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotIn(List<Integer> values) {
			addCriterion("sequence not in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceBetween(Integer value1, Integer value2) {
			addCriterion("sequence between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("sequence not between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andShowIndexIsNull() {
			addCriterion("show_index is null");
			return (Criteria) this;
		}

		public Criteria andShowIndexIsNotNull() {
			addCriterion("show_index is not null");
			return (Criteria) this;
		}

		public Criteria andShowIndexEqualTo(Boolean value) {
			addCriterion("show_index =", value, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexNotEqualTo(Boolean value) {
			addCriterion("show_index <>", value, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexGreaterThan(Boolean value) {
			addCriterion("show_index >", value, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexGreaterThanOrEqualTo(Boolean value) {
			addCriterion("show_index >=", value, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexLessThan(Boolean value) {
			addCriterion("show_index <", value, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexLessThanOrEqualTo(Boolean value) {
			addCriterion("show_index <=", value, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexIn(List<Boolean> values) {
			addCriterion("show_index in", values, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexNotIn(List<Boolean> values) {
			addCriterion("show_index not in", values, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexBetween(Boolean value1, Boolean value2) {
			addCriterion("show_index between", value1, value2, "showIndex");
			return (Criteria) this;
		}

		public Criteria andShowIndexNotBetween(Boolean value1, Boolean value2) {
			addCriterion("show_index not between", value1, value2, "showIndex");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNull() {
			addCriterion("user_status is null");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNotNull() {
			addCriterion("user_status is not null");
			return (Criteria) this;
		}

		public Criteria andUserStatusEqualTo(Integer value) {
			addCriterion("user_status =", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotEqualTo(Integer value) {
			addCriterion("user_status <>", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThan(Integer value) {
			addCriterion("user_status >", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_status >=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThan(Integer value) {
			addCriterion("user_status <", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThanOrEqualTo(Integer value) {
			addCriterion("user_status <=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusIn(List<Integer> values) {
			addCriterion("user_status in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotIn(List<Integer> values) {
			addCriterion("user_status not in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusBetween(Integer value1, Integer value2) {
			addCriterion("user_status between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("user_status not between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdIsNull() {
			addCriterion("brand_logo_id is null");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdIsNotNull() {
			addCriterion("brand_logo_id is not null");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdEqualTo(Long value) {
			addCriterion("brand_logo_id =", value, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdNotEqualTo(Long value) {
			addCriterion("brand_logo_id <>", value, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdGreaterThan(Long value) {
			addCriterion("brand_logo_id >", value, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("brand_logo_id >=", value, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdLessThan(Long value) {
			addCriterion("brand_logo_id <", value, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdLessThanOrEqualTo(Long value) {
			addCriterion("brand_logo_id <=", value, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdIn(List<Long> values) {
			addCriterion("brand_logo_id in", values, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdNotIn(List<Long> values) {
			addCriterion("brand_logo_id not in", values, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdBetween(Long value1, Long value2) {
			addCriterion("brand_logo_id between", value1, value2, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andBrandLogoIdNotBetween(Long value1, Long value2) {
			addCriterion("brand_logo_id not between", value1, value2, "brandLogoId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNull() {
			addCriterion("category_id is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNotNull() {
			addCriterion("category_id is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdEqualTo(Long value) {
			addCriterion("category_id =", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotEqualTo(Long value) {
			addCriterion("category_id <>", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThan(Long value) {
			addCriterion("category_id >", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
			addCriterion("category_id >=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThan(Long value) {
			addCriterion("category_id <", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
			addCriterion("category_id <=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIn(List<Long> values) {
			addCriterion("category_id in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotIn(List<Long> values) {
			addCriterion("category_id not in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdBetween(Long value1, Long value2) {
			addCriterion("category_id between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
			addCriterion("category_id not between", value1, value2, "categoryId");
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

		public Criteria andGcIdIsNull() {
			addCriterion("gc_id is null");
			return (Criteria) this;
		}

		public Criteria andGcIdIsNotNull() {
			addCriterion("gc_id is not null");
			return (Criteria) this;
		}

		public Criteria andGcIdEqualTo(Long value) {
			addCriterion("gc_id =", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotEqualTo(Long value) {
			addCriterion("gc_id <>", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdGreaterThan(Long value) {
			addCriterion("gc_id >", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gc_id >=", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdLessThan(Long value) {
			addCriterion("gc_id <", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdLessThanOrEqualTo(Long value) {
			addCriterion("gc_id <=", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdIn(List<Long> values) {
			addCriterion("gc_id in", values, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotIn(List<Long> values) {
			addCriterion("gc_id not in", values, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdBetween(Long value1, Long value2) {
			addCriterion("gc_id between", value1, value2, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotBetween(Long value1, Long value2) {
			addCriterion("gc_id not between", value1, value2, "gcId");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendIsNull() {
			addCriterion("weixin_recommend is null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendIsNotNull() {
			addCriterion("weixin_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendEqualTo(Integer value) {
			addCriterion("weixin_recommend =", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendNotEqualTo(Integer value) {
			addCriterion("weixin_recommend <>", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendGreaterThan(Integer value) {
			addCriterion("weixin_recommend >", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendGreaterThanOrEqualTo(Integer value) {
			addCriterion("weixin_recommend >=", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendLessThan(Integer value) {
			addCriterion("weixin_recommend <", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendLessThanOrEqualTo(Integer value) {
			addCriterion("weixin_recommend <=", value, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendIn(List<Integer> values) {
			addCriterion("weixin_recommend in", values, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendNotIn(List<Integer> values) {
			addCriterion("weixin_recommend not in", values, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendBetween(Integer value1, Integer value2) {
			addCriterion("weixin_recommend between", value1, value2, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendNotBetween(Integer value1, Integer value2) {
			addCriterion("weixin_recommend not between", value1, value2, "weixinRecommend");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeIsNull() {
			addCriterion("weixin_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeIsNotNull() {
			addCriterion("weixin_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time =", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time <>", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time >", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time >=", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeLessThan(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time <", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("weixin_recommend_time <=", value, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_recommend_time in", values, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("weixin_recommend_time not in", values, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_recommend_time between", value1, value2, "weixinRecommendTime");
			return (Criteria) this;
		}

		public Criteria andWeixinRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("weixin_recommend_time not between", value1, value2,
					"weixinRecommendTime");
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