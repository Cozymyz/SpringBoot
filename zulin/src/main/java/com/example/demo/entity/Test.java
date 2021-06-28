package com.example.demo.entity;

import com.example.demo.valid.register;
import com.example.demo.valid.updateUser;
import org.hibernate.validator.constraints.Length;

public class Test {

    private int a;

    @Length(max=6, min=3, message="用户名3-6位长")
    private String b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
