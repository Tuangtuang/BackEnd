package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Gmat {
    private Integer id;

    private Integer stuId;

    private Double overall;

    private Double overallPercentile;

    private Double verbal;

    private Double verbalPercentile;

    private Double quantitative;

    private Double quantitativePercentite;

    private Double writing;

    private Double writingPercentile;

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

    public Double getVerbal() {
        return verbal;
    }

    public void setVerbal(Double verbal) {
        this.verbal = verbal;
    }

    public Double getVerbalPercentile() {
        return verbalPercentile;
    }

    public void setVerbalPercentile(Double verbalPercentile) {
        this.verbalPercentile = verbalPercentile;
    }

    public Double getQuantitative() {
        return quantitative;
    }

    public void setQuantitative(Double quantitative) {
        this.quantitative = quantitative;
    }

    public Double getQuantitativePercentite() {
        return quantitativePercentite;
    }

    public void setQuantitativePercentite(Double quantitativePercentite) {
        this.quantitativePercentite = quantitativePercentite;
    }

    public Double getWriting() {
        return writing;
    }

    public void setWriting(Double writing) {
        this.writing = writing;
    }

    public Double getWritingPercentile() {
        return writingPercentile;
    }

    public void setWritingPercentile(Double writingPercentile) {
        this.writingPercentile = writingPercentile;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }
}