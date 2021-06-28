package com.example.demo.controller;



import com.example.demo.config.Constant;
import com.example.demo.config.VerificationCode;
import com.example.demo.entity.*;
import com.example.demo.mapper.AchieveMapper;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.WorkMapper;
import com.example.demo.service.*;
import com.example.demo.valid.register;
import com.example.demo.valid.updateUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.demo.util.JWTUtil;
import com.example.demo.util.Msg;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@Api(value = "测试Controller")
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    private  UserMapper usermapper;
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

/*
    @ApiOperation(value = "无权限", notes = "无权限跳转的接口")
    @RequestMapping(path = "/unauthorized/{message}")
    public Msg unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return Msg.fail().add("info", message);
    }

    @ApiOperation(value = "特定用户访问", notes = "拥有 user, admin 角色的用户可以访问下面的页面")
    @PostMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public Msg getMessage() {
        return Msg.success().add("info", "成功获得信息！");
    }

    @ApiOperation(value = "Vip用户访问", notes = "拥有 vip 权限可以访问该页面")
    @PostMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public Msg getVipMessage() {
        return Msg.success().add("info", "成功获得 vip 信息！");
    }

    @PostMapping("/test")
    public Msg test() {
        return Msg.success().add("info", "hello");
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file
                                   ) {
        if (file.isEmpty()) {
             return "empty file";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get( Constant.FILE_UPLOAD_DIC+ file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload";
    }

    @RequestMapping("/download")
    public Msg  testDownload(HttpServletResponse response , Model model,String fileName) {

      //  response.setHeader("content-type", "image/png");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\10847\\Desktop\\" + fileName )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            //出现异常返回给页面失败的信息
            model.addAttribute("result","下载失败");
            return Msg.success().add("info", "下载失败");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //成功后返回成功信息
        model.addAttribute("result","下载成功");
        return Msg.success().add("info", "下载成功");
    }

*/

    public  int getIdbyToken(ServletRequest request){
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        System.out.println("token"+token);
        String name=JWTUtil.getUsername(token);
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> users=usermapper.selectByExample(example);
        System.out.println("user:"+users.get(0).toString());
        int userId = users.get(0).getId();
        System.out.println("id:"+userId);
        return  userId;
    }

    public  int getIdbyToken(String  token){
        System.out.println("token"+token);
        String name=JWTUtil.getUsername(token);
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> users=usermapper.selectByExample(example);
        System.out.println("user:"+users.get(0).toString());
        int userId = users.get(0).getId();
        System.out.println("id:"+userId);
        return  userId;
    }

    public static String getFileType(String originalFilename) {
        //获取文件的原始名称
        //获取文件的后缀名 .jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("suffix = " + suffix);
        return  suffix;
    }

    @ApiOperation(value = "用户登录", notes = "登录--不进行拦截")
    @PostMapping("/login")
    public Msg login(@RequestParam("username") String username,
                     @RequestParam("password") String password,
                     String code,HttpSession session) {
        try {
            //从session中获取随机数
            String random = (String) session.getAttribute("verify_code");
            if (random == null) {
                return Msg.fail().add("code",random).add("info","1").add("id",session.getId()).add("input",code);
            }
            if (random.equals(code)) {
                System.out.println("正确的验证码");

            } else {
                System.out.println("错误的验证码");
                return Msg.fail().add("code",random).add("info","2").add("id",session.getId()).add("input",code);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail().add("code",code).add("info","3").add("id",session.getId()).add("input",code);
        }

        String realPassword = userService.getPassword(username);
        System.out.println("r:"+realPassword);
        System.out.println("name:"+username);
        if(realPassword==null){
            realPassword = userService.getPasswordByphone(username);
            System.out.println("r2:"+realPassword);
            if(realPassword==null)
                realPassword = userService.getPasswordByemail(username);
        }

        if (realPassword == null) {
            return Msg.fail().add("info", "用户名错误");
        } else if (!realPassword.equals(password)) {
            return Msg.fail().add("info", "密码错误");
        } else {
            String token=JWTUtil.createToken(username);
            User user=userService.getUserInfo(getIdbyToken(token));
            return Msg.success().add("token", token).add("user",user);
        }
    }

    @ApiOperation(value = "注册", notes = "用户注册")
    @PostMapping("/register")
        public Msg register(@Validated(register.class)  User user){
        user.setBan(0);
        String identity=user.getIdentity();
        user.setRole("user");
        user.setPermission("normal");
        int y=Integer.parseInt(identity.substring(6,10));
        int m=Integer.parseInt(identity.substring(10,12));
        int d=Integer.parseInt(identity.substring(12,14));
        user.setAge(2021-y);
        user.setBirthday(y+"-"+m+"-"+d);
        userService.insert(user);

        return Msg.success().add("user",user);
    }


    @GetMapping("/verifyCode")
    public  Msg  verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        System.out.println("text:"+text);
        System.out.println(session.getAttribute("verify_code"));
        VerificationCode.output(image,resp.getOutputStream());
        return Msg.success().add("id",session.getId());
    }

    @RequestMapping(value = "/checkVerify")
    public Msg checkVerify(String code, HttpSession session) {
        try {
            //从session中获取随机数
            String random = (String) session.getAttribute("verify_code");
            if (random == null) {
                return Msg.fail().add("code",random).add("info","1").add("id",session.getId()).add("input",code);
            }
            if (random.equals(code)) {
                System.out.println("正确的验证码");
                return Msg.success();
            } else {
                System.out.println("错误的验证码");
                return Msg.fail().add("code",random).add("info","2").add("id",session.getId()).add("input",code);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail().add("code",code).add("info","3").add("id",session.getId()).add("input",code);
        }
    }

    @PostMapping("/test")
    public Msg test(@Validated Test test){
        System.out.println("A"+test.getA());
        System.out.println("B"+test.getB());
        return Msg.success();
    }

    @ApiOperation(value = "更新个人信息", notes = "用户更新信息")
    @PostMapping("/update")
    public Msg update(ServletRequest request,@Validated(updateUser.class) User u){
        int userId=getIdbyToken(request);
        User user=userService.getUserInfo(userId);
        user.setBan(0);
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setPhone(u.getPhone());
        user.setEmail(u.getEmail());
        userService.update(user);
        return Msg.success().add("user",user);
    }

    @ApiOperation(value = "获取用户信息 ", notes = "获取用户信息 所有人可访问")
    @PostMapping("/getUserInfo")
    public Msg getUserInfo(ServletRequest request ) {
        int id=getIdbyToken(request);
        User user=userService.getUserInfo(id);
        return Msg.success().add("user",user);
    }

    @ApiOperation(value = "查看公司列表", notes = "获取所有公司")
    @PostMapping("/getAllCompany")
    public Msg getCompany(ServletRequest request ){
        List<Company> companies=companyService.getAllCompany();
        return Msg.success().add("companies",companies);
    }

    @ApiOperation(value = "查看公司详情", notes = "获取所有公司")
    @PostMapping("/getCompanyInfo")
    public Msg getCompanyInfo(ServletRequest request ,int companyId){
        Company company=companyService.getCompanyInfo(companyId);
        return Msg.success().add("company",company);
    }

    @ApiOperation(value = "搜索公司", notes = "公司列表搜索")
    @PostMapping("/searchCompany")
    public Msg searchCompany(ServletRequest request,String key){
        List<Company> companies=companyService.searchCompany(key);
        return Msg.success().add("user","user");
    }

    @ApiOperation(value = "判断手机号合法", notes = "修改前判断 是否合法")
    @PostMapping("/checkPhone")
    public Msg checkTel(ServletRequest request ,String phone){
        if(phone.length()!=11)
            return Msg.fail().add("info","不符合规范");
        List<User> users=userService.searchPhone(phone);
        if(users.size()>0)
            return Msg.fail().add("info","已经存在");
        else
            return Msg.success().add("info","可以使用");
    }

    @ApiOperation(value = "判断邮箱合法", notes = "修改前判断 是否合法")
    @PostMapping("/checkEmail")
    public Msg checkEmail(ServletRequest request ,String email){
        if(!email.contains("@"))
            return Msg.fail().add("info","不符合规范");
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> users=userService.searchEmail(email);
        if(users.size()>0)
            return Msg.fail().add("info","已经存在");
        else
            return Msg.success().add("info","可以使用");
    }

    @ApiOperation(value = "判断身份证合法", notes = "修改前判断 是否合法")
    @PostMapping("/checkIdentity")
    public Msg checkIdentity(ServletRequest request ,String identity){
        if(identity.length()!=18)
            return Msg.fail().add("info","不符合规范");
        List<User> users=userService.searchIdentity(identity);
        if(users.size()>0)
            return Msg.fail().add("info","已经存在");
        else
            return Msg.success().add("info","可以使用");
    }

    @ApiOperation(value = "判断用户名合法", notes = "修改前判断 是否合法")
    @PostMapping("/checkUserName")
    public Msg checkUserName(ServletRequest request ,String userName){
        List<User> users=userService.searchUserName(userName);
        if(users.size()>0)
            return Msg.fail().add("info","已经存在");
        else
            return Msg.success().add("info","可以使用");
    }


    @ApiOperation(value = "下载自己简历", notes = "下载自己简历 所有人可访问")
    @PostMapping("/downloadSelfResume")
    public Msg downloadSelfResume(ServletRequest request,HttpServletResponse response , Model model) {
        int userId=getIdbyToken(request);
        User user=userService.getUserInfo(userId);
        String fileName=user.getResume();
        if(fileName==null)
            return Msg.fail().add("info", "无简历");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File( Constant.STATIC+fileName )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            //出现异常返回给页面失败的信息
            model.addAttribute("result","下载失败");
            return Msg.fail().add("info", "下载失败");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //成功后返回成功信息
        model.addAttribute("result","下载成功");
        return Msg.success().add("info", "下载成功");

    }

    @ApiOperation(value = "上传自己简历", notes = "上传用户简历 所有人可使用")
    @PostMapping("/uploadUserResume")
    public Msg uploadUserResume(ServletRequest request , MultipartFile file){
        int userId=getIdbyToken(request);

        if (file.isEmpty()) {
            return Msg.fail().add("info","空文件，请重新上传");
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String s = UUID.randomUUID().toString();
            System.out.println(file.getContentType());
            Path path = Paths.get( Constant.FILE_UPLOAD_DIC + s+getFileType(file.getOriginalFilename()));
            Files.write(path, bytes);
            User user=userService.getUserInfo(userId);
            user.setResume(Constant.FILE_MYSQL_DIC + s+getFileType(file.getOriginalFilename()));
            userService.update(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Msg.success().add("info","上传成功");
    }

    @ApiOperation(value = "上传自己照片", notes = "上传用户照片 所有人可使用")
    @PostMapping("/uploadUserPhoto")
    public Msg uploadUserPhoto(ServletRequest request , MultipartFile file){
        int userId=getIdbyToken(request);

        if (file.isEmpty()) {
            return Msg.fail().add("info","空文件，请重新上传");
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String s = UUID.randomUUID().toString();
            System.out.println(file.getContentType());
            Path path = Paths.get( Constant.IMG_UPLOAD_DIC + s+getFileType(file.getOriginalFilename()));
            Files.write(path, bytes);
            User user=userService.getUserInfo(userId);
            user.setPhoto(Constant.IMG_MYSQL_DIC + s+getFileType(file.getOriginalFilename()));
            userService.update(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Msg.success().add("info","上传成功");
    }

    @ApiOperation(value = "获取个人职业经历", notes = "获取个人职业经历 所有人可用  无主观评价")
    @PostMapping("/getSelfWork")
    public Msg getSelfWork(ServletRequest request ){
        int userId=getIdbyToken(request);
        List<Work> works=userService.getSelfWork(userId);
        User user=userService.getUserInfo(userId);
        for(Work w:works ){

            w.setEvaluation(null);
            int comId=w.getCompanyid();
            Company company=companyService.getCompanyInfo(comId);
            w.setCompanyName(company.getCompanyname());
            User hr=userService.getUserInfo(w.getHrid());
            w.setHrName(hr.getUsername());
        }
        return Msg.success().add("works",works);
    }


    @ApiOperation(value = "获取重大事件", notes = "获取某一段职业中重大事件 ")
    @PostMapping("/getWorkEvent")
    public Msg getUserWorkEvent(ServletRequest request ,int workId){
        int userId=getIdbyToken(request);
        Work work=workService.getWorkInfo(workId);
        if(userId!=work.getUseid())
            Msg.fail().add("info","没有权限访问他人履历");
        List<Event> events=eventService.getWorkEvent(workId);
        return Msg.success().add("events",events);
    }

    @ApiOperation(value = "获取自己某一个时期的考勤", notes = "获取某一个时期的考勤 attend为0为未签到")
    @PostMapping("/workSignIn")
    public Msg workSignin(ServletRequest request,int workId){
        int userId=getIdbyToken(request);
        Work work=workService.getWorkInfo(workId);
        if(userId!=work.getUseid())
            Msg.fail().add("info","无权限访问他人考勤");
        List<Signin> signins=signinService.getWorkSignIn(workId);
        return Msg.success().add("signins",signins);
    }

    @ApiOperation(value = "获取自己总体考勤", notes = "获取用户总体考勤情况 attend为0为未签到")
    @PostMapping("/UserSignIn")
    public Msg UsersignIn(ServletRequest request){
        int userId=getIdbyToken(request);
        List<Signin> signins=signinService.getUserSignIn(userId);
        return Msg.success().add("signins",signins).add("allNum",signins.size()).add("attend",signinService.getAttend(userId));
    }

    @ApiOperation(value = "获取绩效", notes = "获取某一段职业中绩效考核")
    @PostMapping("/getWorkAchieve")
    public Msg getUserWorkAchieve(ServletRequest request ,int workId){
        int userId=getIdbyToken(request);
        Work work=workService.getWorkInfo(workId);
        if(userId!=work.getUseid())
            Msg.fail().add("info","没有权限访问他人绩效");
        List<Achieve> achieves=achieveService.getWorkAchieve(workId);
        for(Achieve a:achieves){
            a.setTaskList(taskService.getAchieveTask(a.getAchieveid()));
            a.setEstimate(null);
        }

        return Msg.success().add("achieves",achieves);
    }

    @ApiOperation(value = "申请离职", notes = "申请离职")
    @PostMapping("/applyDimission")
    public Msg applyDimission(ServletRequest request,String submitTime,int companyId,String info){
        int userId=getIdbyToken(request);
        Apply apply=new Apply();
        User user=userService.getUserInfo(userId);
        if(user.getRole().equals("user"))
            apply.setApplytype(1);
        else
            apply.setApplytype(3);
        apply.setIsaccept(0);
        apply.setCompanyid(companyId);
        apply.setInfo(info);
        apply.setSubtime(submitTime);
        apply.setUserid(userId);
        applyService.insert(apply);
        return Msg.success().add("apply",apply);
    }

    @ApiOperation(value = "申请求职", notes = "申请求职")
    @PostMapping("/applyJob")
    public Msg applyJob(ServletRequest request,String submitTime,int companyId,String info){
        int userId=getIdbyToken(request);
        Apply apply=new Apply();
        User user=userService.getUserInfo(userId);
        if(user.getRole().equals("hr"))
            apply.setApplytype(2);
        else
            apply.setApplytype(4);
        apply.setIsaccept(0);
        apply.setCompanyid(companyId);
        apply.setInfo(info);
        apply.setSubtime(submitTime);
        apply.setUserid(userId);
        applyService.insert(apply);
        return Msg.success().add("apply",apply);
    }

    @ApiOperation(value = "获取离职申请列表", notes = "申请离职  0-未处理 1-同意 2-拒绝")
    @PostMapping("/dimissionList")
    public Msg dimissionList(ServletRequest request){
        int userId=getIdbyToken(request);
        List<Apply> applies=applyService.getUserApply(userId,1);
        return Msg.success().add("applies",applies);
    }

    @ApiOperation(value = "获取求职申请列表", notes = "申请求职  0-未处理 1-同意 2-拒绝")
    @PostMapping("/jobList")
    public Msg jobList(ServletRequest request){
        int userId=getIdbyToken(request);
        List<Apply> applies=applyService.getUserApply(userId,2);
        return Msg.success().add("applies",applies);
    }

    @ApiOperation(value = "确认提交任务", notes = "提交任务确认")
    @PostMapping("/subTask")
    public Msg subTask(ServletRequest request,int taskId,String submitTime){
        Task task=taskService.getTaskInfo(taskId);
        task.setSubline(submitTime);
        taskService.update(task);
        return Msg.success().add("task",task);
    }

    @ApiOperation(value = "查看任务", notes = "查看所有未完成任务")
    @PostMapping("/getTask")
    public Msg getTask(ServletRequest request){
        int userId=getIdbyToken(request);
        Work work=workService.getUserNewWork(userId);
        List<Task> tasks=taskService.getUnfinishTask(work.getWorkid());
        return Msg.success().add("tasks",tasks);
    }

    @ApiOperation(value = "判断是否签到", notes = "判断是否当天签到了")
    @PostMapping("/checkSignIn")
    public Msg checkSignIn(ServletRequest request){
        int userId=getIdbyToken(request);
        Work work=workService.getUserNewWork(userId);
        Signin signin=signinService.findTodaySignIn(work.getWorkid());
        if(signin==null)
            return  Msg.fail().add("info","今日不用签到").add("status",2);
        else if(signin.getAttend()!=0)
            return Msg.fail().add("info","已经签到").add("status",1);
        return Msg.success().add("info","今日未签到").add("status",0);
    }

    @ApiOperation(value = "签到", notes = "当天签到")
    @PostMapping("/signIn")
    public Msg signIn(ServletRequest request){
        int userId=getIdbyToken(request);
        Work work=workService.getUserNewWork(userId);
        System.out.println(work.getWorkid());
        Signin signin=signinService.findTodaySignIn(work.getWorkid());
        System.out.println(signin.getAttend()+"/"+signin.getSigninid());
        if(signin==null)
            return  Msg.fail().add("info","今日不用签到");
        else if(signin.getAttend()!=0)
            return Msg.fail().add("info","已经签到");
        signin.setAttend(1);
        signinService.update(signin);
        return Msg.success().add("signin",signin);
    }
}