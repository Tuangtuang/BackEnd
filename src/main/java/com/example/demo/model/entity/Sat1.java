package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Sat1 {
    private Integer id;

    private Integer stuId;

    private Double reading;

    private Double writing;

    private Double math;

    private Double essay;

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

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public Double getWriting() {
        return writing;
    }

    public void setWriting(Double writing) {
        this.writing = writing;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getEssay() {
        return essay;
    }

    public void setEssay(Double essay) {
        this.essay = essay;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }
}