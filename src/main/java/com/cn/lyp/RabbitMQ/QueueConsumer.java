package com.cn.lyp.RabbitMQ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.SerializationUtils;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/*
 * 消息消费者
 * 功能概要：读取队列的程序端，实现了Runnable接口
 */
public class QueueConsumer extends EndPoint implements Runnable,Consumer {

	public QueueConsumer(String endpointName) throws IOException {
		super(endpointName);	
	}

	@Override
	public void handleCancel(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCancelOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleConsumeOk(String arg0) {		
		System.out.println("Consumer "+arg0 +" registered");   
	}

	@Override
	public void handleDelivery(String arg0, Envelope arg1,
			BasicProperties arg2, byte[] arg3) throws IOException {
		 Map map = (HashMap)SerializationUtils.deserialize(arg3);
	        System.out.println("Message Number "+ map.get("message number") + " received.");
	}

	@Override
	public void handleRecoverOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
