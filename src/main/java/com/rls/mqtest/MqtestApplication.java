package com.rls.mqtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.rls.mqtest.jms.JmsMessagePublisherImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.rls.mqtest")
public class MqtestApplication implements CommandLineRunner{

	private static Logger logger = LoggerFactory.getLogger(MqtestApplication.class);

	@Autowired
	JmsMessagePublisherImpl thePublisher;
	
	public static void main(String[] args) {
//		SpringApplication.run(MqtestApplication.class, args);
		SpringApplication app = new SpringApplication(MqtestApplication.class);
	    app.setBannerMode(Banner.Mode.CONSOLE);
	    app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("EXECUTING : command line runner");
		  
	    thePublisher.publishMessage("Hello World");
	}			
}
