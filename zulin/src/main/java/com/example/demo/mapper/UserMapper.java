package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    String getPassword(String username);

    String getPasswordByphone(String userphone);

    String getPasswordByemail(String useremail);

    int checkUserBanStatus(String username);

    String getRole(String username);

    String getRolePermission(String username);

    String getPermission(String username);

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    List<User> getPageUser(int no, int pageSize);
}