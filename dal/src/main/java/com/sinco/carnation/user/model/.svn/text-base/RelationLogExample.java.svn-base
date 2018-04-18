package com.sinco.carnation.user.model;

import com.sinco.carnation.user.bo.RelationLogBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelationLogExample extends AbstractExample<RelationLogBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public RelationLogExample() {
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

        public Criteria andRefereeUidIsNull() {
            addCriterion("referee_uid is null");
            return (Criteria) this;
        }

        public Criteria andRefereeUidIsNotNull() {
            addCriterion("referee_uid is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeUidEqualTo(Long value) {
            addCriterion("referee_uid =", value, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNotEqualTo(Long value) {
            addCriterion("referee_uid <>", value, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidGreaterThan(Long value) {
            addCriterion("referee_uid >", value, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidGreaterThanOrEqualTo(Long value) {
            addCriterion("referee_uid >=", value, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidLessThan(Long value) {
            addCriterion("referee_uid <", value, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidLessThanOrEqualTo(Long value) {
            addCriterion("referee_uid <=", value, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidIn(List<Long> values) {
            addCriterion("referee_uid in", values, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNotIn(List<Long> values) {
            addCriterion("referee_uid not in", values, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidBetween(Long value1, Long value2) {
            addCriterion("referee_uid between", value1, value2, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNotBetween(Long value1, Long value2) {
            addCriterion("referee_uid not between", value1, value2, "refereeUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidIsNull() {
            addCriterion("seller_uid is null");
            return (Criteria) this;
        }

        public Criteria andSellerUidIsNotNull() {
            addCriterion("seller_uid is not null");
            return (Criteria) this;
        }

        public Criteria andSellerUidEqualTo(Long value) {
            addCriterion("seller_uid =", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidNotEqualTo(Long value) {
            addCriterion("seller_uid <>", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidGreaterThan(Long value) {
            addCriterion("seller_uid >", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_uid >=", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidLessThan(Long value) {
            addCriterion("seller_uid <", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidLessThanOrEqualTo(Long value) {
            addCriterion("seller_uid <=", value, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidIn(List<Long> values) {
            addCriterion("seller_uid in", values, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidNotIn(List<Long> values) {
            addCriterion("seller_uid not in", values, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidBetween(Long value1, Long value2) {
            addCriterion("seller_uid between", value1, value2, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andSellerUidNotBetween(Long value1, Long value2) {
            addCriterion("seller_uid not between", value1, value2, "sellerUid");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewIsNull() {
            addCriterion("referee_uid_new is null");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewIsNotNull() {
            addCriterion("referee_uid_new is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewEqualTo(Long value) {
            addCriterion("referee_uid_new =", value, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewNotEqualTo(Long value) {
            addCriterion("referee_uid_new <>", value, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewGreaterThan(Long value) {
            addCriterion("referee_uid_new >", value, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewGreaterThanOrEqualTo(Long value) {
            addCriterion("referee_uid_new >=", value, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewLessThan(Long value) {
            addCriterion("referee_uid_new <", value, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewLessThanOrEqualTo(Long value) {
            addCriterion("referee_uid_new <=", value, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewIn(List<Long> values) {
            addCriterion("referee_uid_new in", values, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewNotIn(List<Long> values) {
            addCriterion("referee_uid_new not in", values, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewBetween(Long value1, Long value2) {
            addCriterion("referee_uid_new between", value1, value2, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andRefereeUidNewNotBetween(Long value1, Long value2) {
            addCriterion("referee_uid_new not between", value1, value2, "refereeUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewIsNull() {
            addCriterion("seller_uid_new is null");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewIsNotNull() {
            addCriterion("seller_uid_new is not null");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewEqualTo(Long value) {
            addCriterion("seller_uid_new =", value, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewNotEqualTo(Long value) {
            addCriterion("seller_uid_new <>", value, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewGreaterThan(Long value) {
            addCriterion("seller_uid_new >", value, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_uid_new >=", value, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewLessThan(Long value) {
            addCriterion("seller_uid_new <", value, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewLessThanOrEqualTo(Long value) {
            addCriterion("seller_uid_new <=", value, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewIn(List<Long> values) {
            addCriterion("seller_uid_new in", values, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewNotIn(List<Long> values) {
            addCriterion("seller_uid_new not in", values, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewBetween(Long value1, Long value2) {
            addCriterion("seller_uid_new between", value1, value2, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andSellerUidNewNotBetween(Long value1, Long value2) {
            addCriterion("seller_uid_new not between", value1, value2, "sellerUidNew");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(Integer value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(Integer value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(Integer value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(Integer value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Integer> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Integer> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(Integer value1, Integer value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("log_type not between", value1, value2, "logType");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNull() {
            addCriterion("modify_by is null");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNotNull() {
            addCriterion("modify_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifyByEqualTo(String value) {
            addCriterion("modify_by =", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotEqualTo(String value) {
            addCriterion("modify_by <>", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThan(String value) {
            addCriterion("modify_by >", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThanOrEqualTo(String value) {
            addCriterion("modify_by >=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThan(String value) {
            addCriterion("modify_by <", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThanOrEqualTo(String value) {
            addCriterion("modify_by <=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLike(String value) {
            addCriterion("modify_by like", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotLike(String value) {
            addCriterion("modify_by not like", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByIn(List<String> values) {
            addCriterion("modify_by in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotIn(List<String> values) {
            addCriterion("modify_by not in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByBetween(String value1, String value2) {
            addCriterion("modify_by between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotBetween(String value1, String value2) {
            addCriterion("modify_by not between", value1, value2, "modifyBy");
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