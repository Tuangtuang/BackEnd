package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 删除教师
 * @author: tyq
 * @create: 2019-06-21 12:31
 **/
@Data
public class DeleteTeacher {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teacherId")
    String teacherId;
}
