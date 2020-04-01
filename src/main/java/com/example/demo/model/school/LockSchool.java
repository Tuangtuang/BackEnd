package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 锁定一个学校接口
 * @author: tyq
 * @create:
 **/
@Data
public class LockSchool {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
    @JsonProperty("studentSchoolId")
    String studentSchoolId;
}
