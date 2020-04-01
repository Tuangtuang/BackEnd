package com.example.demo.service;

import com.example.demo.model.overview.Result;

public interface FlowStateService {

//    内部系统步骤条状态接口 #68
    Result getCurrentState(String userId);

//    选择学校未完成转移状态至下一步接口 #72
    Result enterPaper(String userId);

}
