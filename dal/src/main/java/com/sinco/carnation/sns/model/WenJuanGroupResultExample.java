package com.sinco.carnation.sns.model;

import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WenJuanGroupResultExample extends AbstractExample<WenJuanGroupResultBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public WenJuanGroupResultExample() {
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

		public Criteria andStartScoreIsNull() {
			addCriterion("start_score is null");
			return (Criteria) this;
		}

		public Criteria andStartScoreIsNotNull() {
			addCriterion("start_score is not null");
			return (Criteria) this;
		}

		public Criteria andStartScoreEqualTo(Integer value) {
			addCriterion("start_score =", value, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreNotEqualTo(Integer value) {
			addCriterion("start_score <>", value, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreGreaterThan(Integer value) {
			addCriterion("start_score >", value, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("start_score >=", value, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreLessThan(Integer value) {
			addCriterion("start_score <", value, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreLessThanOrEqualTo(Integer value) {
			addCriterion("start_score <=", value, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreIn(List<Integer> values) {
			addCriterion("start_score in", values, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreNotIn(List<Integer> values) {
			addCriterion("start_score not in", values, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreBetween(Integer value1, Integer value2) {
			addCriterion("start_score between", value1, value2, "startScore");
			return (Criteria) this;
		}

		public Criteria andStartScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("start_score not between", value1, value2, "startScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreIsNull() {
			addCriterion("end_score is null");
			return (Criteria) this;
		}

		public Criteria andEndScoreIsNotNull() {
			addCriterion("end_score is not null");
			return (Criteria) this;
		}

		public Criteria andEndScoreEqualTo(Integer value) {
			addCriterion("end_score =", value, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreNotEqualTo(Integer value) {
			addCriterion("end_score <>", value, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreGreaterThan(Integer value) {
			addCriterion("end_score >", value, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("end_score >=", value, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreLessThan(Integer value) {
			addCriterion("end_score <", value, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreLessThanOrEqualTo(Integer value) {
			addCriterion("end_score <=", value, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreIn(List<Integer> values) {
			addCriterion("end_score in", values, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreNotIn(List<Integer> values) {
			addCriterion("end_score not in", values, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreBetween(Integer value1, Integer value2) {
			addCriterion("end_score between", value1, value2, "endScore");
			return (Criteria) this;
		}

		public Criteria andEndScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("end_score not between", value1, value2, "endScore");
			return (Criteria) this;
		}

		public Criteria andIsChronicIsNull() {
			addCriterion("is_chronic is null");
			return (Criteria) this;
		}

		public Criteria andIsChronicIsNotNull() {
			addCriterion("is_chronic is not null");
			return (Criteria) this;
		}

		public Criteria andIsChronicEqualTo(Boolean value) {
			addCriterion("is_chronic =", value, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicNotEqualTo(Boolean value) {
			addCriterion("is_chronic <>", value, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicGreaterThan(Boolean value) {
			addCriterion("is_chronic >", value, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_chronic >=", value, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicLessThan(Boolean value) {
			addCriterion("is_chronic <", value, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicLessThanOrEqualTo(Boolean value) {
			addCriterion("is_chronic <=", value, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicIn(List<Boolean> values) {
			addCriterion("is_chronic in", values, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicNotIn(List<Boolean> values) {
			addCriterion("is_chronic not in", values, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicBetween(Boolean value1, Boolean value2) {
			addCriterion("is_chronic between", value1, value2, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsChronicNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_chronic not between", value1, value2, "isChronic");
			return (Criteria) this;
		}

		public Criteria andIsHighIsNull() {
			addCriterion("is_high is null");
			return (Criteria) this;
		}

		public Criteria andIsHighIsNotNull() {
			addCriterion("is_high is not null");
			return (Criteria) this;
		}

		public Criteria andIsHighEqualTo(Boolean value) {
			addCriterion("is_high =", value, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighNotEqualTo(Boolean value) {
			addCriterion("is_high <>", value, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighGreaterThan(Boolean value) {
			addCriterion("is_high >", value, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_high >=", value, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighLessThan(Boolean value) {
			addCriterion("is_high <", value, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighLessThanOrEqualTo(Boolean value) {
			addCriterion("is_high <=", value, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighIn(List<Boolean> values) {
			addCriterion("is_high in", values, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighNotIn(List<Boolean> values) {
			addCriterion("is_high not in", values, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighBetween(Boolean value1, Boolean value2) {
			addCriterion("is_high between", value1, value2, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsHighNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_high not between", value1, value2, "isHigh");
			return (Criteria) this;
		}

		public Criteria andIsYjkIsNull() {
			addCriterion("is_yjk is null");
			return (Criteria) this;
		}

		public Criteria andIsYjkIsNotNull() {
			addCriterion("is_yjk is not null");
			return (Criteria) this;
		}

		public Criteria andIsYjkEqualTo(Boolean value) {
			addCriterion("is_yjk =", value, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkNotEqualTo(Boolean value) {
			addCriterion("is_yjk <>", value, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkGreaterThan(Boolean value) {
			addCriterion("is_yjk >", value, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_yjk >=", value, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkLessThan(Boolean value) {
			addCriterion("is_yjk <", value, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkLessThanOrEqualTo(Boolean value) {
			addCriterion("is_yjk <=", value, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkIn(List<Boolean> values) {
			addCriterion("is_yjk in", values, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkNotIn(List<Boolean> values) {
			addCriterion("is_yjk not in", values, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkBetween(Boolean value1, Boolean value2) {
			addCriterion("is_yjk between", value1, value2, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsYjkNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_yjk not between", value1, value2, "isYjk");
			return (Criteria) this;
		}

		public Criteria andIsHealthyIsNull() {
			addCriterion("is_healthy is null");
			return (Criteria) this;
		}

		public Criteria andIsHealthyIsNotNull() {
			addCriterion("is_healthy is not null");
			return (Criteria) this;
		}

		public Criteria andIsHealthyEqualTo(Boolean value) {
			addCriterion("is_healthy =", value, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyNotEqualTo(Boolean value) {
			addCriterion("is_healthy <>", value, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyGreaterThan(Boolean value) {
			addCriterion("is_healthy >", value, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_healthy >=", value, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyLessThan(Boolean value) {
			addCriterion("is_healthy <", value, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyLessThanOrEqualTo(Boolean value) {
			addCriterion("is_healthy <=", value, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyIn(List<Boolean> values) {
			addCriterion("is_healthy in", values, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyNotIn(List<Boolean> values) {
			addCriterion("is_healthy not in", values, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyBetween(Boolean value1, Boolean value2) {
			addCriterion("is_healthy between", value1, value2, "isHealthy");
			return (Criteria) this;
		}

		public Criteria andIsHealthyNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_healthy not between", value1, value2, "isHealthy");
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

		public Criteria andWjProposalIdIsNull() {
			addCriterion("wj_proposal_id is null");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdIsNotNull() {
			addCriterion("wj_proposal_id is not null");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdEqualTo(Long value) {
			addCriterion("wj_proposal_id =", value, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdNotEqualTo(Long value) {
			addCriterion("wj_proposal_id <>", value, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdGreaterThan(Long value) {
			addCriterion("wj_proposal_id >", value, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdGreaterThanOrEqualTo(Long value) {
			addCriterion("wj_proposal_id >=", value, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdLessThan(Long value) {
			addCriterion("wj_proposal_id <", value, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdLessThanOrEqualTo(Long value) {
			addCriterion("wj_proposal_id <=", value, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdIn(List<Long> values) {
			addCriterion("wj_proposal_id in", values, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdNotIn(List<Long> values) {
			addCriterion("wj_proposal_id not in", values, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdBetween(Long value1, Long value2) {
			addCriterion("wj_proposal_id between", value1, value2, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjProposalIdNotBetween(Long value1, Long value2) {
			addCriterion("wj_proposal_id not between", value1, value2, "wjProposalId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdIsNull() {
			addCriterion("wj_group_id is null");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdIsNotNull() {
			addCriterion("wj_group_id is not null");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdEqualTo(Long value) {
			addCriterion("wj_group_id =", value, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdNotEqualTo(Long value) {
			addCriterion("wj_group_id <>", value, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdGreaterThan(Long value) {
			addCriterion("wj_group_id >", value, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdGreaterThanOrEqualTo(Long value) {
			addCriterion("wj_group_id >=", value, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdLessThan(Long value) {
			addCriterion("wj_group_id <", value, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdLessThanOrEqualTo(Long value) {
			addCriterion("wj_group_id <=", value, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdIn(List<Long> values) {
			addCriterion("wj_group_id in", values, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdNotIn(List<Long> values) {
			addCriterion("wj_group_id not in", values, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdBetween(Long value1, Long value2) {
			addCriterion("wj_group_id between", value1, value2, "wjGroupId");
			return (Criteria) this;
		}

		public Criteria andWjGroupIdNotBetween(Long value1, Long value2) {
			addCriterion("wj_group_id not between", value1, value2, "wjGroupId");
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