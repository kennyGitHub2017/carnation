package com.sinco.carnation.user.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserCustomerExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserCustomerExample() {
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Long value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Long value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Long value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Long value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Long value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Long value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Long> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Long> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Long value1, Long value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Long value1, Long value2) {
			addCriterion("uid not between", value1, value2, "uid");
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

		public Criteria andNicknameIsNull() {
			addCriterion("nickname is null");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNotNull() {
			addCriterion("nickname is not null");
			return (Criteria) this;
		}

		public Criteria andNicknameEqualTo(String value) {
			addCriterion("nickname =", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotEqualTo(String value) {
			addCriterion("nickname <>", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThan(String value) {
			addCriterion("nickname >", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("nickname >=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThan(String value) {
			addCriterion("nickname <", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThanOrEqualTo(String value) {
			addCriterion("nickname <=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLike(String value) {
			addCriterion("nickname like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotLike(String value) {
			addCriterion("nickname not like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameIn(List<String> values) {
			addCriterion("nickname in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotIn(List<String> values) {
			addCriterion("nickname not in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameBetween(String value1, String value2) {
			addCriterion("nickname between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotBetween(String value1, String value2) {
			addCriterion("nickname not between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryIsNull() {
			addCriterion("allergic_history is null");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryIsNotNull() {
			addCriterion("allergic_history is not null");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryEqualTo(String value) {
			addCriterion("allergic_history =", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryNotEqualTo(String value) {
			addCriterion("allergic_history <>", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryGreaterThan(String value) {
			addCriterion("allergic_history >", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryGreaterThanOrEqualTo(String value) {
			addCriterion("allergic_history >=", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryLessThan(String value) {
			addCriterion("allergic_history <", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryLessThanOrEqualTo(String value) {
			addCriterion("allergic_history <=", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryLike(String value) {
			addCriterion("allergic_history like", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryNotLike(String value) {
			addCriterion("allergic_history not like", value, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryIn(List<String> values) {
			addCriterion("allergic_history in", values, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryNotIn(List<String> values) {
			addCriterion("allergic_history not in", values, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryBetween(String value1, String value2) {
			addCriterion("allergic_history between", value1, value2, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andAllergicHistoryNotBetween(String value1, String value2) {
			addCriterion("allergic_history not between", value1, value2, "allergicHistory");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(Integer value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(Integer value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(Integer value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(Integer value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(Integer value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(Integer value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<Integer> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<Integer> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(Integer value1, Integer value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(Integer value1, Integer value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andHeightIsNull() {
			addCriterion("height is null");
			return (Criteria) this;
		}

		public Criteria andHeightIsNotNull() {
			addCriterion("height is not null");
			return (Criteria) this;
		}

		public Criteria andHeightEqualTo(Integer value) {
			addCriterion("height =", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotEqualTo(Integer value) {
			addCriterion("height <>", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThan(Integer value) {
			addCriterion("height >", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("height >=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThan(Integer value) {
			addCriterion("height <", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThanOrEqualTo(Integer value) {
			addCriterion("height <=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightIn(List<Integer> values) {
			addCriterion("height in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotIn(List<Integer> values) {
			addCriterion("height not in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightBetween(Integer value1, Integer value2) {
			addCriterion("height between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotBetween(Integer value1, Integer value2) {
			addCriterion("height not between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andWeightIsNull() {
			addCriterion("weight is null");
			return (Criteria) this;
		}

		public Criteria andWeightIsNotNull() {
			addCriterion("weight is not null");
			return (Criteria) this;
		}

		public Criteria andWeightEqualTo(Integer value) {
			addCriterion("weight =", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotEqualTo(Integer value) {
			addCriterion("weight <>", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThan(Integer value) {
			addCriterion("weight >", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("weight >=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThan(Integer value) {
			addCriterion("weight <", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThanOrEqualTo(Integer value) {
			addCriterion("weight <=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightIn(List<Integer> values) {
			addCriterion("weight in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotIn(List<Integer> values) {
			addCriterion("weight not in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightBetween(Integer value1, Integer value2) {
			addCriterion("weight between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotBetween(Integer value1, Integer value2) {
			addCriterion("weight not between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andBirthdateIsNull() {
			addCriterion("birthdate is null");
			return (Criteria) this;
		}

		public Criteria andBirthdateIsNotNull() {
			addCriterion("birthdate is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdateEqualTo(Date value) {
			addCriterionForJDBCDate("birthdate =", value, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("birthdate <>", value, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateGreaterThan(Date value) {
			addCriterionForJDBCDate("birthdate >", value, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("birthdate >=", value, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateLessThan(Date value) {
			addCriterionForJDBCDate("birthdate <", value, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("birthdate <=", value, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateIn(List<Date> values) {
			addCriterionForJDBCDate("birthdate in", values, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("birthdate not in", values, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("birthdate between", value1, value2, "birthdate");
			return (Criteria) this;
		}

		public Criteria andBirthdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("birthdate not between", value1, value2, "birthdate");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathIsNull() {
			addCriterion("head_img_path is null");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathIsNotNull() {
			addCriterion("head_img_path is not null");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathEqualTo(String value) {
			addCriterion("head_img_path =", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathNotEqualTo(String value) {
			addCriterion("head_img_path <>", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathGreaterThan(String value) {
			addCriterion("head_img_path >", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathGreaterThanOrEqualTo(String value) {
			addCriterion("head_img_path >=", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathLessThan(String value) {
			addCriterion("head_img_path <", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathLessThanOrEqualTo(String value) {
			addCriterion("head_img_path <=", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathLike(String value) {
			addCriterion("head_img_path like", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathNotLike(String value) {
			addCriterion("head_img_path not like", value, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathIn(List<String> values) {
			addCriterion("head_img_path in", values, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathNotIn(List<String> values) {
			addCriterion("head_img_path not in", values, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathBetween(String value1, String value2) {
			addCriterion("head_img_path between", value1, value2, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andHeadImgPathNotBetween(String value1, String value2) {
			addCriterion("head_img_path not between", value1, value2, "headImgPath");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
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

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
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

		public Criteria andCreateByEqualTo(String value) {
			addCriterion("create_by =", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotEqualTo(String value) {
			addCriterion("create_by <>", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThan(String value) {
			addCriterion("create_by >", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThanOrEqualTo(String value) {
			addCriterion("create_by >=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThan(String value) {
			addCriterion("create_by <", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThanOrEqualTo(String value) {
			addCriterion("create_by <=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLike(String value) {
			addCriterion("create_by like", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotLike(String value) {
			addCriterion("create_by not like", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByIn(List<String> values) {
			addCriterion("create_by in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotIn(List<String> values) {
			addCriterion("create_by not in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByBetween(String value1, String value2) {
			addCriterion("create_by between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotBetween(String value1, String value2) {
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

		public Criteria andUpdateByIsNull() {
			addCriterion("update_by is null");
			return (Criteria) this;
		}

		public Criteria andUpdateByIsNotNull() {
			addCriterion("update_by is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateByEqualTo(String value) {
			addCriterion("update_by =", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotEqualTo(String value) {
			addCriterion("update_by <>", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThan(String value) {
			addCriterion("update_by >", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
			addCriterion("update_by >=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThan(String value) {
			addCriterion("update_by <", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThanOrEqualTo(String value) {
			addCriterion("update_by <=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLike(String value) {
			addCriterion("update_by like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotLike(String value) {
			addCriterion("update_by not like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByIn(List<String> values) {
			addCriterion("update_by in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotIn(List<String> values) {
			addCriterion("update_by not in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByBetween(String value1, String value2) {
			addCriterion("update_by between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotBetween(String value1, String value2) {
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

		public Criteria andTransHistoryIsNull() {
			addCriterion("trans_history is null");
			return (Criteria) this;
		}

		public Criteria andTransHistoryIsNotNull() {
			addCriterion("trans_history is not null");
			return (Criteria) this;
		}

		public Criteria andTransHistoryEqualTo(String value) {
			addCriterion("trans_history =", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryNotEqualTo(String value) {
			addCriterion("trans_history <>", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryGreaterThan(String value) {
			addCriterion("trans_history >", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryGreaterThanOrEqualTo(String value) {
			addCriterion("trans_history >=", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryLessThan(String value) {
			addCriterion("trans_history <", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryLessThanOrEqualTo(String value) {
			addCriterion("trans_history <=", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryLike(String value) {
			addCriterion("trans_history like", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryNotLike(String value) {
			addCriterion("trans_history not like", value, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryIn(List<String> values) {
			addCriterion("trans_history in", values, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryNotIn(List<String> values) {
			addCriterion("trans_history not in", values, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryBetween(String value1, String value2) {
			addCriterion("trans_history between", value1, value2, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransHistoryNotBetween(String value1, String value2) {
			addCriterion("trans_history not between", value1, value2, "transHistory");
			return (Criteria) this;
		}

		public Criteria andTransGeneticIsNull() {
			addCriterion("trans_genetic is null");
			return (Criteria) this;
		}

		public Criteria andTransGeneticIsNotNull() {
			addCriterion("trans_genetic is not null");
			return (Criteria) this;
		}

		public Criteria andTransGeneticEqualTo(String value) {
			addCriterion("trans_genetic =", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticNotEqualTo(String value) {
			addCriterion("trans_genetic <>", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticGreaterThan(String value) {
			addCriterion("trans_genetic >", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticGreaterThanOrEqualTo(String value) {
			addCriterion("trans_genetic >=", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticLessThan(String value) {
			addCriterion("trans_genetic <", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticLessThanOrEqualTo(String value) {
			addCriterion("trans_genetic <=", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticLike(String value) {
			addCriterion("trans_genetic like", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticNotLike(String value) {
			addCriterion("trans_genetic not like", value, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticIn(List<String> values) {
			addCriterion("trans_genetic in", values, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticNotIn(List<String> values) {
			addCriterion("trans_genetic not in", values, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticBetween(String value1, String value2) {
			addCriterion("trans_genetic between", value1, value2, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andTransGeneticNotBetween(String value1, String value2) {
			addCriterion("trans_genetic not between", value1, value2, "transGenetic");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceIsNull() {
			addCriterion("available_Balance is null");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceIsNotNull() {
			addCriterion("available_Balance is not null");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceEqualTo(BigDecimal value) {
			addCriterion("available_Balance =", value, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceNotEqualTo(BigDecimal value) {
			addCriterion("available_Balance <>", value, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceGreaterThan(BigDecimal value) {
			addCriterion("available_Balance >", value, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("available_Balance >=", value, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceLessThan(BigDecimal value) {
			addCriterion("available_Balance <", value, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("available_Balance <=", value, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceIn(List<BigDecimal> values) {
			addCriterion("available_Balance in", values, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceNotIn(List<BigDecimal> values) {
			addCriterion("available_Balance not in", values, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("available_Balance between", value1, value2, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andAvailableBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("available_Balance not between", value1, value2, "availableBalance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceIsNull() {
			addCriterion("freeze_Blance is null");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceIsNotNull() {
			addCriterion("freeze_Blance is not null");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceEqualTo(BigDecimal value) {
			addCriterion("freeze_Blance =", value, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceNotEqualTo(BigDecimal value) {
			addCriterion("freeze_Blance <>", value, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceGreaterThan(BigDecimal value) {
			addCriterion("freeze_Blance >", value, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("freeze_Blance >=", value, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceLessThan(BigDecimal value) {
			addCriterion("freeze_Blance <", value, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("freeze_Blance <=", value, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceIn(List<BigDecimal> values) {
			addCriterion("freeze_Blance in", values, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceNotIn(List<BigDecimal> values) {
			addCriterion("freeze_Blance not in", values, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("freeze_Blance between", value1, value2, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andFreezeBlanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("freeze_Blance not between", value1, value2, "freezeBlance");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNull() {
			addCriterion("integral is null");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNotNull() {
			addCriterion("integral is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralEqualTo(Integer value) {
			addCriterion("integral =", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotEqualTo(Integer value) {
			addCriterion("integral <>", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThan(Integer value) {
			addCriterion("integral >", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("integral >=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThan(Integer value) {
			addCriterion("integral <", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("integral <=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralIn(List<Integer> values) {
			addCriterion("integral in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotIn(List<Integer> values) {
			addCriterion("integral not in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralBetween(Integer value1, Integer value2) {
			addCriterion("integral between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("integral not between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andGoldIsNull() {
			addCriterion("gold is null");
			return (Criteria) this;
		}

		public Criteria andGoldIsNotNull() {
			addCriterion("gold is not null");
			return (Criteria) this;
		}

		public Criteria andGoldEqualTo(Integer value) {
			addCriterion("gold =", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldNotEqualTo(Integer value) {
			addCriterion("gold <>", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldGreaterThan(Integer value) {
			addCriterion("gold >", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldGreaterThanOrEqualTo(Integer value) {
			addCriterion("gold >=", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldLessThan(Integer value) {
			addCriterion("gold <", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldLessThanOrEqualTo(Integer value) {
			addCriterion("gold <=", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldIn(List<Integer> values) {
			addCriterion("gold in", values, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldNotIn(List<Integer> values) {
			addCriterion("gold not in", values, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldBetween(Integer value1, Integer value2) {
			addCriterion("gold between", value1, value2, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldNotBetween(Integer value1, Integer value2) {
			addCriterion("gold not between", value1, value2, "gold");
			return (Criteria) this;
		}

		public Criteria andInvoiceIsNull() {
			addCriterion("invoice is null");
			return (Criteria) this;
		}

		public Criteria andInvoiceIsNotNull() {
			addCriterion("invoice is not null");
			return (Criteria) this;
		}

		public Criteria andInvoiceEqualTo(String value) {
			addCriterion("invoice =", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotEqualTo(String value) {
			addCriterion("invoice <>", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceGreaterThan(String value) {
			addCriterion("invoice >", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceGreaterThanOrEqualTo(String value) {
			addCriterion("invoice >=", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceLessThan(String value) {
			addCriterion("invoice <", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceLessThanOrEqualTo(String value) {
			addCriterion("invoice <=", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceLike(String value) {
			addCriterion("invoice like", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotLike(String value) {
			addCriterion("invoice not like", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceIn(List<String> values) {
			addCriterion("invoice in", values, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotIn(List<String> values) {
			addCriterion("invoice not in", values, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceBetween(String value1, String value2) {
			addCriterion("invoice between", value1, value2, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotBetween(String value1, String value2) {
			addCriterion("invoice not between", value1, value2, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIsNull() {
			addCriterion("invoice_Type is null");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIsNotNull() {
			addCriterion("invoice_Type is not null");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeEqualTo(Integer value) {
			addCriterion("invoice_Type =", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotEqualTo(Integer value) {
			addCriterion("invoice_Type <>", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeGreaterThan(Integer value) {
			addCriterion("invoice_Type >", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("invoice_Type >=", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLessThan(Integer value) {
			addCriterion("invoice_Type <", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLessThanOrEqualTo(Integer value) {
			addCriterion("invoice_Type <=", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIn(List<Integer> values) {
			addCriterion("invoice_Type in", values, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotIn(List<Integer> values) {
			addCriterion("invoice_Type not in", values, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeBetween(Integer value1, Integer value2) {
			addCriterion("invoice_Type between", value1, value2, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("invoice_Type not between", value1, value2, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdIsNull() {
			addCriterion("delivery_id is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdIsNotNull() {
			addCriterion("delivery_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdEqualTo(Long value) {
			addCriterion("delivery_id =", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdNotEqualTo(Long value) {
			addCriterion("delivery_id <>", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdGreaterThan(Long value) {
			addCriterion("delivery_id >", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdGreaterThanOrEqualTo(Long value) {
			addCriterion("delivery_id >=", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdLessThan(Long value) {
			addCriterion("delivery_id <", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdLessThanOrEqualTo(Long value) {
			addCriterion("delivery_id <=", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdIn(List<Long> values) {
			addCriterion("delivery_id in", values, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdNotIn(List<Long> values) {
			addCriterion("delivery_id not in", values, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdBetween(Long value1, Long value2) {
			addCriterion("delivery_id between", value1, value2, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdNotBetween(Long value1, Long value2) {
			addCriterion("delivery_id not between", value1, value2, "deliveryId");
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