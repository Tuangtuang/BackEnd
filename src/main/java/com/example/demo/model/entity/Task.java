package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
    private Integer id;

    private Integer teacherStuId;

    private Integer state;

    private Timestamp ddl;

    private Timestamp startTime;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherStuId() {
        return teacherStuId;
    }

    public void setTeacherStuId(Integer teacherStuId) {
        this.teacherStuId = teacherStuId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Timestamp ddl) {
        this.ddl = ddl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}