package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 获取考试账户密码信息接口#5
 * @author: tyq
 * @create:
 **/
@Data
public class GetTestAccount {
    @JsonProperty("type")
    String type;
    @JsonProperty("account")
    String account;
    @JsonProperty("password")
    String password;

}
