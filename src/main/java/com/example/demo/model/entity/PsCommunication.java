package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class PsCommunication {
    private Integer id;

    private Integer tblStuSchoolPsId;

    private Integer versionId;

    private Integer peopleId;

    private Timestamp time;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblStuSchoolPsId() {
        return tblStuSchoolPsId;
    }

    public void setTblStuSchoolPsId(Integer tblStuSchoolPsId) {
        this.tblStuSchoolPsId = tblStuSchoolPsId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
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

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}