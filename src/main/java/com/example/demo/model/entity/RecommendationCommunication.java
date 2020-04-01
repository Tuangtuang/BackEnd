package com.example.demo.model.entity;

import java.util.Date;

public class RecommendationCommunication {
    private Integer id;

    private Integer tblRecommendationId;

    private Integer versionId;

    private Integer peopleId;

    private Date time;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblRecommendationId() {
        return tblRecommendationId;
    }

    public void setTblRecommendationId(Integer tblRecommendationId) {
        this.tblRecommendationId = tblRecommendationId;
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