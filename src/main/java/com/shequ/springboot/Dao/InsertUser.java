package com.shequ.springboot.Dao;

import com.shequ.springboot.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface InsertUser {

    @Insert("insert into user (name,user_id,token,creat_time,update_time) values (#{name},#{userid},#{token},#{creattime},#{updatetime})")
    void insertAccount(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where name = #{name}")
    String findByUserName(String name);
}
