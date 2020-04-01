package com.example.demo.dao;

import com.example.demo.model.databaseResponse.DetailVersionInfo;
import com.example.demo.model.entity.StuSchoolOther;
import com.example.demo.model.entity.StuSchoolOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuSchoolOtherMapper {
    int countByExample(StuSchoolOtherExample example);

    int deleteByExample(StuSchoolOtherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuSchoolOther record);

    int insertSelective(StuSchoolOther record);

    List<StuSchoolOther> selectByExampleWithBLOBs(StuSchoolOtherExample example);

    List<StuSchoolOther> selectByExample(StuSchoolOtherExample example);

    StuSchoolOther selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuSchoolOther record, @Param("example") StuSchoolOtherExample example);

    int updateByExampleWithBLOBs(@Param("record") StuSchoolOther record, @Param("example") StuSchoolOtherExample example);

    int updateByExample(@Param("record") StuSchoolOther record, @Param("example") StuSchoolOtherExample example);

    int updateByPrimaryKeySelective(StuSchoolOther record);

    int updateByPrimaryKeyWithBLOBs(StuSchoolOther record);

    int updateByPrimaryKey(StuSchoolOther record);

    int getMaxVersion(int stuStudentId);

    List<DetailVersionInfo> getVersionInfo(int stuSchoolId);

    int deleteByStudentId(Integer studentId);
}