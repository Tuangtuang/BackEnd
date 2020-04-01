package com.example.demo.dao;

import com.example.demo.model.entity.Gre;
import com.example.demo.model.entity.GreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GreMapper {
    int countByExample(GreExample example);

    int deleteByExample(GreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gre record);

    int insertSelective(Gre record);

    List<Gre> selectByExample(GreExample example);

    Gre selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gre record, @Param("example") GreExample example);

    int updateByExample(@Param("record") Gre record, @Param("example") GreExample example);

    int updateByPrimaryKeySelective(Gre record);

    int updateByPrimaryKey(Gre record);
}