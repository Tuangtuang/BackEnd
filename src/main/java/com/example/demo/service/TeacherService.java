package com.example.demo.service;

import com.example.demo.model.overview.Result;

public interface TeacherService {

//    教师获得学生信息接口 #65
    Result getStudentInfo(String teacherId);


//    教师条件搜索学生接口 #92
    Result searchStudent(String studentId,String studentName,String teacherId);
}
