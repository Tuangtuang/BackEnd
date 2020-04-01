package com.example.demo.model.otherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 其他事项截止时间
 * @author: tyq
 * @create:
 **/
@Data
public class OtherDDL {
    @JsonProperty("userId")
    String teacherId;
    @JsonProperty("studentId")
    String studentId;
    @JsonProperty("passport")
    String passport;
    @JsonProperty("deposit")
    String deposit;
    @JsonProperty("dormitory")
    String dormitory;
    @JsonProperty("test")
    String test;
    @JsonProperty("fee")
    String fee;
    @JsonProperty("document")
    String document;
}
