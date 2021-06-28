package com.example.demo.mapper;

import com.example.demo.entity.Signin;
import com.example.demo.entity.SigninExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SigninMapper {
    long countByExample(SigninExample example);

    int deleteByExample(SigninExample example);

    int deleteByPrimaryKey(Integer signinid);

    int insert(Signin record);

    int insertSelective(Signin record);

    List<Signin> selectByExample(SigninExample example);

    Signin selectByPrimaryKey(Integer signinid);

    int updateByExampleSelective(@Param("record") Signin record, @Param("example") SigninExample example);

    int updateByExample(@Param("record") Signin record, @Param("example") SigninExample example);

    int updateByPrimaryKeySelective(Signin record);

    int updateByPrimaryKey(Signin record);
}