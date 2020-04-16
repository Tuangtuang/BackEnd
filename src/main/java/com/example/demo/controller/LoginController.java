package com.example.demo.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.model.login.CheckCodeBack;
import com.example.demo.model.login.UserLogin;
import com.example.demo.model.overview.Result;
import com.example.demo.service.LoginService;
import com.example.demo.tool.ResultTool;
import com.example.demo.tool.TextCheck;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 登陆接口
 * @author: tyq
 * @create:
 **/
@RestController
@CrossOrigin
public class LoginController {

    @Resource
    private LoginService loginService;

    // 发送验证码
    @GetMapping(value = "/inside/login/forgetPassword/message")
    public Result checkMessageCode(@RequestParam("userId") String userId,@RequestParam("identity") String identity) throws ClientException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if(userId.contains("@")){
            return loginService.sendMail(userId,identity);//邮箱验证码
        }
        return loginService.SmsVerification(userId,identity);//短信验证码
    }
    // 接受短信验证码
    @RequestMapping(value = "/inside/login/forgetPassword/message/validateCheck",method = RequestMethod.POST)
    public Result checkValidCode(@RequestBody CheckCodeBack checkCodeBack)throws ClientException, NoSuchAlgorithmException, UnsupportedEncodingException {
        return loginService.validateNum(checkCodeBack);
    }

    // 用户登陆接口
    @RequestMapping(value = "/insider/login",method = RequestMethod.POST)
    public Result UserLogin(@RequestBody UserLogin userLogin){

        return loginService.UserLogin(userLogin);
    }

//    // 发送邮箱验证码接口
//    @GetMapping(value = "/inside/login/forgetPassword/messageMail/{email}/{identity}")
//    public Result checkMailCode(@PathVariable("email") String mail,@PathVariable("identity") String identity){
//        return loginService.sendMail(mail,identity);
//    }






}
