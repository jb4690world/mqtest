package com.rls.mqtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import com.rls.mqtest.jms.JmsMessagePublisherImpl;

@EnableAutoConfiguration
@Configuration
@ImportResource({"classpath:dev-jms-context.xml", "classpath:jms-context.xml"})
public class XmlConfiguration {
	
	@Autowired
    private ApplicationContext ctx;
	 
//    @Scope(value = "prototype")
//    @Bean
//    JmsMessagePublisherImpl getPuslisherService() {
//        return (JmsMessagePublisherImpl) ctx.getBean("wmqPublisher");
//    }

}