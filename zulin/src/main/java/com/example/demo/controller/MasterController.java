package com.example.demo.controller;

import com.example.demo.config.Constant;
import com.example.demo.entity.*;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.*;
import com.example.demo.util.GetTimeNow;
import com.example.demo.util.JWTUtil;
import com.example.demo.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/master"})
public class MasterController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkService workService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EventService eventService;
    @Autowired
    private SigninService signinService;
    @Autowired
    private AchieveService achieveService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ApplyService applyService;

    public  int getIdbyToken(ServletRequest request){
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        System.out.println("token"+token);
        String name= JWTUtil.getUsername(token);
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> users=userMapper.selectByExample(example);
        System.out.println("user:"+users.get(0).toString());
        int userId = users.get(0).getId();
        System.out.println("id:"+userId);
        return  userId;
    }

    @ApiOperation(value = "获取hr离职申请列表", notes = "申请离职  0-未处理 1-同意 2-拒绝")
    @PostMapping("/dimissionList")
    public Msg dimissionList(ServletRequest request){
        int userId=this.getIdbyToken(request);
        User user=userService.getUserInfo(userId);
        int comId=user.getCompanyid();
        if(!(comId>0))
            Msg.fail().add("info","当前不在公司任职");
        List<Apply> applies=applyService.getCompanyApply(comId,3);
        for(Apply apply:applies){
            apply.setUser(userService.getUserInfo(apply.getUserid()));
        }
        return Msg.success().add("applies",applies);
    }


    @ApiOperation(value = "获取hr求职申请列表", notes = "申请求职  0-未处理 1-同意 2-拒绝")
    @PostMapping("/jobList")
    public Msg jobList(ServletRequest request){
        int userId=this.getIdbyToken(request);
        User user=userService.getUserInfo(userId);
        int comId=user.getCompanyid();
        if(!(comId>0))
            Msg.fail().add("info","当前不在公司任职");
        List<Apply> applies=applyService.getCompanyApply(comId,4);
        for(Apply apply:applies){
            apply.setUser(userService.getUserInfo(apply.getUserid()));
        }
        return Msg.success().add("applies",applies);
    }

    @ApiOperation(value = "处理离职", notes = "处理hr离职 isAccept 1-同意 2-拒绝")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/demission")
    public Msg demission(ServletRequest request ,int applyId,int isAccept){
        int userId=this.getIdbyToken(request);
        Apply apply=applyService.getApply(applyId);
        apply.setIsaccept(isAccept);
        apply.setAcceptor(userId);
        applyService.update(apply);
        if(isAccept==1){
            User user=userService.getUserInfo(apply.getUserid());
            user.setCompanyid(null);
            userService.update(user);

            Work work=workService.getUserNewWork(apply.getUserid());

            work.setIsend(1);
            work.setHrid(userId);
            int y= GetTimeNow.getYear();
            int m=GetTimeNow.getMonth();
            int d=GetTimeNow.getDay();
            String today=y+"-"+m+"-"+d;
            work.setEndtime(today);
            workService.update(work);

            return  Msg.success().add("apply",apply).add("work",work);
        }

        return  Msg.success().add("apply",apply);
    }

    @ApiOperation(value = "处理求职", notes = "处理hr求职 isAccept 1-同意 2-拒绝")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/job")
    public Msg job(ServletRequest request ,int applyId,int isAccept){
        int userId=this.getIdbyToken(request);
        Apply apply=applyService.getApply(applyId);
        apply.setIsaccept(isAccept);
        apply.setAcceptor(userId);
        applyService.update(apply);
        if(isAccept==1){
            User user=userService.getUserInfo(apply.getUserid());
            user.setCompanyid(apply.getCompanyid());
            userService.update(user);

            Work work=new Work();
            work.setUseid(apply.getUserid());
            work.setCompanyid(apply.getCompanyid());
            work.setIsend(0);
            work.setHrid(userId);
            int y= GetTimeNow.getYear();
            int m=GetTimeNow.getMonth();
            int d=GetTimeNow.getDay();
            String today=y+"-"+m+"-"+d;
            work.setStarttime(today);

            workService.insert(work);
            return  Msg.success().add("apply",apply).add("work",work);
        }

        return  Msg.success().add("apply",apply);
    }

    @ApiOperation(value = "发布绩效", notes = "")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/setAchieve")
    public Msg setAchieve(ServletRequest request , int userId,String info,String startTime,String endTime){
        Work work=workService.getUserNewWork(userId);
        Achieve achieve=new Achieve();
        achieve.setInfo(info);
        achieve.setStarttime(startTime);
        achieve.setEndtime(endTime);
        achieve.setWorkid(work.getWorkid());
        achieveService.insert(achieve);
        return Msg.success().add("achieve",achieve);
    }

    @ApiOperation(value = "发布任务", notes = "")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/setTask")
    public Msg setTask(ServletRequest request ,int achieveId,String info,String deadLine){
        Task task=new Task();
        task.setDeadline(deadLine);
        task.setAchieveid(achieveId);
        task.setInfo(info);
        taskService.insert(task);
        return Msg.success().add("task",task);
    }

    @ApiOperation(value = "评分任务", notes = "对某一个任务打分")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/scoreTask")
    public Msg scoreTask(ServletRequest request , int taskId,int score){
        Task task=taskService.getTaskInfo(taskId);
        task.setScore(score);
        taskService.update(task);

        return Msg.success().add("task",task);
    }

    @ApiOperation(value = "评价绩效", notes = "对某个绩效评价")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/estimateAchieve")
    public Msg estimateAchieve(ServletRequest request , int achieveId,int score,String estimate){
        Achieve achieve=achieveService.getAchieve(achieveId);
        achieve.setEstimate(estimate);
        achieve.setScore(score);
        achieveService.update(achieve);
        return Msg.success().add("achieve",achieve);
    }


    @ApiOperation(value = "设置hr", notes = "设置用户未hr")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/setHr")
    public Msg setHr(ServletRequest request ,int userId){
        User user=userService.getUserInfo(userId);
        user.setRole("hr");
        userService.update(user);
        return Msg.success().add("user",user);
    }

    @ApiOperation(value = "修改公司信息", notes = "修改公司信息")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/setCompany")
    public Msg setCompany(ServletRequest request ,String companyNama,String companyAddress,
                          String companySetTime){
        int userId=this.getIdbyToken(request);
        User user=userService.getUserInfo(userId);
        int comId=user.getCompanyid();
        Company company=companyService.getCompanyInfo(comId);
        company.setCompanyname(companyNama);
        company.setCompanyaddress(companyAddress);
        company.setCompanysettime(companySetTime);

        companyService.update(company);
        return Msg.success().add("company",company);
    }

    @ApiOperation(value = "上传公司图片", notes = "上传公司图片")
    @RequiresRoles(logical = Logical.OR, value = { "master"})
    @PostMapping("/uploadCompanyPhoto")
    public Msg uploadCompanyPhoto(ServletRequest request , MultipartFile[] photo){
        int userId=this.getIdbyToken(request);
        User user=userService.getUserInfo(userId);
        int comId=user.getCompanyid();
        Company company=companyService.getCompanyInfo(comId);

        for(MultipartFile file:photo){
            if (file.isEmpty()) {
                return Msg.fail().add("info","空文件，请重新上传");
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                String s = UUID.randomUUID().toString();
                System.out.println(file.getContentType());
                Path path = Paths.get( Constant.IMG_UPLOAD_DIC + s+UserController.getFileType(file.getOriginalFilename()));
                Files.write(path, bytes);
                //  User user=userService.getUserInfo(userId);
                //user.setPhoto(Constant.IMG_UPLOAD_DIC + s+getFileType(file.getOriginalFilename()));
                //userService.update(user);
                Photo photo1=new Photo();
                photo1.setComId(comId);
                photo1.setUrl(Constant.IMG_MYSQL_DIC + s+UserController.getFileType(file.getOriginalFilename()));
                companyService.insertPhoto(photo1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        company=companyService.getCompanyInfo(comId);
        return Msg.success().add("company",company).add("info","上传成功");
    }
}
