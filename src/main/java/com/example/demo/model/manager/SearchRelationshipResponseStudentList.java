package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 管理员通过教师id获取师生关系，返回学生列表
 * @author: tyq
 * @create: 2019-06-24 13:41
 **/
@Data
public class SearchRelationshipResponseStudentList {
    @JsonProperty("studentList")
    List<SearchRelationshipResponse> studentList;
}
