package com.example.demo.service.impl;

import com.example.demo.dao.*;
import com.example.demo.model.basicInfo.GetBasicInfo;
import com.example.demo.model.databaseResponse.TeacherStudentName;
import com.example.demo.model.databaseResponse.TeacherStudentNameInfo;
import com.example.demo.model.databaseResponse.TeacherStudentTeacherName;
import com.example.demo.model.databaseResponse.TeacherStudentTeacherNameInfo;
import com.example.demo.model.entity.*;
import com.example.demo.model.file.FileResponse;
import com.example.demo.model.manager.*;
import com.example.demo.model.overview.Result;
import com.example.demo.model.teacher.StudentInfoItem;
import com.example.demo.service.ManagerService;
import com.example.demo.tool.FileTool;
import com.example.demo.tool.ResultTool;
import com.example.demo.tool.ZipUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.management.relation.Relation;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 管理员模块service层
 * @author: tyq
 * @create: 2019-06-19 11:05
 **/
@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private SuperManagerMapper superManagerMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private TeacherStudentMapper teacherStudentMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private CvCommunicationMapper cvCommunicationMapper;

    @Resource
    private CvMapper cvMapper;

    @Resource
    private GmatMapper gmatMapper;

    @Resource
    private GreMapper greMapper;


    @Resource
    private ieltsMapper ieltsMapper;


    @Resource
    private LsatMapper lsatMapper;


    @Resource
    private OtherCommunicationMapper otherCommunicationMapper;

    @Resource
    private OtherInfoMapper otherInfoMapper;


    @Resource
    private OtherTestMapper otherTestMapper;


    @Resource
    private PsCommunicationMapper psCommunicationMapper;

    @Resource
    private RecommendationMapper recommendationMapper;

    @Resource
    private RecommendationCommunicationMapper recommendationCommunicationMapper;


    @Resource
    private RecommenderMapper recommenderMapper;

    @Resource
    private Sat1Mapper sat1Mapper;


    @Resource
    private StuSchoolMapper stuSchoolMapper;


    @Resource
    private StuSchoolOtherMapper stuSchoolOtherMapper;


    @Resource
    private StuSchoolPsMapper stuSchoolPsMapper;

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private ToeflMapper toeflMapper;


    private String pathAddress = "/var/lib/jiyiedu/";


    private boolean checkManager(String userId) {
        int id = Integer.parseInt(userId);
        SuperManager superManager = superManagerMapper.selectByPrimaryKey(id);
        if (superManager == null) {
            return false;
        }
        return true;
    }

    @Override
    public Result getStudentList(String managerId, String studentId, String studentName) {
//        检查管理员身份
        if (checkManager(managerId) == false) {
            return ResultTool.error("您不是管理员");
        }
        int userId = Integer.parseInt(managerId);

        StudentExample studentExample = new StudentExample();


//        ID和姓名都为空时获取所有学生
        if (studentId.equals("") && studentName.equals("")) {
            studentExample.createCriteria().andIdIsNotNull().andCoinsNotEqualTo(Integer.parseInt(managerId));//屏蔽掉删除的学生
            studentExample.setOrderByClause("id asc");
            List<Student> studentList = studentMapper.selectByExample(studentExample);
            if (studentList.isEmpty()) {
                return ResultTool.error("系统中没有学生");
            }
            List<ManageStudentInfoItem> studentInfoItemList = new LinkedList<>();
            for (Student item : studentList) {
                ManageStudentInfoItem info = new ManageStudentInfoItem();
                info.setStudentId(item.getId().toString());
                info.setStudentName(item.getName());
                studentInfoItemList.add(info);
            }
            StudentList studentList1 = new StudentList();
            studentList1.setStudentList(studentInfoItemList);
            return ResultTool.success(studentList1);
        }
//        按照姓名查询
        if (studentId.equals("") && !studentName.equals("")) {
            studentExample.createCriteria().andNameEqualTo(studentName).andCoinsNotEqualTo(Integer.parseInt(managerId));
            studentExample.setOrderByClause("id asc");
            List<Student> studentList = studentMapper.selectByExample(studentExample);
            if (studentList.isEmpty() == true) {
                return ResultTool.error("查无此人");
            }
            List<ManageStudentInfoItem> manageStudentInfoItemList = new LinkedList<>();
            for (Student item : studentList) {
                ManageStudentInfoItem info = new ManageStudentInfoItem();
                info.setStudentId(item.getId().toString());
                info.setStudentName(item.getName());
                manageStudentInfoItemList.add(info);
            }
            StudentList studentList1 = new StudentList();
            studentList1.setStudentList(manageStudentInfoItemList);
            return ResultTool.success(studentList1);
        }

//        按照id查询
        if (!studentId.equals("")) {
            Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
            if (student == null || student.getCoins().intValue() == userId) {
                return ResultTool.error("查无此人");
            }
            if (!studentName.equals("") && !studentName.equals(student.getName())) {
                return ResultTool.error("姓名和id不匹配");
            }
            ManageStudentInfoItem info = new ManageStudentInfoItem();
            info.setStudentId(student.getId().toString());
            info.setStudentName(student.getName());
            List<ManageStudentInfoItem> manageStudentInfoItemList = new LinkedList<>();
            manageStudentInfoItemList.add(info);
            StudentList studentList = new StudentList();
            studentList.setStudentList(manageStudentInfoItemList);
            return ResultTool.success(studentList);
        }
        return ResultTool.error("查询出错");
    }

    /**
     * @Description: 管理员获取学生基本信息接口 #78
     * @Param: [managerId, studentId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-20
     */
    @Override
    public Result getStudentBasicInfo(String managerId, String studentId) {
//        检查管理员身份
        if (checkManager(managerId) == false) {
            return ResultTool.error("您不是管理员");
        }
//
//        获取学生信息
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if (student == null) {
            return ResultTool.error("学生信息不存在");
        }
        GetBasicInfo getBasicInfo = new GetBasicInfo();
        getBasicInfo.setUserPhone(student.getPhone());
        getBasicInfo.setUserPassword(student.getPassword());
        getBasicInfo.setUserEmail(student.getMail());
        getBasicInfo.setUserGrade(student.getGrade());
        getBasicInfo.setUserSchool(student.getSchool());
        getBasicInfo.setUserGpa(student.getGpa());
        getBasicInfo.setUserMajor(student.getMajor());
//        getBasicInfo.se
        return ResultTool.success(getBasicInfo);

    }

    /**
     * @Description: 管理员修改学生基本信息接口 #79
     * @Param: [modifyStudentBasicInfo]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-20
     */
    @Override
    public Result modifyStudentInfoManager(ModifyStudentBasicInfo modifyStudentBasicInfo) {
//        检查管理员id
        if (checkManager(modifyStudentBasicInfo.getUserId()) == false) {
            return ResultTool.error("您不是管理员");
        }
//        检查学生是否存在
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(modifyStudentBasicInfo.getStudentId()));
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
        String tmp;
        if (!(tmp = modifyStudentBasicInfo.getUserPhone()).equals("")) {
            student.setPhone(tmp);
        }
        if (!(tmp = modifyStudentBasicInfo.getUserEmail()).equals("")) {
            student.setMail(tmp);
        }
        if (!(tmp = modifyStudentBasicInfo.getUserPassword()).equals("")) {
            student.setPassword(tmp);
        }
        if (!(tmp = modifyStudentBasicInfo.getUserGrade()).equals("")) {
            student.setGrade(tmp);
        }
        if (!(modifyStudentBasicInfo.getUserGpa()).equals("")) {
            student.setGpa(tmp);
        }
        if (!(tmp = modifyStudentBasicInfo.getUserMajor()).equals("")) {
            student.setMajor(tmp);
        }
        if (!(tmp = modifyStudentBasicInfo.getUserSchool()).equals("")) {
            student.setSchool(tmp);
        }
        if (!(tmp = modifyStudentBasicInfo.getUserName()).equals("")) {
            student.setName(tmp);
        }
        studentMapper.updateByPrimaryKeySelective(student);
        return ResultTool.success();
    }

    /**
     * @Description: 管理员创建学生接口 #80
     * @Param: [addStudentInfo]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-20
     */
    @Override
    public Result createStudent(AddStudentInfo addStudentInfo) {
//        检查管理员
        if (checkManager(addStudentInfo.getUserId()) == false) {
            return ResultTool.error("您不是管理员");
        }
//        检查学生的邮箱是否存在
        StudentExample mailChecking = new StudentExample();
        mailChecking.createCriteria().andMailEqualTo(addStudentInfo.getUserEmail());
        List<Student> checkEmail = studentMapper.selectByExample(mailChecking);
        if (checkEmail.isEmpty() == false) {
            return ResultTool.error("该邮箱已存在");
        }
//        检查学生的手机号是否存在
        StudentExample phoneChecking = new StudentExample();
        phoneChecking.createCriteria().andPhoneEqualTo(addStudentInfo.getUserPhone());
        List<Student> checkPhone = studentMapper.selectByExample(phoneChecking);
        if (checkPhone.isEmpty() == false) {
            return ResultTool.error("该手机号已存在");
        }
//        添加学生信息
        Student student = new Student();
        student.setName(addStudentInfo.getStudentName());
        student.setApplyState(0);
        student.setPassword(addStudentInfo.getUserPassword());
        student.setCoins(0);
        student.setMail(addStudentInfo.getUserEmail());
        student.setPhone(addStudentInfo.getUserPhone());
        studentMapper.insert(student);
//        创建目录
        FileTool.createFolder(pathAddress, student.getId().toString() + "_" + student.getName());
//        添加管理员学生关联
        try {
            TeacherStudent teacherStudent1 = new TeacherStudent();
            teacherStudent1.setTeacherId(1);
            teacherStudent1.setStuId(student.getId());
            teacherStudent1.setState(1);
            teacherStudentMapper.insert(teacherStudent1);

            TeacherStudent teacherStudent2 = new TeacherStudent();
            teacherStudent2.setTeacherId(2);
            teacherStudent2.setStuId(student.getId());
            teacherStudent2.setState(1);
            teacherStudentMapper.insert(teacherStudent2);
        } catch (Exception e) {
            return ResultTool.error("添加管理员学生联系失败");
        }

        IdResponse idResponse=new IdResponse();
        idResponse.setId(student.getId().toString());



        return ResultTool.success(idResponse);

    }

    /**
     * @Description: 管理员创建教师接口 #81
     * @Param: [addTeacherInfo]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-20
     */
    @Override
    public Result createTeacher(AddTeacherInfo addTeacherInfo) {
//        检查管理员
        if (checkManager(addTeacherInfo.getUserId()) == false) {
            return ResultTool.error("您不是管理员");
        }
//        检查邮箱是否存在
        TeacherExample emailChecking = new TeacherExample();
        emailChecking.createCriteria().andMailEqualTo(addTeacherInfo.getUserEmail());
        List<Teacher> checkMailList = teacherMapper.selectByExample(emailChecking);
        if (checkMailList.isEmpty() == false) {
            return ResultTool.error("该邮箱已经存在");
        }

//        检查手机号是否存在
        TeacherExample phoneChecking = new TeacherExample();
        phoneChecking.createCriteria().andPhoneEqualTo(addTeacherInfo.getUserPhone());
        List<Teacher> checkPhoneList = teacherMapper.selectByExample(phoneChecking);
        if (checkPhoneList.isEmpty() == false) {
            return ResultTool.error("该手机号已经存在");
        }
//        添加教师信息
        Teacher teacher = new Teacher();
        teacher.setName(addTeacherInfo.getTeacherName());
        teacher.setPassword(addTeacherInfo.getUserPassword());
        teacher.setMail(addTeacherInfo.getUserEmail());
        teacher.setPhone(addTeacherInfo.getUserPhone());
        teacher.setType("1");
        teacherMapper.insert(teacher);
        IdResponse idResponse=new IdResponse();
        idResponse.setId(teacher.getId().toString());
        return ResultTool.success(idResponse);
    }


    /**
     * @Description: 管理员搜索教师接口 #82
     * @Param: [managerId, studentId, studentName]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-21
     */
    @Override
    public Result getTeacherList(String managerId, String teacherId, String teacherName) {
//        检查管理员身份
        if (checkManager(managerId) == false) {
            return ResultTool.error("您不是管理员");
        }
        TeacherExample teacherExample = new TeacherExample();
        if (teacherId.equals("")) {
            if (teacherName.equals("")) {
                teacherExample.createCriteria().andIdIsNotNull();
            } else {
                teacherExample.createCriteria().andNameEqualTo(teacherName);
            }
            teacherExample.setOrderByClause("id asc");
            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
            if (teacherList.isEmpty() == true) {
                return ResultTool.error("教师列表为空");
            }
            List<ManageStudentInfoItem> manageStudentInfoItemList = new LinkedList<>();
            for (Teacher item : teacherList) {
                ManageStudentInfoItem info = new ManageStudentInfoItem();
                info.setStudentId(item.getId().toString());
                info.setStudentName(item.getName());
                manageStudentInfoItemList.add(info);
            }
            TeacherList teacherList1 = new TeacherList();
            teacherList1.setTeacherList(manageStudentInfoItemList);
            return ResultTool.success(teacherList1);
        } else {
//            按照id搜索
            Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(teacherId));
            if (teacher == null) {
                return ResultTool.error("教师列表为空");
            }
            if (teacher.getName().equals(teacherName) == false && teacherName.equals("") == false) {
                return ResultTool.error("id和姓名不匹配");
            }
            List<ManageStudentInfoItem> manageStudentInfoItemList = new LinkedList<>();
            ManageStudentInfoItem info = new ManageStudentInfoItem();
            info.setStudentName(teacher.getName());
            info.setStudentId(teacher.getId().toString());
            manageStudentInfoItemList.add(info);
            TeacherList teacherList = new TeacherList();
            teacherList.setTeacherList(manageStudentInfoItemList);
            return ResultTool.success(teacherList);
        }

    }

    /**
     * @Description: 管理员删除教师接口 #83
     * @Param: [deleteTeacher]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-21
     */
    @Override
    public Result deleteTeacher(DeleteTeacher deleteTeacher) {
        if (checkManager(deleteTeacher.getUserId()) == false) {
            return ResultTool.error("您不是管理员");
        }
//        检查教师是否存在
        Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(deleteTeacher.getTeacherId()));
        if (teacher == null) {
            return ResultTool.error("教师不存在");
        }
