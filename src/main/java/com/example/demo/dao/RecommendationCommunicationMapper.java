package com.example.demo.dao;

import com.example.demo.model.databaseResponse.ChatName;
import com.example.demo.model.entity.RecommendationCommunication;
import com.example.demo.model.entity.RecommendationCommunicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendationCommunicationMapper {
    int countByExample(RecommendationCommunicationExample example);

    int deleteByExample(RecommendationCommunicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RecommendationCommunication record);

    int insertSelective(RecommendationCommunication record);

    List<RecommendationCommunication> selectByExampleWithBLOBs(RecommendationCommunicationExample example);

    List<RecommendationCommunication> selectByExample(RecommendationCommunicationExample example);

    RecommendationCommunication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RecommendationCommunication record, @Param("example") RecommendationCommunicationExample example);

    int updateByExampleWithBLOBs(@Param("record") RecommendationCommunication record, @Param("example") RecommendationCommunicationExample example);

    int updateByExample(@Param("record") RecommendationCommunication record, @Param("example") RecommendationCommunicationExample example);

    int updateByPrimaryKeySelective(RecommendationCommunication record);

    int updateByPrimaryKeyWithBLOBs(RecommendationCommunication record);

    int updateByPrimaryKey(RecommendationCommunication record);

    List<ChatName> getTeacherChatInfo(int versionId);

    List<ChatName> getStudentChatInfo(int versionId);


    int deleteByStudentId(Integer studentId);

}