package com.example.demo.model.entity;

public class TaskWithBLOBs extends Task {
    private String content;

    private String teacherFilePath;

    private String stuFilePath;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTeacherFilePath() {
        return teacherFilePath;
    }

    public void setTeacherFilePath(String teacherFilePath) {
        this.teacherFilePath = teacherFilePath == null ? null : teacherFilePath.trim();
    }

    public String getStuFilePath() {
        return stuFilePath;
    }

    public void setStuFilePath(String stuFilePath) {
        this.stuFilePath = stuFilePath == null ? null : stuFilePath.trim();
    }
}