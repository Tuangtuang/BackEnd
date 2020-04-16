package com.example.demo.controller;

import com.example.demo.model.flow.UserModifyState;
import com.example.demo.model.overview.Result;
import com.example.demo.service.FlowStateService;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 获取流程接口
 * @author: tyq
 * @create:
 **/
@CrossOrigin
@RestController
public class FlowController {

    @Resource
    SchoolService schoolService;

    @Resource
    FlowStateService flowStateService;

    @GetMapping("/insider/stepsCom/getStep")
    public Result getState(HttpServletRequest httpServletRequest, @RequestParam("userId")String studentId, @RequestParam("teaId")String teacherId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        boolean tag=true;

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
            tag=false;
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("登陆状态无效，token和id不一致");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("您没有权限查看该学生信息");
            }
        }
        return flowStateService.getCurrentState(studentId);
    }

    @PostMapping("/insider/chooseSchool/next")
    public Result enterPaper(HttpServletRequest httpServletRequest, @RequestBody UserModifyState userModifyState){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        String teacherId=userModifyState.getTeaId();
        String studentId=userModifyState.getUserId();
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
        return flowStateService.enterPaper(userModifyState.getUserId());
    }
}
