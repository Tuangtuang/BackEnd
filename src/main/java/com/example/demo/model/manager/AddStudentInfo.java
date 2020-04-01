package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 管理员添加学生信息
 * @author: tyq
 * @create: 2019-06-20 21:26
 **/
@Data
public class AddStudentInfo {
    @JsonProperty("userId")
    String userId;//管理员id
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;
    @JsonProperty("studentName")
    String studentName;
}
