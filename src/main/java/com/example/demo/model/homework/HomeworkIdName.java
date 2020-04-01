package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Data
public class HomeworkIdName {
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    String name;

}
