package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 推荐人信息
 * @author: tyq
 * @create:
 **/
@Data
public class RecommendList {
    @JsonProperty("recommendId")
    String recommendId;
    @JsonProperty("name")
    String name;
}
