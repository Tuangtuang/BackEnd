package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 获取选校信息,#6
 * @author: tyq
 * @create:
 **/
@Data
public class SchoolInfo {
    @JsonProperty("studentSchoolId")
    String studentSchoolId;
    @JsonProperty("name")
    String schoolName;
    @JsonProperty("projectName")
    String projectName;

}