//        先删除师生关系表中的记录
        try {
            TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
            teacherStudentExample.createCriteria().andTeacherIdEqualTo(Integer.parseInt(deleteTeacher.getTeacherId()));
            teacherStudentMapper.deleteByExample(teacherStudentExample);
        } catch (Exception e) {
            return ResultTool.error("删除师生关系表失败");
        }
        try {
            teacherMapper.deleteByPrimaryKey(Integer.parseInt(deleteTeacher.getTeacherId()));
        } catch (Exception e) {
            return ResultTool.error("删除教师表失败");
        }
        return ResultTool.success();
    }

    /**
     * @Description: 管理员获取教师基本信息接口 #84
     * @Param: [managerId, teacherId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-21
     */
    @Override
    public Result getTeacherBasicInfo(String managerId, String teacherId) {
        if (checkManager(managerId) == false) {
            return ResultTool.error("您不是管理员");
        }
        Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(teacherId));
        if (teacher == null) {
            return ResultTool.error("老师不存在");
        }
        TeacherInfoResponse teacherInfoResponse = new TeacherInfoResponse();
        teacherInfoResponse.setUserEmail(teacher.getMail());
        teacherInfoResponse.setUserPassword(teacher.getPassword());
        teacherInfoResponse.setUserPhone(teacher.getPhone());
        return ResultTool.success(teacherInfoResponse);
    }

    /**
     * @Description: 管理员修改教师基本信息接口 #85
     * @Param: [modifyStudentBasicInfo]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-21
     */
    @Override
    public Result modifyTeacherInfoManager(ModifyTeacherBasicInfo modifyTeacherBasicInfo) {
//        检查管理员身份
        if (checkManager(modifyTeacherBasicInfo.getUserId()) == false) {
            return ResultTool.error("您不是管理员");
        }
//        检查教师是否存在
        Teacher teacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(modifyTeacherBasicInfo.getTeacherId()));
        if (teacher == null) {
            return ResultTool.error("教师不存在");
        }

