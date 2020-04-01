package com.example.demo.dao;

import com.example.demo.model.entity.ielts;
import com.example.demo.model.entity.ieltsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ieltsMapper {
    int countByExample(ieltsExample example);

    int deleteByExample(ieltsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ielts record);

    int insertSelective(ielts record);

    List<ielts> selectByExample(ieltsExample example);

    ielts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ielts record, @Param("example") ieltsExample example);

    int updateByExample(@Param("record") ielts record, @Param("example") ieltsExample example);

    int updateByPrimaryKeySelective(ielts record);

    int updateByPrimaryKey(ielts record);
}