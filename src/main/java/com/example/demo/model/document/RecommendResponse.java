package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 推荐人返回信息
 * @author: tyq
 * @create:
 **/
@Data
public class RecommendResponse {
    @JsonProperty("recommendList")
    List<RecommendList> recommendList;
}
