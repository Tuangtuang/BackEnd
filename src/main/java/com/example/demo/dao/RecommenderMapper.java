package com.example.demo.dao;

import com.example.demo.model.databaseResponse.DetailVersionInfo;
import com.example.demo.model.entity.Recommender;
import com.example.demo.model.entity.RecommenderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommenderMapper {
    int countByExample(RecommenderExample example);

    int deleteByExample(RecommenderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recommender record);

    int insertSelective(Recommender record);

    List<Recommender> selectByExample(RecommenderExample example);

    Recommender selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recommender record, @Param("example") RecommenderExample example);

    int updateByExample(@Param("record") Recommender record, @Param("example") RecommenderExample example);

    int updateByPrimaryKeySelective(Recommender record);

    int updateByPrimaryKey(Recommender record);

    List<DetailVersionInfo> getVerisonInfoReco(Integer recommenderId);
}