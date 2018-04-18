package com.sinco.carnation.juanpi.model;

import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JuanpiGoodsClassExample extends AbstractExample<JuanpiGoodsClassBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public JuanpiGoodsClassExample() {
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

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNull() {
            addCriterion("cate_name is null");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNotNull() {
            addCriterion("cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCateNameEqualTo(String value) {
            addCriterion("cate_name =", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotEqualTo(String value) {
            addCriterion("cate_name <>", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThan(String value) {
            addCriterion("cate_name >", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("cate_name >=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThan(String value) {
            addCriterion("cate_name <", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThanOrEqualTo(String value) {
            addCriterion("cate_name <=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLike(String value) {
            addCriterion("cate_name like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotLike(String value) {
            addCriterion("cate_name not like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameIn(List<String> values) {
            addCriterion("cate_name in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotIn(List<String> values) {
            addCriterion("cate_name not in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameBetween(String value1, String value2) {
            addCriterion("cate_name between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotBetween(String value1, String value2) {
            addCriterion("cate_name not between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Long value) {
            addCriterion("cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Long value) {
            addCriterion("cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Long value) {
            addCriterion("cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Long value) {
            addCriterion("cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Long value) {
            addCriterion("cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Long> values) {
            addCriterion("cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Long> values) {
            addCriterion("cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Long value1, Long value2) {
            addCriterion("cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Long value1, Long value2) {
            addCriterion("cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCate2NameIsNull() {
            addCriterion("cate2_name is null");
            return (Criteria) this;
        }

        public Criteria andCate2NameIsNotNull() {
            addCriterion("cate2_name is not null");
            return (Criteria) this;
        }

        public Criteria andCate2NameEqualTo(String value) {
            addCriterion("cate2_name =", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotEqualTo(String value) {
            addCriterion("cate2_name <>", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameGreaterThan(String value) {
            addCriterion("cate2_name >", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameGreaterThanOrEqualTo(String value) {
            addCriterion("cate2_name >=", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameLessThan(String value) {
            addCriterion("cate2_name <", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameLessThanOrEqualTo(String value) {
            addCriterion("cate2_name <=", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameLike(String value) {
            addCriterion("cate2_name like", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotLike(String value) {
            addCriterion("cate2_name not like", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameIn(List<String> values) {
            addCriterion("cate2_name in", values, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotIn(List<String> values) {
            addCriterion("cate2_name not in", values, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameBetween(String value1, String value2) {
            addCriterion("cate2_name between", value1, value2, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotBetween(String value1, String value2) {
            addCriterion("cate2_name not between", value1, value2, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2IdIsNull() {
            addCriterion("cate2_id is null");
            return (Criteria) this;
        }

        public Criteria andCate2IdIsNotNull() {
            addCriterion("cate2_id is not null");
            return (Criteria) this;
        }

        public Criteria andCate2IdEqualTo(Long value) {
            addCriterion("cate2_id =", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdNotEqualTo(Long value) {
            addCriterion("cate2_id <>", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdGreaterThan(Long value) {
            addCriterion("cate2_id >", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate2_id >=", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdLessThan(Long value) {
            addCriterion("cate2_id <", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdLessThanOrEqualTo(Long value) {
            addCriterion("cate2_id <=", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdIn(List<Long> values) {
            addCriterion("cate2_id in", values, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdNotIn(List<Long> values) {
            addCriterion("cate2_id not in", values, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdBetween(Long value1, Long value2) {
            addCriterion("cate2_id between", value1, value2, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdNotBetween(Long value1, Long value2) {
            addCriterion("cate2_id not between", value1, value2, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate3NameIsNull() {
            addCriterion("cate3_name is null");
            return (Criteria) this;
        }

        public Criteria andCate3NameIsNotNull() {
            addCriterion("cate3_name is not null");
            return (Criteria) this;
        }

        public Criteria andCate3NameEqualTo(String value) {
            addCriterion("cate3_name =", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotEqualTo(String value) {
            addCriterion("cate3_name <>", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameGreaterThan(String value) {
            addCriterion("cate3_name >", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameGreaterThanOrEqualTo(String value) {
            addCriterion("cate3_name >=", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameLessThan(String value) {
            addCriterion("cate3_name <", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameLessThanOrEqualTo(String value) {
            addCriterion("cate3_name <=", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameLike(String value) {
            addCriterion("cate3_name like", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotLike(String value) {
            addCriterion("cate3_name not like", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameIn(List<String> values) {
            addCriterion("cate3_name in", values, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotIn(List<String> values) {
            addCriterion("cate3_name not in", values, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameBetween(String value1, String value2) {
            addCriterion("cate3_name between", value1, value2, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotBetween(String value1, String value2) {
            addCriterion("cate3_name not between", value1, value2, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3IdIsNull() {
            addCriterion("cate3_id is null");
            return (Criteria) this;
        }

        public Criteria andCate3IdIsNotNull() {
            addCriterion("cate3_id is not null");
            return (Criteria) this;
        }

        public Criteria andCate3IdEqualTo(Long value) {
            addCriterion("cate3_id =", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdNotEqualTo(Long value) {
            addCriterion("cate3_id <>", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdGreaterThan(Long value) {
            addCriterion("cate3_id >", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate3_id >=", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdLessThan(Long value) {
            addCriterion("cate3_id <", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdLessThanOrEqualTo(Long value) {
            addCriterion("cate3_id <=", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdIn(List<Long> values) {
            addCriterion("cate3_id in", values, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdNotIn(List<Long> values) {
            addCriterion("cate3_id not in", values, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdBetween(Long value1, Long value2) {
            addCriterion("cate3_id between", value1, value2, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdNotBetween(Long value1, Long value2) {
            addCriterion("cate3_id not between", value1, value2, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andIsJoinIsNull() {
            addCriterion("is_join is null");
            return (Criteria) this;
        }

        public Criteria andIsJoinIsNotNull() {
            addCriterion("is_join is not null");
            return (Criteria) this;
        }

        public Criteria andIsJoinEqualTo(Integer value) {
            addCriterion("is_join =", value, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinNotEqualTo(Integer value) {
            addCriterion("is_join <>", value, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinGreaterThan(Integer value) {
            addCriterion("is_join >", value, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_join >=", value, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinLessThan(Integer value) {
            addCriterion("is_join <", value, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinLessThanOrEqualTo(Integer value) {
            addCriterion("is_join <=", value, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinIn(List<Integer> values) {
            addCriterion("is_join in", values, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinNotIn(List<Integer> values) {
            addCriterion("is_join not in", values, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinBetween(Integer value1, Integer value2) {
            addCriterion("is_join between", value1, value2, "isJoin");
            return (Criteria) this;
        }

        public Criteria andIsJoinNotBetween(Integer value1, Integer value2) {
            addCriterion("is_join not between", value1, value2, "isJoin");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Long value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Long value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Long value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Long value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Long value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Long> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Long> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Long value1, Long value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Long value1, Long value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClass2IdIsNull() {
            addCriterion("class2_id is null");
            return (Criteria) this;
        }

        public Criteria andClass2IdIsNotNull() {
            addCriterion("class2_id is not null");
            return (Criteria) this;
        }

        public Criteria andClass2IdEqualTo(Long value) {
            addCriterion("class2_id =", value, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdNotEqualTo(Long value) {
            addCriterion("class2_id <>", value, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdGreaterThan(Long value) {
            addCriterion("class2_id >", value, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("class2_id >=", value, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdLessThan(Long value) {
            addCriterion("class2_id <", value, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdLessThanOrEqualTo(Long value) {
            addCriterion("class2_id <=", value, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdIn(List<Long> values) {
            addCriterion("class2_id in", values, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdNotIn(List<Long> values) {
            addCriterion("class2_id not in", values, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdBetween(Long value1, Long value2) {
            addCriterion("class2_id between", value1, value2, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2IdNotBetween(Long value1, Long value2) {
            addCriterion("class2_id not between", value1, value2, "class2Id");
            return (Criteria) this;
        }

        public Criteria andClass2NameIsNull() {
            addCriterion("class2_name is null");
            return (Criteria) this;
        }

        public Criteria andClass2NameIsNotNull() {
            addCriterion("class2_name is not null");
            return (Criteria) this;
        }

        public Criteria andClass2NameEqualTo(String value) {
            addCriterion("class2_name =", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameNotEqualTo(String value) {
            addCriterion("class2_name <>", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameGreaterThan(String value) {
            addCriterion("class2_name >", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameGreaterThanOrEqualTo(String value) {
            addCriterion("class2_name >=", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameLessThan(String value) {
            addCriterion("class2_name <", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameLessThanOrEqualTo(String value) {
            addCriterion("class2_name <=", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameLike(String value) {
            addCriterion("class2_name like", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameNotLike(String value) {
            addCriterion("class2_name not like", value, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameIn(List<String> values) {
            addCriterion("class2_name in", values, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameNotIn(List<String> values) {
            addCriterion("class2_name not in", values, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameBetween(String value1, String value2) {
            addCriterion("class2_name between", value1, value2, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass2NameNotBetween(String value1, String value2) {
            addCriterion("class2_name not between", value1, value2, "class2Name");
            return (Criteria) this;
        }

        public Criteria andClass3IdIsNull() {
            addCriterion("class3_id is null");
            return (Criteria) this;
        }

        public Criteria andClass3IdIsNotNull() {
            addCriterion("class3_id is not null");
            return (Criteria) this;
        }

        public Criteria andClass3IdEqualTo(Long value) {
            addCriterion("class3_id =", value, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdNotEqualTo(Long value) {
            addCriterion("class3_id <>", value, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdGreaterThan(Long value) {
            addCriterion("class3_id >", value, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("class3_id >=", value, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdLessThan(Long value) {
            addCriterion("class3_id <", value, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdLessThanOrEqualTo(Long value) {
            addCriterion("class3_id <=", value, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdIn(List<Long> values) {
            addCriterion("class3_id in", values, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdNotIn(List<Long> values) {
            addCriterion("class3_id not in", values, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdBetween(Long value1, Long value2) {
            addCriterion("class3_id between", value1, value2, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3IdNotBetween(Long value1, Long value2) {
            addCriterion("class3_id not between", value1, value2, "class3Id");
            return (Criteria) this;
        }

        public Criteria andClass3NameIsNull() {
            addCriterion("class3_name is null");
            return (Criteria) this;
        }

        public Criteria andClass3NameIsNotNull() {
            addCriterion("class3_name is not null");
            return (Criteria) this;
        }

        public Criteria andClass3NameEqualTo(String value) {
            addCriterion("class3_name =", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameNotEqualTo(String value) {
            addCriterion("class3_name <>", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameGreaterThan(String value) {
            addCriterion("class3_name >", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameGreaterThanOrEqualTo(String value) {
            addCriterion("class3_name >=", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameLessThan(String value) {
            addCriterion("class3_name <", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameLessThanOrEqualTo(String value) {
            addCriterion("class3_name <=", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameLike(String value) {
            addCriterion("class3_name like", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameNotLike(String value) {
            addCriterion("class3_name not like", value, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameIn(List<String> values) {
            addCriterion("class3_name in", values, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameNotIn(List<String> values) {
            addCriterion("class3_name not in", values, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameBetween(String value1, String value2) {
            addCriterion("class3_name between", value1, value2, "class3Name");
            return (Criteria) this;
        }

        public Criteria andClass3NameNotBetween(String value1, String value2) {
            addCriterion("class3_name not between", value1, value2, "class3Name");
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