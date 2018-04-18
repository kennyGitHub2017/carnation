package com.sinco.carnation.o2o.model;

import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupGoodsExample extends AbstractExample<GroupGoodsBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public GroupGoodsExample() {
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

		public Criteria andBeginTimeIsNull() {
			addCriterion("begin_time is null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIsNotNull() {
			addCriterion("begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeEqualTo(Date value) {
			addCriterion("begin_time =", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotEqualTo(Date value) {
			addCriterion("begin_time <>", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThan(Date value) {
			addCriterion("begin_time >", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("begin_time >=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThan(Date value) {
			addCriterion("begin_time <", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
			addCriterion("begin_time <=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIn(List<Date> values) {
			addCriterion("begin_time in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotIn(List<Date> values) {
			addCriterion("begin_time not in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeBetween(Date value1, Date value2) {
			addCriterion("begin_time between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
			addCriterion("begin_time not between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andCostPriceIsNull() {
			addCriterion("cost_price is null");
			return (Criteria) this;
		}

		public Criteria andCostPriceIsNotNull() {
			addCriterion("cost_price is not null");
			return (Criteria) this;
		}

		public Criteria andCostPriceEqualTo(BigDecimal value) {
			addCriterion("cost_price =", value, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceNotEqualTo(BigDecimal value) {
			addCriterion("cost_price <>", value, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceGreaterThan(BigDecimal value) {
			addCriterion("cost_price >", value, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("cost_price >=", value, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceLessThan(BigDecimal value) {
			addCriterion("cost_price <", value, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("cost_price <=", value, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceIn(List<BigDecimal> values) {
			addCriterion("cost_price in", values, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceNotIn(List<BigDecimal> values) {
			addCriterion("cost_price not in", values, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cost_price between", value1, value2, "costPrice");
			return (Criteria) this;
		}

		public Criteria andCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cost_price not between", value1, value2, "costPrice");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andGgNameIsNull() {
			addCriterion("gg_name is null");
			return (Criteria) this;
		}

		public Criteria andGgNameIsNotNull() {
			addCriterion("gg_name is not null");
			return (Criteria) this;
		}

		public Criteria andGgNameEqualTo(String value) {
			addCriterion("gg_name =", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameNotEqualTo(String value) {
			addCriterion("gg_name <>", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameGreaterThan(String value) {
			addCriterion("gg_name >", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameGreaterThanOrEqualTo(String value) {
			addCriterion("gg_name >=", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameLessThan(String value) {
			addCriterion("gg_name <", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameLessThanOrEqualTo(String value) {
			addCriterion("gg_name <=", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameLike(String value) {
			addCriterion("gg_name like", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameNotLike(String value) {
			addCriterion("gg_name not like", value, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameIn(List<String> values) {
			addCriterion("gg_name in", values, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameNotIn(List<String> values) {
			addCriterion("gg_name not in", values, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameBetween(String value1, String value2) {
			addCriterion("gg_name between", value1, value2, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgNameNotBetween(String value1, String value2) {
			addCriterion("gg_name not between", value1, value2, "ggName");
			return (Criteria) this;
		}

		public Criteria andGgRebateIsNull() {
			addCriterion("gg_rebate is null");
			return (Criteria) this;
		}

		public Criteria andGgRebateIsNotNull() {
			addCriterion("gg_rebate is not null");
			return (Criteria) this;
		}

		public Criteria andGgRebateEqualTo(BigDecimal value) {
			addCriterion("gg_rebate =", value, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateNotEqualTo(BigDecimal value) {
			addCriterion("gg_rebate <>", value, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateGreaterThan(BigDecimal value) {
			addCriterion("gg_rebate >", value, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("gg_rebate >=", value, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateLessThan(BigDecimal value) {
			addCriterion("gg_rebate <", value, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("gg_rebate <=", value, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateIn(List<BigDecimal> values) {
			addCriterion("gg_rebate in", values, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateNotIn(List<BigDecimal> values) {
			addCriterion("gg_rebate not in", values, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("gg_rebate between", value1, value2, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgRebateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("gg_rebate not between", value1, value2, "ggRebate");
			return (Criteria) this;
		}

		public Criteria andGgClickIsNull() {
			addCriterion("gg_click is null");
			return (Criteria) this;
		}

		public Criteria andGgClickIsNotNull() {
			addCriterion("gg_click is not null");
			return (Criteria) this;
		}

		public Criteria andGgClickEqualTo(Integer value) {
			addCriterion("gg_click =", value, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickNotEqualTo(Integer value) {
			addCriterion("gg_click <>", value, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickGreaterThan(Integer value) {
			addCriterion("gg_click >", value, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickGreaterThanOrEqualTo(Integer value) {
			addCriterion("gg_click >=", value, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickLessThan(Integer value) {
			addCriterion("gg_click <", value, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickLessThanOrEqualTo(Integer value) {
			addCriterion("gg_click <=", value, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickIn(List<Integer> values) {
			addCriterion("gg_click in", values, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickNotIn(List<Integer> values) {
			addCriterion("gg_click not in", values, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickBetween(Integer value1, Integer value2) {
			addCriterion("gg_click between", value1, value2, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGgClickNotBetween(Integer value1, Integer value2) {
			addCriterion("gg_click not between", value1, value2, "ggClick");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIsNull() {
			addCriterion("goods_type is null");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIsNotNull() {
			addCriterion("goods_type is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeEqualTo(Integer value) {
			addCriterion("goods_type =", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotEqualTo(Integer value) {
			addCriterion("goods_type <>", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeGreaterThan(Integer value) {
			addCriterion("goods_type >", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_type >=", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeLessThan(Integer value) {
			addCriterion("goods_type <", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
			addCriterion("goods_type <=", value, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeIn(List<Integer> values) {
			addCriterion("goods_type in", values, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotIn(List<Integer> values) {
			addCriterion("goods_type not in", values, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
			addCriterion("goods_type between", value1, value2, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_type not between", value1, value2, "goodsType");
			return (Criteria) this;
		}

		public Criteria andGroupCountIsNull() {
			addCriterion("group_count is null");
			return (Criteria) this;
		}

		public Criteria andGroupCountIsNotNull() {
			addCriterion("group_count is not null");
			return (Criteria) this;
		}

		public Criteria andGroupCountEqualTo(Integer value) {
			addCriterion("group_count =", value, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountNotEqualTo(Integer value) {
			addCriterion("group_count <>", value, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountGreaterThan(Integer value) {
			addCriterion("group_count >", value, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("group_count >=", value, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountLessThan(Integer value) {
			addCriterion("group_count <", value, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountLessThanOrEqualTo(Integer value) {
			addCriterion("group_count <=", value, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountIn(List<Integer> values) {
			addCriterion("group_count in", values, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountNotIn(List<Integer> values) {
			addCriterion("group_count not in", values, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountBetween(Integer value1, Integer value2) {
			addCriterion("group_count between", value1, value2, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupCountNotBetween(Integer value1, Integer value2) {
			addCriterion("group_count not between", value1, value2, "groupCount");
			return (Criteria) this;
		}

		public Criteria andGroupPriceIsNull() {
			addCriterion("group_price is null");
			return (Criteria) this;
		}

		public Criteria andGroupPriceIsNotNull() {
			addCriterion("group_price is not null");
			return (Criteria) this;
		}

		public Criteria andGroupPriceEqualTo(BigDecimal value) {
			addCriterion("group_price =", value, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceNotEqualTo(BigDecimal value) {
			addCriterion("group_price <>", value, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceGreaterThan(BigDecimal value) {
			addCriterion("group_price >", value, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("group_price >=", value, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceLessThan(BigDecimal value) {
			addCriterion("group_price <", value, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("group_price <=", value, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceIn(List<BigDecimal> values) {
			addCriterion("group_price in", values, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceNotIn(List<BigDecimal> values) {
			addCriterion("group_price not in", values, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("group_price between", value1, value2, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGroupPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("group_price not between", value1, value2, "groupPrice");
			return (Criteria) this;
		}

		public Criteria andGgStatusIsNull() {
			addCriterion("gg_status is null");
			return (Criteria) this;
		}

		public Criteria andGgStatusIsNotNull() {
			addCriterion("gg_status is not null");
			return (Criteria) this;
		}

		public Criteria andGgStatusEqualTo(Integer value) {
			addCriterion("gg_status =", value, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusNotEqualTo(Integer value) {
			addCriterion("gg_status <>", value, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusGreaterThan(Integer value) {
			addCriterion("gg_status >", value, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("gg_status >=", value, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusLessThan(Integer value) {
			addCriterion("gg_status <", value, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusLessThanOrEqualTo(Integer value) {
			addCriterion("gg_status <=", value, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusIn(List<Integer> values) {
			addCriterion("gg_status in", values, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusNotIn(List<Integer> values) {
			addCriterion("gg_status not in", values, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusBetween(Integer value1, Integer value2) {
			addCriterion("gg_status between", value1, value2, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGgStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("gg_status not between", value1, value2, "ggStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusIsNull() {
			addCriterion("group_status is null");
			return (Criteria) this;
		}

		public Criteria andGroupStatusIsNotNull() {
			addCriterion("group_status is not null");
			return (Criteria) this;
		}

		public Criteria andGroupStatusEqualTo(Integer value) {
			addCriterion("group_status =", value, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusNotEqualTo(Integer value) {
			addCriterion("group_status <>", value, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusGreaterThan(Integer value) {
			addCriterion("group_status >", value, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("group_status >=", value, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusLessThan(Integer value) {
			addCriterion("group_status <", value, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusLessThanOrEqualTo(Integer value) {
			addCriterion("group_status <=", value, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusIn(List<Integer> values) {
			addCriterion("group_status in", values, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusNotIn(List<Integer> values) {
			addCriterion("group_status not in", values, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusBetween(Integer value1, Integer value2) {
			addCriterion("group_status between", value1, value2, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGroupStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("group_status not between", value1, value2, "groupStatus");
			return (Criteria) this;
		}

		public Criteria andGgRecommendIsNull() {
			addCriterion("gg_recommend is null");
			return (Criteria) this;
		}

		public Criteria andGgRecommendIsNotNull() {
			addCriterion("gg_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andGgRecommendEqualTo(Boolean value) {
			addCriterion("gg_recommend =", value, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendNotEqualTo(Boolean value) {
			addCriterion("gg_recommend <>", value, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendGreaterThan(Boolean value) {
			addCriterion("gg_recommend >", value, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("gg_recommend >=", value, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendLessThan(Boolean value) {
			addCriterion("gg_recommend <", value, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendLessThanOrEqualTo(Boolean value) {
			addCriterion("gg_recommend <=", value, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendIn(List<Boolean> values) {
			addCriterion("gg_recommend in", values, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendNotIn(List<Boolean> values) {
			addCriterion("gg_recommend not in", values, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendBetween(Boolean value1, Boolean value2) {
			addCriterion("gg_recommend between", value1, value2, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("gg_recommend not between", value1, value2, "ggRecommend");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeIsNull() {
			addCriterion("gg_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeIsNotNull() {
			addCriterion("gg_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeEqualTo(Date value) {
			addCriterion("gg_recommend_time =", value, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeNotEqualTo(Date value) {
			addCriterion("gg_recommend_time <>", value, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeGreaterThan(Date value) {
			addCriterion("gg_recommend_time >", value, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("gg_recommend_time >=", value, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeLessThan(Date value) {
			addCriterion("gg_recommend_time <", value, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterion("gg_recommend_time <=", value, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeIn(List<Date> values) {
			addCriterion("gg_recommend_time in", values, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeNotIn(List<Date> values) {
			addCriterion("gg_recommend_time not in", values, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeBetween(Date value1, Date value2) {
			addCriterion("gg_recommend_time between", value1, value2, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andGgRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterion("gg_recommend_time not between", value1, value2, "ggRecommendTime");
			return (Criteria) this;
		}

		public Criteria andSelledCountIsNull() {
			addCriterion("selled_count is null");
			return (Criteria) this;
		}

		public Criteria andSelledCountIsNotNull() {
			addCriterion("selled_count is not null");
			return (Criteria) this;
		}

		public Criteria andSelledCountEqualTo(Integer value) {
			addCriterion("selled_count =", value, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountNotEqualTo(Integer value) {
			addCriterion("selled_count <>", value, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountGreaterThan(Integer value) {
			addCriterion("selled_count >", value, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("selled_count >=", value, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountLessThan(Integer value) {
			addCriterion("selled_count <", value, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountLessThanOrEqualTo(Integer value) {
			addCriterion("selled_count <=", value, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountIn(List<Integer> values) {
			addCriterion("selled_count in", values, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountNotIn(List<Integer> values) {
			addCriterion("selled_count not in", values, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountBetween(Integer value1, Integer value2) {
			addCriterion("selled_count between", value1, value2, "selledCount");
			return (Criteria) this;
		}

		public Criteria andSelledCountNotBetween(Integer value1, Integer value2) {
			addCriterion("selled_count not between", value1, value2, "selledCount");
			return (Criteria) this;
		}

		public Criteria andGgGaIdIsNull() {
			addCriterion("gg_ga_id is null");
			return (Criteria) this;
		}

		public Criteria andGgGaIdIsNotNull() {
			addCriterion("gg_ga_id is not null");
			return (Criteria) this;
		}

		public Criteria andGgGaIdEqualTo(Long value) {
			addCriterion("gg_ga_id =", value, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdNotEqualTo(Long value) {
			addCriterion("gg_ga_id <>", value, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdGreaterThan(Long value) {
			addCriterion("gg_ga_id >", value, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gg_ga_id >=", value, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdLessThan(Long value) {
			addCriterion("gg_ga_id <", value, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdLessThanOrEqualTo(Long value) {
			addCriterion("gg_ga_id <=", value, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdIn(List<Long> values) {
			addCriterion("gg_ga_id in", values, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdNotIn(List<Long> values) {
			addCriterion("gg_ga_id not in", values, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdBetween(Long value1, Long value2) {
			addCriterion("gg_ga_id between", value1, value2, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGaIdNotBetween(Long value1, Long value2) {
			addCriterion("gg_ga_id not between", value1, value2, "ggGaId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdIsNull() {
			addCriterion("gg_gc_id is null");
			return (Criteria) this;
		}

		public Criteria andGgGcIdIsNotNull() {
			addCriterion("gg_gc_id is not null");
			return (Criteria) this;
		}

		public Criteria andGgGcIdEqualTo(Long value) {
			addCriterion("gg_gc_id =", value, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdNotEqualTo(Long value) {
			addCriterion("gg_gc_id <>", value, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdGreaterThan(Long value) {
			addCriterion("gg_gc_id >", value, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gg_gc_id >=", value, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdLessThan(Long value) {
			addCriterion("gg_gc_id <", value, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdLessThanOrEqualTo(Long value) {
			addCriterion("gg_gc_id <=", value, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdIn(List<Long> values) {
			addCriterion("gg_gc_id in", values, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdNotIn(List<Long> values) {
			addCriterion("gg_gc_id not in", values, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdBetween(Long value1, Long value2) {
			addCriterion("gg_gc_id between", value1, value2, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGgGcIdNotBetween(Long value1, Long value2) {
			addCriterion("gg_gc_id not between", value1, value2, "ggGcId");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathIsNull() {
			addCriterion("group_acc_path is null");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathIsNotNull() {
			addCriterion("group_acc_path is not null");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathEqualTo(String value) {
			addCriterion("group_acc_path =", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathNotEqualTo(String value) {
			addCriterion("group_acc_path <>", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathGreaterThan(String value) {
			addCriterion("group_acc_path >", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathGreaterThanOrEqualTo(String value) {
			addCriterion("group_acc_path >=", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathLessThan(String value) {
			addCriterion("group_acc_path <", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathLessThanOrEqualTo(String value) {
			addCriterion("group_acc_path <=", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathLike(String value) {
			addCriterion("group_acc_path like", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathNotLike(String value) {
			addCriterion("group_acc_path not like", value, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathIn(List<String> values) {
			addCriterion("group_acc_path in", values, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathNotIn(List<String> values) {
			addCriterion("group_acc_path not in", values, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathBetween(String value1, String value2) {
			addCriterion("group_acc_path between", value1, value2, "groupAccPath");
			return (Criteria) this;
		}

		public Criteria andGroupAccPathNotBetween(String value1, String value2) {
			addCriterion("group_acc_path not between", value1, value2, "groupAccPath");
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

		public Criteria andSeoKeywordsIsNull() {
			addCriterion("seo_keywords is null");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsIsNotNull() {
			addCriterion("seo_keywords is not null");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsEqualTo(String value) {
			addCriterion("seo_keywords =", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotEqualTo(String value) {
			addCriterion("seo_keywords <>", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsGreaterThan(String value) {
			addCriterion("seo_keywords >", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsGreaterThanOrEqualTo(String value) {
			addCriterion("seo_keywords >=", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsLessThan(String value) {
			addCriterion("seo_keywords <", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsLessThanOrEqualTo(String value) {
			addCriterion("seo_keywords <=", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsLike(String value) {
			addCriterion("seo_keywords like", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotLike(String value) {
			addCriterion("seo_keywords not like", value, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsIn(List<String> values) {
			addCriterion("seo_keywords in", values, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotIn(List<String> values) {
			addCriterion("seo_keywords not in", values, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsBetween(String value1, String value2) {
			addCriterion("seo_keywords between", value1, value2, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoKeywordsNotBetween(String value1, String value2) {
			addCriterion("seo_keywords not between", value1, value2, "seoKeywords");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionIsNull() {
			addCriterion("seo_description is null");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionIsNotNull() {
			addCriterion("seo_description is not null");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionEqualTo(String value) {
			addCriterion("seo_description =", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionNotEqualTo(String value) {
			addCriterion("seo_description <>", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionGreaterThan(String value) {
			addCriterion("seo_description >", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("seo_description >=", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionLessThan(String value) {
			addCriterion("seo_description <", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionLessThanOrEqualTo(String value) {
			addCriterion("seo_description <=", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionLike(String value) {
			addCriterion("seo_description like", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionNotLike(String value) {
			addCriterion("seo_description not like", value, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionIn(List<String> values) {
			addCriterion("seo_description in", values, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionNotIn(List<String> values) {
			addCriterion("seo_description not in", values, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionBetween(String value1, String value2) {
			addCriterion("seo_description between", value1, value2, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andSeoDescriptionNotBetween(String value1, String value2) {
			addCriterion("seo_description not between", value1, value2, "seoDescription");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIsNull() {
			addCriterion("goods_collect is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIsNotNull() {
			addCriterion("goods_collect is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectEqualTo(Integer value) {
			addCriterion("goods_collect =", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotEqualTo(Integer value) {
			addCriterion("goods_collect <>", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectGreaterThan(Integer value) {
			addCriterion("goods_collect >", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_collect >=", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectLessThan(Integer value) {
			addCriterion("goods_collect <", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectLessThanOrEqualTo(Integer value) {
			addCriterion("goods_collect <=", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIn(List<Integer> values) {
			addCriterion("goods_collect in", values, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotIn(List<Integer> values) {
			addCriterion("goods_collect not in", values, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectBetween(Integer value1, Integer value2) {
			addCriterion("goods_collect between", value1, value2, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_collect not between", value1, value2, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andOffcauseIsNull() {
			addCriterion("offCause is null");
			return (Criteria) this;
		}

		public Criteria andOffcauseIsNotNull() {
			addCriterion("offCause is not null");
			return (Criteria) this;
		}

		public Criteria andOffcauseEqualTo(String value) {
			addCriterion("offCause =", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseNotEqualTo(String value) {
			addCriterion("offCause <>", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseGreaterThan(String value) {
			addCriterion("offCause >", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseGreaterThanOrEqualTo(String value) {
			addCriterion("offCause >=", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseLessThan(String value) {
			addCriterion("offCause <", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseLessThanOrEqualTo(String value) {
			addCriterion("offCause <=", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseLike(String value) {
			addCriterion("offCause like", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseNotLike(String value) {
			addCriterion("offCause not like", value, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseIn(List<String> values) {
			addCriterion("offCause in", values, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseNotIn(List<String> values) {
			addCriterion("offCause not in", values, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseBetween(String value1, String value2) {
			addCriterion("offCause between", value1, value2, "offcause");
			return (Criteria) this;
		}

		public Criteria andOffcauseNotBetween(String value1, String value2) {
			addCriterion("offCause not between", value1, value2, "offcause");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescIsNull() {
			addCriterion("refusedReasonDesc is null");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescIsNotNull() {
			addCriterion("refusedReasonDesc is not null");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescEqualTo(String value) {
			addCriterion("refusedReasonDesc =", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescNotEqualTo(String value) {
			addCriterion("refusedReasonDesc <>", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescGreaterThan(String value) {
			addCriterion("refusedReasonDesc >", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescGreaterThanOrEqualTo(String value) {
			addCriterion("refusedReasonDesc >=", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescLessThan(String value) {
			addCriterion("refusedReasonDesc <", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescLessThanOrEqualTo(String value) {
			addCriterion("refusedReasonDesc <=", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescLike(String value) {
			addCriterion("refusedReasonDesc like", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescNotLike(String value) {
			addCriterion("refusedReasonDesc not like", value, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescIn(List<String> values) {
			addCriterion("refusedReasonDesc in", values, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescNotIn(List<String> values) {
			addCriterion("refusedReasonDesc not in", values, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescBetween(String value1, String value2) {
			addCriterion("refusedReasonDesc between", value1, value2, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andRefusedreasondescNotBetween(String value1, String value2) {
			addCriterion("refusedReasonDesc not between", value1, value2, "refusedreasondesc");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnIsNull() {
			addCriterion("group_count_warn is null");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnIsNotNull() {
			addCriterion("group_count_warn is not null");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnEqualTo(Integer value) {
			addCriterion("group_count_warn =", value, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnNotEqualTo(Integer value) {
			addCriterion("group_count_warn <>", value, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnGreaterThan(Integer value) {
			addCriterion("group_count_warn >", value, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnGreaterThanOrEqualTo(Integer value) {
			addCriterion("group_count_warn >=", value, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnLessThan(Integer value) {
			addCriterion("group_count_warn <", value, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnLessThanOrEqualTo(Integer value) {
			addCriterion("group_count_warn <=", value, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnIn(List<Integer> values) {
			addCriterion("group_count_warn in", values, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnNotIn(List<Integer> values) {
			addCriterion("group_count_warn not in", values, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnBetween(Integer value1, Integer value2) {
			addCriterion("group_count_warn between", value1, value2, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupCountWarnNotBetween(Integer value1, Integer value2) {
			addCriterion("group_count_warn not between", value1, value2, "groupCountWarn");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountIsNull() {
			addCriterion("group_rebate_amount is null");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountIsNotNull() {
			addCriterion("group_rebate_amount is not null");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount =", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountNotEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount <>", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountGreaterThan(BigDecimal value) {
			addCriterion("group_rebate_amount >", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount >=", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountLessThan(BigDecimal value) {
			addCriterion("group_rebate_amount <", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount <=", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountIn(List<BigDecimal> values) {
			addCriterion("group_rebate_amount in", values, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountNotIn(List<BigDecimal> values) {
			addCriterion("group_rebate_amount not in", values, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("group_rebate_amount between", value1, value2, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("group_rebate_amount not between", value1, value2, "groupRebateAmount");
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