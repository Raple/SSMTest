package com.cn.lyp.RabbitMQ2;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

	@Resource(name="amqpTemplate")
	private AmqpTemplate amqpTemplate;

	public void sendMessage(Object message){
	  logger.info("send message:{}",message);
	  amqpTemplate.convertAndSend("queueTestKey",message);//注意queueTestKey跟配置文件中要一致
	}
}
