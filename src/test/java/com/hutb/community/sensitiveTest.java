package com.hutb.community;

import com.hutb.community.util.SensitiveFilter;
import org.apache.catalina.filters.ExpiresFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class sensitiveTest {


    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitive(){
        String text = "☆赌博，吸..毒。。drug...读书真好。";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }

    @Test
    public void test(){
        int a = 0;
        int b = 0;
        b = ++a;
        System.out.println(b);
        System.out.println(a);
    }
}
