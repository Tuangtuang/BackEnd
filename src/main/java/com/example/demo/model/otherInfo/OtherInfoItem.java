package com.example.demo.model.otherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Data
public class OtherInfoItem {
    @JsonProperty("name")
    String name;
    @JsonProperty("deadline")
    String deadline;
    @JsonProperty("status")
    String status;

}
