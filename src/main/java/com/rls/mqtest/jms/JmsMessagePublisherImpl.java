package com.rls.mqtest.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsMessagePublisherImpl implements MessageCreator {

	// com.ibm.mq.jms.MQQueue
    private JmsTemplate template;
    private String poslogXml;

    public JmsMessagePublisherImpl() {
    	System.out.println("Im being constructed");
    }
	/**
	 * defines the JmsTemplate to use when generating the messages on the queue
	 * @param template
	 */
	public void setTemplate(JmsTemplate template)
	{
		this.template = template;
	}
    
	@Override
	public Message createMessage(Session session) throws JMSException {
		
		TextMessage tm = session.createTextMessage(poslogXml);
		
		tm.setJMSDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);
		
		return tm;
	}

	public void publishMessage(String poslogXml) throws Exception {
		
		this.poslogXml = poslogXml;
		template.send(this);
	}
}
