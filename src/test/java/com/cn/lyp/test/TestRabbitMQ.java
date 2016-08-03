package com.cn.lyp.test;

import java.util.HashMap;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.cn.lyp.RabbitMQ.Producer;
import com.cn.lyp.RabbitMQ.QueueConsumer;

public class TestRabbitMQ {
	private static Logger logger=Logger.getLogger(TestRabbitMQ.class);
	
	 @Before
	 public void before()
	 {	
		 System.out.println("-------start-----");		
	 }
	 
	 @Test
	 public void test()throws Exception{         
	        QueueConsumer consumer = new QueueConsumer("queueTestlyp");
	        Thread consumerThread = new Thread(consumer);
	        consumerThread.start();
	         
	        Producer producer = new Producer("queueTestlyp");
	         
	        for (int i = 0; i < 1000000; i++) {
	            HashMap message = new HashMap();
	            message.put("message number", i);
	            producer.sendMessage(message);
	            System.out.println("Message Number "+ i +" sent.");
	        }
	 }
	 
	 @After
	 public void after()
	 {
		 System.out.println("-------end----------");
	 }	
}
