package com.liu.ssm.pageHelper;

import java.util.List;

import javax.annotation.Resource;

import com.liu.ssm.model.User;
import com.liu.ssm.model.UserExample;
import com.liu.ssm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

public class TestPageHelper {

    @Resource
    private UserService userService;

    @Test
    public void testPageHelper() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        PageHelper.startPage(1, 10);

        UserExample user = new UserExample();
        List<User> list = userService.findAll(user);
        PageInfo pageInfo = new PageInfo(list);
        long total = pageInfo.getTotal();
        System.out.println("total:"+total);
        int pages = pageInfo.getPages();
        System.out.println("pages:"+pages);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize:"+pageSize);

    }

}
