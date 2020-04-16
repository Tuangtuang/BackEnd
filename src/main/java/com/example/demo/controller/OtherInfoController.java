package com.example.demo.controller;

import com.example.demo.model.otherInfo.OtherDDL;
import com.example.demo.model.otherInfo.StateModify;
import com.example.demo.model.overview.Result;
import com.example.demo.service.OtherInfoService;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@CrossOrigin
@RestController
public class OtherInfoController {

    @Resource
    private OtherInfoService otherInfoService;

    @Resource
    private SchoolService schoolService;

    @PostMapping("/insider/teaApply/otherDeadline")
    public Result postDDL(@RequestBody OtherDDL otherDDL, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=otherDDL.getTeacherId();
        String studentId=otherDDL.getStudentId();
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
        return otherInfoService.putOtherDDl(otherDDL);
    }

    @GetMapping("/insider/other/getInfo")
    public Result getOtherInfo(@RequestParam("userId") String studentId,
                               @RequestParam("teaId")String teacherId,
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
        return otherInfoService.getOtherInfo(studentId);
    }

    @PostMapping("/insider/teaOther/changeStatus")
    public Result modify(@RequestBody StateModify stateModify,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        String studentId=stateModify.getStudentId();
        String teacherId=stateModify.getUserId();
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
        return otherInfoService.modifyState(stateModify);
    }
}
