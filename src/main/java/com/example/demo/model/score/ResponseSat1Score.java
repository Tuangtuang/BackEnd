package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: sat1成绩返回
 * @author: tyq
 * @create:
 **/
@Data
public class ResponseSat1Score {

    @JsonProperty("id")
    String id;
    @JsonProperty("testdate")
    String testDate;
    @JsonProperty("reading")
    String reading;
    @JsonProperty("writing")
    String writing;
    @JsonProperty("math")
    String math;
    @JsonProperty("essay")
    String essay;
}
