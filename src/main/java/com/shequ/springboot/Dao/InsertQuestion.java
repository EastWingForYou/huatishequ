package com.shequ.springboot.Dao;

import com.shequ.springboot.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertQuestion {

    @Insert("insert into question (title,description,creator,creat_time,update_time,comment_count,review_count,like_count,tag) values" +
            "(#{title},#{description},#{creator},#{creatTime},#{updateTime},#{commentCount},#{reviewCount},#{likeCount},#{tag})" )
    void InsertHuati(Question question);
}
