package com.example.demo.model.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 学生搜索信息
 * @author: tyq
 * @create:
 **/
@Data
public class StudentSearchResponse {
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    String name;
    @JsonProperty("grade")
    String grade;
    @JsonProperty("school")
    String school;

}
