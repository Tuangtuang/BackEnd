package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 当前作业返回
 * @author: tyq
 * @create:
 **/
@Data
public class CurrentHomework {
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("deadline")
    String deadline;
}
