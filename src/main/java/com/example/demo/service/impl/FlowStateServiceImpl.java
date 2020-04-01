package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.model.entity.Student;
import com.example.demo.model.flow.FlowResponse;
import com.example.demo.model.overview.Result;
import com.example.demo.service.FlowStateService;
import com.example.demo.tool.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Service
public class FlowStateServiceImpl implements FlowStateService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Result getCurrentState(String userId) {
//        检查学生是否存在
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
        FlowResponse flowResponse = new FlowResponse();

        if(student.getCoins()<0){
            flowResponse.setCurrent("2");
//            student.setCoins(0);
//            studentMapper.updateByPrimaryKeySelective(student);
        }else {
            if (student.getApplyState() == 0 ) {
                flowResponse.setCurrent("1");
            } else if (student.getApplyState() == 1){
                flowResponse.setCurrent("2");
            }
            else {
                flowResponse.setCurrent(student.getApplyState().toString());
            }
        }
        return ResultTool.success(flowResponse);


    }

    /**
     * @Description: 选择学校未完成转移状态至下一步接口 #72
     * @Param: [userId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result enterPaper(String userId) {
//        检查学生是否存在
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
//        修改进度条
        if (student.getApplyState() <= 2) {
            student.setCoins(-1);
            studentMapper.updateByPrimaryKeySelective(student);
            return ResultTool.success();
        }
        return ResultTool.error("无法更新");
    }
}
