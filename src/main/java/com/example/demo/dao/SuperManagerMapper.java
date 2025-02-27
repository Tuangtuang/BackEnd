package com.example.demo.dao;

import com.example.demo.model.entity.SuperManager;
import com.example.demo.model.entity.SuperManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuperManagerMapper {
    int countByExample(SuperManagerExample example);

    int deleteByExample(SuperManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SuperManager record);

    int insertSelective(SuperManager record);

    List<SuperManager> selectByExample(SuperManagerExample example);

    SuperManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SuperManager record, @Param("example") SuperManagerExample example);

    int updateByExample(@Param("record") SuperManager record, @Param("example") SuperManagerExample example);

    int updateByPrimaryKeySelective(SuperManager record);

    int updateByPrimaryKey(SuperManager record);
}