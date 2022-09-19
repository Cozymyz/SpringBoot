package com.example.demo.controller;

import com.example.demo.config.Constant;
import com.example.demo.entity.Company;
import com.example.demo.entity.Excel;
import com.example.demo.entity.User;
import com.example.demo.service.*;
import com.example.demo.util.ExcelUtil;
import com.example.demo.util.ExportExcelUtils;
import com.example.demo.util.Msg;
import com.example.demo.util.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.License;
import org.apache.poi.hssf.usermodel.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping({"/admin"})
public class AdminController {
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

    @ApiOperation(value = "新建公司", notes = "新建公司")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/setCompany")
    public Msg setCompany(ServletRequest request ,String companyNama,String companyAddress,
                          String companySetTime){

        Company company=new Company();
        company.setCompanyname(companyNama);
        company.setCompanyaddress(companyAddress);
        company.setCompanysettime(companySetTime);

        companyService.insert(company);
        return Msg.success().add("company",company);
    }

    @ApiOperation(value = "设置master", notes = "设置master")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/setMaster")
    public Msg setMaster(ServletRequest request ,int userId,int companyId){
        User user=userService.getUserInfo(userId);
        user.setRole("master");
        user.setCompanyid(companyId);
        userService.update(user);
        return Msg.success().add("user",user);
    }

    @ApiOperation(value = "设置用户禁用", notes = "")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/banUser")
    public Msg banUser(int userId ){
        User user=userService.getUserInfo(userId);
        user.setBan(1);
        userService.update(user);
        return Msg.success();
    }

    @ApiOperation(value = "解除用户禁用", notes = "")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/disbanUser")
    public Msg disbanUser(int userId ){
        User user=userService.getUserInfo(userId);
        user.setBan(0);
        userService.update(user);
        return Msg.success();
    }

    @ApiOperation(value = "所有用户", notes = "所有用户")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/allUser")
    public Msg alluser(int pageNumber,int pageSize,ServletRequest request ){
        List<User> users= userService.allUser();
        int allNumber=users.size();
        int allPage=allNumber%pageNumber==0?allNumber/pageNumber:allNumber/pageSize+1;
        if(pageNumber>allPage){
            pageNumber=allPage;
        }
        int no=(pageNumber-1)*pageSize;
        List<User> user=userService.getPageUser(no,pageSize);
        return Msg.success().add("users",user).add("allNumber",allNumber).add("allPage",allPage);
    }

    @ApiOperation(value = "导出用户文件", notes = "下载用户的excel")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    //@RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/getUserExcel")
    //@RequestMapping("getUserExcel")
    public Msg getUserExcel(ServletRequest request , HttpServletResponse response){
        //得到所有要导出的数据
        List<User> users =userService.allUser();
        //定义导出的excel名字
        String excelName = "用户列表";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("id","编号");
        fieldMap.put("username","用户名");
        fieldMap.put("role","权限");
        fieldMap.put("ban","是否禁用");
        fieldMap.put("phone","手机号");
        fieldMap.put("email","邮箱");
        fieldMap.put("birthday","生日");
        fieldMap.put("age","年龄");
        fieldMap.put("identity","身份证");
        fieldMap.put("realname","真实姓名");

        //导出用户相关信息
        new ExportExcelUtils().export(excelName,users,fieldMap,response);

        return  Msg.success().add("url",Constant.USER);
    }
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @ApiOperation(value = "下载导入用户模板", notes = "下载用户的excel模板")
    @PostMapping("getExcelExample")
    public Msg getExcelExample(ServletRequest request , HttpServletResponse response){
        return Msg.success().add("url", Constant.EXAMPLE);
    }
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping(value = "/uploadExcel", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "用户信息Excel导入数据", notes = "用户信息Excel导入数据", httpMethod = "POST")
    public Msg uploadExcel(MultipartFile file) throws Exception {
        ExcelUtil excelUtil=new ExcelUtil();
        List<UserDto> dtoList = excelUtil.readExcelFileToDTO(file, UserDto.class);

        for(UserDto u:dtoList){
            System.out.println(u.toString());
            User user=new User();
            user.setUsername(u.getUsername());
            user.setBirthday(u.getBirthday());
            user.setAge(u.getAge());
            user.setEmail(u.getEmail());
            user.setPhone(u.getPhone());
            user.setRole(u.getRole());
            user.setBan(u.getBan());
            user.setId(u.getId());
            user.setIdentity(u.getIdentity());
            user.setRealname(u.getRealname());
            userService.insert(user);
        }


        return Msg.success().add("info","导入成功");
    }




    @ApiOperation(value = "所有公司", notes = "所有公司")
    @RequiresRoles(logical = Logical.OR, value = { "admin"})
    @PostMapping("/allCompany")
    public Msg allCompany(ServletRequest request ){
        List<Company> Companys=companyService.getAllCompany();
        return Msg.success().add("Companies",Companys);
    }
}
