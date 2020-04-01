package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 是否完成选校
 * @author: tyq
 * @create:
 **/
@Data
public class IsFinish {
    @JsonProperty("finish")
    String finish;
}
