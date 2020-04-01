package com.example.demo.dao;

import com.example.demo.model.databaseResponse.DetailVersionInfo;
import com.example.demo.model.entity.Cv;
import com.example.demo.model.entity.CvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CvMapper {
    int countByExample(CvExample example);

    int deleteByExample(CvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cv record);

    int insertSelective(Cv record);

    List<Cv> selectByExampleWithBLOBs(CvExample example);

    List<Cv> selectByExample(CvExample example);

    Cv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cv record, @Param("example") CvExample example);

    int updateByExampleWithBLOBs(@Param("record") Cv record, @Param("example") CvExample example);

    int updateByExample(@Param("record") Cv record, @Param("example") CvExample example);

    int updateByPrimaryKeySelective(Cv record);

    int updateByPrimaryKeyWithBLOBs(Cv record);

    int updateByPrimaryKey(Cv record);

    int getMaxVersionByStudentId(Integer studentId);

//    List<DetailVersionInfo> getVersionInfoCv(Integer studentId);
}