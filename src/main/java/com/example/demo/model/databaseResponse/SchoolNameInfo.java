package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 获取学校名称项目名称
 * @author: tyq
 * @create:
 **/
public class SchoolNameInfo {

    private String schoolName;
    private String projectName;
    private Integer studentSchoolId;
    private Integer state;

    public String getSchoolName() {
        return schoolName;
    }

    public String getProjectName() {
        return projectName;
    }

    public Integer getStudentSchoolId() {
        return studentSchoolId;
    }

    public Integer getState() {
        return state;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStudentSchoolId(Integer studentSchoolId) {
        this.studentSchoolId = studentSchoolId;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
