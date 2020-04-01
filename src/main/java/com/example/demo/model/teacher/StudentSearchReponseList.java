package com.example.demo.model.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 教师搜索学生返回信息
 * @author: tyq
 * @create:
 **/
@Data
public class StudentSearchReponseList {
    @JsonProperty("studentList")
    List<StudentSearchResponse> studentList;
}
