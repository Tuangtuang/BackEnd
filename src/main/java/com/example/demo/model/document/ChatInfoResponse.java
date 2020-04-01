package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.jar.JarEntry;

/**
 * @program: demo
 * @description: 返回交流信息接口
 * @author: tyq
 * @create:
 **/
@Data
public class ChatInfoResponse {
    @JsonProperty("identity")
    String identity;
    @JsonProperty("detail")
    String detail;
    @JsonProperty("person")
    String person;
//    @JsonProperty("time")
//    String time;
}
