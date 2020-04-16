package com.example.demo.controller;

import com.example.demo.model.overview.Result;
import com.example.demo.model.school.ChooseSchool;
import com.example.demo.model.score.*;
import com.example.demo.service.SchoolService;
import com.example.demo.service.ScoreService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 分数统计controller层
 * @author: tyq
 * @create:
 **/
@CrossOrigin
@RestController
@Slf4j
public class ScoreController {

    @Resource
    SchoolService schoolService;

    @Resource
    ScoreService scoreService;

//    成绩统计添加GRE历史成绩接口 #36
    @RequestMapping(value = "/insider/score/addGreScore",method = RequestMethod.POST)
    public Result putGreScore(@RequestBody GreScore greScore, HttpServletRequest httpServletRequest){
        String teacherId=greScore.getTeaId();
        String studentId=greScore.getUserId();
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
        return scoreService.addGre(greScore);
    }

//    成绩统计添加GMAT历史成绩接口 #37
    @RequestMapping(value="/insider/score/addGmatScore",method = RequestMethod.POST)
    public Result putGmatScore(@RequestBody GreScore greScore, HttpServletRequest httpServletRequest){
        String teacherId=greScore.getTeaId();
        String studentId=greScore.getUserId();
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
        return scoreService.addGmat(greScore);
    }

//    成绩统计添加TOEFL历史成绩接口 #39
    @RequestMapping(value = "/insider/score/addToeflScore",method = RequestMethod.POST)
    public Result putToeflScore(@RequestBody ToeflAndIeltsScore toeflAndIeltsScore,HttpServletRequest httpServletRequest){
        String teacherId=toeflAndIeltsScore.getTeaId();
        String studentId=toeflAndIeltsScore.getUserId();
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
        return scoreService.addToefl(toeflAndIeltsScore);
    }

//    成绩统计添加IETLS历史成绩接口 #38
    @RequestMapping(value = "/insider/score/addIetlsScore",method = RequestMethod.POST)
    public Result putIelts(@RequestBody ToeflAndIeltsScore toeflAndIeltsScore,HttpServletRequest httpServletRequest){
        String teacherId=toeflAndIeltsScore.getTeaId();
        String studentId=toeflAndIeltsScore.getUserId();
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
        return scoreService.addIelts(toeflAndIeltsScore);
    }

//    成绩统计添加LSAT历史成绩接口 #54
    @RequestMapping(value = "/insider/score/addLsatScore",method = RequestMethod.POST)
    public Result putLsat(@RequestBody LsatScore lsatScore,HttpServletRequest httpServletRequest){
        String teacherId=lsatScore.getTeaId();
        String studentId=lsatScore.getUserId();
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        log.info(teacherId);
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
        return scoreService.addLsat(lsatScore);
    }

//    成绩统计添加SAT1历史成绩接口 #55
    @RequestMapping(value = "/insider/score/addSat1Score",method = RequestMethod.POST)
    public Result putSat1(@RequestBody  Sat1Score sat1Score,HttpServletRequest httpServletRequest){
        String teacherId=sat1Score.getTeaId();
        String studentId=sat1Score.getUserId();
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

        return scoreService.addSat1(sat1Score);
    }

//    成绩统计添加OTHER历史成绩接口 #56
    @RequestMapping(value = "/insider/score/addOtherScore",method = RequestMethod.POST)
    public Result putOther(@RequestBody OtherScore otherScore,HttpServletRequest httpServletRequest){
        String teacherId=otherScore.getTeaId();
        String studentId=otherScore.getUserId();
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
        return scoreService.addOther(otherScore);
    }

    @GetMapping("/insider/score/getScoreList")
    public Result getScores(@RequestParam("userId") String studentId,
                            @RequestParam("teaId") String teacherId,
                            @RequestParam("type") String type,
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
        return scoreService.getScore(studentId,type);
    }

    @RequestMapping(value = "/insider/score/deleteScore",method = RequestMethod.POST)
    public Result deleteScore(@RequestBody DeleteScore deleteScore,HttpServletRequest httpServletRequest){
        String teacherId=deleteScore.getTeaId();
        String studentId=deleteScore.getUserId();
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
        return scoreService.deleteScore(deleteScore.getType(),deleteScore.getId(),deleteScore.getUserId());
    }
}
