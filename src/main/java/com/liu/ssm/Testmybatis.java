package com.liu.ssm;
 import javax.annotation.Resource;

 import com.github.pagehelper.Page;
 import com.github.pagehelper.PageHelper;
 import com.liu.ssm.model.User;
 import com.liu.ssm.model.UserExample;
 import org.apache.log4j.Logger;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 import com.alibaba.fastjson.JSON;
 import com.liu.ssm.service.UserService;
 import org.springframework.web.bind.annotation.RequestParam;

 import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class Testmybatis {
    private static Logger logger = Logger.getLogger(Testmybatis.class);
    //  private ApplicationContext ac = null;
    @Resource
    public UserService userService = null;

//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

   @Test
    public void test1() {
        User user = userService.getUserById(1);
        System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }

    @Test
    public void test2(){
        UserExample userExample = new UserExample();
        Integer currentPage = 1;
        Integer limit = 3;
        UserExample.Criteria c= userExample.createCriteria();
        PageHelper.startPage(currentPage, limit); // 核心分页代码
        List<User> user = userService.findAll(userExample);
        System.out.println(user);
        Page<User> page = (Page<User>)user;
        System.out.println(user);
    }
}