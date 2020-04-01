package com.example.demo.service;

import com.example.demo.model.manager.*;
import com.example.demo.model.overview.Result;

import javax.servlet.http.HttpServletResponse;

public interface ManagerService {

//    管理员获取学生列表接口 #77
    Result getStudentList(String managerId,String studentId,String studentName);

//    管理员获取学生基本信息接口 #78
    Result getStudentBasicInfo(String managerId,String studentId);

//    管理员修改学生基本信息接口 #79
    Result modifyStudentInfoManager(ModifyStudentBasicInfo modifyStudentBasicInfo);

//    管理员创建学生接口 #80
    Result createStudent(AddStudentInfo addStudentInfo);

//    管理员创建教师接口 #81
    Result createTeacher(AddTeacherInfo addTeacherInfo);

//    管理员搜索教师接口 #82
    Result getTeacherList(String managerId,String teacherId,String teacherName);

//    管理员删除教师接口 #83
    Result deleteTeacher(DeleteTeacher deleteTeacher);

//    管理员获取教师基本信息接口 #84
    Result getTeacherBasicInfo(String managerId,String teacherId);

//    管理员修改教师基本信息接口 #85
    Result modifyTeacherInfoManager(ModifyTeacherBasicInfo modifyTeacherBasicInfo);

//    管理员修改师生关联接口 #86
    Result updateTeacherStudentRelationship(TeacherStudentRelation teacherStudentRelation);

    //    管理员获取师生关系列表接口（教师） #87
    Result getRelationshipFromTeacher(String userId,String teacherId, String studentId, String studentName);

    //    管理员获取师生关系列表接口（学生） #89
    Result getRelationshipFromStudent(String userId, String studentId, String teacherId, String teacherName);


    //    管理员获取学生步骤条进度接口 #91
    Result getApplyState(String managerId, String studentId);


//    管理员删除学生接口 #76
    Result deleteStudent(String studentId,String managerId);


    //    下载压缩文件接口
    void downLoadZipFile(String fileName, String url, String userId, String studentId, HttpServletResponse httpServletResponse);




}

