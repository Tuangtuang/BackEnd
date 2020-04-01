package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 学生获取作业
 * @author: tyq
 * @create:
 **/
@Data
public class HomeworkResponse {
    @JsonProperty("historyList")
    List<HomeworkIdName> historyList;
}
