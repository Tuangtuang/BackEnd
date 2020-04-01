package com.example.demo.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 返回验证码
 * @author: tyq
 * @create:
 **/
@Data
public class CheckCodeBack {
    @JsonProperty("time")
    String time;
    @JsonProperty("code")
    String code;
    @JsonProperty("inputCode")
    String inputCode;
    @JsonProperty("userId")
    String userId;

}
