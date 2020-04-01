package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 老师管理的学生信息
 * @author: tyq
 * @create:
 **/

public class MyStudentInfo {
    private Integer id;
    private String name;
    private String grade;
    private String school;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getSchool() {
        return school;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
