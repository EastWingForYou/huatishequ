package com.shequ.springboot.dto;


import java.util.Objects;

public class User {


    private String userid;
    private String name;
    private String token;
    private Long creattime;
    private Long updatetime;

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
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", creattime=" + creattime +
                ", updatetime=" + updatetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid) &&
                Objects.equals(name, user.name) &&
                Objects.equals(token, user.token) &&
                Objects.equals(creattime, user.creattime) &&
                Objects.equals(updatetime, user.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, token, creattime, updatetime);
    }
}
