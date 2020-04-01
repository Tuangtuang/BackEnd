package com.example.demo.dao;

import com.example.demo.model.entity.Outsider;
import com.example.demo.model.entity.OutsiderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutsiderMapper {
    int countByExample(OutsiderExample example);

    int deleteByExample(OutsiderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Outsider record);

    int insertSelective(Outsider record);

    List<Outsider> selectByExample(OutsiderExample example);

    Outsider selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Outsider record, @Param("example") OutsiderExample example);

    int updateByExample(@Param("record") Outsider record, @Param("example") OutsiderExample example);

    int updateByPrimaryKeySelective(Outsider record);

    int updateByPrimaryKey(Outsider record);
}