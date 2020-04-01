package com.example.demo.model.otherInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Data
public class OtherInfoItemResponse {
    @JsonProperty("missionList")
    List<OtherInfoItem> missionList;
}
