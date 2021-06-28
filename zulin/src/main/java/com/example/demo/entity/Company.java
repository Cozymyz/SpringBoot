package com.example.demo.entity;

import java.util.List;

public class Company {
    private Integer id;

    private String companyname;

    private String companyaddress;

    private String companysettime;
    private List<Photo> photoList;

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress == null ? null : companyaddress.trim();
    }

    public String getCompanysettime() {
        return companysettime;
    }

    public void setCompanysettime(String companysettime) {
        this.companysettime = companysettime == null ? null : companysettime.trim();
    }
}