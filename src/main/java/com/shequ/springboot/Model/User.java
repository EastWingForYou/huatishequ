package com.shequ.springboot.Model;


import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private Integer id;
    private String userid;
    private String name;
    private String token;
    private Long creattime;
    private Long updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCreattime() {
        return creattime;
    }

    public void setCreattime(Long creattime) {
        this.creattime = creattime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", creattime=" + creattime +
                ", updatetime=" + updatetime +
                '}';
    }
}
