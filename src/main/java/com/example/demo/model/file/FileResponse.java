package com.example.demo.model.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 文件下载接口
 * @author: tyq
 * @create: 2019-06-20 13:33
 **/
@Data
public class FileResponse {
    @JsonProperty("fileName")
    String fileName;
    @JsonProperty("file")
    String url;
}
