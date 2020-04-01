package com.example.demo.service.impl;

import com.example.demo.dao.OtherInfoMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.model.entity.OtherInfo;
import com.example.demo.model.entity.OtherInfoExample;
import com.example.demo.model.entity.Student;
import com.example.demo.model.otherInfo.OtherDDL;
import com.example.demo.model.otherInfo.OtherInfoItem;
import com.example.demo.model.otherInfo.OtherInfoItemResponse;
import com.example.demo.model.otherInfo.StateModify;
import com.example.demo.model.overview.Result;
import com.example.demo.service.OtherInfoService;
import com.example.demo.tool.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 其他事项接口
 * @author: tyq
 * @create:
 **/
@Service
public class OtherInfoServiceImpl implements OtherInfoService {

    @Resource
    StudentMapper studentMapper;

    @Resource
    OtherInfoMapper otherInfoMapper;

    @Override
    public Result putOtherDDl(OtherDDL otherDDL) {
//        检查学生是否存在
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(otherDDL.getStudentId()));
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
//        检查是否已经存在该学生的ddl
        OtherInfoExample otherInfoExample=new OtherInfoExample();
        otherInfoExample.createCriteria().andVaccineStateEqualTo(Integer.parseInt(otherDDL.getStudentId()));
        List<OtherInfo > otherInfoList=otherInfoMapper.selectByExample(otherInfoExample);
        if(otherInfoList.isEmpty()==false){
            return ResultTool.error("已经存在该学生的ddl信息");
        }

//        插入数据库
        OtherInfo record = new OtherInfo();
        Timestamp passwordDDL;
        Timestamp depositDDL;
        Timestamp dormitoryDDL;
        Timestamp testDDL;
        Timestamp feeDDL;
        Timestamp documentDDL;
        try {
           passwordDDL = stringToTimestamp(otherDDL.getPassport());
           depositDDL = stringToTimestamp(otherDDL.getDeposit());
           dormitoryDDL = stringToTimestamp(otherDDL.getDormitory());
           testDDL = stringToTimestamp(otherDDL.getTest());
           feeDDL = stringToTimestamp(otherDDL.getFee());
           documentDDL = stringToTimestamp(otherDDL.getDocument());
        }catch (Exception e){
            return ResultTool.error("时间不合法");
        }


        record.setDeposit(depositDDL);
        record.setPassport(passwordDDL);
        record.setDormitory(dormitoryDDL);
        record.setTest(testDDL);
        record.setFee(feeDDL);
        record.setDocument(documentDDL);
        record.setVaccineState(Integer.parseInt(otherDDL.getStudentId()));

