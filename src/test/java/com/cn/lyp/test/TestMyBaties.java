package com.cn.lyp.test;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.lyp.pojo.User;
import com.cn.lyp.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})

public class TestMyBaties {
private static Logger logger=Logger.getLogger(TestMyBaties.class);
@Resource
private IUserService userService=null;
 
 @Before
 public void before()
 {	
	 System.out.println("-------start-----");
	// userService=new UserServiceImpl(); //会出现空指针，所以还是用@Resource去初始化
 }
 
 @Test
 public void test()
 {
	User user=userService.getUserById(1);
	logger.info(JSON.toJSONString(user));
	System.out.println(user.getUser_name());
 }
 
 @After
 public void after()
 {
	 System.out.println("-------end----------");
 }
}

