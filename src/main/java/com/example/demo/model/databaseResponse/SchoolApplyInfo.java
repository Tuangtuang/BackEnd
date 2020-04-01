package com.example.demo.model.databaseResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
public class SchoolApplyInfo {
    private Integer id;
    private String schoolName;
    private String projectName;
    private Integer stepNum;
    private String link;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return schoolName;
    }

    public String getProjectName() {
        return projectName;
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public String getLink() {
        return link;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.schoolName= name;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
