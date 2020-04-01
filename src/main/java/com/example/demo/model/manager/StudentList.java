package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 学生信息列表
 * @author: tyq
 * @create: 2019-06-19 11:07
 **/
@Data
public class StudentList {
    @JsonProperty("studentList")
    List<ManageStudentInfoItem> studentList;

}
