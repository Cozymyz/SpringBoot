package com.example.demo.service;

import com.example.demo.entity.Achieve;
import com.example.demo.entity.AchieveExample;
import com.example.demo.entity.Apply;
import com.example.demo.mapper.AchieveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchieveService {
    @Autowired
    private AchieveMapper achieveMapper;


    public List<Achieve> getWorkAchieve(int workId) {
        AchieveExample example=new AchieveExample();
        AchieveExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidEqualTo(workId);
        return achieveMapper.selectByExample(example);
    }


    public void insert(Achieve achieve) {
        achieveMapper.insertSelective(achieve);
    }

    public Achieve getAchieve(int achieveId) {
        return achieveMapper.selectByPrimaryKey(achieveId);
    }

    public void update(Achieve achieve) {
        achieveMapper.updateByPrimaryKey(achieve);
    }
}
