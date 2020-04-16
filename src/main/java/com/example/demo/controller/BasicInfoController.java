package com.example.demo.controller;

import com.example.demo.model.basicInfo.AddTestAccount;
import com.example.demo.model.basicInfo.DeleteTestAccount;
import com.example.demo.model.basicInfo.ModifyBasicInfo;
import com.example.demo.model.basicInfo.UpdateTeacherBasicInfo;
import com.example.demo.model.overview.Result;
import com.example.demo.service.BasicInfoService;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 基本信息controller
 * @author: tyq
 * @create:
 **/
@RestController
@CrossOrigin
public class BasicInfoController {
    @Resource
    private BasicInfoService basicInfoService;

    @Resource
    private SchoolService schoolService;

    //  #2
    @RequestMapping(value = "/insider/basicInfo/post",method = RequestMethod.POST)
    public Result changeBasicInfo(@RequestBody ModifyBasicInfo modifyBasicInfo,
                                  HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!modifyBasicInfo.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return basicInfoService.postBasicInfo(modifyBasicInfo);
    }



    @GetMapping(value = "/insider/basicInfo/get")
    public Result getBasicInfo(@RequestParam("userId") String userId,
                               HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id=JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if(!userId.equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return basicInfoService.getBasicInfo(id);
    }

    // #4
    @RequestMapping(value = "/insider/personalInfo/add",method = RequestMethod.POST)
    public Result userAddAccount(@RequestBody AddTestAccount addTestAccount,HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id=JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if(!addTestAccount.getUserId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return basicInfoService.addAccount(addTestAccount);
    }

    // #5
    @GetMapping(value = "/insider/personalInfo/get")
    public Result userGetAccount(@RequestParam("userId") String userId,@RequestParam("teaId")String teacherId, HttpServletRequest httpServletRequest){
//        String teacherId=;
        String studentId=userId;
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
        return basicInfoService.getAccount(userId);
    }

    @PostMapping(value = "/insider/personalInfo/delete")
    public Result deleteTestAccount(@RequestBody DeleteTestAccount deleteTestAccount,HttpServletRequest httpServletRequest){
        String teacherId=deleteTestAccount.getTeaId();
        String studentId=deleteTestAccount.getUserId();
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
        return basicInfoService.deleteAccount(deleteTestAccount);
    }

    @GetMapping("/insider/teaBasicInfo/get")
    public Result getTeacherInfo(@RequestParam("userId") String userId,HttpServletRequest httpServletRequest){
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
        return basicInfoService.getTeacherBasicInfo(userId);
    }


    @PostMapping("/insider/teaBasicInfo/post")
    public Result updateTeacherInfo(@RequestBody UpdateTeacherBasicInfo updateTeacherBasicInfo,HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id= JwtUtil.parseJwt(token);
        }catch (Exception e){
            return ResultTool.error("登陆状态无效，无法解析token");
        }
        if (!updateTeacherBasicInfo.getTeacherId().equals(id)){
            return ResultTool.error("登陆状态无效，token和id不一致 ");
        }
        return basicInfoService.updateTeacherBasicInfo(updateTeacherBasicInfo);
    }

}
