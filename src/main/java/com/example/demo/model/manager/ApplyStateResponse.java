package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 获取申请状态
 * @author: tyq
 * @create: 2019-06-25 16:22
 **/
@Data
public class ApplyStateResponse {
    @JsonProperty("current")
    String current;
}
