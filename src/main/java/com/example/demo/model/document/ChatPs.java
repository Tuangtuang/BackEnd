package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 师生交流
 * @author: tyq
 * @create:
 **/
@Data
public class ChatPs {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
    @JsonProperty("studentSchoolId")
    String studentSchoolId;
    @JsonProperty("versionId")
    String versionId;
    @JsonProperty("message")
    String message;

}
