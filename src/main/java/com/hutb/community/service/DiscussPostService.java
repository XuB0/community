package com.hutb.community.service;

import com.hutb.community.dao.DiscussPostMapper;
import com.hutb.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper postMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        return postMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId){
        return postMapper.selectDiscussPostRows(userId);
    }

}
