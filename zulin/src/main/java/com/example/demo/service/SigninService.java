package com.example.demo.service;

import com.example.demo.entity.Signin;
import com.example.demo.entity.SigninExample;
import com.example.demo.entity.Work;
import com.example.demo.mapper.SigninMapper;
import com.example.demo.util.GetTimeNow;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class SigninService {

    @Resource
    private SigninMapper signinMapper;
    @Resource
    private WorkService workService;

    public List<Signin> getWorkSignIn(int workId) {
        SigninExample example=new SigninExample();
        SigninExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidEqualTo(workId);
        return signinMapper.selectByExample(example);
    }

    public List<Signin> getUserSignIn(int userId) {
        List<Integer> works=workService.getUserWork(userId);

        SigninExample example=new SigninExample();
        SigninExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidIn(works);
        return signinMapper.selectByExample(example);
    }

    public int getAttend(int userId) {
        List<Integer> works=workService.getUserWork(userId);

        SigninExample example=new SigninExample();
        SigninExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidIn(works);
        criteria.andAttendEqualTo(1);
        return signinMapper.selectByExample(example).size();
    }

    public Signin findTodaySignIn(int workId) {
        SigninExample example=new SigninExample();
        SigninExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidEqualTo(workId);
        int y= GetTimeNow.getYear();
        int m=GetTimeNow.getMonth();
        int d=GetTimeNow.getDay();
        String today=y+"-"+m+"-"+d;
        criteria.andDaytimeEqualTo(today);
        return  signinMapper.selectByExample(example).get(0);
    }

    public void update(Signin signin) {
        signinMapper.updateByPrimaryKeySelective(signin);
    }

    public void insert(Signin signin) {
        signinMapper.insertSelective(signin);
    }

    public List<Signin> seleteTodaySignIn(String today, int workId) {
        SigninExample example=new SigninExample();
        SigninExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidEqualTo(workId);
        criteria.andDaytimeEqualTo(today);
        return  signinMapper.selectByExample(example);
    }

    public List<Signin> seleteNotSignIn(String today, List<Integer> workId) {
        SigninExample example=new SigninExample();
        SigninExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidIn(workId);
        criteria.andDaytimeEqualTo(today);
        criteria.andAttendEqualTo(0);
        return  signinMapper.selectByExample(example);
    }
}
