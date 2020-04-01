package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 添加教师信息
 * @author: tyq
 * @create: 2019-06-20 21:49
 **/
@Data
public class AddTeacherInfo {
    @JsonProperty("userId")
    String userId;//管理员id
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;
    @JsonProperty("teacherName")
    String teacherName;
}
