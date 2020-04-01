package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 删除成绩
 * @author: tyq
 * @create:
 **/
@Data
public class DeleteScore {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
    @JsonProperty("type")
    String type;
    @JsonProperty("id")
    String id;
}
