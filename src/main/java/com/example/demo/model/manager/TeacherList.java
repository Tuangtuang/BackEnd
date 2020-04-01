package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 教师列表
 * @author: tyq
 * @create: 2019-06-21 12:10
 **/
@Data
public class TeacherList {
    @JsonProperty("teacherList")
    List<ManageStudentInfoItem> teacherList;
}
