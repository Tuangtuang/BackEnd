package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 申请状态获取
 * @author: tyq
 * @create:
 **/
@Data
public class ApplyStateItem {
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("projectName")
    String projectName;
    @JsonProperty("stepNum")
    String stepNum;
    @JsonProperty("link")
    String link;
    @JsonProperty("admit")
    String admit;
}
