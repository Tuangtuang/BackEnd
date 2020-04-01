package com.example.demo.model.entity;

public class StuSchoolOther {
    private Integer id;

    private Integer versionId;

    private Integer stuSchoolId;

    private String name;

    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getStuSchoolId() {
        return stuSchoolId;
    }

    public void setStuSchoolId(Integer stuSchoolId) {
        this.stuSchoolId = stuSchoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}