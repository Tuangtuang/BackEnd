package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 返回学生选校表中的主键id
 * @author: tyq
 * @create:
 **/
@Data
public class StuStudentId {
    @JsonProperty("studentSchoolId")
    String studentSchoolId;
}
