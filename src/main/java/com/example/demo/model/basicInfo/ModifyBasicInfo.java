package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 修改个人基础信息 #2
 * @author: tyq
 * @create:
 **/
@Data
public class ModifyBasicInfo {
    @JsonProperty("userId")
    String userId;
//    @JsonProperty("userName")
//    String userName;
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;
    @JsonProperty("userGrade")
    String userGrade;
    @JsonProperty("userSchool")
    String userSchool;
    @JsonProperty("userGpa")
    String userGpa;
    @JsonProperty("userMajor")
    String userMajor;


}
