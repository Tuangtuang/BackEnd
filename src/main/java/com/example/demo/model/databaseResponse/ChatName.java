package com.example.demo.model.databaseResponse;

import java.sql.Timestamp;

/**
 * @program: demo
 * @description: 文书，聊天姓名获取
 * @author: tyq
 * @create:
 **/
public class ChatName {
    private String detail;
    private String name;
    private Timestamp postTime;
    private Integer identityTag;

    public void setIdentityTag(Integer identityTag) {
        this.identityTag = identityTag;
    }

    public Integer getIdentityTag() {
        return identityTag;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }


    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setName(String name) {
        this.name = name;
    }
}
