package com.example.demo.model.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
        import lombok.Data;

/**
 * @program: demo
 * @description: 返回id
 * @author: tyq
 * @create: 2019-06-30 16:53
 **/
@Data
public class IdResponse {
    @JsonProperty("id")
    String id;
}
