package com.sinco.carnation.sys.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccessoryExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public AccessoryExample() {
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

		public Criteria andExtIsNull() {
			addCriterion("ext is null");
			return (Criteria) this;
		}

		public Criteria andExtIsNotNull() {
			addCriterion("ext is not null");
			return (Criteria) this;
		}

		public Criteria andExtEqualTo(String value) {
			addCriterion("ext =", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtNotEqualTo(String value) {
			addCriterion("ext <>", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtGreaterThan(String value) {
			addCriterion("ext >", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtGreaterThanOrEqualTo(String value) {
			addCriterion("ext >=", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtLessThan(String value) {
			addCriterion("ext <", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtLessThanOrEqualTo(String value) {
			addCriterion("ext <=", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtLike(String value) {
			addCriterion("ext like", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtNotLike(String value) {
			addCriterion("ext not like", value, "ext");
			return (Criteria) this;
		}

		public Criteria andExtIn(List<String> values) {
			addCriterion("ext in", values, "ext");
			return (Criteria) this;
		}

		public Criteria andExtNotIn(List<String> values) {
			addCriterion("ext not in", values, "ext");
			return (Criteria) this;
		}

		public Criteria andExtBetween(String value1, String value2) {
			addCriterion("ext between", value1, value2, "ext");
			return (Criteria) this;
		}

		public Criteria andExtNotBetween(String value1, String value2) {
			addCriterion("ext not between", value1, value2, "ext");
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

		public Criteria andInfoIsNull() {
			addCriterion("info is null");
			return (Criteria) this;
		}

		public Criteria andInfoIsNotNull() {
			addCriterion("info is not null");
			return (Criteria) this;
		}

		public Criteria andInfoEqualTo(String value) {
			addCriterion("info =", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotEqualTo(String value) {
			addCriterion("info <>", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThan(String value) {
			addCriterion("info >", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThanOrEqualTo(String value) {
			addCriterion("info >=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThan(String value) {
			addCriterion("info <", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThanOrEqualTo(String value) {
			addCriterion("info <=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLike(String value) {
			addCriterion("info like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotLike(String value) {
			addCriterion("info not like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoIn(List<String> values) {
			addCriterion("info in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotIn(List<String> values) {
			addCriterion("info not in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoBetween(String value1, String value2) {
			addCriterion("info between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotBetween(String value1, String value2) {
			addCriterion("info not between", value1, value2, "info");
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

		public Criteria andPathIsNull() {
			addCriterion("path is null");
			return (Criteria) this;
		}

		public Criteria andPathIsNotNull() {
			addCriterion("path is not null");
			return (Criteria) this;
		}

		public Criteria andPathEqualTo(String value) {
			addCriterion("path =", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotEqualTo(String value) {
			addCriterion("path <>", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThan(String value) {
			addCriterion("path >", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThanOrEqualTo(String value) {
			addCriterion("path >=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThan(String value) {
			addCriterion("path <", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThanOrEqualTo(String value) {
			addCriterion("path <=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLike(String value) {
			addCriterion("path like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotLike(String value) {
			addCriterion("path not like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathIn(List<String> values) {
			addCriterion("path in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotIn(List<String> values) {
			addCriterion("path not in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathBetween(String value1, String value2) {
			addCriterion("path between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotBetween(String value1, String value2) {
			addCriterion("path not between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andSizeIsNull() {
			addCriterion("size is null");
			return (Criteria) this;
		}

		public Criteria andSizeIsNotNull() {
			addCriterion("size is not null");
			return (Criteria) this;
		}

		public Criteria andSizeEqualTo(BigDecimal value) {
			addCriterion("size =", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotEqualTo(BigDecimal value) {
			addCriterion("size <>", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeGreaterThan(BigDecimal value) {
			addCriterion("size >", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("size >=", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeLessThan(BigDecimal value) {
			addCriterion("size <", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("size <=", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeIn(List<BigDecimal> values) {
			addCriterion("size in", values, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotIn(List<BigDecimal> values) {
			addCriterion("size not in", values, "size");
			return (Criteria) this;
		}

		public Criteria andSizeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("size between", value1, value2, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("size not between", value1, value2, "size");
			return (Criteria) this;
		}

		public Criteria andWidthIsNull() {
			addCriterion("width is null");
			return (Criteria) this;
		}

		public Criteria andWidthIsNotNull() {
			addCriterion("width is not null");
			return (Criteria) this;
		}

		public Criteria andWidthEqualTo(Integer value) {
			addCriterion("width =", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotEqualTo(Integer value) {
			addCriterion("width <>", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThan(Integer value) {
			addCriterion("width >", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("width >=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThan(Integer value) {
			addCriterion("width <", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThanOrEqualTo(Integer value) {
			addCriterion("width <=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthIn(List<Integer> values) {
			addCriterion("width in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotIn(List<Integer> values) {
			addCriterion("width not in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthBetween(Integer value1, Integer value2) {
			addCriterion("width between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("width not between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andAlbumIdIsNull() {
			addCriterion("album_id is null");
			return (Criteria) this;
		}

		public Criteria andAlbumIdIsNotNull() {
			addCriterion("album_id is not null");
			return (Criteria) this;
		}

		public Criteria andAlbumIdEqualTo(Long value) {
			addCriterion("album_id =", value, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdNotEqualTo(Long value) {
			addCriterion("album_id <>", value, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdGreaterThan(Long value) {
			addCriterion("album_id >", value, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdGreaterThanOrEqualTo(Long value) {
			addCriterion("album_id >=", value, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdLessThan(Long value) {
			addCriterion("album_id <", value, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdLessThanOrEqualTo(Long value) {
			addCriterion("album_id <=", value, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdIn(List<Long> values) {
			addCriterion("album_id in", values, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdNotIn(List<Long> values) {
			addCriterion("album_id not in", values, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdBetween(Long value1, Long value2) {
			addCriterion("album_id between", value1, value2, "albumId");
			return (Criteria) this;
		}

		public Criteria andAlbumIdNotBetween(Long value1, Long value2) {
			addCriterion("album_id not between", value1, value2, "albumId");
			return (Criteria) this;
		}

		public Criteria andConfigIdIsNull() {
			addCriterion("config_id is null");
			return (Criteria) this;
		}

		public Criteria andConfigIdIsNotNull() {
			addCriterion("config_id is not null");
			return (Criteria) this;
		}

		public Criteria andConfigIdEqualTo(Long value) {
			addCriterion("config_id =", value, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdNotEqualTo(Long value) {
			addCriterion("config_id <>", value, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdGreaterThan(Long value) {
			addCriterion("config_id >", value, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdGreaterThanOrEqualTo(Long value) {
			addCriterion("config_id >=", value, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdLessThan(Long value) {
			addCriterion("config_id <", value, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdLessThanOrEqualTo(Long value) {
			addCriterion("config_id <=", value, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdIn(List<Long> values) {
			addCriterion("config_id in", values, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdNotIn(List<Long> values) {
			addCriterion("config_id not in", values, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdBetween(Long value1, Long value2) {
			addCriterion("config_id between", value1, value2, "configId");
			return (Criteria) this;
		}

		public Criteria andConfigIdNotBetween(Long value1, Long value2) {
			addCriterion("config_id not between", value1, value2, "configId");
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