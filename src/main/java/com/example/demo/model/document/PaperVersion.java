package com.example.demo.model.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: demo
 * @description: 版本信息
 * @author: tyq
 * @create:
 **/

public class PaperVersion {
    private String versionId;//主键id
    private String name;
    private String version;//版本号码

    public String getVersionId() {
        return versionId;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
