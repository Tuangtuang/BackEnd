package com.example.demo.dao;

import com.example.demo.model.databaseResponse.SchoolApplyInfo;
import com.example.demo.model.databaseResponse.TeacherStudentName;
import com.example.demo.model.databaseResponse.TeacherStudentNameInfo;
import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.StudentExample;
import java.util.List;

import com.example.demo.model.school.ApplyStateItem;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExampleWithBLOBs(StudentExample example);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExampleWithBLOBs(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);

    List<SchoolApplyInfo> getItem(Integer userId);

    List<TeacherStudentName> searchTeacherStudentRelationship(Integer teacherId, String studentName);

    List<TeacherStudentName> searchTeacherStudentRelationship2(Integer teacherId);


}