        record.setPassportState(0);
        record.setDepositState(0);
        record.setDocumentState(0);
        record.setFeeState(0);
        record.setTestState(0);
        record.setDormitoryState(0);
        otherInfoMapper.insert(record);
        return ResultTool.success();

    }

    //    时间字符串转时间戳
    Timestamp stringToTimestamp(String time) {
        Timestamp ts;
        time = time + " 00:00:00";
        ts = Timestamp.valueOf(time);
        return ts;
    }

    /** 
    * @Description: 教师其他事项修改事项状态接口 #62 
    * @Param: [stateModify] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result modifyState(StateModify stateModify) {
//        检查是否存在该学生的记录
        OtherInfoExample otherInfoExample=new OtherInfoExample();
        List<OtherInfo> otherInfoList=otherInfoMapper.selectByExample(otherInfoExample);
        if(otherInfoList.isEmpty()==true){
            return ResultTool.error("不存在该学生的其他事项");
        }
        if(stateModify.getMissionName().equals("护照")){
            otherInfoList.get(0).setPassportState(1);
            otherInfoMapper.updateByPrimaryKeySelective(otherInfoList.get(0));
        }


        if(stateModify.getMissionName().equals("定金")){
            otherInfoList.get(0).setDepositState(1);
            otherInfoMapper.updateByPrimaryKeySelective(otherInfoList.get(0));
        }


        if(stateModify.getMissionName().equals("住宿")){
            otherInfoList.get(0).setDormitoryState(1);
            otherInfoMapper.updateByPrimaryKeySelective(otherInfoList.get(0));
        }


        if(stateModify.getMissionName().equals("入学测试")){
            otherInfoList.get(0).setTestState(1);
            otherInfoMapper.updateByPrimaryKeySelective(otherInfoList.get(0));
        }


        if(stateModify.getMissionName().equals("学费缴纳")){
            otherInfoList.get(0).setFeeState(1);
            otherInfoMapper.updateByPrimaryKeySelective(otherInfoList.get(0));

        }

        if(stateModify.getMissionName().equals("入学材料")){
            otherInfoList.get(0).setDocumentState(1);
            otherInfoMapper.updateByPrimaryKeySelective(otherInfoList.get(0));
        }

//        修改学生的申请状态
        Student student=studentMapper.selectByPrimaryKey(Integer.parseInt(stateModify.getStudentId()));
        if(student==null){
            return ResultTool.error("该学生不存在");
        }
        if(student.getApplyState()<3){
            return ResultTool.error("学生没有完成文书编写!");
        }
        student.setApplyState(4);
        studentMapper.updateByPrimaryKeySelective(student);

        return ResultTool.success();

    }



    /** 
    * @Description: 其他事项获取事项信息接口 #41
    * @Param: [userId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getOtherInfo(String userId) {
//        检查该项目是否存在
        OtherInfoExample otherInfoExample=new OtherInfoExample();
        otherInfoExample.createCriteria().andVaccineStateEqualTo(Integer.parseInt(userId));
        List<OtherInfo > otherInfoList=otherInfoMapper.selectByExample(otherInfoExample);
        if(otherInfoList.isEmpty()==true){
            return ResultTool.error("不存在该学生的记录");
        }
        List<OtherInfoItem> otherInfoItemList=new LinkedList<>();
        OtherInfoItem password=new OtherInfoItem();
        password.setName("护照");
        password.setDeadline(otherInfoList.get(0).getPassport().toString());
        password.setStatus(StatusToString(otherInfoList.get(0).getPassportState()));
        otherInfoItemList.add(password);


        OtherInfoItem deposit=new OtherInfoItem();
        deposit.setName("定金");
        deposit.setDeadline(otherInfoList.get(0).getDeposit().toString());
        deposit.setStatus(StatusToString(otherInfoList.get(0).getDepositState()));
        otherInfoItemList.add(deposit);

        OtherInfoItem dormitory=new OtherInfoItem();
        dormitory.setName("住宿");
        dormitory.setDeadline(otherInfoList.get(0).getDormitory().toString());
        dormitory.setStatus(StatusToString(otherInfoList.get(0).getDormitoryState()));
        otherInfoItemList.add(dormitory);

        OtherInfoItem test=new OtherInfoItem();
        test.setName("入学测试");
        test.setDeadline(otherInfoList.get(0).getTest().toString());
        test.setStatus(StatusToString(otherInfoList.get(0).getTestState()));
        otherInfoItemList.add(test);

        OtherInfoItem fee=new OtherInfoItem();
        fee.setName("学费缴纳");
        fee.setDeadline(otherInfoList.get(0).getFee().toString());
        fee.setStatus(StatusToString(otherInfoList.get(0).getFeeState()));
        otherInfoItemList.add(fee);

        OtherInfoItem document=new OtherInfoItem();
        document.setName("入学材料");
        document.setDeadline(otherInfoList.get(0).getDocument().toString());
        document.setStatus(StatusToString(otherInfoList.get(0).getDocumentState()));
        otherInfoItemList.add(document);

        OtherInfoItemResponse otherInfoItemResponse=new OtherInfoItemResponse();
        otherInfoItemResponse.setMissionList(otherInfoItemList);
        return ResultTool.success(otherInfoItemResponse);

    }

    private String StatusToString(int i){
        if(i==0){
            return "未完成";
        }
        return "已完成";
    }


}
