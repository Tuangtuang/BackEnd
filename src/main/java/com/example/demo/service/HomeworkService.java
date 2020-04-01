package com.example.demo.service;

import com.example.demo.model.overview.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface HomeworkService {

//    教师内部系统创建作业接口 #63
    Result createHomework(String studentId, String name, String deadline, MultipartFile file);

//    教师内部系统删除作业接口 #64
    Result deleteHomework(String taskId);

//    内部系统学生获取历史作业接口 #43
    Result getHistoryList(String userId);


//    内部系统学生获取当前作业接口 #44
    Result getCurrentList(String userId);

//    内部系统学生获取作业要求接口 #47
    Result getDemand(String homeworkId);

//    内部系统学生提交作业内容接口 #45
    Result putHomework(String homeworkId,MultipartFile file,String userId);

//    内部系统学生下载作业内容接口 #46
    Result getHomeworkFile(String homeworkId, String teacherId,
                           String userId, HttpServletResponse httpServletResponse);

//    内部系统学生下载已提交作业接口 #57
    Result getHomeworkStudentFile(String homeworkId,String userId,HttpServletResponse httpServletResponse);
}

