package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GreExample() {
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

        public Criteria andOverallPercentileIsNull() {
            addCriterion("overall_percentile is null");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileIsNotNull() {
            addCriterion("overall_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileEqualTo(Double value) {
            addCriterion("overall_percentile =", value, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileNotEqualTo(Double value) {
            addCriterion("overall_percentile <>", value, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileGreaterThan(Double value) {
            addCriterion("overall_percentile >", value, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("overall_percentile >=", value, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileLessThan(Double value) {
            addCriterion("overall_percentile <", value, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileLessThanOrEqualTo(Double value) {
            addCriterion("overall_percentile <=", value, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileIn(List<Double> values) {
            addCriterion("overall_percentile in", values, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileNotIn(List<Double> values) {
            addCriterion("overall_percentile not in", values, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileBetween(Double value1, Double value2) {
            addCriterion("overall_percentile between", value1, value2, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andOverallPercentileNotBetween(Double value1, Double value2) {
            addCriterion("overall_percentile not between", value1, value2, "overallPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalIsNull() {
            addCriterion("verbal is null");
            return (Criteria) this;
        }

        public Criteria andVerbalIsNotNull() {
            addCriterion("verbal is not null");
            return (Criteria) this;
        }

        public Criteria andVerbalEqualTo(Double value) {
            addCriterion("verbal =", value, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalNotEqualTo(Double value) {
            addCriterion("verbal <>", value, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalGreaterThan(Double value) {
            addCriterion("verbal >", value, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalGreaterThanOrEqualTo(Double value) {
            addCriterion("verbal >=", value, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalLessThan(Double value) {
            addCriterion("verbal <", value, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalLessThanOrEqualTo(Double value) {
            addCriterion("verbal <=", value, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalIn(List<Double> values) {
            addCriterion("verbal in", values, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalNotIn(List<Double> values) {
            addCriterion("verbal not in", values, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalBetween(Double value1, Double value2) {
            addCriterion("verbal between", value1, value2, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalNotBetween(Double value1, Double value2) {
            addCriterion("verbal not between", value1, value2, "verbal");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileIsNull() {
            addCriterion("verbal_percentile is null");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileIsNotNull() {
            addCriterion("verbal_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileEqualTo(Double value) {
            addCriterion("verbal_percentile =", value, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileNotEqualTo(Double value) {
            addCriterion("verbal_percentile <>", value, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileGreaterThan(Double value) {
            addCriterion("verbal_percentile >", value, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("verbal_percentile >=", value, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileLessThan(Double value) {
            addCriterion("verbal_percentile <", value, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileLessThanOrEqualTo(Double value) {
            addCriterion("verbal_percentile <=", value, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileIn(List<Double> values) {
            addCriterion("verbal_percentile in", values, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileNotIn(List<Double> values) {
            addCriterion("verbal_percentile not in", values, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileBetween(Double value1, Double value2) {
            addCriterion("verbal_percentile between", value1, value2, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andVerbalPercentileNotBetween(Double value1, Double value2) {
            addCriterion("verbal_percentile not between", value1, value2, "verbalPercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativeIsNull() {
            addCriterion("quantitative is null");
            return (Criteria) this;
        }

        public Criteria andQuantitativeIsNotNull() {
            addCriterion("quantitative is not null");
            return (Criteria) this;
        }

        public Criteria andQuantitativeEqualTo(Double value) {
            addCriterion("quantitative =", value, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeNotEqualTo(Double value) {
            addCriterion("quantitative <>", value, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeGreaterThan(Double value) {
            addCriterion("quantitative >", value, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeGreaterThanOrEqualTo(Double value) {
            addCriterion("quantitative >=", value, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeLessThan(Double value) {
            addCriterion("quantitative <", value, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeLessThanOrEqualTo(Double value) {
            addCriterion("quantitative <=", value, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeIn(List<Double> values) {
            addCriterion("quantitative in", values, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeNotIn(List<Double> values) {
            addCriterion("quantitative not in", values, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeBetween(Double value1, Double value2) {
            addCriterion("quantitative between", value1, value2, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativeNotBetween(Double value1, Double value2) {
            addCriterion("quantitative not between", value1, value2, "quantitative");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileIsNull() {
            addCriterion("quantitative_percentile is null");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileIsNotNull() {
            addCriterion("quantitative_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileEqualTo(Double value) {
            addCriterion("quantitative_percentile =", value, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileNotEqualTo(Double value) {
            addCriterion("quantitative_percentile <>", value, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileGreaterThan(Double value) {
            addCriterion("quantitative_percentile >", value, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("quantitative_percentile >=", value, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileLessThan(Double value) {
            addCriterion("quantitative_percentile <", value, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileLessThanOrEqualTo(Double value) {
            addCriterion("quantitative_percentile <=", value, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileIn(List<Double> values) {
            addCriterion("quantitative_percentile in", values, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileNotIn(List<Double> values) {
            addCriterion("quantitative_percentile not in", values, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileBetween(Double value1, Double value2) {
            addCriterion("quantitative_percentile between", value1, value2, "quantitativePercentile");
            return (Criteria) this;
        }

        public Criteria andQuantitativePercentileNotBetween(Double value1, Double value2) {
            addCriterion("quantitative_percentile not between", value1, value2, "quantitativePercentile");
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

        public Criteria andWritingPercentileIsNull() {
            addCriterion("writing_percentile is null");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileIsNotNull() {
            addCriterion("writing_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileEqualTo(Double value) {
            addCriterion("writing_percentile =", value, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileNotEqualTo(Double value) {
            addCriterion("writing_percentile <>", value, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileGreaterThan(Double value) {
            addCriterion("writing_percentile >", value, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("writing_percentile >=", value, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileLessThan(Double value) {
            addCriterion("writing_percentile <", value, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileLessThanOrEqualTo(Double value) {
            addCriterion("writing_percentile <=", value, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileIn(List<Double> values) {
            addCriterion("writing_percentile in", values, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileNotIn(List<Double> values) {
            addCriterion("writing_percentile not in", values, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileBetween(Double value1, Double value2) {
            addCriterion("writing_percentile between", value1, value2, "writingPercentile");
            return (Criteria) this;
        }

        public Criteria andWritingPercentileNotBetween(Double value1, Double value2) {
            addCriterion("writing_percentile not between", value1, value2, "writingPercentile");
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