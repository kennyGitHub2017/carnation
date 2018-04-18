package com.sinco.carnation.o2o.model;

import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupClassExample extends AbstractExample<GroupClassBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public GroupClassExample() {
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

        public Criteria andGcLevelIsNull() {
            addCriterion("gc_level is null");
            return (Criteria) this;
        }

        public Criteria andGcLevelIsNotNull() {
            addCriterion("gc_level is not null");
            return (Criteria) this;
        }

        public Criteria andGcLevelEqualTo(Integer value) {
            addCriterion("gc_level =", value, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelNotEqualTo(Integer value) {
            addCriterion("gc_level <>", value, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelGreaterThan(Integer value) {
            addCriterion("gc_level >", value, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("gc_level >=", value, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelLessThan(Integer value) {
            addCriterion("gc_level <", value, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelLessThanOrEqualTo(Integer value) {
            addCriterion("gc_level <=", value, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelIn(List<Integer> values) {
            addCriterion("gc_level in", values, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelNotIn(List<Integer> values) {
            addCriterion("gc_level not in", values, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelBetween(Integer value1, Integer value2) {
            addCriterion("gc_level between", value1, value2, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("gc_level not between", value1, value2, "gcLevel");
            return (Criteria) this;
        }

        public Criteria andGcNameIsNull() {
            addCriterion("gc_name is null");
            return (Criteria) this;
        }

        public Criteria andGcNameIsNotNull() {
            addCriterion("gc_name is not null");
            return (Criteria) this;
        }

        public Criteria andGcNameEqualTo(String value) {
            addCriterion("gc_name =", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameNotEqualTo(String value) {
            addCriterion("gc_name <>", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameGreaterThan(String value) {
            addCriterion("gc_name >", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameGreaterThanOrEqualTo(String value) {
            addCriterion("gc_name >=", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameLessThan(String value) {
            addCriterion("gc_name <", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameLessThanOrEqualTo(String value) {
            addCriterion("gc_name <=", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameLike(String value) {
            addCriterion("gc_name like", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameNotLike(String value) {
            addCriterion("gc_name not like", value, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameIn(List<String> values) {
            addCriterion("gc_name in", values, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameNotIn(List<String> values) {
            addCriterion("gc_name not in", values, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameBetween(String value1, String value2) {
            addCriterion("gc_name between", value1, value2, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcNameNotBetween(String value1, String value2) {
            addCriterion("gc_name not between", value1, value2, "gcName");
            return (Criteria) this;
        }

        public Criteria andGcSequenceIsNull() {
            addCriterion("gc_sequence is null");
            return (Criteria) this;
        }

        public Criteria andGcSequenceIsNotNull() {
            addCriterion("gc_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andGcSequenceEqualTo(Integer value) {
            addCriterion("gc_sequence =", value, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceNotEqualTo(Integer value) {
            addCriterion("gc_sequence <>", value, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceGreaterThan(Integer value) {
            addCriterion("gc_sequence >", value, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("gc_sequence >=", value, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceLessThan(Integer value) {
            addCriterion("gc_sequence <", value, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("gc_sequence <=", value, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceIn(List<Integer> values) {
            addCriterion("gc_sequence in", values, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceNotIn(List<Integer> values) {
            addCriterion("gc_sequence not in", values, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceBetween(Integer value1, Integer value2) {
            addCriterion("gc_sequence between", value1, value2, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("gc_sequence not between", value1, value2, "gcSequence");
            return (Criteria) this;
        }

        public Criteria andGcTypeIsNull() {
            addCriterion("gc_type is null");
            return (Criteria) this;
        }

        public Criteria andGcTypeIsNotNull() {
            addCriterion("gc_type is not null");
            return (Criteria) this;
        }

        public Criteria andGcTypeEqualTo(Integer value) {
            addCriterion("gc_type =", value, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeNotEqualTo(Integer value) {
            addCriterion("gc_type <>", value, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeGreaterThan(Integer value) {
            addCriterion("gc_type >", value, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("gc_type >=", value, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeLessThan(Integer value) {
            addCriterion("gc_type <", value, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeLessThanOrEqualTo(Integer value) {
            addCriterion("gc_type <=", value, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeIn(List<Integer> values) {
            addCriterion("gc_type in", values, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeNotIn(List<Integer> values) {
            addCriterion("gc_type not in", values, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeBetween(Integer value1, Integer value2) {
            addCriterion("gc_type between", value1, value2, "gcType");
            return (Criteria) this;
        }

        public Criteria andGcTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("gc_type not between", value1, value2, "gcType");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andMobileIconIsNull() {
            addCriterion("mobile_icon is null");
            return (Criteria) this;
        }

        public Criteria andMobileIconIsNotNull() {
            addCriterion("mobile_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMobileIconEqualTo(String value) {
            addCriterion("mobile_icon =", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotEqualTo(String value) {
            addCriterion("mobile_icon <>", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconGreaterThan(String value) {
            addCriterion("mobile_icon >", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_icon >=", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconLessThan(String value) {
            addCriterion("mobile_icon <", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconLessThanOrEqualTo(String value) {
            addCriterion("mobile_icon <=", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconLike(String value) {
            addCriterion("mobile_icon like", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotLike(String value) {
            addCriterion("mobile_icon not like", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconIn(List<String> values) {
            addCriterion("mobile_icon in", values, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotIn(List<String> values) {
            addCriterion("mobile_icon not in", values, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconBetween(String value1, String value2) {
            addCriterion("mobile_icon between", value1, value2, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotBetween(String value1, String value2) {
            addCriterion("mobile_icon not between", value1, value2, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconIsNull() {
            addCriterion("web_icon is null");
            return (Criteria) this;
        }

        public Criteria andWebIconIsNotNull() {
            addCriterion("web_icon is not null");
            return (Criteria) this;
        }

        public Criteria andWebIconEqualTo(String value) {
            addCriterion("web_icon =", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotEqualTo(String value) {
            addCriterion("web_icon <>", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconGreaterThan(String value) {
            addCriterion("web_icon >", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconGreaterThanOrEqualTo(String value) {
            addCriterion("web_icon >=", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconLessThan(String value) {
            addCriterion("web_icon <", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconLessThanOrEqualTo(String value) {
            addCriterion("web_icon <=", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconLike(String value) {
            addCriterion("web_icon like", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotLike(String value) {
            addCriterion("web_icon not like", value, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconIn(List<String> values) {
            addCriterion("web_icon in", values, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotIn(List<String> values) {
            addCriterion("web_icon not in", values, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconBetween(String value1, String value2) {
            addCriterion("web_icon between", value1, value2, "webIcon");
            return (Criteria) this;
        }

        public Criteria andWebIconNotBetween(String value1, String value2) {
            addCriterion("web_icon not between", value1, value2, "webIcon");
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