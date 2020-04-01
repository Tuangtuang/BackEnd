package com.example.demo.dao;

import com.example.demo.model.entity.OtherTest;
import com.example.demo.model.entity.OtherTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherTestMapper {
    int countByExample(OtherTestExample example);

    int deleteByExample(OtherTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OtherTest record);

    int insertSelective(OtherTest record);

    List<OtherTest> selectByExample(OtherTestExample example);

    OtherTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OtherTest record, @Param("example") OtherTestExample example);

    int updateByExample(@Param("record") OtherTest record, @Param("example") OtherTestExample example);

    int updateByPrimaryKeySelective(OtherTest record);

    int updateByPrimaryKey(OtherTest record);
}