package com.example.demo.entity;

public class Apply {
    private Integer applyid;

    private Integer userid;

    private Integer companyid;

    private String subtime;

    private String info;

    private Integer acceptor;

    private Integer isaccept;

    private Integer applytype;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getSubtime() {
        return subtime;
    }

    public void setSubtime(String subtime) {
        this.subtime = subtime == null ? null : subtime.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(Integer acceptor) {
        this.acceptor = acceptor;
    }

    public Integer getIsaccept() {
        return isaccept;
    }

    public void setIsaccept(Integer isaccept) {
        this.isaccept = isaccept;
    }

    public Integer getApplytype() {
        return applytype;
    }

    public void setApplytype(Integer applytype) {
        this.applytype = applytype;
    }
}