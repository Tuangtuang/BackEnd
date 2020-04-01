package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 其他成绩
 * @author: tyq
 * @create:
 **/
@Data
public class OtherScore {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
    @JsonProperty("type")
    String type;
    @JsonProperty("testdate")
    String testDate;
    @JsonProperty("subjectName")
    String subjectName;
    @JsonProperty("subjectScore")
    String subjectScore;
}
