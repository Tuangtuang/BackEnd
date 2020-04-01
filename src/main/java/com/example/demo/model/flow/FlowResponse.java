package com.example.demo.model.flow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 内部系统步骤条状态接口 #68
 * @author: tyq
 * @create:
 **/
@Data
public class FlowResponse {
    @JsonProperty("current")
    String current;
}
