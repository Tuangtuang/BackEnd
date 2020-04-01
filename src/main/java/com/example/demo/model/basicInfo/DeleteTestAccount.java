package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 删除考试账户信息接口
 * @author: tyq
 * @create:
 **/
@Data
public class DeleteTestAccount {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
    @JsonProperty("examType")
    String examType;
}
