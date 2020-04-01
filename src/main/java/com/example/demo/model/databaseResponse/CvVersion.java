package com.example.demo.model.databaseResponse;

/**
 * @program: demo
 * @description: 获取某同学当前CV的最大版本号
 * @author: tyq
 * @create:
 **/
public class CvVersion {
//    private Integer Id;
    private Integer maxVersion;

    public Integer getMaxVersion() {
        return maxVersion;
    }

    public void setMaxVersion(Integer maxVersion) {
        this.maxVersion = maxVersion;
    }
}
