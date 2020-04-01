package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 当前作业列表
 * @author: tyq
 * @create:
 **/
@Data
public class CurrentHomeworkResponse {
    @JsonProperty("historyList")
    List<CurrentHomework> currentHomeworkResponseList;

}
