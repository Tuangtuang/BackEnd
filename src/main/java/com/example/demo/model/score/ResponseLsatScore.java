package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 返回lsat成绩
 * @author: tyq
 * @create:
 **/
@Data
public class ResponseLsatScore {
    @JsonProperty("id")
    String id;
    @JsonProperty("testdate")
    String testDate;
    @JsonProperty("overall")
    String overall;
    @JsonProperty("overall_percentile")
    String overallPercentile;
    @JsonProperty("reading")
    String reading;
    @JsonProperty("reading_percentile")
    String readingPercentile;
    @JsonProperty("logic")
    String logic;
    @JsonProperty("logic_percentile")
    String logicPercentile;
    @JsonProperty("analysis")
    String analysis;
    @JsonProperty("analysis_percentile")
    String analysisPercentile;
}
