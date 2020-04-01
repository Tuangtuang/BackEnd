package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 删除作业
 * @author: tyq
 * @create:
 **/
@Data
public class DeleteHomework {
    @JsonProperty("userId")
    String teacherId;
    @JsonProperty("studentId")
    String studentId;
    @JsonProperty("homeworkId")
    String homeworkId;
}
