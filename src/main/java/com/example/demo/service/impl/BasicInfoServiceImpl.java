package com.example.demo.service.impl;

import com.example.demo.dao.AccountMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.model.basicInfo.*;
import com.example.demo.model.entity.*;
import com.example.demo.model.overview.Result;
import com.example.demo.service.BasicInfoService;
import com.example.demo.tool.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 学生基础信息和考试账户信息
 * @author: tyq
 * @create:
 **/
@Service
public class BasicInfoServiceImpl implements BasicInfoService {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private TeacherMapper teacherMapper;

    
    /** 
    * @Description: 修改个人基本信息接口 #2 
    * @Param: [modifyBasicInfo] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result postBasicInfo(ModifyBasicInfo modifyBasicInfo) {
        int id=Integer.parseInt(modifyBasicInfo.getUserId());
        Student student=studentMapper.selectByPrimaryKey(id);
        if(student==null){
            return ResultTool.error("用户不存在");
        }
        student.setId(id);
        student.setPhone(modifyBasicInfo.getUserPhone());
        student.setMail(modifyBasicInfo.getUserEmail());
        student.setPassword(modifyBasicInfo.getUserPassword());
        student.setGrade(modifyBasicInfo.getUserGrade());
        student.setGpa(modifyBasicInfo.getUserGpa());
        student.setMajor(modifyBasicInfo.getUserMajor());
        student.setSchool(modifyBasicInfo.getUserSchool());
        try {
            studentMapper.updateByPrimaryKey(student);

        }catch (Exception e){
            return ResultTool.error("无法更新个人信息");
        }
        return ResultTool.success();
    }



    /**
    * @Description: 用户获取基本信息接口 #3
    * @Param: [getBasicInfo]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result getBasicInfo(String userId) {
        int id=Integer.parseInt(userId);
        Student student=studentMapper.selectByPrimaryKey(id);
        GetBasicInfo getBasicInfo=new GetBasicInfo();
        getBasicInfo.setUserPhone(student.getPhone());
        getBasicInfo.setUserPassword(student.getPassword());
        getBasicInfo.setUserEmail(student.getMail());
        getBasicInfo.setUserGrade(student.getGrade());
        getBasicInfo.setUserSchool(student.getSchool());
        getBasicInfo.setUserGpa(student.getGpa());
        getBasicInfo.setUserMajor(student.getMajor());
        return ResultTool.success(getBasicInfo);
    }

    /** 
    * @Description: 添加考试账户信息，#4
    * @Param: [addTestAccount] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result addAccount(AddTestAccount addTestAccount) {
        // 检查是否存同一个用户的相同账号
        AccountExample accountExample=new AccountExample();
        int id=Integer.parseInt(addTestAccount.getUserId());
        accountExample.createCriteria().andUserIdEqualTo(id).andTypeEqualTo(addTestAccount.getExamType());
        List<Account> AccountList=accountMapper.selectByExample(accountExample);
        if(AccountList.isEmpty()==false){
            return ResultTool.error("该考试账户密码已存在!");
        }
        Account item=new Account();
        item.setUserId(id);
        item.setAccount(addTestAccount.getAccount());
        item.setType(addTestAccount.getExamType());
        item.setPassword(addTestAccount.getPassword());
        try {
            accountMapper.insert(item);
        }catch (Exception e){
            return ResultTool.error("插入失败");
        }
        return ResultTool.success();
    }

    
    /** 
    * @Description: 用户获取考试账户信息 
    * @Param: [userId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getAccount(String userId) {
        AccountExample accountExample=new AccountExample();
        accountExample.createCriteria().andUserIdEqualTo(Integer.parseInt(userId));
        List<Account> accountList=accountMapper.selectByExample(accountExample);
        List<GetTestAccount> getTestAccountList=new LinkedList<>();
        if(accountList.isEmpty()==false){
            for(Account account :accountList){
                GetTestAccount getTestAccount=new GetTestAccount();
                getTestAccount.setType(getTestName(Integer.parseInt(account.getType())));
                getTestAccount.setPassword(account.getPassword());
                getTestAccount.setAccount(account.getAccount());
                getTestAccountList.add(getTestAccount);
            }
        }
        return ResultTool.success(getTestAccountList);
    }

    private String getTestName(int i){
        switch (i){
            case 1:return "GRE";
            case 2:return "GMAT";
            case 3:return "LSAT";
            case 4:return "TOEFL";
            case 5:return "IELTS";
            case 6:return "SAT1";
            case 7:return "SAT2";
            case 8:return "IB";
            default:return "AP";
        }
    }

    /**
    * @Description: 删除考试账户信息
    * @Param: [deleteTestAccount]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result deleteAccount(DeleteTestAccount deleteTestAccount) {
        AccountExample accountExample=new AccountExample();
        accountExample.createCriteria().andUserIdEqualTo(Integer.parseInt(deleteTestAccount.getUserId())).andTypeEqualTo(deleteTestAccount.getExamType());
        List<Account> accountList=accountMapper.selectByExample(accountExample);
        if(accountList.isEmpty()==true){
            return ResultTool.error("不存在该考试账户");
        }
        accountMapper.deleteByExample(accountExample);
        return ResultTool.success();
    }

    /** 
    * @Description: 内部系统教师获取个人基本信息接口 #73
    * @Param: [userId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getTeacherBasicInfo(String userId) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if(teacher==null){
            return ResultTool.error("老师不存在");
        }
        TeacherBasicInfo teacherBasicInfo=new TeacherBasicInfo();
        teacherBasicInfo.setUserEmail(teacher.getMail());
        teacherBasicInfo.setUserPassword(teacher.getPassword());
        teacherBasicInfo.setUserPhone(teacher.getPhone());
        return ResultTool.success(teacherBasicInfo);
    }

    /**
    * @Description: 内部系统教师提交个人基本信息接口 #74
    * @Param: [updateTeacherBasicInfo]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result updateTeacherBasicInfo(UpdateTeacherBasicInfo updateTeacherBasicInfo) {
//        获取用户id
        int id = Integer.parseInt(updateTeacherBasicInfo.getTeacherId());
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        if(teacher==null){
            return ResultTool.error("老师不存在");
        }
        teacher.setMail(updateTeacherBasicInfo.getUserEmail());
        teacher.setPassword(updateTeacherBasicInfo.getUserPassword());
        teacher.setPhone(updateTeacherBasicInfo.getUserPhone());
        teacherMapper.updateByPrimaryKeySelective(teacher);
        return ResultTool.success();
    }
}
