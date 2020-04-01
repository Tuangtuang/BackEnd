package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 修改师生关系接口
 * @author: tyq
 * @create: 2019-06-23 19:28
 **/
@Data
public class TeacherStudentRelation {
    @JsonProperty("userId")
    String managerId;
    @JsonProperty("studentId")
    String studentId;
    @JsonProperty("teacherId")
    String teacherId;
    @JsonProperty("status")
    String status;
}
