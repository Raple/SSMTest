package com.cn.lyp.RabbitMQ;

import java.io.IOException;
import java.io.Serializable;
import org.apache.commons.lang.SerializationUtils;

/*
 * 功能概要：消息生产者
 */
public class Producer extends EndPoint {

	public Producer(String endpointName) throws IOException {
		super(endpointName);	
	}
 
	public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    } 
}
