package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 其他考试成绩
 * @author: tyq
 * @create:
 **/
@Data
public class ResponseOtherScore {
    @JsonProperty("id")
    String id;
    @JsonProperty("testdate")
    String testDate;
    @JsonProperty("name")
    String subjectName;
    @JsonProperty("score")
    String subjectScore;
}
