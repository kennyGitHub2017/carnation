package com.sinco.carnation.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NavigationExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public NavigationExample() {
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

		public Criteria andLocationIsNull() {
			addCriterion("location is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("location is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(Integer value) {
			addCriterion("location =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(Integer value) {
			addCriterion("location <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(Integer value) {
			addCriterion("location >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(Integer value) {
			addCriterion("location >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(Integer value) {
			addCriterion("location <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(Integer value) {
			addCriterion("location <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<Integer> values) {
			addCriterion("location in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<Integer> values) {
			addCriterion("location not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(Integer value1, Integer value2) {
			addCriterion("location between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(Integer value1, Integer value2) {
			addCriterion("location not between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andNewWinIsNull() {
			addCriterion("new_win is null");
			return (Criteria) this;
		}

		public Criteria andNewWinIsNotNull() {
			addCriterion("new_win is not null");
			return (Criteria) this;
		}

		public Criteria andNewWinEqualTo(Integer value) {
			addCriterion("new_win =", value, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinNotEqualTo(Integer value) {
			addCriterion("new_win <>", value, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinGreaterThan(Integer value) {
			addCriterion("new_win >", value, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinGreaterThanOrEqualTo(Integer value) {
			addCriterion("new_win >=", value, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinLessThan(Integer value) {
			addCriterion("new_win <", value, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinLessThanOrEqualTo(Integer value) {
			addCriterion("new_win <=", value, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinIn(List<Integer> values) {
			addCriterion("new_win in", values, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinNotIn(List<Integer> values) {
			addCriterion("new_win not in", values, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinBetween(Integer value1, Integer value2) {
			addCriterion("new_win between", value1, value2, "newWin");
			return (Criteria) this;
		}

		public Criteria andNewWinNotBetween(Integer value1, Integer value2) {
			addCriterion("new_win not between", value1, value2, "newWin");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlIsNull() {
			addCriterion("original_url is null");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlIsNotNull() {
			addCriterion("original_url is not null");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlEqualTo(String value) {
			addCriterion("original_url =", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlNotEqualTo(String value) {
			addCriterion("original_url <>", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlGreaterThan(String value) {
			addCriterion("original_url >", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlGreaterThanOrEqualTo(String value) {
			addCriterion("original_url >=", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlLessThan(String value) {
			addCriterion("original_url <", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlLessThanOrEqualTo(String value) {
			addCriterion("original_url <=", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlLike(String value) {
			addCriterion("original_url like", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlNotLike(String value) {
			addCriterion("original_url not like", value, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlIn(List<String> values) {
			addCriterion("original_url in", values, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlNotIn(List<String> values) {
			addCriterion("original_url not in", values, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlBetween(String value1, String value2) {
			addCriterion("original_url between", value1, value2, "originalUrl");
			return (Criteria) this;
		}

		public Criteria andOriginalUrlNotBetween(String value1, String value2) {
			addCriterion("original_url not between", value1, value2, "originalUrl");
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

		public Criteria andSysNavIsNull() {
			addCriterion("sys_Nav is null");
			return (Criteria) this;
		}

		public Criteria andSysNavIsNotNull() {
			addCriterion("sys_Nav is not null");
			return (Criteria) this;
		}

		public Criteria andSysNavEqualTo(Boolean value) {
			addCriterion("sys_Nav =", value, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavNotEqualTo(Boolean value) {
			addCriterion("sys_Nav <>", value, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavGreaterThan(Boolean value) {
			addCriterion("sys_Nav >", value, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavGreaterThanOrEqualTo(Boolean value) {
			addCriterion("sys_Nav >=", value, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavLessThan(Boolean value) {
			addCriterion("sys_Nav <", value, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavLessThanOrEqualTo(Boolean value) {
			addCriterion("sys_Nav <=", value, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavIn(List<Boolean> values) {
			addCriterion("sys_Nav in", values, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavNotIn(List<Boolean> values) {
			addCriterion("sys_Nav not in", values, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavBetween(Boolean value1, Boolean value2) {
			addCriterion("sys_Nav between", value1, value2, "sysNav");
			return (Criteria) this;
		}

		public Criteria andSysNavNotBetween(Boolean value1, Boolean value2) {
			addCriterion("sys_Nav not between", value1, value2, "sysNav");
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

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIdIsNull() {
			addCriterion("type_id is null");
			return (Criteria) this;
		}

		public Criteria andTypeIdIsNotNull() {
			addCriterion("type_id is not null");
			return (Criteria) this;
		}

		public Criteria andTypeIdEqualTo(Long value) {
			addCriterion("type_id =", value, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdNotEqualTo(Long value) {
			addCriterion("type_id <>", value, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdGreaterThan(Long value) {
			addCriterion("type_id >", value, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
			addCriterion("type_id >=", value, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdLessThan(Long value) {
			addCriterion("type_id <", value, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdLessThanOrEqualTo(Long value) {
			addCriterion("type_id <=", value, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdIn(List<Long> values) {
			addCriterion("type_id in", values, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdNotIn(List<Long> values) {
			addCriterion("type_id not in", values, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdBetween(Long value1, Long value2) {
			addCriterion("type_id between", value1, value2, "typeId");
			return (Criteria) this;
		}

		public Criteria andTypeIdNotBetween(Long value1, Long value2) {
			addCriterion("type_id not between", value1, value2, "typeId");
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