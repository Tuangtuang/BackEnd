package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 搜索学校信息#9
 * @author: tyq
 * @create:
 **/
@Data
public class SearchSchoolInfo {
    @JsonProperty("id")
    String schoolId;
    @JsonProperty("name")
    String schoolName;
    @JsonProperty("chooseStatus")
    String chooseStatus;
}
