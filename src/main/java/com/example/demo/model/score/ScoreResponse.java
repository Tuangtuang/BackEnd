package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 分数返回
 * @author: tyq
 * @create:
 **/
@Data
public class ScoreResponse<T> {
    @JsonProperty("scoreList")
    List<T> scoreList;

}
