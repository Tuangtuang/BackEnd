package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 返回托福/雅思成绩
 * @author: tyq
 * @create:
 **/
@Data
public class ResponseIeltsToeflScore {
    @JsonProperty("id")
    String Id;
    @JsonProperty("testdate")
    String testDate;
    @JsonProperty("overall")
    String overall;
    @JsonProperty("speaking")
    String speaking;
    @JsonProperty("writing")
    String writing;
    @JsonProperty("reading")
    String reading;
    @JsonProperty("listening")
    String listening;
}
