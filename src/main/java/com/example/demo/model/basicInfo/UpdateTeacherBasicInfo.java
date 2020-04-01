package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 教师更新信息
 * @author: tyq
 * @create: 2019-06-19 10:40
 **/
@Data
public class UpdateTeacherBasicInfo {
    @JsonProperty("userId")
    String teacherId;
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;
}
