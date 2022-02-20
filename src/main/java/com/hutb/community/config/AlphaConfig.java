package com.hutb.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {

    /**
     *  装配一个第三方的bean:
     *   1.给该类加上 @Configuration 注解
     *   2.给对象加上@Bean
     * */

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
