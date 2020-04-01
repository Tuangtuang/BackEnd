package com.example.demo.dao;

import com.example.demo.model.databaseResponse.DetailVersionInfo;
import com.example.demo.model.entity.StuSchoolPs;
import com.example.demo.model.entity.StuSchoolPsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuSchoolPsMapper {
    int countByExample(StuSchoolPsExample example);

    int deleteByExample(StuSchoolPsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuSchoolPs record);

    int insertSelective(StuSchoolPs record);

    List<StuSchoolPs> selectByExampleWithBLOBs(StuSchoolPsExample example);

    List<StuSchoolPs> selectByExample(StuSchoolPsExample example);

    StuSchoolPs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuSchoolPs record, @Param("example") StuSchoolPsExample example);

    int updateByExampleWithBLOBs(@Param("record") StuSchoolPs record, @Param("example") StuSchoolPsExample example);

    int updateByExample(@Param("record") StuSchoolPs record, @Param("example") StuSchoolPsExample example);

    int updateByPrimaryKeySelective(StuSchoolPs record);

    int updateByPrimaryKeyWithBLOBs(StuSchoolPs record);

    int updateByPrimaryKey(StuSchoolPs record);

    int getMaxVersion(Integer stuSchoolId);

    List<DetailVersionInfo> getVersionInfo(Integer studentSchoolId);

    int deleteByStudentId(Integer studentId);
}