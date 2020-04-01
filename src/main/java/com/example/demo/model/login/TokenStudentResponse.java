package com.example.demo.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 学生登陆返回
 * @author: tyq
 * @create:
 **/
@Data
public class TokenStudentResponse {
    @JsonProperty("token")
    String token;
    @JsonProperty("identity")
    String identity;
    @JsonProperty("userName")
    String userName;
    @JsonProperty("userId")
    String userId;
    @JsonProperty("current")
    String current;
}
