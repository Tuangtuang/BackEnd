package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 详细信息
 * @author: tyq
 * @create:
 **/
public class DetailVersionInfo {
    String schoolName;
    Integer id; //记录的主键
    String fileName;
    Integer version;

    public String getSchoolName() {
        return schoolName;
    }

    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
