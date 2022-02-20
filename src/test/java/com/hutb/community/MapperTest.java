package com.hutb.community;


import com.hutb.community.dao.DiscussPostMapper;
import com.hutb.community.dao.UserMapper;
import com.hutb.community.entity.DiscussPost;
import com.hutb.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper postMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("124r3fkljgl");
        user.setSalt("abc");
        user.setEmail("test@163.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        System.out.println(userMapper.insertUser(user));
    }
    @Test
    public void updateUserStatus(){
        int flag = userMapper.updateStatus(150,1);
        User user = userMapper.selectById(150);
        System.out.println(flag);
        System.out.println(user);

    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> posts = postMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post: posts){
            System.out.println(post);
        }

        int rows = postMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }


}
