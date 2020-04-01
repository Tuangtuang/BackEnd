package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 选择学校添加待锁定学校接口 #11
 * @author: tyq
 * @create:
 **/
@Data
public class ChooseSchool {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
    @JsonProperty("schoolId")
    String SchoolId;
    @JsonProperty("projectName")
    String projectName;
}
