package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 获取师生关联状态
 * @author: tyq
 * @create:
 **/
public class TeacherStudentTeacherName {
    Integer teacherId;
    Integer tag;
    String teacherName;

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setTag(Integer status) {
        this.tag = status;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public Integer getTag() {
        return tag;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
