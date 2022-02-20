package com.hutb.community.controller;

import com.hutb.community.entity.DiscussPost;
import com.hutb.community.entity.Page;
import com.hutb.community.entity.User;
import com.hutb.community.service.DiscussPostService;
import com.hutb.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService postService;

    @Autowired
    private UserService userService;


    @RequestMapping(path = "/index", method = RequestMethod.GET)
    //方法调用前,SpringMVC会自动实例化Model和Page,并将page对象注入model中,所以可以直接在thymeleaf中直接访问page中的数据
    //当页面的请求为  /index?current=15 时,  Spring会自动将Page中的current属性赋值为15
    public String getIndexPage(Model model, Page page) {

        page.setRows(postService.findDiscussPostRows(0));
        page.setPath("/index");
        System.out.println(page.getCurrent());

        List<DiscussPost> list = postService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserByID(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }

}
