package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TaskMapper;
import com.example.demo.dao.TeacherStudentMapper;
import com.example.demo.model.entity.*;
import com.example.demo.model.file.FileResponse;
import com.example.demo.model.homework.*;
import com.example.demo.model.overview.Result;
import com.example.demo.service.HomeworkService;
import com.example.demo.tool.FileTool;
import com.example.demo.tool.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 作业service层
 * @author: tyq
 * @create:
 **/
@Service
@Slf4j
public class HomeworkServiceImpl implements HomeworkService {

    @Resource
    TeacherStudentMapper teacherStudentMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    TaskMapper taskMapper;

    //TODO 部署到服务器后修改路径
    private String pathValue = "/var/lib/jiyiedu/";

//    private String pathValue="/Users/tangyuqi/Downloads/jiyiedu/";


    /** 
    * @Description: 教师内部系统创建作业接口 #63 
    * @Param: [teacherId, studentId, name, deadline, file] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result createHomework(String studentId, String name, String deadline, MultipartFile file) {
//        根据Id查找学生姓名，便于构造文件名
        Student student1=studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if(student1==null){
            return ResultTool.error("该学生不存在");
        }
//        新建文件
        String originName=file.getOriginalFilename();
        String newPath=pathValue+student1.getId()+"_"+student1.getName()+"/Homework/teacher/"+originName;
        FileTool.uploadFile(newPath,file);
//        相关记录存入数据库
        TaskWithBLOBs record=new TaskWithBLOBs();
        record.setState(0);
        record.setTeacherStuId(Integer.parseInt(studentId));
        record.setContent(name);
        record.setTeacherFilePath(newPath);
        Timestamp ts=StringToTimeStamp(deadline);
        if(ts==null){
            return ResultTool.error("dealline时间格式出错");
        }
        record.setDdl(ts);
        taskMapper.insert(record);
        HomeworkIdResponse homeworkIdResponse=new HomeworkIdResponse();
        homeworkIdResponse.setId(record.getId().toString());
        return ResultTool.success(homeworkIdResponse);
    }
    
    /** 
    * @Description: string转时间戳 
    * @Param: [time] 
    * @return: java.sql.Timestamp 
    * @Author: tyq 
    * @Date:
     *
    */ 
    private Timestamp StringToTimeStamp(String tsStr){
        Timestamp ts;
        try {
            ts = Timestamp.valueOf(tsStr);
        } catch (Exception e) {
            return null;
        }
        return ts;
    }

