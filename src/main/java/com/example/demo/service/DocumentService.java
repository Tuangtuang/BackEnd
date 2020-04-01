package com.example.demo.service;

import com.example.demo.model.document.ChatPs;
import com.example.demo.model.document.DeleteRecommenderRequest;
import com.example.demo.model.document.RecommenderInfo;
import com.example.demo.model.overview.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface DocumentService {

//    文书修改CV提交版本文件内容接口 #24
    Result putCV(String userId, MultipartFile file);

//    文书修改推荐信提交版本文件内容接口 #25
    Result putRecommendFile(String userId,MultipartFile file,String recommenderId);

//    文书修改PS提交版本文件内容接口 #26
    Result putPSFile(String userId,String stuSchoolId,MultipartFile file);

//    文书修改PHS提交版本文件内容接口 #27
    Result putOtherPaper(String userId,String stuSchoolId,MultipartFile file);

//    文书修改PHS获取版本文件内容接口 #23
    Result getOtherPaper(String Id, HttpServletResponse httpServletResponse,String userId);

//    文书修改PS获取版本文件内容接口 #20
    Result getPS(String Id,HttpServletResponse httpServletResponse,String userId);

//    文书修改推荐信获取版本文件内容接口 #17
    Result getRecommendation(String Id,HttpServletResponse httpServletResponse,String userId);

//    文书修改CV获取版本详细信息接口 #13
    Result getCv(String Id,HttpServletResponse httpServletResponse,String userId);

//    文书修改PS版本师生交流接口 #30
    Result chatPs(ChatPs chatPs);

//    文书修改PHS版本师生交流接口 #31
    Result chatOther(ChatPs chatPs);

//    文书修改推荐信版本师生交流接口 #29
    Result chatRecommendation(ChatPs chatPs);

//    文书修改CV版本师生交流接口 #28
    Result chatCV(ChatPs chatPs);

//    文书修改PHS获取版本详细信息接口 #22
    Result getChatInfoOther(String versionId);

//    文书修改PHS获取版本接口 #21
    Result getOtherVersion(String studentSchoolId);

//    文书修改PS获取版本详细信息接口 #19
    Result getChatInfoPS(String versionId);

//    文书修改PS获取版本接口 #18
    Result getPSVersion(String studentSchoolId);

//    文书修改推荐信获取版本详细信息接口 #16
    Result getChatInfoRecommendation(String versionId);

//    文书修改CV获取版本详细信息接口 #13
    Result getChatInfoCV(String versionId);

//    文书修改推荐信获取版本接口 #14
    Result getVersionInfoRecommendation(String recommenderId);

//    文书修改CV获取版本接口 #12
    Result getVersionInfoCv(String studentId);


//    文书修改添加推荐人接口 #70
    Result addRecommender(RecommenderInfo recommenderInfo);

//    文书修改获取推荐人信息接口 #69
    Result getRecommender(String studentId);

//    文书修改教师确认文书修改完成接口 #71
    Result comfirmFinish(String studentId);

//    文书修改删除推荐人接口 #93
    Result deleteRecommender(DeleteRecommenderRequest deleteRecommenderRequest);
}


