package com.example.demo.dao;

import com.example.demo.model.entity.Task;
import com.example.demo.model.entity.TaskExample;
import com.example.demo.model.entity.TaskWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    int countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskWithBLOBs record);

    int insertSelective(TaskWithBLOBs record);

    List<TaskWithBLOBs> selectByExampleWithBLOBs(TaskExample example);

    List<Task> selectByExample(TaskExample example);

    TaskWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskWithBLOBs record, @Param("example") TaskExample example);

    int updateByExampleWithBLOBs(@Param("record") TaskWithBLOBs record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(TaskWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TaskWithBLOBs record);

    int updateByPrimaryKey(Task record);

    int deleteByStudentId(Integer studentId);
}