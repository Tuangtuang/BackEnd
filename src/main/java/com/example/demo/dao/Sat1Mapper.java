package com.example.demo.dao;

import com.example.demo.model.entity.Sat1;
import com.example.demo.model.entity.Sat1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sat1Mapper {
    int countByExample(Sat1Example example);

    int deleteByExample(Sat1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sat1 record);

    int insertSelective(Sat1 record);

    List<Sat1> selectByExample(Sat1Example example);

    Sat1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sat1 record, @Param("example") Sat1Example example);

    int updateByExample(@Param("record") Sat1 record, @Param("example") Sat1Example example);

    int updateByPrimaryKeySelective(Sat1 record);

    int updateByPrimaryKey(Sat1 record);
}