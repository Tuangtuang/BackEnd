package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Data
public class ResponseGreGmatScore {
    @JsonProperty("testdate")
    String testDate;
    @JsonProperty("overall")
    String overAll;
    @JsonProperty("overall_percentile")
    String overallPercentile;
    @JsonProperty("verbal")
    String verbal;
    @JsonProperty("verbal_percentile")
    String verbalPercentile;
    @JsonProperty("quantitative")
    String quantitative;
    @JsonProperty("quantitative_percentile")
    String quantitativePercentile;
    @JsonProperty("writing")
    String writing;
    @JsonProperty("writing_percentile")
    String writingPercentile;
    @JsonProperty("id")
    String id;
}
