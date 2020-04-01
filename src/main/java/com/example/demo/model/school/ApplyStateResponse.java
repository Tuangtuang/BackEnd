package com.example.demo.model.school;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @description: 申请结果返回信息
 * @author: tyq
 * @create:
 **/
@Data
public class ApplyStateResponse {
    @JsonProperty("schoolList")
    List<ApplyStateItem> schoolList;

}
