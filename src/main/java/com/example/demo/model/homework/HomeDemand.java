package com.example.demo.model.homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 作业要求接口
 * @author: tyq
 * @create:
 **/
@Data
public class HomeDemand {
    @JsonProperty("homeworkDemand")
    String homeworkDemand;
}
