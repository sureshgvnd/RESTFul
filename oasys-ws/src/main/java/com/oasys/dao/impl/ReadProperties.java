package com.oasys.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

public Properties readProp(){

		Properties prop = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/general_conf.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return	prop;
	}
}
