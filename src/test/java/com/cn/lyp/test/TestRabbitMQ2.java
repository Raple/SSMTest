package com.cn.lyp.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.lyp.RabbitMQ2.MessageConsumer;
import com.cn.lyp.RabbitMQ2.MessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-rabbitMQ2.xml"})

public class TestRabbitMQ2 {
	@Resource
	private MessageProducer producer=null;
	@Resource
	private MessageConsumer consumer=null;
	
	 @Before
	 public void before()
	 {	
		 System.out.println("-------start-----");	
	 }
	 
	 @Test
	 public void test()throws Exception{      
		    //MessageProducer producer=new MessageProducer();
	        Map<String,Object> msg = new HashMap<>();
	        msg.put("data","test,rabbmitmq!");	     	          
	        producer.sendMessage(msg);	        	           
	 }
	 
	 @After
	 public void after()
	 {
		 System.out.println("-------end----------");
	 }	
}
