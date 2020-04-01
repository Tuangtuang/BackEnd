package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ieltsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ieltsExample() {
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

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andOverallIsNull() {
            addCriterion("overall is null");
            return (Criteria) this;
        }

        public Criteria andOverallIsNotNull() {
            addCriterion("overall is not null");
            return (Criteria) this;
        }

        public Criteria andOverallEqualTo(Double value) {
            addCriterion("overall =", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotEqualTo(Double value) {
            addCriterion("overall <>", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallGreaterThan(Double value) {
            addCriterion("overall >", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallGreaterThanOrEqualTo(Double value) {
            addCriterion("overall >=", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallLessThan(Double value) {
            addCriterion("overall <", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallLessThanOrEqualTo(Double value) {
            addCriterion("overall <=", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallIn(List<Double> values) {
            addCriterion("overall in", values, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotIn(List<Double> values) {
            addCriterion("overall not in", values, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallBetween(Double value1, Double value2) {
            addCriterion("overall between", value1, value2, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotBetween(Double value1, Double value2) {
            addCriterion("overall not between", value1, value2, "overall");
            return (Criteria) this;
        }

        public Criteria andSpeakingIsNull() {
            addCriterion("speaking is null");
            return (Criteria) this;
        }

        public Criteria andSpeakingIsNotNull() {
            addCriterion("speaking is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakingEqualTo(Double value) {
            addCriterion("speaking =", value, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingNotEqualTo(Double value) {
            addCriterion("speaking <>", value, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingGreaterThan(Double value) {
            addCriterion("speaking >", value, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingGreaterThanOrEqualTo(Double value) {
            addCriterion("speaking >=", value, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingLessThan(Double value) {
            addCriterion("speaking <", value, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingLessThanOrEqualTo(Double value) {
            addCriterion("speaking <=", value, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingIn(List<Double> values) {
            addCriterion("speaking in", values, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingNotIn(List<Double> values) {
            addCriterion("speaking not in", values, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingBetween(Double value1, Double value2) {
            addCriterion("speaking between", value1, value2, "speaking");
            return (Criteria) this;
        }

        public Criteria andSpeakingNotBetween(Double value1, Double value2) {
            addCriterion("speaking not between", value1, value2, "speaking");
            return (Criteria) this;
        }

        public Criteria andReadingIsNull() {
            addCriterion("reading is null");
            return (Criteria) this;
        }

        public Criteria andReadingIsNotNull() {
            addCriterion("reading is not null");
            return (Criteria) this;
        }

        public Criteria andReadingEqualTo(Double value) {
            addCriterion("reading =", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingNotEqualTo(Double value) {
            addCriterion("reading <>", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingGreaterThan(Double value) {
            addCriterion("reading >", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingGreaterThanOrEqualTo(Double value) {
            addCriterion("reading >=", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingLessThan(Double value) {
            addCriterion("reading <", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingLessThanOrEqualTo(Double value) {
            addCriterion("reading <=", value, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingIn(List<Double> values) {
            addCriterion("reading in", values, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingNotIn(List<Double> values) {
            addCriterion("reading not in", values, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingBetween(Double value1, Double value2) {
            addCriterion("reading between", value1, value2, "reading");
            return (Criteria) this;
        }

        public Criteria andReadingNotBetween(Double value1, Double value2) {
            addCriterion("reading not between", value1, value2, "reading");
            return (Criteria) this;
        }

        public Criteria andListeningIsNull() {
            addCriterion("listening is null");
            return (Criteria) this;
        }

        public Criteria andListeningIsNotNull() {
            addCriterion("listening is not null");
            return (Criteria) this;
        }

        public Criteria andListeningEqualTo(Double value) {
            addCriterion("listening =", value, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningNotEqualTo(Double value) {
            addCriterion("listening <>", value, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningGreaterThan(Double value) {
            addCriterion("listening >", value, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningGreaterThanOrEqualTo(Double value) {
            addCriterion("listening >=", value, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningLessThan(Double value) {
            addCriterion("listening <", value, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningLessThanOrEqualTo(Double value) {
            addCriterion("listening <=", value, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningIn(List<Double> values) {
            addCriterion("listening in", values, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningNotIn(List<Double> values) {
            addCriterion("listening not in", values, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningBetween(Double value1, Double value2) {
            addCriterion("listening between", value1, value2, "listening");
            return (Criteria) this;
        }

        public Criteria andListeningNotBetween(Double value1, Double value2) {
            addCriterion("listening not between", value1, value2, "listening");
            return (Criteria) this;
        }

        public Criteria andWritingIsNull() {
            addCriterion("writing is null");
            return (Criteria) this;
        }

        public Criteria andWritingIsNotNull() {
            addCriterion("writing is not null");
            return (Criteria) this;
        }

        public Criteria andWritingEqualTo(Double value) {
            addCriterion("writing =", value, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingNotEqualTo(Double value) {
            addCriterion("writing <>", value, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingGreaterThan(Double value) {
            addCriterion("writing >", value, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingGreaterThanOrEqualTo(Double value) {
            addCriterion("writing >=", value, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingLessThan(Double value) {
            addCriterion("writing <", value, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingLessThanOrEqualTo(Double value) {
            addCriterion("writing <=", value, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingIn(List<Double> values) {
            addCriterion("writing in", values, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingNotIn(List<Double> values) {
            addCriterion("writing not in", values, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingBetween(Double value1, Double value2) {
            addCriterion("writing between", value1, value2, "writing");
            return (Criteria) this;
        }

        public Criteria andWritingNotBetween(Double value1, Double value2) {
            addCriterion("writing not between", value1, value2, "writing");
            return (Criteria) this;
        }

        public Criteria andTestDateIsNull() {
            addCriterion("test_date is null");
            return (Criteria) this;
        }

        public Criteria andTestDateIsNotNull() {
            addCriterion("test_date is not null");
            return (Criteria) this;
        }

        public Criteria andTestDateEqualTo(Date value) {
            addCriterion("test_date =", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateNotEqualTo(Date value) {
            addCriterion("test_date <>", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateGreaterThan(Date value) {
            addCriterion("test_date >", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateGreaterThanOrEqualTo(Date value) {
            addCriterion("test_date >=", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateLessThan(Date value) {
            addCriterion("test_date <", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateLessThanOrEqualTo(Date value) {
            addCriterion("test_date <=", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateIn(List<Date> values) {
            addCriterion("test_date in", values, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateNotIn(List<Date> values) {
            addCriterion("test_date not in", values, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateBetween(Date value1, Date value2) {
            addCriterion("test_date between", value1, value2, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateNotBetween(Date value1, Date value2) {
            addCriterion("test_date not between", value1, value2, "testDate");
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