    /**
    * @Description: 删除作业
    * @Param: [taskId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result deleteHomework(String taskId) {
//        检查作业是否存在
        TaskWithBLOBs taskWithBLOBs = taskMapper.selectByPrimaryKey(Integer.parseInt(taskId));
        if(taskWithBLOBs==null){
            return ResultTool.error("不存在该作业");
        }
//        根据路径删除文件
        String filePath=taskWithBLOBs.getTeacherFilePath();
        if(FileTool.deleteFile(filePath)==false){
            return ResultTool.error("删除失败");
        }else {
            taskMapper.deleteByPrimaryKey(Integer.parseInt(taskId));
        }
        return ResultTool.success();

    }
    

    /** 
    * @Description: 内部系统学生获取历史作业接口 #43
    * @Param: [userId, teacherId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getHistoryList(String userId) {

//        获取当前时间戳
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        TaskExample taskExample=new TaskExample();
        taskExample.createCriteria().andTeacherStuIdEqualTo(Integer.parseInt(userId)).andDdlLessThan(ts);
        List<TaskWithBLOBs> taskList=taskMapper.selectByExampleWithBLOBs(taskExample);
//        if(taskList.isEmpty()==true){
//            return ResultTool.error("不存在历史作业");
//        }
        List<HomeworkIdName> homeworkIdNameList=new LinkedList<>();
        for(TaskWithBLOBs item:taskList){
            HomeworkIdName info=new HomeworkIdName();
            info.setId(item.getId().toString());
            info.setName(item.getContent());
            homeworkIdNameList.add(info);
        }

        HomeworkResponse homeworkResponse=new HomeworkResponse();
        homeworkResponse.setHistoryList(homeworkIdNameList);
        return ResultTool.success(homeworkResponse);
    }


    /** 
    * @Description: 内部系统学生获取当前作业接口 #44
    * @Param: [userId, teacherId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getCurrentList(String userId) {

//        获取当前时间戳
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        TaskExample taskExample=new TaskExample();
        taskExample.createCriteria().andTeacherStuIdEqualTo(Integer.parseInt(userId)).andDdlGreaterThan(ts);
        List<TaskWithBLOBs> taskList=taskMapper.selectByExampleWithBLOBs(taskExample);
//        if(taskList.isEmpty()==true){
//            return ResultTool.error("不存在历史作业");
//        }
        List<CurrentHomework> homeworkIdNameList=new LinkedList<>();
        for(TaskWithBLOBs item:taskList){
            CurrentHomework info=new CurrentHomework();
            info.setId(item.getId().toString());
            info.setName(item.getContent());
            info.setDeadline(item.getDdl().toString());
            homeworkIdNameList.add(info);
        }

        CurrentHomeworkResponse homeworkResponse=new CurrentHomeworkResponse();
        homeworkResponse.setCurrentHomeworkResponseList(homeworkIdNameList);
        return ResultTool.success(homeworkResponse);
    }

    /** 
    * @Description: 内部系统学生获取作业要求接口 #47
    * @Param: [homeworkId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getDemand(String homeworkId) {
        TaskWithBLOBs taskWithBLOBs=taskMapper.selectByPrimaryKey(Integer.parseInt(homeworkId));
        if(taskWithBLOBs==null){
            return ResultTool.error("该作业不存在");
        }
        HomeDemand homeDemand=new HomeDemand();
        homeDemand.setHomeworkDemand(taskWithBLOBs.getContent());
        return ResultTool.success(homeDemand);
    }

    /**
    * @Description: 内部系统学生提交作业内容接口 #45
    * @Param: [homeworkId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result putHomework(String homeworkId,MultipartFile file,String userId) {
//        查找该作业是否存在
        TaskWithBLOBs taskWithBLOBs=taskMapper.selectByPrimaryKey(Integer.parseInt(homeworkId));
        if(taskWithBLOBs==null){
            return ResultTool.error("该作业不存在");
        }
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        if(ts.after(taskWithBLOBs.getDdl())){
            return ResultTool.error("作业已截止");
        }
        if(userId.equals(taskWithBLOBs.getTeacherStuId().toString())==false){
            return ResultTool.error("不是该学生的作业");
        }

//        获得studentId
        Student student=studentMapper.selectByPrimaryKey(taskWithBLOBs.getTeacherStuId());
//        作业路径
        String originName=file.getOriginalFilename();
        String newPath=pathValue+student.getId()+"_"+student.getName()+"/Homework/Student/"+originName;
        FileTool.uploadFile(newPath,file);
//        更新数据
        TaskWithBLOBs record=new TaskWithBLOBs();
        record.setId(taskWithBLOBs.getId());
        record.setStuFilePath(newPath);
        record.setState(1);
        taskMapper.updateByPrimaryKeySelective(record);
        return ResultTool.success();
    }

    /**
    * @Description: 内部系统学生下载作业内容接口 #46
    * @Param: [homeworkId, userId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result getHomeworkFile(String homeworkId,String teacherId, String userId, HttpServletResponse httpServletResponse) {
        //        查找该作业是否存在
        TaskWithBLOBs taskWithBLOBs=taskMapper.selectByPrimaryKey(Integer.parseInt(homeworkId));
        if(taskWithBLOBs==null){
            return ResultTool.error("该作业不存在");
        }
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        if(ts.after(taskWithBLOBs.getDdl())&&teacherId.equals("")==true){
            return ResultTool.error("作业已截止");
        }
        if(userId.equals(taskWithBLOBs.getTeacherStuId().toString())==false){
            return ResultTool.error("不是该学生的作业");
        }
//        下载作业
        String filePath=taskWithBLOBs.getTeacherFilePath();
        if(filePath==null){
            return ResultTool.error("没有上传文件");
        }
        String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
        FileResponse fileResponse=new FileResponse();
        fileResponse.setUrl(filePath);
        fileResponse.setFileName(fileName);
        return ResultTool.success(fileResponse);

    }

    /**
    * @Description: 内部系统学生下载已提交作业接口 #57
    * @Param: [homeworkId, userId, httpServletResponse]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result getHomeworkStudentFile(String homeworkId, String userId, HttpServletResponse httpServletResponse) {
        //        查找该作业是否存在
        TaskWithBLOBs taskWithBLOBs=taskMapper.selectByPrimaryKey(Integer.parseInt(homeworkId));
        if(taskWithBLOBs==null){
            return ResultTool.error("该作业不存在");
        }
        if(userId.equals(taskWithBLOBs.getTeacherStuId().toString())==false){
            return ResultTool.error("不是该学生的作业");
        }
//        下载作业
        String filePath=taskWithBLOBs.getStuFilePath();
        if(filePath==null){
            return ResultTool.error("没有上传文件");
        }
        String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
        FileResponse fileResponse=new FileResponse();
        fileResponse.setFileName(fileName);
        fileResponse.setUrl(filePath);
        return ResultTool.success(fileResponse);
    }
}
