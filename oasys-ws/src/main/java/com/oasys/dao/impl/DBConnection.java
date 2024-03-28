package com.oasys.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.oasys.bo.impl.OratalAdminImpl;


public class DBConnection {

	private static final Logger logger = Logger.getLogger(OratalAdminImpl.class);

	public static Connection getConnection() {

		Connection conn = null;
		try {

			Context initialContext = new InitialContext();
			Context environmentContext = (Context) initialContext.lookup("java:comp/env");

			ReadProperties rD = new ReadProperties();
			Properties properties = rD.readProp();
			System.out.println(properties.getProperty("OAS_POOL_NAME"));


			//DataSource dataSource = (DataSource) environmentContext.lookup("jdbc/vdev-oasys-pool");
			DataSource dataSource = (DataSource) environmentContext.lookup(properties.getProperty("OAS_POOL_NAME"));
			conn = dataSource.getConnection();

			logger.info("getConnection : " + properties.getProperty("OAS_POOL_NAME").toString() +  " isClosed() " + conn.isClosed());

			if (!conn.isClosed())
				logger.info(properties.getProperty("OAS_POOL_NAME").toString() + " : Connected");
			else
				logger.info(properties.getProperty("OAS_POOL_NAME").toString() + " : Not Connected");

		} catch (Exception ex) {

		}

		return conn;
	}

}
