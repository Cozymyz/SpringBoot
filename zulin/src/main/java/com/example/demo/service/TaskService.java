package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskExample;
import com.example.demo.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;

    public List<Task> getAchieveTask(int achieveId) {
        TaskExample example=new TaskExample();
        TaskExample.Criteria criteria=example.createCriteria();
        criteria.andAchieveidEqualTo(achieveId);
        return taskMapper.selectByExample(example);
    }

    public Task getTaskInfo(int taskId) {
        return  taskMapper.selectByPrimaryKey(taskId);
    }

    public void update(Task task) {
        taskMapper.updateByPrimaryKey(task);
    }


    public List<Task> getUnfinishTask(int workId) {
        List<Integer> ac=taskMapper.getUnfinishTask(workId);
        List<Task> tasks=new ArrayList<>();
        for(int id:ac){
            Task task=taskMapper.selectByPrimaryKey(id);
            tasks.add(task);
        }
        return  tasks;
    }

    public void insert(Task task) {
        taskMapper.insertSelective(task);
    }
}
