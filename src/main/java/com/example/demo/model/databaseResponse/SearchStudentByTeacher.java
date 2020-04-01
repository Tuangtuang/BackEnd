package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description:教师搜索学生信息
 * @author: tyq
 * @create:
 **/
public class SearchStudentByTeacher {
    Integer studentId;
    String studentName;
    String grade;
    String school;

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getGrade() {
        return grade;
    }

    public String getSchool() {
        return school;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
