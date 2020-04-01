package com.example.demo.dao;

import com.example.demo.model.entity.Toefl;
import com.example.demo.model.entity.ToeflExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ToeflMapper {
    int countByExample(ToeflExample example);

    int deleteByExample(ToeflExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Toefl record);

    int insertSelective(Toefl record);

    List<Toefl> selectByExample(ToeflExample example);

    Toefl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Toefl record, @Param("example") ToeflExample example);

    int updateByExample(@Param("record") Toefl record, @Param("example") ToeflExample example);

    int updateByPrimaryKeySelective(Toefl record);

    int updateByPrimaryKey(Toefl record);
}