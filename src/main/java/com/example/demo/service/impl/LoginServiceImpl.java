package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.SuperManagerMapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.model.entity.*;
import com.example.demo.model.login.*;
import com.example.demo.model.overview.Result;
import com.example.demo.service.LoginService;
import com.example.demo.tool.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: demo
 * @description: 登陆
 * @author: tyq
 * @create:
 **/
@Service

public class LoginServiceImpl implements LoginService  {

    private static final String KEY = "wulaoshizuikoumen";

    @Resource
    private SuperManagerMapper superManagerMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;


   
    /** 
    * @Description: 接口52，用户忘记密码，进行短信验证 
    * @Param: [phone] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result SmsVerification(String phone,String identity) throws com.aliyuncs.exceptions.ClientException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if(checkPhone(phone,identity)==true){
            String phoneNumber = phone;
            String randomNum = getMsgCode();// 生成随机数
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE, 1);
            String currentTime = sf.format(c.getTime());// 生成1分钟后时间，用户校验是否过期
            TextCheck.sendSms(phone,randomNum); //此处执行发送短信验证码方法
            String hash =  MD5Utils.encodeByMd5((KEY + "#"  + randomNum+"#"+phone));//生成MD5值
            CheckCode checkCode=new CheckCode();
            checkCode.setCode(hash);
            checkCode.setTime(currentTime);
            return ResultTool.success(checkCode); //将hash值和tamp时间返回给前端
        }
        return ResultTool.error("该用户不存在！");
    }

    /**
    * @Description: 检查手机号是否存在
    * @Param: [phone, identity]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkPhone(String phone,String identity){
        int ide=Integer.parseInt(identity);
        switch (ide){
            case 0:return checkSuperPhone(phone);
            case 1:return checkTeacherPhone(phone);
            case 2:return checkStudentPhone(phone);
        }
        return false;
    }

    
    /** 
    * @Description: 查看管理员手机号是否存在
    * @Param: [phone] 
    * @return: boolean 
    * @Author: tyq 
    * @Date:
    */ 
    private boolean checkSuperPhone(String phone){
        SuperManagerExample superManagerExample=new SuperManagerExample();
        superManagerExample.createCriteria().andPhoneEqualTo(phone);
        List<SuperManager> superManagerList=superManagerMapper.selectByExample(superManagerExample);
        if(superManagerList.isEmpty()==true){
            //  列表是空的，说明改手机号码不存在
            return false;
        }
        return true;
    }

