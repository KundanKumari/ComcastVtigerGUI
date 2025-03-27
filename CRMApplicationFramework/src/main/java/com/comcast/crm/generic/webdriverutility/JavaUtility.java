package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumer(){
          Random random=new Random();
         int randomInt= random.nextInt(50000);
         return randomInt;       
}
	public String getSystemDateYYYYMMDD(){
		Date dataObj=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date= sdf.format(dataObj);
		return date;
	}
//for capture previous day pass negative integer number and for capture next day pass postive integer number
	public String getRequiriedDateYYYYMMDD(int days){	
		Date dataObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(dataObj);
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate= sdf.format(cal.getTime());
		return reqdate;
}}