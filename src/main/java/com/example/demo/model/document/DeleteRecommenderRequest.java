package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 删除推荐人接口
 * @author: tyq
 * @create:
 **/
@Data
public class DeleteRecommenderRequest {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teacherId;
    @JsonProperty("recommend")
    String recommend;
}
