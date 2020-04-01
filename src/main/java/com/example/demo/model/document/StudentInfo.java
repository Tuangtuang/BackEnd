package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Data
public class StudentInfo {
    @JsonProperty("userId")
    String studentId;
    @JsonProperty("teaId")
    String teacherId;

}
