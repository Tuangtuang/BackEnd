package com.example.demo.service.impl;

import com.example.demo.dao.*;
import com.example.demo.model.databaseResponse.ChatName;
import com.example.demo.model.databaseResponse.DetailVersionInfo;
import com.example.demo.model.document.*;
import com.example.demo.model.entity.*;
import com.example.demo.model.file.FileResponse;
import com.example.demo.model.overview.Result;
import com.example.demo.service.DocumentService;
import com.example.demo.tool.FileTool;
import com.example.demo.tool.ResultTool;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 文书
 * @author: tyq
 * @create:
 **/
@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private CvMapper cvMapper;

    @Resource
    private RecommendationMapper recommendationMapper;

    @Resource
    private RecommenderMapper recommenderMapper;

    @Resource
    private StuSchoolPsMapper stuSchoolPsMapper;

    @Resource
    private StuSchoolOtherMapper stuSchoolOtherMapper;

    @Resource
    private StuSchoolMapper stuSchoolMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private PsCommunicationMapper psCommunicationMapper;

    @Resource
    private OtherCommunicationMapper otherCommunicationMapper;

    @Resource
    private CvCommunicationMapper cvCommunicationMapper;

    @Resource
    private RecommendationCommunicationMapper recommendationCommunicationMapper;


    //TODO 部署到服务器后修改路径
    private String pathValue = "/var/lib/jiyiedu/";


    /**
     * 文书修改CV提交版本文件内容接口 #24
     *
     * @Description:
     * @Param:
     * @return:
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result putCV(String userId, MultipartFile file) {
//        获取id对应的姓名
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (student == null) {
            return ResultTool.error("该学生不存在");
        }
//        检查文件名
        if(!checkFile(file.getOriginalFilename())){
            return ResultTool.error("文件异常");
        }
//        查看该学生是否存在cv表中
        CvExample check = new CvExample();
        check.createCriteria().andStuIdEqualTo(Integer.parseInt(userId));
        List<Cv> cvList = cvMapper.selectByExample(check);
        Integer cv_version = 0;
        if (cvList.isEmpty() == false) {
            //        获取该学生cv的当前最大版本号
            cv_version = cvMapper.getMaxVersionByStudentId(Integer.parseInt(userId)) + 1;

        }
        String originName = file.getOriginalFilename();
        String newFilePath = pathValue +
                student.getId() + "_" + student.getName() + "/CV/version_" + cv_version + originName.substring(originName.lastIndexOf('.'));
//        存入文件
        FileTool.uploadFile(newFilePath, file);
//        相关记录存入数据库
        Cv record = new Cv();
        record.setFileName(student.getName() + "_CV" + "_" + cv_version+originName.substring(originName.lastIndexOf('.')));
        record.setFilePath(newFilePath);
        record.setStuId(Integer.parseInt(userId));
        record.setVersion(cv_version);
        cvMapper.insert(record);
        PutCvResponse putCvResponse = new PutCvResponse();
        putCvResponse.setName(record.getFileName());
        putCvResponse.setVersion(cv_version.toString());
        putCvResponse.setVersionId(record.getId().toString());
        return ResultTool.success(putCvResponse);
    }


    /**
     * @Description: 推荐信上传接口
     * @Param: [userId, file, recommenderId]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result putRecommendFile(String userId, MultipartFile file, String recommenderId) {
        //        获取id对应的姓名
        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (student == null) {
            return ResultTool.error("该学生不存在");
        }
        //        检查文件名
        if(!checkFile(file.getOriginalFilename())){
            return ResultTool.error("文件异常");
        }
        int u_id = Integer.parseInt(userId);
        int r_id = Integer.parseInt(recommenderId);
//        查看该学生的该推荐人的推荐信是否已经存在
        RecommendationExample check = new RecommendationExample();
        check.createCriteria().andStuIdEqualTo(Integer.parseInt(userId)).andRecommenderIdEqualTo(Integer.parseInt(recommenderId));
        List<Recommendation> RecommendationList = recommendationMapper.selectByExample(check);
        int recommVersion = 0;
        if (RecommendationList.isEmpty() == false) {
//            获取该推荐人推荐信最大版本号
            recommVersion = recommendationMapper.getMaxVersion(u_id, r_id) + 1;
        }
//        检查推荐人是否存在
        Recommender recommender = recommenderMapper.selectByPrimaryKey(r_id);
        if (recommender == null) {
            return ResultTool.error("推荐人不存在");
        }
        String originName = file.getOriginalFilename();

        String newFilePath = pathValue + student.getId() + "_" + student.getName() + "/Recommendation/" + recommenderId + "_" + recommender.getName() + "/version_" + recommVersion + originName.substring(originName.lastIndexOf('.'));
        FileTool.uploadFile(newFilePath, file);
//        相关记录存入数据库
        Recommendation record = new Recommendation();
        record.setName(student.getName() + "_Recommendation_" + recommender.getName() + "_" + recommVersion+originName.substring(originName.lastIndexOf('.')));
        record.setPath(newFilePath);
        record.setRecommenderId(r_id);
        record.setStuId(u_id);
        record.setVersion(recommVersion);
        recommendationMapper.insert(record);
        PutRecommendationResponse putRecommendationResponse = new PutRecommendationResponse();
        putRecommendationResponse.setName(record.getName());
        putRecommendationResponse.setVersion(recommVersion + "");
        putRecommendationResponse.setVersionId(record.getId().toString());
        return ResultTool.success(putRecommendationResponse);
    }

    /**
     * @Description: 文书上传接口
     * @Param: [userId, stuSchoolId, file]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result putPSFile(String userId, String stuSchoolId, MultipartFile file) {
//        检查学生是否存在
        int studentId = Integer.parseInt(userId);
        int studentSchoolId = Integer.parseInt(stuSchoolId);
        Student student = studentMapper.selectByPrimaryKey(studentId);
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
        //        检查文件名
        if(!checkFile(file.getOriginalFilename())){
            return ResultTool.error("文件异常");
        }
        //        检查选校记录是否存在
        StuSchoolExample stuSchoolCheck = new StuSchoolExample();
        stuSchoolCheck.createCriteria().andIdEqualTo(Integer.parseInt(stuSchoolId)).andStuIdEqualTo(Integer.parseInt(userId));
        List<StuSchool> stuSchoolList = stuSchoolMapper.selectByExample(stuSchoolCheck);
        if (stuSchoolList.isEmpty() == true) {
            return ResultTool.error("不存在该选校记录");
        }
//        查看是否已经存在该学校的文书
        StuSchoolPsExample stuSchoolPsExample = new StuSchoolPsExample();
        stuSchoolPsExample.createCriteria().andStuSchoolIdEqualTo(studentSchoolId);
        //TODO 可能需要判断该同学是否选了该学校
        List<StuSchoolPs> stuSchoolPsList = stuSchoolPsMapper.selectByExample(stuSchoolPsExample);
        int version_id = 0;
        if (stuSchoolPsList.isEmpty() == false) {
//            版本号=当前最大版本号+1
            version_id = stuSchoolPsMapper.getMaxVersion(studentSchoolId) + 1;
        }
        String originName = file.getOriginalFilename();
        String newFilePath = pathValue + student.getId() + "_" + student.getName() + "/PS/" + stuSchoolId + "/version_" + version_id + originName.substring(originName.lastIndexOf('.'));
        FileTool.uploadFile(newFilePath, file);
//        相关记录存入数据库
        StuSchoolPs record = new StuSchoolPs();
        record.setName(student.getName() + "_PS_" + stuSchoolId + "_" + version_id+originName.substring(originName.lastIndexOf('.')));
        record.setPath(newFilePath);
        record.setStuSchoolId(studentSchoolId);
        record.setVersionId(version_id);
        stuSchoolPsMapper.insert(record);
        PutRecommendationResponse putPSResponse = new PutRecommendationResponse();
        putPSResponse.setName(record.getName());
        putPSResponse.setVersion(version_id + "");
        putPSResponse.setVersionId(record.getId().toString());
        return ResultTool.success(putPSResponse);
    }

    /**
     * @Description: 其他上传接口
     * @Param: [userId, stuSchoolId, file]
     * @return: com.example.demo.model.overview.Result
     * @Author: tyq
     * @Date:
     */
    @Override
    public Result putOtherPaper(String userId, String stuSchoolId, MultipartFile file) {
//        检查学生是否存在
        int studentId = Integer.parseInt(userId);
        int studentSchoolId = Integer.parseInt(stuSchoolId);
        Student student = studentMapper.selectByPrimaryKey(studentId);
        if (student == null) {
            return ResultTool.error("学生不存在");
        }
        //        检查文件名
        if(!checkFile(file.getOriginalFilename())){
            return ResultTool.error("文件异常");
        }
//        检查选校记录是否存在
        StuSchoolExample stuSchoolCheck = new StuSchoolExample();
        stuSchoolCheck.createCriteria().andIdEqualTo(Integer.parseInt(stuSchoolId)).andStuIdEqualTo(Integer.parseInt(userId));
        List<StuSchool> stuSchoolList = stuSchoolMapper.selectByExample(stuSchoolCheck);
        if (stuSchoolList.isEmpty() == true) {
            return ResultTool.error("不存在该选校记录");
        }
//        查看是否存在该学校的其他信息
        StuSchoolOtherExample stuSchoolOtherExample = new StuSchoolOtherExample();
        stuSchoolOtherExample.createCriteria().andStuSchoolIdEqualTo(Integer.parseInt(stuSchoolId));
        List<StuSchoolOther> stuSchoolOtherList = stuSchoolOtherMapper.selectByExample(stuSchoolOtherExample);
        int version_id = 0;
        if (stuSchoolOtherList.isEmpty() == false) {
//            查找当前最大id
            version_id = stuSchoolOtherMapper.getMaxVersion(Integer.parseInt(stuSchoolId)) + 1;
        }
//        构造文件路径
        String originName = file.getOriginalFilename();
        String newFilePath = pathValue + student.getId() + "_" + student.getName() + "/Other/" + stuSchoolId + "/version_" + version_id + originName.substring(originName.lastIndexOf('.'));
        FileTool.uploadFile(newFilePath, file);
//        相关记录存入数据库
        StuSchoolOther record = new StuSchoolOther();
        record.setName(student.getName() + "_Other_" + stuSchoolId + "_" + version_id+originName.substring(originName.lastIndexOf('.')));
        record.setPath(newFilePath);
        record.setStuSchoolId(studentSchoolId);
        record.setVersionId(version_id);
        stuSchoolOtherMapper.insert(record);
        PutRecommendationResponse putPSResponse = new PutRecommendationResponse();
        putPSResponse.setName(record.getName());
        putPSResponse.setVersion(version_id + "");
        putPSResponse.setVersionId(record.getId().toString());
        return ResultTool.success(putPSResponse);
    }


    /** 
    * @Description: 获取其他信息
    * @Param: [Id, httpServletResponse] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getOtherPaper(String Id, HttpServletResponse httpServletResponse,String userId) {
        StuSchoolOther stuSchoolOther=stuSchoolOtherMapper.selectByPrimaryKey(Integer.parseInt(Id));
        if(stuSchoolOther==null){
            return ResultTool.error("不存在相关信息");
        }
        if(checkStudentByStuSchoolId(stuSchoolOther.getStuSchoolId(),Integer.parseInt(userId))==false){
            return ResultTool.error("不是该学生的信息");
        }
//        FileTool.downloadFile(httpServletResponse,stuSchoolOther.getName(),stuSchoolOther.getPath());
        FileResponse fileResponse=new FileResponse();
        fileResponse.setFileName(stuSchoolOther.getName());
        fileResponse.setUrl(stuSchoolOther.getPath());
        return ResultTool.success(fileResponse);
    }

    /** 
    * @Description: 文书修改PS获取版本文件内容接口 #20
    * @Param: [Id, httpServletResponse] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getPS(String Id, HttpServletResponse httpServletResponse,String userId) {
        StuSchoolPs stuSchoolPs=stuSchoolPsMapper.selectByPrimaryKey(Integer.parseInt(Id));
        if(stuSchoolPs==null){
            return ResultTool.error("不存在相关信息");
        }
        if(checkStudentByStuSchoolId(stuSchoolPs.getStuSchoolId(),Integer.parseInt(userId))==false){
            return ResultTool.error("不是该学生信息");
        }
//        FileTool.downloadFile(httpServletResponse,stuSchoolPs.getName(),stuSchoolPs.getPath());
        FileResponse fileResponse=new FileResponse();
        fileResponse.setUrl(stuSchoolPs.getPath());
        fileResponse.setFileName(stuSchoolPs.getName());
        return ResultTool.success(fileResponse);
    }

    /** 
    * @Description: 文书修改推荐信获取版本文件内容接口 #17 
    * @Param: [Id, httpServletResponse] 
    * @return: void 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getRecommendation(String Id, HttpServletResponse httpServletResponse,String userId) {
        Recommendation recommendation=recommendationMapper.selectByPrimaryKey(Integer.parseInt(Id));
        if(recommendation==null){
            return ResultTool.error("不存在相关信息");
        }
        if(!recommendation.getStuId().equals(Integer.parseInt(userId))){
            return ResultTool.error("不是该学生信息");
        }
        FileResponse fileResponse=new FileResponse();
        fileResponse.setFileName(recommendation.getName());
        fileResponse.setUrl(recommendation.getPath());
        return ResultTool.success(fileResponse);
    }

    /** 
    * @Description: 文书修改CV获取版本详细信息接口 #15
    * @Param: [Id, httpServletResponse] 
    * @return: void 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getCv(String Id, HttpServletResponse httpServletResponse,String userId) {
        Cv cv=cvMapper.selectByPrimaryKey(Integer.parseInt(Id));
        if(cv==null){
            return ResultTool.error("不存在相关信息");
        }
        if(!cv.getStuId().equals(Integer.parseInt(userId))){
            return ResultTool.error("不是该学生信息");
        }
//        FileTool.downloadFile(httpServletResponse,cv.getFileName(),cv.getFilePath());
        FileResponse fileResponse=new FileResponse();
        fileResponse.setUrl(cv.getFilePath());
        fileResponse.setFileName(cv.getFileName());
        return ResultTool.success(fileResponse);
    }

    /**
    * @Description: 通过学生选校id判断该选校是否为该学生的选择
    * @Param: [studentSchoolId, studentId]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkStudentByStuSchoolId(int studentSchoolId,int studentId){
        StuSchool check=stuSchoolMapper.selectByPrimaryKey(studentSchoolId);
        if(check==null){
            return false;
        }
        if(studentId==check.getStuId()){
            return true;
        }
        return false;
    }

    @Override
    public Result chatPs(ChatPs chatPs) {
//        检查该版本的版本号是否存在
        StuSchoolPs check=stuSchoolPsMapper.selectByPrimaryKey(Integer.parseInt(chatPs.getVersionId()));
        if(check==null){
            return ResultTool.error("不存在该文书");
        }
//        检查是否是该学生文书记录
        if(!checkStudentByStuSchoolId(check.getStuSchoolId(),Integer.parseInt(chatPs.getUserId()))){
            return ResultTool.error("不是该学生的文书记录");
        }
        PsCommunication record=new PsCommunication();
        if(chatPs.getTeaId().equals("")){
//            学生发出来的请求
            record.setVersionId(1);//该字段被征用为身份标志
            if(!checkStudent(Integer.parseInt(chatPs.getUserId()))){
                return ResultTool.error("学生不存在");
            }
            record.setPeopleId(Integer.parseInt(chatPs.getUserId()));
        }else {
//            老师发出来的请求
            record.setVersionId(0);
            if(!checkTeacher(Integer.parseInt(chatPs.getTeaId()))){
                return ResultTool.error("老师不存在");
            }
            record.setPeopleId(Integer.parseInt(chatPs.getTeaId()));
        }
        record.setContent(chatPs.getMessage());
        record.setTblStuSchoolPsId(Integer.parseInt(chatPs.getVersionId()));
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        record.setTime(ts);
        psCommunicationMapper.insert(record);
        return ResultTool.success();

    }

    /**
    * @Description: 检查文件是否带后缀名
    * @Param: [fileName]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkFile(String fileName){
        log.info(fileName);
//        if(fileName.contains(".")==false){
//            return false;
//        }
        return fileName.contains(".");
    }

    /**
    * @Description: 检查学生是否存在
    * @Param: [studentId]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    private boolean checkStudent(int studentId){
        Student student=studentMapper.selectByPrimaryKey(studentId);
        if(student==null){
            return false;
        }
        return true;
    }

    private boolean checkTeacher(int teacherId){
        Teacher teacher=teacherMapper.selectByPrimaryKey(teacherId);
        if(teacher==null){
            return false;
        }
        return true;
    }

    /** 
    * @Description: 文书修改PHS版本师生交流接口 #31
    * @Param: [chatPs] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result chatOther(ChatPs chatPs) {
//        检查other的版本号是否存在
        StuSchoolOther stuSchoolOther=stuSchoolOtherMapper.selectByPrimaryKey(Integer.parseInt(chatPs.getVersionId()));
        if(stuSchoolOther==null){
            return ResultTool.error("该其他信息版本不存在");
        }
//        检查是否为该学生的other记录
        if(!checkStudentByStuSchoolId(stuSchoolOther.getStuSchoolId(),Integer.parseInt(chatPs.getUserId()))){
            return ResultTool.error("不是该学生的其他记录");
        }
        OtherCommunication record=new OtherCommunication();
        if(chatPs.getTeaId().equals("")){
//            学生发出来的请求
            if(!checkStudent(Integer.parseInt(chatPs.getUserId()))){
                return ResultTool.error("学生不存在");
            }
            record.setPeopleId(Integer.parseInt(chatPs.getUserId()));
        }else {
//            老师发出来的请求
            if(!checkTeacher(Integer.parseInt(chatPs.getTeaId()))){
                return ResultTool.error("老师不存在");
            }
            record.setPeopleId(-Integer.parseInt(chatPs.getTeaId()));//如果people是小于0的说明是老师的留言
        }
        record.setContent(chatPs.getMessage());
        record.setTblStuSchoolOtherId(Integer.parseInt(chatPs.getVersionId()));
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        record.setTime(ts);
        try {
            otherCommunicationMapper.insert(record);
        }catch (Exception e){
            return ResultTool.error("插入失败");
        }
        return ResultTool.success();

    }

    /** 
    * @Description: 推荐信师生交流 
    * @Param: [chatPs] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result chatRecommendation(ChatPs chatPs) {
//        return null;
//        检查推荐信的版本号是否存在
        Recommendation recommendation = recommendationMapper.selectByPrimaryKey(Integer.parseInt(chatPs.getVersionId()));
        if(recommendation==null){
            return ResultTool.error("推荐信版本不存在");
        }
//        检查是否是该学生的推荐信
        int studentId=Integer.parseInt(chatPs.getUserId());
        if(studentId!=recommendation.getStuId()){
            return ResultTool.error("不是该学生的推荐信");
        }
        RecommendationCommunication record=new RecommendationCommunication();
        if(chatPs.getTeaId().equals("")){
//            学生发出来的请求
            
            if(!checkStudent(studentId)){
                return ResultTool.error("学生不存在");
            }
            record.setVersionId(1);
            record.setPeopleId(studentId);
            
        }else {
//            老师发出来的请求
            if(!checkTeacher(Integer.parseInt(chatPs.getTeaId()))){
                return ResultTool.error("老师不存在");
            }
            record.setVersionId(0);
            record.setPeopleId(Integer.parseInt(chatPs.getTeaId()));
        }
        record.setTblRecommendationId(Integer.parseInt(chatPs.getVersionId()));
        record.setContent(chatPs.getMessage());
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        record.setTime(ts);
//        try {
            recommendationCommunicationMapper.insert(record);
//        }catch (Exception e){
//            return ResultTool.error("插入失败");
//        }
        return ResultTool.success();
    }


    /**
    * @Description: 文书修改CV版本师生交流接口 #28
    * @Param: [chatPs]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result chatCV(ChatPs chatPs) {
//        return null;
//        检查CV的版本号是否存在
        Cv cv = cvMapper.selectByPrimaryKey(Integer.parseInt(chatPs.getVersionId()));
        if(cv==null){
            return ResultTool.error("该CV版本不存在");
        }
//        检查是否是该学生的CV
        int studentId = Integer.parseInt(chatPs.getUserId());
        if(studentId!=cv.getStuId()){
            return ResultTool.error("不是该学生的CV");
        }
        CvCommunication record=new CvCommunication();
        if(chatPs.getTeaId().equals("")){
//            学生发出的请求
            if(!checkStudent(studentId)){
                return ResultTool.error("学生不存在");
            }
            record.setVersionId(1);
            record.setPeopleId(studentId);
        }else {
            //            老师发出来的请求
            if(!checkTeacher(Integer.parseInt(chatPs.getTeaId()))){
                return ResultTool.error("老师不存在");
            }
            record.setVersionId(0);
            record.setPeopleId(Integer.parseInt(chatPs.getTeaId()));
        }
        record.setContent(chatPs.getMessage());
        record.setCvId(Integer.parseInt(chatPs.getVersionId()));
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        record.setTime(ts);
        try {
            cvCommunicationMapper.insert(record);
        }catch (Exception e){
            return ResultTool.error("插入失败");
        }

        return ResultTool.success();
    }

    /**
    * @Description: 文书修改PHS获取版本详细信息接口 #22
    * @Param: [versionId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result getChatInfoOther(String versionId) {
        int vId=Integer.parseInt(versionId);
        OtherCommunicationExample otherCommunicationExample=new OtherCommunicationExample();
        otherCommunicationExample.createCriteria().andTblStuSchoolOtherIdEqualTo(vId);
        List<OtherCommunication> otherCommunicationList=otherCommunicationMapper.selectByExample(otherCommunicationExample);
        if(otherCommunicationList.isEmpty()==true){
            return ResultTool.error("该版本文书没有交流");
        }

        List<ChatName> chatNameTeacherList=otherCommunicationMapper.getTeacherName(vId);
        log.info(chatNameTeacherList.size()+"");
        List<ChatName> chatNameStudentList=otherCommunicationMapper.getStudentName(vId);
        log.info(chatNameStudentList.size()+"");
        List<ChatName> chatNameList=mergeTwoList(chatNameStudentList,chatNameTeacherList);

        List<ChatInfoResponse> chatInfoResponseList=new LinkedList<>();
        for(ChatName item:chatNameList){
            ChatInfoResponse info=new ChatInfoResponse();
            info.setDetail(item.getDetail());
            info.setIdentity(item.getIdentityTag().toString());
            info.setPerson(item.getName());
            chatInfoResponseList.add(info);
        }

        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessList(chatInfoResponseList);
        return ResultTool.success(messageResponse);

    }

//    合并两个有序链表
    private List<ChatName> mergeTwoList(List<ChatName> a,List<ChatName> b){
        List<ChatName> result=new LinkedList<>();
        if(a.size()==0){
            return b;
        }
        if(b.size()==0){
            return a;
        }

        int i=0,j=0;
        while (i<a.size()&&j<b.size()){


            if(a.get(i).getPostTime().toString().compareTo(b.get(j).getPostTime().toString())<=0){
//                a列表的元素小
                result.add(a.get(i));
                i++;
            }else {
                result.add(b.get(j));
                j++;
            }
        }
        if(i<a.size()){
//            说明a表还有剩下的
            for(;i<a.size();i++){
                result.add(a.get(i));
            }
        }
        if(j<b.size()){
//            说明b表还有剩下的
            for(;j<b.size();j++){
                result.add(b.get(j));
            }
        }
        return result;
    }

    /** 
    * @Description: 文书修改PHS获取版本接口 #21
    * @Param: [studentSchoolId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getOtherVersion(String studentSchoolId) {

        List<DetailVersionInfo> detailVersionInfoList = stuSchoolOtherMapper.getVersionInfo(Integer.parseInt(studentSchoolId));
        if(detailVersionInfoList.isEmpty()==true){
            return ResultTool.error("该选校记录没有对应的其他信息");
        }
        List<PaperVersion> paperVersionList = new LinkedList<>();
        for(DetailVersionInfo item:detailVersionInfoList){
            PaperVersion info=new PaperVersion();
            info.setName(item.getFileName());
            info.setVersion(item.getVersion().toString());
            info.setVersionId(item.getId().toString());
            paperVersionList.add(info);
        }
        PaperVersionResponse paperVersionResponse=new PaperVersionResponse();
        paperVersionResponse.setName(detailVersionInfoList.get(0).getSchoolName()+"其他Paper");
        paperVersionResponse.setTimeList(paperVersionList);
        List<PaperVersionResponse> paperVersionResponseList=new LinkedList<>();
        paperVersionResponseList.add(paperVersionResponse);
        VersionResponse versionResponse=new VersionResponse();
        versionResponse.setVersionResponseList(paperVersionResponseList);
        return ResultTool.success(versionResponse);
    }

    /** 
    * @Description: 文书修改PS获取版本详细信息接口 #19 
    * @Param: [versionId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getChatInfoPS(String versionId) {
        int vId=Integer.parseInt(versionId);
        PsCommunicationExample psCommunicationExample=new PsCommunicationExample();
        psCommunicationExample.createCriteria().andTblStuSchoolPsIdEqualTo(vId);
        List<PsCommunication> otherCommunicationList=psCommunicationMapper.selectByExample(psCommunicationExample);
        if(otherCommunicationList.isEmpty()==true){
            return ResultTool.error("该版本文书没有交流");
        }
        List<ChatName> chatNameTeacherList = psCommunicationMapper.getPSChatInfoTeacher(vId);
        List<ChatName> chatNameStudentList = psCommunicationMapper.getPSChatInfoStudent(vId);
        List<ChatName> chatNameList=mergeTwoList(chatNameStudentList,chatNameTeacherList);
        List<ChatInfoResponse> chatInfoResponseList=new LinkedList<>();
        for(ChatName item:chatNameList){
            ChatInfoResponse info=new ChatInfoResponse();
            info.setPerson(item.getName());
            info.setIdentity(item.getIdentityTag().toString());
            info.setDetail(item.getDetail());
            chatInfoResponseList.add(info);
        }
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessList(chatInfoResponseList);
        return ResultTool.success(messageResponse);
    }

    /** 
    * @Description: 文书修改PS获取版本接口 #18
    * @Param: [studentSchoolId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getPSVersion(String studentSchoolId) {
        List<DetailVersionInfo> detailVersionInfoList = stuSchoolPsMapper.getVersionInfo(Integer.parseInt(studentSchoolId));
        if(detailVersionInfoList.isEmpty()==true){
            return ResultTool.error("该选校记录没有对应的PS信息");
        }
        List<PaperVersion> paperVersionList = new LinkedList<>();
        for(DetailVersionInfo item:detailVersionInfoList){
            PaperVersion info=new PaperVersion();
            info.setName(item.getFileName());
            info.setVersion(item.getVersion().toString());
            info.setVersionId(item.getId().toString());
            paperVersionList.add(info);
        }
        PaperVersionResponse paperVersionResponse=new PaperVersionResponse();
        paperVersionResponse.setName(detailVersionInfoList.get(0).getSchoolName()+" PS");
        paperVersionResponse.setTimeList(paperVersionList);
        List<PaperVersionResponse> paperVersionResponseList=new LinkedList<>();
        paperVersionResponseList.add(paperVersionResponse);
        VersionResponse versionResponse=new VersionResponse();
        versionResponse.setVersionResponseList(paperVersionResponseList);
        return ResultTool.success(versionResponse);
    }

    /** 
    * @Description: 文书修改推荐信获取版本详细信息接口 #16 
    * @Param: [versionId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getChatInfoRecommendation(String versionId) {
//        return null;
        int vId=Integer.parseInt(versionId);
        RecommendationCommunicationExample  recommendationCommunicationExample=new  RecommendationCommunicationExample();
        recommendationCommunicationExample.createCriteria().andTblRecommendationIdEqualTo(vId);
        List<RecommendationCommunication> otherCommunicationList=recommendationCommunicationMapper.selectByExample(recommendationCommunicationExample);
        if(otherCommunicationList.isEmpty()==true){
            return ResultTool.error("该版本推荐信没有交流");
        }
        List<ChatName> chatNameTeacherList = recommendationCommunicationMapper.getTeacherChatInfo(vId);
        List<ChatName> chatNameStudentList = recommendationCommunicationMapper.getStudentChatInfo(vId);
        List<ChatName> chatNameList=mergeTwoList(chatNameStudentList,chatNameTeacherList);
        List<ChatInfoResponse> chatInfoResponseList=new LinkedList<>();
        for(ChatName item:chatNameList){
            ChatInfoResponse info=new ChatInfoResponse();
            info.setPerson(item.getName());
            info.setIdentity(item.getIdentityTag().toString());
            info.setDetail(item.getDetail());
            chatInfoResponseList.add(info);
        }
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessList(chatInfoResponseList);
        return ResultTool.success(messageResponse);
    }

    /** 
    * @Description: 文书修改CV获取版本详细信息接口 #13
    * @Param: [versionId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getChatInfoCV(String versionId) {
        int vId=Integer.parseInt(versionId);
        log.info(vId+"");
        CvCommunicationExample  cvCommunicationExample=new  CvCommunicationExample();
        cvCommunicationExample.createCriteria().andCvIdEqualTo(vId);
        List<CvCommunication> otherCommunicationList=cvCommunicationMapper.selectByExample(cvCommunicationExample);
        if(otherCommunicationList.isEmpty()==true){
            return ResultTool.error("该版本推荐信没有交流");
        }
        List<ChatName> chatNameTeacherList = cvCommunicationMapper.getTeacherCvChatInfo(vId);
        log.info(chatNameTeacherList.size()+"");
        List<ChatName> chatNameStudentList = cvCommunicationMapper.getStudentCvChatInfo(vId);
        log.info(chatNameStudentList.size()+"");
        List<ChatName> chatNameList=mergeTwoList(chatNameStudentList,chatNameTeacherList);
        List<ChatInfoResponse> chatInfoResponseList=new LinkedList<>();
        for(ChatName item:chatNameList){
            ChatInfoResponse info=new ChatInfoResponse();
            info.setPerson(item.getName());
            info.setIdentity(item.getIdentityTag().toString());
            info.setDetail(item.getDetail());
            chatInfoResponseList.add(info);
        }
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessList(chatInfoResponseList);
        return ResultTool.success(messageResponse);
    }

    /** 
    * @Description: 获取推荐信版本信息 
    * @Param: [recommenderId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getVersionInfoRecommendation(String recommenderId) {
        List<DetailVersionInfo> detailVersionInfoList = recommendationMapper.getVerisonInfoReco(Integer.parseInt(recommenderId));
        if(detailVersionInfoList.isEmpty()==true){
            return ResultTool.error("该选校记录没有对应的推荐信信息");
        }
        List<PaperVersion> paperVersionList = new LinkedList<>();
        for(DetailVersionInfo item:detailVersionInfoList){
            PaperVersion info=new PaperVersion();
            info.setName(item.getFileName());
            info.setVersion(item.getVersion().toString());
            info.setVersionId(item.getId().toString());
            paperVersionList.add(info);
        }
        PaperVersionResponse paperVersionResponse=new PaperVersionResponse();
        paperVersionResponse.setName(detailVersionInfoList.get(0).getSchoolName()+"推荐信");
        paperVersionResponse.setTimeList(paperVersionList);
        List<PaperVersionResponse> paperVersionResponseList=new LinkedList<>();
        paperVersionResponseList.add(paperVersionResponse);
        VersionResponse versionResponse=new VersionResponse();
        versionResponse.setVersionResponseList(paperVersionResponseList);
        return ResultTool.success(versionResponse);
    }

    /** 
    * @Description: 获取CV信息 
    * @Param: [studentId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getVersionInfoCv(String studentId) {
        CvExample cvExample=new CvExample();
        cvExample.createCriteria().andStuIdEqualTo(Integer.parseInt(studentId));
        List<Cv> cvList=cvMapper.selectByExample(cvExample);
        if(cvList.isEmpty()==true){
            return ResultTool.error("该学生的CV不存在");
        }
        List<PaperVersion> paperVersionList = new LinkedList<>();
        for(Cv item:cvList){
            PaperVersion info=new PaperVersion();
            info.setName(item.getFileName());
            info.setVersion(item.getVersion().toString());
            info.setVersionId(item.getId().toString());
            paperVersionList.add(info);
        }
        PaperVersionResponse paperVersionResponse=new PaperVersionResponse();
        paperVersionResponse.setName("简历");
        paperVersionResponse.setTimeList(paperVersionList);


        List<PaperVersionResponse> paperVersionResponseList=new LinkedList<>();
        paperVersionResponseList.add(paperVersionResponse);
        VersionResponse versionResponse=new VersionResponse();
        versionResponse.setVersionResponseList(paperVersionResponseList);
        return ResultTool.success(versionResponse);
    }

    /**
    * @Description: 文书修改添加推荐人接口 #70
    * @Param: [recommenderInfo]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result addRecommender(RecommenderInfo recommenderInfo) {
//        检查学生是否存在
        Student student=studentMapper.selectByPrimaryKey(Integer.parseInt(recommenderInfo.getUserId()));
        if(student==null){
            return ResultTool.error("该学生不存在");
        }
        Recommender recommender=new Recommender();
        recommender.setName(recommenderInfo.getRecommendName());
        recommender.setType(Integer.parseInt(recommenderInfo.getUserId()));
        recommenderMapper.insert(recommender);
        RecommenderId recommenderId=new RecommenderId();
        recommenderId.setRecommendId(recommender.getId().toString());
        return ResultTool.success(recommenderId);
    }


    /** 
    * @Description: 文书修改获取推荐人信息接口 #69 
    * @Param: [studentId] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getRecommender(String studentId) {
//        return null;
//        检查学生是否存在
        Student student=studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if(student==null){
            return ResultTool.error("学生不存在");
        }
        RecommenderExample recommenderExample=new RecommenderExample();
        recommenderExample.createCriteria().andTypeEqualTo(Integer.parseInt(studentId));
        List<Recommender> recommenderList=recommenderMapper.selectByExample(recommenderExample);
        List<RecommendList> recommendListList=new LinkedList<>();
        for(Recommender item:recommenderList){
            RecommendList info=new RecommendList();
            info.setName(item.getName());
            info.setRecommendId(item.getId().toString());
            recommendListList.add(info);
        }
        RecommendResponse recommendResponse=new RecommendResponse();
        recommendResponse.setRecommendList(recommendListList);
        return ResultTool.success(recommendResponse);
    }

    /**
    * @Description: 文书修改教师确认文书修改完成接口 #71
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result comfirmFinish(String studentId) {
//        找到学生
        Student student=studentMapper.selectByPrimaryKey(Integer.parseInt(studentId));
        if(student==null){
            return ResultTool.error("学生不存在");
        }
//        检查状态是否合格
        if(student.getApplyState()<2){
            return ResultTool.error("学生尚未完成选校以及之前内容");
        }
        student.setApplyState(3);
        studentMapper.updateByPrimaryKeySelective(student);
        return ResultTool.success();
    }


    @Override
    public Result deleteRecommender(DeleteRecommenderRequest deleteRecommenderRequest) {
//        检查推荐人是否存在
        int id=Integer.parseInt(deleteRecommenderRequest.getRecommend());
        Recommender recommender = recommenderMapper.selectByPrimaryKey(id);
        if(recommender==null){
            return ResultTool.error("推荐人不存在");
        }
//        检查推荐人和学生是否匹配
        if(!recommender.getType().equals(Integer.parseInt(deleteRecommenderRequest.getUserId()))){
            return ResultTool.error("推荐人和学生不匹配");
        }
//        删除推荐人
        try {
            recommenderMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }

        return ResultTool.success();


    }
}
