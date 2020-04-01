package com.example.demo.dao;

import com.example.demo.model.databaseResponse.DetailVersionInfo;
import com.example.demo.model.entity.Recommendation;
import com.example.demo.model.entity.RecommendationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendationMapper {
    int countByExample(RecommendationExample example);

    int deleteByExample(RecommendationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recommendation record);

    int insertSelective(Recommendation record);

    List<Recommendation> selectByExampleWithBLOBs(RecommendationExample example);

    List<Recommendation> selectByExample(RecommendationExample example);

    Recommendation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recommendation record, @Param("example") RecommendationExample example);

    int updateByExampleWithBLOBs(@Param("record") Recommendation record, @Param("example") RecommendationExample example);

    int updateByExample(@Param("record") Recommendation record, @Param("example") RecommendationExample example);

    int updateByPrimaryKeySelective(Recommendation record);

    int updateByPrimaryKeyWithBLOBs(Recommendation record);

    int updateByPrimaryKey(Recommendation record);

    int getMaxVersion(@Param("studentId")int studentId,@Param("recommenderId")int recommenderId);

    List<DetailVersionInfo> getVerisonInfoReco(Integer recommenderId);
}