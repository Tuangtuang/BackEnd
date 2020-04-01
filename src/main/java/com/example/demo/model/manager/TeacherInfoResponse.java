package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 教师基本信息返回接口
 * @author: tyq
 * @create: 2019-06-21 12:58
 **/
@Data
public class TeacherInfoResponse {
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;
}
