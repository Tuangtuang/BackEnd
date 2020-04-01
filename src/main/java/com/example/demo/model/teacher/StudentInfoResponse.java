package com.example.demo.model.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Data
public class StudentInfoResponse {
    @JsonProperty("studentList")
    List<StudentInfoItem> studentInfoItemList;
}
