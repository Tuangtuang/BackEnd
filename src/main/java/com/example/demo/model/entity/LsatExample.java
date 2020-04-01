package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LsatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LsatExample() {
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

        public Criteria andReadingPercentileIsNull() {
            addCriterion("reading_percentile is null");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileIsNotNull() {
            addCriterion("reading_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileEqualTo(Double value) {
            addCriterion("reading_percentile =", value, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileNotEqualTo(Double value) {
            addCriterion("reading_percentile <>", value, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileGreaterThan(Double value) {
            addCriterion("reading_percentile >", value, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("reading_percentile >=", value, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileLessThan(Double value) {
            addCriterion("reading_percentile <", value, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileLessThanOrEqualTo(Double value) {
            addCriterion("reading_percentile <=", value, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileIn(List<Double> values) {
            addCriterion("reading_percentile in", values, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileNotIn(List<Double> values) {
            addCriterion("reading_percentile not in", values, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileBetween(Double value1, Double value2) {
            addCriterion("reading_percentile between", value1, value2, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andReadingPercentileNotBetween(Double value1, Double value2) {
            addCriterion("reading_percentile not between", value1, value2, "readingPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicIsNull() {
            addCriterion("logic is null");
            return (Criteria) this;
        }

        public Criteria andLogicIsNotNull() {
            addCriterion("logic is not null");
            return (Criteria) this;
        }

        public Criteria andLogicEqualTo(Double value) {
            addCriterion("logic =", value, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicNotEqualTo(Double value) {
            addCriterion("logic <>", value, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicGreaterThan(Double value) {
            addCriterion("logic >", value, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicGreaterThanOrEqualTo(Double value) {
            addCriterion("logic >=", value, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicLessThan(Double value) {
            addCriterion("logic <", value, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicLessThanOrEqualTo(Double value) {
            addCriterion("logic <=", value, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicIn(List<Double> values) {
            addCriterion("logic in", values, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicNotIn(List<Double> values) {
            addCriterion("logic not in", values, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicBetween(Double value1, Double value2) {
            addCriterion("logic between", value1, value2, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicNotBetween(Double value1, Double value2) {
            addCriterion("logic not between", value1, value2, "logic");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileIsNull() {
            addCriterion("logic_percentile is null");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileIsNotNull() {
            addCriterion("logic_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileEqualTo(Double value) {
            addCriterion("logic_percentile =", value, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileNotEqualTo(Double value) {
            addCriterion("logic_percentile <>", value, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileGreaterThan(Double value) {
            addCriterion("logic_percentile >", value, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("logic_percentile >=", value, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileLessThan(Double value) {
            addCriterion("logic_percentile <", value, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileLessThanOrEqualTo(Double value) {
            addCriterion("logic_percentile <=", value, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileIn(List<Double> values) {
            addCriterion("logic_percentile in", values, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileNotIn(List<Double> values) {
            addCriterion("logic_percentile not in", values, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileBetween(Double value1, Double value2) {
            addCriterion("logic_percentile between", value1, value2, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andLogicPercentileNotBetween(Double value1, Double value2) {
            addCriterion("logic_percentile not between", value1, value2, "logicPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNull() {
            addCriterion("analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNotNull() {
            addCriterion("analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisEqualTo(Double value) {
            addCriterion("analysis =", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotEqualTo(Double value) {
            addCriterion("analysis <>", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThan(Double value) {
            addCriterion("analysis >", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThanOrEqualTo(Double value) {
            addCriterion("analysis >=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThan(Double value) {
            addCriterion("analysis <", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThanOrEqualTo(Double value) {
            addCriterion("analysis <=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisIn(List<Double> values) {
            addCriterion("analysis in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotIn(List<Double> values) {
            addCriterion("analysis not in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisBetween(Double value1, Double value2) {
            addCriterion("analysis between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotBetween(Double value1, Double value2) {
            addCriterion("analysis not between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileIsNull() {
            addCriterion("analysis_percentile is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileIsNotNull() {
            addCriterion("analysis_percentile is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileEqualTo(Double value) {
            addCriterion("analysis_percentile =", value, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileNotEqualTo(Double value) {
            addCriterion("analysis_percentile <>", value, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileGreaterThan(Double value) {
            addCriterion("analysis_percentile >", value, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileGreaterThanOrEqualTo(Double value) {
            addCriterion("analysis_percentile >=", value, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileLessThan(Double value) {
            addCriterion("analysis_percentile <", value, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileLessThanOrEqualTo(Double value) {
            addCriterion("analysis_percentile <=", value, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileIn(List<Double> values) {
            addCriterion("analysis_percentile in", values, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileNotIn(List<Double> values) {
            addCriterion("analysis_percentile not in", values, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileBetween(Double value1, Double value2) {
            addCriterion("analysis_percentile between", value1, value2, "analysisPercentile");
            return (Criteria) this;
        }

        public Criteria andAnalysisPercentileNotBetween(Double value1, Double value2) {
            addCriterion("analysis_percentile not between", value1, value2, "analysisPercentile");
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