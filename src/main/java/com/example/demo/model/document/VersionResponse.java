package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 返回数据
 * @author: tyq
 * @create:
 **/
@Data
public class VersionResponse {
    @JsonProperty("versionList")
    List<PaperVersionResponse> versionResponseList;
}
