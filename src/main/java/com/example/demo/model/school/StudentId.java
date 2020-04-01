package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 学生id
 * @author: tyq
 * @create:
 **/
@Data
public class StudentId {
    @JsonProperty("userId")
    String userId;
}
