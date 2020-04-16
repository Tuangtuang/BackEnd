package com.example.demo.controller;

import com.example.demo.model.homework.DeleteHomework;
import com.example.demo.model.overview.Result;
import com.example.demo.service.HomeworkService;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @description: 作业controller层
 * @author: tyq
 * @create:
 **/
@CrossOrigin
@RestController
public class HomeworkTaskController {

    @Resource
    private SchoolService schoolService;

    @Resource
    private HomeworkService homeworkService;

    @PostMapping("/insider/teaHomework/create")
    public Result createHomework(@RequestParam("userId")String teacherId,
                                 @RequestParam("studentId")String studentId,
                                 @RequestParam("name")String name,
                                 @RequestParam("deadline")String deadline,
                                 @RequestParam("file")MultipartFile file,
                                 HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.createHomework(studentId, name,deadline,file);
    }


    @PostMapping("/insider/teaHomework/delete")
    public Result deleteTask(@RequestBody DeleteHomework deleteHomework,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=deleteHomework.getTeacherId();
        String studentId=deleteHomework.getStudentId();
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.deleteHomework(deleteHomework.getHomeworkId());
    }

    @GetMapping("/insider/homework/history")
    public  Result getHistory(HttpServletRequest httpServletRequest,@RequestParam("userId")String studentId,@RequestParam("teaId")String teacherId){
        String token = httpServletRequest.getHeader("Authorization");

        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.getHistoryList(studentId);
    }

    @GetMapping("/insider/homework/current")
    public Result getCurrent(HttpServletRequest httpServletRequest,
                             @RequestParam("userId")String studentId,@RequestParam("teaId")String teacherId){
        String token = httpServletRequest.getHeader("Authorization");

        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.getCurrentList(studentId);
    }

    @GetMapping("/insider/homework/getDemand")
    public Result getDemmand(HttpServletRequest httpServletRequest,
                             @RequestParam("userId")String studentId,@RequestParam("teaId")String teacherId,
                             @RequestParam("homeworkId")String homeworkId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.getDemand(homeworkId);
    }

    @PostMapping("/insider/homework/handIn")
    public Result putStudentFile(HttpServletRequest httpServletRequest,
                                 @RequestParam("homeworkId")String homeworkId,
                                 @RequestParam("userId")String userId,
                                 @RequestParam("file") MultipartFile file){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if(id.equals(userId)==false){
            return ResultTool.error("token和id不匹配");
        }
        return homeworkService.putHomework(homeworkId,file,userId);
    }

    @GetMapping("/insider/homework/getFile")
    public Result getFile(HttpServletRequest httpServletRequest,
                          @RequestParam("userId")String studentId,
                          @RequestParam("teaId")String teacherId,
                          @RequestParam("homeworkId")String homeworkId,
                          HttpServletResponse httpServletResponse){

        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.getHomeworkFile(homeworkId,teacherId,studentId,httpServletResponse);
    }


    @GetMapping("/insider/homework/getCommittedFile")
    public Result getStudentFile(HttpServletRequest httpServletRequest,
                                 @RequestParam("userId")String studentId,
                                 @RequestParam("teaId")String teacherId,
                                 @RequestParam("homeworkId")String homeworkId,
                                 HttpServletResponse httpServletResponse){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return homeworkService.getHomeworkStudentFile(homeworkId,studentId,httpServletResponse);
    }


}
