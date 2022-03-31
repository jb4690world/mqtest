package com.rls.mqtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePosFileDataPublisher implements Runnable {
	
	private static Logger logger = LoggerFactory.getLogger(BasePosFileDataPublisher.class);

	private String fileId;
	
	@Override
	public void run() {
		logger.info(String.format("BasePosFileDataPublisher (hashCode: %d) in run: %s", this.hashCode(), fileId));
		
		java.sql.Statement stmt = null;
		Connection con=null;
		
		try {
			con = DriverManager.getConnection("jdbc:h2:localhost");
		}
		catch ( Exception e ) {
			logger.error("Error", e);
		}
		finally {
			if( stmt != null ) {
				try {
					stmt.close();
				     con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	public void setFileid(String fileId) {
		this.fileId = fileId;
		logger.info("BasePosFileDataPublisher got fileId: " + this.fileId);
	}
	
}
