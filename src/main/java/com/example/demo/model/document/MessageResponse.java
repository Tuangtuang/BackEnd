package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 消息返回
 * @author: tyq
 * @create:
 **/
@Data
public class MessageResponse {
    @JsonProperty("messList")
    List<ChatInfoResponse> messList;

}
