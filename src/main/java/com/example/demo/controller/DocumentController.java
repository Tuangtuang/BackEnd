package com.example.demo.controller;

import com.example.demo.model.document.ChatPs;
import com.example.demo.model.document.DeleteRecommenderRequest;
import com.example.demo.model.document.RecommenderInfo;
import com.example.demo.model.document.StudentInfo;
import com.example.demo.model.overview.Result;
import com.example.demo.model.school.StudentId;
import com.example.demo.service.DocumentService;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @description: 学生文书信息Controller层
 * @author: tyq
 * @create:
 **/
@RestController
@CrossOrigin
@Slf4j
public class DocumentController {

    @Resource
    private DocumentService documentService;


    @Resource
    private SchoolService schoolService;

    /**
     * @Description: 上传cv
     * @Param: [file, studentId, teacherId, httpServletRequest]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @RequestMapping(value = "/insider/paper/cvVersionUpload", method = RequestMethod.POST)
    public Result putCv(@RequestParam("file") MultipartFile file, @RequestParam("userId") String studentId, @RequestParam("teaId") String teacherId, HttpServletRequest httpServletRequest) {
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
        return documentService.putCV(studentId, file);
    }


    /**
     * @Description: 上传推荐信接口
     * @Param: [file, studentId, teacherId, recommendId, httpServletRequest]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @RequestMapping(value = "/insider/paper/recVersionUpload", method = RequestMethod.POST)
    public Result putRecommendation(@RequestParam("file") MultipartFile file, @RequestParam("userId") String studentId, @RequestParam("teaId") String teacherId, @RequestParam("recommendId") String recommendId, HttpServletRequest httpServletRequest) {
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
        return documentService.putRecommendFile(studentId, file, recommendId);
    }


    /**
     * @Description: 上传文书接口
     * @Param: [file, studentId, teacherId, studentSchool, httpServletRequest]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @RequestMapping(value = "/insider/paper/psVersionUpload", method = RequestMethod.POST)
    public Result putPS(@RequestParam("file") MultipartFile file,
                        @RequestParam("userId") String studentId,
                        @RequestParam("teaId") String teacherId,
                        @RequestParam("studentSchoolId") String studentSchool,
                        HttpServletRequest httpServletRequest) {
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
        return documentService.putPSFile(studentId, studentSchool, file);
    }

    /** 
    * @Description: 添加其他信息
    * @Param: [file, studentId, teacherId, studentSchool, httpServletRequest] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @RequestMapping(value = "/insider/paper/phsVersionUpload",method = RequestMethod.POST)
    public Result putOther(@RequestParam("file") MultipartFile file,
                           @RequestParam("userId") String studentId,
                           @RequestParam("teaId") String teacherId,
                           @RequestParam("studentSchoolId") String studentSchool,
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

        return documentService.putOtherPaper(studentId,studentSchool,file);
    }

    /** 
    * @Description: 获取other文件接口 
    * @Param: [httpServletRequest, httpServletResponse, studentId, teacherId, versionId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @GetMapping("/insider/paper/phsVersionFile")
    public  Result getOtherPaper(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
                               @RequestParam("userId")String studentId,
                               @RequestParam("teaId")String teacherId,
                               @RequestParam("versionId")String versionId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("token不合法");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("身份验证不合法");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("身份验证不合法");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("不存在师生关系");
            }
        }
        return documentService.getOtherPaper(versionId,httpServletResponse,studentId);
    }


    /** 
    * @Description: 文书修改PS获取版本文件内容接口 #20 
    * @Param: [httpServletResponse, httpServletRequest, studentId, teacherId, versionId] 
    * @return: void 
    * @Author: tyq 
    * @Date:
    */ 
    @GetMapping("/insider/paper/psVersionFile")
    public Result getPs(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest,
                      @RequestParam("userId")String studentId,
                      @RequestParam("teaId")String teacherId,
                      @RequestParam("versionId")String versionId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("token不合法");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("身份验证不通过");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("身份验证不通过");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("不存在师生关系");
            }
        }
        return documentService.getPS(versionId,httpServletResponse,studentId);

    }


    /**
    * @Description: 获取推荐信
    * @Param: [httpServletResponse, httpServletRequest, studentId, teacherId, versionId]
    * @return: void
    * @Author: tyq
    * @Date:
    */
    @GetMapping("/insider/paper/recVersionFile")
    public Result getRecommendation(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest,
                                  @RequestParam("userId")String studentId,
                                  @RequestParam("teaId")String teacherId,
                                  @RequestParam("versionId")String versionId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("token不合法");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("身份验证不合法");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("身份验证不合法");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("不存在师生关系");
            }
        }
        return documentService.getRecommendation(versionId,httpServletResponse,studentId);

    }

    

    /** 
    * @Description: 文书修改CV获取版本详细信息接口 #13
    * @Param: [httpServletResponse, httpServletRequest, studentId, teacherId, versionId] 
    * @return: void 
    * @Author: tyq 
    * @Date:
    */ 
    @GetMapping("/insider/paper/cvVersionFile")
    public Result getCv(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest,
                      @RequestParam("userId")String studentId,
                      @RequestParam("teaId")String teacherId,
                      @RequestParam("versionId")String versionId){
        String token = httpServletRequest.getHeader("Authorization");
        String id;
        try {
            id = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            return ResultTool.error("token不合法");
        }
        if (teacherId.equals("")) {
//            学生登陆
            if (!studentId.equals(id)) {
                return ResultTool.error("身份验证不合法");
            }
        } else {
//            老师查看学生的信息
            if (!teacherId.equals(id)) {
                return ResultTool.error("身份验证不合法");
            }
//            检查是否存在师生关系
            if (schoolService.checkStudentTeacherRelationship(studentId, teacherId) == false) {
                return ResultTool.error("不存在师生关系");
            }
        }
        return documentService.getCv(versionId,httpServletResponse,studentId);
    }



    /**
    * @Description: 文书修改PS版本师生交流接口 #30
    * @Param: [httpServletRequest, chatPs]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @PostMapping("/insider/paper/psVersionCom")
    public Result chartOnPs(HttpServletRequest httpServletRequest, @RequestBody ChatPs chatPs){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=chatPs.getTeaId();
        String studentId=chatPs.getUserId();
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
        return documentService.chatPs(chatPs);
    }

    
    /** 
    * @Description: 文书修改PHS版本师生交流接口 #31
    * @Param: [httpServletRequest, chatPs] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @PostMapping("/insider/paper/phsVersionCom")
    public Result chartOnOther(HttpServletRequest httpServletRequest,@RequestBody ChatPs chatPs){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=chatPs.getTeaId();
        String studentId=chatPs.getUserId();
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
        return documentService.chatOther(chatPs);
    }


    /** 
    * @Description: 文书修改推荐信版本师生交流接口 #29
    * @Param: [httpServletRequest, chatPs] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @PostMapping("/insider/paper/recVersionCom")
    public Result chatOnRecommendation(HttpServletRequest httpServletRequest,@RequestBody ChatPs chatPs){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=chatPs.getTeaId();
        String studentId=chatPs.getUserId();
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
        return documentService.chatRecommendation(chatPs);
    }


    /** 
    * @Description: CV交流 
    * @Param: [chatPs, httpServletRequest] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @PostMapping("/insider/paper/cvVersionCom")
    public Result chatOnCV(@RequestBody ChatPs chatPs,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=chatPs.getTeaId();
        String studentId=chatPs.getUserId();
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
        return documentService.chatCV(chatPs);
    }

    /** 
    * @Description: 文书修改PHS获取版本详细信息接口 #22
    * @Param: [studentId, teacherId, versionId, httpServletRequest] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @GetMapping("/insider/paper/phsVersionDetail")
    public Result getChatOnOther(@RequestParam("userId") String studentId,@RequestParam("teaId")String teacherId,@RequestParam("versionId")String versionId,HttpServletRequest httpServletRequest){
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
        return documentService.getChatInfoOther(versionId);
    }

    /**
    * @Description: 获得版本信息
    * @Param: [studentId, teacherId, studentSchoolId, httpServletRequest]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @GetMapping("/insider/paper/phsVersion")
    public Result getOtherVersionDetail(@RequestParam("userId")String studentId,
                                        @RequestParam("teaId")String teacherId,
                                        @RequestParam("studentSchoolId")String studentSchoolId,
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
        return documentService.getOtherVersion(studentSchoolId);
    }


    /** 
    * @Description: 文书修改PS获取版本详细信息接口 #19
    * @Param: [studentId, teacherId, versionId, httpServletRequest] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @GetMapping("/insider/paper/psVersionDetail")
    public Result getPSVersionDetail(@RequestParam("userId")String studentId,
                                     @RequestParam("teaId")String teacherId,
                                     @RequestParam("versionId")String versionId,
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
        return documentService.getChatInfoPS(versionId);
    }

    @GetMapping("/insider/paper/psVersion")
    public Result getPSVersionDetail(HttpServletRequest httpServletRequest,
                                     @RequestParam("userId")String studentId,
                                     @RequestParam("teaId")String teacherId,
                                     @RequestParam("studentSchoolId")String studentSchoolId){
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
        return documentService.getPSVersion(studentSchoolId);
    }


    /** 
    * @Description: 文书修改推荐信获取版本详细信息接口 #16
    * @Param: [studentId, teacherId, versionId, httpServletRequest] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @GetMapping("/insider/paper/recVersionDetail")
    public Result getRecommendationChatInfo(@RequestParam("userId")String studentId,
                                            @RequestParam("teaId")String teacherId,
                                            @RequestParam("versionId")String versionId,
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
        return documentService.getChatInfoRecommendation(versionId);
    }

    @GetMapping("/insider/paper/cvVersionDetail")
    public Result getCvChatInfo(@RequestParam("userId")String studentId,
                                @RequestParam("teaId")String teacherId,
                                @RequestParam("versionId")String versionId,
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
        return documentService.getChatInfoCV(versionId);
    }


    @GetMapping("/insider/paper/recVersion")
    public Result getRecommendationVersionInfo(@RequestParam("userId")String studentId,
                                               @RequestParam("teaId")String teacherId,
                                               @RequestParam("recommenderId")String recommendeId,
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
        return documentService.getVersionInfoRecommendation(recommendeId);
    }

    @GetMapping("/insider/paper/cvVersion")
    public Result getCvVersionInfo(HttpServletRequest httpServletRequest,
                                   @RequestParam("userId")String studentId,
                                   @RequestParam("teaId")String teacherId){
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
        return documentService.getVersionInfoCv(studentId);
    }


    @PostMapping("/insider/paper/createRecommend")
    public Result getCvVersionInfo(HttpServletRequest httpServletRequest,
                                   @RequestBody RecommenderInfo recommenderInfo){
        String token = httpServletRequest.getHeader("Authorization");
        String studentId=recommenderInfo.getUserId();
        String teacherId=recommenderInfo.getTeaId();
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
        return documentService.addRecommender(recommenderInfo);
    }

    @GetMapping("/insider/paper/recommendPerson")
    public Result getRecommender(HttpServletRequest httpServletRequest,
                                 @RequestParam("userId")String studentId,
                                 @RequestParam("teaId")String teacherId){
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
        return documentService.getRecommender(studentId);
    }


    @PostMapping("/insider/paper/teaFinish")
    public Result finishPaper(@RequestBody StudentInfo studentInfo,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=studentInfo.getTeacherId();
        String studentId=studentInfo.getStudentId();
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
        return documentService.comfirmFinish(studentId);
    }


    @PostMapping("/insider/paper/deleteRecommend")
    public Result deleteRecommender(@RequestBody DeleteRecommenderRequest deleteRecommenderRequest,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        String teacherId=deleteRecommenderRequest.getTeacherId();
        String studentId=deleteRecommenderRequest.getUserId();
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
        return documentService.deleteRecommender(deleteRecommenderRequest);
    }


}
