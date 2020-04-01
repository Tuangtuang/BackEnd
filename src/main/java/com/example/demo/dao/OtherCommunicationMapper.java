package com.example.demo.dao;

import com.example.demo.model.databaseResponse.ChatName;
import com.example.demo.model.entity.OtherCommunication;
import com.example.demo.model.entity.OtherCommunicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherCommunicationMapper {
    int countByExample(OtherCommunicationExample example);

    int deleteByExample(OtherCommunicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OtherCommunication record);

    int insertSelective(OtherCommunication record);

    List<OtherCommunication> selectByExampleWithBLOBs(OtherCommunicationExample example);

    List<OtherCommunication> selectByExample(OtherCommunicationExample example);

    OtherCommunication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OtherCommunication record, @Param("example") OtherCommunicationExample example);

    int updateByExampleWithBLOBs(@Param("record") OtherCommunication record, @Param("example") OtherCommunicationExample example);

    int updateByExample(@Param("record") OtherCommunication record, @Param("example") OtherCommunicationExample example);

    int updateByPrimaryKeySelective(OtherCommunication record);

    int updateByPrimaryKeyWithBLOBs(OtherCommunication record);

    int updateByPrimaryKey(OtherCommunication record);

    List<ChatName> getTeacherName(Integer versionId);

    List<ChatName> getStudentName(Integer versionId);

    int deleteByStudent(Integer studentId);

}