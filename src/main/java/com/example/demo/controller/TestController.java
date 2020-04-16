package com.example.demo.controller;

import com.example.demo.model.entity.Student;
import com.example.demo.model.overview.Result;
import com.example.demo.service.ManagerService;
import com.example.demo.service.TeacherService;
import com.example.demo.tool.FileTool;
import com.example.demo.tool.JwtUtil;
import com.example.demo.tool.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @description: 测试服务器上是否可以通过运行
 * @author: tyq
 * @create:
 **/
@CrossOrigin
@RestController
@Slf4j
public class
TestController {

    @Resource
    ManagerService managerService;

    @GetMapping("/hello")
    public String testing(){
        return "吴老师最美丽";
    }


    @GetMapping("/downloadFile")
    public void fileDownload(@RequestParam("url")String url,@RequestParam("fileName")String fileName, HttpServletResponse httpServletResponse){
        System.out.println(fileName+url);
        FileTool.downloadFile(httpServletResponse,fileName,url);
    }

    @GetMapping("/downloadZipFile")
    public void zipFileDownload(@RequestParam("url")String url,
                                @RequestParam("fileName")String fileName,
                                @RequestParam("userId") String userId,
                                @RequestParam("studentId") String studentId,
                                HttpServletResponse httpServletResponse){
        log.info("fileName");
        managerService.downLoadZipFile(fileName,url,userId,studentId,httpServletResponse);

    }


}
