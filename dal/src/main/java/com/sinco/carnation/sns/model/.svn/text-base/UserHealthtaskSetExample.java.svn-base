package com.sinco.carnation.sns.model;

import com.sinco.carnation.sns.bo.UserHealthtaskSetBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserHealthtaskSetExample extends AbstractExample<UserHealthtaskSetBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public UserHealthtaskSetExample() {
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

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public void setLimit(int count) {
		this.limit = String.valueOf(count);
	}

	public void setLimit(int offset, int rows) {
		this.limit = new StringBuilder().append(String.valueOf(offset)).append(",")
				.append(String.valueOf(rows)).toString();
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

		public Criteria andUserHealthtaskIdIsNull() {
			addCriterion("user_healthTask_id is null");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdIsNotNull() {
			addCriterion("user_healthTask_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdEqualTo(Long value) {
			addCriterion("user_healthTask_id =", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdNotEqualTo(Long value) {
			addCriterion("user_healthTask_id <>", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdGreaterThan(Long value) {
			addCriterion("user_healthTask_id >", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_healthTask_id >=", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdLessThan(Long value) {
			addCriterion("user_healthTask_id <", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdLessThanOrEqualTo(Long value) {
			addCriterion("user_healthTask_id <=", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdIn(List<Long> values) {
			addCriterion("user_healthTask_id in", values, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdNotIn(List<Long> values) {
			addCriterion("user_healthTask_id not in", values, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdBetween(Long value1, Long value2) {
			addCriterion("user_healthTask_id between", value1, value2, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdNotBetween(Long value1, Long value2) {
			addCriterion("user_healthTask_id not between", value1, value2, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andRemindTimeIsNull() {
			addCriterion("remind_time is null");
			return (Criteria) this;
		}

		public Criteria andRemindTimeIsNotNull() {
			addCriterion("remind_time is not null");
			return (Criteria) this;
		}

		public Criteria andRemindTimeEqualTo(String value) {
			addCriterion("remind_time =", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotEqualTo(String value) {
			addCriterion("remind_time <>", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeGreaterThan(String value) {
			addCriterion("remind_time >", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeGreaterThanOrEqualTo(String value) {
			addCriterion("remind_time >=", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeLessThan(String value) {
			addCriterion("remind_time <", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeLessThanOrEqualTo(String value) {
			addCriterion("remind_time <=", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeLike(String value) {
			addCriterion("remind_time like", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotLike(String value) {
			addCriterion("remind_time not like", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeIn(List<String> values) {
			addCriterion("remind_time in", values, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotIn(List<String> values) {
			addCriterion("remind_time not in", values, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeBetween(String value1, String value2) {
			addCriterion("remind_time between", value1, value2, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotBetween(String value1, String value2) {
			addCriterion("remind_time not between", value1, value2, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindWeekIsNull() {
			addCriterion("remind_week is null");
			return (Criteria) this;
		}

		public Criteria andRemindWeekIsNotNull() {
			addCriterion("remind_week is not null");
			return (Criteria) this;
		}

		public Criteria andRemindWeekEqualTo(String value) {
			addCriterion("remind_week =", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekNotEqualTo(String value) {
			addCriterion("remind_week <>", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekGreaterThan(String value) {
			addCriterion("remind_week >", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekGreaterThanOrEqualTo(String value) {
			addCriterion("remind_week >=", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekLessThan(String value) {
			addCriterion("remind_week <", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekLessThanOrEqualTo(String value) {
			addCriterion("remind_week <=", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekLike(String value) {
			addCriterion("remind_week like", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekNotLike(String value) {
			addCriterion("remind_week not like", value, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekIn(List<String> values) {
			addCriterion("remind_week in", values, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekNotIn(List<String> values) {
			addCriterion("remind_week not in", values, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekBetween(String value1, String value2) {
			addCriterion("remind_week between", value1, value2, "remindWeek");
			return (Criteria) this;
		}

		public Criteria andRemindWeekNotBetween(String value1, String value2) {
			addCriterion("remind_week not between", value1, value2, "remindWeek");
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

		public Criteria andIsDeletedIsNull() {
			addCriterion("is_deleted is null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIsNotNull() {
			addCriterion("is_deleted is not null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedEqualTo(Long value) {
			addCriterion("is_deleted =", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotEqualTo(Long value) {
			addCriterion("is_deleted <>", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThan(Long value) {
			addCriterion("is_deleted >", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThanOrEqualTo(Long value) {
			addCriterion("is_deleted >=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThan(Long value) {
			addCriterion("is_deleted <", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThanOrEqualTo(Long value) {
			addCriterion("is_deleted <=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIn(List<Long> values) {
			addCriterion("is_deleted in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotIn(List<Long> values) {
			addCriterion("is_deleted not in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedBetween(Long value1, Long value2) {
			addCriterion("is_deleted between", value1, value2, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotBetween(Long value1, Long value2) {
			addCriterion("is_deleted not between", value1, value2, "isDeleted");
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

		public Criteria andMonIsNull() {
			addCriterion("MON is null");
			return (Criteria) this;
		}

		public Criteria andMonIsNotNull() {
			addCriterion("MON is not null");
			return (Criteria) this;
		}

		public Criteria andMonEqualTo(Long value) {
			addCriterion("MON =", value, "mon");
			return (Criteria) this;
		}

		public Criteria andMonNotEqualTo(Long value) {
			addCriterion("MON <>", value, "mon");
			return (Criteria) this;
		}

		public Criteria andMonGreaterThan(Long value) {
			addCriterion("MON >", value, "mon");
			return (Criteria) this;
		}

		public Criteria andMonGreaterThanOrEqualTo(Long value) {
			addCriterion("MON >=", value, "mon");
			return (Criteria) this;
		}

		public Criteria andMonLessThan(Long value) {
			addCriterion("MON <", value, "mon");
			return (Criteria) this;
		}

		public Criteria andMonLessThanOrEqualTo(Long value) {
			addCriterion("MON <=", value, "mon");
			return (Criteria) this;
		}

		public Criteria andMonIn(List<Long> values) {
			addCriterion("MON in", values, "mon");
			return (Criteria) this;
		}

		public Criteria andMonNotIn(List<Long> values) {
			addCriterion("MON not in", values, "mon");
			return (Criteria) this;
		}

		public Criteria andMonBetween(Long value1, Long value2) {
			addCriterion("MON between", value1, value2, "mon");
			return (Criteria) this;
		}

		public Criteria andMonNotBetween(Long value1, Long value2) {
			addCriterion("MON not between", value1, value2, "mon");
			return (Criteria) this;
		}

		public Criteria andTueIsNull() {
			addCriterion("TUE is null");
			return (Criteria) this;
		}

		public Criteria andTueIsNotNull() {
			addCriterion("TUE is not null");
			return (Criteria) this;
		}

		public Criteria andTueEqualTo(Long value) {
			addCriterion("TUE =", value, "tue");
			return (Criteria) this;
		}

		public Criteria andTueNotEqualTo(Long value) {
			addCriterion("TUE <>", value, "tue");
			return (Criteria) this;
		}

		public Criteria andTueGreaterThan(Long value) {
			addCriterion("TUE >", value, "tue");
			return (Criteria) this;
		}

		public Criteria andTueGreaterThanOrEqualTo(Long value) {
			addCriterion("TUE >=", value, "tue");
			return (Criteria) this;
		}

		public Criteria andTueLessThan(Long value) {
			addCriterion("TUE <", value, "tue");
			return (Criteria) this;
		}

		public Criteria andTueLessThanOrEqualTo(Long value) {
			addCriterion("TUE <=", value, "tue");
			return (Criteria) this;
		}

		public Criteria andTueIn(List<Long> values) {
			addCriterion("TUE in", values, "tue");
			return (Criteria) this;
		}

		public Criteria andTueNotIn(List<Long> values) {
			addCriterion("TUE not in", values, "tue");
			return (Criteria) this;
		}

		public Criteria andTueBetween(Long value1, Long value2) {
			addCriterion("TUE between", value1, value2, "tue");
			return (Criteria) this;
		}

		public Criteria andTueNotBetween(Long value1, Long value2) {
			addCriterion("TUE not between", value1, value2, "tue");
			return (Criteria) this;
		}

		public Criteria andWedIsNull() {
			addCriterion("WED is null");
			return (Criteria) this;
		}

		public Criteria andWedIsNotNull() {
			addCriterion("WED is not null");
			return (Criteria) this;
		}

		public Criteria andWedEqualTo(Long value) {
			addCriterion("WED =", value, "wed");
			return (Criteria) this;
		}

		public Criteria andWedNotEqualTo(Long value) {
			addCriterion("WED <>", value, "wed");
			return (Criteria) this;
		}

		public Criteria andWedGreaterThan(Long value) {
			addCriterion("WED >", value, "wed");
			return (Criteria) this;
		}

		public Criteria andWedGreaterThanOrEqualTo(Long value) {
			addCriterion("WED >=", value, "wed");
			return (Criteria) this;
		}

		public Criteria andWedLessThan(Long value) {
			addCriterion("WED <", value, "wed");
			return (Criteria) this;
		}

		public Criteria andWedLessThanOrEqualTo(Long value) {
			addCriterion("WED <=", value, "wed");
			return (Criteria) this;
		}

		public Criteria andWedIn(List<Long> values) {
			addCriterion("WED in", values, "wed");
			return (Criteria) this;
		}

		public Criteria andWedNotIn(List<Long> values) {
			addCriterion("WED not in", values, "wed");
			return (Criteria) this;
		}

		public Criteria andWedBetween(Long value1, Long value2) {
			addCriterion("WED between", value1, value2, "wed");
			return (Criteria) this;
		}

		public Criteria andWedNotBetween(Long value1, Long value2) {
			addCriterion("WED not between", value1, value2, "wed");
			return (Criteria) this;
		}

		public Criteria andThuIsNull() {
			addCriterion("THU is null");
			return (Criteria) this;
		}

		public Criteria andThuIsNotNull() {
			addCriterion("THU is not null");
			return (Criteria) this;
		}

		public Criteria andThuEqualTo(Long value) {
			addCriterion("THU =", value, "thu");
			return (Criteria) this;
		}

		public Criteria andThuNotEqualTo(Long value) {
			addCriterion("THU <>", value, "thu");
			return (Criteria) this;
		}

		public Criteria andThuGreaterThan(Long value) {
			addCriterion("THU >", value, "thu");
			return (Criteria) this;
		}

		public Criteria andThuGreaterThanOrEqualTo(Long value) {
			addCriterion("THU >=", value, "thu");
			return (Criteria) this;
		}

		public Criteria andThuLessThan(Long value) {
			addCriterion("THU <", value, "thu");
			return (Criteria) this;
		}

		public Criteria andThuLessThanOrEqualTo(Long value) {
			addCriterion("THU <=", value, "thu");
			return (Criteria) this;
		}

		public Criteria andThuIn(List<Long> values) {
			addCriterion("THU in", values, "thu");
			return (Criteria) this;
		}

		public Criteria andThuNotIn(List<Long> values) {
			addCriterion("THU not in", values, "thu");
			return (Criteria) this;
		}

		public Criteria andThuBetween(Long value1, Long value2) {
			addCriterion("THU between", value1, value2, "thu");
			return (Criteria) this;
		}

		public Criteria andThuNotBetween(Long value1, Long value2) {
			addCriterion("THU not between", value1, value2, "thu");
			return (Criteria) this;
		}

		public Criteria andFriIsNull() {
			addCriterion("FRI is null");
			return (Criteria) this;
		}

		public Criteria andFriIsNotNull() {
			addCriterion("FRI is not null");
			return (Criteria) this;
		}

		public Criteria andFriEqualTo(Long value) {
			addCriterion("FRI =", value, "fri");
			return (Criteria) this;
		}

		public Criteria andFriNotEqualTo(Long value) {
			addCriterion("FRI <>", value, "fri");
			return (Criteria) this;
		}

		public Criteria andFriGreaterThan(Long value) {
			addCriterion("FRI >", value, "fri");
			return (Criteria) this;
		}

		public Criteria andFriGreaterThanOrEqualTo(Long value) {
			addCriterion("FRI >=", value, "fri");
			return (Criteria) this;
		}

		public Criteria andFriLessThan(Long value) {
			addCriterion("FRI <", value, "fri");
			return (Criteria) this;
		}

		public Criteria andFriLessThanOrEqualTo(Long value) {
			addCriterion("FRI <=", value, "fri");
			return (Criteria) this;
		}

		public Criteria andFriIn(List<Long> values) {
			addCriterion("FRI in", values, "fri");
			return (Criteria) this;
		}

		public Criteria andFriNotIn(List<Long> values) {
			addCriterion("FRI not in", values, "fri");
			return (Criteria) this;
		}

		public Criteria andFriBetween(Long value1, Long value2) {
			addCriterion("FRI between", value1, value2, "fri");
			return (Criteria) this;
		}

		public Criteria andFriNotBetween(Long value1, Long value2) {
			addCriterion("FRI not between", value1, value2, "fri");
			return (Criteria) this;
		}

		public Criteria andSatIsNull() {
			addCriterion("SAT is null");
			return (Criteria) this;
		}

		public Criteria andSatIsNotNull() {
			addCriterion("SAT is not null");
			return (Criteria) this;
		}

		public Criteria andSatEqualTo(Long value) {
			addCriterion("SAT =", value, "sat");
			return (Criteria) this;
		}

		public Criteria andSatNotEqualTo(Long value) {
			addCriterion("SAT <>", value, "sat");
			return (Criteria) this;
		}

		public Criteria andSatGreaterThan(Long value) {
			addCriterion("SAT >", value, "sat");
			return (Criteria) this;
		}

		public Criteria andSatGreaterThanOrEqualTo(Long value) {
			addCriterion("SAT >=", value, "sat");
			return (Criteria) this;
		}

		public Criteria andSatLessThan(Long value) {
			addCriterion("SAT <", value, "sat");
			return (Criteria) this;
		}

		public Criteria andSatLessThanOrEqualTo(Long value) {
			addCriterion("SAT <=", value, "sat");
			return (Criteria) this;
		}

		public Criteria andSatIn(List<Long> values) {
			addCriterion("SAT in", values, "sat");
			return (Criteria) this;
		}

		public Criteria andSatNotIn(List<Long> values) {
			addCriterion("SAT not in", values, "sat");
			return (Criteria) this;
		}

		public Criteria andSatBetween(Long value1, Long value2) {
			addCriterion("SAT between", value1, value2, "sat");
			return (Criteria) this;
		}

		public Criteria andSatNotBetween(Long value1, Long value2) {
			addCriterion("SAT not between", value1, value2, "sat");
			return (Criteria) this;
		}

		public Criteria andSunIsNull() {
			addCriterion("SUN is null");
			return (Criteria) this;
		}

		public Criteria andSunIsNotNull() {
			addCriterion("SUN is not null");
			return (Criteria) this;
		}

		public Criteria andSunEqualTo(Long value) {
			addCriterion("SUN =", value, "sun");
			return (Criteria) this;
		}

		public Criteria andSunNotEqualTo(Long value) {
			addCriterion("SUN <>", value, "sun");
			return (Criteria) this;
		}

		public Criteria andSunGreaterThan(Long value) {
			addCriterion("SUN >", value, "sun");
			return (Criteria) this;
		}

		public Criteria andSunGreaterThanOrEqualTo(Long value) {
			addCriterion("SUN >=", value, "sun");
			return (Criteria) this;
		}

		public Criteria andSunLessThan(Long value) {
			addCriterion("SUN <", value, "sun");
			return (Criteria) this;
		}

		public Criteria andSunLessThanOrEqualTo(Long value) {
			addCriterion("SUN <=", value, "sun");
			return (Criteria) this;
		}

		public Criteria andSunIn(List<Long> values) {
			addCriterion("SUN in", values, "sun");
			return (Criteria) this;
		}

		public Criteria andSunNotIn(List<Long> values) {
			addCriterion("SUN not in", values, "sun");
			return (Criteria) this;
		}

		public Criteria andSunBetween(Long value1, Long value2) {
			addCriterion("SUN between", value1, value2, "sun");
			return (Criteria) this;
		}

		public Criteria andSunNotBetween(Long value1, Long value2) {
			addCriterion("SUN not between", value1, value2, "sun");
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