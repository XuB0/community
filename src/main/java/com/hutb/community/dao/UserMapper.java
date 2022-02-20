package com.hutb.community.dao;

import com.hutb.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //根据id查用户
    User selectById(int id);

    //根据用户名查用户
    User selectByName(String username);

    //根据email查用户
    User selectByEmail(String email);

    //插入一个用户
    int insertUser(User user);

    //更新用户的状态  0-未激活  1-激活状态
    int updateStatus(int id,int status);

    //更新头像
    int updateHeader(int id,String headerUrl);

    //修改用户的密码
    int updatePassword(int id,String password);
}
