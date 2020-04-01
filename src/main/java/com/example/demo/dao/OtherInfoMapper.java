package com.example.demo.dao;

import com.example.demo.model.entity.OtherInfo;
import com.example.demo.model.entity.OtherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherInfoMapper {
    int countByExample(OtherInfoExample example);

    int deleteByExample(OtherInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OtherInfo record);

    int insertSelective(OtherInfo record);

    List<OtherInfo> selectByExample(OtherInfoExample example);

    OtherInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OtherInfo record, @Param("example") OtherInfoExample example);

    int updateByExample(@Param("record") OtherInfo record, @Param("example") OtherInfoExample example);

    int updateByPrimaryKeySelective(OtherInfo record);

    int updateByPrimaryKey(OtherInfo record);
}