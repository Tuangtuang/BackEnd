package com.example.demo.controller;

import com.example.demo.model.overview.Result;
import com.example.demo.service.TeacherService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 老师controller层
 * @author: tyq
 * @create:
 **/
@CrossOrigin
@RestController
public class TeacherController {


    @Resource
    TeacherService teacherService;


    @GetMapping("/insider/teaStudent/info")
    public Result getStudentList(@RequestParam("userId")String userId, HttpServletRequest httpServletRequest){
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
        return teacherService.getStudentInfo(userId);
    }


    @GetMapping("/insider/teacher/searchStudentList")
    public Result searchStudent(@RequestParam("userId")String teacherId,
                                @RequestParam("studentId")String studentId,
                                @RequestParam("studentName")String studentName,
                                HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if(id.equals(teacherId)==false){
            return ResultTool.error("token和id不匹配");
        }
        return teacherService.searchStudent(studentId,studentName,teacherId);
    }

}
