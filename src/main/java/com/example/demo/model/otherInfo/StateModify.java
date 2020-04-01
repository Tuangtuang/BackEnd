package com.example.demo.model.otherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 修改状态
 * @author: tyq
 * @create:
 **/
@Data
public class StateModify {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("studentId")
    String studentId;
    @JsonProperty("missionName")
    String missionName;
}
