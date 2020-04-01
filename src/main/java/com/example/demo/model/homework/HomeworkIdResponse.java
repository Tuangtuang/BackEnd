package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: homework
 * @author: tyq
 * @create:
 **/
@Data
public class HomeworkIdResponse {
    @JsonProperty("id")
    String id;
}
