package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 学生单独信息
 * @author: tyq
 * @create: 2019-06-19 11:08
 **/
@Data
public class ManageStudentInfoItem {
    @JsonProperty("id")
    String studentId;
    @JsonProperty("name")
    String studentName;
}
