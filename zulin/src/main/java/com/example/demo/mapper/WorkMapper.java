package com.example.demo.mapper;

import com.example.demo.entity.Work;
import com.example.demo.entity.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {

    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer workid);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Integer workid);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}