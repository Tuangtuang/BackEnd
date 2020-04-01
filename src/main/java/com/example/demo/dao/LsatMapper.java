package com.example.demo.dao;

import com.example.demo.model.entity.Lsat;
import com.example.demo.model.entity.LsatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LsatMapper {
    int countByExample(LsatExample example);

    int deleteByExample(LsatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lsat record);

    int insertSelective(Lsat record);

    List<Lsat> selectByExample(LsatExample example);

    Lsat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lsat record, @Param("example") LsatExample example);

    int updateByExample(@Param("record") Lsat record, @Param("example") LsatExample example);

    int updateByPrimaryKeySelective(Lsat record);

    int updateByPrimaryKey(Lsat record);
}