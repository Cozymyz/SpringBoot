package com.example.demo.mapper;

import com.example.demo.entity.Achieve;
import com.example.demo.entity.AchieveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AchieveMapper {
    long countByExample(AchieveExample example);

    int deleteByExample(AchieveExample example);

    int deleteByPrimaryKey(Integer achieveid);

    int insert(Achieve record);

    int insertSelective(Achieve record);

    List<Achieve> selectByExample(AchieveExample example);

    Achieve selectByPrimaryKey(Integer achieveid);

    int updateByExampleSelective(@Param("record") Achieve record, @Param("example") AchieveExample example);

    int updateByExample(@Param("record") Achieve record, @Param("example") AchieveExample example);

    int updateByPrimaryKeySelective(Achieve record);

    int updateByPrimaryKey(Achieve record);
}