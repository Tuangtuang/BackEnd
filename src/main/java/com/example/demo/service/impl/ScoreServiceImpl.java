package com.example.demo.service.impl;

import com.example.demo.dao.*;
import com.example.demo.model.entity.*;
import com.example.demo.model.overview.Result;
import com.example.demo.model.score.*;
import com.example.demo.service.ScoreService;
import com.example.demo.tool.ResultTool;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 分数统计
 * @author: tyq
 * @create:
 **/
@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private GreMapper greMapper;

    @Resource
    private GmatMapper gmatMapper;

    @Resource
    private ToeflMapper toeflMapper;

    @Resource
    private ieltsMapper ieltsMapper;

    @Resource
    private LsatMapper lsatMapper;

    @Resource
    private Sat1Mapper sat1Mapper;

    @Resource
    private OtherTestMapper otherTestMapper;

    /**
    * @Description: 添加GRE成绩
    * @Param: [greScore]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result addGre(GreScore greScore) {
        Timestamp ts;
        String testDate=greScore.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
        GreExample greExample=new GreExample();
        greExample.createCriteria().andStuIdEqualTo(Integer.parseInt(greScore.getUserId())).andTestDateEqualTo(ts);
        List<Gre> greList=greMapper.selectByExample(greExample);
        if(greList.isEmpty()==false){
            return ResultTool.error("您在该日期已经存在GRE考试记录");
        }
        Gre record=new Gre();
        try {
            record.setOverall(Double.parseDouble(greScore.getOverAll()));
            record.setOverallPercentile(Double.parseDouble(greScore.getOverallPercentile()));
            record.setVerbal(Double.parseDouble(greScore.getOverAll()));
            record.setVerbalPercentile(Double.parseDouble(greScore.getVerbalPercentile()));
            record.setQuantitative(Double.parseDouble(greScore.getQuantitative()));
            record.setQuantitativePercentile(Double.parseDouble(greScore.getQuantitativePercentile()));
            record.setWriting(Double.parseDouble(greScore.getWriting()));
            record.setWritingPercentile(Double.parseDouble(greScore.getWritingPercentile()));
            record.setTestDate(ts);
            record.setStuId(Integer.parseInt(greScore.getUserId()));
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        greMapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);

    }

    /**
    * @Description: 成绩统计添加GMAT历史成绩接口 #37
    * @Param: [greScore]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result addGmat(GreScore greScore) {
        Timestamp ts;
        String testDate=greScore.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
        GmatExample gmatExample=new GmatExample();
        gmatExample.createCriteria().andStuIdEqualTo(Integer.parseInt(greScore.getUserId())).andTestDateEqualTo(ts);
        List<Gmat> gmatList=gmatMapper.selectByExample(gmatExample);
        if(gmatList.isEmpty()==false){
            return ResultTool.error("您在该日期已经存在GMAT考试记录");
        }
        Gmat record=new Gmat();
        try {
            record.setOverall(Double.parseDouble(greScore.getOverAll()));
            record.setOverallPercentile(Double.parseDouble(greScore.getOverallPercentile()));
            record.setVerbal(Double.parseDouble(greScore.getOverAll()));
            record.setVerbalPercentile(Double.parseDouble(greScore.getVerbalPercentile()));
            record.setQuantitative(Double.parseDouble(greScore.getQuantitative()));
            record.setQuantitativePercentite(Double.parseDouble(greScore.getQuantitativePercentile()));
            record.setWriting(Double.parseDouble(greScore.getWriting()));
            record.setWritingPercentile(Double.parseDouble(greScore.getWritingPercentile()));
            record.setTestDate(ts);
            record.setStuId(Integer.parseInt(greScore.getUserId()));
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        gmatMapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);
    }

    /**
    * @Description: 提交托福成绩接口
    * @Param: [toeflAndIeltsScore]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result addToefl(ToeflAndIeltsScore toeflAndIeltsScore) {
        Timestamp ts;
        String testDate=toeflAndIeltsScore.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
        ToeflExample toeflExample=new ToeflExample();
        toeflExample.createCriteria().andStuIdEqualTo(Integer.parseInt(toeflAndIeltsScore.getUserId())).andTestDateEqualTo(ts);
        List<Toefl> toeflList=toeflMapper.selectByExample(toeflExample);
        if(toeflList.isEmpty()==false){
            return ResultTool.error("您在该日期已经存在托福考试记录");
        }
        Toefl record=new Toefl();
        try {
            record.setOverall(Double.parseDouble(toeflAndIeltsScore.getOverall()));
            record.setListening(Double.parseDouble(toeflAndIeltsScore.getListening()));
            record.setSpeaking(Double.parseDouble(toeflAndIeltsScore.getSpeaking()));
            record.setReading(Double.parseDouble(toeflAndIeltsScore.getReading()));
            record.setWriting(Double.parseDouble(toeflAndIeltsScore.getWriting()));
            record.setTestDate(ts);
            record.setStuId(Integer.parseInt(toeflAndIeltsScore.getUserId()));
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        toeflMapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);
    }

    /** 
    * @Description: 提交雅思成绩接口 
    * @Param: [toeflAndIeltsScore] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result addIelts(ToeflAndIeltsScore toeflAndIeltsScore) {
        Timestamp ts;
        String testDate=toeflAndIeltsScore.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
        ieltsExample ieltsExample=new ieltsExample();
        ieltsExample.createCriteria().andStuIdEqualTo(Integer.parseInt(toeflAndIeltsScore.getUserId())).andTestDateEqualTo(ts);
        List<ielts> ieltsList=ieltsMapper.selectByExample(ieltsExample);
        if(ieltsList.isEmpty()==false){
            return ResultTool.error("您在该日期已经存在雅思考试记录");
        }
        ielts record=new ielts();
        try {
            record.setOverall(Double.parseDouble(toeflAndIeltsScore.getOverall()));
            record.setListening(Double.parseDouble(toeflAndIeltsScore.getListening()));
            record.setSpeaking(Double.parseDouble(toeflAndIeltsScore.getSpeaking()));
            record.setReading(Double.parseDouble(toeflAndIeltsScore.getReading()));
            record.setWriting(Double.parseDouble(toeflAndIeltsScore.getWriting()));
            record.setTestDate(ts);
            record.setStuId(Integer.parseInt(toeflAndIeltsScore.getUserId()));
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        ieltsMapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);
    }

    /** 
    * @Description: 添加lsat成绩 
    * @Param: [lsatScore] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result addLsat(LsatScore lsatScore) {
        Timestamp ts;
        String testDate=lsatScore.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
//        检查是否存在该日期考试记录
        LsatExample lsatExample=new LsatExample();
        lsatExample.createCriteria().andStuIdEqualTo(Integer.parseInt(lsatScore.getUserId())).andTestDateEqualTo(ts);
        List<Lsat> lsatList=lsatMapper.selectByExample(lsatExample);
        if(lsatList.isEmpty()==false){
            return ResultTool.error("您在该日期已经存在Lsat考试记录");
        }
        Lsat record=new Lsat();
        try {
            record.setAnalysis(Double.parseDouble(lsatScore.getAnalysis()));
            record.setAnalysisPercentile(Double.parseDouble(lsatScore.getAnalysisPercentile()));
            record.setLogic(Double.parseDouble(lsatScore.getLogic()));
            record.setLogicPercentile(Double.parseDouble(lsatScore.getLogicPercentile()));
            record.setStuId(Integer.parseInt(lsatScore.getUserId()));
            record.setReading(Double.parseDouble(lsatScore.getReading()));
            record.setReadingPercentile(Double.parseDouble(lsatScore.getReadingPercentile()));
            record.setOverall(Double.parseDouble(lsatScore.getOverall()));
            record.setOverallPercentile(Double.parseDouble(lsatScore.getOverallPercentile()));
            record.setTestDate(ts);
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        lsatMapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);
    }

    /**
    * @Description: 成绩统计添加SAT1历史成绩接口 #55
    * @Param: [sat1Score]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result addSat1(Sat1Score sat1Score) {
        Timestamp ts;
        String testDate=sat1Score.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
//       检查是否存在该考试记录
        Sat1Example sat1Example=new Sat1Example();
        sat1Example.createCriteria().andStuIdEqualTo(Integer.parseInt(sat1Score.getUserId())).andTestDateEqualTo(ts);
        List<Sat1> sat1List=sat1Mapper.selectByExample(sat1Example);
        if(sat1List.isEmpty()==false){
            return ResultTool.error("您在该日期已经存在Sat1考试记录");
        }
        Sat1 record=new Sat1();
        try {
            record.setEssay(Double.parseDouble(sat1Score.getEssay()));
            record.setMath(Double.parseDouble(sat1Score.getMath()));
            record.setReading(Double.parseDouble(sat1Score.getReading()));
            record.setWriting(Double.parseDouble(sat1Score.getWriting()));
            record.setStuId(Integer.parseInt(sat1Score.getUserId()));
            record.setTestDate(ts);
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        sat1Mapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);

    }

    /** 
    * @Description: 成绩统计添加OTHER历史成绩接口 #56
    * @Param: [otherScore] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result addOther(OtherScore otherScore) {
        Timestamp ts;
        String testDate=otherScore.getTestDate()+" 00:00:00";
        try {
            ts=Timestamp.valueOf(testDate);
        }catch (Exception e){
            return ResultTool.error("时间转换出错");
        }
        String test_type;
        //        确定考试类型
        int type=Integer.parseInt(otherScore.getType());
        switch (type){
            case 7:test_type="SAT2";break;
            case 8:test_type="IB";break;
            case 9:test_type="AP";break;
            default:return ResultTool.error("考试类型不合法！");
        }
//        检查是否存在该考试
        OtherTestExample otherTestExample=new OtherTestExample();
        otherTestExample.createCriteria().
                andTypeEqualTo(test_type).andSubjectEqualTo(otherScore.getSubjectName()).andStuIdEqualTo(Integer.parseInt(otherScore.getUserId())).andTestDateEqualTo(ts);
        List<OtherTest> otherTestList=otherTestMapper.selectByExample(otherTestExample);
        if(otherTestList.isEmpty()==false){
            return ResultTool.error("您在该日期存在该考试记录");
        }


//        添加记录
        OtherTest record=new OtherTest();
        try {
            record.setScore(Integer.parseInt(otherScore.getSubjectScore()));
            record.setStuId(Integer.parseInt(otherScore.getUserId()));
            record.setSubject(otherScore.getSubjectName());
            record.setType(test_type);
            record.setTestDate(ts);
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }

        otherTestMapper.insert(record);
        ScoreIdResponse scoreIdResponse=new ScoreIdResponse();
        scoreIdResponse.setId(record.getId().toString());
        return ResultTool.success(scoreIdResponse);

    }
    
    
    /** 
    * @Description: 成绩统计获取历史成绩接口 #32
    * @Param: [getScore] 
    * @return: com.example.demo.model.overview.Result 
    * @Author: tyq 
    * @Date:
    */ 
    @Override
    public Result getScore(String stuId,String t) {
        int studentId=Integer.parseInt(stuId);
        int type;
        try {
            type=Integer.parseInt(t);
        }catch (NumberFormatException e){
            return ResultTool.error("考试类型数学不合法");
        }
        switch (type){
            case 1:return getGreScore(studentId);
            case 2:return getGmatScore(studentId);
            case 3:return getLsat(studentId);
            case 4:return getToefl(studentId);
            case 5:return getIelts(studentId);
            case 6:return getSat1(studentId);
            case 7:return getOtherScore("SAT2",studentId);
            case 8:return getOtherScore("IB",studentId);
            case 9:return getOtherScore("AP",studentId);
            default:return ResultTool.error("不存在该类型考试");
        }
    }

    /**
    * @Description: 获得GRE成绩
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getGreScore(int studentId){
        GreExample greExample=new GreExample();
        greExample.createCriteria().andStuIdEqualTo(studentId);
        List<Gre> greList=greMapper.selectByExample(greExample);
//        if(greList.isEmpty()==true){
//            return ResultTool.error("不存在该学生的GRE考试记录");
//        }
        List<ResponseGreGmatScore> greScoreList=new LinkedList<>();
        for(Gre gre:greList){
            ResponseGreGmatScore info=new ResponseGreGmatScore();
            info.setOverAll(gre.getOverall().toString());
            info.setOverallPercentile(gre.getOverallPercentile().toString());
            info.setQuantitative(gre.getQuantitative().toString());
            info.setQuantitativePercentile(gre.getQuantitativePercentile().toString());
            info.setVerbal(gre.getVerbal().toString());
            info.setVerbalPercentile(gre.getVerbalPercentile().toString());
            info.setWriting(gre.getWriting().toString());
            info.setWritingPercentile(gre.getWritingPercentile().toString());
            info.setId(gre.getId().toString());
            info.setTestDate(gre.getTestDate().toString());
            greScoreList.add(info);

        }
        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(greScoreList);
        return ResultTool.success(scoreResponse);
    }

    /**
    * @Description: 获得gmat成绩
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getGmatScore(int studentId){
        GmatExample gmatExample=new GmatExample();
        gmatExample.createCriteria().andStuIdEqualTo(studentId);
        List<Gmat> gmatList=gmatMapper.selectByExample(gmatExample);
//        if(gmatList.isEmpty()==true){
//            return ResultTool.error("不存在该学生的GMAT考试记录");
//        }
        List<ResponseGreGmatScore> responseGreGmatScoreList=new LinkedList<>();
        for(Gmat gmat:gmatList){
            ResponseGreGmatScore info=new ResponseGreGmatScore();
            info.setTestDate(gmat.getTestDate().toString());
            info.setId(gmat.getId().toString());
            info.setOverAll(gmat.getOverall().toString());
            info.setOverallPercentile(gmat.getOverallPercentile().toString());
            info.setQuantitative(gmat.getQuantitative().toString());
            info.setQuantitativePercentile(gmat.getQuantitativePercentite().toString());
            info.setVerbal(gmat.getVerbal().toString());
            info.setVerbalPercentile(gmat.getVerbalPercentile().toString());
            info.setWriting(gmat.getWriting().toString());
            info.setWritingPercentile(gmat.getWritingPercentile().toString());
            responseGreGmatScoreList.add(info);
        }
        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(responseGreGmatScoreList);
        return ResultTool.success(scoreResponse);
    }

    /**
    * @Description: 获得lsat考试数据
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getLsat(int studentId){
//        检查考试是否存在
        LsatExample lsatExample=new LsatExample();
        lsatExample.createCriteria().andStuIdEqualTo(studentId);
        List<Lsat> lsatList=lsatMapper.selectByExample(lsatExample);
//        if(lsatList.isEmpty()==true){
//            return ResultTool.error("不存在该学生的Lsat考试记录");
//        }
//        拿出数据
        List<ResponseLsatScore> responseLsatScoreList=new LinkedList<>();
        for(Lsat lsat:lsatList){
            ResponseLsatScore info=new ResponseLsatScore();
            info.setId(lsat.getId().toString());
            info.setAnalysis(lsat.getAnalysis().toString());
            info.setAnalysisPercentile(lsat.getAnalysisPercentile().toString());
            info.setLogic(lsat.getLogic().toString());
            info.setLogicPercentile(lsat.getLogicPercentile().toString());
            info.setReading(lsat.getReading().toString());
            info.setReadingPercentile(lsat.getReadingPercentile().toString());
            info.setOverall(lsat.getOverall().toString());
            info.setOverallPercentile(lsat.getOverallPercentile().toString());
            info.setTestDate(lsat.getTestDate().toString());
            responseLsatScoreList.add(info);
        }

        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(responseLsatScoreList);
        return ResultTool.success(scoreResponse);
    }

    /**
    * @Description: 获得托福成绩
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getToefl(int studentId){
//        检查是否存在该学生的托福成绩
        ToeflExample toeflExample=new ToeflExample();
        toeflExample.createCriteria().andStuIdEqualTo(studentId);
        List<Toefl> toeflList=toeflMapper.selectByExample(toeflExample);
//        if(toeflList.isEmpty()==true){
//            return ResultTool.error("不存在该学生的托福考试记录");
//        }
        List<ResponseIeltsToeflScore> responseIeltsToeflScoreList=new LinkedList<>();
        for(Toefl toefl:toeflList){
            ResponseIeltsToeflScore info=new ResponseIeltsToeflScore();
            info.setId(toefl.getId().toString());
            info.setOverall(toefl.getOverall().toString());
            info.setListening(toefl.getListening().toString());
            info.setSpeaking(toefl.getSpeaking().toString());
            info.setReading(toefl.getReading().toString());
            info.setWriting(toefl.getWriting().toString());
            info.setTestDate(toefl.getTestDate().toString());
            responseIeltsToeflScoreList.add(info);
        }
        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(responseIeltsToeflScoreList);
        return ResultTool.success(scoreResponse);

    }

    /**
    * @Description: 获得雅思考试成绩
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getIelts(int studentId){
        ieltsExample ieltsExample=new ieltsExample();
        ieltsExample.createCriteria().andStuIdEqualTo(studentId);
        List<ielts> ieltsList=ieltsMapper.selectByExample(ieltsExample);
//        if(ieltsList.isEmpty()==true){
//            return ResultTool.error("不存在该学生的雅思考试记录");
//        }
        List<ResponseIeltsToeflScore> responseIeltsToeflScoreList=new LinkedList<>();
        for(ielts ielts:ieltsList){
            ResponseIeltsToeflScore info=new ResponseIeltsToeflScore();
            info.setId(ielts.getId().toString());
            info.setOverall(ielts.getOverall().toString());
            info.setListening(ielts.getListening().toString());
            info.setSpeaking(ielts.getSpeaking().toString());
            info.setReading(ielts.getReading().toString());
            info.setWriting(ielts.getWriting().toString());
            info.setTestDate(ielts.getTestDate().toString());
            responseIeltsToeflScoreList.add(info);
        }
        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(responseIeltsToeflScoreList);
        return ResultTool.success(scoreResponse);
    }

    /**
    * @Description: 获得学生sat1信息
    * @Param: [studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getSat1(int studentId){
        Sat1Example sat1Example=new Sat1Example();
        sat1Example.createCriteria().andStuIdEqualTo(studentId);
        List<Sat1> sat1List=sat1Mapper.selectByExample(sat1Example);
//        if(sat1List.isEmpty()==true){
//            return ResultTool.error("不存在该学生的Sat1的考试记录");
//        }
        List<ResponseSat1Score> responseSat1ScoreList=new LinkedList<>();
        for(Sat1 sat1:sat1List){
            ResponseSat1Score info=new ResponseSat1Score();
            info.setId(sat1.getId().toString());
            info.setEssay(sat1.getEssay().toString());
            info.setMath(sat1.getMath().toString());
            info.setReading(sat1.getReading().toString());
            info.setWriting(sat1.getWriting().toString());
            info.setTestDate(sat1.getTestDate().toString());
            responseSat1ScoreList.add(info);
        }
        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(responseSat1ScoreList);
        return ResultTool.success(scoreResponse);
    }

    /**
    * @Description: 获取其他考试成绩
    * @Param: [type, studentId]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result getOtherScore(String type,int studentId){
        OtherTestExample otherTestExample=new OtherTestExample();
        otherTestExample.createCriteria().andStuIdEqualTo(studentId).andTypeEqualTo(type);
        List<OtherTest> otherTestList=otherTestMapper.selectByExample(otherTestExample);
//        if(otherTestList.isEmpty()==true){
//            return ResultTool.error("不存在该学生的该类型考试记录");
//        }
        List<ResponseOtherScore> responseOtherScoreList=new LinkedList<>();
        for(OtherTest otherTest:otherTestList){
            ResponseOtherScore info=new ResponseOtherScore();
            info.setId(otherTest.getId().toString());
            info.setSubjectName(otherTest.getSubject());
            info.setSubjectScore(otherTest.getScore().toString());
            info.setTestDate(otherTest.getTestDate().toString());
            responseOtherScoreList.add(info);
        }
        ScoreResponse scoreResponse=new ScoreResponse();
        scoreResponse.setScoreList(responseOtherScoreList);
        return ResultTool.success(scoreResponse);
    }

    /**
    * @Description: 删除一个特定的成绩
    * @Param: [deleteScore]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    @Override
    public Result deleteScore(String type,String id,String stuId) {
        int t;
        try {
            t=Integer.parseInt(type);
        }catch (NumberFormatException e){
            return ResultTool.error("数据类型不合法");
        }
        if(t>9){
            return ResultTool.error("不存在考试类型");
        }
        int target=Integer.parseInt(id);
        int studentId=Integer.parseInt(stuId);
        switch (t){
            case 1:return deleteGreScore(target,studentId);
            case 2:return deleteGmatScore(target,studentId);
            case 3:return deleteLsatScore(target,studentId);
            case 4:return deleteToeflScore(target,studentId);
            case 5:return deletIelts(target,studentId);
            case 6:return deleteSat1(target,studentId);
            default:return deleteOther(target,studentId);

        }
    }

    /**
    * @Description: 删除GRE成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deleteGreScore(int id,int studentId){
//        检查该记录是否存在
        GreExample check=new GreExample();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<Gre> checkList=greMapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }
        try {
            GreExample greExample=new GreExample();
            greExample.createCriteria().andIdEqualTo(id).andStuIdEqualTo(studentId);
            greMapper.deleteByExample(greExample);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();

    }

    /**
    * @Description: 删除Gmat成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deleteGmatScore(int id,int studentId){
        GmatExample check=new GmatExample();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<Gmat> checkList=gmatMapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }

        try {
            GmatExample gmatExample=new GmatExample();
            gmatExample.createCriteria().andIdEqualTo(id).andStuIdEqualTo(studentId);
            gmatMapper.deleteByExample(gmatExample);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();
    }

    /**
    * @Description: 删除lsat成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deleteLsatScore(int id,int studentId){
        LsatExample check=new LsatExample();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<Lsat> checkList=lsatMapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }
        try {
            LsatExample lsatExample=new LsatExample();
            lsatExample.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
            lsatMapper.deleteByExample(lsatExample);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();
    }

    /**
    * @Description: 删除托福成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deleteToeflScore(int id,int studentId){
        ToeflExample check=new ToeflExample();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<Toefl> checkList=toeflMapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }
        try {
            ToeflExample toeflExample=new ToeflExample();
            toeflExample.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
            toeflMapper.deleteByExample(toeflExample);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();
    }

    /**
    * @Description: 删除雅思成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deletIelts(int id,int studentId){
        ieltsExample check=new ieltsExample();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<ielts> checkList=ieltsMapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }
        try {
            ieltsExample ieltsExample=new ieltsExample();
            ieltsExample.createCriteria().andIdEqualTo(id).andStuIdEqualTo(studentId);
            ieltsMapper.selectByExample(ieltsExample);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();
    }

    /**
    * @Description: 删除sat成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deleteSat1(int id,int studentId){
        Sat1Example check=new Sat1Example();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<Sat1> checkList=sat1Mapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }
        try {
            Sat1Example sat1Example=new Sat1Example();
            sat1Example.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
            sat1Mapper.deleteByExample(sat1Example);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();
    }

    /**
    * @Description: 删除其他成绩
    * @Param: [id]
    * @return: com.example.demo.model.overview.Result
    * @Author: tyq
    * @Date:
    */
    private Result deleteOther(int id, int studentId){
        OtherTestExample check=new OtherTestExample();
        check.createCriteria().andStuIdEqualTo(studentId).andIdEqualTo(id);
        List<OtherTest> checkList=otherTestMapper.selectByExample(check);
        if(checkList.isEmpty()==true){
            return ResultTool.error("不存在该记录");
        }
        try {
            OtherTestExample otherTestExample=new OtherTestExample();
            otherTestExample.createCriteria().andIdEqualTo(id).andStuIdEqualTo(studentId);
            otherTestMapper.deleteByExample(otherTestExample);
        }catch (Exception e){
            return ResultTool.error("删除异常");
        }
        return ResultTool.success();
    }


}
