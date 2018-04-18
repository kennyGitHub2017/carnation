package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperatorExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OperatorExample() {
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

		public Criteria andLevelIsNull() {
			addCriterion("level is null");
			return (Criteria) this;
		}

		public Criteria andLevelIsNotNull() {
			addCriterion("level is not null");
			return (Criteria) this;
		}

		public Criteria andLevelEqualTo(String value) {
			addCriterion("level =", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotEqualTo(String value) {
			addCriterion("level <>", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThan(String value) {
			addCriterion("level >", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThanOrEqualTo(String value) {
			addCriterion("level >=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThan(String value) {
			addCriterion("level <", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThanOrEqualTo(String value) {
			addCriterion("level <=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLike(String value) {
			addCriterion("level like", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotLike(String value) {
			addCriterion("level not like", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelIn(List<String> values) {
			addCriterion("level in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotIn(List<String> values) {
			addCriterion("level not in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelBetween(String value1, String value2) {
			addCriterion("level between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotBetween(String value1, String value2) {
			addCriterion("level not between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeIsNull() {
			addCriterion("operator_code is null");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeIsNotNull() {
			addCriterion("operator_code is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeEqualTo(String value) {
			addCriterion("operator_code =", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeNotEqualTo(String value) {
			addCriterion("operator_code <>", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeGreaterThan(String value) {
			addCriterion("operator_code >", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeGreaterThanOrEqualTo(String value) {
			addCriterion("operator_code >=", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeLessThan(String value) {
			addCriterion("operator_code <", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeLessThanOrEqualTo(String value) {
			addCriterion("operator_code <=", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeLike(String value) {
			addCriterion("operator_code like", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeNotLike(String value) {
			addCriterion("operator_code not like", value, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeIn(List<String> values) {
			addCriterion("operator_code in", values, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeNotIn(List<String> values) {
			addCriterion("operator_code not in", values, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeBetween(String value1, String value2) {
			addCriterion("operator_code between", value1, value2, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andOperatorCodeNotBetween(String value1, String value2) {
			addCriterion("operator_code not between", value1, value2, "operatorCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeIsNull() {
			addCriterion("invitation_code is null");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeIsNotNull() {
			addCriterion("invitation_code is not null");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeEqualTo(String value) {
			addCriterion("invitation_code =", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotEqualTo(String value) {
			addCriterion("invitation_code <>", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeGreaterThan(String value) {
			addCriterion("invitation_code >", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeGreaterThanOrEqualTo(String value) {
			addCriterion("invitation_code >=", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeLessThan(String value) {
			addCriterion("invitation_code <", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeLessThanOrEqualTo(String value) {
			addCriterion("invitation_code <=", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeLike(String value) {
			addCriterion("invitation_code like", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotLike(String value) {
			addCriterion("invitation_code not like", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeIn(List<String> values) {
			addCriterion("invitation_code in", values, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotIn(List<String> values) {
			addCriterion("invitation_code not in", values, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeBetween(String value1, String value2) {
			addCriterion("invitation_code between", value1, value2, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotBetween(String value1, String value2) {
			addCriterion("invitation_code not between", value1, value2, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
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

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNull() {
			addCriterion("id_card is null");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNotNull() {
			addCriterion("id_card is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardEqualTo(String value) {
			addCriterion("id_card =", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotEqualTo(String value) {
			addCriterion("id_card <>", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThan(String value) {
			addCriterion("id_card >", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("id_card >=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThan(String value) {
			addCriterion("id_card <", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThanOrEqualTo(String value) {
			addCriterion("id_card <=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLike(String value) {
			addCriterion("id_card like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotLike(String value) {
			addCriterion("id_card not like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardIn(List<String> values) {
			addCriterion("id_card in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotIn(List<String> values) {
			addCriterion("id_card not in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardBetween(String value1, String value2) {
			addCriterion("id_card between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotBetween(String value1, String value2) {
			addCriterion("id_card not between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(String value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(String value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(String value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(String value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(String value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(String value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLike(String value) {
			addCriterion("sex like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotLike(String value) {
			addCriterion("sex not like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<String> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<String> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(String value1, String value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(String value1, String value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdIsNull() {
			addCriterion("operator_area_id is null");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdIsNotNull() {
			addCriterion("operator_area_id is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdEqualTo(String value) {
			addCriterion("operator_area_id =", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdNotEqualTo(String value) {
			addCriterion("operator_area_id <>", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdGreaterThan(String value) {
			addCriterion("operator_area_id >", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdGreaterThanOrEqualTo(String value) {
			addCriterion("operator_area_id >=", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdLessThan(String value) {
			addCriterion("operator_area_id <", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdLessThanOrEqualTo(String value) {
			addCriterion("operator_area_id <=", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdLike(String value) {
			addCriterion("operator_area_id like", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdNotLike(String value) {
			addCriterion("operator_area_id not like", value, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdIn(List<String> values) {
			addCriterion("operator_area_id in", values, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdNotIn(List<String> values) {
			addCriterion("operator_area_id not in", values, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdBetween(String value1, String value2) {
			addCriterion("operator_area_id between", value1, value2, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andOperatorAreaIdNotBetween(String value1, String value2) {
			addCriterion("operator_area_id not between", value1, value2, "operatorAreaId");
			return (Criteria) this;
		}

		public Criteria andNationIsNull() {
			addCriterion("nation is null");
			return (Criteria) this;
		}

		public Criteria andNationIsNotNull() {
			addCriterion("nation is not null");
			return (Criteria) this;
		}

		public Criteria andNationEqualTo(String value) {
			addCriterion("nation =", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotEqualTo(String value) {
			addCriterion("nation <>", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThan(String value) {
			addCriterion("nation >", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThanOrEqualTo(String value) {
			addCriterion("nation >=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThan(String value) {
			addCriterion("nation <", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThanOrEqualTo(String value) {
			addCriterion("nation <=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLike(String value) {
			addCriterion("nation like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotLike(String value) {
			addCriterion("nation not like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationIn(List<String> values) {
			addCriterion("nation in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotIn(List<String> values) {
			addCriterion("nation not in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationBetween(String value1, String value2) {
			addCriterion("nation between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotBetween(String value1, String value2) {
			addCriterion("nation not between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andBankIdIsNull() {
			addCriterion("bank_id is null");
			return (Criteria) this;
		}

		public Criteria andBankIdIsNotNull() {
			addCriterion("bank_id is not null");
			return (Criteria) this;
		}

		public Criteria andBankIdEqualTo(Integer value) {
			addCriterion("bank_id =", value, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdNotEqualTo(Integer value) {
			addCriterion("bank_id <>", value, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdGreaterThan(Integer value) {
			addCriterion("bank_id >", value, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("bank_id >=", value, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdLessThan(Integer value) {
			addCriterion("bank_id <", value, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdLessThanOrEqualTo(Integer value) {
			addCriterion("bank_id <=", value, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdIn(List<Integer> values) {
			addCriterion("bank_id in", values, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdNotIn(List<Integer> values) {
			addCriterion("bank_id not in", values, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdBetween(Integer value1, Integer value2) {
			addCriterion("bank_id between", value1, value2, "bankId");
			return (Criteria) this;
		}

		public Criteria andBankIdNotBetween(Integer value1, Integer value2) {
			addCriterion("bank_id not between", value1, value2, "bankId");
			return (Criteria) this;
		}

		public Criteria andSubBankNameIsNull() {
			addCriterion("sub_bank_name is null");
			return (Criteria) this;
		}

		public Criteria andSubBankNameIsNotNull() {
			addCriterion("sub_bank_name is not null");
			return (Criteria) this;
		}

		public Criteria andSubBankNameEqualTo(String value) {
			addCriterion("sub_bank_name =", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameNotEqualTo(String value) {
			addCriterion("sub_bank_name <>", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameGreaterThan(String value) {
			addCriterion("sub_bank_name >", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("sub_bank_name >=", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameLessThan(String value) {
			addCriterion("sub_bank_name <", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameLessThanOrEqualTo(String value) {
			addCriterion("sub_bank_name <=", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameLike(String value) {
			addCriterion("sub_bank_name like", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameNotLike(String value) {
			addCriterion("sub_bank_name not like", value, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameIn(List<String> values) {
			addCriterion("sub_bank_name in", values, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameNotIn(List<String> values) {
			addCriterion("sub_bank_name not in", values, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameBetween(String value1, String value2) {
			addCriterion("sub_bank_name between", value1, value2, "subBankName");
			return (Criteria) this;
		}

		public Criteria andSubBankNameNotBetween(String value1, String value2) {
			addCriterion("sub_bank_name not between", value1, value2, "subBankName");
			return (Criteria) this;
		}

		public Criteria andBankNoIsNull() {
			addCriterion("bank_no is null");
			return (Criteria) this;
		}

		public Criteria andBankNoIsNotNull() {
			addCriterion("bank_no is not null");
			return (Criteria) this;
		}

		public Criteria andBankNoEqualTo(String value) {
			addCriterion("bank_no =", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoNotEqualTo(String value) {
			addCriterion("bank_no <>", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoGreaterThan(String value) {
			addCriterion("bank_no >", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoGreaterThanOrEqualTo(String value) {
			addCriterion("bank_no >=", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoLessThan(String value) {
			addCriterion("bank_no <", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoLessThanOrEqualTo(String value) {
			addCriterion("bank_no <=", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoLike(String value) {
			addCriterion("bank_no like", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoNotLike(String value) {
			addCriterion("bank_no not like", value, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoIn(List<String> values) {
			addCriterion("bank_no in", values, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoNotIn(List<String> values) {
			addCriterion("bank_no not in", values, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoBetween(String value1, String value2) {
			addCriterion("bank_no between", value1, value2, "bankNo");
			return (Criteria) this;
		}

		public Criteria andBankNoNotBetween(String value1, String value2) {
			addCriterion("bank_no not between", value1, value2, "bankNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoIsNull() {
			addCriterion("registration_no is null");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoIsNotNull() {
			addCriterion("registration_no is not null");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoEqualTo(String value) {
			addCriterion("registration_no =", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoNotEqualTo(String value) {
			addCriterion("registration_no <>", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoGreaterThan(String value) {
			addCriterion("registration_no >", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoGreaterThanOrEqualTo(String value) {
			addCriterion("registration_no >=", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoLessThan(String value) {
			addCriterion("registration_no <", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoLessThanOrEqualTo(String value) {
			addCriterion("registration_no <=", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoLike(String value) {
			addCriterion("registration_no like", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoNotLike(String value) {
			addCriterion("registration_no not like", value, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoIn(List<String> values) {
			addCriterion("registration_no in", values, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoNotIn(List<String> values) {
			addCriterion("registration_no not in", values, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoBetween(String value1, String value2) {
			addCriterion("registration_no between", value1, value2, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationNoNotBetween(String value1, String value2) {
			addCriterion("registration_no not between", value1, value2, "registrationNo");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathIsNull() {
			addCriterion("registration_path is null");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathIsNotNull() {
			addCriterion("registration_path is not null");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathEqualTo(String value) {
			addCriterion("registration_path =", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathNotEqualTo(String value) {
			addCriterion("registration_path <>", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathGreaterThan(String value) {
			addCriterion("registration_path >", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathGreaterThanOrEqualTo(String value) {
			addCriterion("registration_path >=", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathLessThan(String value) {
			addCriterion("registration_path <", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathLessThanOrEqualTo(String value) {
			addCriterion("registration_path <=", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathLike(String value) {
			addCriterion("registration_path like", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathNotLike(String value) {
			addCriterion("registration_path not like", value, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathIn(List<String> values) {
			addCriterion("registration_path in", values, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathNotIn(List<String> values) {
			addCriterion("registration_path not in", values, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathBetween(String value1, String value2) {
			addCriterion("registration_path between", value1, value2, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andRegistrationPathNotBetween(String value1, String value2) {
			addCriterion("registration_path not between", value1, value2, "registrationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoIsNull() {
			addCriterion("organization_no is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoIsNotNull() {
			addCriterion("organization_no is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoEqualTo(String value) {
			addCriterion("organization_no =", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoNotEqualTo(String value) {
			addCriterion("organization_no <>", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoGreaterThan(String value) {
			addCriterion("organization_no >", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoGreaterThanOrEqualTo(String value) {
			addCriterion("organization_no >=", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoLessThan(String value) {
			addCriterion("organization_no <", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoLessThanOrEqualTo(String value) {
			addCriterion("organization_no <=", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoLike(String value) {
			addCriterion("organization_no like", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoNotLike(String value) {
			addCriterion("organization_no not like", value, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoIn(List<String> values) {
			addCriterion("organization_no in", values, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoNotIn(List<String> values) {
			addCriterion("organization_no not in", values, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoBetween(String value1, String value2) {
			addCriterion("organization_no between", value1, value2, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationNoNotBetween(String value1, String value2) {
			addCriterion("organization_no not between", value1, value2, "organizationNo");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNull() {
			addCriterion("organization_path is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNotNull() {
			addCriterion("organization_path is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathEqualTo(String value) {
			addCriterion("organization_path =", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotEqualTo(String value) {
			addCriterion("organization_path <>", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThan(String value) {
			addCriterion("organization_path >", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThanOrEqualTo(String value) {
			addCriterion("organization_path >=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThan(String value) {
			addCriterion("organization_path <", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThanOrEqualTo(String value) {
			addCriterion("organization_path <=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLike(String value) {
			addCriterion("organization_path like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotLike(String value) {
			addCriterion("organization_path not like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIn(List<String> values) {
			addCriterion("organization_path in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotIn(List<String> values) {
			addCriterion("organization_path not in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathBetween(String value1, String value2) {
			addCriterion("organization_path between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotBetween(String value1, String value2) {
			addCriterion("organization_path not between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andTaxNoIsNull() {
			addCriterion("tax_no is null");
			return (Criteria) this;
		}

		public Criteria andTaxNoIsNotNull() {
			addCriterion("tax_no is not null");
			return (Criteria) this;
		}

		public Criteria andTaxNoEqualTo(String value) {
			addCriterion("tax_no =", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoNotEqualTo(String value) {
			addCriterion("tax_no <>", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoGreaterThan(String value) {
			addCriterion("tax_no >", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoGreaterThanOrEqualTo(String value) {
			addCriterion("tax_no >=", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoLessThan(String value) {
			addCriterion("tax_no <", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoLessThanOrEqualTo(String value) {
			addCriterion("tax_no <=", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoLike(String value) {
			addCriterion("tax_no like", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoNotLike(String value) {
			addCriterion("tax_no not like", value, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoIn(List<String> values) {
			addCriterion("tax_no in", values, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoNotIn(List<String> values) {
			addCriterion("tax_no not in", values, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoBetween(String value1, String value2) {
			addCriterion("tax_no between", value1, value2, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxNoNotBetween(String value1, String value2) {
			addCriterion("tax_no not between", value1, value2, "taxNo");
			return (Criteria) this;
		}

		public Criteria andTaxPathIsNull() {
			addCriterion("tax_path is null");
			return (Criteria) this;
		}

		public Criteria andTaxPathIsNotNull() {
			addCriterion("tax_path is not null");
			return (Criteria) this;
		}

		public Criteria andTaxPathEqualTo(String value) {
			addCriterion("tax_path =", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathNotEqualTo(String value) {
			addCriterion("tax_path <>", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathGreaterThan(String value) {
			addCriterion("tax_path >", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathGreaterThanOrEqualTo(String value) {
			addCriterion("tax_path >=", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathLessThan(String value) {
			addCriterion("tax_path <", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathLessThanOrEqualTo(String value) {
			addCriterion("tax_path <=", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathLike(String value) {
			addCriterion("tax_path like", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathNotLike(String value) {
			addCriterion("tax_path not like", value, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathIn(List<String> values) {
			addCriterion("tax_path in", values, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathNotIn(List<String> values) {
			addCriterion("tax_path not in", values, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathBetween(String value1, String value2) {
			addCriterion("tax_path between", value1, value2, "taxPath");
			return (Criteria) this;
		}

		public Criteria andTaxPathNotBetween(String value1, String value2) {
			addCriterion("tax_path not between", value1, value2, "taxPath");
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

		public Criteria andUpdateByEqualTo(String value) {
			addCriterion("update_by =", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotEqualTo(String value) {
			addCriterion("update_by <>", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThan(String value) {
			addCriterion("update_by >", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
			addCriterion("update_by >=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThan(String value) {
			addCriterion("update_by <", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThanOrEqualTo(String value) {
			addCriterion("update_by <=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLike(String value) {
			addCriterion("update_by like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotLike(String value) {
			addCriterion("update_by not like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByIn(List<String> values) {
			addCriterion("update_by in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotIn(List<String> values) {
			addCriterion("update_by not in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByBetween(String value1, String value2) {
			addCriterion("update_by between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotBetween(String value1, String value2) {
			addCriterion("update_by not between", value1, value2, "updateBy");
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