package com.example.demo.model.flow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description:选择学校未完成转移状态至下一步接口 #72
 * @author: tyq
 * @create:
 **/
@Data
public class UserModifyState {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
//    @JsonProperty("")
}
