package com.example.demo.controller;

import com.example.demo.model.manager.*;
import com.example.demo.model.overview.Result;
import com.example.demo.service.ManagerService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import com.example.demo.tool.ZipUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 管理员controller层
 * @author: tyq
 * @create:
 **/
@RestController
@CrossOrigin
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @GetMapping("/insider/manStudent/searchList")
    public Result searchStudent(HttpServletRequest httpServletRequest,
                                @RequestParam("userId")String userId,
                                @RequestParam("studentId")String studentId,
                                @RequestParam("studentName")String studentName){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!userId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getStudentList(userId,studentId,studentName);
    }


    @GetMapping("/insider/manager/getStuBasicInfo")
    public Result getDetailStudentInfo(HttpServletRequest httpServletRequest,
                                       @RequestParam("userId")String managerId,
                                       @RequestParam("studentId")String studentId){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getStudentBasicInfo(managerId,studentId);
    }

    @PostMapping("/insider/manager/postStuBasicInfo")
    public Result ModifyStudentBasicInfo(HttpServletRequest httpServletRequest, @RequestBody ModifyStudentBasicInfo modifyStudentBasicInfo){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!modifyStudentBasicInfo.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.modifyStudentInfoManager(modifyStudentBasicInfo);
    }

    @PostMapping("/insider/manager/createStudent")
    public Result addStudent(HttpServletRequest httpServletRequest, @RequestBody AddStudentInfo addStudentInfo){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!addStudentInfo.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.createStudent(addStudentInfo);
    }


    @PostMapping("/insider/manager/createTeacher")
    public Result addTeacher(HttpServletRequest httpServletRequest, @RequestBody AddTeacherInfo addTeacherInfo){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!addTeacherInfo.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.createTeacher(addTeacherInfo);
    }


    @GetMapping("/insider/manTeacher/searchList")
    public Result getTeacherList(HttpServletRequest httpServletRequest,
                                 @RequestParam("teacherId")String teacherId,
                                 @RequestParam("teacherName")String teacherName,
                                 @RequestParam("userId")String managerId){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getTeacherList(managerId,teacherId,teacherName);
    }

    @PostMapping("/insider/manTeacher/deleteTeacher")
    public Result deleteTeacher(HttpServletRequest httpServletRequest,
                                @RequestBody DeleteTeacher deleteTeacher){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!deleteTeacher.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.deleteTeacher(deleteTeacher);
    }


    @GetMapping("/insider/manager/getTeaBasicInfo")
    public Result getTeacherInfo(HttpServletRequest httpServletRequest,
                                 @RequestParam("userId")String managerId,
                                 @RequestParam("teacherId")String teacherId){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getTeacherBasicInfo(managerId, teacherId);
    }

    @PostMapping("/insider/manager/postTeaBasicInfo")
    public Result modifyTeacherBasicInfo(HttpServletRequest httpServletRequest,
                                         @RequestBody ModifyTeacherBasicInfo modifyTeacherBasicInfo){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!modifyTeacherBasicInfo.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.modifyTeacherInfoManager(modifyTeacherBasicInfo);
    }

    @PostMapping("/insider/manager/changeRelation")
    public Result modifyTeacherStudentRelationship(@RequestBody TeacherStudentRelation teacherStudentRelation,
                                                   HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!teacherStudentRelation.getManagerId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.updateTeacherStudentRelationship(teacherStudentRelation);
    }


    @GetMapping("/insider/manTeacher/stuRelationList")
    public Result getRelationshipByTeacher(HttpServletRequest httpServletRequest,
                                           @RequestParam("userId")String managerId,
                                           @RequestParam("teacherId")String teacherId,
                                           @RequestParam("studentId")String studentId,
                                           @RequestParam("studentName")String studentName){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getRelationshipFromTeacher(managerId, teacherId, studentId, studentName);
    }


    @GetMapping("/insider/manStudent/teaRelationList")
    public Result getRelationshipByStudent(HttpServletRequest httpServletRequest,
                                           @RequestParam("userId")String managerId,
                                           @RequestParam("studentId")String studentId,
                                           @RequestParam("teacherId")String teacherId,
                                           @RequestParam("teacherName")String teacherName){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getRelationshipFromStudent(managerId,studentId,teacherId,teacherName);
    }

//    @GetMapping("/zipTest")
//    public  Result testZip(@RequestParam("Path")String path,@RequestParam("zippath")String zippath,@RequestParam("zipname")String zipname){
//        ZipUtils.folder2zip(path,zippath,zipname);
//        return ResultTool.success();
//    }

    @GetMapping("/insider/manager/getStudentStep")
    public Result getApplySate(HttpServletRequest httpServletRequest,@RequestParam("userId")String managerId,@RequestParam("studentId")String studentId){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.getApplyState(managerId, studentId);
    }


    @GetMapping("/insider/manStudent/deleteStudent")
    public Result deleteStudent(HttpServletRequest httpServletRequest,@RequestParam("userId")String managerId,@RequestParam("studentId")String studentId){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!managerId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return managerService.deleteStudent(studentId,managerId);
    }
}
