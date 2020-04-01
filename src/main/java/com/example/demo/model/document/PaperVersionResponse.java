package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


/**
 * @program: demo
 * @description: 返回文书信息
 * @author: tyq
 * @create:
 **/
@Data
public class PaperVersionResponse {
    @JsonProperty("name")
    String name;
    @JsonProperty("timeList")
    List<PaperVersion> timeList;
}
