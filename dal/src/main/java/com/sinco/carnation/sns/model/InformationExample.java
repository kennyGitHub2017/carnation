package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public InformationExample() {
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

		public Criteria andAuthorIsNull() {
			addCriterion("author is null");
			return (Criteria) this;
		}

		public Criteria andAuthorIsNotNull() {
			addCriterion("author is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorEqualTo(String value) {
			addCriterion("author =", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotEqualTo(String value) {
			addCriterion("author <>", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorGreaterThan(String value) {
			addCriterion("author >", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorGreaterThanOrEqualTo(String value) {
			addCriterion("author >=", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLessThan(String value) {
			addCriterion("author <", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLessThanOrEqualTo(String value) {
			addCriterion("author <=", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorLike(String value) {
			addCriterion("author like", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotLike(String value) {
			addCriterion("author not like", value, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorIn(List<String> values) {
			addCriterion("author in", values, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotIn(List<String> values) {
			addCriterion("author not in", values, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorBetween(String value1, String value2) {
			addCriterion("author between", value1, value2, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorNotBetween(String value1, String value2) {
			addCriterion("author not between", value1, value2, "author");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIsNull() {
			addCriterion("author_id is null");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIsNotNull() {
			addCriterion("author_id is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorIdEqualTo(Long value) {
			addCriterion("author_id =", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotEqualTo(Long value) {
			addCriterion("author_id <>", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdGreaterThan(Long value) {
			addCriterion("author_id >", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
			addCriterion("author_id >=", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdLessThan(Long value) {
			addCriterion("author_id <", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
			addCriterion("author_id <=", value, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdIn(List<Long> values) {
			addCriterion("author_id in", values, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotIn(List<Long> values) {
			addCriterion("author_id not in", values, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdBetween(Long value1, Long value2) {
			addCriterion("author_id between", value1, value2, "authorId");
			return (Criteria) this;
		}

		public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
			addCriterion("author_id not between", value1, value2, "authorId");
			return (Criteria) this;
		}

		public Criteria andClassidIsNull() {
			addCriterion("classid is null");
			return (Criteria) this;
		}

		public Criteria andClassidIsNotNull() {
			addCriterion("classid is not null");
			return (Criteria) this;
		}

		public Criteria andClassidEqualTo(Long value) {
			addCriterion("classid =", value, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidNotEqualTo(Long value) {
			addCriterion("classid <>", value, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidGreaterThan(Long value) {
			addCriterion("classid >", value, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidGreaterThanOrEqualTo(Long value) {
			addCriterion("classid >=", value, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidLessThan(Long value) {
			addCriterion("classid <", value, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidLessThanOrEqualTo(Long value) {
			addCriterion("classid <=", value, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidIn(List<Long> values) {
			addCriterion("classid in", values, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidNotIn(List<Long> values) {
			addCriterion("classid not in", values, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidBetween(Long value1, Long value2) {
			addCriterion("classid between", value1, value2, "classid");
			return (Criteria) this;
		}

		public Criteria andClassidNotBetween(Long value1, Long value2) {
			addCriterion("classid not between", value1, value2, "classid");
			return (Criteria) this;
		}

		public Criteria andClicktimesIsNull() {
			addCriterion("clicktimes is null");
			return (Criteria) this;
		}

		public Criteria andClicktimesIsNotNull() {
			addCriterion("clicktimes is not null");
			return (Criteria) this;
		}

		public Criteria andClicktimesEqualTo(Integer value) {
			addCriterion("clicktimes =", value, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesNotEqualTo(Integer value) {
			addCriterion("clicktimes <>", value, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesGreaterThan(Integer value) {
			addCriterion("clicktimes >", value, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesGreaterThanOrEqualTo(Integer value) {
			addCriterion("clicktimes >=", value, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesLessThan(Integer value) {
			addCriterion("clicktimes <", value, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesLessThanOrEqualTo(Integer value) {
			addCriterion("clicktimes <=", value, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesIn(List<Integer> values) {
			addCriterion("clicktimes in", values, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesNotIn(List<Integer> values) {
			addCriterion("clicktimes not in", values, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesBetween(Integer value1, Integer value2) {
			addCriterion("clicktimes between", value1, value2, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andClicktimesNotBetween(Integer value1, Integer value2) {
			addCriterion("clicktimes not between", value1, value2, "clicktimes");
			return (Criteria) this;
		}

		public Criteria andCoverIsNull() {
			addCriterion("cover is null");
			return (Criteria) this;
		}

		public Criteria andCoverIsNotNull() {
			addCriterion("cover is not null");
			return (Criteria) this;
		}

		public Criteria andCoverEqualTo(Long value) {
			addCriterion("cover =", value, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverNotEqualTo(Long value) {
			addCriterion("cover <>", value, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverGreaterThan(Long value) {
			addCriterion("cover >", value, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverGreaterThanOrEqualTo(Long value) {
			addCriterion("cover >=", value, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverLessThan(Long value) {
			addCriterion("cover <", value, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverLessThanOrEqualTo(Long value) {
			addCriterion("cover <=", value, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverIn(List<Long> values) {
			addCriterion("cover in", values, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverNotIn(List<Long> values) {
			addCriterion("cover not in", values, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverBetween(Long value1, Long value2) {
			addCriterion("cover between", value1, value2, "cover");
			return (Criteria) this;
		}

		public Criteria andCoverNotBetween(Long value1, Long value2) {
			addCriterion("cover not between", value1, value2, "cover");
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

		public Criteria andStoreIsNull() {
			addCriterion("store is null");
			return (Criteria) this;
		}

		public Criteria andStoreIsNotNull() {
			addCriterion("store is not null");
			return (Criteria) this;
		}

		public Criteria andStoreEqualTo(String value) {
			addCriterion("store =", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreNotEqualTo(String value) {
			addCriterion("store <>", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreGreaterThan(String value) {
			addCriterion("store >", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreGreaterThanOrEqualTo(String value) {
			addCriterion("store >=", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreLessThan(String value) {
			addCriterion("store <", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreLessThanOrEqualTo(String value) {
			addCriterion("store <=", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreLike(String value) {
			addCriterion("store like", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreNotLike(String value) {
			addCriterion("store not like", value, "store");
			return (Criteria) this;
		}

		public Criteria andStoreIn(List<String> values) {
			addCriterion("store in", values, "store");
			return (Criteria) this;
		}

		public Criteria andStoreNotIn(List<String> values) {
			addCriterion("store not in", values, "store");
			return (Criteria) this;
		}

		public Criteria andStoreBetween(String value1, String value2) {
			addCriterion("store between", value1, value2, "store");
			return (Criteria) this;
		}

		public Criteria andStoreNotBetween(String value1, String value2) {
			addCriterion("store not between", value1, value2, "store");
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

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andInfoSourceIsNull() {
			addCriterion("info_Source is null");
			return (Criteria) this;
		}

		public Criteria andInfoSourceIsNotNull() {
			addCriterion("info_Source is not null");
			return (Criteria) this;
		}

		public Criteria andInfoSourceEqualTo(String value) {
			addCriterion("info_Source =", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceNotEqualTo(String value) {
			addCriterion("info_Source <>", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceGreaterThan(String value) {
			addCriterion("info_Source >", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceGreaterThanOrEqualTo(String value) {
			addCriterion("info_Source >=", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceLessThan(String value) {
			addCriterion("info_Source <", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceLessThanOrEqualTo(String value) {
			addCriterion("info_Source <=", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceLike(String value) {
			addCriterion("info_Source like", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceNotLike(String value) {
			addCriterion("info_Source not like", value, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceIn(List<String> values) {
			addCriterion("info_Source in", values, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceNotIn(List<String> values) {
			addCriterion("info_Source not in", values, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceBetween(String value1, String value2) {
			addCriterion("info_Source between", value1, value2, "infoSource");
			return (Criteria) this;
		}

		public Criteria andInfoSourceNotBetween(String value1, String value2) {
			addCriterion("info_Source not between", value1, value2, "infoSource");
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

		public Criteria andSynopsisIsNull() {
			addCriterion("synopsis is null");
			return (Criteria) this;
		}

		public Criteria andSynopsisIsNotNull() {
			addCriterion("synopsis is not null");
			return (Criteria) this;
		}

		public Criteria andSynopsisEqualTo(String value) {
			addCriterion("synopsis =", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisNotEqualTo(String value) {
			addCriterion("synopsis <>", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisGreaterThan(String value) {
			addCriterion("synopsis >", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisGreaterThanOrEqualTo(String value) {
			addCriterion("synopsis >=", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisLessThan(String value) {
			addCriterion("synopsis <", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisLessThanOrEqualTo(String value) {
			addCriterion("synopsis <=", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisLike(String value) {
			addCriterion("synopsis like", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisNotLike(String value) {
			addCriterion("synopsis not like", value, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisIn(List<String> values) {
			addCriterion("synopsis in", values, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisNotIn(List<String> values) {
			addCriterion("synopsis not in", values, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisBetween(String value1, String value2) {
			addCriterion("synopsis between", value1, value2, "synopsis");
			return (Criteria) this;
		}

		public Criteria andSynopsisNotBetween(String value1, String value2) {
			addCriterion("synopsis not between", value1, value2, "synopsis");
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