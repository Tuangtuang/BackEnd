package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 管理员修改学生信息
 * @author: tyq
 * @create: 2019-06-20 17:50
 **/
@Data
public class ModifyStudentBasicInfo {
    @JsonProperty("userId")
    String userId;//管理员id
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
    @JsonProperty("studentId")
    String studentId;
    @JsonProperty("userName")
    String userName;

}
