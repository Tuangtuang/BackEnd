package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 学生选校状态
 * @author: tyq
 * @create:
 **/
@Data
public class StudentChooseState {
    @JsonProperty("studentChooseStatus")
    String studentChooseStatus;
}
