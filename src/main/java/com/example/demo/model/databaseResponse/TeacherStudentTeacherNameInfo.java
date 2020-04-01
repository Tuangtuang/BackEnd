package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 师生关系，通过学生id查找老师列表
 * @author: tyq
 * @create:
 **/
public class TeacherStudentTeacherNameInfo {
    String teacherName;
    Integer teacherId;

    public String getTeacherName() {
        return teacherName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
