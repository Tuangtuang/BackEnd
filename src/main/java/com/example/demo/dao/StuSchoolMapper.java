package com.example.demo.dao;

import com.example.demo.model.databaseResponse.SchoolNameInfo;
import com.example.demo.model.entity.StuSchool;
import com.example.demo.model.entity.StuSchoolExample;
import java.util.List;

//import com.example.demo.model.entity.StudentSchoolMulti;
import org.apache.ibatis.annotations.Param;

public interface StuSchoolMapper {
    int countByExample(StuSchoolExample example);

    int deleteByExample(StuSchoolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuSchool record);

    int insertSelective(StuSchool record);

    List<StuSchool> selectByExampleWithBLOBs(StuSchoolExample example);

    List<StuSchool> selectByExample(StuSchoolExample example);

    StuSchool selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuSchool record, @Param("example") StuSchoolExample example);

    int updateByExampleWithBLOBs(@Param("record") StuSchool record, @Param("example") StuSchoolExample example);

    int updateByExample(@Param("record") StuSchool record, @Param("example") StuSchoolExample example);

    int updateByPrimaryKeySelective(StuSchool record);

    int updateByPrimaryKeyWithBLOBs(StuSchool record);

    int updateByPrimaryKey(StuSchool record);

    List<SchoolNameInfo> stuLockedStudentSchoolInfo(Integer userId);

    List<SchoolNameInfo> stuUnlockedStudentSchoolInfo(Integer userId);

}