package com.example.demo.config;


import com.example.demo.entity.Signin;
import com.example.demo.entity.User;
import com.example.demo.entity.Work;
import com.example.demo.service.SigninService;
import com.example.demo.service.UserService;
import com.example.demo.service.WorkService;
import com.example.demo.util.GetTimeNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
public class Schedule {

    @Autowired
    private UserService userService;
    @Autowired
    private WorkService workService;
    @Autowired
    private SigninService signinService;

    @Scheduled(cron = "0 0 1 ? * MON-FRI")
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        List<User> users=userService.allUser();
        for(User u:users){
            Work work=workService.getUserNewWork(u.getId());
            if(!(work.getIsend()==1)){
                Signin signin=new Signin();
                signin.setUser(u);
                signin.setAttend(0);
                signin.setWorkid(work.getWorkid());
                int y= GetTimeNow.getYear();
                int m=GetTimeNow.getMonth();
                int d=GetTimeNow.getDay();
                signin.setDaytime(y+"-"+m+"-"+d);
                signinService.insert(signin);
            }
        }
    }
}