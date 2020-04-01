package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Lsat {
    private Integer id;

    private Integer stuId;

    private Double overall;

    private Double overallPercentile;

    private Double reading;

    private Double readingPercentile;

    private Double logic;

    private Double logicPercentile;

    private Double analysis;

    private Double analysisPercentile;

    private Timestamp testDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Double getOverall() {
        return overall;
    }

    public void setOverall(Double overall) {
        this.overall = overall;
    }

    public Double getOverallPercentile() {
        return overallPercentile;
    }

    public void setOverallPercentile(Double overallPercentile) {
        this.overallPercentile = overallPercentile;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public Double getReadingPercentile() {
        return readingPercentile;
    }

    public void setReadingPercentile(Double readingPercentile) {
        this.readingPercentile = readingPercentile;
    }

    public Double getLogic() {
        return logic;
    }

    public void setLogic(Double logic) {
        this.logic = logic;
    }

    public Double getLogicPercentile() {
        return logicPercentile;
    }

    public void setLogicPercentile(Double logicPercentile) {
        this.logicPercentile = logicPercentile;
    }

    public Double getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Double analysis) {
        this.analysis = analysis;
    }

    public Double getAnalysisPercentile() {
        return analysisPercentile;
    }

    public void setAnalysisPercentile(Double analysisPercentile) {
        this.analysisPercentile = analysisPercentile;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }
}