package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OtherInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OtherInfoExample() {
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

        public Criteria andPassportIsNull() {
            addCriterion("passport is null");
            return (Criteria) this;
        }

        public Criteria andPassportIsNotNull() {
            addCriterion("passport is not null");
            return (Criteria) this;
        }

        public Criteria andPassportEqualTo(Date value) {
            addCriterion("passport =", value, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportNotEqualTo(Date value) {
            addCriterion("passport <>", value, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportGreaterThan(Date value) {
            addCriterion("passport >", value, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportGreaterThanOrEqualTo(Date value) {
            addCriterion("passport >=", value, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportLessThan(Date value) {
            addCriterion("passport <", value, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportLessThanOrEqualTo(Date value) {
            addCriterion("passport <=", value, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportIn(List<Date> values) {
            addCriterion("passport in", values, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportNotIn(List<Date> values) {
            addCriterion("passport not in", values, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportBetween(Date value1, Date value2) {
            addCriterion("passport between", value1, value2, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportNotBetween(Date value1, Date value2) {
            addCriterion("passport not between", value1, value2, "passport");
            return (Criteria) this;
        }

        public Criteria andPassportStateIsNull() {
            addCriterion("passport_state is null");
            return (Criteria) this;
        }

        public Criteria andPassportStateIsNotNull() {
            addCriterion("passport_state is not null");
            return (Criteria) this;
        }

        public Criteria andPassportStateEqualTo(Integer value) {
            addCriterion("passport_state =", value, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateNotEqualTo(Integer value) {
            addCriterion("passport_state <>", value, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateGreaterThan(Integer value) {
            addCriterion("passport_state >", value, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("passport_state >=", value, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateLessThan(Integer value) {
            addCriterion("passport_state <", value, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateLessThanOrEqualTo(Integer value) {
            addCriterion("passport_state <=", value, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateIn(List<Integer> values) {
            addCriterion("passport_state in", values, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateNotIn(List<Integer> values) {
            addCriterion("passport_state not in", values, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateBetween(Integer value1, Integer value2) {
            addCriterion("passport_state between", value1, value2, "passportState");
            return (Criteria) this;
        }

        public Criteria andPassportStateNotBetween(Integer value1, Integer value2) {
            addCriterion("passport_state not between", value1, value2, "passportState");
            return (Criteria) this;
        }

        public Criteria andVaccineIsNull() {
            addCriterion("vaccine is null");
            return (Criteria) this;
        }

        public Criteria andVaccineIsNotNull() {
            addCriterion("vaccine is not null");
            return (Criteria) this;
        }

        public Criteria andVaccineEqualTo(Date value) {
            addCriterion("vaccine =", value, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineNotEqualTo(Date value) {
            addCriterion("vaccine <>", value, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineGreaterThan(Date value) {
            addCriterion("vaccine >", value, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineGreaterThanOrEqualTo(Date value) {
            addCriterion("vaccine >=", value, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineLessThan(Date value) {
            addCriterion("vaccine <", value, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineLessThanOrEqualTo(Date value) {
            addCriterion("vaccine <=", value, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineIn(List<Date> values) {
            addCriterion("vaccine in", values, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineNotIn(List<Date> values) {
            addCriterion("vaccine not in", values, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineBetween(Date value1, Date value2) {
            addCriterion("vaccine between", value1, value2, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineNotBetween(Date value1, Date value2) {
            addCriterion("vaccine not between", value1, value2, "vaccine");
            return (Criteria) this;
        }

        public Criteria andVaccineStateIsNull() {
            addCriterion("vaccine_state is null");
            return (Criteria) this;
        }

        public Criteria andVaccineStateIsNotNull() {
            addCriterion("vaccine_state is not null");
            return (Criteria) this;
        }

        public Criteria andVaccineStateEqualTo(Integer value) {
            addCriterion("vaccine_state =", value, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateNotEqualTo(Integer value) {
            addCriterion("vaccine_state <>", value, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateGreaterThan(Integer value) {
            addCriterion("vaccine_state >", value, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("vaccine_state >=", value, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateLessThan(Integer value) {
            addCriterion("vaccine_state <", value, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateLessThanOrEqualTo(Integer value) {
            addCriterion("vaccine_state <=", value, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateIn(List<Integer> values) {
            addCriterion("vaccine_state in", values, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateNotIn(List<Integer> values) {
            addCriterion("vaccine_state not in", values, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateBetween(Integer value1, Integer value2) {
            addCriterion("vaccine_state between", value1, value2, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andVaccineStateNotBetween(Integer value1, Integer value2) {
            addCriterion("vaccine_state not between", value1, value2, "vaccineState");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(Date value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Date value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Date value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Date value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Date value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Date value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Date> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Date> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Date value1, Date value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Date value1, Date value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositStateIsNull() {
            addCriterion("deposit_state is null");
            return (Criteria) this;
        }

        public Criteria andDepositStateIsNotNull() {
            addCriterion("deposit_state is not null");
            return (Criteria) this;
        }

        public Criteria andDepositStateEqualTo(Integer value) {
            addCriterion("deposit_state =", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotEqualTo(Integer value) {
            addCriterion("deposit_state <>", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateGreaterThan(Integer value) {
            addCriterion("deposit_state >", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("deposit_state >=", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateLessThan(Integer value) {
            addCriterion("deposit_state <", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateLessThanOrEqualTo(Integer value) {
            addCriterion("deposit_state <=", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateIn(List<Integer> values) {
            addCriterion("deposit_state in", values, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotIn(List<Integer> values) {
            addCriterion("deposit_state not in", values, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateBetween(Integer value1, Integer value2) {
            addCriterion("deposit_state between", value1, value2, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotBetween(Integer value1, Integer value2) {
            addCriterion("deposit_state not between", value1, value2, "depositState");
            return (Criteria) this;
        }

        public Criteria andDormitoryIsNull() {
            addCriterion("dormitory is null");
            return (Criteria) this;
        }

        public Criteria andDormitoryIsNotNull() {
            addCriterion("dormitory is not null");
            return (Criteria) this;
        }

        public Criteria andDormitoryEqualTo(Date value) {
            addCriterion("dormitory =", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotEqualTo(Date value) {
            addCriterion("dormitory <>", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryGreaterThan(Date value) {
            addCriterion("dormitory >", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryGreaterThanOrEqualTo(Date value) {
            addCriterion("dormitory >=", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryLessThan(Date value) {
            addCriterion("dormitory <", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryLessThanOrEqualTo(Date value) {
            addCriterion("dormitory <=", value, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryIn(List<Date> values) {
            addCriterion("dormitory in", values, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotIn(List<Date> values) {
            addCriterion("dormitory not in", values, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryBetween(Date value1, Date value2) {
            addCriterion("dormitory between", value1, value2, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryNotBetween(Date value1, Date value2) {
            addCriterion("dormitory not between", value1, value2, "dormitory");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateIsNull() {
            addCriterion("dormitory_state is null");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateIsNotNull() {
            addCriterion("dormitory_state is not null");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateEqualTo(Integer value) {
            addCriterion("dormitory_state =", value, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateNotEqualTo(Integer value) {
            addCriterion("dormitory_state <>", value, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateGreaterThan(Integer value) {
            addCriterion("dormitory_state >", value, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("dormitory_state >=", value, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateLessThan(Integer value) {
            addCriterion("dormitory_state <", value, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateLessThanOrEqualTo(Integer value) {
            addCriterion("dormitory_state <=", value, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateIn(List<Integer> values) {
            addCriterion("dormitory_state in", values, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateNotIn(List<Integer> values) {
            addCriterion("dormitory_state not in", values, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateBetween(Integer value1, Integer value2) {
            addCriterion("dormitory_state between", value1, value2, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andDormitoryStateNotBetween(Integer value1, Integer value2) {
            addCriterion("dormitory_state not between", value1, value2, "dormitoryState");
            return (Criteria) this;
        }

        public Criteria andTestIsNull() {
            addCriterion("test is null");
            return (Criteria) this;
        }

        public Criteria andTestIsNotNull() {
            addCriterion("test is not null");
            return (Criteria) this;
        }

        public Criteria andTestEqualTo(Date value) {
            addCriterion("test =", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotEqualTo(Date value) {
            addCriterion("test <>", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestGreaterThan(Date value) {
            addCriterion("test >", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestGreaterThanOrEqualTo(Date value) {
            addCriterion("test >=", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLessThan(Date value) {
            addCriterion("test <", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLessThanOrEqualTo(Date value) {
            addCriterion("test <=", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestIn(List<Date> values) {
            addCriterion("test in", values, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotIn(List<Date> values) {
            addCriterion("test not in", values, "test");
            return (Criteria) this;
        }

        public Criteria andTestBetween(Date value1, Date value2) {
            addCriterion("test between", value1, value2, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotBetween(Date value1, Date value2) {
            addCriterion("test not between", value1, value2, "test");
            return (Criteria) this;
        }

        public Criteria andTestStateIsNull() {
            addCriterion("test_state is null");
            return (Criteria) this;
        }

        public Criteria andTestStateIsNotNull() {
            addCriterion("test_state is not null");
            return (Criteria) this;
        }

        public Criteria andTestStateEqualTo(Integer value) {
            addCriterion("test_state =", value, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateNotEqualTo(Integer value) {
            addCriterion("test_state <>", value, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateGreaterThan(Integer value) {
            addCriterion("test_state >", value, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_state >=", value, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateLessThan(Integer value) {
            addCriterion("test_state <", value, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateLessThanOrEqualTo(Integer value) {
            addCriterion("test_state <=", value, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateIn(List<Integer> values) {
            addCriterion("test_state in", values, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateNotIn(List<Integer> values) {
            addCriterion("test_state not in", values, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateBetween(Integer value1, Integer value2) {
            addCriterion("test_state between", value1, value2, "testState");
            return (Criteria) this;
        }

        public Criteria andTestStateNotBetween(Integer value1, Integer value2) {
            addCriterion("test_state not between", value1, value2, "testState");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Date value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Date value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Date value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Date value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Date value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Date value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Date> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Date> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Date value1, Date value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Date value1, Date value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeStateIsNull() {
            addCriterion("fee_state is null");
            return (Criteria) this;
        }

        public Criteria andFeeStateIsNotNull() {
            addCriterion("fee_state is not null");
            return (Criteria) this;
        }

        public Criteria andFeeStateEqualTo(Integer value) {
            addCriterion("fee_state =", value, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateNotEqualTo(Integer value) {
            addCriterion("fee_state <>", value, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateGreaterThan(Integer value) {
            addCriterion("fee_state >", value, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_state >=", value, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateLessThan(Integer value) {
            addCriterion("fee_state <", value, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateLessThanOrEqualTo(Integer value) {
            addCriterion("fee_state <=", value, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateIn(List<Integer> values) {
            addCriterion("fee_state in", values, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateNotIn(List<Integer> values) {
            addCriterion("fee_state not in", values, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateBetween(Integer value1, Integer value2) {
            addCriterion("fee_state between", value1, value2, "feeState");
            return (Criteria) this;
        }

        public Criteria andFeeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_state not between", value1, value2, "feeState");
            return (Criteria) this;
        }

        public Criteria andDocumentIsNull() {
            addCriterion("document is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIsNotNull() {
            addCriterion("document is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentEqualTo(Date value) {
            addCriterion("document =", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotEqualTo(Date value) {
            addCriterion("document <>", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentGreaterThan(Date value) {
            addCriterion("document >", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentGreaterThanOrEqualTo(Date value) {
            addCriterion("document >=", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLessThan(Date value) {
            addCriterion("document <", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLessThanOrEqualTo(Date value) {
            addCriterion("document <=", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentIn(List<Date> values) {
            addCriterion("document in", values, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotIn(List<Date> values) {
            addCriterion("document not in", values, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentBetween(Date value1, Date value2) {
            addCriterion("document between", value1, value2, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotBetween(Date value1, Date value2) {
            addCriterion("document not between", value1, value2, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentStateIsNull() {
            addCriterion("document_state is null");
            return (Criteria) this;
        }

        public Criteria andDocumentStateIsNotNull() {
            addCriterion("document_state is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentStateEqualTo(Integer value) {
            addCriterion("document_state =", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateNotEqualTo(Integer value) {
            addCriterion("document_state <>", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateGreaterThan(Integer value) {
            addCriterion("document_state >", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_state >=", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateLessThan(Integer value) {
            addCriterion("document_state <", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateLessThanOrEqualTo(Integer value) {
            addCriterion("document_state <=", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateIn(List<Integer> values) {
            addCriterion("document_state in", values, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateNotIn(List<Integer> values) {
            addCriterion("document_state not in", values, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateBetween(Integer value1, Integer value2) {
            addCriterion("document_state between", value1, value2, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateNotBetween(Integer value1, Integer value2) {
            addCriterion("document_state not between", value1, value2, "documentState");
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