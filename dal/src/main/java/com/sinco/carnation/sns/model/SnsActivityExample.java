package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SnsActivityExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SnsActivityExample() {
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

		public Criteria andImgIsNull() {
			addCriterion("img is null");
			return (Criteria) this;
		}

		public Criteria andImgIsNotNull() {
			addCriterion("img is not null");
			return (Criteria) this;
		}

		public Criteria andImgEqualTo(String value) {
			addCriterion("img =", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotEqualTo(String value) {
			addCriterion("img <>", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThan(String value) {
			addCriterion("img >", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThanOrEqualTo(String value) {
			addCriterion("img >=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThan(String value) {
			addCriterion("img <", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThanOrEqualTo(String value) {
			addCriterion("img <=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLike(String value) {
			addCriterion("img like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotLike(String value) {
			addCriterion("img not like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgIn(List<String> values) {
			addCriterion("img in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotIn(List<String> values) {
			addCriterion("img not in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgBetween(String value1, String value2) {
			addCriterion("img between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotBetween(String value1, String value2) {
			addCriterion("img not between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andEnrollBgIsNull() {
			addCriterion("enroll_bg is null");
			return (Criteria) this;
		}

		public Criteria andEnrollBgIsNotNull() {
			addCriterion("enroll_bg is not null");
			return (Criteria) this;
		}

		public Criteria andEnrollBgEqualTo(Date value) {
			addCriterion("enroll_bg =", value, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgNotEqualTo(Date value) {
			addCriterion("enroll_bg <>", value, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgGreaterThan(Date value) {
			addCriterion("enroll_bg >", value, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgGreaterThanOrEqualTo(Date value) {
			addCriterion("enroll_bg >=", value, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgLessThan(Date value) {
			addCriterion("enroll_bg <", value, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgLessThanOrEqualTo(Date value) {
			addCriterion("enroll_bg <=", value, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgIn(List<Date> values) {
			addCriterion("enroll_bg in", values, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgNotIn(List<Date> values) {
			addCriterion("enroll_bg not in", values, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgBetween(Date value1, Date value2) {
			addCriterion("enroll_bg between", value1, value2, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollBgNotBetween(Date value1, Date value2) {
			addCriterion("enroll_bg not between", value1, value2, "enrollBg");
			return (Criteria) this;
		}

		public Criteria andEnrollEndIsNull() {
			addCriterion("enroll_end is null");
			return (Criteria) this;
		}

		public Criteria andEnrollEndIsNotNull() {
			addCriterion("enroll_end is not null");
			return (Criteria) this;
		}

		public Criteria andEnrollEndEqualTo(Date value) {
			addCriterion("enroll_end =", value, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndNotEqualTo(Date value) {
			addCriterion("enroll_end <>", value, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndGreaterThan(Date value) {
			addCriterion("enroll_end >", value, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndGreaterThanOrEqualTo(Date value) {
			addCriterion("enroll_end >=", value, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndLessThan(Date value) {
			addCriterion("enroll_end <", value, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndLessThanOrEqualTo(Date value) {
			addCriterion("enroll_end <=", value, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndIn(List<Date> values) {
			addCriterion("enroll_end in", values, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndNotIn(List<Date> values) {
			addCriterion("enroll_end not in", values, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndBetween(Date value1, Date value2) {
			addCriterion("enroll_end between", value1, value2, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andEnrollEndNotBetween(Date value1, Date value2) {
			addCriterion("enroll_end not between", value1, value2, "enrollEnd");
			return (Criteria) this;
		}

		public Criteria andActBgIsNull() {
			addCriterion("act_bg is null");
			return (Criteria) this;
		}

		public Criteria andActBgIsNotNull() {
			addCriterion("act_bg is not null");
			return (Criteria) this;
		}

		public Criteria andActBgEqualTo(Date value) {
			addCriterion("act_bg =", value, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgNotEqualTo(Date value) {
			addCriterion("act_bg <>", value, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgGreaterThan(Date value) {
			addCriterion("act_bg >", value, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgGreaterThanOrEqualTo(Date value) {
			addCriterion("act_bg >=", value, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgLessThan(Date value) {
			addCriterion("act_bg <", value, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgLessThanOrEqualTo(Date value) {
			addCriterion("act_bg <=", value, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgIn(List<Date> values) {
			addCriterion("act_bg in", values, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgNotIn(List<Date> values) {
			addCriterion("act_bg not in", values, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgBetween(Date value1, Date value2) {
			addCriterion("act_bg between", value1, value2, "actBg");
			return (Criteria) this;
		}

		public Criteria andActBgNotBetween(Date value1, Date value2) {
			addCriterion("act_bg not between", value1, value2, "actBg");
			return (Criteria) this;
		}

		public Criteria andActEndIsNull() {
			addCriterion("act_end is null");
			return (Criteria) this;
		}

		public Criteria andActEndIsNotNull() {
			addCriterion("act_end is not null");
			return (Criteria) this;
		}

		public Criteria andActEndEqualTo(Date value) {
			addCriterion("act_end =", value, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndNotEqualTo(Date value) {
			addCriterion("act_end <>", value, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndGreaterThan(Date value) {
			addCriterion("act_end >", value, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndGreaterThanOrEqualTo(Date value) {
			addCriterion("act_end >=", value, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndLessThan(Date value) {
			addCriterion("act_end <", value, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndLessThanOrEqualTo(Date value) {
			addCriterion("act_end <=", value, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndIn(List<Date> values) {
			addCriterion("act_end in", values, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndNotIn(List<Date> values) {
			addCriterion("act_end not in", values, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndBetween(Date value1, Date value2) {
			addCriterion("act_end between", value1, value2, "actEnd");
			return (Criteria) this;
		}

		public Criteria andActEndNotBetween(Date value1, Date value2) {
			addCriterion("act_end not between", value1, value2, "actEnd");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNull() {
			addCriterion("area_id is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("area_id is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Long value) {
			addCriterion("area_id =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Long value) {
			addCriterion("area_id <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Long value) {
			addCriterion("area_id >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("area_id >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Long value) {
			addCriterion("area_id <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Long value) {
			addCriterion("area_id <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Long> values) {
			addCriterion("area_id in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Long> values) {
			addCriterion("area_id not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Long value1, Long value2) {
			addCriterion("area_id between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Long value1, Long value2) {
			addCriterion("area_id not between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andKeywordsIsNull() {
			addCriterion("keywords is null");
			return (Criteria) this;
		}

		public Criteria andKeywordsIsNotNull() {
			addCriterion("keywords is not null");
			return (Criteria) this;
		}

		public Criteria andKeywordsEqualTo(String value) {
			addCriterion("keywords =", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotEqualTo(String value) {
			addCriterion("keywords <>", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsGreaterThan(String value) {
			addCriterion("keywords >", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
			addCriterion("keywords >=", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsLessThan(String value) {
			addCriterion("keywords <", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsLessThanOrEqualTo(String value) {
			addCriterion("keywords <=", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsLike(String value) {
			addCriterion("keywords like", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotLike(String value) {
			addCriterion("keywords not like", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsIn(List<String> values) {
			addCriterion("keywords in", values, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotIn(List<String> values) {
			addCriterion("keywords not in", values, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsBetween(String value1, String value2) {
			addCriterion("keywords between", value1, value2, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotBetween(String value1, String value2) {
			addCriterion("keywords not between", value1, value2, "keywords");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNull() {
			addCriterion("priority is null");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNotNull() {
			addCriterion("priority is not null");
			return (Criteria) this;
		}

		public Criteria andPriorityEqualTo(Integer value) {
			addCriterion("priority =", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotEqualTo(Integer value) {
			addCriterion("priority <>", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThan(Integer value) {
			addCriterion("priority >", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
			addCriterion("priority >=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThan(Integer value) {
			addCriterion("priority <", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThanOrEqualTo(Integer value) {
			addCriterion("priority <=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityIn(List<Integer> values) {
			addCriterion("priority in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotIn(List<Integer> values) {
			addCriterion("priority not in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityBetween(Integer value1, Integer value2) {
			addCriterion("priority between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
			addCriterion("priority not between", value1, value2, "priority");
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

		public Criteria andDisplayIsNull() {
			addCriterion("display is null");
			return (Criteria) this;
		}

		public Criteria andDisplayIsNotNull() {
			addCriterion("display is not null");
			return (Criteria) this;
		}

		public Criteria andDisplayEqualTo(Boolean value) {
			addCriterion("display =", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotEqualTo(Boolean value) {
			addCriterion("display <>", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayGreaterThan(Boolean value) {
			addCriterion("display >", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayGreaterThanOrEqualTo(Boolean value) {
			addCriterion("display >=", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayLessThan(Boolean value) {
			addCriterion("display <", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayLessThanOrEqualTo(Boolean value) {
			addCriterion("display <=", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayIn(List<Boolean> values) {
			addCriterion("display in", values, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotIn(List<Boolean> values) {
			addCriterion("display not in", values, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayBetween(Boolean value1, Boolean value2) {
			addCriterion("display between", value1, value2, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotBetween(Boolean value1, Boolean value2) {
			addCriterion("display not between", value1, value2, "display");
			return (Criteria) this;
		}

		public Criteria andMarkIsNull() {
			addCriterion("mark is null");
			return (Criteria) this;
		}

		public Criteria andMarkIsNotNull() {
			addCriterion("mark is not null");
			return (Criteria) this;
		}

		public Criteria andMarkEqualTo(String value) {
			addCriterion("mark =", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotEqualTo(String value) {
			addCriterion("mark <>", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThan(String value) {
			addCriterion("mark >", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThanOrEqualTo(String value) {
			addCriterion("mark >=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThan(String value) {
			addCriterion("mark <", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThanOrEqualTo(String value) {
			addCriterion("mark <=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLike(String value) {
			addCriterion("mark like", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotLike(String value) {
			addCriterion("mark not like", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkIn(List<String> values) {
			addCriterion("mark in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotIn(List<String> values) {
			addCriterion("mark not in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkBetween(String value1, String value2) {
			addCriterion("mark between", value1, value2, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotBetween(String value1, String value2) {
			addCriterion("mark not between", value1, value2, "mark");
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

		public Criteria andActTypeIsNull() {
			addCriterion("act_type is null");
			return (Criteria) this;
		}

		public Criteria andActTypeIsNotNull() {
			addCriterion("act_type is not null");
			return (Criteria) this;
		}

		public Criteria andActTypeEqualTo(String value) {
			addCriterion("act_type =", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotEqualTo(String value) {
			addCriterion("act_type <>", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeGreaterThan(String value) {
			addCriterion("act_type >", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeGreaterThanOrEqualTo(String value) {
			addCriterion("act_type >=", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeLessThan(String value) {
			addCriterion("act_type <", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeLessThanOrEqualTo(String value) {
			addCriterion("act_type <=", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeLike(String value) {
			addCriterion("act_type like", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotLike(String value) {
			addCriterion("act_type not like", value, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeIn(List<String> values) {
			addCriterion("act_type in", values, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotIn(List<String> values) {
			addCriterion("act_type not in", values, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeBetween(String value1, String value2) {
			addCriterion("act_type between", value1, value2, "actType");
			return (Criteria) this;
		}

		public Criteria andActTypeNotBetween(String value1, String value2) {
			addCriterion("act_type not between", value1, value2, "actType");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
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