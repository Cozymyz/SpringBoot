package com.example.demo.mapper;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TaskMapper {

    @Select("select taskId from task,achieve where  " +
            "  achieve.workId = #{workId} and task.achieveId = achieve.achieveId and task.subLine = null")
    List<Integer> getUnfinishTask(int workId);

    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer taskid);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer taskid);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

}