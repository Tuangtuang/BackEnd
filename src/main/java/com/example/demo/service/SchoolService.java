package com.example.demo.service;

import com.example.demo.model.overview.Result;
import com.example.demo.model.school.ChooseSchool;
import com.example.demo.model.school.LockSchool;
import org.springframework.web.multipart.MultipartFile;


public interface SchoolService {
//    选择学校获取锁定学校信息接口 #6
    Result getLockedSchool(String userId);

//    获取待锁定学校信息接口 #7
    Result getUnlockedSchool(String userId);

//    检查是否存在师生关系
    Boolean checkStudentTeacherRelationship(String studentId,String teacherId);

//    获取搜索学校信息 #9
    Result getSearchSchool(String name,String userId);

//    选择学校锁定学校信息接口 #10
    Result lockSchool(LockSchool lockSchool);

//    选择学校添加待锁定学校接口 #11
    Result chooseSchool(ChooseSchool chooseSchool);

//    选择学校删除待锁定学校信息接口 #51
    Result deleteUnlockedSchool(LockSchool lockSchool);

//    选择学校解锁学校信息接口 #50
    Result unlockSchool(LockSchool lockSchool);

//    选择学校学生完成选校接口 #42
    Result finishSchoolChoosing(String userId);

//    教师选择学校确认学校上传文件接口 #60
    Result finishUploadFile(MultipartFile file,String userId);

    Result getStudentChooseState(String studentId);

//    教师申请流程修改学校状态接口 #58
    Result modifyState(String studentSchoolId,String status,String applyAddress);

//    申请流程获取状态接口 #40
    Result getApplyState(String userId);


//    获取选校流程是否完成接口 #88
    Result isFinishSchoolChoosing(String studentId,boolean tag);

//    教师选校阶段获取学生是否完成选校接口 #94
    Result isStudentFinish(String studentId);
}
