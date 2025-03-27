package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
//if we want to pass this method , then pass the key which we want value from properties file.
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		//read data from properties file
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties pobj=new Properties();
		
		//load all the key
		pobj.load(fis);
		
		//getproperty method is used to connecting to properties file and read data
		String data = pobj.getProperty(key);
		
		return data;
	}
}
