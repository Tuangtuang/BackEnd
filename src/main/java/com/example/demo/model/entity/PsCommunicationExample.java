package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PsCommunicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PsCommunicationExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdIsNull() {
            addCriterion("tbl_stu_school_ps_id is null");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdIsNotNull() {
            addCriterion("tbl_stu_school_ps_id is not null");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdEqualTo(Integer value) {
            addCriterion("tbl_stu_school_ps_id =", value, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdNotEqualTo(Integer value) {
            addCriterion("tbl_stu_school_ps_id <>", value, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdGreaterThan(Integer value) {
            addCriterion("tbl_stu_school_ps_id >", value, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tbl_stu_school_ps_id >=", value, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdLessThan(Integer value) {
            addCriterion("tbl_stu_school_ps_id <", value, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdLessThanOrEqualTo(Integer value) {
            addCriterion("tbl_stu_school_ps_id <=", value, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdIn(List<Integer> values) {
            addCriterion("tbl_stu_school_ps_id in", values, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdNotIn(List<Integer> values) {
            addCriterion("tbl_stu_school_ps_id not in", values, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdBetween(Integer value1, Integer value2) {
            addCriterion("tbl_stu_school_ps_id between", value1, value2, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andTblStuSchoolPsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tbl_stu_school_ps_id not between", value1, value2, "tblStuSchoolPsId");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNull() {
            addCriterion("version_id is null");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNotNull() {
            addCriterion("version_id is not null");
            return (Criteria) this;
        }

        public Criteria andVersionIdEqualTo(Integer value) {
            addCriterion("version_id =", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotEqualTo(Integer value) {
            addCriterion("version_id <>", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThan(Integer value) {
            addCriterion("version_id >", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_id >=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThan(Integer value) {
            addCriterion("version_id <", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThanOrEqualTo(Integer value) {
            addCriterion("version_id <=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdIn(List<Integer> values) {
            addCriterion("version_id in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotIn(List<Integer> values) {
            addCriterion("version_id not in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdBetween(Integer value1, Integer value2) {
            addCriterion("version_id between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("version_id not between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdIsNull() {
            addCriterion("people_id is null");
            return (Criteria) this;
        }

        public Criteria andPeopleIdIsNotNull() {
            addCriterion("people_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleIdEqualTo(Integer value) {
            addCriterion("people_id =", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotEqualTo(Integer value) {
            addCriterion("people_id <>", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdGreaterThan(Integer value) {
            addCriterion("people_id >", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_id >=", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdLessThan(Integer value) {
            addCriterion("people_id <", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("people_id <=", value, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdIn(List<Integer> values) {
            addCriterion("people_id in", values, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotIn(List<Integer> values) {
            addCriterion("people_id not in", values, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("people_id between", value1, value2, "peopleId");
            return (Criteria) this;
        }

        public Criteria andPeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("people_id not between", value1, value2, "peopleId");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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