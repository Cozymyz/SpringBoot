package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.mapper.PhotoMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyService {
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private PhotoMapper photoMapper;
    @Resource
    private UserMapper userMapper;

    public Company getCompanyInfo(int comId) {
        Company company= companyMapper.selectByPrimaryKey(comId);
        PhotoExample example=new PhotoExample();
        PhotoExample.Criteria criteria=example.createCriteria();
        criteria.andComIdEqualTo(comId);
        company.setPhotoList(photoMapper.selectByExample(example));
        return  company;
    }

    public List<Company> getAllCompany() {
        List<Company> companies= companyMapper.selectByExample(new CompanyExample());
        for(Company c:companies){
            PhotoExample example=new PhotoExample();
            PhotoExample.Criteria criteria=example.createCriteria();
            criteria.andComIdEqualTo(c.getId());
            c.setPhotoList(photoMapper.selectByExample(example));
        }
        return  companies;
    }

    public List<Company> searchCompany(String key) {
        CompanyExample example=new CompanyExample();
        CompanyExample.Criteria criteria=example.createCriteria();
        criteria.andCompanynameLike("%"+key+"%");
        return companyMapper.selectByExample(example);
    }

    public List<User> getUser(int comId) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andCompanyidEqualTo(comId);
        criteria.andRoleEqualTo("user");
        return userMapper.selectByExample(example);
    }

    public List<User> getHr(int comId) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andCompanyidEqualTo(comId);
        criteria.andRoleEqualTo("hr");
        return userMapper.selectByExample(example);
    }

    public void update(Company company) {
        companyMapper.updateByPrimaryKey(company);
    }

    public void insertPhoto(Photo photo1) {
        photoMapper.insertSelective(photo1);
    }

    public void insert(Company company) {
        companyMapper.insertSelective(company);
    }
}
