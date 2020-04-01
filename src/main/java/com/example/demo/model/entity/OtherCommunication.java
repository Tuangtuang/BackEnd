package com.example.demo.model.entity;

import java.util.Date;

public class OtherCommunication {
    private Integer id;

    private Integer tblStuSchoolOtherId;

    private Integer peopleId;

    private Date time;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblStuSchoolOtherId() {
        return tblStuSchoolOtherId;
    }

    public void setTblStuSchoolOtherId(Integer tblStuSchoolOtherId) {
        this.tblStuSchoolOtherId = tblStuSchoolOtherId;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}