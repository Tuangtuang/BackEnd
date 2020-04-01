package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 获取教师和学生信息
 * @author: tyq
 * @create:
 **/

public class TeacherStudentNameInfo {
    String studentName;
    Integer studentId;

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
