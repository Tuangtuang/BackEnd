package com.example.demo.dao;

import com.example.demo.model.databaseResponse.*;
import com.example.demo.model.entity.TeacherStudent;
import com.example.demo.model.entity.TeacherStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherStudentMapper {
    int countByExample(TeacherStudentExample example);

    int deleteByExample(TeacherStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherStudent record);

    int insertSelective(TeacherStudent record);

    List<TeacherStudent> selectByExample(TeacherStudentExample example);

    TeacherStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherStudent record, @Param("example") TeacherStudentExample example);

    int updateByExample(@Param("record") TeacherStudent record, @Param("example") TeacherStudentExample example);

    int updateByPrimaryKeySelective(TeacherStudent record);

    int updateByPrimaryKey(TeacherStudent record);

    List<MyStudentInfo> getStudentList(Integer teacherId);


    List<TeacherStudentName> searchTeacherStudentName(String studentName,Integer teacherId);


    List<TeacherStudentNameInfo> getRelationship(Integer teacherId);

    List<TeacherStudentTeacherNameInfo> getRelationshipByStudent(Integer studentId);


    SearchStudentByTeacher teacherSearchStudentById(Integer studentId,Integer teacherId);

    List<SearchStudentByTeacher> teacherSearchByName(String studentName, Integer teacherId);

    List<SearchStudentByTeacher> getAllByTeacher(Integer teacherId);
}