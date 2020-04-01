package com.example.demo.service;


import com.example.demo.model.otherInfo.OtherDDL;
import com.example.demo.model.otherInfo.StateModify;
import com.example.demo.model.overview.Result;

public interface OtherInfoService {
//    教师申请流程提交其他事项截止时间接口 #59

    Result putOtherDDl(OtherDDL otherDDL);

//    教师其他事项修改事项状态接口 #62
    Result modifyState(StateModify stateModify);

//    其他事项获取事项信息接口 #41
    Result getOtherInfo(String userId);


}
