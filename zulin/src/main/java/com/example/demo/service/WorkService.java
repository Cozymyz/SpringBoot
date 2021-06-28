package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.Work;
import com.example.demo.entity.WorkExample;
import com.example.demo.mapper.WorkMapper;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {

    @Resource
    private WorkMapper workMapper;

    public Work getWorkInfo(int workId) {
        return workMapper.selectByPrimaryKey(workId);
    }


    public List<Integer> getUserWork(int userId) {
        WorkExample example=new WorkExample();
        WorkExample.Criteria criteria=example.createCriteria();
        criteria.andUseidEqualTo(userId);
        List<Work> works=workMapper.selectByExample(example);

        List<Integer> w=new ArrayList<>();
        for(Work w1:works){
            w.add(w1.getWorkid());
        }
        return w;
    }

    public Work getUserNewWork(int userId) {
        WorkExample example=new WorkExample();
        WorkExample.Criteria criteria=example.createCriteria();
        criteria.andUseidEqualTo(userId);
        criteria.andIsendEqualTo(0);
        List<Work> works=workMapper.selectByExample(example);
        return  works.get(works.size()-1);
    }

    public void insert(Work work) {
        workMapper.insertSelective(work);
    }

    public void update(Work work) {
        workMapper.updateByPrimaryKeySelective(work);
    }

    public List<Integer> getUsersWork(List<User> users) {
        List<Integer> ids=new ArrayList<>();
        for(User u:users){
            Work work=getUserNewWork(u.getId());
            ids.add(work.getWorkid());
        }

        return ids;
    }
}
