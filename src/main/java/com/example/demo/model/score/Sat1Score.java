package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 添加sat1
 * @author: tyq
 * @create:
 **/
@Data
public class Sat1Score {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
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
