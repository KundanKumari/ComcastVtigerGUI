package com.comcast.crm.generic.fileutility;

import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Throwable {
		//get the java object json physical file
		FileReader file=new FileReader("./configAppData/AppCommonData.json");
		JSONParser parser=new JSONParser();
		//parse json file into actual java object. java object is a supper class of the all the class which is available into the java.
		Object obj= parser.parse(file);
		//downcasting the jsonoject to get java object. java object is a supper class of the all the class
		JSONObject map= (JSONObject)obj;
		//convart into the hashmap
		String data=(String)map.get(key);
		return data;
		
	}
}
