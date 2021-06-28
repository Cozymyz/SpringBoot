package com.example.demo.service;

import com.example.demo.entity.Apply;
import com.example.demo.entity.ApplyExample;
import com.example.demo.mapper.ApplyMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyService {
    @Resource
    private ApplyMapper applyMapper;
    @Resource
    private UserMapper userMapper;

    public void insert(Apply apply) {
        applyMapper.insertSelective(apply);
    }

    public List<Apply> getUserApply(int userId, int i) {
        ApplyExample example=new ApplyExample();
        ApplyExample.Criteria criteria=example.createCriteria();
        criteria.andApplytypeEqualTo(i);
        criteria.andUseridEqualTo(userId);
        List<Apply> applies= applyMapper.selectByExample(example);
        for(Apply apply:applies){
            apply.setUser(userMapper.selectByPrimaryKey(apply.getUserid()));
        }
        return applies;
    }

    public List<Apply> getCompanyApply(int comId, int i) {
        ApplyExample example=new ApplyExample();
        ApplyExample.Criteria criteria=example.createCriteria();
        criteria.andApplytypeEqualTo(i);
        criteria.andCompanyidEqualTo(comId);
        criteria.andIsacceptEqualTo(0);
        return applyMapper.selectByExample(example);
    }

    public Apply getApply(int applyId) {
        return  applyMapper.selectByPrimaryKey(applyId);
    }

    public void update(Apply apply) {
        applyMapper.updateByPrimaryKeySelective(apply) ;
    }
}
