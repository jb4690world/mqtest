package com.rls.mqtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePosFileDataPublisher implements Runnable {
	
	private static Logger logger = LoggerFactory.getLogger(BasePosFileDataPublisher.class);

	private String fileId;
	
	@Override
	public void run() {
		logger.info(String.format("BasePosFileDataPublisher (hashCode: %d) in run: %s", this.hashCode(), fileId));
	}

	public void setFileid(String fileId) {
		this.fileId = fileId;
		logger.info("BasePosFileDataPublisher got fileId: " + this.fileId);
	}
	
}
