package com.example.demo.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 内部系统用户登陆界面
 * @author: tyq
 * @create:
 **/
@Data
public class UserLogin {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("userPassword")
    String userPassword;
    @JsonProperty("userIdentity")
    String userIdentity;
}
