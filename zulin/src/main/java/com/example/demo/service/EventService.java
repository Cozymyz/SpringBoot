package com.example.demo.service;

import com.example.demo.entity.Event;
import com.example.demo.entity.EventExample;
import com.example.demo.mapper.EventMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventService {
    @Resource
    private EventMapper eventMapper;

    public List<Event> getWorkEvent(int workId) {
        EventExample example=new EventExample();
        EventExample.Criteria criteria=example.createCriteria();
        criteria.andWorkidEqualTo(workId);
        return eventMapper.selectByExample(example);
    }

    public void insert(Event event) {
        eventMapper.insertSelective(event);
    }
}
