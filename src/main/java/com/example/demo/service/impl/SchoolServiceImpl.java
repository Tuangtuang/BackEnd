package com.example.demo.service.impl;

import com.example.demo.dao.SchoolMapper;
import com.example.demo.dao.StuSchoolMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TeacherStudentMapper;
import com.example.demo.model.databaseResponse.SchoolApplyInfo;
import com.example.demo.model.databaseResponse.SchoolNameInfo;
import com.example.demo.model.entity.*;
import com.example.demo.model.overview.Result;
import com.example.demo.model.school.*;
import com.example.demo.service.SchoolService;
import com.example.demo.tool.FileTool;
import com.example.demo.tool.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 选校service层
 * @author: tyq
 * @create:
 **/
@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private StuSchoolMapper stuSchoolMapper;

    @Resource
    private TeacherStudentMapper teacherStudentMapper;

    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private StudentMapper studentMapper;

    //TODO 部署到服务器后修改路径
//    private String pathValue = "/var/lib/jiyiedu/";
    private String pathValue=System.getProperty("user.dir")+"/";

    /**
     * @Description: 获取锁定学校接口，state=1
     * @Param:
     * @return:
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result getLockedSchool(String userId) {
        int stuId = Integer.parseInt(userId);
        List<SchoolNameInfo> lockedSchoolList = stuSchoolMapper.stuLockedStudentSchoolInfo(stuId);
//        if (lockedSchoolList.isEmpty() == true) {
//            return ResultTool.error("该学生没有锁定学校");
//        }
        List<SchoolInfo> schoolInfoList = new LinkedList<>();
        for (SchoolNameInfo item : lockedSchoolList) {
            SchoolInfo info = new SchoolInfo();
            info.setStudentSchoolId(item.getStudentSchoolId().toString());
            info.setProjectName(item.getProjectName());
            info.setSchoolName(item.getSchoolName());
            schoolInfoList.add(info);
        }
        return ResultTool.success(schoolInfoList);
    }

    /**
     * @Description: 获取等待锁定学校信息接口，state=0
     * @Param: [userId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result getUnlockedSchool(String userId) {
        int stuId = Integer.parseInt(userId);
        List<SchoolNameInfo> unlockedSchoolList = stuSchoolMapper.stuUnlockedStudentSchoolInfo(stuId);
//        if (unlockedSchoolList.isEmpty() == true) {
//            return ResultTool.error("该学生没有待锁定学校");
//        }
        List<SchoolInfo> schoolInfoList = new LinkedList<>();
        for (SchoolNameInfo item : unlockedSchoolList) {
            SchoolInfo info = new SchoolInfo();
            info.setStudentSchoolId(item.getStudentSchoolId().toString());
            info.setProjectName(item.getProjectName());
            info.setSchoolName(item.getSchoolName());
            schoolInfoList.add(info);
        }
        return ResultTool.success(schoolInfoList);
    }

    /**
     * @Description: 检查是否存在师生关系
     * @Param: [studentId, teacherId]
     * @return: java.lang.Boolean
     * @Author: tyq
     * @Date: 2019-05-16
     */
    @Override
    public Boolean checkStudentTeacherRelationship(String studentId, String teacherId) {
        int stuId = Integer.parseInt(studentId);
        int teaId = Integer.parseInt(teacherId);
        TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
        teacherStudentExample.createCriteria().andStuIdEqualTo(stuId).andTeacherIdEqualTo(teaId);
        List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectByExample(teacherStudentExample);
        if (teacherStudentList.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 搜索学校信息
     * @Param: [name, studentId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result getSearchSchool(String name, String studentId) {
//        return null;
//        先获取目标学校
        List<School> schoolList = schoolMapper.searchSchoolInfo(name);
//        获取已选择学校
        StuSchoolExample stuSchoolExample = new StuSchoolExample();
        stuSchoolExample.createCriteria().andIdEqualTo(Integer.parseInt(studentId));
        List<StuSchool> chosenList = stuSchoolMapper.selectByExample(stuSchoolExample);
        List<SearchSchoolInfo> searchSchoolInfoList = new LinkedList<>();
        for (School item : schoolList) {
            SearchSchoolInfo searchSchoolInfo = new SearchSchoolInfo();
            if (checkChooseStatus(item.getId(), chosenList) == true) {
                searchSchoolInfo.setChooseStatus("1");
            } else {
                searchSchoolInfo.setChooseStatus("0");
            }
            searchSchoolInfo.setSchoolId(item.getId().toString());
            searchSchoolInfo.setSchoolName(item.getSchoolName());
            searchSchoolInfoList.add(searchSchoolInfo);
        }
        return ResultTool.success(searchSchoolInfoList);
    }

    //    查看学校id是否在学校列表中
    private boolean checkChooseStatus(Integer schoolId, List<StuSchool> stuSchoolList) {
        for (StuSchool target : stuSchoolList) {
            if (schoolId.equals(target.getSchoolId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 锁定学校
     * @Param: [lockSchool]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result lockSchool(LockSchool lockSchool) {

        //  检查是否锁定的是对应用户的选校
        StuSchool target = stuSchoolMapper.selectByPrimaryKey(Integer.parseInt(lockSchool.getStudentSchoolId()));
        if (target.getStuId().intValue() != Integer.parseInt(lockSchool.getUserId())) {
            return ResultTool.error("用户id和要修改的记录不匹配");
        }
        StuSchool record = new StuSchool();
        record.setId(Integer.parseInt(lockSchool.getStudentSchoolId()));
        record.setState(1);
        stuSchoolMapper.updateByPrimaryKeySelective(record);
        return ResultTool.success();
    }

    /**
     * @Description: 选择学校添加待锁定学校接口 #11
     * @Param: [chooseSchool]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result chooseSchool(ChooseSchool chooseSchool) {
//        检查学校是否存在
        School school = schoolMapper.selectByPrimaryKey(Integer.parseInt(chooseSchool.getSchoolId()));
        if (school == null) {
            return ResultTool.error("该学校不存在");
        }
//        检查是否已经选过该学校的该项目
        StuSchoolExample check = new StuSchoolExample();
        check.createCriteria().andStuIdEqualTo(Integer.parseInt(chooseSchool.getUserId())).andSchoolIdEqualTo(Integer.parseInt(chooseSchool.getSchoolId())).andProjectEqualTo(chooseSchool.getProjectName());
        List<StuSchool> checkList = stuSchoolMapper.selectByExample(check);
        if (checkList.isEmpty() == false) {
            return ResultTool.error("您已经选过该学校的该项目");
        }
//        选校
        StuSchool stuSchool = new StuSchool();
        stuSchool.setStuId(Integer.parseInt(chooseSchool.getUserId()));
        stuSchool.setSchoolId(Integer.parseInt(chooseSchool.getSchoolId()));
        stuSchool.setProject(chooseSchool.getProjectName());
        stuSchool.setState(0);
        stuSchoolMapper.insert(stuSchool);
        StuStudentId stuStudentId = new StuStudentId();
        stuStudentId.setStudentSchoolId(stuSchool.getId().toString());
        return ResultTool.success(stuStudentId);
    }

    /**
     * @Description: 选择学校删除待锁定学校信息接口 #51
     * @Param: [lockSchool]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result deleteUnlockedSchool(LockSchool lockSchool) {
//        return null;
//        检查该锁定学校是否存在
        StuSchoolExample stuSchoolExample = new StuSchoolExample();
        stuSchoolExample.createCriteria().andStuIdEqualTo(Integer.parseInt(lockSchool.getUserId()))
                .andIdEqualTo(Integer.parseInt(lockSchool.getStudentSchoolId())).andStateEqualTo(0);
        List<StuSchool> checkList = stuSchoolMapper.selectByExample(stuSchoolExample);
        if (checkList.isEmpty() == true) {
            return ResultTool.error("不存在该记录");
        }
//        删除学校
        stuSchoolMapper.deleteByExample(stuSchoolExample);
        return ResultTool.success();
    }

    /**
     * @Description: 解锁学校
     * @Param: [lockSchool]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result unlockSchool(LockSchool lockSchool) {
//        return null;
//        检查解锁学校是否存在
        StuSchoolExample stuSchoolExample = new StuSchoolExample();
        stuSchoolExample.createCriteria().andStateEqualTo(1)
                .andStuIdEqualTo(Integer.parseInt(lockSchool.getUserId()))
                .andIdEqualTo(Integer.parseInt(lockSchool.getStudentSchoolId()));
        List<StuSchool> checkList = stuSchoolMapper.selectByExample(stuSchoolExample);
        if (checkList.isEmpty() == true) {
            return ResultTool.error("不存在该记录");
        }
        StuSchool record = new StuSchool();
        record.setId(Integer.parseInt(lockSchool.getStudentSchoolId()));
        record.setState(0);
        stuSchoolMapper.updateByPrimaryKeySelective(record);
        return ResultTool.success();
    }

    /**
     * @Description: 学生完成选校接口
     * @Param: [userId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result finishSchoolChoosing(String userId) {
        StuSchoolExample stuSchoolExample = new StuSchoolExample();
        stuSchoolExample.createCriteria().andStuIdEqualTo(Integer.parseInt(userId)).andStateEqualTo(0);
        stuSchoolMapper.deleteByExample(stuSchoolExample);
        Student record = studentMapper.selectByPrimaryKey(Integer.parseInt(userId));
        record.setApplyState(1);//1表示学生完成
//        if(record.getCoins()<0){
//            record.setCoins(0);
//        }
        studentMapper.updateByPrimaryKeySelective(record);

        return ResultTool.success();
    }

    /**
     * @Description: 教师选择学校确认学校上传文件接口 #60
     * @Param: [file, userId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result finishUploadFile(MultipartFile file, String userId) {
//        return null;
//        String filePath=pathValue
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (student == null) {
            return ResultTool.error("该学生不存在");
        }
        if (student.getApplyState() < 1) {
            return ResultTool.error("学生尚未完成选校");
        }
        String filePath = pathValue + userId + "_" + student.getName() + "/" + file.getOriginalFilename();
        log.info(filePath);
        FileTool.uploadFile(filePath, file);
//        修改进度条
        Student record = new Student();
        record.setId(Integer.parseInt(userId));
        record.setApplyState(2);//2表示选校完成
        if(student.getCoins()<0){
            record.setCoins(0);
        }
        studentMapper.updateByPrimaryKeySelective(record);
        return ResultTool.success();
    }

    @Override
    public Result getStudentChooseState(String studentId) {
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if (student == null) {
            return ResultTool.error("该学生不存在");
        }
        StudentChooseState studentChooseState = new StudentChooseState();
        if (student.getApplyState() >= 1) {
            studentChooseState.setStudentChooseStatus("true");
        } else {
            studentChooseState.setStudentChooseStatus("true");
        }
        return ResultTool.success(studentChooseState);

    }

    @Override
    public Result modifyState(String studentSchoolId, String status, String applyAddress) {
//        检查是否存在该记录
        StuSchool stuSchool = stuSchoolMapper.selectByPrimaryKey(Integer.parseInt(studentSchoolId));
        if(!status.equals("")){
            if (stuSchool == null) {
                return ResultTool.error("不存在该记录");
            }

            if (stuSchool.getState() < 1) {
                return ResultTool.error("该学校未锁定");
            }
            int state = 2;
            if (status.equals("未开始")) {
                state = 2;
            }
            if (status.equals("申请中")) {
                state = 3;
            }
            if (status.equals("已完成")) {
                state = 4;
            }
            if (status.equals("已录取")) {
                state = 5;
            }
            if (status.equals("已拒绝")) {
                state = 6;
            }
            stuSchool.setState(state);
        }
        if(!applyAddress.equals("")){
            stuSchool.setApplyAddress(applyAddress);
        }

        stuSchoolMapper.updateByPrimaryKeySelective(stuSchool);
        return ResultTool.success();

    }

    /**
     * @Description: 申请流程获取状态接口 #40
     * @Param: [userId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result getApplyState(String userId) {
//        获取该同学的选校列表
        StuSchoolExample stuSchoolExample = new StuSchoolExample();
        stuSchoolExample.createCriteria().andStuIdEqualTo(Integer.parseInt(userId));
        List<StuSchool> stuSchoolList = stuSchoolMapper.selectByExample(stuSchoolExample);
        if (stuSchoolList.isEmpty() == true) {
            return ResultTool.error("不存在该同学的选校记录");
        }
        List<SchoolApplyInfo> schoolApplyInfoList = studentMapper.getItem(Integer.parseInt(userId));
        log.info(schoolApplyInfoList.size() + "");
        List<ApplyStateItem> applyStateItemList = new LinkedList<>();
        for (SchoolApplyInfo item : schoolApplyInfoList) {
            ApplyStateItem info = new ApplyStateItem();
            info.setId(item.getId().toString());
            info.setLink(item.getLink());
            info.setName(item.getName());
            info.setProjectName(item.getProjectName());
            if (item.getStepNum() <= 2) {
                info.setStepNum(item.getStepNum().toString());
            } else {
                info.setStepNum("3");
                info.setAdmit(item.getStepNum() == 3 ? "true" : "false");
            }
            applyStateItemList.add(info);
        }

        ApplyStateResponse applyStateResponse = new ApplyStateResponse();
        applyStateResponse.setSchoolList(applyStateItemList);
        return ResultTool.success(applyStateResponse);


    }


    /**
     * @Description: 获取选校流程是否完成接口 #88
     * @Param: [studentId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result isFinishSchoolChoosing(String studentId, boolean tag) {
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
        IsFinish isFinish = new IsFinish();
        if (tag == true) {
//            学生登陆
            if (student.getApplyState() < 1) {
                isFinish.setFinish("false");
            } else {
                isFinish.setFinish("true");
            }
        } else {
//            教师登陆
            if (student.getApplyState() < 2) {
                isFinish.setFinish("false");
            } else {
                isFinish.setFinish("true");
            }

        }

        return ResultTool.success(isFinish);
    }


    /** 
    * @Description: 教师选校阶段获取学生是否完成选校接口 #94
    * @Param: [studentId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result isStudentFinish(String studentId) {
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if(student==null){
            return ResultTool.error("学生不存在");
        }
        IsStudentFinish isStudentFinish=new IsStudentFinish();
        if(student.getApplyState().intValue()==1){
            isStudentFinish.setUpload("true");
        }else {
            isStudentFinish.setUpload("false");
        }
        return ResultTool.success(isStudentFinish);

    }
}
