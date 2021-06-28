package com.example.demo.mapper;

import com.example.demo.entity.Event;
import com.example.demo.entity.EventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventMapper {
    long countByExample(EventExample example);

    int deleteByExample(EventExample example);

    int deleteByPrimaryKey(Integer eventid);

    int insert(Event record);

    int insertSelective(Event record);

    List<Event> selectByExample(EventExample example);

    Event selectByPrimaryKey(Integer eventid);

    int updateByExampleSelective(@Param("record") Event record, @Param("example") EventExample example);

    int updateByExample(@Param("record") Event record, @Param("example") EventExample example);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);
}