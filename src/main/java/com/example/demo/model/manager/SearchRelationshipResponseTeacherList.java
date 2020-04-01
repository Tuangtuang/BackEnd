package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 通过学生id获取师生关系，得到教师列表
 * @author: tyq
 * @create: 2019-06-24 17:12
 **/
@Data
public class SearchRelationshipResponseTeacherList {
    @JsonProperty("teacherList")
    List<SearchRelationshipResponse> teacherList;
}
