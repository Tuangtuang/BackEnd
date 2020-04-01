package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 学生添加考试账户信息#4
 * @author: tyq
 * @create:
 **/
@Data
public class AddTestAccount {
//    userId: xxx,
//    examType: xxx, // "GRE" or "GMAT" ...
//    account: xxx,
//    password: xxx,
    @JsonProperty("userId")
    String userId;
    @JsonProperty("examType")
    String examType;
    @JsonProperty("account")
    String account;
    @JsonProperty("password")
    String password;
}
