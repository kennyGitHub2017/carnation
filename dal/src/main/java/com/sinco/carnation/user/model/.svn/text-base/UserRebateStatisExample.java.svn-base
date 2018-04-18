package com.sinco.carnation.user.model;

import com.sinco.carnation.user.bo.UserRebateStatisBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRebateStatisExample extends AbstractExample<UserRebateStatisBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public UserRebateStatisExample() {
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

		public Criteria andStatisTypeIsNull() {
			addCriterion("statis_type is null");
			return (Criteria) this;
		}

		public Criteria andStatisTypeIsNotNull() {
			addCriterion("statis_type is not null");
			return (Criteria) this;
		}

		public Criteria andStatisTypeEqualTo(String value) {
			addCriterion("statis_type =", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeNotEqualTo(String value) {
			addCriterion("statis_type <>", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeGreaterThan(String value) {
			addCriterion("statis_type >", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeGreaterThanOrEqualTo(String value) {
			addCriterion("statis_type >=", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeLessThan(String value) {
			addCriterion("statis_type <", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeLessThanOrEqualTo(String value) {
			addCriterion("statis_type <=", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeLike(String value) {
			addCriterion("statis_type like", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeNotLike(String value) {
			addCriterion("statis_type not like", value, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeIn(List<String> values) {
			addCriterion("statis_type in", values, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeNotIn(List<String> values) {
			addCriterion("statis_type not in", values, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeBetween(String value1, String value2) {
			addCriterion("statis_type between", value1, value2, "statisType");
			return (Criteria) this;
		}

		public Criteria andStatisTypeNotBetween(String value1, String value2) {
			addCriterion("statis_type not between", value1, value2, "statisType");
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

		public Criteria andRebateMemberIsNull() {
			addCriterion("rebate_member is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberIsNotNull() {
			addCriterion("rebate_member is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberEqualTo(BigDecimal value) {
			addCriterion("rebate_member =", value, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member <>", value, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberGreaterThan(BigDecimal value) {
			addCriterion("rebate_member >", value, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member >=", value, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberLessThan(BigDecimal value) {
			addCriterion("rebate_member <", value, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member <=", value, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberIn(List<BigDecimal> values) {
			addCriterion("rebate_member in", values, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member not in", values, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member between", value1, value2, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member not between", value1, value2, "rebateMember");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstIsNull() {
			addCriterion("rebate_member_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstIsNotNull() {
			addCriterion("rebate_member_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_member_first =", value, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member_first <>", value, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_member_first >", value, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_first >=", value, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstLessThan(BigDecimal value) {
			addCriterion("rebate_member_first <", value, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_first <=", value, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_member_first in", values, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member_first not in", values, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_first between", value1, value2, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_first not between", value1, value2, "rebateMemberFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondIsNull() {
			addCriterion("rebate_member_second is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondIsNotNull() {
			addCriterion("rebate_member_second is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondEqualTo(BigDecimal value) {
			addCriterion("rebate_member_second =", value, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member_second <>", value, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondGreaterThan(BigDecimal value) {
			addCriterion("rebate_member_second >", value, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_second >=", value, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondLessThan(BigDecimal value) {
			addCriterion("rebate_member_second <", value, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_second <=", value, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondIn(List<BigDecimal> values) {
			addCriterion("rebate_member_second in", values, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member_second not in", values, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_second between", value1, value2, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberSecondNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_second not between", value1, value2, "rebateMemberSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdIsNull() {
			addCriterion("rebate_member_third is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdIsNotNull() {
			addCriterion("rebate_member_third is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdEqualTo(BigDecimal value) {
			addCriterion("rebate_member_third =", value, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member_third <>", value, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdGreaterThan(BigDecimal value) {
			addCriterion("rebate_member_third >", value, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_third >=", value, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdLessThan(BigDecimal value) {
			addCriterion("rebate_member_third <", value, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_third <=", value, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdIn(List<BigDecimal> values) {
			addCriterion("rebate_member_third in", values, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member_third not in", values, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_third between", value1, value2, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberThirdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_third not between", value1, value2, "rebateMemberThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerIsNull() {
			addCriterion("rebate_binding_seller is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerIsNotNull() {
			addCriterion("rebate_binding_seller is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller =", value, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller <>", value, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_seller >", value, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller >=", value, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerLessThan(BigDecimal value) {
			addCriterion("rebate_binding_seller <", value, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller <=", value, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller in", values, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller not in", values, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller between", value1, value2, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller not between", value1, value2, "rebateBindingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstIsNull() {
			addCriterion("rebate_binding_seller_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstIsNotNull() {
			addCriterion("rebate_binding_seller_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_first =", value, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_first <>", value, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_seller_first >", value, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_first >=", value, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstLessThan(BigDecimal value) {
			addCriterion("rebate_binding_seller_first <", value, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_first <=", value, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller_first in", values, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller_first not in", values, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller_first between", value1, value2, "rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller_first not between", value1, value2,
					"rebateBindingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondIsNull() {
			addCriterion("rebate_binding_seller_second is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondIsNotNull() {
			addCriterion("rebate_binding_seller_second is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_second =", value, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_second <>", value, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_seller_second >", value, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_second >=", value, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondLessThan(BigDecimal value) {
			addCriterion("rebate_binding_seller_second <", value, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_second <=", value, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller_second in", values, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller_second not in", values, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller_second between", value1, value2, "rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerSecondNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller_second not between", value1, value2,
					"rebateBindingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdIsNull() {
			addCriterion("rebate_binding_seller_third is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdIsNotNull() {
			addCriterion("rebate_binding_seller_third is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_third =", value, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_third <>", value, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_seller_third >", value, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_third >=", value, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdLessThan(BigDecimal value) {
			addCriterion("rebate_binding_seller_third <", value, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_seller_third <=", value, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller_third in", values, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_seller_third not in", values, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller_third between", value1, value2, "rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateBindingSellerThirdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_seller_third not between", value1, value2,
					"rebateBindingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerIsNull() {
			addCriterion("rebate_spending_seller is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerIsNotNull() {
			addCriterion("rebate_spending_seller is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller =", value, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller <>", value, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_seller >", value, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller >=", value, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerLessThan(BigDecimal value) {
			addCriterion("rebate_spending_seller <", value, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller <=", value, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller in", values, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller not in", values, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller between", value1, value2, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller not between", value1, value2, "rebateSpendingSeller");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstIsNull() {
			addCriterion("rebate_spending_seller_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstIsNotNull() {
			addCriterion("rebate_spending_seller_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_first =", value, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_first <>", value, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_seller_first >", value, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_first >=", value, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstLessThan(BigDecimal value) {
			addCriterion("rebate_spending_seller_first <", value, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_first <=", value, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller_first in", values, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller_first not in", values, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller_first between", value1, value2, "rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller_first not between", value1, value2,
					"rebateSpendingSellerFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondIsNull() {
			addCriterion("rebate_spending_seller_second is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondIsNotNull() {
			addCriterion("rebate_spending_seller_second is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_second =", value, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_second <>", value, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_seller_second >", value, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_second >=", value, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondLessThan(BigDecimal value) {
			addCriterion("rebate_spending_seller_second <", value, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_second <=", value, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller_second in", values, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller_second not in", values, "rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller_second between", value1, value2,
					"rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerSecondNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller_second not between", value1, value2,
					"rebateSpendingSellerSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdIsNull() {
			addCriterion("rebate_spending_seller_third is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdIsNotNull() {
			addCriterion("rebate_spending_seller_third is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_third =", value, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_third <>", value, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_seller_third >", value, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_third >=", value, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdLessThan(BigDecimal value) {
			addCriterion("rebate_spending_seller_third <", value, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_seller_third <=", value, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller_third in", values, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_seller_third not in", values, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller_third between", value1, value2, "rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingSellerThirdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_seller_third not between", value1, value2,
					"rebateSpendingSellerThird");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorIsNull() {
			addCriterion("rebate_spending_district_operator is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorIsNotNull() {
			addCriterion("rebate_spending_district_operator is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator =", value, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator <>", value, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_district_operator >", value, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator >=", value, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorLessThan(BigDecimal value) {
			addCriterion("rebate_spending_district_operator <", value, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator <=", value, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_district_operator in", values, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_district_operator not in", values, "rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_district_operator between", value1, value2,
					"rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_district_operator not between", value1, value2,
					"rebateSpendingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstIsNull() {
			addCriterion("rebate_spending_district_operator_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstIsNotNull() {
			addCriterion("rebate_spending_district_operator_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator_first =", value,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator_first <>", value,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_district_operator_first >", value,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator_first >=", value,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstLessThan(BigDecimal value) {
			addCriterion("rebate_spending_district_operator_first <", value,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_district_operator_first <=", value,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_district_operator_first in", values,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_district_operator_first not in", values,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_district_operator_first between", value1, value2,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingDistrictOperatorFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_district_operator_first not between", value1, value2,
					"rebateSpendingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorIsNull() {
			addCriterion("rebate_spending_city_operator is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorIsNotNull() {
			addCriterion("rebate_spending_city_operator is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator =", value, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator <>", value, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_city_operator >", value, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator >=", value, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorLessThan(BigDecimal value) {
			addCriterion("rebate_spending_city_operator <", value, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator <=", value, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_city_operator in", values, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_city_operator not in", values, "rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_city_operator between", value1, value2,
					"rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_city_operator not between", value1, value2,
					"rebateSpendingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstIsNull() {
			addCriterion("rebate_spending_city_operator_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstIsNotNull() {
			addCriterion("rebate_spending_city_operator_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator_first =", value, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator_first <>", value, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_spending_city_operator_first >", value, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator_first >=", value, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstLessThan(BigDecimal value) {
			addCriterion("rebate_spending_city_operator_first <", value, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_spending_city_operator_first <=", value, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_city_operator_first in", values, "rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_spending_city_operator_first not in", values,
					"rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_city_operator_first between", value1, value2,
					"rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSpendingCityOperatorFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_spending_city_operator_first not between", value1, value2,
					"rebateSpendingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorIsNull() {
			addCriterion("rebate_binding_district_operator is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorIsNotNull() {
			addCriterion("rebate_binding_district_operator is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator =", value, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator <>", value, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_district_operator >", value, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator >=", value, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorLessThan(BigDecimal value) {
			addCriterion("rebate_binding_district_operator <", value, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator <=", value, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_district_operator in", values, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_district_operator not in", values, "rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_district_operator between", value1, value2,
					"rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_district_operator not between", value1, value2,
					"rebateBindingDistrictOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstIsNull() {
			addCriterion("rebate_binding_district_operator_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstIsNotNull() {
			addCriterion("rebate_binding_district_operator_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator_first =", value,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator_first <>", value,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_district_operator_first >", value,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator_first >=", value,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstLessThan(BigDecimal value) {
			addCriterion("rebate_binding_district_operator_first <", value,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_district_operator_first <=", value,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_district_operator_first in", values,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_district_operator_first not in", values,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_district_operator_first between", value1, value2,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingDistrictOperatorFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_district_operator_first not between", value1, value2,
					"rebateBindingDistrictOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorIsNull() {
			addCriterion("rebate_binding_city_operator is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorIsNotNull() {
			addCriterion("rebate_binding_city_operator is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator =", value, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator <>", value, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_city_operator >", value, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator >=", value, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorLessThan(BigDecimal value) {
			addCriterion("rebate_binding_city_operator <", value, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator <=", value, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_city_operator in", values, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_city_operator not in", values, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_city_operator between", value1, value2, "rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_city_operator not between", value1, value2,
					"rebateBindingCityOperator");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstIsNull() {
			addCriterion("rebate_binding_city_operator_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstIsNotNull() {
			addCriterion("rebate_binding_city_operator_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator_first =", value, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator_first <>", value, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_binding_city_operator_first >", value, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator_first >=", value, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstLessThan(BigDecimal value) {
			addCriterion("rebate_binding_city_operator_first <", value, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_binding_city_operator_first <=", value, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_city_operator_first in", values, "rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_binding_city_operator_first not in", values,
					"rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_city_operator_first between", value1, value2,
					"rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateBindingCityOperatorFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_binding_city_operator_first not between", value1, value2,
					"rebateBindingCityOperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateIsNull() {
			addCriterion("repeat_rebate is null");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateIsNotNull() {
			addCriterion("repeat_rebate is not null");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateEqualTo(BigDecimal value) {
			addCriterion("repeat_rebate =", value, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateNotEqualTo(BigDecimal value) {
			addCriterion("repeat_rebate <>", value, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateGreaterThan(BigDecimal value) {
			addCriterion("repeat_rebate >", value, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("repeat_rebate >=", value, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateLessThan(BigDecimal value) {
			addCriterion("repeat_rebate <", value, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("repeat_rebate <=", value, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateIn(List<BigDecimal> values) {
			addCriterion("repeat_rebate in", values, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateNotIn(List<BigDecimal> values) {
			addCriterion("repeat_rebate not in", values, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("repeat_rebate between", value1, value2, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRepeatRebateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("repeat_rebate not between", value1, value2, "repeatRebate");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierIsNull() {
			addCriterion("rebate_supplier is null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierIsNotNull() {
			addCriterion("rebate_supplier is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier =", value, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierNotEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier <>", value, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierGreaterThan(BigDecimal value) {
			addCriterion("rebate_supplier >", value, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier >=", value, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierLessThan(BigDecimal value) {
			addCriterion("rebate_supplier <", value, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier <=", value, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier in", values, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierNotIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier not in", values, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier between", value1, value2, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier not between", value1, value2, "rebateSupplier");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstIsNull() {
			addCriterion("rebate_supplier_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstIsNotNull() {
			addCriterion("rebate_supplier_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_first =", value, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_first <>", value, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_supplier_first >", value, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_first >=", value, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstLessThan(BigDecimal value) {
			addCriterion("rebate_supplier_first <", value, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_first <=", value, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier_first in", values, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier_first not in", values, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier_first between", value1, value2, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier_first not between", value1, value2, "rebateSupplierFirst");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondIsNull() {
			addCriterion("rebate_supplier_second is null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondIsNotNull() {
			addCriterion("rebate_supplier_second is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_second =", value, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondNotEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_second <>", value, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondGreaterThan(BigDecimal value) {
			addCriterion("rebate_supplier_second >", value, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_second >=", value, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondLessThan(BigDecimal value) {
			addCriterion("rebate_supplier_second <", value, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_second <=", value, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier_second in", values, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondNotIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier_second not in", values, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier_second between", value1, value2, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierSecondNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier_second not between", value1, value2, "rebateSupplierSecond");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdIsNull() {
			addCriterion("rebate_supplier_third is null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdIsNotNull() {
			addCriterion("rebate_supplier_third is not null");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_third =", value, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdNotEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_third <>", value, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdGreaterThan(BigDecimal value) {
			addCriterion("rebate_supplier_third >", value, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_third >=", value, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdLessThan(BigDecimal value) {
			addCriterion("rebate_supplier_third <", value, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_supplier_third <=", value, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier_third in", values, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdNotIn(List<BigDecimal> values) {
			addCriterion("rebate_supplier_third not in", values, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier_third between", value1, value2, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateSupplierThirdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_supplier_third not between", value1, value2, "rebateSupplierThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstIsNull() {
			addCriterion("rebate_member_recommend_cnoperator_first is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstIsNotNull() {
			addCriterion("rebate_member_recommend_cnoperator_first is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_first =", value,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_first <>", value,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstGreaterThan(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_first >", value,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_first >=", value,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstLessThan(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_first <", value,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_first <=", value,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstIn(List<BigDecimal> values) {
			addCriterion("rebate_member_recommend_cnoperator_first in", values,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member_recommend_cnoperator_first not in", values,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_recommend_cnoperator_first between", value1, value2,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_recommend_cnoperator_first not between", value1, value2,
					"rebateMemberRecommendCnoperatorFirst");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondIsNull() {
			addCriterion("rebate_member_recommend_cnoperator_second is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondIsNotNull() {
			addCriterion("rebate_member_recommend_cnoperator_second is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_second =", value,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_second <>", value,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondGreaterThan(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_second >", value,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_second >=", value,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondLessThan(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_second <", value,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_second <=", value,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondIn(List<BigDecimal> values) {
			addCriterion("rebate_member_recommend_cnoperator_second in", values,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member_recommend_cnoperator_second not in", values,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_recommend_cnoperator_second between", value1, value2,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorSecondNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("rebate_member_recommend_cnoperator_second not between", value1, value2,
					"rebateMemberRecommendCnoperatorSecond");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdIsNull() {
			addCriterion("rebate_member_recommend_cnoperator_third is null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdIsNotNull() {
			addCriterion("rebate_member_recommend_cnoperator_third is not null");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_third =", value,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdNotEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_third <>", value,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdGreaterThan(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_third >", value,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_third >=", value,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdLessThan(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_third <", value,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_member_recommend_cnoperator_third <=", value,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdIn(List<BigDecimal> values) {
			addCriterion("rebate_member_recommend_cnoperator_third in", values,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdNotIn(List<BigDecimal> values) {
			addCriterion("rebate_member_recommend_cnoperator_third not in", values,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_recommend_cnoperator_third between", value1, value2,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateMemberRecommendCnoperatorThirdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_member_recommend_cnoperator_third not between", value1, value2,
					"rebateMemberRecommendCnoperatorThird");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiIsNull() {
			addCriterion("rebate_yun_gou_bi is null");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiIsNotNull() {
			addCriterion("rebate_yun_gou_bi is not null");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiEqualTo(BigDecimal value) {
			addCriterion("rebate_yun_gou_bi =", value, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiNotEqualTo(BigDecimal value) {
			addCriterion("rebate_yun_gou_bi <>", value, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiGreaterThan(BigDecimal value) {
			addCriterion("rebate_yun_gou_bi >", value, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_yun_gou_bi >=", value, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiLessThan(BigDecimal value) {
			addCriterion("rebate_yun_gou_bi <", value, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_yun_gou_bi <=", value, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiIn(List<BigDecimal> values) {
			addCriterion("rebate_yun_gou_bi in", values, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiNotIn(List<BigDecimal> values) {
			addCriterion("rebate_yun_gou_bi not in", values, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_yun_gou_bi between", value1, value2, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andRebateYunGouBiNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_yun_gou_bi not between", value1, value2, "rebateYunGouBi");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayIsNull() {
			addCriterion("seller_qr_pay is null");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayIsNotNull() {
			addCriterion("seller_qr_pay is not null");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayEqualTo(BigDecimal value) {
			addCriterion("seller_qr_pay =", value, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayNotEqualTo(BigDecimal value) {
			addCriterion("seller_qr_pay <>", value, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayGreaterThan(BigDecimal value) {
			addCriterion("seller_qr_pay >", value, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("seller_qr_pay >=", value, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayLessThan(BigDecimal value) {
			addCriterion("seller_qr_pay <", value, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayLessThanOrEqualTo(BigDecimal value) {
			addCriterion("seller_qr_pay <=", value, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayIn(List<BigDecimal> values) {
			addCriterion("seller_qr_pay in", values, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayNotIn(List<BigDecimal> values) {
			addCriterion("seller_qr_pay not in", values, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("seller_qr_pay between", value1, value2, "sellerQrPay");
			return (Criteria) this;
		}

		public Criteria andSellerQrPayNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("seller_qr_pay not between", value1, value2, "sellerQrPay");
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