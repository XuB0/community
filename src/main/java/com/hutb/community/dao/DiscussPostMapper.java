package com.hutb.community.dao;

import com.hutb.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //1.当userId不等于0时，可以按userId获取帖子
    //2. mysql数据库实现分页时，只需提供起始行号和每页显示的条数。
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);


    //@Param()注解用于给参数去别名
    //如果只有一个参数，且需要在sql中动态拼接，则必须加别名。
    int selectDiscussPostRows(@Param("userId") int userId);


}
