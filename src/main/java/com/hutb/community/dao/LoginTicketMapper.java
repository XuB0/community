package com.hutb.community.dao;

import com.hutb.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketMapper {

    /**
     *     Mapper接口实现可以通过 xxx.xml配置文件实现;
     *     也可以使用注解实现
     * */


    @Insert({
            "insert into login_ticket (user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);


    @Update({
            "update login_ticket set status=#{status} ",
            "where ticket=#{ticket}"
    })
    int updateStatus(String ticket, int status);

}
