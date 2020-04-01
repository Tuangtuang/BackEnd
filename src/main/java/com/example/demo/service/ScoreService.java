package com.example.demo.service;

import com.example.demo.model.overview.Result;
import com.example.demo.model.score.*;

public interface ScoreService {

//    成绩统计添加GRE历史成绩接口 #36
    Result addGre(GreScore greScore);

//    成绩统计添加GMAT历史成绩接口 #37
    Result addGmat(GreScore greScore);

//    成绩统计添加TOEFL历史成绩接口 #39
    Result addToefl(ToeflAndIeltsScore toeflAndIeltsScore);

//    成绩统计添加TOEFL历史成绩接口 #39
    Result addIelts(ToeflAndIeltsScore toeflAndIeltsScore);

//    成绩统计添加LSAT历史成绩接口 #54
    Result addLsat(LsatScore lsatScore);

//    成绩统计添加SAT1历史成绩接口 #55
    Result addSat1(Sat1Score sat1Score);

//    成绩统计添加OTHER历史成绩接口 #56
    Result addOther(OtherScore otherScore);

//    成绩统计获取历史成绩接口 #32
    Result getScore(String stuId,String t);

//    成绩统计删除历史成绩接口 #49
    Result deleteScore(String type,String id,String stuId);

}
