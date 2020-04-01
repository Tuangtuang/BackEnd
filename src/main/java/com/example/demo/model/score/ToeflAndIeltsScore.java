package com.example.demo.model.score;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 托福雅思成绩上传接口
 * @author: tyq
 * @create:
 **/
@Data
public class ToeflAndIeltsScore {
    @JsonProperty("userId")
    String userId;
    @JsonProperty("teaId")
    String teaId;
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
