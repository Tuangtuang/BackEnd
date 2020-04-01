package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 获取个人基本信息 #3
 * @author: tyq
 * @create:
 **/
@Data
public class GetBasicInfo {
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userPassword")
    String userPassword;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userGrade")
    String userGrade;
    @JsonProperty("userSchool")
    String userSchool;
    @JsonProperty("userGpa")
    String userGpa;
    @JsonProperty("userMajor")
    String userMajor;

}
