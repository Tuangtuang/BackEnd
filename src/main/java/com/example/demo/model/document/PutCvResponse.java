package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 上传CV之后的返回信息
 * @author: tyq
 * @create:
 **/
@Data
public class PutCvResponse {
    @JsonProperty("versionId")
    String versionId;
    @JsonProperty("name")
    String name;
    @JsonProperty("version")
    String version;
}
