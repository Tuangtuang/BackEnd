package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 修改教师基本信息接口
 * @author: tyq
 * @create: 2019-06-21 21:51
 **/
@Data
public class ModifyTeacherBasicInfo {

    @JsonProperty("userId")
    String userId;//管理员id
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;
    @JsonProperty("teacherId")
    String teacherId;
    @JsonProperty("userName")
    String userName;
}
