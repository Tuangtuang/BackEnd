package com.example.demo.model.basicInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 获取老师基本信息
 * @author: tyq
 * @create:
 **/
@Data
public class TeacherBasicInfo {
    @JsonProperty("userPhone")
    String userPhone;
    @JsonProperty("userEmail")
    String userEmail;
    @JsonProperty("userPassword")
    String userPassword;

}
