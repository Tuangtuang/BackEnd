package com.example.demo.dao;

import com.example.demo.model.databaseResponse.ChatName;
import com.example.demo.model.entity.PsCommunication;
import com.example.demo.model.entity.PsCommunicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsCommunicationMapper {
    int countByExample(PsCommunicationExample example);

    int deleteByExample(PsCommunicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PsCommunication record);

    int insertSelective(PsCommunication record);

    List<PsCommunication> selectByExampleWithBLOBs(PsCommunicationExample example);

    List<PsCommunication> selectByExample(PsCommunicationExample example);

    PsCommunication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PsCommunication record, @Param("example") PsCommunicationExample example);

    int updateByExampleWithBLOBs(@Param("record") PsCommunication record, @Param("example") PsCommunicationExample example);

    int updateByExample(@Param("record") PsCommunication record, @Param("example") PsCommunicationExample example);

    int updateByPrimaryKeySelective(PsCommunication record);

    int updateByPrimaryKeyWithBLOBs(PsCommunication record);

    int updateByPrimaryKey(PsCommunication record);

    List<ChatName> getPSChatInfoTeacher(int versionId);

    List<ChatName> getPSChatInfoStudent(int versionId);

    int deleteByStudentId(Integer studentId);
}