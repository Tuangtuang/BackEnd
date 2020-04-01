package com.example.demo.dao;

import com.example.demo.model.databaseResponse.ChatName;
import com.example.demo.model.entity.CvCommunication;
import com.example.demo.model.entity.CvCommunicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CvCommunicationMapper {
    int countByExample(CvCommunicationExample example);

    int deleteByExample(CvCommunicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CvCommunication record);

    int insertSelective(CvCommunication record);

    List<CvCommunication> selectByExampleWithBLOBs(CvCommunicationExample example);

    List<CvCommunication> selectByExample(CvCommunicationExample example);

    CvCommunication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CvCommunication record, @Param("example") CvCommunicationExample example);

    int updateByExampleWithBLOBs(@Param("record") CvCommunication record, @Param("example") CvCommunicationExample example);

    int updateByExample(@Param("record") CvCommunication record, @Param("example") CvCommunicationExample example);

    int updateByPrimaryKeySelective(CvCommunication record);

    int updateByPrimaryKeyWithBLOBs(CvCommunication record);

    int updateByPrimaryKey(CvCommunication record);

    List<ChatName> getTeacherCvChatInfo(Integer cvId);

    List<ChatName> getStudentCvChatInfo(Integer cvId);

    int deleteStudentChat(Integer studentId);

}