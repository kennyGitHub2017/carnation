package com.sinco.carnation.o2o.model;

import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupInfoExample extends AbstractExample<GroupInfoBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public GroupInfoExample() {
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
        this.limit = new StringBuilder().append(String.valueOf(offset)).append(",").append(String.valueOf(rows)).toString();
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

        public Criteria andGroupSnIsNull() {
            addCriterion("group_sn is null");
            return (Criteria) this;
        }

        public Criteria andGroupSnIsNotNull() {
            addCriterion("group_sn is not null");
            return (Criteria) this;
        }

        public Criteria andGroupSnEqualTo(String value) {
            addCriterion("group_sn =", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnNotEqualTo(String value) {
            addCriterion("group_sn <>", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnGreaterThan(String value) {
            addCriterion("group_sn >", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnGreaterThanOrEqualTo(String value) {
            addCriterion("group_sn >=", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnLessThan(String value) {
            addCriterion("group_sn <", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnLessThanOrEqualTo(String value) {
            addCriterion("group_sn <=", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnLike(String value) {
            addCriterion("group_sn like", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnNotLike(String value) {
            addCriterion("group_sn not like", value, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnIn(List<String> values) {
            addCriterion("group_sn in", values, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnNotIn(List<String> values) {
            addCriterion("group_sn not in", values, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnBetween(String value1, String value2) {
            addCriterion("group_sn between", value1, value2, "groupSn");
            return (Criteria) this;
        }

        public Criteria andGroupSnNotBetween(String value1, String value2) {
            addCriterion("group_sn not between", value1, value2, "groupSn");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeIsNull() {
            addCriterion("refund_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeIsNotNull() {
            addCriterion("refund_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeEqualTo(Date value) {
            addCriterion("refund_complete_time =", value, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeNotEqualTo(Date value) {
            addCriterion("refund_complete_time <>", value, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeGreaterThan(Date value) {
            addCriterion("refund_complete_time >", value, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_complete_time >=", value, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeLessThan(Date value) {
            addCriterion("refund_complete_time <", value, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_complete_time <=", value, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeIn(List<Date> values) {
            addCriterion("refund_complete_time in", values, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeNotIn(List<Date> values) {
            addCriterion("refund_complete_time not in", values, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("refund_complete_time between", value1, value2, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_complete_time not between", value1, value2, "refundCompleteTime");
            return (Criteria) this;
        }

        public Criteria andRefundReasionIsNull() {
            addCriterion("refund_reasion is null");
            return (Criteria) this;
        }

        public Criteria andRefundReasionIsNotNull() {
            addCriterion("refund_reasion is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReasionEqualTo(String value) {
            addCriterion("refund_reasion =", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionNotEqualTo(String value) {
            addCriterion("refund_reasion <>", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionGreaterThan(String value) {
            addCriterion("refund_reasion >", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionGreaterThanOrEqualTo(String value) {
            addCriterion("refund_reasion >=", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionLessThan(String value) {
            addCriterion("refund_reasion <", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionLessThanOrEqualTo(String value) {
            addCriterion("refund_reasion <=", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionLike(String value) {
            addCriterion("refund_reasion like", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionNotLike(String value) {
            addCriterion("refund_reasion not like", value, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionIn(List<String> values) {
            addCriterion("refund_reasion in", values, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionNotIn(List<String> values) {
            addCriterion("refund_reasion not in", values, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionBetween(String value1, String value2) {
            addCriterion("refund_reasion between", value1, value2, "refundReasion");
            return (Criteria) this;
        }

        public Criteria andRefundReasionNotBetween(String value1, String value2) {
            addCriterion("refund_reasion not between", value1, value2, "refundReasion");
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(Long value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(Long value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(Long value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(Long value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(Long value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<Long> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<Long> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(Long value1, Long value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(Long value1, Long value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andProportionIsNull() {
            addCriterion("proportion is null");
            return (Criteria) this;
        }

        public Criteria andProportionIsNotNull() {
            addCriterion("proportion is not null");
            return (Criteria) this;
        }

        public Criteria andProportionEqualTo(BigDecimal value) {
            addCriterion("proportion =", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotEqualTo(BigDecimal value) {
            addCriterion("proportion <>", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThan(BigDecimal value) {
            addCriterion("proportion >", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("proportion >=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThan(BigDecimal value) {
            addCriterion("proportion <", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("proportion <=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionIn(List<BigDecimal> values) {
            addCriterion("proportion in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotIn(List<BigDecimal> values) {
            addCriterion("proportion not in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proportion between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proportion not between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionIsNull() {
            addCriterion("check_reasion is null");
            return (Criteria) this;
        }

        public Criteria andCheckReasionIsNotNull() {
            addCriterion("check_reasion is not null");
            return (Criteria) this;
        }

        public Criteria andCheckReasionEqualTo(String value) {
            addCriterion("check_reasion =", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionNotEqualTo(String value) {
            addCriterion("check_reasion <>", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionGreaterThan(String value) {
            addCriterion("check_reasion >", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionGreaterThanOrEqualTo(String value) {
            addCriterion("check_reasion >=", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionLessThan(String value) {
            addCriterion("check_reasion <", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionLessThanOrEqualTo(String value) {
            addCriterion("check_reasion <=", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionLike(String value) {
            addCriterion("check_reasion like", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionNotLike(String value) {
            addCriterion("check_reasion not like", value, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionIn(List<String> values) {
            addCriterion("check_reasion in", values, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionNotIn(List<String> values) {
            addCriterion("check_reasion not in", values, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionBetween(String value1, String value2) {
            addCriterion("check_reasion between", value1, value2, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andCheckReasionNotBetween(String value1, String value2) {
            addCriterion("check_reasion not between", value1, value2, "checkReasion");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNull() {
            addCriterion("read_status is null");
            return (Criteria) this;
        }

        public Criteria andReadStatusIsNotNull() {
            addCriterion("read_status is not null");
            return (Criteria) this;
        }

        public Criteria andReadStatusEqualTo(Integer value) {
            addCriterion("read_status =", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotEqualTo(Integer value) {
            addCriterion("read_status <>", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThan(Integer value) {
            addCriterion("read_status >", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_status >=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThan(Integer value) {
            addCriterion("read_status <", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("read_status <=", value, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusIn(List<Integer> values) {
            addCriterion("read_status in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotIn(List<Integer> values) {
            addCriterion("read_status not in", values, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusBetween(Integer value1, Integer value2) {
            addCriterion("read_status between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andReadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("read_status not between", value1, value2, "readStatus");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoIsNull() {
            addCriterion("refused_info is null");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoIsNotNull() {
            addCriterion("refused_info is not null");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoEqualTo(String value) {
            addCriterion("refused_info =", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoNotEqualTo(String value) {
            addCriterion("refused_info <>", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoGreaterThan(String value) {
            addCriterion("refused_info >", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoGreaterThanOrEqualTo(String value) {
            addCriterion("refused_info >=", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoLessThan(String value) {
            addCriterion("refused_info <", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoLessThanOrEqualTo(String value) {
            addCriterion("refused_info <=", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoLike(String value) {
            addCriterion("refused_info like", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoNotLike(String value) {
            addCriterion("refused_info not like", value, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoIn(List<String> values) {
            addCriterion("refused_info in", values, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoNotIn(List<String> values) {
            addCriterion("refused_info not in", values, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoBetween(String value1, String value2) {
            addCriterion("refused_info between", value1, value2, "refusedInfo");
            return (Criteria) this;
        }

        public Criteria andRefusedInfoNotBetween(String value1, String value2) {
            addCriterion("refused_info not between", value1, value2, "refusedInfo");
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