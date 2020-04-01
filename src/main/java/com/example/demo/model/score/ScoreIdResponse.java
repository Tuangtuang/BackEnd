package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 返回成绩id
 * @author: tyq
 * @create:
 **/
@Data
public class ScoreIdResponse {
    @JsonProperty("id")
    String id;
}
