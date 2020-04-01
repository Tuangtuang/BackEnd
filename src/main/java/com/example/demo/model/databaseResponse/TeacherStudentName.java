package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 学生表和师生表连接
 * @author: tyq
 * @create:
 **/

public class TeacherStudentName {
    Integer stuId;
    String studentName;
    Integer tag;

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getStuId() {
        return stuId;
    }


    public String getStudentName() {
        return studentName;
    }

    public Integer getTag() {
        return tag;
    }
}
