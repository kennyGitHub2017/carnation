package com.sinco.carnation.goldEgg.model;

import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlodEggRecordExample extends AbstractExample<GlodEggRecordBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public GlodEggRecordExample() {
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

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
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

		public Criteria andCnAccountIsNull() {
			addCriterion("cn_account is null");
			return (Criteria) this;
		}

		public Criteria andCnAccountIsNotNull() {
			addCriterion("cn_account is not null");
			return (Criteria) this;
		}

		public Criteria andCnAccountEqualTo(String value) {
			addCriterion("cn_account =", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountNotEqualTo(String value) {
			addCriterion("cn_account <>", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountGreaterThan(String value) {
			addCriterion("cn_account >", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountGreaterThanOrEqualTo(String value) {
			addCriterion("cn_account >=", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountLessThan(String value) {
			addCriterion("cn_account <", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountLessThanOrEqualTo(String value) {
			addCriterion("cn_account <=", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountLike(String value) {
			addCriterion("cn_account like", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountNotLike(String value) {
			addCriterion("cn_account not like", value, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountIn(List<String> values) {
			addCriterion("cn_account in", values, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountNotIn(List<String> values) {
			addCriterion("cn_account not in", values, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountBetween(String value1, String value2) {
			addCriterion("cn_account between", value1, value2, "cnAccount");
			return (Criteria) this;
		}

		public Criteria andCnAccountNotBetween(String value1, String value2) {
			addCriterion("cn_account not between", value1, value2, "cnAccount");
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

		public Criteria andNickNameIsNull() {
			addCriterion("nick_name is null");
			return (Criteria) this;
		}

		public Criteria andNickNameIsNotNull() {
			addCriterion("nick_name is not null");
			return (Criteria) this;
		}

		public Criteria andNickNameEqualTo(String value) {
			addCriterion("nick_name =", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotEqualTo(String value) {
			addCriterion("nick_name <>", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThan(String value) {
			addCriterion("nick_name >", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThanOrEqualTo(String value) {
			addCriterion("nick_name >=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThan(String value) {
			addCriterion("nick_name <", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThanOrEqualTo(String value) {
			addCriterion("nick_name <=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLike(String value) {
			addCriterion("nick_name like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotLike(String value) {
			addCriterion("nick_name not like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameIn(List<String> values) {
			addCriterion("nick_name in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotIn(List<String> values) {
			addCriterion("nick_name not in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameBetween(String value1, String value2) {
			addCriterion("nick_name between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotBetween(String value1, String value2) {
			addCriterion("nick_name not between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andAppNameIsNull() {
			addCriterion("app_name is null");
			return (Criteria) this;
		}

		public Criteria andAppNameIsNotNull() {
			addCriterion("app_name is not null");
			return (Criteria) this;
		}

		public Criteria andAppNameEqualTo(String value) {
			addCriterion("app_name =", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameNotEqualTo(String value) {
			addCriterion("app_name <>", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameGreaterThan(String value) {
			addCriterion("app_name >", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameGreaterThanOrEqualTo(String value) {
			addCriterion("app_name >=", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameLessThan(String value) {
			addCriterion("app_name <", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameLessThanOrEqualTo(String value) {
			addCriterion("app_name <=", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameLike(String value) {
			addCriterion("app_name like", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameNotLike(String value) {
			addCriterion("app_name not like", value, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameIn(List<String> values) {
			addCriterion("app_name in", values, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameNotIn(List<String> values) {
			addCriterion("app_name not in", values, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameBetween(String value1, String value2) {
			addCriterion("app_name between", value1, value2, "appName");
			return (Criteria) this;
		}

		public Criteria andAppNameNotBetween(String value1, String value2) {
			addCriterion("app_name not between", value1, value2, "appName");
			return (Criteria) this;
		}

		public Criteria andEggIndexIsNull() {
			addCriterion("egg_index is null");
			return (Criteria) this;
		}

		public Criteria andEggIndexIsNotNull() {
			addCriterion("egg_index is not null");
			return (Criteria) this;
		}

		public Criteria andEggIndexEqualTo(Byte value) {
			addCriterion("egg_index =", value, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexNotEqualTo(Byte value) {
			addCriterion("egg_index <>", value, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexGreaterThan(Byte value) {
			addCriterion("egg_index >", value, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexGreaterThanOrEqualTo(Byte value) {
			addCriterion("egg_index >=", value, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexLessThan(Byte value) {
			addCriterion("egg_index <", value, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexLessThanOrEqualTo(Byte value) {
			addCriterion("egg_index <=", value, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexIn(List<Byte> values) {
			addCriterion("egg_index in", values, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexNotIn(List<Byte> values) {
			addCriterion("egg_index not in", values, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexBetween(Byte value1, Byte value2) {
			addCriterion("egg_index between", value1, value2, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andEggIndexNotBetween(Byte value1, Byte value2) {
			addCriterion("egg_index not between", value1, value2, "eggIndex");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdIsNull() {
			addCriterion("glod_egg_id is null");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdIsNotNull() {
			addCriterion("glod_egg_id is not null");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdEqualTo(Long value) {
			addCriterion("glod_egg_id =", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdNotEqualTo(Long value) {
			addCriterion("glod_egg_id <>", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdGreaterThan(Long value) {
			addCriterion("glod_egg_id >", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdGreaterThanOrEqualTo(Long value) {
			addCriterion("glod_egg_id >=", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdLessThan(Long value) {
			addCriterion("glod_egg_id <", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdLessThanOrEqualTo(Long value) {
			addCriterion("glod_egg_id <=", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdIn(List<Long> values) {
			addCriterion("glod_egg_id in", values, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdNotIn(List<Long> values) {
			addCriterion("glod_egg_id not in", values, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdBetween(Long value1, Long value2) {
			addCriterion("glod_egg_id between", value1, value2, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdNotBetween(Long value1, Long value2) {
			addCriterion("glod_egg_id not between", value1, value2, "glodEggId");
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