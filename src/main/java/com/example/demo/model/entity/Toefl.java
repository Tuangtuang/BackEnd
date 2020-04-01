package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Toefl {
    private Integer id;

    private Integer stuId;

    private Double overall;

    private Double speaking;

    private Double writing;

    private Double reading;

    private Double listening;

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

    public Double getSpeaking() {
        return speaking;
    }

    public void setSpeaking(Double speaking) {
        this.speaking = speaking;
    }

    public Double getWriting() {
        return writing;
    }

    public void setWriting(Double writing) {
        this.writing = writing;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public Double getListening() {
        return listening;
    }

    public void setListening(Double listening) {
        this.listening = listening;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }
}