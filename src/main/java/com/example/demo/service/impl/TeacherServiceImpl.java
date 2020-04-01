package com.example.demo.service.impl;

import com.example.demo.dao.TeacherMapper;
import com.example.demo.dao.TeacherStudentMapper;
import com.example.demo.model.databaseResponse.MyStudentInfo;
import com.example.demo.model.databaseResponse.SearchStudentByTeacher;
import com.example.demo.model.document.StudentInfo;
import com.example.demo.model.entity.Teacher;
import com.example.demo.model.entity.TeacherStudent;
import com.example.demo.model.entity.TeacherStudentExample;
import com.example.demo.model.overview.Result;
import com.example.demo.model.teacher.StudentInfoItem;
import com.example.demo.model.teacher.StudentInfoResponse;
import com.example.demo.model.teacher.StudentSearchReponseList;
import com.example.demo.model.teacher.StudentSearchResponse;
import com.example.demo.service.TeacherService;
import com.example.demo.tool.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: tyq
 * @create:
 **/
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherStudentMapper teacherStudentMapper;

    @Resource
    TeacherMapper teacherMapper;


    @Override
    public Result getStudentInfo(String teacherId) {
        List<MyStudentInfo> myStudentInfoList=teacherStudentMapper.getStudentList(Integer.parseInt(teacherId));
        if(myStudentInfoList.isEmpty()==true){
            return ResultTool.error("您没有学生");
        }
        List<StudentInfoItem> studentInfoItemList=new LinkedList<>();
        for(MyStudentInfo item:myStudentInfoList){
            StudentInfoItem info=new StudentInfoItem();
            info.setId(item.getId().toString());
            info.setGrade(item.getGrade());
            info.setName(item.getName());
            info.setSchool(item.getSchool());
            studentInfoItemList.add(info);
        }
        StudentInfoResponse studentInfoResponse=new StudentInfoResponse();
        studentInfoResponse.setStudentInfoItemList(studentInfoItemList);
        return ResultTool.success(studentInfoResponse);

    }


    /**
    * @Description: 教师条件搜索学生接口 #92
    * @Param: [studentId, studentName]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result searchStudent(String studentId, String studentName,String teacherId) {
        int teaId = Integer.parseInt(teacherId);
        if(!studentId.equals("")){
            int stuId = Integer.parseInt(studentId);
//            根据id查找
            SearchStudentByTeacher searchStudentByTeacher = teacherStudentMapper.teacherSearchStudentById(stuId,teaId);
            if(searchStudentByTeacher==null){
                return ResultTool.error("该同学不是您的学生");
            }
//            最多只有一条记录
//            查看id姓名是否匹配
            if(!searchStudentByTeacher.getStudentName().equals(studentName)&&!studentName.equals("")){
                return ResultTool.error("id和姓名不匹配");
            }
            StudentSearchResponse studentSearchResponse=new StudentSearchResponse();
            studentSearchResponse.setId(searchStudentByTeacher.getStudentId().toString());
            studentSearchResponse.setName(searchStudentByTeacher.getStudentName());
            studentSearchResponse.setGrade(searchStudentByTeacher.getGrade());
            studentSearchResponse.setSchool(searchStudentByTeacher.getSchool());
            List<StudentSearchResponse> searchStudentByTeacherList=new LinkedList<>();
            searchStudentByTeacherList.add(studentSearchResponse);
            StudentSearchReponseList studentSearchReponseList=new StudentSearchReponseList();
            studentSearchReponseList.setStudentList(searchStudentByTeacherList);
            return ResultTool.success(studentSearchReponseList);
        }else {
            if (!studentName.equals("")) {
                //            根据姓名查询
                List<SearchStudentByTeacher> dbResut = teacherStudentMapper.teacherSearchByName(studentName, teaId);
                if (dbResut.isEmpty() == true) {
                    return ResultTool.error("该同学不是您的学生");
                }
                List<StudentSearchResponse> responseList = new LinkedList<>();
                for (SearchStudentByTeacher item : dbResut) {
                    StudentSearchResponse info = new StudentSearchResponse();
                    info.setId(item.getStudentId().toString());
                    info.setName(item.getStudentName());
                    info.setGrade(item.getGrade());
                    info.setSchool(item.getSchool());
                    responseList.add(info);
                }
                StudentSearchReponseList studentSearchReponseList = new StudentSearchReponseList();
                studentSearchReponseList.setStudentList(responseList);
                return ResultTool.success(studentSearchReponseList);
            }else {
//                返回所有关联学生
                List<SearchStudentByTeacher> databaseResult=teacherStudentMapper.getAllByTeacher(teaId);
                if(databaseResult.isEmpty()){
                    return ResultTool.error("您没有学生");
                }
                List<StudentSearchResponse> responseList=new LinkedList<>();
                for(SearchStudentByTeacher item:databaseResult){
                    StudentSearchResponse info = new StudentSearchResponse();
                    info.setId(item.getStudentId().toString());
                    info.setName(item.getStudentName());
                    info.setGrade(item.getGrade());
                    info.setSchool(item.getSchool());
                    responseList.add(info);
                }
                StudentSearchReponseList studentSearchReponseList = new StudentSearchReponseList();
                studentSearchReponseList.setStudentList(responseList);
                return ResultTool.success(studentSearchReponseList);

            }
        }

    }
}
