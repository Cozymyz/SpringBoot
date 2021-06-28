package com.example.demo.entity;

import com.example.demo.valid.register;
import com.example.demo.valid.updateUser;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @ApiModelProperty(value = "编号")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message="用户名不为空" ,groups = {register.class , updateUser.class})
    @Length(max=6, min=3, message="用户名3-6位长",groups = {register.class , updateUser.class})
    private String username;


    @NotBlank(message="用户名不为空" ,groups = {register.class , updateUser.class})
    @Length(max=6, min=3, message="密码3-6位长",groups = {register.class , updateUser.class})
    private String password;
    @ApiModelProperty(value = "权限")
    private String role;
    @ApiModelProperty(value = "编号")
    private String permission;
    @ApiModelProperty(value = "是否禁用")
    private Integer ban;

    @ApiModelProperty(value = "手机号")
    @Length(max=11, min=11, message="手机号11位长",groups = {register.class , updateUser.class})
    private String phone;
    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮件不合法",groups = { register.class ,updateUser.class})
    private String email;

    @Size(max=1, min=0,groups = {register.class })
    private String sex;
    @ApiModelProperty(value = "生日")
    private String birthday;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "身份证")
    @Length(max=18, min=18, message="身份证18位长",groups = {register.class })
    private String identity;

    private String resume;

    private String photo;

    private Integer companyid;
    @ApiModelProperty(value = "真实姓名")
    private String realname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Integer getBan() {
        return ban;
    }

    public void setBan(Integer ban) {
        this.ban = ban;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                ", ban=" + ban +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", identity='" + identity + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}