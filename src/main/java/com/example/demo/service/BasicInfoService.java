package com.example.demo.service;

import com.example.demo.model.basicInfo.*;
import com.example.demo.model.overview.Result;

// 基本信息和考试信息
public interface BasicInfoService {
    //  提交个人基本信息接口 #2
    Result postBasicInfo(ModifyBasicInfo modifyBasicInfo);

    //  获取个人基本信息接口 #3
    Result getBasicInfo(String userId);

//    完善信息添加考试账户接口 #4
    Result addAccount(AddTestAccount addTestAccount);

//    获取考试账户信息接口 #5
    Result getAccount(String userId);

//    完善信息删除考试账户接口 #48
    Result deleteAccount(DeleteTestAccount deleteTestAccount);

//    内部系统教师获取个人基本信息接口 #73
    Result getTeacherBasicInfo(String userId);

    //    内部系统教师提交个人基本信息接口 #74
    Result updateTeacherBasicInfo(UpdateTeacherBasicInfo updateTeacherBasicInfo);

}
