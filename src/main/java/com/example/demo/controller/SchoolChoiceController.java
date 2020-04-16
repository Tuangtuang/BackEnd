package com.example.demo.controller;

import com.example.demo.model.overview.Result;
import com.example.demo.model.school.ChooseSchool;
import com.example.demo.model.school.LockSchool;
import com.example.demo.model.school.ModifyApplyState;
import com.example.demo.model.school.StudentId;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 选择学校controller层
 * @author: tyq
 * @create:
 **/
@RestController
@CrossOrigin
public class SchoolChoiceController {
    @Resource
    private SchoolService schoolService;

    //    #6
    @GetMapping("/insider/chooseSchool/locked")
    public Result getLockedSchool(@RequestParam("userId") String studentId,
                                  @RequestParam("teaId") String teacherId,
                                  HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (teacherId == "") {
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
        return schoolService.getLockedSchool(studentId);
    }

//    #7
    @GetMapping("/insider/chooseSchool/unlocked")
    public Result getUnlockedSchool(@RequestParam("userId") String studentId,
                                    @RequestParam("teaId") String teacherId,
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
        return schoolService.getUnlockedSchool(studentId);
    }

//    #9
    @GetMapping("/insider/chooseSchool/search")
    public Result searchSchoolInfo(@RequestParam("userId") String studentId,
                                   @RequestParam("teaId") String teacherId,
                                   @RequestParam("name") String name,
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
        return schoolService.getSearchSchool(name,studentId);
    }

    @RequestMapping(value = "/insider/chooseSchool/lock",method = RequestMethod.POST)
    public Result lockSchool(@RequestBody LockSchool lockSchool,HttpServletRequest httpServletRequest){
        String teacherId=lockSchool.getTeaId();
        String studentId=lockSchool.getUserId();
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
        return schoolService.lockSchool(lockSchool);
    }

    @RequestMapping(value="/insider/chooseSchool/add",method = RequestMethod.POST)
    public Result chooseSchool(@RequestBody ChooseSchool chooseSchool,HttpServletRequest httpServletRequest){
        String teacherId=chooseSchool.getTeaId();
        String studentId=chooseSchool.getUserId();
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
        return schoolService.chooseSchool(chooseSchool);
    }

//    选择学校删除待锁定学校信息接口 #51
    @RequestMapping(value = "/insider/chooseSchool/delete",method = RequestMethod.POST)
    public Result deleteUnlockedSchool(@RequestBody LockSchool lockSchool,HttpServletRequest httpServletRequest){
        String teacherId=lockSchool.getTeaId();
        String studentId=lockSchool.getUserId();
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
        return schoolService.deleteUnlockedSchool(lockSchool);
    }

//    选择学校解锁学校信息接口 #50
    @RequestMapping(value = "/insider/chooseSchool/unlock",method = RequestMethod.POST)
    public Result unlockSchool(@RequestBody LockSchool lockSchool,HttpServletRequest httpServletRequest){
        String teacherId=lockSchool.getTeaId();
        String studentId=lockSchool.getUserId();
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
        return schoolService.unlockSchool(lockSchool);
    }

    @RequestMapping(value = "/insider/chooseSchool/finish",method = RequestMethod.POST)
    public Result finishChoosingSchool(@RequestBody StudentId stuId, HttpServletRequest httpServletRequest){

        String studentId=stuId.getUserId();
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if(id.equals(studentId)==false){
            return ResultTool.error("token和id不匹配");
        }
        return schoolService.finishSchoolChoosing(studentId);
    }


    @PostMapping("/insider/teaChooseSchool/upload")
    public Result finishByTeacher(HttpServletRequest httpServletRequest,
                                  @RequestParam("userId") String teacherId,
                                  @RequestParam("studentId")String studentId,
                                  @RequestParam("file")MultipartFile file){
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
        return schoolService.finishUploadFile(file,studentId);
    }
    

    @GetMapping("/insider/teaChooseSchool/studentChooseStatus")
    public Result getStudentStatus(@RequestParam("userId")String teacherId,@RequestParam("studentId")String studentId,HttpServletRequest httpServletRequest){
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
        return schoolService.getStudentChooseState(studentId);
    }


    @PostMapping("/insider/teaApply/changeStatus")
    public Result modifyState(@RequestBody ModifyApplyState modifyApplyState,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        String userId=modifyApplyState.getUserId();//教师的id
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if(userId.equals(id)==false){
            return ResultTool.error("token和id不匹配");
        }
        return schoolService.modifyState(modifyApplyState.getStudentSchoolId(),modifyApplyState.getStatus(),modifyApplyState.getLink());
    }

    @GetMapping("/insider/apply/getStatus")
    public  Result getApplyState(HttpServletRequest httpServletRequest,@RequestParam("userId")String studentId,@RequestParam("teaId")String teacherId){
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
        return schoolService.getApplyState(studentId);
    }

    @GetMapping("/insider/chooseSchool/allFinish")
    public Result getSchoolChoiceState(HttpServletRequest httpServletRequest,
                                       @RequestParam("userId")String studentId,
                                       @RequestParam("teaId")String teacherId){
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
        return schoolService.isFinishSchoolChoosing(studentId,tag);
    }


    @GetMapping("/insider/chooseSchool/teaUpload")
    public Result isStudentFinish(@RequestParam("userId")String studentId,@RequestParam("teaId")String teacherId,
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
        return schoolService.isStudentFinish(studentId);
    }


}