//        修改教师信息
        String tmp;
        if (!(tmp = modifyTeacherBasicInfo.getUserEmail()).equals("")) {
            teacher.setMail(tmp);
        }

        if (!(tmp = modifyTeacherBasicInfo.getUserName()).equals("")) {
            teacher.setName(tmp);
        }

        if (!(tmp = modifyTeacherBasicInfo.getUserPassword()).equals("")) {
            teacher.setPassword(tmp);
        }

        if (!(tmp = modifyTeacherBasicInfo.getUserPhone()).equals("")) {
            teacher.setPhone(tmp);
        }

        teacherMapper.updateByPrimaryKeySelective(teacher);
        return ResultTool.success();
    }


    /**
     * @Description: 管理员修改师生关联接口 #86
     * @Param: [teacherStudentRelation]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-23
     */
    @Override
    public Result updateTeacherStudentRelationship(TeacherStudentRelation teacherStudentRelation) {
//        检查管理员身份
        if (checkManager(teacherStudentRelation.getManagerId()) == false) {
            return ResultTool.error("您不是管理员");
        }
        int teacherId = Integer.parseInt(teacherStudentRelation.getTeacherId());
        int studentId = Integer.parseInt(teacherStudentRelation.getStudentId());
//        如果是关联
        if (teacherStudentRelation.getStatus().equals("关联")) {
            if (checkTeacherStudentRelationship(teacherId, studentId) == false) {
//                检查教师是否存在
                Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
                if (teacher == null) {
                    return ResultTool.error("教师不存在");
                }
//                检查学生是否存在
                Student student = studentMapper.selectByPrimaryKey(studentId);
                if (student == null) {
                    return ResultTool.error("学生不存在");
                }

//                师生关系不存在，插入新的师生关系
                TeacherStudent record = new TeacherStudent();
                record.setStuId(studentId);
                record.setTeacherId(teacherId);
                record.setState(0);
                teacherStudentMapper.insert(record);
                return ResultTool.success();
            } else {
                return ResultTool.success();
            }
        } else if (teacherStudentRelation.getStatus().equals("取消关联")) {
//            检查师生关系是否存在
            if (checkTeacherStudentRelationship(teacherId, studentId) == false) {
                return ResultTool.error("师生关系不存在");
            } else {
//                师生关系存砸，删除记录
                try {
                    TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
                    teacherStudentExample.createCriteria().andStuIdEqualTo(studentId).andTeacherIdEqualTo(teacherId);
                    teacherStudentMapper.deleteByExample(teacherStudentExample);
                } catch (Exception e) {
                    return ResultTool.error("删除异常");
                }
                return ResultTool.success();
            }
        } else {
            return ResultTool.error("状态不合法");
        }
    }

    /**
     * @Description: 检查师生关系是否存在
     * @Param: [teacherId, studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-23
     */
    boolean checkTeacherStudentRelationship(int teacherId, int studentId) {
        TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
        teacherStudentExample.createCriteria().andTeacherIdEqualTo(teacherId)
                .andStuIdEqualTo(studentId);
        List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectByExample(teacherStudentExample);
        if (teacherStudentList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Result getRelationshipFromTeacher(String userId, String teacherId, String studentId, String studentName) {
//        检查管理员身份
        if (checkManager(userId) == false) {
            return ResultTool.error("您不是管理员");
        }
        int teaId;
        try {
            teaId = Integer.parseInt(teacherId);
        } catch (Exception e) {
            return ResultTool.error("教师id不合法");
        }

        if (checkTeacher(teaId) == false) {
            return ResultTool.error("教师不存在");
        }

//        studengId不为空
        if (!studentId.equals("")) {
            int stuId = Integer.parseInt(studentId);
            if (checkStudent(stuId) == false) {
                return ResultTool.error("学生不存在");
            }
//           检查该id的学生是否存在
            Student isStudentExists = studentMapper.selectByPrimaryKey(stuId);
            if (isStudentExists == null) {
                return ResultTool.error("学生不存在");
            }
            if (!isStudentExists.getName().equals(studentName) && !studentName.equals("")) {
                return ResultTool.error("学生id和姓名不匹配");
            }
//            检查是否存在该师生关系
            TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
            teacherStudentExample.createCriteria().andTeacherIdEqualTo(teaId).andStuIdEqualTo(stuId).andStateEqualTo(0);
            List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectByExample(teacherStudentExample);
            SearchRelationshipResponse searchRelationshipResponse = new SearchRelationshipResponse();
            if (teacherStudentList.isEmpty() == true) {
                searchRelationshipResponse.setStatus("未关联");
            } else {
                searchRelationshipResponse.setStatus("已关联");
            }
            searchRelationshipResponse.setId(stuId + "");
            searchRelationshipResponse.setName(isStudentExists.getName());
            List<SearchRelationshipResponse> stuList = new LinkedList<>();
            stuList.add(searchRelationshipResponse);
            SearchRelationshipResponseStudentList searchRelationshipResponseStudentList = new SearchRelationshipResponseStudentList();
            searchRelationshipResponseStudentList.setStudentList(stuList);
            return ResultTool.success(searchRelationshipResponseStudentList);
        } else {
//            id为空，按照姓名查询
//            如果姓名为空，返回和当前教师建立联系的所有学生
            if (studentName.equals("")) {
                StudentExample studentExample = new StudentExample();
                studentExample.createCriteria().andIdIsNotNull();
                studentExample.setOrderByClause("id asc");
                List<Student> studentList = studentMapper.selectByExample(studentExample);
                if (studentList.isEmpty()) {
                    return ResultTool.error("学生不存在");
                }
                List<SearchRelationshipResponse> searchRelationshipResponseList = new LinkedList<>();
                List<TeacherStudentName> teacherStudentNameList = studentMapper.searchTeacherStudentRelationship2(teaId);
                for (TeacherStudentName item : teacherStudentNameList) {
                    SearchRelationshipResponse info = new SearchRelationshipResponse();
                    info.setId(item.getStuId().toString());
                    info.setName(item.getStudentName());
                    info.setStatus(item.getTag() == 0 ? "未关联" : "关联");
                    searchRelationshipResponseList.add(info);
                }

                SearchRelationshipResponseStudentList searchRelationshipResponseStudentList = new SearchRelationshipResponseStudentList();
                searchRelationshipResponseStudentList.setStudentList(searchRelationshipResponseList);
                return ResultTool.success(searchRelationshipResponseStudentList);

            } else {

                StudentExample studentExample = new StudentExample();
                studentExample.createCriteria().andNameEqualTo(studentName);
                studentExample.setOrderByClause("id asc");
                List<Student> studentList = studentMapper.selectByExample(studentExample);
                if (studentList.isEmpty()) {
                    return ResultTool.error("学生不存在");
                }
                List<SearchRelationshipResponse> searchRelationshipResponseList = new LinkedList<>();
                List<TeacherStudentName> teacherStudentNameList = studentMapper.searchTeacherStudentRelationship(teaId, studentName);
                for (TeacherStudentName item : teacherStudentNameList) {
                    SearchRelationshipResponse info = new SearchRelationshipResponse();
                    info.setId(item.getStuId().toString());
                    info.setName(item.getStudentName());
                    info.setStatus(item.getTag() == 0 ? "未关联" : "关联");
                    searchRelationshipResponseList.add(info);
                }

                SearchRelationshipResponseStudentList searchRelationshipResponseStudentList = new SearchRelationshipResponseStudentList();
                searchRelationshipResponseStudentList.setStudentList(searchRelationshipResponseList);
                return ResultTool.success(searchRelationshipResponseStudentList);

            }
        }
    }


    /**
     * @Description: 通过id检查教师是否存在
     * @Param: [teacherId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-24
     */
    private boolean checkTeacher(int teacherId) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
        if (teacher == null) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 通过id检查学生是否存在
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-24
     */
    private boolean checkStudent(int studentId) {
        Student student = studentMapper.selectByPrimaryKey(studentId);
        if (student == null) {
            return false;
        }
        return true;
    }


    /**
     * @Description: 管理员获取师生关系列表接口（学生） #89
     * @Param: [userId, studentId, teacherId, teacherName]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-24
     */
    @Override
    public Result getRelationshipFromStudent(String userId, String studentId, String teacherId, String teacherName) {
//    检查管理员身份
        if (checkManager(userId) == false) {
            return ResultTool.error("您不是管理员");
        }
//        检查学生是否存在
        System.out.println(studentId);
        int stuId = Integer.parseInt(studentId);
        if (checkStudent(stuId) == false) {
            return ResultTool.error("学生不存在");
        }
//        int teaId = Integer.parseInt(teacherId);
//        if(checkTeacher(teaId)==false){
//            return ResultTool.error("教师不存在");
//        }
        if (!teacherId.equals("")) {
//            根据教师id查询
            int teaId = Integer.parseInt(teacherId);
            if (checkTeacher(teaId) == false) {
                return ResultTool.error("教师不存在");
            }
            Teacher teacher = teacherMapper.selectByPrimaryKey(teaId);
            if (!teacher.getName().equals(teacherName) && !teacherName.equals("")) {
                return ResultTool.error("教师id和姓名不匹配");
            }
//            检查是否存在师生关系
            TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
            teacherStudentExample.createCriteria().andStuIdEqualTo(stuId).andTeacherIdEqualTo(teaId).andStateEqualTo(0);
            List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectByExample(teacherStudentExample);

            SearchRelationshipResponse searchRelationshipResponse = new SearchRelationshipResponse();
            searchRelationshipResponse.setId(teacherId);
            searchRelationshipResponse.setName(teacher.getName());
            if (teacherStudentList.isEmpty()) {
                searchRelationshipResponse.setStatus("未关联");
            } else {
                searchRelationshipResponse.setStatus("关联");
            }
            List<SearchRelationshipResponse> searchRelationshipResponseList = new LinkedList<>();
            searchRelationshipResponseList.add(searchRelationshipResponse);
            SearchRelationshipResponseTeacherList searchRelationshipResponseTeacherList = new SearchRelationshipResponseTeacherList();
            searchRelationshipResponseTeacherList.setTeacherList(searchRelationshipResponseList);
            return ResultTool.success(searchRelationshipResponseTeacherList);
        } else {
//            检查姓名是否为空
            if (teacherName.equals("")) {
                List<SearchRelationshipResponse> searchRelationshipResponseList = new LinkedList<>();
                List<TeacherStudentTeacherName> teacherStudentTeacherNameList = teacherMapper.getTSRelationship2(stuId);
                for (TeacherStudentTeacherName item : teacherStudentTeacherNameList) {
                    SearchRelationshipResponse info = new SearchRelationshipResponse();
                    info.setName(item.getTeacherName());
                    info.setId(item.getTeacherId().toString());
                    info.setStatus(item.getTag().intValue() == 0 ? "未关联" : "关联");
                    searchRelationshipResponseList.add(info);
                }
                SearchRelationshipResponseTeacherList searchRelationshipResponseTeacherList = new SearchRelationshipResponseTeacherList();
                searchRelationshipResponseTeacherList.setTeacherList(searchRelationshipResponseList);
                return ResultTool.success(searchRelationshipResponseTeacherList);
            } else {
                List<SearchRelationshipResponse> searchRelationshipResponseList = new LinkedList<>();
                List<TeacherStudentTeacherName> teacherStudentTeacherNameList = teacherMapper.getTSRelationship(teacherName, stuId);
                for (TeacherStudentTeacherName item : teacherStudentTeacherNameList) {
                    SearchRelationshipResponse info = new SearchRelationshipResponse();
                    info.setName(item.getTeacherName());
                    info.setId(item.getTeacherId().toString());
                    info.setStatus(item.getTag().intValue() == 0 ? "未关联" : "关联");
                    searchRelationshipResponseList.add(info);
                }
                SearchRelationshipResponseTeacherList searchRelationshipResponseTeacherList = new SearchRelationshipResponseTeacherList();
                searchRelationshipResponseTeacherList.setTeacherList(searchRelationshipResponseList);
                return ResultTool.success(searchRelationshipResponseTeacherList);
            }
        }
    }

    /**
     * @Description: 管理员获取学生步骤条进度接口 #91
     * @Param: [managerId, studentId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-25
     */
    @Override
    public Result getApplyState(String managerId, String studentId) {
        if (checkManager(managerId) == false) {
            return ResultTool.error("您不是管理员");
        }
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if (student == null) {
            return ResultTool.error("学生不存在");
        }

        ApplyStateResponse applyStateResponse = new ApplyStateResponse();
        applyStateResponse.setCurrent(student.getApplyState().toString());
        return ResultTool.success(applyStateResponse);

    }


    /**
     * @Description: 管理员删除学生接口 #76
     * @Param: [studentId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date: 2019-06-25
     */
    @Override
    public Result deleteStudent(String studentId, String managerId) {
//         检查管理员身份
        if (checkManager(managerId) == false) {
            return ResultTool.error("您不是管理员");
        }
        int stuId = Integer.parseInt(studentId);
//       检查是否是第一个管理员
        Student student = studentMapper.selectByPrimaryKey(stuId);
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
        if (student.getCoins().intValue() == 0 || student.getCoins().intValue() == -1) {
//            第一个管理员删除
//            1.文件夹打包
            String address = studentId + "_" + student.getName();
            String fileName = address + ".zip";
            String resultPath = ZipUtils.folder2zip(address, "", fileName);

//            3.开始删除各种表
//            3.1 删除考试账户
            if (deleteAccount(stuId) == false) {
                return ResultTool.error("考试账户删除异常");
            }
//            3.2 删除cv
            if (deleteCv(stuId) == false) {
                return ResultTool.error("CV删除异常");
            }
//            3.3 删除gamt
            if (deleteGmat(stuId) == false) {
                return ResultTool.error("GMAT删除异常");
            }
//            3.4 删除GRE
            if (deleteGre(stuId) == false) {
                return ResultTool.error("GRE删除异常");
            }
//            3.5 删除雅思成绩
            if (deleteIelts(stuId) == false) {
                return ResultTool.error("雅思删除异常");
            }
//            3.5 删除Lsat成绩
            if (deleteLsat(stuId) == false) {
                return ResultTool.error("lsat成绩删除异常");
            }
//            3.6 删除其他文书
            if (deleteOtherPaper(stuId) == false) {
                return ResultTool.error("删除其他文书异常");
            }
//            3.7 删除其他事项
            if (deleteOtherAction(stuId) == false) {
                return ResultTool.error("删除其他事项异常");
            }
//            3.8 删除其他考试
            if (deleteOtherTest(stuId) == false) {
                return ResultTool.error("删除其他考试异常");
            }
//            3.9 删除文书
            if (deletePs(stuId) == false) {
                return ResultTool.error("删除其他文书异常");
            }
//            3.10 删除推荐信
            if (deleteRecommendation(stuId) == false) {
                return ResultTool.error("删除推荐新信息异常");
            }
//            3.11 删除推荐人
            if (deleteRecommender(stuId) == false) {
                return ResultTool.error("删除推荐人信息异常");
            }
//            3.12 删除Sat1成绩
            if (deleteSat1(stuId) == false) {
                return ResultTool.error("删除Sat1信息异常");
            }
//            3.13 删除选生学校
            if (deleteStudentSchool(stuId) == false) {
                return ResultTool.error("删除学生选校信息异常");
            }
//            3.14 删除学生作业记录
            if (deleteTask(stuId) == false) {
                return ResultTool.error("删除作业信息异常");
            }
//            3.15 删除师生关系
            if (deleteTeacherStudent(stuId) == false) {
                return ResultTool.error("删除师生关系异常");
            }
//            3.16 删除托福成绩
            if (deleteToefl(stuId) == false) {
                return ResultTool.error("删除托福成绩异常");
            }

//            4. 删除系统中的文件夹
            FileTool.deleteDir(pathAddress + studentId + "_" + student.getName());
            log.info(pathAddress + studentId + "_" + student.getName());
//            2.更新数据库
            student.setBasicFile(resultPath);
            studentMapper.updateByPrimaryKeySelective(student);
            //             5.返回zip信息
            FileResponse fileResponse = new FileResponse();
            fileResponse.setFileName(fileName);
            fileResponse.setUrl(resultPath);
            return ResultTool.success(fileResponse);

        } else if (student.getCoins() > 0 && !student.getCoins().equals(Integer.parseInt(managerId))) {
//            第二个管理员删除
//            检查学生是否存在
            Student student1 = studentMapper.selectByPrimaryKey(stuId);
            if (student == null) {
                return ResultTool.error("学生不存在");
            }
//            1.下载文件
            FileResponse fileResponse = new FileResponse();
            fileResponse.setUrl(student1.getBasicFile());
            try {
                String tmp = student1.getBasicFile();
                tmp = tmp.substring(tmp.lastIndexOf('/'));
                fileResponse.setFileName(tmp);
            } catch (Exception e) {
                return ResultTool.error("文件名异常");
            }
////            2. 删除用户zip
//            FileTool.deleteFile(student.getBasicFile());
////            3. 删除学生表
//            studentMapper.deleteByPrimaryKey(stuId);
            return ResultTool.success(fileResponse);

        } else {
            return ResultTool.error("您已经下载过该文件！");
        }

    }

    /**
     * @Description: 删除考试账户信息
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteAccount(int studentId) {
        try {
            AccountExample accountExample = new AccountExample();
            accountExample.createCriteria().andUserIdEqualTo(studentId);
            accountMapper.deleteByExample(accountExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * @Description: 删除cv信息
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteCv(int studentId) {
        try {
//            先删除CV交流
            cvCommunicationMapper.deleteStudentChat(studentId);
//            删除Cv
            CvExample cvExample = new CvExample();
            cvExample.createCriteria().andStuIdEqualTo(studentId);
            cvMapper.deleteByExample(cvExample);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除GMAT
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteGmat(int studentId) {
        try {
            GmatExample gmatExample = new GmatExample();
            gmatExample.createCriteria().andStuIdEqualTo(studentId);
            gmatMapper.deleteByExample(gmatExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除GRE成绩
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteGre(int studentId) {
        try {
            GreExample greExample = new GreExample();
            greExample.createCriteria().andStuIdEqualTo(studentId);
            greMapper.deleteByExample(greExample);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    /**
     * @Description: 删除雅思成绩
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteIelts(int studentId) {
        try {
            ieltsExample ieltsExample = new ieltsExample();
            ieltsExample.createCriteria().andStuIdEqualTo(studentId);
            ieltsMapper.deleteByExample(ieltsExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * @Description: 删除lsat成绩
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteLsat(int studentId) {
        try {
            LsatExample lsatExample = new LsatExample();
            lsatExample.createCriteria().andStuIdEqualTo(studentId);
            lsatMapper.deleteByExample(lsatExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除其他文书
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteOtherPaper(int studentId) {
        try {
//            先删除聊天
            otherCommunicationMapper.deleteByStudent(studentId);
//            删除其他信息
            stuSchoolOtherMapper.deleteByStudentId(studentId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除其他事项
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteOtherAction(int studentId) {
        try {
            OtherInfoExample otherInfoExample = new OtherInfoExample();
            otherInfoExample.createCriteria().andVaccineStateEqualTo(studentId);
            otherInfoMapper.deleteByExample(otherInfoExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除其他考试事项
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteOtherTest(int studentId) {
        try {
            OtherTestExample otherTestExample = new OtherTestExample();
            otherTestExample.createCriteria().andStuIdEqualTo(studentId);
            otherTestMapper.deleteByExample(otherTestExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除ps信息
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deletePs(int studentId) {
        try {
            psCommunicationMapper.deleteByStudentId(studentId);
            stuSchoolPsMapper.deleteByStudentId(studentId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description:删除推荐信信息
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteRecommendation(int studentId) {
        try {
//            删除交流信息
            recommendationCommunicationMapper.deleteByStudentId(studentId);
//            删除推荐信信息
            RecommendationExample check = new RecommendationExample();
            check.createCriteria().andStuIdEqualTo(studentId);
            recommendationMapper.deleteByExample(check);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除推荐人
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteRecommender(int studentId) {
        try {
            RecommenderExample recommenderExample = new RecommenderExample();
            recommenderExample.createCriteria().andTypeEqualTo(studentId);
            recommenderMapper.deleteByExample(recommenderExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除sat1成绩
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteSat1(int studentId) {
        try {
            Sat1Example sat1Example = new Sat1Example();
            sat1Example.createCriteria().andStuIdEqualTo(studentId);
            sat1Mapper.deleteByExample(sat1Example);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除学生选校
     * @Param: [student]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteStudentSchool(int student) {
        try {
            StuSchoolExample stuSchoolExample = new StuSchoolExample();
            stuSchoolExample.createCriteria().andStuIdEqualTo(student);
            stuSchoolMapper.deleteByExample(stuSchoolExample);

        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * @Description: 删除作业
     * @Param: [student]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteTask(int student) {
        try {
            taskMapper.deleteByStudentId(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除师生关系
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteTeacherStudent(int studentId) {
        try {
            TeacherStudentExample teacherStudentExample = new TeacherStudentExample();
            teacherStudentExample.createCriteria().andStuIdEqualTo(studentId);
            teacherStudentMapper.deleteByExample(teacherStudentExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @Description: 删除托福成绩
     * @Param: [studentId]
     * @return: boolean
     * @Author: tyq
     * @Date: 2019-06-25
     */
    private boolean deleteToefl(int studentId) {
        try {
            ToeflExample toeflExample = new ToeflExample();
            toeflExample.createCriteria().andStuIdEqualTo(studentId);
            toeflMapper.deleteByExample(toeflExample);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    /**
     * @Description: 下载压缩文件
     * @Param: [fileName, url, userId, studentId]
     * @return: void
     * @Author: tyq
     * @Date: 2019-06-26
     */
    @Override
    public void downLoadZipFile(String fileName, String url, String userId, String studentId, HttpServletResponse httpServletResponse) {
//        检查管理员身份
        if (checkManager(userId) == false) {
            return;
        }
        int managerId = Integer.parseInt(userId);
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if (student == null) {
            return;
        }
        if (student.getCoins().intValue() == 0 || student.getCoins().intValue() == -1) {
//            第一个管理员下载
            FileTool.downloadFile(httpServletResponse, fileName, url);
            student.setCoins(Integer.parseInt(userId));
            studentMapper.updateByPrimaryKeySelective(student);
        } else {
            if (student.getCoins().intValue() != managerId) {
//                第二个管理员下载
                FileTool.downloadFile(httpServletResponse, fileName, url);
//                删除zip
                FileTool.deleteFile(url);
//                删除学生表的记录
                studentMapper.deleteByPrimaryKey(Integer.parseInt(studentId));
            } else {
                return;
            }
        }
    }
}
