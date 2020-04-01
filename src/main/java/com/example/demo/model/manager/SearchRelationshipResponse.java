package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 搜索师生关系返回值
 * @author: tyq
 * @create: 2019-06-24 13:34
 **/
@Data
public class SearchRelationshipResponse {
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("status")
    String status;
}
