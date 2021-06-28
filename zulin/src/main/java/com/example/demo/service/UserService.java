package com.example.demo.service;



import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import com.example.demo.entity.Work;
import com.example.demo.entity.WorkExample;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.WorkMapper;
import com.example.demo.util.Msg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private WorkMapper workMapper;
    @Resource
    private CompanyMapper companyMapper;

    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }
    public String getPasswordByphone(String userphone) {
        System.out.println("rr+"+userphone);
        return userMapper.getPasswordByphone(userphone);
    }
    public String getPasswordByemail(String useremail) {
        return userMapper.getPasswordByemail(useremail);
    }

    public int checkUserBanStatus(String username) {
        return userMapper.checkUserBanStatus(username);
    }

    public String getRole(String username) {
        return userMapper.getRole(username);
    }

    public String getRolePermission(String username) {
        return userMapper.getRolePermission(username);
    }

    public String getPermission(String username) {
        return userMapper.getPermission(username);
    }


    public User getUserInfo(int userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        return  user;
    }

    public List<Work> getSelfWork(int userId) {
        WorkExample example=new WorkExample();
        WorkExample.Criteria criteria=example.createCriteria();
        criteria.andUseidEqualTo(userId);

        List<Work> works= workMapper.selectByExample(example);
        for(Work w:works){
            w.setUser(userMapper.selectByPrimaryKey(w.getUseid()));
            w.setHrName(userMapper.selectByPrimaryKey(w.getHrid()).getUsername());
            w.setCompanyName(companyMapper.selectByPrimaryKey(w.getCompanyid()).getCompanyname());
        }

        return  works;
    }

    public void insert(User user) {
        userMapper.insertSelective(user);
    }

    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> searchPhone(String phone) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        return userMapper.selectByExample(example);
    }

    public List<User> searchEmail(String email) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(example);
    }

    public List<User> searchIdentity(String identity) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andIdentityEqualTo(identity);
        return userMapper.selectByExample(example);
    }

    public List<User> searchUserName(String userName) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        return userMapper.selectByExample(example);
    }

    public List<User> allUser() {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        return userMapper.selectByExample(example);
    }

    public List<User> getPageUser(int no, int pageSize) {
        return userMapper.getPageUser(no,pageSize);
    }
}