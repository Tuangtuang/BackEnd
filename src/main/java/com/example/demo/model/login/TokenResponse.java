package com.example.demo.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 登陆成功返回token
 * @author: tyq
 * @create:
 **/
@Data
public class TokenResponse {
    @JsonProperty("token")
    String token;
    @JsonProperty("identity")
    String identity;
    @JsonProperty("userName")
    String userName;
    @JsonProperty("userId")
    String userId;


}