    /**
    * @Description: 查看老师的手机号是否存在
    * @Param: [phone]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkTeacherPhone(String phone){
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.createCriteria().andPhoneEqualTo(phone);
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(teacherList.isEmpty()==true){
            return false;
        }
        return true;
    }

    /**
    * @Description:  查看学生的手机号是否存在
    * @Param: [phoen]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkStudentPhone(String phoen){
        StudentExample studentExample=new StudentExample();
        studentExample.createCriteria().andPhoneEqualTo(phoen);
        List<Student> studentList=studentMapper.selectByExample(studentExample);
        if(studentList.isEmpty()==true){
            return false;
        }
        return true;
    }

    /** 
    * @Description: 随机生产六位验证码 
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: tyq 
    * @Date:
    */ 
    private static String getMsgCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }


    /**
    * @Description: 确认验证码是否正确
    * @Param: [checkCodeBack]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result validateNum(CheckCodeBack checkCodeBack)  throws com.aliyuncs.exceptions.ClientException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String requestHash = checkCodeBack.getCode();//hash串
        String tamp = checkCodeBack.getTime();//来自前端的时间
        String msgNum = checkCodeBack.getInputCode();//来自前端的用户输入的验证码
        String userId=checkCodeBack.getUserId();
        String hash = MD5Utils.encodeByMd5((KEY +  "#" + msgNum+"#"+userId));//生成新的MD5值
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String currentTime = sf.format(c.getTime());
        if (tamp.compareTo(currentTime) > 0) {
            if (hash.equalsIgnoreCase(requestHash)) {
                //校验成功
                return ResultTool.success();
            } else {
                //验证码不正确，校验失败
                return ResultTool.error("验证码不正确，校验失败");
            }
        } else {
            // 超时
//            System.out.println("当前时间"+currentTime+" 前端传过来的时间"+tamp);
            return ResultTool.error("超时");
        }
    }

    
    /**
    * @Description:  接口1，用户登陆，返回token
    * @Param: [userLogin]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result UserLogin(UserLogin userLogin) {
        int identity=Integer.parseInt(userLogin.getUserIdentity());
//        System.out.println(userLogin.getUserId()+userLogin.getUserPassword()+userLogin.getUserIdentity());
        switch (identity){
            case 0: return SuperLogin(userLogin);
            case 1: return TeacherLogin(userLogin);
            case 2: return StudentLogin(userLogin);

        }
        return ResultTool.error("身份信息错误");
    }

    /**
    * @Description: 超级管理员登陆
    * @Param: [userLogin]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result SuperLogin(UserLogin userLogin){
        SuperManagerExample superManagerExample=new SuperManagerExample();
        superManagerExample.createCriteria().andPhoneEqualTo(userLogin.getUserId()).andPasswordEqualTo(userLogin.getUserPassword());
        List<SuperManager>  superManagerList=superManagerMapper.selectByExample(superManagerExample);
        if(superManagerList.isEmpty()==true){
            return ResultTool.error("用户名或密码错误");
        }
        TokenResponse tokenResponse=new TokenResponse();
        tokenResponse.setIdentity("0");
        tokenResponse.setToken(JwtUtil.createJwt(superManagerList.get(0).getId().toString()));//把id放在token里，不是手机号
        tokenResponse.setUserName(superManagerList.get(0).getName());
        tokenResponse.setUserId(superManagerList.get(0).getId().toString());
        return ResultTool.success(tokenResponse);
    }


    /**
    * @Description: 老师用户登陆接口
    * @Param: [userLogin]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result TeacherLogin(UserLogin userLogin){
        TeacherExample teacherExample=new TeacherExample();
        TokenResponse tokenResponse=new TokenResponse();
        if(userLogin.getUserId().contains("@")){
            // 邮箱登陆
            teacherExample.createCriteria().andMailEqualTo(userLogin.getUserId()).andPasswordEqualTo(userLogin.getUserPassword());
        }else{
            // 手机号登陆
            teacherExample.createCriteria().andPhoneEqualTo(userLogin.getUserId()).andPasswordEqualTo(userLogin.getUserPassword());
        }
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(teacherList.isEmpty()==true){
            return ResultTool.error("用户名或密码错误");
        }
        tokenResponse.setUserName(teacherList.get(0).getName());
        tokenResponse.setToken(JwtUtil.createJwt(teacherList.get(0).getId().toString()));
        tokenResponse.setIdentity("1");
        tokenResponse.setUserId(teacherList.get(0).getId().toString());
        return ResultTool.success(tokenResponse);
    }


    /**
    * @Description: 学生登陆接口
    * @Param: [userLogin]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result StudentLogin(UserLogin userLogin){
        StudentExample studentExample=new StudentExample();
        TokenStudentResponse tokenResponse=new TokenStudentResponse();
        if(userLogin.getUserId().contains("@")){
            //  邮箱登陆
            studentExample.createCriteria().andMailEqualTo(userLogin.getUserId()).andPasswordEqualTo(userLogin.getUserPassword());
        }else{
            studentExample.createCriteria().andPhoneEqualTo(userLogin.getUserId()).andPasswordEqualTo(userLogin.getUserPassword());
        }
        List<Student> studentList=studentMapper.selectByExample(studentExample);
        if(studentList.isEmpty()==true){
            return ResultTool.error("用户名或密码错误");
        }
        tokenResponse.setIdentity("2");
        tokenResponse.setToken(JwtUtil.createJwt(studentList.get(0).getId().toString()));
        tokenResponse.setUserName(studentList.get(0).getName());
        tokenResponse.setUserId(studentList.get(0).getId().toString());
        int state=studentList.get(0).getApplyState();
        if(state==0||state==1){
            tokenResponse.setCurrent("1");
        }else
        {
            tokenResponse.setCurrent(state+"");
        }
        return ResultTool.success(tokenResponse);
    }

//    @Value("${mail.fromMail.addr}")
//    private String from;



    /**
    * @Description: 发送邮箱验证码
    * @Param: [mail, identity] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result sendMail(String mail, String identity) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(checkMail(mail,identity)==true){
            String phoneNumber = mail;
            String randomNum = getMsgCode();// 生成随机数
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE, 1);
            String currentTime = sf.format(c.getTime());// 生成1分钟后时间，用户校验是否过期
            String [] users=new String[1];
            users[0]=mail;
            EmailUtils.sendEmail("觊翼留学--账户验证",users,null,"【觊翼留学】您的验证码："+randomNum+"，您正在进行身份验证，打死不告诉别！",null);
            String hash =  MD5Utils.encodeByMd5((KEY + "#"  + randomNum+"#"+mail));//生成MD5值
            CheckCode checkCode=new CheckCode();
            checkCode.setCode(hash);
            checkCode.setTime(currentTime);
            return ResultTool.success(checkCode); //将hash值和tamp时间返回给前端

        }
        return ResultTool.error("用户不存在");
    }


    /**
    * @Description: 检查用户邮箱是否存在
    * @Param: [mail, identity]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkMail(String mail,String identity){
        int ide=Integer.parseInt(identity);
        switch (ide){
//            case 0:checkSuperMail(mail);break;
            case 1:return checkTeacherMail(mail);
            case 2:return checkStudentMail(mail);
        }
        return false;
    }


    /**
    * @Description: 检查老师的邮箱
    * @Param: [mail]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkTeacherMail(String mail){
        System.out.println(mail);
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.createCriteria().andMailEqualTo(mail);
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(teacherList.isEmpty()==true){
            return false;
        }
        return true;
    }


    /**
    * @Description: 检查学生的邮箱
    * @Param: [mail]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkStudentMail(String mail){
        TeacherExample teacherExample=new TeacherExample();
        teacherExample.createCriteria().andMailEqualTo(mail);
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        if(teacherList.isEmpty()==true){
            return false;
        }
        return true;
    }


}
