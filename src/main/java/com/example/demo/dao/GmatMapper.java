package com.example.demo.dao;

import com.example.demo.model.entity.Gmat;
import com.example.demo.model.entity.GmatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GmatMapper {
    int countByExample(GmatExample example);

    int deleteByExample(GmatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gmat record);

    int insertSelective(Gmat record);

    List<Gmat> selectByExample(GmatExample example);

    Gmat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gmat record, @Param("example") GmatExample example);

    int updateByExample(@Param("record") Gmat record, @Param("example") GmatExample example);

    int updateByPrimaryKeySelective(Gmat record);

    int updateByPrimaryKey(Gmat record);
}