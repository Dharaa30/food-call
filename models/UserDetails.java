package com.example.dharaa.foodcall.models;

/**
 * Created by Dharaa on 20-03-2018.
 */

public class UserDetails {

    String name;
    String pwd;
    String email;
    String phno;

    public UserDetails(String name, String pwd, String email, String phno) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.phno = phno;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
