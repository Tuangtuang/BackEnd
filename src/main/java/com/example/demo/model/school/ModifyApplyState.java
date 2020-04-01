package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 申请进度修改
 * @author: tyq
 * @create:
 **/
@Data
public class ModifyApplyState {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("studentSchoolId")
    String studentSchoolId;
    @JsonProperty("status")
    String status;
    @JsonProperty("link")
    String link;
}
